package net.example.demofinproject.repository.rate;

import net.example.demofinproject.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RateRepository  extends JpaRepository<Rate, Integer> {

    Rate findByRateCode(String rate_code);

}
