package prosperaancientart.antiques.relicaisle.ui.composable.screen.onboarding

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.ui.graphics.vector.ImageVector
import prosperaancientart.antiques.relicaisle.R

data class OnboardingContent(
    @field:StringRes val titleRes: Int,
    @field:StringRes val descriptionRes: Int,
    val icons: List<ImageVector>,
)

val onboardingPagesContent = listOf(
    OnboardingContent(
        titleRes = R.string.page_discover_title,
        descriptionRes = R.string.page_discover_description,
        icons = listOf(Icons.Filled.Storefront, Icons.Filled.Search, Icons.Filled.FavoriteBorder),
    ),
    OnboardingContent(
        titleRes = R.string.page_checkout_title,
        descriptionRes = R.string.page_checkout_description,
        icons = listOf(Icons.Filled.ShoppingCart, Icons.Filled.Lock),
    ),
    OnboardingContent(
        titleRes = R.string.page_delivery_title,
        descriptionRes = R.string.page_delivery_description,
        icons = listOf(
            Icons.Filled.LocalShipping,
            Icons.Filled.Notifications,
            Icons.Filled.CheckCircle
        ),
    ),
)
