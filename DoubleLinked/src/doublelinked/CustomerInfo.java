/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublelinked;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class CustomerInfo {
    private String adSoyad;
    private String adres;
    private ArrayList tel;
    private String telefonlar;

    public CustomerInfo(String adSoyad, String adres, ArrayList tel) {
        this.adSoyad = adSoyad;
        this.adres = adres;
        this.tel = tel;
        telefonlar=String.join(", ", tel); //This method give us chance display all elements of arraylist sorted  by single command. Works only Java8
                                           //and higher versions.
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public ArrayList getTel() {
        return tel;
    }

    public void setTel(ArrayList tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "CustomerInfo{" + "adSoyad=" + adSoyad + ", adres=" + adres + ", telefonlar=" + telefonlar + '}';
    }
    
    
}
