package prosperaancientart.antiques.relicaisle.ui.composable.screen.productdetails.header

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import prosperaancientart.antiques.relicaisle.R
import prosperaancientart.antiques.relicaisle.data.model.Product
import prosperaancientart.antiques.relicaisle.ui.theme.LocalDimens
import prosperaancientart.antiques.relicaisle.ui.theme.controlBorderStroke

@Composable
fun ProductHeader(
    product: Product,
    modifier: Modifier = Modifier,
) {
    val dimens = LocalDimens.current
    val badgeShape = RoundedCornerShape(dimens.controlCornerRadius)

    Column(modifier = modifier) {
        Text(
            text = product.title,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.headlineSmall,
        )

        Spacer(modifier = Modifier.height(dimens.tightSpacing))

        Surface(
            shape = badgeShape,
            color = MaterialTheme.colorScheme.surfaceContainerLow,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
            border = controlBorderStroke(),
        ) {
            Text(
                text = stringResource(product.category.titleRes),
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                style = MaterialTheme.typography.labelMedium,
            )
        }

        Spacer(modifier = Modifier.height(dimens.contentSpacing))

        Text(
            text = stringResource(R.string.price, product.price),
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleLarge,
        )
    }
}
