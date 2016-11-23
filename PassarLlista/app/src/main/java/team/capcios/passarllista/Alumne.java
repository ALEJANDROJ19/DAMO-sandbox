package team.capcios.passarllista;

import android.provider.ContactsContract;

/**
 * Created by ALEJANDRO on 23/11/2016.
 */
public class Alumne {
    private String nom;
    private String email;

    public Alumne(String nom, String email) {

        this.nom = nom;
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return nom + "\n" + email;
    }
}
