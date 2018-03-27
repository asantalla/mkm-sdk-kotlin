package co.develoop.mkm.api.stock.request

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
class MkmIncreaseArticlesRequestElement {

    @XmlElement(name = "idArticle")
    var idArticle: Long? = null

    @XmlElement(name = "amount")
    var amount: Long? = null
}