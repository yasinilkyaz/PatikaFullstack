package dev.patika.library_management.dto.Category;

public class CategorySaveRequest {

    private String name;

    private String description;

    public CategorySaveRequest() {
    }

    public CategorySaveRequest(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
