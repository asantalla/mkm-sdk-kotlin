package co.develoop.mkm.api.stock.response

import co.develoop.mkm.model.MkmArticle
import com.google.gson.annotations.SerializedName

class MkmEditArticlesResponse(
        @SerializedName("updatedArticles")
        val updatedArticles: List<MkmArticle>,

        @SerializedName("notUpdatedArticles")
        val notUpdatedArticles: List<MkmArticle>
)