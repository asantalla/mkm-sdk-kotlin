package co.develoop.mkm.model

import com.google.gson.annotations.SerializedName
import java.util.*

class MkmExpansion(
        val idGame: Int,
        val idExpansion: Long,
        val enName: String,
        val abbreviation: String,
        val icon: Long,
        val releaseDate: Date,
        val isReleased: Boolean,

        @SerializedName("localization")
        val localizations: List<MkmLocalization>
)