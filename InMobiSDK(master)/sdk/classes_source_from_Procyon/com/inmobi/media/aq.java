// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.UUID;
import android.os.Parcel;
import androidx.annotation.Nullable;
import com.inmobi.unification.sdk.model.ASRequestParams;
import androidx.annotation.NonNull;
import java.util.Map;
import android.os.Parcelable;

public final class aq implements Parcelable
{
    private final long a;
    private final long b;
    private final String c;
    private String d;
    private Map<String, String> e;
    private String f;
    private final String g;
    private String h;
    private String i;
    @NonNull
    private String j;
    private String k;
    private boolean l;
    private ASRequestParams m;
    @Nullable
    private String n;
    public static final Parcelable.Creator<aq> CREATOR;
    
    private aq(final long a, final long b, final String d, final String g, final String c, final String h) {
        this.j = "";
        this.k = "activity";
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.g = g;
        if (this.d == null) {
            this.d = "";
        }
        this.h = h;
    }
    
    private aq(final Parcel parcel) {
        this.j = "";
        this.k = "activity";
        this.b = parcel.readLong();
        this.a = parcel.readLong();
        this.c = parcel.readString();
        final String string;
        String k = null;
        if ((string = parcel.readString()) == null) {
            k = "activity";
        }
        else {
            switch (string) {
                default: {
                    k = "activity";
                    break;
                }
                case "others": {
                    k = "others";
                    break;
                }
            }
        }
        this.k = k;
        this.g = parcel.readString();
    }
    
    @NonNull
    public static String a(final Map<String, String> map) {
        if (map == null) {
            return "";
        }
        final String s;
        if ((s = map.get("tp")) == null) {
            return "";
        }
        return s;
    }
    
    public final String a() {
        return this.c;
    }
    
    public final String b() {
        final String c = this.c;
        switch (c) {
            default: {
                return "im";
            }
            case "AerServ": {
                return "as";
            }
        }
    }
    
    public final void b(final Map<String, String> e) {
        this.e = e;
    }
    
    public final Map<String, String> c() {
        return this.e;
    }
    
    public final String d() {
        return this.f;
    }
    
    public final long e() {
        final String c = this.c;
        switch (c) {
            default: {
                return this.a;
            }
            case "AerServ": {
                return this.b;
            }
        }
    }
    
    public final boolean f() {
        return this.l;
    }
    
    public final ASRequestParams g() {
        return this.m;
    }
    
    @Nullable
    public final String h() {
        return this.n;
    }
    
    public final long i() {
        return this.b;
    }
    
    public final long j() {
        return this.a;
    }
    
    public final String k() {
        return this.d;
    }
    
    public final String l() {
        return this.g;
    }
    
    public final void a(@NonNull final String j) {
        this.j = j;
    }
    
    @NonNull
    public final String m() {
        return this.j;
    }
    
    public final String n() {
        return this.k;
    }
    
    public final void b(final String k) {
        this.k = k;
    }
    
    @NonNull
    public final String o() {
        return this.i;
    }
    
    @Nullable
    public final String p() {
        return this.h;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final aq aq = (aq)o;
        return this.a == aq.a && this.b == aq.b && this.c.equals(aq.c) && this.k.equals(aq.k) && this.d.equals(aq.d) && this.g.equals(aq.g);
    }
    
    @Override
    public final int hashCode() {
        return 29 * (30 * (31 * (int)(this.b ^ this.b >>> 32) + (int)(this.a ^ this.a >>> 31)) + this.g.hashCode()) + this.k.hashCode();
    }
    
    @Override
    public final String toString() {
        final String a = this.a();
        switch (a) {
            default: {
                return String.valueOf(this.a);
            }
            case "AerServ": {
                return String.valueOf(this.b);
            }
        }
    }
    
    public final int describeContents() {
        return 0;
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeLong(this.b);
        parcel.writeLong(this.a);
        parcel.writeString(this.c);
        parcel.writeString(this.k);
        parcel.writeString(this.g);
    }
    
    static {
        CREATOR = (Parcelable.Creator)new Parcelable.Creator<aq>() {};
    }
    
    public static final class a
    {
        private long a;
        private long b;
        private String c;
        private Map<String, String> d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;
        private boolean j;
        private String k;
        private ASRequestParams l;
        @Nullable
        private String m;
        
        public a(final String f, final String c) {
            this.a = Long.MIN_VALUE;
            this.b = Long.MIN_VALUE;
            this.i = "";
            this.k = "activity";
            this.f = f;
            this.c = c;
            this.h = UUID.randomUUID().toString();
        }
        
        public final a a(final long a) {
            this.a = a;
            return this;
        }
        
        public final a b(final long b) {
            this.b = b;
            return this;
        }
        
        public final a a(@NonNull final aq aq) {
            this.b = aq.b;
            this.a = aq.a;
            this.k = aq.k;
            this.d = aq.e;
            this.i = aq.j;
            return this;
        }
        
        public final a a(@NonNull final String i) {
            this.i = i;
            return this;
        }
        
        public final a b(final String k) {
            this.k = k;
            return this;
        }
        
        public final a a(@Nullable final Map<String, String> d) {
            this.d = d;
            return this;
        }
        
        public final a c(@Nullable final String e) {
            this.e = e;
            return this;
        }
        
        public final a a(final boolean j) {
            this.j = j;
            return this;
        }
        
        public final a a(final ASRequestParams l) {
            this.l = l;
            return this;
        }
        
        public final a d(final String g) {
            this.g = g;
            return this;
        }
        
        public final a e(@Nullable final String m) {
            this.m = m;
            return this;
        }
        
        public final aq a() {
            final String c = this.c;
            switch (c) {
                default: {
                    if (this.a == Long.MIN_VALUE) {
                        throw new IllegalStateException("When the integration type is IM, IM-Plc can't be empty");
                    }
                    break;
                }
                case "AerServ": {
                    if (this.b == Long.MIN_VALUE) {
                        throw new IllegalStateException("When the integration type is AS, AS-Plc can't be empty");
                    }
                    break;
                }
            }
            final aq aq;
            (aq = new aq(this.a, this.b, com.inmobi.media.aq.a(this.d), this.f, this.c, this.g, (byte)0)).f = this.e;
            aq.e = this.d;
            aq.j = this.i;
            aq.k = this.k;
            aq.i = this.h;
            aq.l = this.j;
            aq.m = this.l;
            aq.n = this.m;
            return aq;
        }
    }
}
