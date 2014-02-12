package com.bpoplataforma.tuevento;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class DetalleEvento extends TabActivity{

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TabHost host = getTabHost();
    	//A�adimos cada tab, que al ser pulsadas abren sus respectivas Activities
    	host.addTab(host.newTabSpec("activity_detalle_evento").setIndicator("Detalle").setContent(new Intent(this, FichaEvento.class)));
    	host.addTab(host.newTabSpec("activity_detalle_evento").setIndicator("Mapa").setContent(new Intent(this, FichaEvento.class)));
    	host.addTab(host.newTabSpec("activity_detalle_evento").setIndicator("Comentarios").setContent(new Intent(this, FichaEvento.class)));
	}
}
