package fiipractic.PFM_TRX_MGM.repository;

import fiipractic.PFM_TRX_MGM.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
    Optional<Category> findById(BigInteger id);

    void deleteById(BigInteger id);
}
