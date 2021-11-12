// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.unifiedId;

import java.util.Arrays;
import java.util.HashMap;
import androidx.annotation.Nullable;

public final class InMobiUserDataModel
{
    @Nullable
    private final InMobiUserDataTypes a;
    @Nullable
    private final InMobiUserDataTypes b;
    @Nullable
    private final HashMap<String, String> c;
    
    private InMobiUserDataModel(@Nullable final InMobiUserDataTypes a, @Nullable final InMobiUserDataTypes b, @Nullable final HashMap<String, String> c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Nullable
    public final InMobiUserDataTypes getPhoneNumber() {
        return this.a;
    }
    
    @Nullable
    public final InMobiUserDataTypes getEmailId() {
        return this.b;
    }
    
    @Nullable
    public final HashMap<String, String> getExtras() {
        return this.c;
    }
    
    @Override
    public final boolean equals(@Nullable final Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof InMobiUserDataModel) {
            final InMobiUserDataModel inMobiUserDataModel = (InMobiUserDataModel)o;
            return true & ((this.a == null && inMobiUserDataModel.getPhoneNumber() == null) || (this.a != null && this.a.equals(inMobiUserDataModel.getPhoneNumber()))) & ((this.b == null && inMobiUserDataModel.getEmailId() == null) || (this.b != null && this.b.equals(inMobiUserDataModel.getEmailId()))) & ((this.c == null && inMobiUserDataModel.getExtras() == null) || (this.c != null && this.c.equals(inMobiUserDataModel.getExtras())));
        }
        return false;
    }
    
    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[] { this.getPhoneNumber(), this.getEmailId(), this.getExtras() });
    }
    
    public static class Builder
    {
        @Nullable
        private InMobiUserDataTypes a;
        @Nullable
        private InMobiUserDataTypes b;
        @Nullable
        private HashMap<String, String> c;
        
        public Builder phoneNumber(@Nullable final InMobiUserDataTypes a) {
            this.a = a;
            return this;
        }
        
        public Builder emailId(@Nullable final InMobiUserDataTypes b) {
            this.b = b;
            return this;
        }
        
        public Builder extras(@Nullable final HashMap<String, String> c) {
            this.c = c;
            return this;
        }
        
        public InMobiUserDataModel build() {
            return new InMobiUserDataModel(this.a, this.b, this.c, (byte)0);
        }
    }
}
