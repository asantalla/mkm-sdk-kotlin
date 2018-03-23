package co.develoop.mkm.api.response

import co.develoop.mkm.model.MkmArticle
import com.google.gson.annotations.SerializedName

class MkmAddProductsResponseElement(
        @SerializedName("success")
        val success: Boolean,

        @SerializedName("idArticle")
        val article: MkmArticle
)