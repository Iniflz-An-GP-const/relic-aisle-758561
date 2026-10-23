package prosperaancientart.antiques.relicaisle.data.repository

import prosperaancientart.antiques.relicaisle.data.model.Product
import prosperaancientart.antiques.relicaisle.data.model.ProductCategory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ProductRepository {
    private val products = listOf<Product>(
        Product(
            id = 1,
            title = "Leather-Bound Missal",
            description = "This early twentieth-century missal has a tooled leather binding and gilt-edged pages. Its devotional illustrations and printed liturgy remain clear, with gentle wear consistent with careful use. A sound choice for collectors of religious printing and traditional bookcraft.",
            category = ProductCategory.BOOKS_AND_MANUSCRIPTS,
            price = 185.00,
            imageUrl = "https://images.unsplash.com/photo-1776698540733-e7994300ff52",
        ),
        Product(
            id = 2,
            title = "Antique Korean Book",
            description = "This traditional Korean book preserves period script on softly aged paper. The leaves show expected handling and toning, while the surviving text remains strong and legible. It is a distinctive object for collectors of Asian printing, calligraphy, and documentary history.",
            category = ProductCategory.BOOKS_AND_MANUSCRIPTS,
            price = 78.00,
            imageUrl = "https://images.unsplash.com/photo-1701525181804-efc707196fff",
        ),
        Product(
            id = 3,
            title = "Greek Silver Coin",
            description = "This ancient Greek silver coin bears a classical profile and time-softened relief. Natural toning highlights the surviving details without disguising the surface. It is supplied in a protective capsule with a catalog card for display and reference.",
            category = ProductCategory.COINS_AND_MEDALS,
            price = 1450.00,
            imageUrl = "https://images.unsplash.com/photo-1718140245037-8d02a29e425e",
        ),
        Product(
            id = 4,
            title = "Victorian Silver Coin",
            description = "This circulated silver coin comes from the Victorian era and retains a legible portrait and date. Fine marks and mellow toning reflect its genuine period use. It offers an accessible addition to a British historical coin collection.",
            category = ProductCategory.COINS_AND_MEDALS,
            price = 95.00,
            imageUrl = "https://images.unsplash.com/photo-1637597384655-e3c8ca310502",
        ),
        Product(
            id = 5,
            title = "Ancient Chinese Vase",
            description = "This ancient Chinese vase has a slender profile and a softly weathered blue surface. Subtle variations in colour and texture reveal the character expected of an excavated ceramic. Its compact scale makes it well suited to a protected cabinet display.",
            category = ProductCategory.CERAMICS,
            price = 950.00,
            imageUrl = "https://images.unsplash.com/photo-1758092320140-8b487fa3d47d",
        ),
        Product(
            id = 6,
            title = "Greek Ceramic Amphora",
            description = "This ancient Greek ceramic amphora carries a painted figural scene around its rounded body. Surface wear and mineral traces are consistent with the vessel's considerable age. The stable form presents beautifully as a centrepiece for a classical antiquities collection.",
            category = ProductCategory.CERAMICS,
            price = 2600.00,
            imageUrl = "https://images.unsplash.com/photo-1695901741829-7a9cc23d32ac",
        ),
        Product(
            id = 7,
            title = "Silver Pocket Watch",
            description = "This mechanical pocket watch has a silver-tone case, Roman numeral dial, and attached chain. The case shows light handling marks that complement its aged character. It has been checked for basic operation, though regular servicing is recommended for dependable timekeeping.",
            category = ProductCategory.TIMEPIECES,
            price = 295.00,
            imageUrl = "https://images.unsplash.com/photo-1773414685888-1a9d8c5fade4",
        ),
        Product(
            id = 8,
            title = "Gilt Mantel Clock",
            description = "This ornate mantel clock pairs a gilt metal case with sculptural classical details. The dial remains easy to read and the finish has developed an appealing aged patina. It is an impressive focal piece for a mantel, study, or formal collection.",
            category = ProductCategory.TIMEPIECES,
            price = 680.00,
            imageUrl = "https://images.unsplash.com/photo-1774266838816-2e9e2a4651b3",
        ),
        Product(
            id = 9,
            title = "Brass Pocket Compass",
            description = "This brass pocket compass has a hinged cover and a clearly marked directional dial. The case carries a warm patina with small signs of travel and handling. It is a compact historical instrument suited to a maritime or exploration-themed collection.",
            category = ProductCategory.HISTORICAL_INSTRUMENTS,
            price = 145.00,
            imageUrl = "https://images.unsplash.com/photo-1769776400503-6ad467d68ac3",
        ),
        Product(
            id = 10,
            title = "Brass Opera Glasses",
            description = "These compact brass opera glasses combine period theatre style with practical folding optics. Their metalwork shows an even patina, while the focusing wheel moves smoothly. They make a distinctive display object for collectors of optical and performance history.",
            category = ProductCategory.HISTORICAL_INSTRUMENTS,
            price = 175.00,
            imageUrl = "https://images.unsplash.com/photo-1777639629820-cc621507874e",
        ),
    )

    fun observeById(id: Int): Flow<Product?> {
        val item = products.find { it.id == id }
        return flowOf(item)
    }

    fun getById(id: Int): Product? {
        return products.find { it.id == id }
    }

    fun observeAll(): Flow<List<Product>> {
        return flowOf(products)
    }
}
