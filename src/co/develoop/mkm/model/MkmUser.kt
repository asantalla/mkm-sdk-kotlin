package co.develoop.mkm.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class MkmUser(
    val idUser: Long,
    val username: String,
    val isCommercial: MkmUserType,
    val reputation: MkmUserReputation,
    val sellCount: Long,
    val onVacation: Boolean,
    val name: MkmIdentity,
    val address: MkmAddress,
    val phone: String,
    val email: String,
    val vat: String,
    val registrationDate: Date,
    val isSeller: Boolean,
    val legalInformation: String,
    val unsentShipments: Long,
    val shipsFast: Long,
    val soldItems: Long,
    val avgShippingTime: Long,
    val riskGroup: MkmRiskGroup,
    val lossPercentage: String
)

enum class MkmUserType(val internalValue: Int) {
    @SerializedName("0")
    PRIVATE(0),
    @SerializedName("1")
    COMMERCIAL(1),
    @SerializedName("2")
    POWERSELLER(2)
}

enum class MkmUserReputation(val internalValue: Int) {
    @SerializedName("0")
    NOT_ENOUGH_SELLS(0),
    @SerializedName("1")
    OUTSTANDING(1),
    @SerializedName("2")
    VERY_GOOD(2),
    @SerializedName("3")
    GOOD(3),
    @SerializedName("4")
    AVERAGE(4),
    @SerializedName("5")
    BAD(5)
}

enum class MkmRiskGroup(val internalValue: Int) {
    @SerializedName("0")
    NO_RISK(0),
    @SerializedName("1")
    LOW_RISK(1),
    @SerializedName("2")
    HIGH_RISK(2)
}