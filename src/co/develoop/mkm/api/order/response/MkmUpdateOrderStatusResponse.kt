package co.develoop.mkm.api.order.response

import co.develoop.mkm.model.MkmOrder
import com.google.gson.annotations.SerializedName

data class MkmUpdateOrderStatusResponse(

    @SerializedName("order")
    val order: MkmOrder
)