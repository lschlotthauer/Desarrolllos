package com.example.lucass.tpmemotest;

import android.app.Dialog;
import android.content.DialogInterface;
import android.location.GpsStatus;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;

/**
 * Created by lucass on 11/14/2016.
 */

public class MiDialogo extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Ingrese su nombre");
        builder.setMessage("Nombre: ");
        builder.setPositiveButton("Guardar", (DialogInterface.OnClickListener)getActivity());

        AlertDialog ad = builder.create();
        return ad;
    }
}
