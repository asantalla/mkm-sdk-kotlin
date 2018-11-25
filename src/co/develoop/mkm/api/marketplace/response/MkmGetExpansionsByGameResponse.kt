package co.develoop.mkm.api.marketplace.response

import co.develoop.mkm.model.MkmExpansion
import com.google.gson.annotations.SerializedName

class MkmGetExpansionsByGameResponse(
        @SerializedName("expansion")
        val expansions: List<MkmExpansion>
)