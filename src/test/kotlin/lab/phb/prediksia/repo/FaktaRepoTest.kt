package lab.phb.prediksia.repo

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FaktaRepoTest {

    @Autowired
    lateinit var repo: FaktaRepo

    var logger = LoggerFactory.getLogger("FaktaRepoTest")

    @Test
    fun getAllTest() {
        var result = repo.findAll()
        logger.info("jumlah baris : " + result.size)
        Assertions.assertNotNull(result)
    }

}