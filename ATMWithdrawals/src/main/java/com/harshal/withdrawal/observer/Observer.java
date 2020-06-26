package com.harshal.withdrawal.observer;
import com.harshal.withdraw.WithdrawSubject;

public abstract class Observer {
	protected WithdrawSubject wsubject;
	public abstract void updateWithdrawalObs(String msg);
}
