package co.develoop.mkm.api.marketplace.response

import com.google.gson.annotations.SerializedName

class MkmGetPriceGuideResponse(
        @SerializedName("priceguidefile")
        val base64File: String
)