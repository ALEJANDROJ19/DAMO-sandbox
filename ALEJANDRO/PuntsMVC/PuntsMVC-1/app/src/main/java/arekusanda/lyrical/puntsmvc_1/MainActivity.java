package arekusanda.lyrical.puntsmvc_1;

import android.graphics.Color;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button red,green;
    private EditText x,y;
    private VistaDePunts vdp;
    private ConjuntDePunts cdp;

    private static final String TAG = "DEBUG: ";
    private Random random;
    private enum Coord {X,Y};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        vdp.defineixModel(cdp);
    }

    private void initialize() {
        red = (Button) findViewById(R.id.button_vermell);
        green = (Button) findViewById(R.id.button_verd);
        x = (EditText) findViewById(R.id.coordX);
        y = (EditText) findViewById(R.id.coordY);
        vdp = (VistaDePunts) findViewById(R.id.vistaDePunts);

        cdp = new ConjuntDePunts();

        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boto_clic((Button) view);
            }
        });

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boto_clic((Button) view);
            }
        });

        vdp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.i("DEBUG: ","Captura listener del Vista de Punts: " +
                        motionEvent.getAction());
                return view_clic((VistaDePunts) view, motionEvent);
            }
        });

        random = new Random();
    }

    private void boto_clic(Button view) {
        int col;

        switch (view.getText().toString().toLowerCase()) {
            case "vermell":
                col = Color.RED;
                break;
            case "verd":
                col = Color.GREEN;
                break;
            default:
                Log.d("DEBUG: ", "Error en switch");
                col = 0;
        }
        afegeixPunt(col);
    }

    private boolean view_clic(VistaDePunts view, MotionEvent event) {
        if(MotionEvent.ACTION_DOWN != event.getAction()){
            return false;
        }
        afegeixPunt(Color.CYAN,event);
        return true;
    }

    private void afegeixPunt(int color){
        double rx,ry,rd;
        rd = random.nextDouble() * 20 + 10;
        rx = coordenadaRandom(Coord.X,rd);
        ry = coordenadaRandom(Coord.Y,rd);

        Punt punt = new Punt(rx,ry,color,rd);
        mostraCoordenades(punt);
        cdp.afegirPunt(punt);
    }

    private void afegeixPunt(int color, MotionEvent event){
        double rd;
        rd = random.nextDouble() * 20 + 10;
        Punt punt = new Punt(event.getX(),event.getY(),color,rd);
        mostraCoordenades(punt);
        cdp.afegirPunt(punt);
    }

    private double coordenadaRandom(Coord coord, double diametre){
        double ret,size,margin;
        if(coord == Coord.X){
            size = vdp.getWidth();
            margin = vdp.getX();
        } else {
            size = vdp.getHeight();
            margin = vdp.getY();
        }
        size -= 2*diametre;
        ret = random.nextDouble() * size + diametre;
//        Log.i("+",String.valueOf(coord)+" Size: "+String.valueOf(size)+" Margin:"+String.valueOf(margin));
        return ret;
    }

    private void mostraCoordenades(Punt punt) {
        x.setText(String.valueOf(punt.getCoordX()));
        y.setText(String.valueOf(punt.getCoordY()));
    }


}
