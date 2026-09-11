package dev.team1.products;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.team1.products.dtos.ProductDTOResponse;

@ExtendWith (MockitoExtension.class)
public class ProductServiceTest {
    
    @InjectMocks 
    ProductService service;

    @Mock 
    ProductRepository repository;

    private List<ProductEntity> sampleEntities;
    private List<ProductDTOResponse> sampleDTOs;

    @BeforeEach 
    void setup() {
        service = new ProductService(repository);
        
        sampleEntities = ProductTestData.sampleEntities();
        sampleDTOs = ProductTestData.sampleDTOs();
    }

    @Test 
    void testGetAll() {
        Pageable pageable = PageRequest.of(0, 20);
        Page<ProductEntity> mockPage = new PageImpl<>(sampleEntities, pageable, sampleEntities.size());

        when(repository.findAll(pageable)).thenReturn(mockPage);
        Page<ProductDTOResponse> pageDTO = service.getAll(pageable);

        assertThat(pageDTO.getTotalElements(), is(equalTo(8L)));
        assertThat(pageDTO.getContent().get(0).available(), is(equalTo(true)));
        assertThat(pageDTO.getContent().get(1).available(), is(equalTo(false)));
        assertThat(pageDTO.getContent().get(3).name(), is(equalTo("Java Roll")));
    }

}
