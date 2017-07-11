package com.example.germanpereyra.instaslam.model;

import android.net.Uri;

/**
 * Created by germanpereyra on 25/Jul/16.
 */
public class InstaImage {
    private Uri imgResourceURL;

    public Uri getImgResourceURL() {
        return imgResourceURL;
    }

    public InstaImage(Uri imgResourceURL) {
        this.imgResourceURL = imgResourceURL;
    }
}
