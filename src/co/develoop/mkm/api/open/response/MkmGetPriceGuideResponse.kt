package co.develoop.mkm.api.open.response

import com.google.gson.annotations.SerializedName

class MkmGetPriceGuideResponse(
    @SerializedName("priceGuides")
    val priceGuides: List<MkmPriceGuideEntry>
)

data class MkmPriceGuideEntry(
    val idProduct: Long,

    val avg: Double,
    val low: Double,
    val trend: Double,

    val avg1: Double,
    val avg7: Double,
    val avg30: Double,

    @SerializedName("avg-foil")
    val foilAvg: Double,

    @SerializedName("low-foil")
    val foilLow: Double,

    @SerializedName("trend-foil")
    val foilTrend: Double,

    @SerializedName("avg1-foil")
    val foilAvg1: Double,

    @SerializedName("avg7-foil")
    val foilAvg7: Double,

    @SerializedName("avg30-foil")
    val foilAvg30: Double,
)