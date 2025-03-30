package co.develoop.mkm.api.marketplace.response

data class MkmGetExportUserOffersDetailsResponse(
    val userOffersRequests: MkmGetExportUserOffersDetails
)

data class MkmGetExportUserOffersDetails(
    val idRequest: Long,
    val idUser: Long,
    val status: String,
    val startedAt: String,
    val finishedAt: String,
    val type: String,
    val resourceId: String,
    val url: String
)