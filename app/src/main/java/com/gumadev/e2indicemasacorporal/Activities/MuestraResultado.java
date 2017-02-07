package com.gumadev.e2indicemasacorporal.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.gumadev.e2indicemasacorporal.Listener.EscuchaMenu;
import com.gumadev.e2indicemasacorporal.Listener.MuestraRangos;
import com.gumadev.e2indicemasacorporal.R;
import com.gumadev.e2indicemasacorporal.Utilidades.Utils;

public class MuestraResultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle bundle){

        super.onCreate(bundle);

        setContentView(R.layout.activity_muestra_resultado);

        //Obtengo los valores para realizar el cálculo
        Intent intent = getIntent();
        float peso = intent.getFloatExtra("peso",0);
        float altura = intent.getFloatExtra("altura",0);

        TextView elmensaje = (TextView) findViewById(R.id.elmensaje);
        String resultado = Utils.calculaIMC(peso,altura,this);
        elmensaje.setText(resultado);

        //Le doy la accción al botón definida en MuestrRangos
        Button boton = (Button) findViewById(R.id.volver);
        MuestraRangos muestraRangos = new MuestraRangos(this);
        boton.setOnClickListener(muestraRangos);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflo el menu
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Con escucha menu ejecuto las acciones de los item del menú
        EscuchaMenu escuchaMenu = new EscuchaMenu(this);
        item.setOnMenuItemClickListener(escuchaMenu);
        return true;
    }

}
