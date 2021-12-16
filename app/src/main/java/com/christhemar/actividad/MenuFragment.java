package com.christhemar.actividad;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.christhemar.actividad.FragmentsOptions.AppFragment;
import com.christhemar.actividad.FragmentsOptions.SearchFragment;
import com.christhemar.actividad.FragmentsOptions.UpdateFragment;
import com.christhemar.actividad.FragmentsOptions.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuFragment extends Fragment {

    BottomNavigationView menu;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState==null){
            getActivity().getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentContainer,new AppFragment())
                    .commit();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        menu=view.findViewById(R.id.btnMenu);
        cambioFragmento();
    }

    public void cambioFragmento(){
        menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int udMenu=item.getItemId();
                switch (udMenu){
                    case R.id.btnPrimero:
                        ((Navigation)getActivity()).navigateOptions(new AppFragment());
                        return true;
                    case R.id.btnSegundo:
                        ((Navigation)getActivity()).navigateOptions(new UpdateFragment());
                        return true;
                    case R.id.btnTercera:
                        ((Navigation)getActivity()).navigateOptions(new SearchFragment());
                        return true;
                    case R.id.btnCuarto:
                        ((Navigation)getActivity()).navigateOptions(new UserFragment());
                        return true;
                }
                return false;
            }
        });
    }

}