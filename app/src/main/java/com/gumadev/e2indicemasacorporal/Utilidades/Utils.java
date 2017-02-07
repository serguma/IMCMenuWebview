package com.gumadev.e2indicemasacorporal.Utilidades;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.gumadev.e2indicemasacorporal.R;


/**
 * Created by sergu on 07/01/2017.
 */

public class Utils {

    public Context ct;
    public Utils (Context context){
        this.ct = context;
    }

    public static String calculaIMC(float peso, float altura, Context ct){
        String mensaje;

        Activity activity = (Activity) ct;

        if((altura > 0.0 && peso > 0.0)) {
            altura = (altura / 100);
            float imc = peso / (altura * altura);

            if (imc < 16) {
                mensaje = activity.getResources().getString(R.string.tuimc) + imc + " \n " + activity.getResources().getString(R.string.desnutrido);
            } else if ((imc >= 16) && (imc < 18)) {
                mensaje = activity.getResources().getString(R.string.tuimc) + imc + " \n " + activity.getResources().getString(R.string.bajopeso);
            } else if ((imc >= 18) && (imc < 25)) {
                mensaje = activity.getResources().getString(R.string.tuimc) + imc + " \n " + activity.getResources().getString(R.string.normal);
            } else if ((imc >= 25) && (imc < 31)) {
                mensaje = activity.getResources().getString(R.string.tuimc) + imc + " \n " + activity.getResources().getString(R.string.sobrepeso);
            } else {
                mensaje = activity.getResources().getString(R.string.tuimc) + imc + " \n " + activity.getResources().getString(R.string.obesidad);
            }
        }else{
            mensaje = activity.getResources().getString(R.string.error);
        }

        return mensaje;
    }

    public static void salir(Context ctx){

        Activity activity = (Activity) ctx;
        SharedPreferences sharedPreferences = activity.getSharedPreferences("preferen", ctx.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("logueo", false);
        editor.commit();

        activity.finishAffinity();
    }

}
