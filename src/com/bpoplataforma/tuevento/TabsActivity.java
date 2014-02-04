package com.bpoplataforma.tuevento;

import java.util.List;
import java.util.Vector;

import com.bpoplataforma.tuevento.dao.EventoDAO;
import com.bpoplataforma.tuevento.model.Evento;
import com.bpoplataforma.tuevento.model.Usuario;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.TabHost;

public class TabsActivity extends FragmentActivity{

	private GoogleMap mMap;
	private List<Evento> eventos = new Vector<Evento>();
	private Usuario usuario = new Usuario();
	
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
		setUpMapIfNeeded();
		
	}
	
   private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapfrag))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

 
    private void setUpMap() {
    	mMap.addMarker(new MarkerOptions().position(new LatLng(-31.387554, -57.964565)).title("lala"));
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tabs, menu);
		return true;
	}

}
