package co.develoop.mkm.api.stock.response

import com.google.gson.annotations.SerializedName

class MkmDeleteArticlesResponse(
        @SerializedName("deleted")
        val articles: List<MkmDeleteArticlesResponseElement>
)