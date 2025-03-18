import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewModelScope
import com.example.sgprepartidor.Home.Client.presentation.HomeClientViewModel
import com.example.sgprepartidor.Home.Client.presentation.components.SupplierCard
import com.example.sgprepartidor.layouts.Container
import kotlinx.coroutines.launch

@Composable
fun HomeContent(homeClientViewModel: HomeClientViewModel) {

    val suppliers by homeClientViewModel.suppliers.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        homeClientViewModel.viewModelScope.launch {
            homeClientViewModel.getAllSuppliers()
        }
    }

    Container(
        headerTitle = "Elige un proveedor"
    ) {
        LazyColumn {
            items(suppliers) {
                    supplier -> SupplierCard( supplier, homeClientViewModel::onSelectSupplier)
            }
        }
    }
}

