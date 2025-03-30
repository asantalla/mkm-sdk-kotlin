package co.develoop.mkm.api.order.response

import co.develoop.mkm.model.MkmOrder
import com.google.gson.annotations.SerializedName

data class MkmGetOrdersResponse(
    @SerializedName("order")
    val orders: List<MkmOrder>
)

