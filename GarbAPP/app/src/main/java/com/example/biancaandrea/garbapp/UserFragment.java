package com.example.biancaandrea.garbapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.biancaandrea.garbapp.entities.Usuario;


public class UserFragment extends Fragment {
    private static final String TAG = "USERFRAGMENT";
    private TextView usuario;
    private TextView correo_electronico;
    private TextView dsitrito;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView");

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        usuario = view.findViewById(R.id.text_usuario);
        usuario.setText(Usuario.getInstance().getNombre());

        correo_electronico = view.findViewById(R.id.text_correo);
        correo_electronico.setText(Usuario.getInstance().getEmail());

        dsitrito = view.findViewById(R.id.text_distrito);
        dsitrito.setText(Usuario.getInstance().getDistrito());

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate");
    }
}
