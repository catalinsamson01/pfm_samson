package fiipractic.PFM_TRX_MGM.repository;

import fiipractic.PFM_TRX_MGM.model.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface KeywordRepo extends JpaRepository<Keyword, Integer> {
    Optional<Keyword> findById(BigInteger id);

    void deleteById(BigInteger id);
}
