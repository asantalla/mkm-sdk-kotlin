package co.develoop.mkm.api.marketplace.response

import co.develoop.mkm.model.MkmGame
import com.google.gson.annotations.SerializedName

class MkmGetGamesResponse(
        @SerializedName("game")
        val games: List<MkmGame>
)