package com.bpoplataforma.tuevento.dao;

import java.util.List;
import java.util.Vector;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.bpoplataforma.tuevento.dao.EventoDAO;
import com.bpoplataforma.tuevento.model.Evento;
import com.bpoplataforma.tuevento.model.Usuario;
import com.bpoplataforma.tuevento.sql.TuEventoSQLiteHelper;

public class EventoDAO {
	
	private static EventoDAO eventoInstance = null;
	
	private TuEventoSQLiteHelper dbHelper;
	private SQLiteDatabase db;
	
	private EventoDAO(Context context) {
		dbHelper = TuEventoSQLiteHelper.getInstance(context);
		db = dbHelper.getOpenDb();
	}

	public static EventoDAO getInstance(Context context) {
		
		if (eventoInstance == null) {
			eventoInstance = new EventoDAO(context);
		}
		return eventoInstance;
	}
	
	public List<Evento> obtenerEventosDeUsuario(Usuario usuario) {
		
		// Creo una lista vacia de eventos
		List<Evento> eventos = new Vector<Evento>();

		Cursor cursor = db.query(TuEventoSQLiteHelper.TABLA_EVENTOS,
				TuEventoSQLiteHelper.columnasEventos, null, null, null, null, null);

		//Log.d("CURSOR_EVENTOS", DatabaseUtils.dumpCursorToString(cursor));
		
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Evento evento = crearEventoDesdeCursor(cursor);
			Log.d("evento del cursor",evento.getNombre().toString());
			Log.d("Fecha del evento",evento.getFechaComienzo().toString());
			eventos.add(evento);
			cursor.moveToNext();
		}

		cursor.close();
		
		return eventos;
	}
	
	private Evento crearEventoDesdeCursor(Cursor cursor) {
		
		Evento evento = null;
		
		try {
			evento = new Evento(
					cursor.getLong(0),    // id
					cursor.getString(1),  // nombre
					cursor.getString(2),  // descripcion
					cursor.getString(3),  // Lugar
					cursor.getLong(4),     // Ciudad
					cursor.getString(5),  //Fecha comienzo
					cursor.getString(6),  //Fecha fin
					cursor.getDouble(7),
					cursor.getDouble(8)); 			
		} catch (Exception e) {
			Log.d("Excepción al crear evento",e.getMessage());
		}
		return evento;
	}
	
	public void crearEventosDePrueba(){
		
		db.delete(TuEventoSQLiteHelper.TABLA_EVENTOS, 
				null, null);
		
		ContentValues values = new ContentValues();
		values.put(TuEventoSQLiteHelper.COLUMNA_EVENTOS_NOMBRE, "Nombre evento 1");
		values.put(TuEventoSQLiteHelper.COLUMNA_EVENTOS_DESCRIPCION, "Desc. evento 1");
		values.put(TuEventoSQLiteHelper.COLUMNA_EVENTOS_LUGAR, "Lugar evento 1");
		values.put(TuEventoSQLiteHelper.COLUMNA_EVENTOS_CIUDAD, 1);
		values.put(TuEventoSQLiteHelper.COLUMNA_EVENTOS_FECHA_COMIENZO, "01-02-2014");
		values.put(TuEventoSQLiteHelper.COLUMNA_EVENTOS_FECHA_FIN, "05-02-2014");
		values.put(TuEventoSQLiteHelper.COLUMNA_EVENTOS_LAT, -31.387554);
		values.put(TuEventoSQLiteHelper.COLUMNA_EVENTOS_LON, -57.964565);

		db.insert(TuEventoSQLiteHelper.TABLA_EVENTOS, 
				null, values);
		
		values = new ContentValues();
		values.put(TuEventoSQLiteHelper.COLUMNA_EVENTOS_NOMBRE, "Nombre evento 2");
		values.put(TuEventoSQLiteHelper.COLUMNA_EVENTOS_DESCRIPCION, "Desc. evento 2");
		values.put(TuEventoSQLiteHelper.COLUMNA_EVENTOS_LUGAR, "Lugar evento 2");
		values.put(TuEventoSQLiteHelper.COLUMNA_EVENTOS_CIUDAD, 2);
		values.put(TuEventoSQLiteHelper.COLUMNA_EVENTOS_FECHA_COMIENZO, "01-03-2014");
		values.put(TuEventoSQLiteHelper.COLUMNA_EVENTOS_FECHA_FIN, "05-03-2014");
		values.put(TuEventoSQLiteHelper.COLUMNA_EVENTOS_LAT, 38.986743);
		values.put(TuEventoSQLiteHelper.COLUMNA_EVENTOS_LON, -1.866398);
		
		db.insert(TuEventoSQLiteHelper.TABLA_EVENTOS, 
				null, values);	

	}
}

