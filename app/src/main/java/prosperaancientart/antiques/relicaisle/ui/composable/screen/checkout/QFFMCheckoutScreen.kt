package prosperaancientart.antiques.relicaisle.ui.composable.screen.checkout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import prosperaancientart.antiques.relicaisle.ui.composable.approot.LocalContentBottomPadding
import prosperaancientart.antiques.relicaisle.ui.composable.screen.checkout.button.CheckoutConfirmButton
import prosperaancientart.antiques.relicaisle.ui.composable.screen.checkout.form.CheckoutForm
import prosperaancientart.antiques.relicaisle.ui.state.DataUiState
import prosperaancientart.antiques.relicaisle.ui.viewmodel.CheckoutViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun QFFMCheckoutScreen(
    modifier: Modifier = Modifier,
    viewModel: CheckoutViewModel = koinViewModel(),
    onNavigateToOrdersScreen: () -> Unit,
) {
    val focusManager = LocalFocusManager.current
    val orderState by viewModel.orderState.collectAsStateWithLifecycle()
    val emailInvalidState by viewModel.emailInvalidState.collectAsStateWithLifecycle()

    val isButtonEnabled by remember {
        derivedStateOf {
            viewModel.customerFirstName.isNotEmpty() &&
                    viewModel.customerLastName.isNotEmpty() &&
                    viewModel.customerEmail.isNotEmpty()
        }
    }

    if (orderState is DataUiState.Populated) {
        CheckoutDialog(
            onConfirm = onNavigateToOrdersScreen
        )
    }

    CheckoutContent(
        customerFirstName = viewModel.customerFirstName,
        customerLastName = viewModel.customerLastName,
        customerEmail = viewModel.customerEmail,
        isEmailInvalid = emailInvalidState,
        modifier = modifier,
        focusManager = focusManager,
        isButtonEnabled = isButtonEnabled,
        onFirstNameChanged = viewModel::updateCustomerFirstName,
        onLastNameChanged = viewModel::updateCustomerLastName,
        onEmailChanged = viewModel::updateCustomerEmail,
        onPlaceOrderButtonClick = viewModel::placeOrder
    )
}

@Composable
private fun CheckoutContent(
    customerFirstName: String,
    customerLastName: String,
    customerEmail: String,
    isEmailInvalid: Boolean,
    modifier: Modifier = Modifier,
    focusManager: FocusManager,
    isButtonEnabled: Boolean,
    onFirstNameChanged: (String) -> Unit,
    onLastNameChanged: (String) -> Unit,
    onEmailChanged: (String) -> Unit,
    onPlaceOrderButtonClick: () -> Unit,
) {
    // The checkout button is pinned to the bottom using a spacer and must not
    // extend beneath the system bar. There is no bottom bar on this screen,
    // so the padding equals the system inset; without it, the button would
    // overlap the navigation buttons.
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(bottom = LocalContentBottomPadding.current),
    ) {
        CheckoutForm(
            customerFirstName = customerFirstName,
            customerLastName = customerLastName,
            customerEmail = customerEmail,
            isEmailInvalid = isEmailInvalid,
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState()),
            focusManager = focusManager,
            onFirstNameChanged = onFirstNameChanged,
            onLastNameChanged = onLastNameChanged,
            onEmailChanged = onEmailChanged,
        )

        Spacer(modifier = Modifier.height(16.dp))

        CheckoutConfirmButton(
            enabled = isButtonEnabled,
            onClick = {
                focusManager.clearFocus()
                onPlaceOrderButtonClick()
            },
        )
    }
}
