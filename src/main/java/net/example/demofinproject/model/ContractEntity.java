package net.example.demofinproject.model;

import javax.persistence.*;

@Entity
@Table(name = "Contracts")
public class ContractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "sum")
    private int sum;
    @Column(name = "number")
    private String number;
    @Column(name = "rate_code")
    private String rate_code;


    public int getId() {
        return id;
    }

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

    public String getRate_code() {
        return rate_code;
    }

    public void setRate_code(String rate_id) {
        this.rate_code = rate_id;
    }
}
