package com.sideprojects.api_books.text_plain.infrastructure.rest_api.controller.dtos;

import com.sideprojects.api_books.text_plain.domain.entities.TextPlain;

public record TextPlainDto(String message) {
    public static TextPlainDto fromDomain(TextPlain textPlain) {
        return new TextPlainDto(textPlain.value());
    }
}
