package dev.patika.library_management.api;

import dev.patika.library_management.business.abstracts.ICategoryService;
import dev.patika.library_management.core.config.modelMapper.IModelMapperService;
import dev.patika.library_management.dto.Category.CategorySaveRequest;
import dev.patika.library_management.entities.Category;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/category")
public class CategoryController {

    private final ICategoryService categoryService;
    private final IModelMapperService mapperService;

    public CategoryController(ICategoryService categoryService, IModelMapperService mapperService) {
        this.categoryService = categoryService;
        this.mapperService = mapperService;
    }

    @PostMapping()
    public void saveCategory(@RequestBody CategorySaveRequest categorySaveRequest) {
        this.categoryService.saveCategory(categorySaveRequest);
    }

}
