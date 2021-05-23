package co.develoop.mkm.model.order

data class MkmAddress(
    val name: String,
    val extra: String?,
    val street: String,
    val zip: String,
    val city: String,
    val country: String
)