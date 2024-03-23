package fiipractic.PFM_TRX_MGM.service;

import fiipractic.PFM_TRX_MGM.exceptions.NotFoundException;
import fiipractic.PFM_TRX_MGM.model.Category;
import fiipractic.PFM_TRX_MGM.repository.CategoryRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }


    public List<Category> getAll() {
        return categoryRepo.findAll();
    }

    public Category getById(BigInteger id) {
        return categoryRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Category with ID: " + id + " not found."));
    }

    public Category save(Category category) {
        return categoryRepo.save(category);
    }

    public Category update(BigInteger id, Category category) {
        Category existingCategory = getById(id);
        existingCategory.setValue(category.getValue());
        existingCategory.setParentId(category.getParentId());
        return categoryRepo.save(existingCategory);
    }

    @Transactional
    public void deleteById(BigInteger id) {
        categoryRepo.deleteById(id);
    }
}
