//$Id$
package com.jdbcimplementation;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import static java.lang.System.*;

public class JdbcCoonection {
	public static void main(String[] args) {
		Connection connection = null;
		String url = "jdbc:mysql://localhost:3306/booksdata?verifyServerCertificate=false&useSSL=false";
		String userName = "root";
		String passwd = "";
		try{
			connection = DriverManager.getConnection(url,userName,passwd);
			Statement stm = connection.createStatement();
			String query = "select * from Customer";
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()){
				out.print(rs.getInt("CustomerID")+" ");
				out.print(rs.getString("FirstName")+" ");
				out.print(rs.getString("LastName")+" ");
				out.print(rs.getString("EMail")+" ");
				out.println(rs.getString("Phone")+" ");
			}
		}catch(SQLException e){
			out.println(e.getMessage());
			
		}
	}

}
