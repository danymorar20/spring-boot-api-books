package com.sideprojects.api_books.text_plain.application.use_cases;

import com.sideprojects.api_books.text_plain.domain.contracts.use_cases.GetHelloNameContract;
import com.sideprojects.api_books.text_plain.domain.entities.TextPlain;

public class GetHelloName implements GetHelloNameContract {
    @Override
    public TextPlain execute() {
        return new TextPlain("Hello World");
    }
}
