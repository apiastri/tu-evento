package com.bpoplataforma.tuevento;

import com.bpoplataforma.tuevento.dao.EventoDAO;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {
	
	private EventoDAO datasource;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		datasource = EventoDAO.getInstance(this);
		datasource.crearEventosDePrueba();
		//List eventosUsuario = datasource.obtenerEventosDeUsuario(new Usuario());
		
		Intent intent = new Intent(MainActivity.this, TabsActivity.class);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
