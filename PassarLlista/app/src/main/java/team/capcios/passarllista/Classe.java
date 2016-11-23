package team.capcios.passarllista;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ALEJANDRO on 23/11/2016.
 */
public class Classe {
    private String nom;
    private ConjuntAlumnes conjuntAlumnes;
    // private Array de Dies de la setmana que s'imparteix la assignatura.


    public Classe(String nom, ConjuntAlumnes conjuntAlumnes) {
        this.nom = nom;
        this.conjuntAlumnes = conjuntAlumnes;
    }

    public String getNom() {
        return nom;
    }

    public ConjuntAlumnes getConjuntAlumnes() {
        return conjuntAlumnes;
    }
}
