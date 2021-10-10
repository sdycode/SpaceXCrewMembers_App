package com.example.spacexcrew;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.ViewHolder> {
    Context context;
    ArrayList<model> modelList;

    public adapter(Context context, ArrayList<model> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rcv_item_sample,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(adapter.ViewHolder holder, int position) {
model m =modelList.get(position);
holder.nametext.setText(m.name);
holder.agencyText.setText(m.agency);
holder.status.setText(m.status);
holder.wiki.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Uri uri = Uri.parse(m.wikipedia); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(intent);
    }
});
        Glide.with(context)
                .load(m.image)
                .into(holder.img);
//Uri uri = Uri.parse(m.image);
//holder.img.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nametext, agencyText, status , wiki;
        ImageView img;
        public ViewHolder( View itemView) {
            super(itemView);
            nametext = itemView.findViewById(R.id.nameid2);
            agencyText = itemView.findViewById(R.id.agencyid);
            status = itemView.findViewById(R.id.statusid);
            wiki = itemView.findViewById(R.id.wiki);
            img = itemView.findViewById(R.id.imageView);
        }
    }
}
