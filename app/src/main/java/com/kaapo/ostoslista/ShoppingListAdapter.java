package com.kaapo.ostoslista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShoppingListAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private Context context;
    private ArrayList<Item> items = new ArrayList<>();

    public ShoppingListAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.item.setText(items.get(position).getOstos());
        holder.extraText.setText(items.get(position).getExtraTxt());

        holder.editName.setText(items.get(position).getOstos());
        holder.editExtra.setText(items.get(position).getExtraTxt());

        holder.removeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                ItemStorage.getInstance().removeItem(items.get(pos).getOstos());
                notifyItemRemoved(pos);
            }
        });

        holder.editImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();

                if(holder.editName.getVisibility() == View.VISIBLE) {
                    Item item = ItemStorage.getInstance().getItemByObject(pos);
                    item.setOstos(holder.editName.getText().toString());
                    item.setExtraTxt(holder.editExtra.getText().toString());

                    holder.editName.setVisibility(View.GONE);
                    holder.editExtra.setVisibility(View.GONE);

                    notifyDataSetChanged();
                }
                else {
                    holder.editName.setVisibility(View.VISIBLE);
                    holder.editExtra.setVisibility(View.VISIBLE);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return items.size();
    }
}
