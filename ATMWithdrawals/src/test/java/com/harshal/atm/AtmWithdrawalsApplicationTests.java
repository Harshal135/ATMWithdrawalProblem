package com.harshal.atm;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.harshal.withdraw.ATMMoney;
import com.harshal.withdraw.WithdrawSubject;
import com.harshal.withdrawal.observer.AtmMoneyWithdraw;

@SpringBootTest
class AtmWithdrawalsApplicationTests {

	@Test
	void contextLoads() {
		
		WithdrawSubject wwSubject = new WithdrawSubject(new ATMMoney(50, 10));
		new AtmMoneyWithdraw(wwSubject);
		wwSubject.withdraw(20000);
		wwSubject.withdraw(3000);
		
	}

}
