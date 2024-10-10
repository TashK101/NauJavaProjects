package ru.karimova.NauJava.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.karimova.NauJava.entity.Address;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Config {
    @Bean
    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
    public List<Address> addressContainer() {
        return new ArrayList<>();
    }
}