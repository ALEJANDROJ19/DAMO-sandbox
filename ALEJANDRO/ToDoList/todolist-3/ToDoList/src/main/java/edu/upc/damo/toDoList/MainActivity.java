package edu.upc.damo.toDoList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends Activity {
    private Boolean b=true;
    private int i=0;
    private Button boto;
    private ListView listView;
    private List<CharSequence> dades =new ArrayList<>();

    private BaseAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.llista);

        carregaDades(); //Carregar d'un array XML

        inicialitza();
    }

    private void carregaDades() {
        CharSequence[] dadesEstatiques =
                getResources().getStringArray(R.array.dadesEstatiques);
        Collections.addAll(dades, dadesEstatiques);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    private void inicialitza() {

        listView = (ListView) findViewById(R.id.llista);
        adaptador = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_list_item_1, dades);
        listView.setAdapter(adaptador); //Això substitueix les entries en el xml

        boto = (Button) findViewById(R.id.button);

        boto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                creaItemLlista();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int possicio, long id) {
                eliminarItemLlista(possicio);
                return false;
            }
        });

    }

    private void eliminarItemLlista(int possicio) {
        //FORMA INCORRECTA
        //dades.remove(adaptador.getItem(possicio));
        //FORMA INCORRECTA 2
        //adaptador.remove(adaptador.getItem(possicio));

        //FORMA CORRECTA
        //No sempre el id correspon a la possició, per això busquem
        //i eliminem per el seu id.
        dades.remove((int) adaptador.getItemId(possicio));
        adaptador.notifyDataSetChanged();
    }

    private void creaItemLlista() {
        //Més robust. Ens permet fer més cosses.
        dades.add("Item Hardcoded"+String.valueOf(i));
        adaptador.notifyDataSetChanged();
        i++;
    }
}
