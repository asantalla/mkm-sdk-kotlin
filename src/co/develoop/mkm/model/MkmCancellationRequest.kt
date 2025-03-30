package co.develoop.mkm.model

import java.util.*

data class MkmCancellationRequests(
    val cancellationRequestBuyer: MkmCancellationRequest? = null,
    val cancellationRequestSeller: MkmCancellationRequest? = null
)

data class MkmCancellationRequest(
    val date: Date,
    val reason: String? = null,
    val status: String,
    val answer: String? = null
)