package prosperaancientart.antiques.relicaisle.ui.composable.screen.productdetails.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import prosperaancientart.antiques.relicaisle.data.model.Product
import prosperaancientart.antiques.relicaisle.data.model.productBenefits
import prosperaancientart.antiques.relicaisle.ui.composable.screen.productdetails.benefits.ProductBenefitsCard
import prosperaancientart.antiques.relicaisle.ui.composable.screen.productdetails.button.AddToCartButton
import prosperaancientart.antiques.relicaisle.ui.composable.screen.productdetails.description.ProductDescription
import prosperaancientart.antiques.relicaisle.ui.composable.screen.productdetails.header.ProductHeader
import prosperaancientart.antiques.relicaisle.ui.composable.screen.productdetails.image.ProductDetailsImage
import prosperaancientart.antiques.relicaisle.ui.composable.screen.productdetails.snackbar.rememberAddToCartSnackbarState
import prosperaancientart.antiques.relicaisle.ui.composable.screen.productdetails.snackbar.AddedToCartSnackbar
import prosperaancientart.antiques.relicaisle.ui.theme.LocalDimens

@Composable
fun ProductDetailsLayout(
    product: Product,
    modifier: Modifier = Modifier,
    onAddToCart: () -> Unit,
) {
    val dimens = LocalDimens.current
    val snackbarState = rememberAddToCartSnackbarState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 16.dp),
    ) {
        Box(modifier = Modifier.weight(1f)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(vertical = 16.dp),
            ) {
                ProductDetailsImage(
                    imageUrl = product.imageUrl,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimens.screenPadding),
                )

                Spacer(modifier = Modifier.height(16.dp))

                ProductHeader(
                    product = product,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimens.screenPadding),
                )

                Spacer(modifier = Modifier.height(16.dp))

                ProductBenefitsCard(
                    benefits = productBenefits,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimens.screenPadding),
                )

                Spacer(modifier = Modifier.height(16.dp))

                ProductDescription(
                    description = product.description,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimens.screenPadding),
                )
            }

            AddedToCartSnackbar(
                visible = snackbarState.isVisible,
                modifier = Modifier.align(Alignment.BottomCenter),
            )
        }

        AddToCartButton(
            onClick = {
                onAddToCart()
                snackbarState.show()
            },
            modifier = Modifier.fillMaxWidth(),
        )
    }
}
