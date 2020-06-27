package com.harshal.atm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.harshal.withdraw.ATMMoney;
import com.harshal.withdraw.WithdrawSubject;
import com.harshal.withdrawal.observer.AtmMoneyWithdraw;

/**
 * @author - Harshal Sonawane
 *Assuming that ATM uses only 2000 and 500 notes and setting note counts from constructor.
 * 
 */
@SpringBootApplication
public class AtmWithdrawalsApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(AtmWithdrawalsApplication.class, args);
		/*Assuming that ATM uses only 2000 and 500 notes and setting note counts from
		constructor.*/
		WithdrawSubject wwSubject = new WithdrawSubject(new ATMMoney(50, 10));
		
		
		new AtmMoneyWithdraw(wwSubject);
		
		wwSubject.withdraw(2000);
		wwSubject.withdraw(3000);
		
	}

}
