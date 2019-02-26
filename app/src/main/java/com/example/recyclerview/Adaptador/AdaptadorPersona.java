package com.example.recyclerview.Adaptador;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclerview.Modelo.Persona;
import com.example.recyclerview.R;

import java.util.List;

public class AdaptadorPersona extends RecyclerView.Adapter<AdaptadorPersona.viewHolder> {

    List<Persona> lp;

    public AdaptadorPersona(List<Persona> lp) {
        this.lp = lp;
    }


    @NonNull
    @Override
    public AdaptadorPersona.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemrcvd, viewGroup, false);
       viewHolder vh = new viewHolder(v);
       return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPersona.viewHolder viewHolder, int i) {
        viewHolder.txtnombre.setText(lp.get(i).getNombre());
        viewHolder.txtapellido.setText(lp.get(i).getApellido());
        viewHolder.txtnombre.setText(String.valueOf(lp.get(i).getNombre()));

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView txtnombre;
        TextView txtapellido;
        TextView txtedad;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            TextView txtnombre = itemView.findViewById(R.id.txtnombre);
            TextView txtapellido= itemView.findViewById(R.id.txtapellido);
            TextView txtedad= itemView.findViewById(R.id.txtedad);

        }
    }
}
