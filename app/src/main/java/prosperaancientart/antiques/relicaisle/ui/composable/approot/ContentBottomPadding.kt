package prosperaancientart.antiques.relicaisle.ui.composable.approot

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * The height occupied by the bottom bar, including the inset for system
 * navigation.
 *
 * Content is drawn behind the bar rather than above it. This is necessary
 * to make cards visibly extend underneath the bar's edge-to-edge tiles.
 * The trade-off is that the last list item would end up behind the bar,
 * so every scrollable screen must add this value to its `contentPadding`,
 * while a screen with a fixed bottom block must add it to that block's
 * bottom padding.
 *
 * Zero on screens without a bottom bar: `Scaffold` reserves no space there.
 */
val LocalContentBottomPadding = compositionLocalOf<Dp> { 0.dp }
