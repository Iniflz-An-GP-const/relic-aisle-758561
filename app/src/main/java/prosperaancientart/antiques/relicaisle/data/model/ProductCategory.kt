package prosperaancientart.antiques.relicaisle.data.model

import androidx.annotation.StringRes
import prosperaancientart.antiques.relicaisle.R

enum class ProductCategory(@field:StringRes val titleRes: Int) {
    BOOKS_AND_MANUSCRIPTS(R.string.product_category_books_manuscripts_title),
    COINS_AND_MEDALS(R.string.product_category_coins_medals_title),
    CERAMICS(R.string.product_category_ceramics_title),
    TIMEPIECES(R.string.product_category_timepieces_title),
    HISTORICAL_INSTRUMENTS(R.string.product_category_historical_instruments_title),
}
