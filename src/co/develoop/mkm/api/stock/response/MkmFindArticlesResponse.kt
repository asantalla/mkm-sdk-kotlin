package co.develoop.mkm.api.stock.response

import co.develoop.mkm.model.MkmArticle
import com.google.gson.annotations.SerializedName

class MkmFindArticlesResponse(
        @SerializedName("article")
        val articles: List<MkmArticle>
)