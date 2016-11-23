package team.capcios.passarllista;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ALEJANDRO on 23/11/2016.
 */
public class ConjuntDiesClasses {
    private List<Dia> diesClasses;

    public ConjuntDiesClasses() {
        diesClasses = new ArrayList<>();
    }

    public void addDia(Dia dia){
        diesClasses.add(dia);
    }

    public List<Dia> getDiesClasses() {
        return diesClasses;
    }
}
