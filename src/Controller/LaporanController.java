/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author ASUS
 */
import Model.LaporanModel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LaporanController {
    private LaporanModel laporanModel;

    public LaporanController() {
        laporanModel = new LaporanModel();
    }

    // Method untuk memproses data laporan dan menyimpannya ke database
    public boolean tambahLaporan(String namaJalan, String kecamatan, String tingkatKerusakan, String deskripsi) {
        String tanggalLaporan = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return laporanModel.simpanLaporan(namaJalan, kecamatan, tingkatKerusakan, deskripsi, tanggalLaporan);
    }
}

