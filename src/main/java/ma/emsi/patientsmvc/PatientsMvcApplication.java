package ma.emsi.patientsmvc;

import ma.emsi.patientsmvc.entities.Patient;
import ma.emsi.patientsmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null, "walid", new Date(), true,196));
            patientRepository.save(new Patient(null, "Marouane", new Date(), false,374));
            patientRepository.save(new Patient(null, "walid2", new Date(), true,265));
            patientRepository.save(new Patient(null, "walid3", new Date(), true,152));

            patientRepository.findAll().forEach(p -> {
                System.out.println(p.getNom());
            });
        };
    }
}
