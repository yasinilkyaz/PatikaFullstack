package dev.patika.library_management.business.concretes;

import dev.patika.library_management.business.abstracts.ICategoryService;
import dev.patika.library_management.core.config.modelMapper.IModelMapperService;
import dev.patika.library_management.dao.CategoryRepo;
import dev.patika.library_management.dto.Category.CategorySaveRequest;
import dev.patika.library_management.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryManager implements ICategoryService {

    private final IModelMapperService mapperService;
    private final CategoryRepo categoryRepo;

    public CategoryManager(IModelMapperService mapperService, CategoryRepo categoryRepo) {
        this.mapperService = mapperService;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category saveCategory(CategorySaveRequest category) {
        Category category1=mapperService.forRequest().map(category, Category.class);
        return categoryRepo.save(category1);
    }

    @Override
    public Optional<Category> getCategory(Long id) {
        return categoryRepo.findById(id);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepo.findAll();
    }

    @Override
    public void deleteCategorty(Category category) {
        categoryRepo.delete(category);
    }
}
