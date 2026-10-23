package prosperaancientart.antiques.relicaisle.ui.composable.screen.home.slider

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import prosperaancientart.antiques.relicaisle.R
import prosperaancientart.antiques.relicaisle.data.model.Product
import prosperaancientart.antiques.relicaisle.ui.composable.screen.shared.ProductImage
import prosperaancientart.antiques.relicaisle.ui.theme.LocalDimens
import prosperaancientart.antiques.relicaisle.ui.theme.cardBorderStroke
import prosperaancientart.antiques.relicaisle.ui.theme.imageBorder

@Composable
fun FeaturedSlider(
    products: List<Product>,
    modifier: Modifier = Modifier,
    onProductClick: (productId: Int) -> Unit,
) {
    val pagerState = rememberPagerState { products.size }
    val dimens = LocalDimens.current

    HorizontalPager(
        state = pagerState,
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = dimens.screenPadding),
        pageSpacing = dimens.contentSpacing,
    ) { page ->
        val product = products[page]

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clickable { onProductClick(product.id) },
            shape = RoundedCornerShape(dimens.cardCornerRadius),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            ),
            border = cardBorderStroke(),
        ) {
            Column {
                ProductImage(
                    imageUrl = product.imageUrl,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .imageBorder(RectangleShape),
                )

                Column(modifier = Modifier.padding(dimens.cardPadding)) {
                    Text(
                        text = product.title,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        style = MaterialTheme.typography.titleSmall,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Text(
                        text = stringResource(R.string.price, product.price),
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
            }
        }
    }
}
