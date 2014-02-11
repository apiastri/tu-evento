package com.bpoplataforma.tuevento;

import com.bpoplataforma.tuevento.dao.EventoDAO;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TabHost;

public class MainActivity extends TabActivity {
	
	private EventoDAO datasource;


	protected void onCreate(Bundle savedInstanceState) {
		datasource = EventoDAO.getInstance(this);
		datasource.crearEventosDePrueba();
		super.onCreate(savedInstanceState);
		//creamos el contenedor de Tabs
    	TabHost host = getTabHost();
    	//Añadimos cada tab, que al ser pulsadas abren sus respectivas Activities
    	host.addTab(host.newTabSpec("activity_lista_evento").setIndicator("Eventos").setContent(new Intent(this, ListaEvento.class)));
    	host.addTab(host.newTabSpec("activity_lista_evento").setIndicator("Favoritos").setContent(new Intent(this, ListaEvento.class)));
    	host.addTab(host.newTabSpec("activity_lista_evento").setIndicator("Busqueda").setContent(new Intent(this, ListaEvento.class)));
    	//añadir mas tabs

		
    	
    	//setContentView(R.layout.activity_lista_evento);
		
		//Intent intent = new Intent(MainActivity.this,ListaEvento.class);
		//startActivity(intent);
		
		
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
