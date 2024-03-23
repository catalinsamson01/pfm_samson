package fiipractic.PFM_TRX_MGM.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "pfm_trx")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "date", updatable = false)
    private Date date;
    private Double amount;
    private BigInteger categoryId;
    private BigInteger keywordId;
    private BigInteger parentId;
    String description;


    public Transaction() {
    }

    public Transaction(Double amount, BigInteger categoryId, BigInteger keywordId, BigInteger parentId, String description) {
            this.amount = amount;
            this.categoryId = categoryId;
            this.keywordId = keywordId;
            this.parentId = parentId;
            this.description = description;
    }

    public BigInteger getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public BigInteger getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(BigInteger categoryId) {
        this.categoryId = categoryId;
    }

    public BigInteger getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(BigInteger keywordId) {
        this.keywordId = keywordId;
    }

    public BigInteger getParentId() {
        return parentId;
    }

    public void setParentId(BigInteger parentId) {
        this.parentId = parentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
