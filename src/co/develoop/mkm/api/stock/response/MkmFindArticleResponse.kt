package co.develoop.mkm.api.stock.response

import co.develoop.mkm.model.MkmArticle
import co.develoop.mkm.model.MkmProduct
import com.google.gson.annotations.SerializedName

class MkmFindArticleResponse(
        @SerializedName("article")
        val article: MkmArticle,

        @SerializedName("product")
        val product: MkmProduct
)