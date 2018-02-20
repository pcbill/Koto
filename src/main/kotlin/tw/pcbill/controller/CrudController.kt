package tw.pcbill.controller

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.ModelAndView
import tw.pcbill.domain.Person
import tw.pcbill.domain.PersonDao
import tw.pcbill.domain.PersonParam
import tw.pcbill.service.RegistrationService
import java.util.*

@Controller
class CrudController {
    val logger = LoggerFactory.getLogger(CrudController::class.java.simpleName)

    @Autowired
    private lateinit var registrationService: RegistrationService

    @Autowired
    private lateinit var personDao: PersonDao

    @PostMapping("/createPerson")
    fun createPerson(person: PersonParam): ModelAndView {
        when {
            person.name.isBlank() -> logger.error("the name of person is blank")
            person.personId.isBlank() -> logger.error("the personId of person is blank")
            else -> {
                val p = Person(person.personId, person.name)
                p.registrationTime = Date()
                personDao.save(p)
            }
        }

        return refreshAndGoToRegistrationManagementPage()
    }

    @GetMapping("/deleteRegistration/{idp}")
    fun deleteRegistration(@PathVariable idp: String): ModelAndView {
        if (idp.isBlank()) {
            logger.error("the id of person is blank")
        } else {
            //val id = UUID.fromString(idp)
            val peopleOpt = personDao.findById(idp)
                    peopleOpt.get().registrationTime = null
            //when {
            //    people.size > 1 -> logger.error("multiple people have same personId !")
              //  people.size == 1 ->  people[0].registrationTime = null
                //else -> logger.error("the id of person didn't exist!")
            //}
        }

        return refreshAndGoToRegistrationManagementPage()
    }


    private fun refreshAndGoToRegistrationManagementPage(): ModelAndView {
        val re = HashMap<String, Any>()
        re.put("people", registrationService.listAllRegistered())
        return ModelAndView("registrationManagement", re)
    }
}