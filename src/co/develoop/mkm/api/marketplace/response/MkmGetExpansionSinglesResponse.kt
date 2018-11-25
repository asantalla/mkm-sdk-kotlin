package co.develoop.mkm.api.marketplace.response

import co.develoop.mkm.model.MkmExpansion
import co.develoop.mkm.model.MkmProduct
import com.google.gson.annotations.SerializedName

class MkmGetExpansionSinglesResponse(
        val expansion: MkmExpansion,

        @SerializedName("single")
        val singles: List<MkmProduct>
)