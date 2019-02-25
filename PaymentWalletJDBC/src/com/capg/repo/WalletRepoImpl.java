package com.capg.repo;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.capg.beans.Customer;
import com.capg.beans.Wallet;
import com.capg.util.ConnectionUtil;

public class WalletRepoImpl implements WalletRepo{
	
	Connection conn ;

	public WalletRepoImpl() {
		super();
		conn = ConnectionUtil.getConnection();
	}

	
		@Override
		public boolean save(Customer customer) throws SQLException,ClassNotFoundException{
			
			try{
				
				
				PreparedStatement ps = conn.prepareStatement("insert into Customer (name,mobileno,balance) values(?,?,?)");
				ps.setString(1,customer.getName());
				ps.setString(2, customer.getMobileno());
				ps.setBigDecimal(3, customer.getWallet().getBalance());
				ps.executeUpdate();
				conn.commit();
				return true;
			}
			catch(SQLException se){
				
				System.out.println(" SQL EXception raised in SaveCustomer ");
				
			}
				return false;
			
		}
		
		@Override
		public Customer findCustomer(String mobileno) throws SQLException,ClassNotFoundException{
			
			try{
			
				
				Statement stmt = conn.createStatement();
				ResultSet rset = stmt.executeQuery("select * from Customer where mobileno=" + mobileno);
				Customer cust = null;

				if(rset.next()){

					cust = new Customer(rset.getString(1),rset.getString(2),new Wallet(rset.getBigDecimal(3)));
				}
				
				return cust;

				}catch(SQLException se){
					
					System.out.println(" SQL EXception raised in findCustomer ");
				}
			
				return null;
		}
		
		@Override
		public void fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount,BigDecimal amount1) {
			
			try {
				 
		        Statement stmt = conn.createStatement();  
		        
		        stmt.executeUpdate("update customer set balance = " + amount + " where mobileno = " + sourceMobileNo);
		        stmt.executeUpdate("update customer set balance = " + amount1 + " where mobileno = " + targetMobileNo);
		        conn.commit();
			}catch(SQLException e) {System.out.println(e);}
		}
		
		
		
		
		public void update(String mobileno,BigDecimal amount) {
			
			
			try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("update customer set balance = " + amount + " where mobileno = " + mobileno);
			conn.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("SQL exception in update");
			}
			
			
			
			
			
		}
		
}
