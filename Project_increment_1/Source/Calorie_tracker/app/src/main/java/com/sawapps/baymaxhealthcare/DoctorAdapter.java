package com.sawapps.baymaxhealthcare;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.ViewHolder> {
    public static  final String KEY_NAME = "name";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_ADDR = "address";

    private List<DoctorsList> doctorsLists;
    private  Context context;

    public DoctorAdapter(List<DoctorsList> doctorslist, Context applicationContext) {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return doctorsLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView doc_name;
        public ImageView doc_image;
        public  TextView doc_address;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            doc_name = (TextView) itemView.findViewById(R.id.docname);
            doc_image = (ImageView) itemView.findViewById(R.id.docimage);
            doc_address = (TextView) itemView.findViewById(R.id.docaddr);
        }
    }
}
