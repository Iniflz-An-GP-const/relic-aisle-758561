package prosperaancientart.antiques.relicaisle.di

import prosperaancientart.antiques.relicaisle.ui.viewmodel.AppViewModel
import prosperaancientart.antiques.relicaisle.ui.viewmodel.CartViewModel
import prosperaancientart.antiques.relicaisle.ui.viewmodel.CheckoutViewModel
import prosperaancientart.antiques.relicaisle.ui.viewmodel.OnboardingViewModel
import prosperaancientart.antiques.relicaisle.ui.viewmodel.OrderViewModel
import prosperaancientart.antiques.relicaisle.ui.viewmodel.ProductDetailsViewModel
import prosperaancientart.antiques.relicaisle.ui.viewmodel.ProductViewModel
import prosperaancientart.antiques.relicaisle.ui.viewmodel.SplashViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModule = module {
    viewModel {
        AppViewModel(
            cartRepository = get()
        )
    }

    viewModel {
        SplashViewModel(
            onboardingRepository = get()
        )
    }

    viewModel {
        OnboardingViewModel(
            onboardingRepository = get()
        )
    }

    viewModel {
        ProductViewModel(
            productRepository = get(),
            cartRepository = get(),
        )
    }

    viewModel {
        ProductDetailsViewModel(
            productRepository = get(),
            cartRepository = get(),
        )
    }

    viewModel {
        CheckoutViewModel(
            cartRepository = get(),
            productRepository = get(),
            orderRepository = get(),
        )
    }

    viewModel {
        CartViewModel(
            cartRepository = get(),
            productRepository = get(),
        )
    }

    viewModel {
        OrderViewModel(
            orderRepository = get(),
        )
    }
}