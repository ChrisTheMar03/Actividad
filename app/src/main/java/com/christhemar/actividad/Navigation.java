package com.christhemar.actividad;

import androidx.fragment.app.Fragment;

public interface Navigation {

    void navigate(Fragment fragment, boolean addTobackStack);
    void navigateOptions(Fragment fragment);

}
