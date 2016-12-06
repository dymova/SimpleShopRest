
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import ru.nsu.ccfit.dymova.shop.Application
import ru.nsu.ccfit.dymova.shop.domain.OrderRepository
import ru.nsu.ccfit.dymova.shop.domain.entities.*
import ru.nsu.ccfit.dymova.shop.restapi.OrderApi
import java.math.BigDecimal
import java.sql.Timestamp

@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(Application::class))
class OrderApiTest {
    @Autowired
    private lateinit var controller : OrderApi


    @MockBean
    private lateinit var orderRepository: OrderRepository

    @Test
    fun get() {
        val testCategory = Category("test_category_name")
        val testProduct = Product("testName", "test_description", BigDecimal.TEN, testCategory)
        val orderItem = OrderItem(null, testProduct, 42)
        val items = mutableListOf(orderItem)
        val data = Timestamp(System.currentTimeMillis())
        given(orderRepository.findAll())
                .willReturn(mutableListOf(Order(data,
                        OrderStatus.PENDING_PAYMENT, items)))
        val result = controller.get()
        val order = result?.first()
        assertThat(order).hasFieldOrPropertyWithValue("data", data)
        assertThat(order).hasFieldOrPropertyWithValue("status", OrderStatus.PENDING_PAYMENT)
        assertThat(order).hasFieldOrPropertyWithValue("products", items)
    }
}