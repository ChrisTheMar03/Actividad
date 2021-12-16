package com.christhemar.actividad;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;

public class EstadoCardViewHolder extends RecyclerView.ViewHolder {

    public TextView estadoMountain;
    public NetworkImageView estadoImagen;
    public TextView estadoPais;

    public EstadoCardViewHolder(@NonNull View itemView){
        super(itemView);
        estadoMountain=itemView.findViewById(R.id.txtmountain);
        estadoImagen=itemView.findViewById(R.id.imgEstado);
        estadoPais=itemView.findViewById(R.id.txtpais);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context  context=view.getContext();
                Intent intent=new Intent(context,DetalleActivity.class);
                intent.putExtra("mountain",EstadoCardRecyclerViewAdapter.estadoList.get(getAdapterPosition()).mountain);
                intent.putExtra("img",EstadoCardRecyclerViewAdapter.estadoList.get(getAdapterPosition()).imagen);
                context.startActivity(intent);
            }
        });

    }

}
