package com.christhemar.actividad.FragmentsOptions;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.christhemar.actividad.EstadoCardRecyclerViewAdapter;
import com.christhemar.actividad.Network.Estado;
import com.christhemar.actividad.R;

public class AppFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_app, container, false);
        //Capturando el rv
        RecyclerView recyclerView=view.findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1,GridLayoutManager.HORIZONTAL,false));
        EstadoCardRecyclerViewAdapter adapter=new EstadoCardRecyclerViewAdapter(
                Estado.initEstadoList(getResources()));
        recyclerView.setAdapter(adapter);
        return view;
    }

}