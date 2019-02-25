package com.capg.repo;

import java.math.BigDecimal;
import java.sql.SQLException;

import com.capg.beans.Customer;

public interface WalletRepo {

	public boolean save(Customer customer) throws SQLException,ClassNotFoundException;
	public Customer findCustomer(String mobileno) throws SQLException,ClassNotFoundException;
	public void fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal balance,BigDecimal balance1);
	public void update(String mobileno,BigDecimal amount);

}
