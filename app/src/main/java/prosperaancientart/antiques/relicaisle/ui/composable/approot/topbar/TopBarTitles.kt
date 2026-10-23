package prosperaancientart.antiques.relicaisle.ui.composable.approot.topbar

import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import prosperaancientart.antiques.relicaisle.R
import prosperaancientart.antiques.relicaisle.ui.composable.navigation.NavRoute
import kotlin.reflect.KClass

internal val canNavigateBackRoutes: List<KClass<out NavRoute>> = listOf(
    NavRoute.ProductDetails::class,
    NavRoute.Checkout::class,
)

internal fun topBarTitleRes(currentDestination: NavDestination?): Int? {
    return when {
        currentDestination == null -> null

        currentDestination.hierarchy.any { it.hasRoute(NavRoute.Home::class) } -> {
            R.string.qffm_top_bar_home_title
        }

        currentDestination.hierarchy.any { it.hasRoute(NavRoute.ProductDetails::class) } -> {
            R.string.qffm_top_bar_product_details_title
        }

        currentDestination.hierarchy.any { it.hasRoute(NavRoute.Cart::class) } -> {
            R.string.qffm_top_bar_cart_title
        }

        currentDestination.hierarchy.any { it.hasRoute(NavRoute.Checkout::class) } -> {
            R.string.qffm_top_bar_checkout_title
        }

        currentDestination.hierarchy.any { it.hasRoute(NavRoute.Orders::class) } -> {
            R.string.qffm_top_bar_orders_title
        }

        currentDestination.hierarchy.any { it.hasRoute(NavRoute.Settings::class) } -> {
            R.string.qffm_top_bar_settings_title
        }

        else -> null
    }
}
