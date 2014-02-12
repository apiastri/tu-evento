package com.bpoplataforma.tuevento;

import com.bpoplataforma.tuevento.dao.EventoDAO;
import com.bpoplataforma.tuevento.model.Usuario;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TextView;

public class FichaEvento extends Activity {
	TextView seleccionado;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalle_evento);
		seleccionado = (TextView)findViewById(R.id.txtResultado);
		Intent i = getIntent();
		Bundle b = i.getExtras();
		if(b != null){
			String datos = b.getString("datos");
			seleccionado.setText(datos);
			
		}
		
		
	}

}
