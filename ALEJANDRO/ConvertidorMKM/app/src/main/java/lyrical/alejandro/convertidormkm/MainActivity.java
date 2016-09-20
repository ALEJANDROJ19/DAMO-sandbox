package lyrical.alejandro.convertidormkm;

import android.graphics.Color;
import android.support.annotation.BoolRes;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final double FACTOR_CONVERSSIO = 0.62137119;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    public void respostaOnClick(View vw) {
//        convertir();
//
//    }

    public void convertir(View vw){

        TextView text = (TextView) findViewById(R.id.EntradaDades);

        String actual = text.getText().toString();

        if (!actual.isEmpty()) {
            boolean modeKm = ((RadioButton) findViewById(R.id.radioButton)).isChecked();
            double convertit = transmutador_dunitats(modeKm, Float.parseFloat(actual));
            text.setText(String.valueOf(convertit));

            Snackbar snackbar = Snackbar
                    .make(findViewById(android.R.id.content), "Valor: " + Double.toString(convertit), Snackbar.LENGTH_LONG);
                    //.setAction("Undo", mOnClickListener)
                    //.setActionTextColor(Color.RED);

            snackbar.show();
        }



    }

    public void netejar(View vw){
        TextView text = (TextView) findViewById(R.id.EntradaDades);
        text.setText("");

        Snackbar snackbar = Snackbar
                .make(findViewById(android.R.id.content), "Valor netejat.", Snackbar.LENGTH_LONG);

        snackbar.show();

    }

    private double transmutador_dunitats(Boolean Km, double valor){
        double res = 0.0;
        if (Km){
            //Km -> milles
            res = valor * FACTOR_CONVERSSIO;

        } else {
            //Milles -> Km
            res = valor / FACTOR_CONVERSSIO;
        }
        return res;
    }

    private void copia(){}
}
