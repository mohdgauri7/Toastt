// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.unifiedId;

import java.util.Arrays;
import androidx.annotation.Nullable;

public final class InMobiUserDataTypes
{
    @Nullable
    protected String md5;
    @Nullable
    protected String sha1;
    @Nullable
    protected String sha256;
    
    private InMobiUserDataTypes(@Nullable final String md5, @Nullable final String sha1, @Nullable final String sha2) {
        this.md5 = md5;
        this.sha1 = sha1;
        this.sha256 = sha2;
    }
    
    @Nullable
    public final String getMd5() {
        return this.md5;
    }
    
    @Nullable
    public final String getSha1() {
        return this.sha1;
    }
    
    @Nullable
    public final String getSha256() {
        return this.sha256;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InMobiUserDataTypes)) {
            return false;
        }
        final InMobiUserDataTypes inMobiUserDataTypes = (InMobiUserDataTypes)o;
        return true & ((this.md5 == null && inMobiUserDataTypes.getMd5() == null) || (this.md5 != null && this.md5.equals(inMobiUserDataTypes.getMd5()))) & ((this.sha1 == null && inMobiUserDataTypes.getSha1() == null) || (this.sha1 != null && this.sha1.equals(inMobiUserDataTypes.getSha1()))) & ((this.sha256 == null && inMobiUserDataTypes.getSha256() == null) || (this.sha256 != null && this.sha256.equals(inMobiUserDataTypes.getSha256())));
    }
    
    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[] { this.md5, this.sha1, this.sha256 });
    }
    
    public static class Builder
    {
        @Nullable
        protected String a;
        @Nullable
        protected String b;
        @Nullable
        protected String c;
        
        public Builder md5(@Nullable final String a) {
            this.a = a;
            return this;
        }
        
        public Builder sha1(@Nullable final String b) {
            this.b = b;
            return this;
        }
        
        public Builder sha256(@Nullable final String c) {
            this.c = c;
            return this;
        }
        
        public InMobiUserDataTypes build() {
            return new InMobiUserDataTypes(this.a, this.b, this.c, (byte)0);
        }
    }
}
