package com.sideprojects.api_books.text_plain.infrastructure.rest_api.controller;

import com.sideprojects.api_books.text_plain.domain.contracts.use_cases.GetHelloNameContract;
import com.sideprojects.api_books.text_plain.infrastructure.rest_api.controller.dtos.TextPlainDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TextPlainController {

    private final GetHelloNameContract getHelloName;

    public TextPlainController(GetHelloNameContract getHelloName) {
        this.getHelloName = getHelloName;
    }

    @GetMapping
    public TextPlainDto getHelloName() {
        return TextPlainDto.fromDomain(getHelloName.execute());
    }
}
