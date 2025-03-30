package co.develoop.mkm.model

data class MkmShippingMethod(
    val idShippingMethod: Long,
    val name: String,
    val price: Double,
    val idCurrency: Int,
    val currencyCode: String,
    val isLetter: Boolean,
    val isInsured: Boolean
)
