package co.develoop.mkm.model

import com.google.gson.annotations.SerializedName
import java.util.*

class MkmArticle(
        val idArticle: Long,
        val idProduct: Long,
        val language: MkmLanguage,
        val comments: String,
        val price: Double,
        val count: Long,
        val inShoppingCart: Boolean,
        val lastEdited: Date?,
        val condition: MkmArticleCondition?,
        val isFoil: Boolean,
        val isSigned: Boolean,
        val isPlayset: Boolean,
        val isAltered: Boolean,

        val idCurrency: Int? = null,
        val currencyCode: String? = null,

        @SerializedName("product")
        val shortProduct: MkmShortProduct?
)

enum class MkmArticleCondition {
    MT, NM, EX, GD, LP, PL, PO
}