package prosperaancientart.antiques.relicaisle.ui.composable.approot.bottombar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import prosperaancientart.antiques.relicaisle.ui.composable.approot.bottombar.BottomNavItem
import prosperaancientart.antiques.relicaisle.ui.composable.approot.bottombar.isSelectedDestination
import prosperaancientart.antiques.relicaisle.ui.composable.navigation.NavRoute
import prosperaancientart.antiques.relicaisle.ui.theme.ControlDivider

private val BarHeight = 56.dp
private val IconSize = 22.dp
private val PillHorizontalPadding = 14.dp
private val PillVerticalPadding = 8.dp
private val LabelGap = 6.dp

@Composable
fun AppBottomBar(
    itemsInCart: Int,
    currentDestination: NavDestination?,
    navigationItems: List<BottomNavItem>,
    onNavigateToRoute: (BottomNavItem) -> Unit,
) {
    Surface(
        color = MaterialTheme.colorScheme.surfaceContainer,
        contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
    ) {
        Column(modifier = Modifier.navigationBarsPadding()) {
            ControlDivider()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(BarHeight)
                    .selectableGroup(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                navigationItems.forEach { item ->
                    NavPill(
                        item = item,
                        selected = isSelectedDestination(currentDestination, item.route),
                        itemsInCart = itemsInCart,
                        onClick = { onNavigateToRoute(item) },
                    )
                }
            }
        }
    }
}

@Composable
private fun NavPill(
    item: BottomNavItem,
    selected: Boolean,
    itemsInCart: Int,
    onClick: () -> Unit,
) {
    val background by animateColorAsState(
        targetValue = if (selected) {
            MaterialTheme.colorScheme.primaryContainer
        } else {
            Color.Transparent
        },
        label = "NavPillBackground",
    )

    val contentColor by animateColorAsState(
        targetValue = if (selected) {
            MaterialTheme.colorScheme.onPrimaryContainer
        } else {
            MaterialTheme.colorScheme.onSurfaceVariant
        },
        label = "NavPillContent",
    )

    Row(
        modifier = Modifier
            .clip(CircleShape)
            .background(background)
            .selectable(selected = selected, role = Role.Tab, onClick = onClick)
            .padding(horizontal = PillHorizontalPadding, vertical = PillVerticalPadding),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val icon = @Composable {
            Icon(
                imageVector = item.icon,
                contentDescription = stringResource(item.titleRes),
                tint = contentColor,
                modifier = Modifier.size(IconSize),
            )
        }

        if (item.route == NavRoute.Cart) {
            BadgedBox(
                badge = {
                    if (itemsInCart > 0) {
                        Badge {
                            Text(itemsInCart.toString())
                        }
                    }
                }
            ) {
                icon()
            }
        } else {
            icon()
        }

        AnimatedVisibility(visible = selected) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Spacer(modifier = Modifier.width(LabelGap))

                Text(
                    text = stringResource(item.titleRes),
                    color = contentColor,
                    style = MaterialTheme.typography.labelLarge,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}
