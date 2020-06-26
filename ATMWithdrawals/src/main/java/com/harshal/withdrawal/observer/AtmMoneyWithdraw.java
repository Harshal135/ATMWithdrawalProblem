package com.harshal.withdrawal.observer;
import com.harshal.withdraw.ATMMoney;
import com.harshal.withdraw.WithdrawSubject;


public class AtmMoneyWithdraw extends Observer{
    
	public AtmMoneyWithdraw(WithdrawSubject withdrawSubject) {
		this.wsubject = withdrawSubject;
		this.wsubject.attach(this);
	}
	
	@Override
	public void updateWithdrawalObs(String msg) {
		// TODO Auto-generated method stub
		System.out.println(msg);
		
	}

}
