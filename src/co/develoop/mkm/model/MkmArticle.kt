package co.develoop.mkm.model

import java.util.*

class MkmArticle(
        val idArticle: Long,
        val idProduct: Long,
        val language: MkmLanguage,
        val comments: String,
        val price: Double,
        val count: Long,
        val inShoppingCart: Boolean,
        val product: MkmShortProduct,
        val lastEdited: Date,
        val condition: MkmArticleCondition,
        val isFoil: Boolean,
        val isSigned: Boolean,
        val isPlayset: Boolean,
        val isAltered: Boolean
)

enum class MkmArticleCondition {
    MT, NM, EX, GD, LP, PL, PO
}