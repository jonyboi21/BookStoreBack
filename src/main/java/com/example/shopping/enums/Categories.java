package com.example.shopping.enums;

import javax.persistence.Enumerated;

public enum Categories {
    TEXTBOOK("TEXTBOOK"),
    FICTION("FICTION"),
    NOVEL("NOVEL"),
    NONFICTION("NON-FICTION");

    private final String categories;

    Categories(String categories) {
        this.categories = categories;
    }

    public String getCategories() {
        return categories;
    }
}
