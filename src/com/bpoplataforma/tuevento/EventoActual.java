package com.bpoplataforma.tuevento;

import java.util.List;
import java.util.Vector;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import com.bpoplataforma.tuevento.dao.EventoDAO;
import com.bpoplataforma.tuevento.model.Evento;
import com.bpoplataforma.tuevento.model.Usuario;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.support.v4.app.FragmentActivity;

public class EventoActual extends FragmentActivity {

	private GoogleMap mMap;
	private EventoDAO datasource;
	private List<Evento> eventos = new Vector<Evento>();
	private Usuario usuario = new Usuario();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_evento_actual);
		setUpMapIfNeeded();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.evento_actual, menu);
		return true;
	}
	
   private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

 
    private void setUpMap() {
//    	mMap.addMarker(new MarkerOptions().position(new LatLng(-31.387554, -57.964565)).title("lala"));
    	datasource = EventoDAO.getInstance(this);
		eventos = datasource.obtenerEventosDeUsuario(usuario);
		for (Evento evento : eventos) {
			mMap.addMarker(new MarkerOptions().position(new LatLng(evento.getLat(), evento.getLon())).title(evento.getNombre()));
		}
        
    }

}
