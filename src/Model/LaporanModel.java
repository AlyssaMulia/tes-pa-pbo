/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */
import Controller.UserController;
import Database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class LaporanModel {
    private Connection conn;

    public LaporanModel() {
        conn = Database.connect();
    }

    public boolean tambahLaporan(String namaJalan, String kecamatan, String deskripsi, String tingkatKerusakan, String statusLaporan, int userId) {
        // Tambahkan status_laporan di SQL query dan parameter yang sesuai
        String sql = "INSERT INTO laporan (nama_jalan, kecamatan, tanggal_laporan, deskripsi, tingkat_kerusakan, status_laporan, user_id_user) VALUES (?, ?, NOW(),?, ?, ?, ?)";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, namaJalan);
            stmt.setString(2, kecamatan);
            stmt.setString(3, deskripsi);
            stmt.setString(4, tingkatKerusakan);
            stmt.setString(5, statusLaporan);
            stmt.setInt(6, UserController.getCurrentUserId());
            
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
