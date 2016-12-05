
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import ru.nsu.ccfit.dymova.shop.Application
import ru.nsu.ccfit.dymova.shop.domain.ProductRepository
import ru.nsu.ccfit.dymova.shop.domain.entities.Category
import ru.nsu.ccfit.dymova.shop.domain.entities.Product
import ru.nsu.ccfit.dymova.shop.rest.ProductController
import java.math.BigDecimal

@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(Application::class))
class ProductControllerTest {
    @Autowired
    private lateinit var controller : ProductController


    @MockBean
    private lateinit var productRepository: ProductRepository

    @Test
    fun get() {
        val testCategory = Category("test_category_name")
        val testName = "testName"
        given(productRepository.findAll())
                .willReturn(mutableListOf(
                        Product(testName, "test_description", BigDecimal.TEN, testCategory)))
        val result = controller.get()
        val product = result?.first()
        assertThat(product).hasFieldOrPropertyWithValue("name", testName)
        assertThat(product).hasFieldOrPropertyWithValue("category", testCategory)
    }
}