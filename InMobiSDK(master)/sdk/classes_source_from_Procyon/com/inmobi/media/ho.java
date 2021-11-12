// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import android.view.WindowInsets;
import android.view.Window;
import android.app.Activity;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Map;
import android.content.Context;
import android.view.WindowManager;
import android.util.DisplayMetrics;

public class ho
{
    private static final String a;
    private static String b;
    
    public static int a(final int n) {
        return Math.round(n * a().c);
    }
    
    public static hp a() {
        final Context c;
        if ((c = gz.c()) == null) {
            return new hp(0, 0, 2.0f);
        }
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager)c.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        final float density = displayMetrics.density;
        return new hp(Math.round(displayMetrics.widthPixels / density), Math.round(displayMetrics.heightPixels / density), density);
    }
    
    public static int b(final int n) {
        return Math.round(n / a().c);
    }
    
    public static byte b() {
        final Context c;
        if ((c = gz.c()) == null) {
            return 1;
        }
        final int rotation = ((WindowManager)c.getSystemService("window")).getDefaultDisplay().getRotation();
        switch (c.getResources().getConfiguration().orientation) {
            case 1: {
                if (rotation == 1 || rotation == 2) {
                    return 2;
                }
                return 1;
            }
            case 2: {
                if (rotation == 0 || rotation == 1) {
                    return 3;
                }
                return 4;
            }
            default: {
                return 1;
            }
        }
    }
    
    public static Map<String, String> c() {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        try {
            hashMap.put("d-device-screen-density", String.valueOf(a().c));
            final HashMap<String, String> hashMap2 = hashMap;
            final String s = "d-device-screen-size";
            final hp a = a();
            hashMap2.put(s, a.a + "X" + a.b);
            final HashMap<String, String> hashMap3 = hashMap;
            final String s2 = "d-density-dependent-screen-size";
            final Context c;
            String string;
            if ((c = gz.c()) == null) {
                string = "0x0";
            }
            else {
                final DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager)c.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                string = displayMetrics.widthPixels + "x" + displayMetrics.heightPixels;
            }
            hashMap3.put(s2, string);
            hashMap.put("d-orientation", String.valueOf(b()));
            hashMap.put("d-textsize", String.valueOf(new TextView(gz.c()).getTextSize()));
        }
        catch (Exception ex) {}
        return hashMap;
    }
    
    @RequiresApi(api = 29)
    public static void a(final Context context) {
        if (!(context instanceof Activity)) {
            return;
        }
        final Window window;
        if ((window = ((Activity)context).getWindow()) == null) {
            return;
        }
        final WindowInsets rootWindowInsets;
        if ((rootWindowInsets = window.getDecorView().getRootWindowInsets()) == null) {
            return;
        }
        a(context, rootWindowInsets);
    }
    
    @RequiresApi(api = 29)
    public static void a(final Context context, final WindowInsets windowInsets) {
        gz.a(new Runnable() {
            @Override
            public final void run() {
                try {
                    final String[] split = windowInsets.getSystemGestureInsets().toString().split("Insets");
                    final StringBuffer sb = new StringBuffer();
                    if (split.length > 1) {
                        final String[] split2 = split[1].replaceAll("[^0-9,=a-zA-Z]*", "").split(",");
                        sb.append("{");
                        for (int i = 0; i < split2.length; ++i) {
                            final String[] split3;
                            if ((split3 = split2[i].split("=")).length == 2) {
                                sb.append("\"" + split3[0] + "\"");
                                sb.append(":");
                                sb.append(ho.b(Integer.parseInt(split3[1])));
                                if (i < split2.length - 1) {
                                    sb.append(", ");
                                }
                            }
                        }
                        sb.append("}");
                    }
                    if (sb.length() > 0) {
                        ho.b = sb.toString();
                        gu.a(context, "gesture_info_store").a("gesture_margin", sb.toString());
                    }
                }
                catch (Exception ex) {
                    ho.a;
                }
            }
        });
    }
    
    @Nullable
    public static String d() {
        if (ho.b != null) {
            return ho.b;
        }
        final Context c;
        return ho.b = (((c = gz.c()) == null) ? null : gu.a(c, "gesture_info_store").b("gesture_margin"));
    }
    
    static {
        a = ho.class.getSimpleName();
        ho.b = null;
    }
}
