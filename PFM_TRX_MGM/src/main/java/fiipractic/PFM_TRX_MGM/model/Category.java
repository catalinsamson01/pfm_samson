package fiipractic.PFM_TRX_MGM.model;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "pfm_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private String value;
    private BigInteger parentId;

    public Category() {
    }

    public Category(String value, BigInteger parentId) {
        this.value = value;
        this.parentId = parentId;
    }

    public BigInteger getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public BigInteger getParentId() {
        return parentId;
    }

    public void setParentId(BigInteger parentId) {
        this.parentId = parentId;
    }
}
