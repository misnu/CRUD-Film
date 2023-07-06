/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import controller.koneksi;
import model.Film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class daoFilm implements interfaceFilm {
    
     Connection connection;
    final String insert = "INSERT INTO tbl_film (judul,sinopsis,tahun) VALUES (?, ?, ?);";
    final String update = "UPDATE tbl_film SET judul=?, sinopsis=?, tahun=? WHERE id=? ;";
    final String delete = "DELETE FROM tbl_film WHERE id=? ;";
    final String select = "SELECT * FROM tbl_film ORDER BY id DESC;";
    
    public daoFilm() {
        connection = koneksi.connection();
    }

    @Override
    public void insert(Film film1) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, film1.getJudul());
            statement.setString(2, film1.getSinopsis());
            statement.setInt(3, film1.getTahun());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(Film film1) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, film1.getJudul());
            statement.setString(2, film1.getSinopsis());
            statement.setInt(3, film1.getTahun());
            statement.setInt(4, film1.getId());
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Film> getData() {
        List<Film> listFilm = null;
        try {
            listFilm = new ArrayList<Film>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Film film1 = new Film();
                film1.setId(rs.getInt("id"));
                film1.setJudul(rs.getString("judul"));
                film1.setSinopsis(rs.getString("sinopsis"));
                film1.setTahun(rs.getInt("tahun"));
                listFilm.add(film1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoFilm.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listFilm;
    }
    
}
