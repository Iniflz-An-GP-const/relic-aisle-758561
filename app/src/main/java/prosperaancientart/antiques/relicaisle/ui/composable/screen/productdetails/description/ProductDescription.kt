package prosperaancientart.antiques.relicaisle.ui.composable.screen.productdetails.description

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import prosperaancientart.antiques.relicaisle.R
import prosperaancientart.antiques.relicaisle.ui.composable.screen.shared.sectiontitle.SectionTitle

@Composable
fun ProductDescription(
    description: String,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        SectionTitle(text = stringResource(R.string.product_details_description_title))

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = description,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}
