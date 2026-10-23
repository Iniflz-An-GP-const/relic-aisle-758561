package prosperaancientart.antiques.relicaisle.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import prosperaancientart.antiques.relicaisle.data.database.dao.CartItemDao
import prosperaancientart.antiques.relicaisle.data.database.dao.OrderDao
import prosperaancientart.antiques.relicaisle.data.database.converter.Converters
import prosperaancientart.antiques.relicaisle.data.entity.CartItemEntity
import prosperaancientart.antiques.relicaisle.data.entity.OrderEntity

@Database(
    entities = [CartItemEntity::class, OrderEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class QFFMAppDatabase : RoomDatabase() {

    abstract fun cartItemDao(): CartItemDao

    abstract fun orderDao(): OrderDao
}