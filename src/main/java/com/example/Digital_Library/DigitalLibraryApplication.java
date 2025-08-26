package com.example.Digital_Library;

import com.example.Digital_Library.repository.TxnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DigitalLibraryApplication implements CommandLineRunner {

	@Autowired
	private TxnRepository txnRepository;

	public static void main(String[] args) {

		SpringApplication.run(DigitalLibraryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		txnRepository.updateExistingTxn();
//		txnRepository.upd~ateBook();
		System.out.println("My Application has Started!");
	}
}
