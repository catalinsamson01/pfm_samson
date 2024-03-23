package fiipractic.PFM_TRX_MGM.model;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "pfm_keyword")
public class Keyword {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private BigInteger id;
        private String value;

        private BigInteger categoryId;

        public Keyword() {
        }

        public Keyword(String value, BigInteger categoryId) {
                this.value = value;
                this.categoryId = categoryId;
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

        public BigInteger getCategoryId() {
                return categoryId;
        }

        public void setCategoryId(BigInteger categoryId) {
                this.categoryId = categoryId;
        }
}
