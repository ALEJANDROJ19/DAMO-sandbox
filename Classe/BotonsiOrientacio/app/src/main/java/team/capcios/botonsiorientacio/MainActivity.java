package team.capcios.botonsiorientacio;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.io.Console;


public class MainActivity extends Activity {

    RadioButton vert, horit, esq, cent, drt;
    LinearLayout grup0;
    RadioGroup grup2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

    }

    private void initialize() {
        vert = (RadioButton) findViewById(R.id.vertical);
        horit = (RadioButton) findViewById(R.id.horitzontal);
        esq = (RadioButton) findViewById(R.id.esquerra);
        cent = (RadioButton) findViewById(R.id.centrat);
        drt = (RadioButton) findViewById(R.id.dreta);
        grup0 = (LinearLayout) findViewById(R.id.grup0);
        grup2 = (RadioGroup) findViewById(R.id.grup2);

        vert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transformar_grup1((RadioButton) view);
            }
        });

        horit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transformar_grup1((RadioButton) view);
            }
        });

        esq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transformar_grup2((RadioButton) view);
            }
        });

        cent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transformar_grup2((RadioButton) view);
            }
        });

        drt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transformar_grup2((RadioButton) view);
            }
        });

    }

    private void transformar_grup1(RadioButton r){
        switch (r.getId()){
            case R.id.horitzontal:
                grup0.setOrientation(LinearLayout.HORIZONTAL);
                break;
            case R.id.vertical:
                grup0.setOrientation(LinearLayout.VERTICAL);
                break;
            default:
                Log.d("[DEBUG]: ", "transformar_grup1 falla en switch");
        }
    }

    private void transformar_grup2(RadioButton r){
        switch (r.getId()){
            case R.id.esquerra:
                grup2.setGravity(Gravity.LEFT);
                break;
            case R.id.centrat:
                grup2.setGravity(Gravity.CENTER);
                break;
            case R.id.dreta:
                grup2.setGravity(Gravity.RIGHT);
                break;
            default:
                Log.d("[DEBUG]: ", "transformar_grup2 falla en switch");
        }
    }


}
