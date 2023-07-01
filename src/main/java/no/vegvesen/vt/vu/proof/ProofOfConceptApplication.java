package no.vegvesen.vt.vu.proof;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ProofOfConceptApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProofOfConceptApplication.class, args);
    }

}
