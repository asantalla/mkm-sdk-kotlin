package co.develoop.mkm.api.response

import com.google.gson.annotations.SerializedName

class MkmAddProductsResponse(
        @SerializedName("inserted")
        val articles: List<MkmAddProductsResponseElement>
)