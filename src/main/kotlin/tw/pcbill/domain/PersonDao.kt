package tw.pcbill.domain

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PersonDao : JpaRepository<Person, String> {

    fun findByRegistrationTimeIsNotNull(): List<Person>
    fun findByPersonId(personId: String): List<Person>
    fun findByName(name: String): List<Person>

    fun findById(id: UUID): List<Person>
}