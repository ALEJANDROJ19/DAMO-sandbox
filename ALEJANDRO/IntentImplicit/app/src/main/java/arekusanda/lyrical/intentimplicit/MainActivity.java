package arekusanda.lyrical.intentimplicit;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        Button boto_mapa, boto_web, boto_trucar;
        final EditText latitud, longitud, telefon;

        boto_mapa = (Button) findViewById(R.id.boto_mapa);
        boto_web = (Button) findViewById(R.id.boto_web);
        boto_trucar = (Button) findViewById(R.id.boto_trucar);
        latitud = (EditText) findViewById(R.id.editText_lat);
        longitud = (EditText) findViewById(R.id.editText_long);
        telefon = (EditText) findViewById(R.id.edittrucar);

        boto_mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("geo:"+latitud.getText().toString()+","+longitud.getText().toString());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        boto_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://commonsware.com");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        boto_trucar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:"+telefon.getText().toString());
                Intent intent = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(intent);
            }
        });


    }
}
