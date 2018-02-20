package tw.pcbill.service

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import tw.pcbill.domain.Person
import tw.pcbill.domain.PersonDao
import java.util.*
import javax.transaction.Transactional

@Service
@Transactional
class RegistrationServiceImpl : RegistrationService {

    val logger = LoggerFactory.getLogger(RegistrationServiceImpl::class.java.simpleName)

    @Autowired
    private lateinit var personDao : PersonDao


    override fun registerByName(name: String) {
        handleResult(personDao.findByName(name))
    }

    override fun registerByPersonId(personId: String) {
        handleResult(personDao.findByPersonId(personId))
    }

    override fun listAllRegistered(): List<Person> {
        return personDao.findByRegistrationTimeIsNotNull()
    }

    //@PostConstruct
    fun postConstruct() {

        val winnie = Person("002", "bill")
        winnie.registrationTime = Date()

        personDao.saveAll(listOf(
                Person("001","bill"),
                winnie
                ))
    }

    private fun handleResult(people: List<Person>) {
        when {
            people.size > 1 -> logger.error("Non Unique Result by NAME")
            people.size == 1 -> people[0].registrationTime = Date()
            else -> logger.error("No Result by NAME")
        }
    }
}