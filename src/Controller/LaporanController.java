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

public class LaporanController {
    private LaporanModel laporanModel;

    public LaporanController() {
        laporanModel = new LaporanModel();
    }

    public boolean simpanLaporan(String namaJalan, String kecamatan, String deskripsi, String tingkatKerusakan, int userId) {
        String status = "Belum Diproses";
        return laporanModel.tambahLaporan(namaJalan, kecamatan, deskripsi, tingkatKerusakan, status, userId);
    }
}