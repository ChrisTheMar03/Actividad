package com.christhemar.actividad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.christhemar.actividad.Network.Estado;
import com.christhemar.actividad.Network.ImageRequester;

import java.util.List;

public class EstadoCardRecyclerViewAdapter extends RecyclerView.Adapter<EstadoCardViewHolder> {

    public static List<Estado> estadoList;
    private ImageRequester imageRequester;

    public EstadoCardRecyclerViewAdapter(List<Estado> estadoList){
        this.estadoList=estadoList;
        imageRequester=ImageRequester.getInstance();
    }

    @NonNull
    @Override
    public EstadoCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView= LayoutInflater.from(parent.getContext()).inflate(R.layout.estado_item,parent,false);
        return new EstadoCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull EstadoCardViewHolder holder, int position) {
        if(estadoList!=null && position<estadoList.size()){
            Estado estado=estadoList.get(position);
            holder.estadoMountain.setText(estado.mountain);
            imageRequester.setImageFormUrl(holder.estadoImagen,estado.imagen);
            holder.estadoPais.setText(estado.pais);
        }
    }

    @Override
    public int getItemCount() {
        return estadoList.size();
    }
}
