package tw.pcbill.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.ModelAndView
import tw.pcbill.domain.PersonParam
import tw.pcbill.service.RegistrationService

@Controller
class RegistrationController {

    @Autowired
    private lateinit var registrationService: RegistrationService

    @GetMapping("/")
    fun registration(): ModelAndView {

        return refreshAndGoToRegistrationPage()
    }

    @PostMapping("/registerByPersonId")
    fun registerByPersonId(person: PersonParam): ModelAndView {

        registrationService.registerByPersonId(person.personId)

        return refreshAndGoToRegistrationPage()
    }

    @PostMapping("/registerByName")
    fun registerByName(person: PersonParam): ModelAndView {

        registrationService.registerByName(person.name)

        return refreshAndGoToRegistrationPage()
    }

    private fun refreshAndGoToRegistrationPage(): ModelAndView {
        val re = HashMap<String, Any>()
        re.put("people", registrationService.listAllRegistered())
        return ModelAndView("registration", re)
    }


}