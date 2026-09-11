package dev.team1.products;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.stream.Collectors;

import dev.team1.config.SecurityConfiguration;
import dev.team1.contracts.IProductService;
import dev.team1.products.dtos.ProductDTOResponse;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.JsonNode;

@WebMvcTest(controllers = ProductController.class)
@Import(SecurityConfiguration.class)
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
        Pageable pageable = PageRequest.of(0, 20);
        
        List<ProductDTOResponse> mockContent = mockProducts.stream()
            .filter(p -> p.available())
            .collect(Collectors.toList());
        
        Page<ProductDTOResponse> mockPage = new PageImpl<>(mockContent, pageable, mockContent.size());
        String json = mapper.writeValueAsString(mockPage);

        when(service.getAllAvailable(pageable)).thenReturn(mockPage);
        MockHttpServletResponse response = mockMvc.perform(get("/api/v1/products"))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse();

        JsonNode tree = mapper.readTree(response.getContentAsString());

        List<ProductDTOResponse> respContent = mapper.convertValue(
            tree.get("content"),
            new TypeReference<List<ProductDTOResponse>>() {}
        );

        assertThat(response.getContentAsString(), is(equalTo(json)));
        assertThat(respContent, is(equalTo(mockContent)));
        assertThat(response.getStatus(), is(equalTo(HttpStatus.OK.value())));
        assertThat(tree.get("totalPages").asInt(), is(equalTo(1)));
        assertThat(respContent.size(), is(equalTo(7)));
        assertThat(respContent.get(0).name(), is(equalTo("Ramen Fix")));
    }


    @Test 
    void testIndex_shouldReturnAllAvailableSecondPage() throws Exception {
        Pageable pageable = PageRequest.of(1, 4);
        
        List<ProductDTOResponse> mockContent = mockProducts.stream()
            .filter(p -> p.available())
            .collect(Collectors.toList());
        
        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), mockContent.size());

        List<ProductDTOResponse> mockPageContent = mockContent.subList(start, end);

        Page<ProductDTOResponse> mockPage = new PageImpl<>(mockPageContent, pageable, mockContent.size());
        String json = mapper.writeValueAsString(mockPage);

        when(service.getAllAvailable(pageable)).thenReturn(mockPage);
        MockHttpServletResponse response = mockMvc.perform(get("/api/v1/products")
                .param("page", "1")
                .param("size", "4")
                .accept(MediaType.ALL_VALUE))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse();

        JsonNode tree = mapper.readTree(response.getContentAsString());

        List<ProductDTOResponse> respContent = mapper.convertValue(
            tree.get("content"),
            new TypeReference<List<ProductDTOResponse>>() {}
        );

        assertThat(response.getContentAsString(), is(equalTo(json)));
        assertThat(respContent, is(equalTo(mockPageContent)));
        assertThat(response.getStatus(), is(equalTo(HttpStatus.OK.value())));
        assertThat(tree.get("totalPages").asInt(), is(equalTo(2)));
        assertThat(respContent.size(), is(equalTo(3)));
        assertThat(respContent.get(0).name(), is(equalTo("EbiOps")));
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
