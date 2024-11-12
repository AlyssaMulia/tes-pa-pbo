/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */
public class Admin extends UserModel {
    private String jabatan;

    public Admin(String username, String password, String jabatan) {
        super(username, password);
        this.jabatan = jabatan;
    }

    public String getJabatan() {
        return jabatan;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Admin Username: " + username);
        System.out.println("Jabatan: " + jabatan);
    }
}
