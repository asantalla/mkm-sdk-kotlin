package co.develoop.mkm.model

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
    PRIVATE(0),
    COMMERCIAL(1),
    POWERSELLER(2)
}

enum class MkmUserReputation(val internalValue: Int) {
    NOT_ENOUGH_SELLS(0),
    OUTSTANDING(1),
    VERY_GOOD(2),
    GOOD(3),
    AVERAGE(4),
    BAD(5)
}

enum class MkmRiskGroup(val internalValue: Int) {
    NO_RISK(0),
    LOW_RISK(1),
    HIGH_RISK(2)
}