package co.develoop.mkm.api.stock.response

import com.google.gson.annotations.SerializedName

class MkmGetStockFileResponse(
        @SerializedName("stock")
        val base64File: String
)