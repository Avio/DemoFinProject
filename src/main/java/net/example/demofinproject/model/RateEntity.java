package net.example.demofinproject.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Rates")
public class RateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "r_value")
    private BigDecimal rateValue;
    @Column(name = "r_code")
    private String rateCode;

    public int getId() {
        return id;
    }

    public BigDecimal getRateValue() {
        return rateValue;
    }

    public void setRateValue(BigDecimal rate_value) {
        this.rateValue = rate_value;
    }

    public String getRateCode() {
        return rateCode;
    }

    public void setRateCode(String rate_code) {
        this.rateCode = rate_code;
    }
}
