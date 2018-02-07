package tw.pcbill.domain

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Domain {
    @Id
    private var name:String = ""

    fun getName() = name
    fun setName(n:String) = {name = n}
}