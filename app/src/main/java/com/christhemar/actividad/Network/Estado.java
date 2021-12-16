package com.christhemar.actividad.Network;

import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

import com.christhemar.actividad.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Estado {

    private static final String TAG=Estado.class.getCanonicalName();
    public final int id;
    public final String mountain;
    public final Uri dynamicUrl;
    public final String imagen;
    public final String pais;

    public Estado(int id,String mountain, String dynamicUrl,String imagen, String pais){
        this.id=id;
        this.mountain=mountain;
        this.dynamicUrl=Uri.parse(dynamicUrl);
        this.imagen=imagen;
        this.pais=pais;
    }

    public static List<Estado> initEstadoList(Resources resources){
        InputStream inputStream=resources.openRawResource(R.raw.clima);
        Writer writer=new StringWriter();
        char[] buffer=new char[1024];

        try {
            Reader reader=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
            int pointer;
            while ((pointer=reader.read(buffer))!=-1){
                writer.write(buffer,0,pointer);
            }
        }catch (IOException IOX){
            Log.e(TAG,"Error al escribir o leer el archivo JSON",IOX);
        }finally {
            try {
                inputStream.close();
            }catch (IOException IO){
                Log.e(TAG,"Error al cerra la conexion con el archivo",IO);
            }
        }

        String jsonEstadoString=writer.toString();
        Gson gson=new Gson();
        Type estadoType=new TypeToken<ArrayList<Estado>>(){

        }.getType();

        return gson.fromJson(jsonEstadoString,estadoType);

    }

}
