package team.capcios.passarllista;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ALEJANDRO on 23/11/2016.
 */
public class ConjuntAlumnes {
    private List<Alumne> alumnes;

    public ConjuntAlumnes() {
        alumnes = new ArrayList<>();
        loadAlumnes();
    }

    private void loadAlumnes() {
        alumnes.add(new Alumne("Alejandro Jurnet Bolarin", "alejandro.jurnet@estudiant.upc.edu"));
        alumnes.add(new Alumne("Pau Marcer Albareda", "pau.marcer@estudiant.upc.edu"));
        alumnes.add(new Alumne("John Doe", "john.doe@nomail.com"));
    }

    public void addAlumne(Alumne alumne){
        alumnes.add(alumne);
    }

    public List<Alumne> getAlumnes() {
        return alumnes;
    }

    //TODO: deleteAlumnes,


}
