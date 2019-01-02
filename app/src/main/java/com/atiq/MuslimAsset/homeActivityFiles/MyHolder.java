package com.atiq.MuslimAsset.homeActivityFiles;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.atiq.MuslimAsset.R;

public class MyHolder extends RecyclerView.ViewHolder {

    //Views
    ImageView mImageIv;
    TextView mTitleTv, mDescrTv;


    public MyHolder(@NonNull View itemView) {
        super(itemView);
        this.mImageIv = itemView.findViewById(R.id.modelImageIv);
        this.mTitleTv = itemView.findViewById(R.id.heading);
        this.mDescrTv = itemView.findViewById(R.id.modelDescrTv);
    }
}
