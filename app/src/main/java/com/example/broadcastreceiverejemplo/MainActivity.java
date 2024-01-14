package com.example.broadcastreceiverejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
Autor: Juan Francisco Sánchez González
Fecha: 14/01/2024
Clase: Actividad que contiene un botón para iniciar el registro de los mensajes recibidos por el sistema.
 Se escucharán los broadcast de carga de la batería y cambiar al modo avión. Se utilizará la clase BroadcastReceiver.
*/

public class MainActivity extends AppCompatActivity {

    private Button btnIniciar;
    MyReceiver myReceiver = new MyReceiver();
    IntentFilter filter = new IntentFilter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Acciones del sistema que escucharemos
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);

        // Componente Button
        btnIniciar = findViewById(R.id.buttonIniciarBroadcast);
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciamos nuestro Receiver para registrar los mensajes
                MainActivity.this.registerReceiver(myReceiver,filter);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Paramos nuestro Receiver al destruir la actividad
        MainActivity.this.unregisterReceiver(myReceiver);
    }
}
