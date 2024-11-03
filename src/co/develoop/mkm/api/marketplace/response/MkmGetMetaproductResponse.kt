package co.develoop.mkm.api.marketplace.response

import co.develoop.mkm.model.MkmMetaproduct
import co.develoop.mkm.model.MkmProduct
import com.google.gson.annotations.SerializedName

data class MkmGetMetaproductResponse(
    val metaproduct: MkmMetaproduct,

    @SerializedName("product")
    val products: List<MkmProduct>
)