package prosperaancientart.antiques.relicaisle.di

import androidx.room.Room
import prosperaancientart.antiques.relicaisle.data.database.QFFMAppDatabase
import org.koin.dsl.module

private const val DB_NAME = "qffm_db"

val databaseModule = module {
    single {
        Room.databaseBuilder(
            context = get(),
            klass = QFFMAppDatabase::class.java,
            name = DB_NAME
        ).build()
    }

    single { get<QFFMAppDatabase>().cartItemDao() }

    single { get<QFFMAppDatabase>().orderDao() }
}