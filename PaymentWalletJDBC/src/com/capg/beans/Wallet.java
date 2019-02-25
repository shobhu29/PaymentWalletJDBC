package com.capg.beans;

import java.math.BigDecimal;

public class Wallet {

		private BigDecimal balance;

		public Wallet(BigDecimal balance) {											// PARAMETERIZED CONSTRUCTOR
			super();
			this.balance = balance;
		}

		public BigDecimal getBalance() {											// GETTER AND SETTER METHODS
			return balance;
		}

		public void setBalance(BigDecimal balance) {
			this.balance = balance;
		}
																					// OBJECT REPRESENTATION OF STRING
		@Override
		public String toString() {
			return "Wallet [balance=" + balance + "]";
		}
		
		
}
