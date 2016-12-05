
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import ru.nsu.ccfit.dymova.shop.Application
import ru.nsu.ccfit.dymova.shop.domain.CategoryRepository
import ru.nsu.ccfit.dymova.shop.domain.entities.Category
import ru.nsu.ccfit.dymova.shop.rest.CategoryController

@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(Application::class))
class CategoryControllerTest {
    @Autowired
    private lateinit var controller: CategoryController


    @MockBean
    private lateinit var categoryRepository: CategoryRepository

    @Test
    fun get() {
        given(categoryRepository.findAll())
                .willReturn(mutableListOf(Category("test_category")))

        val result = controller.get()
        assertThat(result?.first()).hasFieldOrPropertyWithValue("name", "test_category")
    }
}