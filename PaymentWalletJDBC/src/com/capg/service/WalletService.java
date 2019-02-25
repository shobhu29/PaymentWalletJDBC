package com.capg.service;

import java.math.BigDecimal;
import java.sql.SQLException;

import com.capg.beans.Customer;
import com.capg.exceptions.DuplicateMobileNoException;
import com.capg.exceptions.InsufficientBalanceException;
import com.capg.exceptions.InvalidInputGivenException;

public interface WalletService {

	public Customer createAccount(String name, String mobileno, BigDecimal balance) throws SQLException,InvalidInputGivenException,DuplicateMobileNoException, ClassNotFoundException;

	public Customer showBalance(String mobileno) throws InvalidInputGivenException,SQLException,ClassNotFoundException;

	public Customer fundTransfer(String sourcemobileno, String targetmobileno, BigDecimal balance) throws ClassNotFoundException,SQLException,InvalidInputGivenException;

	public Customer depositAmount(String mobileno, BigDecimal amount) throws ClassNotFoundException,SQLException,InvalidInputGivenException;

	public Customer withdrawAmount(String mobileno, BigDecimal amount) throws ClassNotFoundException,SQLException,InsufficientBalanceException,InvalidInputGivenException;
	
	public boolean ValidateName(String name) throws InvalidInputGivenException;

	public boolean ValidateMobileno(String mobileno) throws InvalidInputGivenException;

	public boolean ValidateBalance(BigDecimal balance) throws InvalidInputGivenException;

}