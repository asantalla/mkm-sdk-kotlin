package co.develoop.mkm.api.stock.response

import co.develoop.mkm.model.MkmArticle
import com.google.gson.annotations.SerializedName

class MkmDeleteArticlesResponseElement(
        @SerializedName("success")
        val success: Boolean,

        @SerializedName("idArticle")
        var idArticle: Long,

        @SerializedName("count")
        var count: Long
)