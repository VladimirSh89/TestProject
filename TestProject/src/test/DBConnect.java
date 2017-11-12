package test;

import java.sql.*;


public class DBConnect {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	public DBConnect(){
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Database", "root", "");
			st = (Statement) con.createStatement();
			
		} 
		catch (Exception ex)
		{
			System.out.println("Error: " + ex);
		}
	}
	
	public String getUrl(){
		try 
		{
			String query = "Select * from address";
			rs = ((java.sql.Statement) st).executeQuery(query);
			
			String url = "";
			
			while(rs.next())
			{
				url = rs.getString("url");
			}
			return url;
			
		} 
		catch (Exception ex)
		{
			System.out.println("Error: " + ex);
			return "";
		}
	}
	
	public String getData(){
		try {
			String query = "Select * from userinformation";
			rs = ((java.sql.Statement) st).executeQuery(query);
			
			String name = "";
			String password = "";
			
			while(rs.next()){
				name = rs.getString("Login");
				password = rs.getString("Password");
				System.out.println("Login: " + name + " Password: " + password);
			}
			return name+";"+password;
			
		} catch (Exception ex)
		{
			System.out.println("Error: " + ex);
			return "";
		}
	}
	
}
