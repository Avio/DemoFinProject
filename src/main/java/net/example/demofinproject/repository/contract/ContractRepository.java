package net.example.demofinproject.repository.contract;


import net.example.demofinproject.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Integer>{

    Contract findContractByNumber(String number);

}
