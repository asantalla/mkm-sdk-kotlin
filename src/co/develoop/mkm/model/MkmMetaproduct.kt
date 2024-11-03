package co.develoop.mkm.model

import com.google.gson.annotations.SerializedName

data class MkmMetaproduct(
    val idMetaproduct: Long,

    @SerializedName("localization")
    val localizations: List<MkmLocalization>
)