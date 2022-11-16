package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.ViewHolderHome> implements View.OnClickListener{
    ArrayList<AdapHome> ListaMenu;
    private View.OnClickListener listener;

    public AdapterHome(ArrayList<AdapHome> ListaMenu) {
        this.ListaMenu = ListaMenu;
    }


    @Override
    public AdapterHome.ViewHolderHome onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_lista, null, false);
        view.setOnClickListener(this);
        return new ViewHolderHome(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHome.ViewHolderHome holder, int position) {
        holder.foto.setImageResource(ListaMenu.get(position).getFoto());

    }

    @Override
    public int getItemCount() {
        return ListaMenu.size();
    }

    public void setOnClick(View.OnClickListener listener){
        this.listener = listener;

    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }

    }


    public class ViewHolderHome extends RecyclerView.ViewHolder {

        ImageView foto;

        public ViewHolderHome(@NonNull View itemView) {
            super(itemView);
            foto = (ImageView) itemView.findViewById(R.id.idImagen);

        }
    }
}
