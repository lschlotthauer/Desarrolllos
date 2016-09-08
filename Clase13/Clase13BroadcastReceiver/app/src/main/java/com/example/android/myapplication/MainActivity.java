package com.example.android.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    File f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {
            f = createImageFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
        startActivityForResult(takePictureIntent, 0);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == Activity.RESULT_OK){
/*            Bundle extras = data.getExtras();
            // obtenemos un bitmap con una preview de la imagen tomada
            ImageView imageViewPreView = (ImageView) findViewById(R.id.imageView);
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            // mostramos el bitmap
            imageViewPreView.setImageBitmap(imageBitmap);*/

            Bitmap captureBmp = null;
            try {
                captureBmp = MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.fromFile(f));
            } catch (IOException e) {
                e.printStackTrace();
            }
            ImageView img=(ImageView) findViewById(R.id.imageView);
            img.setImageBitmap(captureBmp);

        }
    }

    private File getAlbumDir()
    {
        String strPath = Environment.getExternalStorageDirectory()+"/Android/data/"+getPackageName()+"/Pictures";
        File path = new File (strPath);
        // creamos el directorio si no existe
        path.mkdirs();
        return path;
    }

    private File createImageFile() throws IOException
    {
        // creamos el nombre del archivo
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "foto_"+ timeStamp + ".jpg";
        // creamos el archivo
        File image = new File(getAlbumDir(), imageFileName);
        image.createNewFile();
        return image;
    }



}
