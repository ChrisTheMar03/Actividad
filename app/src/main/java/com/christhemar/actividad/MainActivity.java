package com.christhemar.actividad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Navigation{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container,new InicioFragment())
                    .commit();
        }
    }


    @Override
    public void navigate(Fragment fragment, boolean addTobackStack) {
        FragmentTransaction transaction=getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container,fragment);

        if(addTobackStack){
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }

    @Override
    public void navigateOptions(Fragment fragment) {
        FragmentTransaction transaction=getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer,fragment);

        transaction.commit();

    }


}