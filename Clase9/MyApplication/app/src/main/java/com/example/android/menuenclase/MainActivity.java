package com.example.android.menuenclase;

import android.animation.AnimatorSet;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnClickListener, SearchView.OnQueryTextListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Sin conexion a internet", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Recargar", MainActivity.this).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.menu_item_share);
        ShareActionProvider mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(item);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,"http://www.lslutnfra.com");

        mShareActionProvider.setShareIntent(intent);

        MenuItem searchItem = menu.findItem(R.id.campo_buscar);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.action_settings:
            {
                Log.d("act", "action_settings");
                return true;
            }
            case R.id.opcion1:
            {
                Log.d("act", "opcion 1");
                MiDialogo md =  new MiDialogo();
                md.show(getSupportFragmentManager(),"Dialogo");


                return true;
            }
            case R.id.opcion2:
            {
                Log.d("act", "opcion 2");
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

        switch (which)
        {
            case AlertDialog.BUTTON_POSITIVE:
            {
                Log.d("act", "Positivo");
            }
            case AlertDialog.BUTTON_NEGATIVE:
            {
                Log.d("act", "Negativo");
            }

        }

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.d("act", "Buscamos: " + query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
