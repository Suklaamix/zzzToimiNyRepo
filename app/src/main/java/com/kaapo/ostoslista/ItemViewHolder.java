package com.kaapo.ostoslista;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    TextView item, extraText;

    ImageView removeImage, editImage;

    EditText editName, editExtra;

    public ItemViewHolder(@NonNull View itemView){
        super(itemView);
        item = itemView.findViewById(R.id.txtOstos);
        extraText = itemView.findViewById(R.id.txtExtra);
        removeImage = itemView.findViewById(R.id.imgDelete);
        editImage = itemView.findViewById(R.id.imgEdit);
        editName = itemView.findViewById(R.id.editName);
        editExtra = itemView.findViewById(R.id.editExtra);
    }
}
