package com.socialmedia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserCRUD implements User1{
	boolean b;

	public void signup(Details d) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "root");
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO USER VALUE (?,?,?,?,?,?,?,?)");
			preparedStatement.setInt(1, d.getId());
			preparedStatement.setString(2, d.getFirst_name());
			preparedStatement.setString(3, d.getLast_name());
			preparedStatement.setString(4, d.getGender());
			preparedStatement.setLong(5, d.getPhone());
			preparedStatement.setString(6, d.getDate_of_birth());
			preparedStatement.setString(7, d.getEmail());
			preparedStatement.setString(8, d.getPassword());

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("REGISTERED SUCCESFULLY NOW YOU CAN LOGIN");
	}

	public boolean login(String email, String password) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "root");
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USER WHERE email_id=?");
			preparedStatement.setString(1, email);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				if (rs.getString(7).equals(email)) {
					if (rs.getString(8).equals(password)) {
						return true;
					} else {
						System.out.println("Wrong password");
					}

				} else
					return false;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;

	}

	public void logout() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "root");
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void status(String email, String status) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "root");

			PreparedStatement ps = connection.prepareStatement("SELECT * from user where email_id=?");
			ps.setString(1, email);
			ResultSet re = ps.executeQuery();
			while (re.next()) {
				PreparedStatement preparedstatement = connection.prepareStatement("INSERT into status values(?,?,?) ");
				preparedstatement.setInt(1, re.getInt(1));
				preparedstatement.setString(2, re.getString(7));
				preparedstatement.setString(3, status);
				preparedstatement.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
