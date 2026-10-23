package prosperaancientart.antiques.relicaisle.di

import prosperaancientart.antiques.relicaisle.data.repository.CartRepository
import prosperaancientart.antiques.relicaisle.data.repository.OnboardingRepository
import prosperaancientart.antiques.relicaisle.data.repository.OrderRepository
import prosperaancientart.antiques.relicaisle.data.repository.ProductRepository

import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    includes(databaseModule, dataStoreModule)

    single {
        OnboardingRepository(
            onboardingDataStoreManager = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }

    single { ProductRepository() }

    single {
        CartRepository(
            cartItemDao = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }

    single {
        OrderRepository(
            orderDao = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }
}