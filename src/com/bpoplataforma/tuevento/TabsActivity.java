package com.bpoplataforma.tuevento;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.view.Menu;
import android.widget.TabHost;

public class TabsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tabs);
		//declaro esta variable resources solo para poder obtener los iconos de drawable
		Resources res = getResources();
		
		//obtengo el control de pestañas
		TabHost tabs = (TabHost)findViewById(android.R.id.tabhost);
		tabs.setup();
		
		//agrego las pestañas al control tabhost
		TabHost.TabSpec spec = tabs.newTabSpec("tabmapa");
		spec.setContent(R.id.tabmapa);
		spec.setIndicator("Mapa", res.getDrawable(android.R.drawable.ic_dialog_map));
		tabs.addTab(spec);
		//agrego otra pestaña
		spec = tabs.newTabSpec("tabevento");
		spec.setContent(R.id.tabevento);
		spec.setIndicator("Datos del evento", res.getDrawable(android.R.drawable.ic_dialog_info));
		tabs.addTab(spec);
		
		//defino la tab por defecto
		tabs.setCurrentTabByTag("tabmapa");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tabs, menu);
		return true;
	}

}
