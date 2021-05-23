package co.develoop.mkm.model.order

import java.util.*

data class MkmActor(
    val idUser: Long,
    val username: String,
    val isCommercial: Int,
    val reputation: Int,
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
    val shipsFast: Int,
    val soldItems: Long,
    val avgShippingTime: Double,
    val riskGroup: Int,
    val lossPercentage: String
)