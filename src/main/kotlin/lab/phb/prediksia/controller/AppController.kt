package lab.phb.prediksia.controller

import lab.phb.prediksia.model.Parameter
import lab.phb.prediksia.repo.ResumeRepo
import lab.phb.prediksia.util.LeastSquare
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class AppController {

    var logger = LoggerFactory.getLogger("AppController")

    @Autowired
    lateinit var resumeRepo: ResumeRepo

    @RequestMapping("/")
    fun home(model: Model): String {
        model.addAttribute("param", Parameter())
        return "home"
    }

    @RequestMapping(value = [ "/proses" ], method = [ RequestMethod.POST ])
    fun proses(param: Parameter, model: Model): String {
        val data = resumeRepo.findByTglBetween(
            LeastSquare.convertTglToInt(param.tglAwal),
            LeastSquare.convertTglToInt(param.tglAkhir)
        )
        model.addAttribute("hasil", LeastSquare.calculate(data))
        return "proses"
    }

}