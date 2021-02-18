package com.example.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
public class  ReadingData{
		public static void updateEmployee() throws NumberFormatException, IOException{
			Connection con = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1","root","upendar@1234");
				PreparedStatement ps=con.prepareStatement("insert into mydb1.employe values(?,?,?,?,?)");
				BufferedReader in =new BufferedReader(new FileReader ("D:/upendar.csv"));
				String line;
				while((line=in.readLine())!=null) {
				String [] data=line.split(",");
				int id=Integer.parseInt(data[0]);
				String name=data[1];
				String email=data[2];
				String contact=data[3];
				String course=data[4];
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setString(3, email);
				ps.setString(4,contact);
				ps.setString(5,course);
				ps.executeUpdate();
				}
		
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		
		/**public static void getEmployee(){
			Connection con = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","upendar@1234");
				PreparedStatement ps=con.prepareStatement("select * from mydb.employee where id=11");
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" "+rs.getString(3));
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}

	}**/

}
