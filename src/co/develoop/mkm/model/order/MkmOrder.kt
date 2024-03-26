package co.develoop.mkm.model.order

import co.develoop.mkm.model.MkmArticle
import com.google.gson.annotations.SerializedName

data class MkmOrder(
    val idOrder: Long,
    val isBuyer: Boolean,
    val seller: MkmActor,
    val buyer: MkmActor,
    val state: MkmState,
    val shippingMethod: MkmShippingMethod,
    val trackingNumber: String,
    val temporaryEmail: String,
    val isPresale: Boolean,
    val shippingAddress: MkmAddress,
    val note: String,
    val articleCount: Int,
    @SerializedName("article")
    val articles: List<MkmArticle>,
    val cancellationRequests: MkmCancellationRequests? = null
)