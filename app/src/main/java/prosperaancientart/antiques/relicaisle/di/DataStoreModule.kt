package prosperaancientart.antiques.relicaisle.di

import prosperaancientart.antiques.relicaisle.data.datastore.OnboardingDataStoreManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataStoreModule = module {
    single { OnboardingDataStoreManager(androidContext()) }
}