package net.example.demofinproject.model;

import java.math.BigDecimal;

public class ContractDTO {

    private String number;
    private int sum;
    private BigDecimal rate;


    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
