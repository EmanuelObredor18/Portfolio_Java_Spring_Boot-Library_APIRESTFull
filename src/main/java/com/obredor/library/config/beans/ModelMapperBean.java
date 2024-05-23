package com.obredor.library.config.beans;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperBean {
  
  @Bean
  ModelMapper modelMapper() {
    return new ModelMapper();
  }

}
