package com.example.lucass.tpmemotest;

import android.app.Dialog;
import android.content.DialogInterface;
import android.location.GpsStatus;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by lucass on 11/14/2016.
 */

public class MiDialogo extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        builder.setTitle("Ingrese su nombre");
//        builder.setMessage("Nombre: ");
//        builder.setPositiveButton("Guardar", (DialogInterface.OnClickListener)getActivity());
//
//        AlertDialog ad = builder.create();

        LayoutInflater li = LayoutInflater.from(getActivity());
        View viewAlert = li.inflate(R.layout.layout_dialogo,null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Ingrese su nombre");
        builder.setView(viewAlert);

        builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
                EditText et = (EditText) findViewById(R.id.editText);
                Log.d("act", "Resultado: "+ et.getText().toString());
            }
        });
        AlertDialog ad = builder.create();
        return ad;
    }
}
