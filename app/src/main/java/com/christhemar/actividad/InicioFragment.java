package com.christhemar.actividad;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class InicioFragment extends Fragment {

    ImageButton btnIr;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnIr=view.findViewById(R.id.btnIrMenu);

        btnIr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irMenu();
            }
        });

    }

    public void irMenu(){
        ((Navigation)getActivity()).navigate(new MenuFragment(),false);
    }

}