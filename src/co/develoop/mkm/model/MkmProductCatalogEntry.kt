package co.develoop.mkm.model

data class MkmProductCatalogEntry(
    val idProduct: Long,
    val name: String,
    val idCategory: Long,
    val categoryName: String,
    val idExpansion: Long,
    val idMetacard: Long
)