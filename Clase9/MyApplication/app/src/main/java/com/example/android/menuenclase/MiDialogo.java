package com.example.android.menuenclase;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by android on 18/05/16.
 */
public class MiDialogo extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Alerta Virus!");
        builder.setMessage("Se te va a borrar todo");
        builder.setPositiveButton("Aceptar", (DialogInterface.OnClickListener)getActivity());
        builder.setNegativeButton("Cancelar", (DialogInterface.OnClickListener) getActivity());

        AlertDialog ad = builder.create();
        return ad;
    }
}
