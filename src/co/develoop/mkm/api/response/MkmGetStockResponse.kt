package co.develoop.mkm.api.response

import co.develoop.mkm.model.MkmArticle
import com.google.gson.annotations.SerializedName

class MkmGetStockResponse(
        @SerializedName("article") val articles: List<MkmArticle>
)