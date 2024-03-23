package fiipractic.PFM_TRX_MGM.controller;

import fiipractic.PFM_TRX_MGM.dto.CategoryDto;
import fiipractic.PFM_TRX_MGM.model.Category;
import fiipractic.PFM_TRX_MGM.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories =  categoryService.getAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable BigInteger id) {
        Category category = categoryService.getById(id);
        return ResponseEntity.ok(category);
    }

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody CategoryDto categoryDto) {
        if (categoryDto.parentId() != null)
            categoryService.getById(categoryDto.parentId());
        Category savedCategory = categoryService.save(new Category(categoryDto.value(), categoryDto.parentId()));
        return ResponseEntity.ok(savedCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable BigInteger id, @RequestBody CategoryDto categoryDto) {
        if (categoryDto.parentId() != null)
            categoryService.getById(categoryDto.parentId());
        Category updatedCategory = categoryService.update(id, new Category(categoryDto.value(), categoryDto.parentId()));
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable BigInteger id) {
        categoryService.deleteById(id);
        return ResponseEntity.ok("Category with ID: " + id + " deleted.");
    }

}
