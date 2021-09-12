package net.example.demofinproject.controller;

import net.example.demofinproject.model.ContractDTO;
import net.example.demofinproject.service.ContractService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/contracts")
public class ContractController {

    final ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping
    List<ContractDTO> getAllContracts() {
        return contractService.getAllContracts();
    }

    @GetMapping(value = "/contract/{id}", produces = "application/json")
    public ContractDTO getContractByNumber(@PathVariable("id") String id){
        return contractService.getContractByNumber(id);
    }

    @GetMapping(value = "/contract/{id}/revenue", produces = "application/json")
    public BigDecimal getContractRevenue(@PathVariable("id") String id){
        return contractService.getContractRevenue(id);
    }
}
