package prosperaancientart.antiques.relicaisle.data.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.GppGood
import androidx.compose.material.icons.outlined.Inventory2
import androidx.compose.material.icons.outlined.Verified
import androidx.compose.ui.graphics.vector.ImageVector

data class Benefit(
    val icon: ImageVector,
    val text: String,
)

val productBenefits = listOf<Benefit>(
    Benefit(
        icon = Icons.Outlined.Verified,
        text = "Curator-checked condition",
    ),
    Benefit(
        icon = Icons.Outlined.GppGood,
        text = "14-day return cover",
    ),
    Benefit(
        icon = Icons.Outlined.Inventory2,
        text = "Secure archival packing",
    ),
)
