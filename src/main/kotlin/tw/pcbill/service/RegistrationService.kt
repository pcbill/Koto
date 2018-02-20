package tw.pcbill.service

import tw.pcbill.domain.Person


interface RegistrationService {

    fun listAllRegistered(): List<Person>

    fun registerByPersonId(personId: String)
    fun registerByName(name: String)
}