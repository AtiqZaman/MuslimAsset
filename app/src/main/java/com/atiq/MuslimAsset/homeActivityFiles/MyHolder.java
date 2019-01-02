package com.atiq.MuslimAsset.homeActivityFiles;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.atiq.MuslimAsset.R;

public class MyHolder extends RecyclerView.ViewHolder {

    //Views
    ImageView ivImage;
    TextView tvTitelHeading,tvTitleSubHeading, tvDescrArabic, tvDescrTrans;


    public MyHolder(@NonNull View itemView) {
        super(itemView);
        this.ivImage = itemView.findViewById(R.id.ivImage);
        this.tvTitelHeading = itemView.findViewById(R.id.tvTitleHeading);
        this.tvTitleSubHeading = itemView.findViewById(R.id.tvTitleSubHeading);
        this.tvDescrArabic = itemView.findViewById(R.id.descrTextviewArabic);
        this.tvDescrTrans = itemView.findViewById(R.id.descrTextviewTrans);
    }
}
