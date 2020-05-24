package at.htlle.test.sqlite;

import org.sqlite.JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    Connection con = null;
    try {
      Class.forName("org.sqlite.JDBC");
      con = DriverManager.getConnection("jdbc:sqlite:./resources/student-organizer.db");
      System.out.println("Connection successful!");

      PreparedStatement prepStmt = con.prepareStatement("Select kuerzel from Faecher");
      ResultSet res = prepStmt.executeQuery();


      while (res.next()) {
        System.out.println("Kuerzel: " + res.getString(1));
      }
    } catch(ClassNotFoundException ex) {
      System.out.println("Class Not Found");
    } catch(SQLException sqlEx) {
      System.out.println("SQL Exception: " + sqlEx.getMessage());
    }
   
  }
}