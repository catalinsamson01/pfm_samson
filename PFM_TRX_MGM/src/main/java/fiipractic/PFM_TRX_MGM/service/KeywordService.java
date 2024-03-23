package fiipractic.PFM_TRX_MGM.service;

import fiipractic.PFM_TRX_MGM.exceptions.NotFoundException;
import fiipractic.PFM_TRX_MGM.model.Keyword;
import fiipractic.PFM_TRX_MGM.repository.KeywordRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class KeywordService {

    private final KeywordRepo keywordRepo;

    public KeywordService(KeywordRepo keywordRepo) {
        this.keywordRepo = keywordRepo;
    }

    public List<Keyword> getAll() {
        return keywordRepo.findAll();
    }

    public Keyword getById(BigInteger id) {
        return keywordRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Keyword with ID: " + id + " not found."));
    }

    public Keyword save(Keyword keyword) {
        return keywordRepo.save(keyword);
    }

    public Keyword update(BigInteger id, Keyword keyword) {
        Keyword existingKeyword = getById(id);
        existingKeyword.setValue(keyword.getValue());
        existingKeyword.setCategoryId(keyword.getCategoryId());
        return keywordRepo.save(existingKeyword);
    }

    @Transactional
    public void deleteById(BigInteger id) {
        keywordRepo.deleteById(id);
    }
}
