package com.bpoplataforma.tuevento.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

public class TuEventoSQLiteHelper extends SQLiteOpenHelper {

	private static TuEventoSQLiteHelper sInstance = null;
	
	private SQLiteDatabase db = null;
	
	public static final String DATABASE_NAME = "TuEvento.db";
	public static final int DATABASE_VERSION = 1;
	
	public static final String TABLA_EVENTOS = "eventos";
	public static final String TABLA_USUARIOS = "usuarios";
	public static final String TABLA_TAGS = "tags";
	public static final String TABLA_COMENTARIOS = "comentarios";
	public static final String TABLA_PAISES = "paises";
	public static final String TABLA_CIUDADES = "ciudades";
	public static final String TABLA_EVENTOS_FAVORITOS = "eventos_favoritos";
	public static final String TABLA_TAGS_EVENTOS = "tags_eventos";
	
	
	// Columnas Tabla eventos
	public static final String COLUMNA_EVENTOS_ID = "id";
	public static final String COLUMNA_EVENTOS_NOMBRE = "nombre";
	public static final String COLUMNA_EVENTOS_DESCRIPCION = "descripcion";
	public static final String COLUMNA_EVENTOS_LUGAR = "lugar";
	public static final String COLUMNA_EVENTOS_CIUDAD = "ciudad_id";
	public static final String COLUMNA_EVENTOS_FECHA_COMIENZO = "fecha_comienzo";
	public static final String COLUMNA_EVENTOS_FECHA_FIN = "fecha_fin";
	public static final String COLUMNA_EVENTOS_LAT = "lat";
	public static final String COLUMNA_EVENTOS_LON = "lon";
	
	
	public static final String[] columnasEventos = 
		{ TuEventoSQLiteHelper.COLUMNA_EVENTOS_ID,
		TuEventoSQLiteHelper.COLUMNA_EVENTOS_NOMBRE,
		TuEventoSQLiteHelper.COLUMNA_EVENTOS_DESCRIPCION,
		TuEventoSQLiteHelper.COLUMNA_EVENTOS_LUGAR,
		TuEventoSQLiteHelper.COLUMNA_EVENTOS_CIUDAD,
		TuEventoSQLiteHelper.COLUMNA_EVENTOS_FECHA_COMIENZO,
		TuEventoSQLiteHelper.COLUMNA_EVENTOS_FECHA_FIN,
		TuEventoSQLiteHelper.COLUMNA_EVENTOS_LAT,
		TuEventoSQLiteHelper.COLUMNA_EVENTOS_LON };
	
	// SQL para creacion de la Tabla Eventos
	private static final String TABLA_EVENTOS_CREACION = "CREATE TABLE "
			+ TABLA_EVENTOS + "(" + COLUMNA_EVENTOS_ID + " INTEGER primary key autoincrement, " 
			+ COLUMNA_EVENTOS_NOMBRE + " TEXT not null,"
			+ COLUMNA_EVENTOS_DESCRIPCION + " TEXT,"
			+ COLUMNA_EVENTOS_LUGAR + " TEXT,"
			+ COLUMNA_EVENTOS_CIUDAD + " INTEGER,"
			+ COLUMNA_EVENTOS_FECHA_COMIENZO + " TEXT,"
			+ COLUMNA_EVENTOS_FECHA_FIN + " TEXT,"
			+ COLUMNA_EVENTOS_LAT + " REAL,"
			+ COLUMNA_EVENTOS_LON + " REAL"
					+ ");";
	
	// Columnas Tabla comentarios
	public static final String COLUMNA_COMENTARIOS_ID = "id";
	public static final String COLUMNA_COMENTARIOS_USUARIO = "usuario_id";
	public static final String COLUMNA_COMENTARIOS_EVENTO = "evento_id";
	public static final String COLUMNA_COMENTARIOS_TEXTO = "texto";

	public static final String[] columnasComentarios = 
		{ TuEventoSQLiteHelper.COLUMNA_COMENTARIOS_ID,
		TuEventoSQLiteHelper.COLUMNA_COMENTARIOS_USUARIO,
		TuEventoSQLiteHelper.COLUMNA_COMENTARIOS_EVENTO,
		TuEventoSQLiteHelper.COLUMNA_COMENTARIOS_TEXTO};
	
	private static final String TABLA_COMENTARIOS_CREACION = "CREATE TABLE "
			+ TABLA_COMENTARIOS + "(" + COLUMNA_COMENTARIOS_ID + " INTEGER primary key autoincrement, " 
			+ COLUMNA_COMENTARIOS_USUARIO + " INTEGER not null,"
			+ COLUMNA_COMENTARIOS_EVENTO + " INTEGER not null,"
			+ COLUMNA_COMENTARIOS_TEXTO + " TEXT not null"
		    + ");";

	// Columnas Tabla eventos_favoritos
	public static final String COLUMNA_EVENTOS_FAVORITOS_ID = "id";
	public static final String COLUMNA_EVENTOS_FAVORITOS_USUARIO = "usuario_id";
	public static final String COLUMNA_EVENTOS_FAVORITOS_EVENTO = "evento_id";

	public static final String[] columnasEventosFavoritos = 
		{ TuEventoSQLiteHelper.COLUMNA_EVENTOS_FAVORITOS_ID,
		TuEventoSQLiteHelper.COLUMNA_EVENTOS_FAVORITOS_USUARIO,
		TuEventoSQLiteHelper.COLUMNA_EVENTOS_FAVORITOS_EVENTO};
	
	private static final String TABLA_EVENTOS_FAVORITOS_CREACION = "CREATE TABLE "
			+ TABLA_EVENTOS_FAVORITOS + "(" + COLUMNA_EVENTOS_FAVORITOS_ID + " INTEGER primary key autoincrement, " 
			+ COLUMNA_EVENTOS_FAVORITOS_USUARIO + " INTEGER not null,"
			+ COLUMNA_EVENTOS_FAVORITOS_EVENTO + " INTEGER not null"
			+ ");";
	
	public static TuEventoSQLiteHelper getInstance(Context context) {

		// Use the application context, which will ensure that you 
		// don't accidentally leak an Activity's context.
		// See this article for more information: http://bit.ly/6LRzfx
		if (sInstance == null) {
			sInstance = new TuEventoSQLiteHelper(context.getApplicationContext());
		}
		return sInstance;
	}
	
	private TuEventoSQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	public TuEventoSQLiteHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	public SQLiteDatabase getOpenDb() {
		if (db == null || !db.isOpen()){
			db = sInstance.getWritableDatabase();
		}
		return db;
	}
	
	public void close() {
		if (db != null && db.isOpen()){
			db.close();
		}
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(TABLA_EVENTOS_CREACION);
		database.execSQL(TABLA_COMENTARIOS_CREACION);
		database.execSQL(TABLA_EVENTOS_FAVORITOS_CREACION);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(TuEventoSQLiteHelper.class.getName(),
				"Actualizando la version de la base de datos: " + oldVersion + " a "
						+ newVersion + ", se eliminan los datos viejos en este caso");
		
		// Tabla Deporte
		db.execSQL("DROP TABLE IF EXISTS " + TABLA_EVENTOS);
		onCreate(db);
	}

	
}
