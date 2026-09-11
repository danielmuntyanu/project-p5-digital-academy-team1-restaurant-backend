package dev.team1.products;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import dev.team1.contracts.IProductService;
import dev.team1.enums.ProductCategory;
import dev.team1.products.dtos.ProductDTOResponse;
import tools.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = ProductController.class)
public class ProductControllerTest {

    @Autowired 
    MockMvc mockMvc;

    @MockitoBean 
    IProductService service;

    @Autowired 
    ObjectMapper mapper;

    private List<ProductDTOResponse> mockProducts;

    @BeforeEach 
    void setup() {
        mockProducts = ProductTestData.sampleDTOs();
    }

    @Test 
    void testIndex_shouldReturnAllAvailableFirstPage() throws Exception {

        // создаем мок ответа объектом

        // конвертируем в мок ответ json

        // подменяем ответ от service нашим mock-объектом

        // Имитируем запрос

        // конвертируем ответ в объект 

        // сравниваем и проверяем

    }


    @Test 
    void testIndex_shouldReturnAllAvailableSecondPage() throws Exception {

        // создаем мок ответа объектом

        // конвертируем в мок ответ json

        // подменяем ответ от service нашим mock-объектом

        // Имитируем запрос

        // конвертируем ответ в объект 

        // сравниваем и проверяем

    }

    @Test 
    void testIndex_shouldReturnAllProducts() throws Exception {

        // создаем мок ответа объектом

        // конвертируем в мок ответ json

        // подменяем ответ от service нашим mock-объектом

        // Имитируем запрос

        // конвертируем ответ в объект 

        // сравниваем и проверяем

    }

    @Test 
    void testIndex_shouldReturnProductById() throws Exception {

        // создаем мок ответа объектом

        // конвертируем в мок ответ json

        // подменяем ответ от service нашим mock-объектом

        // Имитируем запрос

        // конвертируем ответ в объект 

        // сравниваем и проверяем

    }


    @Test 
    void testIndex_shouldReturnCorrectCategory() throws Exception {

        // создаем мок ответа объектом

        // конвертируем в мок ответ json

        // подменяем ответ от service нашим mock-объектом

        // Имитируем запрос

        // конвертируем ответ в объект 

        // сравниваем и проверяем

    }

    @Test 
    void testIndex_shouldReturnThrowWithIncorrectCategory() throws Exception {

        // создаем мок ответа объектом

        // конвертируем в мок ответ json

        // подменяем ответ от service нашим mock-объектом

        // Имитируем запрос

        // конвертируем ответ в объект 

        // сравниваем и проверяем

    }

    

}
