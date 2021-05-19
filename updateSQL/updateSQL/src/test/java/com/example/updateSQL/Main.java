package com.example.updateSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.deleteSQL.DbHelper;

public class Main {
	public static void main(String[] args) throws SQLException {
		
		Connection connection = null;
		DbHelper dbHelper = new DbHelper();
		Statement statement= null;
		ResultSet resultSet;
		PreparedStatement preparedStatement = null;

		try {
			connection = dbHelper.getConnection();
			String sql = "update musteri set soyad='Çınar', bakiye=3500 where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 13); 
			int result = preparedStatement.executeUpdate();
			System.out.println("Kayit güncellendi");
		}catch(SQLException sqlException) {
			dbHelper.showErrorMessage(sqlException);
		}finally {
			preparedStatement.close();
			connection.close();
		}
		
	}
}