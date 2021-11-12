// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.Collection;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;
import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import androidx.annotation.Nullable;

public class cw
{
    private static final String h;
    @Nullable
    private String i;
    int a;
    int b;
    List<a> c;
    public List<bv> d;
    public String e;
    static final ArrayList<String> f;
    public boolean g;
    
    public cw(final int a, final int b, @Nullable final String i) {
        this.i = i;
        this.a = a;
        this.b = b;
        this.e = null;
        this.c = new ArrayList<a>();
        this.d = new ArrayList<bv>();
    }
    
    @NonNull
    public final List<a> a(final int n) {
        final ArrayList<a> list = new ArrayList<a>();
        final Iterator<a> iterator = this.c.iterator();
        while (iterator.hasNext()) {
            final a a;
            if ((a = iterator.next()).a == n) {
                list.add(a);
            }
        }
        return list;
    }
    
    public final void a(@NonNull final a a) {
        this.c.add(a);
    }
    
    @NonNull
    public final List<bv> a(final String anObject) {
        final ArrayList<bv> list = new ArrayList<bv>();
        final Iterator<bv> iterator = this.d.iterator();
        while (iterator.hasNext()) {
            final bv bv;
            if ((bv = iterator.next()).d.equals(anObject)) {
                list.add(bv);
            }
        }
        return list;
    }
    
    public final void a(@NonNull final bv bv) {
        this.d.add(bv);
    }
    
    @Override
    public String toString() {
        final JSONObject jsonObject = new JSONObject();
        try {
            if (this.i != null) {
                jsonObject.put("id", (Object)this.i);
            }
            jsonObject.put("width", this.a);
            jsonObject.put("height", this.b);
            jsonObject.put("clickThroughUrl", (Object)this.e);
            final JSONArray jsonArray = new JSONArray();
            final Iterator<a> iterator = this.c.iterator();
            while (iterator.hasNext()) {
                jsonArray.put((Object)iterator.next().toString());
            }
            jsonObject.put("resources", (Object)jsonArray);
            final JSONArray jsonArray2 = new JSONArray();
            final Iterator<bv> iterator2 = this.d.iterator();
            while (iterator2.hasNext()) {
                jsonArray2.put((Object)iterator2.next().toString());
            }
            jsonObject.put("trackers", (Object)jsonArray2);
        }
        catch (JSONException ex) {
            fv.a().a(new gv((Throwable)ex));
            return "";
        }
        return jsonObject.toString();
    }
    
    static {
        h = cw.class.getSimpleName();
        f = new ArrayList<String>(Arrays.asList("image/jpeg", "image/png"));
    }
    
    public static final class a
    {
        public byte a;
        public String b;
        
        a(final byte a, final String b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public final String toString() {
            final JSONObject jsonObject = new JSONObject();
            try {
                final JSONObject jsonObject2 = jsonObject;
                final String s = "type";
                String s2 = null;
                switch (this.a) {
                    default: {
                        s2 = "unknown";
                        break;
                    }
                    case 1: {
                        s2 = "static";
                        break;
                    }
                    case 2: {
                        s2 = "html";
                        break;
                    }
                    case 3: {
                        s2 = "iframe";
                        break;
                    }
                }
                jsonObject2.put(s, (Object)s2);
                jsonObject.put("content", (Object)this.b);
            }
            catch (JSONException ex) {
                cw.h;
                fv.a().a(new gv((Throwable)ex));
                return "";
            }
            return jsonObject.toString();
        }
    }
}
