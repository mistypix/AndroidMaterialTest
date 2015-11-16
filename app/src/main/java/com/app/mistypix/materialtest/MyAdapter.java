package com.app.mistypix.materialtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

/**
 * Created by Vikrant on 13-11-2015.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    private List<Information> data= Collections.emptyList();
    private Context context;


    public MyAdapter(Context context,List<Information> data){
        this.context=context;
        inflater=LayoutInflater.from(context);
        this.data=data;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("MYTAG", "onCreateViewHolder called "+parent);
        View view=inflater.inflate(R.layout.custom_row,parent,false);
        MyViewHolder holder=new  MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.d("MYTAG","onBindViewHolder called "+position);
        Information current=data.get(position);
        holder.title.setText(current.text);
        holder.icon.setImageResource(current.itemId);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public void delete(int position){
        data.remove(position);
        notifyItemRemoved(position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        ImageView icon;

        public MyViewHolder(View itemView){
            super(itemView);
            Log.d("MYTAG","inside MyViewHolder");

            title=(TextView)itemView.findViewById(R.id.textView);
            icon=(ImageView)itemView.findViewById(R.id.imageView);
            icon.setOnClickListener(this);
        }

        public void onClick(View v){
            //Toast.makeText(context,"Item clicked at: "+getAdapterPosition(),Toast.LENGTH_SHORT).show();
            Log.d("MYTAG","Item clicked at: "+getAdapterPosition());
            delete(getAdapterPosition());
        }
    }


}
