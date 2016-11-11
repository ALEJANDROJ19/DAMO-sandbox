package arekusanda.lyrical.textacumulatiuambmenu;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    EditText camp;
    TextView res;
    Button boto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicialitza();
    }

    private void inicialitza() {
        camp = (EditText) findViewById(R.id.camp);
        res = (TextView) findViewById(R.id.resultat);
        camp.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                return nouContingut(v, actionId, event);
            }
        });
        boto = (Button) findViewById(R.id.boto);


        boto.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        esborraResultat(v);
                                    }
                                }

        );
    }

    private boolean nouContingut(TextView v, int actionId, KeyEvent event) {
        // Mirem si s'ha polsat un botó d'acció. En aquests casos l'event és null
        // (És el cas de teclat soft)
        switch (actionId){
            case EditorInfo.IME_ACTION_GO:
                afegeixAResultat(camp.getText());
                camp.setText("");
                return true;
        }

        // Mirem quin event s'ha generat
        // (Cas de teclat hard)
        switch (event.getAction()) {
            case KeyEvent.ACTION_UP:
                afegeixAResultat(camp.getText());
                camp.setText("");
                return true;
        }
        return true;
    }

    private void afegeixAResultat(Editable text) {
        res.append("\n");
        res.append(text);
    }

    private void esborraResultat(View v) {
        res.setText("");
        camp.setText("");
    }
}

