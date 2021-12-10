package lab.phb.prediksia.util

import lab.phb.prediksia.repo.ResumeRepo
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class LeastSquareTest {

    var log = LoggerFactory.getLogger("LeastSquareTest")

    @Autowired
    lateinit var resumeRepo: ResumeRepo

    @Test
    fun convertTglToIntTest() {
        val result = LeastSquare.convertTglToInt("2005-06-07")
        log.info("Nilainya : " + result.toString())
        Assertions.assertEquals(20050607, result)
    }

    @Test
    fun calculateATest() {
        val data = resumeRepo.findByTglBetween(20050524, 20050530)
        val result = LeastSquare.calculateA(data)
        log.info("Nilainya : " + result)
        Assertions.assertEquals(589.01, result)
    }

    @Test
    fun generateXOddTest(){
        val result = LeastSquare.generateXOdd(9)
        log.info("baris data : " + result)
        Assertions.assertNotNull(result)
    }

}