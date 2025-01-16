package com.trade_ham;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TradeHamApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradeHamApplication.class, args);
    }

}
