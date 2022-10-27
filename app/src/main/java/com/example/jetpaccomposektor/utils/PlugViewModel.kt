package com.example.jetpaccomposektor.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.lifecycle.ViewModel

// Clase que permite la composicion local para instanciar view model ya que hiltViewModel() debe estar en composición
/*
@Suppress("PropertyName")
class PlugViewModel<T : ViewModel>(val composableInVM: @Composable ()->Unit = {}) {
    private lateinit var _viewModel: T
    val viewModel by lazy { _viewModel }

    @Composable
    fun PlugViewModelComposition(hiltViewModel: T) {
        _viewModel = hiltViewModel
    }

}

@Composable
inline fun <reified T : ViewModel> ProviderComposition(
    activeStoreState: ProvidableCompositionLocal<PlugViewModel<T>>,
    crossinline composable: @Composable () -> Unit
) {
    with(PlugViewModel<T>()) {
        CompositionLocalProvider(activeStoreState provides this) {
            PlugViewModelComposition(hiltViewModel())
            composable()
        }
    }
}

 */
