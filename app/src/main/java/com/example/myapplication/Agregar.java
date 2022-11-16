package com.example.myapplication;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.Manifest.permission_group.CAMERA;


import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;



public class Agregar extends AppCompatActivity {
    private static final int SOLICITUD_PERMISO_LECTURA = 0;
    final static int RESULTADO_FOTO=3;
    private Spinner spiner1, spiner2;
    ArrayList<AdapHome> ListaMenu;
    RecyclerView recyclerMenu;
    private ImageButton perfil, chat, favoritos, mapa, home, ajustes;
    private final String CARPETA_RAIZ = "misImagenesPrueba/";
    private final String RUTA_IMAGEN = CARPETA_RAIZ + "misFotos";

    final int COD_SELECCIONA = 10;
    final int COD_FOTO = 20;
    private String path;
    private ImageView imagen, camara;
    private Uri uriUltimaFoto;
    private Activity actividad;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        ListaMenu = new ArrayList<>();
        recyclerMenu = (RecyclerView) findViewById(R.id.recycle);
        recyclerMenu.setLayoutManager(new GridLayoutManager(this,3));

        spiner1 = (Spinner) findViewById(R.id.spinner);
        spiner2 = (Spinner) findViewById(R.id.spinner2);

        camara = findViewById(R.id.camara);



        ArrayList<String> elementos = new ArrayList<>();
        elementos.add("Seleccina la mascota:");
        elementos.add("Gato");
        elementos.add("Perro");

        ArrayAdapter adp = new ArrayAdapter(Agregar.this, android.R.layout.simple_spinner_dropdown_item, elementos);

