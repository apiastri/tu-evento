package com.bpoplataforma.tuevento;

import java.util.List;

import com.bpoplataforma.tuevento.dao.EventoDAO;
import com.bpoplataforma.tuevento.model.Evento;
import com.bpoplataforma.tuevento.model.Usuario;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListaEvento extends Activity {

	private EventoDAO datasource;
	private List<Evento> listaSocio;

	ListView lista;
	
	TextView seleccionado;
	private static final int USUARIO_OK = 0;
	private int itemSocioSeleccionado;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_evento);
		lista = (ListView) findViewById(R.id.lvlista);
		datasource = EventoDAO.getInstance(this);
		this.rellenarlista();
		
	
		seleccionado = (TextView)findViewById(R.id.seleccionado);
	        
	        /*lista.setOnItemClickListener(new OnItemClickListener() {
	        	@Override
	            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
	            	//seleccionado.setText("Has seleccionado: "+ lista.getItemIdAtPosition(position) );
	        	}
	          });*/
		
		
				
	}
	
	
	
	
	
	
	private void rellenarlista(){
		//ArrayList<Socio> listaSocio = new ArrayList();
		
		//listaSocio = Polideportivo.getInstancia().getSocios();
		listaSocio = datasource.obtenerEventosDeUsuario(new Usuario());
//		final ArrayAdapter<Socio> aA = new ArrayAdapter<Socio>(this, android.R.layout., listaSocio);
		ListAdapter la = new AdaptadorEvento(this, listaSocio);
		lista.setAdapter(la);
	}


}
