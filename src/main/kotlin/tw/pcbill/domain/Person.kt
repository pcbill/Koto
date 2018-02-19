package tw.pcbill.domain

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Person(
        val personId: String,
        val name: String,
        @Id val id: UUID ?= UUID.randomUUID()
)
{
    var registrationTime : Date? = null
    var createTime : Date = Date()
}