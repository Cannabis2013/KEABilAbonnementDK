package com.example.keabilabonnement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KeaBilAbonnementApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeaBilAbonnementApplication.class, args);
        /*
            Wait 500 ms to avoid trailing spring messages
         */

        try {
            Thread.sleep(1000);
            ConsoleInformation.Print();
        } catch (InterruptedException e) {
            ConsoleInformation.Print();
        }

    }

}
