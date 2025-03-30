package co.develoop.mkm.api.marketplace.response

import co.develoop.mkm.model.MkmUser
import com.google.gson.annotations.SerializedName

class MkmFindUsersResponse(
    @SerializedName("expansion")
    val users: List<MkmUser>
)
