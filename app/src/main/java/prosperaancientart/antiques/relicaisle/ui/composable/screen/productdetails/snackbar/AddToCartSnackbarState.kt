package prosperaancientart.antiques.relicaisle.ui.composable.screen.productdetails.snackbar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val VisibleDurationMillis = 2500L

@Stable
class AddToCartSnackbarState internal constructor(private val scope: CoroutineScope) {

    var isVisible by mutableStateOf(false)
        private set

    private var hideJob: Job? = null

    fun show() {
        hideJob?.cancel()
        hideJob = scope.launch {
            isVisible = true
            delay(VisibleDurationMillis)
            isVisible = false
        }
    }
}

@Composable
fun rememberAddToCartSnackbarState(): AddToCartSnackbarState {
    val scope = rememberCoroutineScope()
    return remember(scope) { AddToCartSnackbarState(scope) }
}