        spiner1.setAdapter(adp);
        spiner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String elemento = (String) spiner1.getAdapter().getItem(position);
                Toast.makeText(Agregar.this, "Seleccionaste " + elemento, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayList<String> ele = new ArrayList<>();
        ele.add("Seleccina tamaño (Si aplica):");
        ele.add("Pequeño");
        ele.add("Mediano");
        ele.add("Grande");

        ArrayAdapter adapterp = new ArrayAdapter(Agregar.this, android.R.layout.simple_spinner_dropdown_item, ele);
        spiner2.setAdapter(adapterp);
        spiner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String ele = (String) spiner2.getAdapter().getItem(position);
                Toast.makeText(Agregar.this, "Seleccionaste " + ele, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        llenarMenu();
        AdapterHome adapter = new AdapterHome(ListaMenu);
        adapter.setOnClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListaMenu.add(new AdapHome(R.drawable.image_6));
                Intent perfil = new Intent(Agregar.this, Perfil.class);
                startActivity(perfil);
                ListaMenu.add(new AdapHome(R.drawable.imagegoo_3_1));
                Intent home = new Intent(Agregar.this, Home1.class);
                startActivity(home);
                ListaMenu.add(new AdapHome(R.drawable.image_2));
                Intent chat = new Intent(Agregar.this, Chat.class);
                startActivity(chat);
                ListaMenu.add(new AdapHome(R.drawable.image_4));
                Intent favoritos = new Intent(Agregar.this, Favoritos.class);
                startActivity(favoritos);
                ListaMenu.add(new AdapHome(R.drawable.image_8));
                Intent mapa = new Intent(Agregar.this, MAPA.class);
                startActivity(mapa);
                ListaMenu.add(new AdapHome(R.drawable.image_5));
                Intent ajustes = new Intent(Agregar.this, Ajustes.class);
                startActivity(ajustes);

            }
        });
        recyclerMenu.setAdapter(adapter);



        //AbrirGaleria
        /*public void abrirGaleria(){
        galeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usoLugar.ponerDeGaleria(RESULTADO_GALERIA);
            }
        });
    }*/



        imagen = (ImageView )findViewById(R.id.imageView10);
        camara = (ImageView) findViewById(R.id.camara);

        if (validaPermisos()) {
            camara.setEnabled(true);
        } else {
            camara.setEnabled(false);
        }


    }

    private void llenarMenu() {
            ListaMenu.add(new AdapHome(R.drawable.image_6));
            ListaMenu.add(new AdapHome(R.drawable.imagegoo_3_1));
            ListaMenu.add(new AdapHome(R.drawable.image_2));
            ListaMenu.add(new AdapHome(R.drawable.image_4));
            ListaMenu.add(new AdapHome(R.drawable.image_8));
            ListaMenu.add(new AdapHome(R.drawable.image_5));
    }


    //tomarFotoCamara
    public void tomarFotoCamara(){
        camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uriUltimaFoto = tomarFoto(RESULTADO_FOTO);
            }
        });
    }

    public Uri tomarFoto(int codigoSolicitud){
        try{
            Uri uriUltimatoFoto;
            File file = File.createTempFile("img_"+
                            (System.currentTimeMillis()/1000),".jpg",
                    actividad.getExternalFilesDir(Environment.DIRECTORY_PICTURES));
            if (ContextCompat.checkSelfPermission(actividad, Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){
                solicitarPermiso(Manifest.permission.READ_EXTERNAL_STORAGE,"Sin el permiso de lectura no podrá visualizar la foto que capturó",
                        SOLICITUD_PERMISO_LECTURA, actividad);
                uriUltimatoFoto= Uri.parse(String.valueOf(R.mipmap.ic_launcher));
            }

            else if (Build.VERSION.SDK_INT>=24){
                uriUltimatoFoto = FileProvider.getUriForFile(actividad,".fileProvider",file);
            } else {
                uriUltimatoFoto = Uri.fromFile(file);
            }
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT,uriUltimatoFoto);
            actividad.startActivityForResult(intent,codigoSolicitud);
            return uriUltimatoFoto;
        } catch (IOException e) {
            Toast.makeText(actividad,"Error al crear el fichero de imagen "+e.getMessage(),
                    Toast.LENGTH_LONG).show();
            return null;
        }
    }

    public static void solicitarPermiso(final String permiso, String justificacion, final int requestCode, final Activity actividad){
        if (ActivityCompat.shouldShowRequestPermissionRationale(actividad, permiso)){
            new AlertDialog.Builder(actividad)
                    .setTitle("Solicitud del permiso en la APP")
                    .setMessage(justificacion)
                    .setIcon(R.mipmap.ic_launcher)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(actividad, new String[]{permiso}, requestCode);
                        }
                    }).show();
        } else {
            ActivityCompat.requestPermissions(actividad, new String[]{permiso}, requestCode);
        }
    }
    //Eliminar foto
    //onActivityResult
    //onRequestPermissionsResult

    private boolean validaPermisos() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }

        if ((checkSelfPermission(CAMERA) == PackageManager.PERMISSION_GRANTED) &&
                (checkSelfPermission(WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)) {
            return true;
        }

        if ((shouldShowRequestPermissionRationale(CAMERA)) ||
                (shouldShowRequestPermissionRationale(WRITE_EXTERNAL_STORAGE))) {
            cargarDialogoRecomendacion();
        } else {
            requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE, CAMERA}, 100);
        }

        return false;

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 100) {
            if (grantResults.length == 2 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                camara.setEnabled(true);
            } else {
                solicitarPermisosManual();
            }
        }

    }

    private void solicitarPermisosManual() {
        final CharSequence[] opciones = {"si", "no"};
        final AlertDialog.Builder alertOpciones = new AlertDialog.Builder(Agregar.this);
        alertOpciones.setTitle("¿Desea configurar los permisos de forma manual?");
        alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (opciones[i].equals("si")) {
                    Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri = Uri.fromParts("package", getPackageName(), null);
                    intent.setData(uri);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Los permisos no fueron aceptados", Toast.LENGTH_SHORT).show();
                    dialogInterface.dismiss();
                }
            }
        });
        alertOpciones.show();
    }


    private void cargarDialogoRecomendacion() {
        AlertDialog.Builder dialogo=new AlertDialog.Builder(Agregar.this);
        dialogo.setTitle("Permisos Desactivados");
        dialogo.setMessage("Debe aceptar los permisos para el correcto funcionamiento de la App");

        dialogo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE,CAMERA},100);
            }
        });
        dialogo.show();
    }

    public void onclick(View view) {
        cargarImagen();
    }


    private void cargarImagen() {

        final CharSequence[] opciones = {"Tomar Foto", "Cargar Imagen", "Cancelar"};
        final AlertDialog.Builder alertOpciones = new AlertDialog.Builder(Agregar.this);
        alertOpciones.setTitle("Seleccione una Opción");
        alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (opciones[i].equals("Tomar Foto")) {
                    tomarFotografia();
                } else {
                    if (opciones[i].equals("Cargar Imagen")) {
                        Intent intent = new Intent(Intent.ACTION_GET_CONTENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        intent.setType("image/");
                        startActivityForResult(intent.createChooser(intent, "Seleccione la Aplicación"), COD_SELECCIONA);
                    } else {
                        dialogInterface.dismiss();
                    }
                }
            }
        });
        alertOpciones.show();
    }

    private void tomarFotografia() {
        File fileImagen = new File(Environment.getExternalStorageDirectory(), RUTA_IMAGEN);
        boolean isCreada = fileImagen.exists();
        String nombreImagen = "";
        if (isCreada == false) {
            isCreada = fileImagen.mkdirs();
        }
        if(isCreada==true){
            nombreImagen=(System.currentTimeMillis()/1000)+".jpg";
        }


        path=Environment.getExternalStorageDirectory()+
                File.separator+RUTA_IMAGEN+File.separator+nombreImagen;

        File imagen=new File(path);

        Intent intent=null;
        intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        ////
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N)
        {
            String authorities=getApplicationContext().getPackageName()+".provider";
            Uri imageUri=FileProvider.getUriForFile(this,authorities,imagen);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        }else
        {
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imagen));
        }
        startActivityForResult(intent,COD_FOTO);

        ////

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){

            switch (requestCode){
                case COD_SELECCIONA:
                    Uri miPath=data.getData();
                    imagen.setImageURI(miPath);
                    break;

                case COD_FOTO:
                    MediaScannerConnection.scanFile(this, new String[]{path}, null,
                            new MediaScannerConnection.OnScanCompletedListener() {
                                @Override
                                public void onScanCompleted(String path, Uri uri) {
                                    Log.i("Ruta de almacenamiento","Path: "+path);
                                }
                            });

                    Bitmap bitmap= BitmapFactory.decodeFile(path);
                    imagen.setImageBitmap(bitmap);

                    break;
            }


        }
    }
}