package edu.upc.damo.toDoList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends Activity {
    private Boolean b=true;
    private Button boto;
    private ListView listView;
    private ArrayList<String> dades =new ArrayList<String>();

    private ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.llista);

        inicialitza();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    private void inicialitza() {

        listView = (ListView) findViewById(R.id.llista);
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dades);


    }
}
