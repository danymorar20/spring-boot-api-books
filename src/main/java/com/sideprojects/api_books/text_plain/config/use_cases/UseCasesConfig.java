package com.sideprojects.api_books.text_plain.config.use_cases;

import com.sideprojects.api_books.text_plain.application.use_cases.GetHelloName;
import com.sideprojects.api_books.text_plain.domain.contracts.use_cases.GetHelloNameContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesConfig {
    @Bean
    GetHelloNameContract getHelloName() {
        return new GetHelloName();
    }
}
