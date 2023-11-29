package dev.patika.ecommerce.dto.request.category;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CategorySaveRequest {
    @NotNull(message = "Kategori adı boş veya null olamaz")
    private String name;

    public CategorySaveRequest() {
    }

    public CategorySaveRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
