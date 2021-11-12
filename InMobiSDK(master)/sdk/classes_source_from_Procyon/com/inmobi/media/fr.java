// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import org.json.JSONObject;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;

@hw
public class fr extends ff
{
    private static final String DEFAULT_EXPONENT = "010001";
    private static final String DEFAULT_MODULUS = "E72409364B865B757E1D6B8DB73011BBB1D20C1A9F931ADD3C4C09E2794CE102F8AA7F2D50EB88F9880A576E6C7B0E95712CAE9416F7BACB798564627846E93B";
    private static final String DEFAULT_ALGORITHM = "rsa";
    private static final String DEFAULT_VERSION = "1";
    public String e;
    public String m;
    private String alg;
    public String ver;
    
    @NonNull
    public static hv<fr> a() {
        return new hv<fr>();
    }
    
    fr(@Nullable final String s) {
        super(s);
        this.e = "010001";
        this.m = "E72409364B865B757E1D6B8DB73011BBB1D20C1A9F931ADD3C4C09E2794CE102F8AA7F2D50EB88F9880A576E6C7B0E95712CAE9416F7BACB798564627846E93B";
        this.alg = "rsa";
        this.ver = "1";
    }
    
    @Override
    public String b() {
        return "pk";
    }
    
    @Nullable
    @Override
    public JSONObject c() {
        return new hv<fr>().a(this);
    }
    
    @Override
    public boolean d() {
        return this.e.trim().length() != 0 && this.m.trim().length() != 0 && this.alg.trim().length() != 0 && this.ver.trim().length() != 0;
    }
}
