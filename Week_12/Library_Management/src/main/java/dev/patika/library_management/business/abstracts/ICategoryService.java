package dev.patika.library_management.business.abstracts;

import dev.patika.library_management.dto.Category.CategorySaveRequest;
import dev.patika.library_management.entities.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {

    Category saveCategory(CategorySaveRequest category);

    Optional<Category> getCategory(Long id);

    List<Category> getAllCategory();

    void deleteCategorty(Category category);

}
