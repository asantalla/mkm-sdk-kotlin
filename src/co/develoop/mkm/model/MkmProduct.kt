package co.develoop.mkm.model

import com.google.gson.annotations.SerializedName

class MkmProduct(
        val idProduct: Long,
        val idMetaproduct: Long,
        val countReprints: Int,
        val idGame: Int,
        val enName: String,
        val locName: String,
        val image: String,
        val rarity: String,
        val website: String,
        val gameName: String,
        val categoryName: String,
        val number: Long,
        val expansion: MkmExpansion,
        val priceGuide: MkmPriceGuide,
        val countArticles: Long,
        val countFoils: Long,

        @SerializedName("reprint")
        val reprints: List<MkmReprint>,

        @SerializedName("localization")
        val localizations: List<MkmLocalization>
)