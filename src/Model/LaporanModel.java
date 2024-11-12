/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */
import Database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LaporanModel {
    private Connection conn;

    public LaporanModel() {
        conn = Database.connect();
    }

    public boolean simpanLaporan(String namaJalan, String kecamatan, String tingkatKerusakan, String deskripsi, String tanggalLaporan) {
        String query = "INSERT INTO laporan (nama_jalan, kecamatan, tingkat_kerusakan, deskripsi, tanggal_laporan) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, namaJalan);
            stmt.setString(2, kecamatan);
            stmt.setString(3, tingkatKerusakan);
            stmt.setString(4, deskripsi);
            stmt.setString(5, tanggalLaporan);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Gagal menyimpan laporan: " + e.getMessage());
            return false;
        }
    }
}

