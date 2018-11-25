package co.develoop.mkm.api.stock.request

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "request")
class MkmAddProductsRequest {

    @XmlElement(name = "article")
    lateinit var products: List<MkmAddProductsRequestElement>
}