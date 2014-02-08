package com.bpoplataforma.tuevento;

import java.util.List;

import junit.framework.Assert;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.bpoplataforma.tuevento.model.Evento;

public class AdaptadorEvento implements ListAdapter {
	
	private List<Evento> eventos;
	private Activity context;

	public AdaptadorEvento(Activity context, List<Evento> eventos) {
		this.context = context;
		this.eventos = eventos;

	}

	static class ViewHolderEvento {
	    TextView doc;
	    TextView nomb;
	  
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View rowView = convertView;
		ViewHolderEvento holder;
	    if(rowView == null){
	        LayoutInflater inflater = (LayoutInflater) context.getLayoutInflater();
	        rowView = inflater.inflate(R.layout.linea_evento, null);
	        
	        holder = new ViewHolderEvento();
	        holder.nomb = (TextView)  rowView.findViewById(R.id.tvNombre);
	        //holder.imagen = (ImageView) rowView.findViewById(R.id.icon);
	        
	        rowView.setTag(holder);

	    }else{	
	    	
	    	 holder = (ViewHolderEvento) rowView.getTag();
	    }
		
	    holder.nomb.setText( eventos.get(position).getNombre());
		
		return rowView;
	}

	public static int getDrawable(Context context, String name)
    {
        Assert.assertNotNull(context);
        Assert.assertNotNull(name);

        return context.getResources().getIdentifier(name,
                "drawable", context.getPackageName());
    }
	
	
	
	public int getCount() {
		// TODO Auto-generated method stub
		return eventos.size();
	}

	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return eventos.get(arg0);
	}

	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getItemViewType(int arg0) {
		// TODO Auto-generated method stub
		return R.layout.linea_evento;
	}


	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return 1;
	}

	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public void registerDataSetObserver(DataSetObserver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void unregisterDataSetObserver(DataSetObserver arg0) {
		// TODO Auto-generated method stub
		
	}

	public boolean areAllItemsEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled(int arg0) {
		// TODO Auto-generated method stub
		return true;
	}

}
