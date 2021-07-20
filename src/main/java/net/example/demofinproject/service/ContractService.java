package net.example.demofinproject.service;

import net.example.demofinproject.model.Contract;
import net.example.demofinproject.repository.contract.ContractRepository;
import net.example.demofinproject.repository.rate.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContractService {

    private ContractRepository contractRepository;

    private RateRepository rateRepository;

    public ContractService(ContractRepository contractRepository, RateRepository rateRepository){
        this.contractRepository = contractRepository;
        this.rateRepository = rateRepository;
    }

    public Contract getContractByNumber(String number){
        return contractRepository.findContractByNumber(number);
    }

    public BigDecimal getContractRevenue (String number){
        int contractSum = getContractByNumber(number).getSum();

        BigDecimal rate = rateRepository.findByRateCode(getContractByNumber(number).getRate_code()).getRateValue();

        return rate.multiply(BigDecimal.valueOf(contractSum));
    }


}
