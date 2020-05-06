package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Nurse {

	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/nurse_management", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String readNurse()
	{
		String output = "";
		
		try
		{
			Connection con = connect();
			if (con == null)
			{
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border='1'><th>Nurse Name</th><th>Nurse Age</th><th>Nurse TelePhone</th><th>Nurse Email</th><th>Nurse Ward</th><th>Update</th><th>Remove</th></tr>";
			
			String query = "select * from nurse";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
	 
			// iterate through the rows in the result set
			while (rs.next())
			{
				String nurse_id = Integer.toString(rs.getInt("nurse_id"));
				String nurse_name = rs.getString("nurse_name");
				String nurse_age = Integer.toString(rs.getInt("nurse_age"));
				String nurse_tele = Integer.toString(rs.getInt("nurse_tele"));		
				String nurse_email = rs.getString("nurse_email"); 
				String nurse_ward = rs.getString("nurse_ward"); 
	
				// Add into the html table
				output += "<tr><td><input id='hidnurse_idUpdate'name='hidnurse_idUpdate' type='hidden'value='" + nurse_id + "'>" + nurse_name + "</td>";
				output += "<td>" + nurse_age + "</td>";
				output += "<td>" + nurse_tele + "</td>";
				output += "<td>" + nurse_email + "</td>";
				output += "<td>" + nurse_ward + "</td>";
	
				// buttons
				output += "<td><input name='btnUpdate' type='button'value='Update' class='btnUpdate btn btn-secondary'></td><td><input name='btnRemove' type='button'value='Remove'class='btnRemove btn btn-danger' data-nurseid='"
						+ nurse_id + "'></td></tr>";
			}
	 
			con.close();
	 
			// Complete the html table
	 
			output += "</table>";
	 }
	catch (Exception e)
	 {
	 output = "Error while reading the Nurse details.";
	 System.err.println(e.getMessage());
	 }
	return output;
	}
	
	public String insertNurse(String name, String age, String tele, String email, String ward) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into nurse(nurse_id, nurse_name, nurse_age, nurse_tele, nurse_email, nurse_ward)"
					+ " values (?, ?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, name);
			preparedStmt.setInt(3, Integer.parseInt(age));
			preparedStmt.setInt(4, Integer.parseInt(tele));
			preparedStmt.setString(5, email);	
			preparedStmt.setString(6, ward);
			
			// execute the statement
			preparedStmt.execute();
			con.close();
			
			//output = "Inserted successfully";
			
			String newNurse = readNurse();
			 output = "{\"status\":\"success\", \"data\": \"" +
					 newNurse + "\"}"; 
			 
			 
		} catch (Exception e) {
		//	output = "Error while inserting the nurse details.";
			output = "{\"status\":\"error\", \"data\": \"Error while inserting the Nurse details.\"}"; 
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	public String updateNurse(String id, String name, String age, String tele, String email, String ward) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			
			
			// create a prepared statement
			String query = "UPDATE nurse SET nurse_name=?, nurse_age=?, nurse_tele=? ,nurse_email=?, nurse_ward=? WHERE nurse_id=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, name);
			preparedStmt.setInt(2, Integer.parseInt(age));
			preparedStmt.setInt(3, Integer.parseInt(tele));
			preparedStmt.setString(4, email);
			preparedStmt.setString(5, ward);
			preparedStmt.setInt(6, Integer.parseInt(id));
			// execute the statement
			preparedStmt.execute();
			con.close();
			//output = "Updated successfully";
			String newNurse = readNurse();
			 output = "{\"status\":\"success\", \"data\": \"" + newNurse + "\"}"; 
		} catch (Exception e) {
			//output = "Error while updating the Nurse details.";
			output = "{\"status\":\"error\", \"data\": \"Error while updating the Nurse details.\"}"; 
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteNurse(String id) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from nurse where nurse_id =?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(id));
			// execute the statement
			preparedStmt.execute();
			con.close();
			//output = "Deleted successfully";
			String newNurse = readNurse();
			 output = "{\"status\":\"success\", \"data\": \"" +
					 newNurse + "\"}"; 
		} catch (Exception e) {
			//output = "Error while deleting the nurse details.";
			output = "{\"status\":\"error\", \"data\": \"Error while deleting the nurse details.\"}"; 
			System.err.println(e.getMessage());
		}
		return output;
	}
}