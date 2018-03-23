package co.develoop.mkm.api.stock.response

import co.develoop.mkm.model.MkmArticle
import com.google.gson.annotations.SerializedName

class MkmGetStockResponse(
        @SerializedName("article")
        val articles: List<MkmArticle>
)