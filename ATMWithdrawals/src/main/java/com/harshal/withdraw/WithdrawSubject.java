package com.harshal.withdraw;
import java.util.ArrayList;
import java.util.List;
import com.harshal.*;
import com.harshal.withdrawal.observer.Observer;


public class WithdrawSubject {
	
	private Observer observer;
	
	ATMMoney atmMoney;

	public String withdraw(int money) {
		int availableMoney = this.atmMoney.getTotalMoney();
		int multiTen = money%10;
		if(multiTen!=0) {
			String msg="Enter the amount which is multiple of 10";
			notifyAllObservers(msg);
			return msg;
		}else if(money<=availableMoney) {
		String msg = this.atmMoney.withdraw(money);
		notifyAllObservers(msg);
		return msg;
		}else {
			String msg="No sufficient cash available in ATM";
			notifyAllObservers(msg);
			return msg;
		}
		
	}

	public WithdrawSubject(ATMMoney atmMoney) {
		super();
		this.atmMoney = atmMoney;
	}

	public void attach(Observer observer){
	      this.observer = observer;		
	   }

	   public void notifyAllObservers(String msg){
	     
	         observer.updateWithdrawalObs(msg);
	      
	   } 	
}
