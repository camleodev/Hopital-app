package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.PatientRepository;

@SpringBootApplication
public class HopitalApplication implements CommandLineRunner{
	@Autowired
	private PatientRepository patientRepository;
	public static void main(String[] args) {
		SpringApplication.run(HopitalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		patientRepository.save(new Patient(null,"Jean", new Date(), true,134));
//		patientRepository.save(new Patient(null,"Anne", new Date(), true,124));
//		patientRepository.save(new Patient(null,"Marie", new Date(), false,144));
	
	}
}
