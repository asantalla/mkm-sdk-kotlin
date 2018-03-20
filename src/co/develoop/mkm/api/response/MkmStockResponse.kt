package co.develoop.mkm.api.response

import co.develoop.mkm.model.MkmArticle
import com.google.gson.annotations.SerializedName

class MkmStockResponse(
        @SerializedName("article") val articles: List<MkmArticle>
)