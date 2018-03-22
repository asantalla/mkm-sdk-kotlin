package co.develoop.mkm.api.response

import com.google.gson.annotations.SerializedName

class MkmAddArticlesResponse(
        @SerializedName("inserted")
        val articles: List<MkmArticleResponseElement>
)