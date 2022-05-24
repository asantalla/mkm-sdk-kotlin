package co.develoop.mkm.api.order.request

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "request")
class MkmUpdateOrderStatusRequest {

    @XmlElement(name = "action")
    var action: String? = null
}