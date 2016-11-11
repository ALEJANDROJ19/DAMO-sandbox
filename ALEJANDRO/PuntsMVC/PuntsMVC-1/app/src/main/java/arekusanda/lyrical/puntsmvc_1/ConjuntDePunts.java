package arekusanda.lyrical.puntsmvc_1;

import java.util.ArrayList;
import java.util.List;

public class ConjuntDePunts {
    private List<Punt> punts;
    private ConjuntDePuntsListener observador;

    public interface ConjuntDePuntsListener {
        void onCanviConjuntdePunts();
    }

    public ConjuntDePunts() {
        punts = new ArrayList<>();
    }

    public void afegirPunt(Punt punt){
        punts.add(punt);
        avisarObservador();
    }

    private void avisarObservador() {
        if(observador != null)
            observador.onCanviConjuntdePunts();
    }

    public void enregistrarObservador(ConjuntDePuntsListener observador){
        this.observador = observador;
    }
}
