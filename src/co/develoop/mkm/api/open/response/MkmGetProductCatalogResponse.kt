package co.develoop.mkm.api.open.response

import co.develoop.mkm.model.MkmProductCatalogEntry
import java.util.*

class MkmGetProductCatalogResponse(
    val version: Long,
    val createdAt: Date,
    val products: List<MkmProductCatalogEntry>
)