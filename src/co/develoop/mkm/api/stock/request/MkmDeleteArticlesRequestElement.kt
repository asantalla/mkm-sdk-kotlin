package co.develoop.mkm.api.stock.request

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
class MkmDeleteArticlesRequestElement {

    @XmlElement(name = "idArticle")
    var idArticle: Long? = null

    @XmlElement(name = "count")
    var count: Long? = null
}