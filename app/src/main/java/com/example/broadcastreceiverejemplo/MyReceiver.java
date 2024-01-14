package com.example.broadcastreceiverejemplo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/*
Autor: Juan Francisco Sánchez González
Fecha: 14/01/2024
Clase: Clase que extiende de BroadcastReceiver. Lanzamos mensaje Toast según el mesnsaje broadcast que
nos llegue del sistema.
*/

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        if (intentAction != null){
            String toastMessage = context.getResources().getString(R.string.defult_texto_toast);
            // Según el mensaje recibido
            switch (intentAction){
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage = context.getResources().getString(R.string.batConectada_texto_toast);
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage = context.getResources().getString(R.string.batDesconectada_texto_toast);
                    break;
                case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                    boolean status = intent.getBooleanExtra("state" , true);
                    if(status){
                        toastMessage = context.getResources().getString(R.string.modAvionOn_texto_toast);
                    }else {
                        toastMessage = context.getResources().getString(R.string.modAvionOff_texto_toast);
                    }
                    break;
            }
            Log.d(context.getResources().getString(R.string.log_tag), toastMessage);
            Toast.makeText(context, toastMessage, Toast.LENGTH_LONG).show();
        }
    }
}