package dev.patika.ecommerce.dto.request.category;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CategoryUpdateRequest {
    @Positive
    private int id;
    @NotNull
    private String name;

    public CategoryUpdateRequest() {
    }

    public CategoryUpdateRequest(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
