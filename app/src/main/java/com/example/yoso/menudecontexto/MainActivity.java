package com.example.yoso.menudecontexto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inflar el texto del menu de contexto
        TextView tvNombre = (TextView) findViewById(R.id.tvNombre);

        // Instrucció para poner el View que levante un menu de contexto
        registerForContextMenu(tvNombre);
    }

    // Metodo oncreate de contexto
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = new MenuInflater(this);

        getMenuInflater().inflate(R.menu.menu_contexto, menu);
    }

    // Crear opciones del menu con acciones

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.mEdit:
                // Acciones
                Toast.makeText(this, getResources().getString(R.string.menu_edit),
                        Toast.LENGTH_SHORT).show();
                break;

            case R.id.mDelete:
                // Acciones
                Toast.makeText(this, getResources().getString(R.string.menu_delete)
                , Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onContextItemSelected(item);
    }
}
