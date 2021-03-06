package tw.pcbill.domain

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Person(
        @Column(unique=true) val personId: String,
        val name: String,
        @Id val id: String ?= UUID.randomUUID().toString() )
{
    var registrationTime : Date? = null
    var createTime : Date = Date()
}