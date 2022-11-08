package de.whitefallen.springloginexample;

import de.whitefallen.springloginexample.domain.Role;
import de.whitefallen.springloginexample.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringLoginExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringLoginExampleApplication.class, args);
    }

    @Bean
    CommandLineRunner init(RoleRepository roleRepository) {

        return args -> {

            Role adminRole = roleRepository.findByName("ADMIN");
            if (adminRole == null) {
                Role newAdminRole = new Role();
                newAdminRole.setName("ADMIN");
                roleRepository.save(newAdminRole);
            }

            Role userRole = roleRepository.findByName("USER");
            if (userRole == null) {
                Role newUserRole = new Role();
                newUserRole.setName("USER");
                roleRepository.save(newUserRole);
            }
        };

    }

}
