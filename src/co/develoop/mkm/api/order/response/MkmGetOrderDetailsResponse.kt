package co.develoop.mkm.api.order.response

import co.develoop.mkm.model.MkmOrder
import com.google.gson.annotations.SerializedName

data class MkmGetOrderDetailsResponse(
    @SerializedName("order")
    val order: MkmOrder
)