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
        val number: String,
        val priceGuide: MkmPriceGuide?,
        val countArticles: Long,
        val countFoils: Long,
        val expansionName: String?,
        val expansionIcon: Int?,

        @SerializedName("expansion")
        val shortExpansion: MkmShortExpansion?,

        @SerializedName("reprint")
        val reprints: List<MkmReprint>?,

        @SerializedName("localization")
        val localizations: List<MkmLocalization>
)