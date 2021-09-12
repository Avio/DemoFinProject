package net.example.demofinproject.service;

import net.example.demofinproject.exception.ContractNotFoundException;
import net.example.demofinproject.model.ContractDTO;
import net.example.demofinproject.model.ContractEntity;
import net.example.demofinproject.repository.contract.ContractRepository;
import net.example.demofinproject.repository.rate.RateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContractService {

    private final static Logger logger = LoggerFactory.getLogger(ContractService.class);

    private final ContractRepository contractRepository;

    private final RateRepository rateRepository;

    public ContractService(ContractRepository contractRepository, RateRepository rateRepository) {
        this.contractRepository = contractRepository;
        this.rateRepository = rateRepository;
    }

    public List<ContractDTO> getAllContracts() {
        return contractRepository.findAll().stream().map(contractEntity -> fromEntity(contractEntity)).collect(Collectors.toList());
    }
    public ContractDTO getContractByNumber(String number){
        return fromEntity(findOne(number));
    }

    public BigDecimal getContractRevenue (String number){
        BigDecimal result;
        int contractSum = findOne(number).getSum();
        BigDecimal rate = getRateValueByCode(findOne(number).getRate_code());

        return rate.multiply(BigDecimal.valueOf(contractSum));
    }

    private ContractEntity findOne(String number){
        ContractEntity contractEntity = contractRepository.findContractByNumber(number);
        if(contractEntity == null) {
            logger.info("There is no contractEntity with number " + number);
            throw new ContractNotFoundException("There is no contractEntity with number " + number);
        }
        return contractRepository.findContractByNumber(number);
    }

    private BigDecimal getRateValueByCode(String rateCode){
        return rateRepository.findByRateCode(rateCode).getRateValue();
    }

    private ContractDTO fromEntity(ContractEntity contractEntity){
        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setNumber(contractEntity.getNumber());
        contractDTO.setSum(contractEntity.getSum());
        contractDTO.setRate(getRateValueByCode(contractEntity.getRate_code()));
        return contractDTO;
    }
}
