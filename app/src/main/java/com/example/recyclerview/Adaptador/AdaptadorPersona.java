package com.example.recyclerview.Adaptador;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;

import com.example.recyclerview.Modelo.Persona;
import com.example.recyclerview.R;

import java.net.CookieHandler;
import java.util.List;

public class AdaptadorPersona extends RecyclerView.Adapter<AdaptadorPersona.viewHolder> {

    List<Persona> lp;

    public AdaptadorPersona(List<Persona> lp) {
        this.lp = lp;
    }


    @NonNull
    @Override
    public AdaptadorPersona.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = parent.getContext();
       LayoutInflater inflater = LayoutInflater.from(context);

    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPersona.viewHolder viewHolder, final int i) {
        Persona p = lp.get(i);
        viewHolder.txtnombre.setText(p.getNombre());
        viewHolder.txtapellido.setText(p.getApellido());
        viewHolder.txtedad.setText(String.valueOf(p.getNombre()));
        viewHolder.txttelefono.setText(p.getTelefono());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t = new Intent(Intent.ACTION_CALL);
                t.setData(Uri.parse("tel: ", p.getTelefono()));
            }
        });





    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView txtnombre;
        TextView txtapellido;
        TextView txtedad;
        TextView txttelefono;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            TextView txtnombre = itemView.findViewById(R.id.txtnombre);
            TextView txtapellido= itemView.findViewById(R.id.txtapellido);
            TextView txtedad= itemView.findViewById(R.id.txtedad);
            TextView txttelefoo = itemView.findViewById(R.id.txtelefono);

        }
    }
}
