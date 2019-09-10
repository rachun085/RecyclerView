package com.example.admin.pigfarm.ManageData_Page;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.pigfarm.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private Context mCtx;
    private List<Model> profilepig;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){

        mListener = listener;
    }

    public MyAdapter(Context mCtx, List<Model> profilepig){
        this.mCtx = mCtx;
        this.profilepig = profilepig;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_item_datamanage,null);
        return new MyAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, final int position) {
        Model model = profilepig.get(position);

        String pig_id = model.getPig_id();

        holder.textpigid.setText("เบอร์หู : "+model.getPig_id());


    }

    @Override
    public int getItemCount() {
        return profilepig.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textpigid;

        public MyViewHolder(View itemView){
            super(itemView);

            textpigid = itemView.findViewById(R.id.textpigid);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (profilepig != null){
                                int position = getAdapterPosition();
                                if (position != RecyclerView.NO_POSITION){
                                    mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }


}
