package com.christhemar.actividad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.christhemar.actividad.Network.ImageRequester;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class DetalleActivity extends AppCompatActivity {

    String Bmountain,imgEnlace;
    BottomSheetBehavior bottomSheetBehavior;
    NetworkImageView imgNet;
    TextView txtMoun;
    ImageRequester imageRequester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        imageRequester=ImageRequester.getInstance();
        txtMoun=findViewById(R.id.txtMountainSheet);
        imgNet=findViewById(R.id.imgSheet);

        if(savedInstanceState==null){
            Bundle bundle=getIntent().getExtras();
            if(bundle==null){
                Bmountain=null;
            }else{
                Bmountain=bundle.getString("mountain");
                imgEnlace=bundle.getString("img");
                txtMoun.setText(Bmountain+"");
                imageRequester.setImageFormUrl(imgNet,imgEnlace);
            }
        }else{
            Bmountain=(String)savedInstanceState.getSerializable("mountain");
        }


        bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.bottom_sheet));
        bottomSheetBehavior.setPeekHeight(300);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

    }
}