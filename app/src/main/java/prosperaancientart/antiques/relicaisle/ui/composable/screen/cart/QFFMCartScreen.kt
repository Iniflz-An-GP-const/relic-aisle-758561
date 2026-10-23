package prosperaancientart.antiques.relicaisle.ui.composable.screen.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import prosperaancientart.antiques.relicaisle.R
import prosperaancientart.antiques.relicaisle.ui.composable.approot.LocalContentBottomPadding
import prosperaancientart.antiques.relicaisle.ui.composable.screen.cart.card.CartItem
import prosperaancientart.antiques.relicaisle.ui.composable.screen.cart.summary.CartSummary
import prosperaancientart.antiques.relicaisle.ui.composable.screen.shared.DataBasedContainer
import prosperaancientart.antiques.relicaisle.ui.composable.screen.shared.DataEmptyContent
import prosperaancientart.antiques.relicaisle.ui.state.CartItemUiState
import prosperaancientart.antiques.relicaisle.ui.state.DataUiState
import prosperaancientart.antiques.relicaisle.ui.theme.LocalDimens
import prosperaancientart.antiques.relicaisle.ui.viewmodel.CartViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun QFFMCartScreen(
    modifier: Modifier = Modifier,
    viewModel: CartViewModel = koinViewModel(),
    onNavigateToCheckoutScreen: () -> Unit,
) {
    val cartItemsState by viewModel.cartItemsState.collectAsStateWithLifecycle()
    val totalPrice by viewModel.totalPrice.collectAsStateWithLifecycle()

    val onPlusItemClick = { itemId: Int ->
        viewModel.incrementProductInCart(itemId)
    }

    val onMinusItemClick = { itemId: Int ->
        viewModel.decrementItemInCart(itemId)
    }

    val onDeleteItemClick = { itemId: Int ->
        viewModel.deleteFromCart(itemId)
    }

    CartScreenContent(
        cartItemsState = cartItemsState,
        modifier = modifier,
        totalPrice = totalPrice,
        onPlusItemClick = onPlusItemClick,
        onMinusItemClick = onMinusItemClick,
        onDeleteItemClick = onDeleteItemClick,
        onCompleteOrderButtonClick = onNavigateToCheckoutScreen,
    )
}

@Composable
private fun CartScreenContent(
    cartItemsState: DataUiState<List<CartItemUiState>>,
    modifier: Modifier = Modifier,
    totalPrice: Double,
    onPlusItemClick: (Int) -> Unit,
    onMinusItemClick: (Int) -> Unit,
    onDeleteItemClick: (Int) -> Unit,
    onCompleteOrderButtonClick: () -> Unit,
) {
    val dimens = LocalDimens.current

    Column(modifier = modifier) {

        DataBasedContainer(
            modifier = Modifier.fillMaxSize(),
            dataState = cartItemsState,

            dataPopulated = {
                val data = (cartItemsState as DataUiState.Populated<List<CartItemUiState>>).data

                Column(modifier = Modifier.fillMaxSize()) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        contentPadding = PaddingValues(dimens.screenPadding),
                        verticalArrangement = Arrangement.spacedBy(dimens.contentSpacing),
                    ) {
                        items(items = data, key = { item -> item.productId }) { item ->
                            CartItem(
                                item = item,
                                onPlusClick = { onPlusItemClick(item.productId) },
                                onMinusClick = { onMinusItemClick(item.productId) },
                                onDeleteClick = { onDeleteItemClick(item.productId) },
                            )
                        }
                    }

                    CartSummary(
                        itemsCount = data.sumOf { item -> item.quantity },
                        totalPrice = totalPrice,
                        onCompleteOrderButtonClick = onCompleteOrderButtonClick,
                    )
                }
            },

            dataEmpty = {
                DataEmptyContent(
                    primaryText = stringResource(R.string.cart_state_empty_primary_text),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = LocalContentBottomPadding.current),
                )
            },
        )
    }
}
