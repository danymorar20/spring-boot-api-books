package com.sideprojects.api_books.text_plain.infrastructure.controller;

import com.sideprojects.api_books.text_plain.application.usecase.GetPlainTextUseCase;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/text", produces = MediaType.TEXT_PLAIN_VALUE)
public class PlainTextController {

    private final GetPlainTextUseCase getPlainTextUseCase;

    public PlainTextController(GetPlainTextUseCase getPlainTextUseCase) {
        this.getPlainTextUseCase = getPlainTextUseCase;
    }

    @GetMapping
    public String getHello() {
        return getPlainTextUseCase.execute();
    }
}
