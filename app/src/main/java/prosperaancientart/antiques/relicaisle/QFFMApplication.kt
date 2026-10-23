package prosperaancientart.antiques.relicaisle

import android.app.Application
import prosperaancientart.antiques.relicaisle.di.dataModule
import prosperaancientart.antiques.relicaisle.di.dispatcherModule
import prosperaancientart.antiques.relicaisle.di.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class QFFMApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val appModules = dataModule + viewModule + dispatcherModule

        startKoin {
            androidLogger()
            androidContext(this@QFFMApplication)
            modules(appModules)
        }
    }
}
