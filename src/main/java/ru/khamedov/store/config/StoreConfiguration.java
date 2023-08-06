package ru.khamedov.store.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.khamedov.store.service.ProductService;

@Configuration
public class StoreConfiguration {

    @Bean
    public ProductService productService(){
        return new ProductService();
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
