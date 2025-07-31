package com.sideprojects.api_books.text_plain.application.usecase;

import com.sideprojects.api_books.text_plain.domain.service.PlainTextService;
import org.springframework.stereotype.Component;

@Component
public class GetPlainTextUseCase {
    private final PlainTextService plainTextService;

    public GetPlainTextUseCase() {
        this.plainTextService = new PlainTextService();
    }

    public String execute() {
        return plainTextService.getMessage();
    }
}
