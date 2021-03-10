package Model;

import Controller.DatabaseController;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseModel {
    public void createDatabase() throws SQLException{
        try{
            String sql = "CREATE DATABASE IF NOT EXISTS event DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci";
            PreparedStatement pstmt = DatabaseController.preConnect().prepareStatement(sql);
            pstmt.execute();
        }catch (Exception error){
            System.out.println(error.getMessage());
        }
    }

    public void createTableUsers() throws SQLException{
        try {
            String sql = "CREATE TABLE IF NOT EXISTS users (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    " name VARCHAR(50) NULL, room1 VARCHAR(50) NULL, room2 VARCHAR(50) NULL," +
                    " coffee1 VARCHAR (50) NULL, coffee2 VARCHAR(50) NULL)";
            PreparedStatement pstmt = DatabaseController.connect().prepareStatement(sql);
            pstmt.execute();
        }catch (Exception error){
            System.out.println(error.getMessage());
        }
    }

    public void createTableRooms() throws SQLException{
        try {
            String sql = "CREATE TABLE IF NOT EXISTS rooms (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    " name VARCHAR(50) NULL, capacity INT NOT NULL)";
            PreparedStatement pstmt = DatabaseController.connect().prepareStatement(sql);
            pstmt.execute();
        }catch (Exception error){
            System.out.println(error.getMessage());
        }
    }

    public void createTableCoffee() throws SQLException{
        try {
            String sql = "CREATE TABLE IF NOT EXISTS coffee (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    " name VARCHAR(50) NOT NULL)";
            PreparedStatement pstmt = DatabaseController.connect().prepareStatement(sql);
            pstmt.execute();
        }catch (Exception error){
            System.out.println(error.getMessage());
        }
    }
}
