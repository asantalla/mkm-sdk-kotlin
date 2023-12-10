package co.develoop.mkm.api.stock.response

class MkmGetExportOwnStockResponseElement(
    val idRequest: Long,
    val idUser: Long,
    val status: String,
    val startedAt: String,
    val finishedAt: String,
    val type: String,
    val resourceId: String,
    val url: String
)