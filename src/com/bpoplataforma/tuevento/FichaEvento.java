package com.bpoplataforma.tuevento;

import com.bpoplataforma.tuevento.dao.EventoDAO;
import com.bpoplataforma.tuevento.model.Usuario;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class FichaEvento extends Activity {

	private EventoDAO datasource;
	
	private TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalle_evento);
		
		datasource = EventoDAO.getInstance(this);
		textView = (TextView) findViewById( R.id.txtResultado );
		textView.setTextSize(28);
		textView.setText((CharSequence) datasource.obtenerEventosDeUsuario(new Usuario()));
		
	}

}
