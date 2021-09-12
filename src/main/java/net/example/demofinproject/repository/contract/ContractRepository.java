package net.example.demofinproject.repository.contract;


import net.example.demofinproject.model.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<ContractEntity, Integer>{

    ContractEntity findContractByNumber(String number);

}
