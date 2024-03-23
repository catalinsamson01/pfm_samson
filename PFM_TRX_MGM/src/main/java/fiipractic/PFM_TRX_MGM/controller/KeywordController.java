package fiipractic.PFM_TRX_MGM.controller;

import fiipractic.PFM_TRX_MGM.dto.KeywordDto;
import fiipractic.PFM_TRX_MGM.model.Keyword;
import fiipractic.PFM_TRX_MGM.service.CategoryService;
import fiipractic.PFM_TRX_MGM.service.KeywordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/keywords")
public class KeywordController {

    private final KeywordService keywordService;
    private final CategoryService categoryService;

    public KeywordController(KeywordService keywordService, CategoryService categoryService) {
        this.keywordService = keywordService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Keyword>> getAllKeywords() {
        List<Keyword> keywords = keywordService.getAll();
        return ResponseEntity.ok(keywords);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Keyword> getKeywordById(@PathVariable BigInteger id) {
        Keyword keyword = keywordService.getById(id);
        return ResponseEntity.ok(keyword);
    }

    @PostMapping
    public ResponseEntity<Keyword> addKeyword(@RequestBody KeywordDto keywordDto) {
        if (keywordDto.categoryId() != null)
            categoryService.getById(keywordDto.categoryId());
        Keyword savedKeyword = keywordService.save(new Keyword(keywordDto.value(), keywordDto.categoryId()));
        return ResponseEntity.ok(savedKeyword);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Keyword> updateKeyword(@PathVariable BigInteger id, @RequestBody KeywordDto keywordDto) {
        if (keywordDto.categoryId() != null)
            categoryService.getById(keywordDto.categoryId());
        Keyword updatedKeyword = keywordService.update(id, new Keyword(keywordDto.value(), keywordDto.categoryId()));
        return ResponseEntity.ok(updatedKeyword);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteKeyword(@PathVariable BigInteger id) {
        keywordService.deleteById(id);
        return ResponseEntity.ok("Keyword with ID: " + id + " deleted.");
    }
}
