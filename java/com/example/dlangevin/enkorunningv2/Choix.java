package com.example.dlangevin.enkorunningv2;

import android.view.View;

/**
 * ONGLET CALORIES DANS LA PAGE SANTE
 */
public class Choix {
    private String mName;
    private int mThumbnail;
    private View.OnClickListener onClickListener;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public int getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.mThumbnail = thumbnail;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}

