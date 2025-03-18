package com.example.map

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.mapbox.mapboxsdk.camera.CameraPosition
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.*
import com.mapbox.mapboxsdk.style.layers.*
import com.mapbox.mapboxsdk.style.layers.PropertyFactory.circleColor
import com.mapbox.mapboxsdk.style.layers.PropertyFactory.circleRadius
import com.mapbox.mapboxsdk.style.layers.PropertyFactory.circleStrokeColor
import com.mapbox.mapboxsdk.style.layers.PropertyFactory.circleStrokeWidth
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource
import kotlinx.coroutines.flow.collectLatest

@Composable
fun LiveLocationMap(webSocketLocationManager: WebSocketLocationManager) {
    val context = LocalContext.current
    var mapView by remember { mutableStateOf<MapView?>(null) }
    var mapboxMap by remember { mutableStateOf<MapboxMap?>(null) }
    var currentLocation by remember { mutableStateOf<LatLng?>(null) }

    LaunchedEffect(Unit) {
        webSocketLocationManager.connectWebSocket()
        webSocketLocationManager.locationFlow.collectLatest { newLocation ->
            newLocation?.let {
                currentLocation = LatLng(it.first, it.second)
            }
        }
    }

    AndroidView(
        factory = { ctx ->
            val mapViewInstance = MapView(ctx)
            mapViewInstance.getMapAsync { map ->
                mapboxMap = map
                map.setStyle(Style.Builder().fromUri("https://demotiles.maplibre.org/style.json")) { style ->
                    currentLocation?.let { addMarker(style, it) }
                }
            }
            mapView = mapViewInstance
            mapViewInstance
        },
        modifier = Modifier.fillMaxSize()
    )

    currentLocation?.let {
        mapboxMap?.moveCamera(
            CameraUpdateFactory.newCameraPosition(
                CameraPosition.Builder()
                    .target(it)
                    .zoom(15.0)
                    .build()
            )
        )
    }
}

private fun addMarker(style: Style, position: LatLng) {
    val sourceId = "driver-location"
    val layerId = "driver-marker"


    val source = style.getSourceAs<GeoJsonSource>(sourceId)
    if (source == null) {

        val newSource = GeoJsonSource(sourceId, """
            {
                "type": "Feature",
                "geometry": {
                    "type": "Point",
                    "coordinates": [${position.longitude}, ${position.latitude}]
                }
            }
        """.trimIndent())
        style.addSource(newSource)

        val layer = CircleLayer(layerId, sourceId)
            .withProperties(
                circleColor("#FF0000"),
                circleRadius(8f),
                circleStrokeWidth(2f),
                circleStrokeColor("#FFFFFF")
            )
        style.addLayer(layer)
    } else {
        source.setGeoJson("""
            {
                "type": "Feature",
                "geometry": {
                    "type": "Point",
                    "coordinates": [${position.longitude}, ${position.latitude}]
                }
            }
        """.trimIndent())
    }
}

