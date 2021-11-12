// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.NonNull;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaMetadataRetriever;
import android.view.ViewGroup;
import android.view.View;
import android.content.Context;
import android.widget.ProgressBar;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class ey extends RelativeLayout
{
    private static final String a;
    private ex b;
    private ImageView c;
    private ProgressBar d;
    
    public ey(final Context context) {
        super(context);
        this.b = new ex(this.getContext());
        final RelativeLayout.LayoutParams layoutParams;
        (layoutParams = new RelativeLayout.LayoutParams(-1, -1)).addRule(13);
        this.addView((View)this.b, (ViewGroup.LayoutParams)layoutParams);
        (this.c = new ImageView(this.getContext())).setScaleType(ImageView.ScaleType.FIT_XY);
        this.c.setVisibility(8);
        this.addView((View)this.c, (ViewGroup.LayoutParams)layoutParams);
        (this.d = new ProgressBar(this.getContext())).setVisibility(8);
        final RelativeLayout.LayoutParams layoutParams2;
        (layoutParams2 = new RelativeLayout.LayoutParams(-2, -2)).addRule(13);
        this.addView((View)this.d, (ViewGroup.LayoutParams)layoutParams2);
        final ew mediaController = new ew(this.getContext());
        final RelativeLayout.LayoutParams layoutParams3;
        (layoutParams3 = new RelativeLayout.LayoutParams(-1, -1)).addRule(13);
        this.b.setMediaController(mediaController);
        this.addView((View)mediaController, (ViewGroup.LayoutParams)layoutParams3);
    }
    
    public final void a() {
        final bw bw;
        if ((bw = (bw)this.b.getTag()) != null) {
            RelativeLayout.LayoutParams layoutParams;
            try {
                final MediaMetadataRetriever mediaMetadataRetriever;
                (mediaMetadataRetriever = new MediaMetadataRetriever()).setDataSource(bw.b().b());
                final int intValue = Integer.valueOf(mediaMetadataRetriever.extractMetadata(18));
                final int intValue2 = Integer.valueOf(mediaMetadataRetriever.extractMetadata(19));
                mediaMetadataRetriever.release();
                final Point a;
                double n;
                double n2;
                if (ez.c((a = bw.c.a).x) / (double)ez.c(a.y) > intValue / (double)intValue2) {
                    n = intValue * (ez.c(a.y) * 1.0 / intValue2);
                    n2 = ez.c(a.y);
                }
                else {
                    n = ez.c(a.x);
                    n2 = intValue2 * (ez.c(a.x) * 1.0 / intValue);
                }
                layoutParams = new RelativeLayout.LayoutParams((int)n, (int)n2);
            }
            catch (Exception ex) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                fv.a().a(new gv(ex));
            }
            layoutParams.addRule(13);
            this.b.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        }
    }
    
    public void setPosterImage(@NonNull final Bitmap imageBitmap) {
        this.c.setImageBitmap(imageBitmap);
    }
    
    @NonNull
    public ex getVideoView() {
        return this.b;
    }
    
    @NonNull
    public ImageView getPoster() {
        return this.c;
    }
    
    @NonNull
    public ProgressBar getProgressBar() {
        return this.d;
    }
    
    static {
        a = ey.class.getSimpleName();
    }
}
