package tw.pcbill.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView
import tw.pcbill.domain.Person

@Controller
class RegistrationController {

    @GetMapping("/")
    fun registration(): ModelAndView {

        val re = HashMap<String, Any>()
        re.put("people", listOf(Person("123", "bill"),Person("333", "jill")))
        return ModelAndView("registration", re)
    }

}