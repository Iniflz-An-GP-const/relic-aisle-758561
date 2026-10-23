package prosperaancientart.antiques.relicaisle.ui.composable.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import prosperaancientart.antiques.relicaisle.ui.composable.screen.cart.QFFMCartScreen
import prosperaancientart.antiques.relicaisle.ui.composable.screen.checkout.QFFMCheckoutScreen
import prosperaancientart.antiques.relicaisle.ui.composable.screen.home.QFFMHomeScreen
import prosperaancientart.antiques.relicaisle.ui.composable.screen.onboarding.QFFMOnboardingScreen
import prosperaancientart.antiques.relicaisle.ui.composable.screen.order.QFFMOrdersScreen
import prosperaancientart.antiques.relicaisle.ui.composable.screen.productdetails.QFFMProductDetailsScreen
import prosperaancientart.antiques.relicaisle.ui.composable.screen.settings.QFFMSettingsScreen
import prosperaancientart.antiques.relicaisle.ui.composable.screen.splash.QFFMSplashScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.Splash,
        modifier = modifier,
    ) {
        composable<NavRoute.Splash> {
            QFFMSplashScreen(
                onNavigateToHomeScreen = {
                    navController.navigate(route = NavRoute.Home) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
                onNavigateToOnboarding = {
                    navController.navigate(route = NavRoute.Onboarding) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<NavRoute.Onboarding> {
            QFFMOnboardingScreen(
                onNavigateToHomeScreen = {
                    navController.navigate(NavRoute.Home) {
                        popUpTo(NavRoute.Onboarding) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<NavRoute.Home> {
            QFFMHomeScreen(
                onNavigateToProductDetails = { id: Int ->
                    navController.navigate(
                        route = NavRoute.ProductDetails(id = id)
                    )
                }
            )
        }

        composable<NavRoute.ProductDetails> { backStackEntry ->
            val productDetails: NavRoute.ProductDetails = backStackEntry.toRoute()
            QFFMProductDetailsScreen(
                productId = productDetails.id,
            )
        }

        composable<NavRoute.Cart> {
            QFFMCartScreen(
                onNavigateToCheckoutScreen = {
                    navController.navigate(NavRoute.Checkout)
                }
            )
        }

        composable<NavRoute.Checkout> {
            QFFMCheckoutScreen(
                onNavigateToOrdersScreen = {
                    navController.navigate(NavRoute.Orders) {
                        popUpTo(NavRoute.Home) { inclusive = false }
                    }
                }
            )
        }

        composable<NavRoute.Orders> {
            QFFMOrdersScreen()
        }

        composable<NavRoute.Settings> {
            QFFMSettingsScreen()
        }
    }
}