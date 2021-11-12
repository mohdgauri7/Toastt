// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.Nullable;
import com.inmobi.ads.viewsv2.NativeRecyclerViewAdapter;
import androidx.annotation.NonNull;

final class ev
{
    @Nullable
    public static eu a(final byte b, @NonNull final bn bn, @NonNull final eq eq) {
        switch (b) {
            default: {
                return null;
            }
            case 0: {
                return new eo(bn, eq);
            }
            case 1: {
                try {
                    return new NativeRecyclerViewAdapter(bn, eq);
                }
                catch (NoClassDefFoundError noClassDefFoundError) {
                    hf.a((byte)1, "InMobi", "Error rendering ad! RecyclerView not found. Please check if the recyclerview support library was included");
                    fv.a().a(new gv(noClassDefFoundError));
                    return null;
                }
                break;
            }
        }
    }
}
