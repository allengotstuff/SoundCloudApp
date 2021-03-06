package com.example.allengotstuff.soundcloudapp.list.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.allengotstuff.soundcloudapp.R;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by allengotstuff on 4/8/2017.
 */

public class HotSongHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.title)
    public TextView title;

    @BindView(R.id.art_image)
    public SimpleDraweeView artImage;

    public View itemView;

    public HotSongHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        ButterKnife.bind(this, itemView);
    }

}
