/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.UserModel;
import Model.Admin;
import Model.Pelapor;
import Database.Database;
import java.sql.*;

/**
 *
 * @author ASUS
 */

public class UserController {
    private Connection conn;

    public UserController() {
        conn = Database.connect();
    }

    public UserModel loginUser(String username, String password, String role) {
        String query;
        // Tentukan query SQL berdasarkan peran (role)
        if ("Admin".equals(role)) {
            query = "SELECT * FROM admin WHERE username = ? AND password = ?";
        } else {
            query = "SELECT * FROM pelapor WHERE username = ? AND password = ?";
        }

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            // Cek jika ada hasil dari query
            if (rs.next()) {
                if ("Admin".equals(role)) {
                    // Login sebagai Admin
                    return new Admin(username, password, rs.getString("hak_akses"));
                } else {
                    // Login sebagai Pelapor
                    return new Pelapor(username, password, rs.getString("nama_pelapor"), rs.getString("nomor_telepon"), rs.getString("email"));
                }
            } else {
                System.out.println("Login gagal: Username atau password salah untuk " + role);
            }
        } catch (SQLException e) {
            System.out.println("Kesalahan SQL saat login: " + e.getMessage());
        }
        
        return null; // Mengembalikan null jika login gagal
    }

    // Metode registrasi untuk Pelapor
    public boolean registerPelapor(Pelapor pelapor) {
        String query = "INSERT INTO pelapor (nama_pelapor, nomor_telepon, email, username, password) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, pelapor.getNama());
            stmt.setString(2, pelapor.getNoTelp());
            stmt.setString(3, pelapor.getEmail());
            stmt.setString(4, pelapor.getUsername());
            stmt.setString(5, pelapor.getPassword());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Registrasi gagal: " + e.getMessage());
            return false;
        }
    }
}