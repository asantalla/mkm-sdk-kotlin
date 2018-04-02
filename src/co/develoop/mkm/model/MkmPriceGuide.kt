package co.develoop.mkm.model

import com.google.gson.annotations.SerializedName

class MkmPriceGuide(
        @SerializedName("SELL")
        val sell: Double,

        @SerializedName("LOW")
        val low: Double,

        @SerializedName("LOWEX")
        val lowex: Double,

        @SerializedName("LOWFOIL")
        val lowfoil: Double,

        @SerializedName("AVG")
        val avg: Double,

        @SerializedName("TREND")
        val trend: Double
)