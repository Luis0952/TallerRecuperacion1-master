package com.taller.tallerrecuperacion.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.taller.tallerrecuperacion.InformationActivity;
import com.taller.tallerrecuperacion.Models.ComidaModel;
import com.taller.tallerrecuperacion.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luis Eduardo on 13/11/2017.
 */

public class ComidaAdapter  extends RecyclerView.Adapter<ComidaAdapter.ViewHolder> {
    List<ComidaModel> contactList = new ArrayList<>();
    Context context;

    public ComidaAdapter(List<ComidaModel> contactList, Context context) {
        this.contactList = contactList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comida, parent, false);
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textViewName.setText(contactList.get(position).getName());
        holder.textViewProcedencia.setText(contactList.get(position).getProcedencia());
     holder.textViewTipo.setText(contactList.get(position).getTipo());
        holder.textviewingredientes.setText(contactList.get(position).getIngredientes());


    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textViewName;
        TextView textViewProcedencia;
        TextView textViewTipo;
       TextView textviewingredientes;


        public ViewHolder(View item) {
            super(item);

            item.setOnClickListener(this);

            textViewName = (TextView) item.findViewById(R.id.id_tv_item_name);
            textViewProcedencia= (TextView) item.findViewById(R.id.id_tv_item_procedencia);
           textViewTipo = (TextView) item.findViewById(R.id.id_tv_item_tipo);
           textviewingredientes = (TextView) item.findViewById(R.id.id_tv_item_ingredientes);


        }

        @Override
        public void onClick(View view) {
            Context contextItem = view.getContext();

            Intent intent = new Intent(context, InformationActivity.class);
            intent.putExtra("id", Integer.toString(contactList.get(getLayoutPosition()).getId()));

           intent.putExtra("name", contactList.get(getLayoutPosition()).getName());
            intent.putExtra("procedencia", contactList.get(getLayoutPosition()).getProcedencia());
            intent.putExtra("tipo", contactList.get(getLayoutPosition()).getTipo());
            intent.putExtra("ingredientes", contactList.get(getLayoutPosition()).getIngredientes());
            contextItem.startActivity(intent);


            //String valor = Integer.toString(albumModelList.get(getLayoutPosition()).getId());
            //Toast.makeText(contextItem, valor, Toast.LENGTH_SHORT).show();
        }
    }

}
