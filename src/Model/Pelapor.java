/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */
public class Pelapor extends UserModel {
    private String nama;
    private String noTelp;
    private String email;

    public Pelapor(String username, String password, String nama, String noTelp, String email) {
        super(username, password);
        this.nama = nama;
        this.noTelp = noTelp;
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Username: " + username);
        System.out.println("No Telepon: " + noTelp);
        System.out.println("Email: " + email);
    }
}