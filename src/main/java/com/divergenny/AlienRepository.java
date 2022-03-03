package com.divergenny;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlienRepository {

    private Connection con = null;

    public AlienRepository() {
        String url = "jdbc:mysql://localhost:3306/restdb?useSSL=false&serverTimezone=Asia/Shanghai";
        String username = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            String sqlSetTimeZone = "SET GLOBAL time_zone = '+5:00';";
            Statement st = con.createStatement();
            st.executeQuery(sqlSetTimeZone);
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public List<Alien> getAliens() {
        List<Alien> aliens = new ArrayList<>();
        String sql = "select * from alien";
        try {
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery(sql);
            while (resultSet.next()) {
                Alien a = new Alien();
                a.setId(resultSet.getInt(1));
                a.setName(resultSet.getString(2));
                a.setPoints(resultSet.getInt(3));
                aliens.add(a);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return aliens;
    }

    public Alien getAlien(int id) {
        List<Alien> aliens = new ArrayList<>();
        String sql = "select * from alien where id=" + id;
        Alien a = new Alien();
        try {
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery(sql);
            if (resultSet.next()) {
                a.setId(resultSet.getInt(1));
                a.setName(resultSet.getString(2));
                a.setPoints(resultSet.getInt(3));
                aliens.add(a);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return a;
    }

    public void create(Alien a1) {
        String sql = "insert into alien values(?,?,?)";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, a1.getId());
            st.setString(2, a1.getName());
            st.setInt(3, a1.getPoints());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
