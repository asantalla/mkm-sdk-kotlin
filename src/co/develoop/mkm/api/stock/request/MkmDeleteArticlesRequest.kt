package co.develoop.mkm.api.stock.request

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "request")
class MkmDeleteArticlesRequest {

    @XmlElement(name = "article")
    lateinit var articles: List<MkmDeleteArticlesRequestElement>
}