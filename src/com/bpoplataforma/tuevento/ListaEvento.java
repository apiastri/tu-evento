package com.bpoplataforma.tuevento;

import java.util.List;

import com.bpoplataforma.tuevento.dao.EventoDAO;
import com.bpoplataforma.tuevento.model.Evento;
import com.bpoplataforma.tuevento.model.Usuario;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListaEvento extends Activity {

	private EventoDAO datasource;
	private List<Evento> listaE;
	ListView lista;
	Bundle b = new Bundle();
	private int position;
	
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_evento);
		lista = (ListView) findViewById(R.id.lvlista);
		datasource = EventoDAO.getInstance(this);
		this.rellenarlista();
	
	       lista.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> a, View v, int position, long id) {
			     
			        String opcionSeleccionada = ( "Evento: " +((Evento)a.getAdapter().getItem(position)).getNombre() +"\nCiudad: "+ ((Evento)a.getAdapter().getItem(position)).getCiudadId()+"\nDescripcion: "+ ((Evento)a.getAdapter().getItem(position)).getDescripcion()+"\nLugar: "+ ((Evento)a.getAdapter().getItem(position)).getLugar()+"\nFecha de comienzo: "+ ((Evento)a.getAdapter().getItem(position)).getFechaComienzo()+"\nFecha fin: "+ ((Evento)a.getAdapter().getItem(position)).getFin()+"\nLatitude: "+ ((Evento)a.getAdapter().getItem(position)).getLat()+"\nLongitude: "+ ((Evento)a.getAdapter().getItem(position)).getLon());
			        long id1 = (((Evento)a.getAdapter().getItem(position)).getId());
			        b.putString("datos", opcionSeleccionada);
			        b.putLong("id", id1);
			        Intent i = new Intent(ListaEvento.this, FichaEvento.class);
					i.putExtras(b);
					startActivity(i);
				}
	          });
		
		
				
	}

	
	
	private void rellenarlista(){
		listaE = datasource.obtenerEventosDeUsuario(new Usuario());
		ListAdapter la = new AdaptadorEvento(this, listaE);
		lista.setAdapter(la);
	}


}
