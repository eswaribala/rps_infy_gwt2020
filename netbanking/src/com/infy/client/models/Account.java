package com.infy.client.models;

import java.io.Serializable;

public class Account implements Serializable {

	private long accountNo;
	private long balance;
	private AccountType account_Type;
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public AccountType getAccount_Type() {
		return account_Type;
	}
	public void setAccount_Type(AccountType account_Type) {
		this.account_Type = account_Type;
	}
	
	
}
