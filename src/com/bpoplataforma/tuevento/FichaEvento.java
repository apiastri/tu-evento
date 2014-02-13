package com.bpoplataforma.tuevento;

import com.bpoplataforma.tuevento.dao.EventoDAO;
import com.bpoplataforma.tuevento.model.Usuario;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class FichaEvento extends Activity {
	TextView seleccionado;
	TextView comentario;
	private EventoDAO datasource;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalle_evento);
		datasource = EventoDAO.getInstance(this);
		seleccionado = (TextView)findViewById(R.id.txtResultado);
		comentario = (TextView)findViewById(R.id.editText1);
		final Button agregar = (Button)findViewById(R.id.cAlta);
		
		Intent i = getIntent();
		Bundle b = i.getExtras();
		if(b != null){
			String datos = b.getString("datos");
			seleccionado.setText(datos);
			
		}
		
		agregar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String Ecomentario = comentario.getText().toString();
				Intent i = getIntent();
				Bundle b = i.getExtras();
				if(b != null){
					long id = b.getLong("id");
					long idU = 1234;
					datasource.agregarComentarioDelEvento(idU, id, Ecomentario);
					datasource.agregarEventoFavorito(idU, id);
					//if(datasource.agregarEventoFavorito(idU, id)) {
						Toast.makeText(agregar.getContext(), "favorito agregado" + id, Toast.LENGTH_LONG).show();
					//}
				}
				
			}
		});
		
		
	}

}
