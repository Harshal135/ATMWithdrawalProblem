package com.harshal.withdraw;

import org.springframework.stereotype.Component;


public class ATMMoney {
      private volatile int fiveHundreadNotes=100;
      private volatile int twoThousandNotes=50;
      private volatile int total=0; 
      private int noteCount;
	public ATMMoney(int fiveHundreadNotes, int twoThousandNotes) {
		super();
		this.fiveHundreadNotes = fiveHundreadNotes;
		this.twoThousandNotes = twoThousandNotes;
	}
	
	public synchronized String  withdraw(int amount) {
		int twoThousandDiv = (amount/2000);
		int twoThousandRemind = (amount%2000);
		noteCount=0;
		if(twoThousandRemind==0 && twoThousandDiv<=twoThousandNotes) {
			twoThousandNotes= twoThousandNotes-twoThousandDiv;
			noteCount=twoThousandDiv;
			return "Amount - "+amount+ " withdrawn ,with minimum note -"+noteCount;
			
		}else if(twoThousandNotes!=0 && twoThousandRemind!=0 ) {
			int fiveHundreadDiv = (twoThousandRemind/500);
			int fiveHundreadRemind = (twoThousandRemind%500);
			if(fiveHundreadRemind==0) {
				twoThousandNotes= twoThousandNotes-twoThousandDiv;
				fiveHundreadNotes=fiveHundreadNotes-fiveHundreadDiv;
				noteCount=twoThousandDiv+fiveHundreadDiv;
				return "Amount - "+amount+ " withdrawn ,with minimum note -"+noteCount;
			}else {
				return "Cant withdraw the amount as its not multiple of 1000 and 500 combinely";
			}
		}else{
			int fiveHundreadDiv = (amount/500);
			int fiveHundreadRemind = (twoThousandRemind%500);
			if(fiveHundreadRemind==0) {
				fiveHundreadNotes=fiveHundreadNotes-fiveHundreadDiv;
				noteCount=fiveHundreadDiv;
				return "Amount - "+amount+ " withdrawn ,with minimum note - "+noteCount;
			}else {
				return "Enter the amount which is multiple of 500";
			}
		}

	}
      
	public int getTotalMoney() {
		total = 0;
		total=(twoThousandNotes*2000)+(fiveHundreadNotes*500);
		return total;
	}
}
