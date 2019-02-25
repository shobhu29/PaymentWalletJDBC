package com.capg.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.capg.beans.Customer;
import com.capg.beans.Wallet;
import com.capg.exceptions.DuplicateMobileNoException;
import com.capg.exceptions.InsufficientBalanceException;
import com.capg.exceptions.InvalidInputGivenException;
import com.capg.repo.WalletRepo;
import com.capg.service.WalletService;
import com.capg.service.WalletServiceImpl;

public class TestClass {
	
	WalletRepo wrepo;

	
	
	@Test(expected = com.capg.exceptions.DuplicateMobileNoException.class)
	public void whenthemobilenumberalreadyexist() throws DuplicateMobileNoException,InvalidInputGivenException,SQLException,ClassNotFoundException {
		
		String mobileno = "9711377939";
		String name = "shobhit";
		Wallet wallet = new Wallet(BigDecimal.valueOf(2000));
		BigDecimal balance = wallet.getBalance();
		WalletService ws = new WalletServiceImpl();
		ws.createAccount(name, mobileno,balance);
				
	}
	
	@Test
	public void whenallthedetailsarevalid() throws InvalidInputGivenException,DuplicateMobileNoException,SQLException,ClassNotFoundException {
		
		Wallet wallet = new Wallet(BigDecimal.valueOf(2000));
		BigDecimal balance = wallet.getBalance();
		WalletService ws = new WalletServiceImpl();
		Customer cust = ws.createAccount("santosh","9811210939",balance);
		assertEquals(cust.getMobileno(),"9811210939");
	}

	
	@Test(expected = com.capg.exceptions.InvalidInputGivenException.class)
	public void whenthecustomernameisnotvalid() throws InvalidInputGivenException {
		
		String name="aaaa12@";
		WalletService ws = new WalletServiceImpl();
		boolean result = ws.ValidateName(name);
		assertEquals(false, result);
	}
	
	@Test(expected = com.capg.exceptions.InvalidInputGivenException.class)
	public void whenthecustomermobilenoisnotvalid() throws InvalidInputGivenException {
		String name="0123456789";
		WalletService ws = new WalletServiceImpl();
		boolean result=ws.ValidateMobileno(name);
		assertEquals(false, result);	
	}
	
	@Test
	public void whenthecustomermobilenumberisvalid() throws InvalidInputGivenException {
		String name="9540612658";
		WalletService ws = new WalletServiceImpl();
		boolean result = ws.ValidateMobileno(name);
		assertEquals(true, result);	
	}	
	
	@Test
	public void whentheamountgivenisvalid() throws InvalidInputGivenException {
		BigDecimal balance = new BigDecimal(10000);
		WalletService ws = new WalletServiceImpl();
		boolean result = ws.ValidateBalance(balance);
		assertEquals(true, result);
	}
	
//	@Test
//	public void whentheamountgivenisnotvalid() throws InvalidInputGivenException {
//		Wallet wallet = new Wallet(BigDecimal.valueOf(0));
//		BigDecimal balance = wallet.getBalance();
//		WalletService ws = new WalletServiceImpl();
//		ws.ValidateBalance(balance);
//	}
//	
	@Test
	public void whenthecurrentbalanceislessthanwithdrawlbalance() throws SQLException,ClassNotFoundException ,InvalidInputGivenException,InsufficientBalanceException{
		WalletService ws = new WalletServiceImpl();
		ws.withdrawAmount("9711377939", BigDecimal.valueOf(300));
		
	}
	
	
}
