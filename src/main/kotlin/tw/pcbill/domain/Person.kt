package tw.pcbill.domain

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Person(
        @Id val id: UUID ?= UUID.randomUUID(),
        val personId: String,
        val name: String)
{
    var registrationTime : Date? = null
    var createTime : Date = Date()
}