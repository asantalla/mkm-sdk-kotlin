package co.develoop.mkm.api.marketplace.response

import com.google.gson.annotations.SerializedName

data class MkmRequestExportUserOffersResponse(
    @SerializedName("mkm_error_description")
    val mkmErrorDescription: String,

    @SerializedName("http_status_code")
    val httpStatusCode: Int,

    @SerializedName("http_status_code_description")
    val httpStatusCodeDescription: String
)
