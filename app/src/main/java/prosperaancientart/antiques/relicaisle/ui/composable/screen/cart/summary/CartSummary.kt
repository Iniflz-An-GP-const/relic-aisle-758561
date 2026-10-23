package prosperaancientart.antiques.relicaisle.ui.composable.screen.cart.summary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import prosperaancientart.antiques.relicaisle.R
import prosperaancientart.antiques.relicaisle.ui.composable.approot.LocalContentBottomPadding
import prosperaancientart.antiques.relicaisle.ui.theme.ControlDivider
import prosperaancientart.antiques.relicaisle.ui.theme.LocalDimens

@Composable
fun CartSummary(
    itemsCount: Int,
    totalPrice: Double,
    modifier: Modifier = Modifier,
    onCompleteOrderButtonClick: () -> Unit,
) {
    val dimens = LocalDimens.current

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceContainer),
    ) {
        ControlDivider()

        Column(
            modifier = Modifier.padding(
                start = dimens.screenPadding,
                top = dimens.screenPadding,
                end = dimens.screenPadding,
                bottom = dimens.screenPadding + LocalContentBottomPadding.current,
            ),
        ) {
            SummaryRow(
                label = stringResource(R.string.cart_summary_subtotal_label),
                value = stringResource(R.string.price, totalPrice),
            )

            Spacer(modifier = Modifier.height(dimens.tightSpacing))

            SummaryRow(
                label = stringResource(R.string.cart_summary_delivery_label),
                value = stringResource(R.string.cart_summary_delivery_free),
                valueColor = MaterialTheme.colorScheme.primary,
            )

            Spacer(modifier = Modifier.height(dimens.contentSpacing))

            ControlDivider()

            Spacer(modifier = Modifier.height(dimens.contentSpacing))

            SummaryRow(
                label = stringResource(R.string.cart_summary_total_label),
                value = stringResource(R.string.price, totalPrice),
                labelColor = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.height(dimens.tightSpacing))

            Text(
                text = stringResource(R.string.cart_items_count, itemsCount),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.bodySmall,
            )

            Spacer(modifier = Modifier.height(dimens.contentSpacing))

            Button(
                onClick = onCompleteOrderButtonClick,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(dimens.controlCornerRadius),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                ),
            ) {
                Text(text = stringResource(R.string.button_place_order_label, totalPrice))
            }
        }
    }
}

@Composable
private fun SummaryRow(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    labelColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
    valueColor: Color = MaterialTheme.colorScheme.onSurface,
    fontWeight: FontWeight? = null,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = label,
            color = labelColor,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = fontWeight,
        )

        Text(
            text = value,
            color = valueColor,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = fontWeight,
        )
    }
}
