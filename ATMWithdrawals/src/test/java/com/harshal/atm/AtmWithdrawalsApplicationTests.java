package com.harshal.atm;

import static org.assertj.core.api.Assertions.assertThat;

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
		//wwSubject.withdraw(20000);
		
	}
	
	@Test
	void validMoneyWithdrawalwithMinimumNotesTestCase() throws Exception{
		String expectedResult ="Amount - 3000 withdrawn ,with minimum note -3";
		WithdrawSubject wwSubject = new WithdrawSubject(new ATMMoney(50, 10));
		new AtmMoneyWithdraw(wwSubject);
		String currentResult = wwSubject.withdraw(3000);
		assertThat(currentResult).isEqualTo(expectedResult);
		
		
	}
	
	@Test
	void validMoneyWithdrawalwithMinimumNotesNegativeTestCase() throws Exception{
		String expectedResult ="Amount - 3000 withdrawn ,with minimum note -4";
		WithdrawSubject wwSubject = new WithdrawSubject(new ATMMoney(50, 10));
		new AtmMoneyWithdraw(wwSubject);
		String currentResult = wwSubject.withdraw(3000);
		assertThat(currentResult).isNotEqualTo(expectedResult);
		
		
	}
	
	@Test
	void amountMultipleofTenTestCase() throws Exception{
		String expectedResult ="Enter the amount which is multiple of 10";
		WithdrawSubject wwSubject = new WithdrawSubject(new ATMMoney(50, 10));
		new AtmMoneyWithdraw(wwSubject);
		String currentResult = wwSubject.withdraw(3005);
		assertThat(currentResult).isEqualTo(expectedResult);
		
		
	}
	
	@Test
	void amountMultipleofTenNegativeTestCase() throws Exception{
		String expectedResult ="Enter the amount which is multiple of 10";
		WithdrawSubject wwSubject = new WithdrawSubject(new ATMMoney(50, 10));
		new AtmMoneyWithdraw(wwSubject);
		String currentResult = wwSubject.withdraw(30000);
		assertThat(currentResult).isNotEqualTo(expectedResult);
		
		
	}
	
	@Test
	void noSufficientCashTestCase() throws Exception{
		String expectedResult ="No sufficient cash available in ATM";
		WithdrawSubject wwSubject = new WithdrawSubject(new ATMMoney(50, 10));
		new AtmMoneyWithdraw(wwSubject);
		String currentResult = wwSubject.withdraw(100000);
		assertThat(currentResult).isEqualTo(expectedResult);
		
		
	}
	
	@Test
	void noSufficientCashNegativeTestCase() throws Exception{
		String expectedResult ="No sufficient cash available in ATM";
		WithdrawSubject wwSubject = new WithdrawSubject(new ATMMoney(50, 10));
		new AtmMoneyWithdraw(wwSubject);
		String currentResult = wwSubject.withdraw(5000);
		assertThat(currentResult).isNotEqualTo(expectedResult);
		
	}
	

}
