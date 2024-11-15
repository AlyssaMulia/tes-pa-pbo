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
    private String namaLengkap;
    private String noTelp;
    private String email;

    public Pelapor(String username, String password, String namaLengkap, String noTelp, String email) {
        super(username, password);
        this.namaLengkap = namaLengkap;
        this.noTelp = noTelp;
        this.email = email;
    }

    // Getter dan Setter untuk atribut tambahan
    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}