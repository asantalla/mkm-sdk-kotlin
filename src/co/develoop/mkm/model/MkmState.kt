package co.develoop.mkm.model

import java.util.*

data class MkmState(
    val state: String,
    val dateBought: Date,
    val datePaid: Date,
    val dateSent: Date,
)
