package co.develoop.mkm.api.request

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
class MkmAddProductsRequestElement {

    @XmlElement(name = "idProduct")
    var idProduct: Long? = null

    @XmlElement(name = "idLanguage")
    var idLanguage: Int? = null

    @XmlElement(name = "comments")
    var comments: String? = null

    @XmlElement(name = "price")
    var price: Long? = null

    @XmlElement(name = "count")
    var count: Long? = null

    @XmlElement(name = "condition")
    var condition: String? = null

    @XmlElement(name = "isFoil")
    var isFoil: Boolean = false

    @XmlElement(name = "isSigned")
    var isSigned: Boolean = false

    @XmlElement(name = "isPlayset")
    var isPlayset: Boolean = false

    @XmlElement(name = "isAltered")
    var isAltered: Boolean = false
}