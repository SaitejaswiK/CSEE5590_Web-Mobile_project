package com.sawapps.baymaxhealthcare.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sawapps.baymaxhealthcare.DoctorsList;
import com.sawapps.baymaxhealthcare.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.ViewHolder> {
    public static  final String KEY_NAME = "name";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_ADDR = "address";

    private List<DoctorsList> doctorsLists;
    private  Context context;

    public DoctorAdapter(List<DoctorsList> doctorslist, Context applicationContext) {
        this.doctorsLists = doctorslist;
        this.context = applicationContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_doctor, viewGroup, false);

        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final DoctorsList doctorsList = doctorsLists.get(i);
        viewHolder.doc_name.setText(doctorsList.get_doc_name());

        Picasso.get().load(doctorsList.get_doc_img()).into(viewHolder.doc_image);

        viewHolder.doc_address.setText(doctorsList.get_doc_addr());
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
