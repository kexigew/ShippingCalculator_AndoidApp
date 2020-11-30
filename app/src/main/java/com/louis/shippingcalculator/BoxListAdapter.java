package com.louis.shippingcalculator;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.louis.shippingcalculator.model.Address;
import com.louis.shippingcalculator.model.Box;

import java.util.List;

public class BoxListAdapter extends RecyclerView.Adapter<BoxListAdapter.ViewHolder> {

    public static final String TAG = "BoxListAdapter";

    private Context context;
    private List<Box> boxList;

    public BoxListAdapter(Context context, List<Box> boxList) {
        this.context = context;
        this.boxList = boxList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_box, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameTV.setText(boxList.get(position).getName());
        holder.widthTV.setText(Double.toString(boxList.get(position).getWidth()));
        holder.heightTV.setText(Double.toString(boxList.get(position).getHeight()));
        holder.depthTV.setText(Double.toString(boxList.get(position).getDepth()));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: " + boxList.get(position).toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return boxList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout parentLayout;
        TextView nameTV;
        TextView widthTV;
        TextView heightTV;
        TextView depthTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            parentLayout = itemView.findViewById(R.id.parent_layout);
            nameTV = itemView.findViewById(R.id.name);
            widthTV = itemView.findViewById(R.id.width);
            heightTV = itemView.findViewById(R.id.height);
            depthTV = itemView.findViewById(R.id.depth);
        }
    }
}