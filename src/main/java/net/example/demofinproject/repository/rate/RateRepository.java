package net.example.demofinproject.repository.rate;

import net.example.demofinproject.model.RateEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RateRepository  extends JpaRepository<RateEntity, Integer> {

    RateEntity findByRateCode(String rate_code);

}
