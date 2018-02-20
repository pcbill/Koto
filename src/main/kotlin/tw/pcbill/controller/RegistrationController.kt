package tw.pcbill.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.ModelAndView
import tw.pcbill.domain.PersonDao
import tw.pcbill.domain.PersonParam
import tw.pcbill.service.RegistrationService

@Controller
class RegistrationController {

    @Autowired
    private lateinit var registrationService: RegistrationService

    @Autowired
    private lateinit var personDao: PersonDao

    @GetMapping("/")
    fun registration(): ModelAndView {

        return refreshAndGoToPage("registration")
    }

    @GetMapping("/management")
    fun registrationManagement(): ModelAndView {
        return refreshAndGoToPage("registrationManagement")
    }

    @PostMapping("/registerByPersonId")
    fun registerByPersonId(person: PersonParam): ModelAndView {

        registrationService.registerByPersonId(person.personId)

        return refreshAndGoToPage("registration")
    }

    @PostMapping("/registerByName")
    fun registerByName(person: PersonParam): ModelAndView {

        registrationService.registerByName(person.name)

        return refreshAndGoToPage("registration")
    }

    private fun refreshAndGoToPage(pageName: String): ModelAndView {
        val re = HashMap<String, Any>()
        re.put("people", registrationService.listAllRegistered())
        re.put("totalCount", personDao.findAll().size)
        return ModelAndView(pageName, re)
    }


}