package co.develoop.mkm.model

import com.google.gson.annotations.SerializedName

class MkmLanguage(
        val idLanguage: MkmLanguageID,
        val languageName: String
)

enum class MkmLanguageID(
        val id: Int
) {

    @SerializedName("1")
    ENGLISH(1),

    @SerializedName("2")
    FRENCH(2),

    @SerializedName("3")
    GERMAN(3),

    @SerializedName("4")
    SPANISH(4),

    @SerializedName("5")
    ITALIAN(5),

    @SerializedName("6")
    SIMPLIFIED_CHINESE(6),

    @SerializedName("7")
    JAPANESE(7),

    @SerializedName("8")
    PORTUGUESE(8),

    @SerializedName("9")
    RUSSIAN(9),

    @SerializedName("10")
    KOREAN(10),

    @SerializedName("11")
    TRADITIONAL_CHINESE(11)
}