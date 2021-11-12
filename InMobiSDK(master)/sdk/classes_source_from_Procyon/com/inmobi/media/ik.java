// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import org.json.JSONException;
import org.json.JSONObject;
import android.annotation.TargetApi;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.os.Build;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfo;

public class ik
{
    private static final String d;
    String a;
    int b;
    int c;
    
    public ik() {
    }
    
    @TargetApi(18)
    public ik(final CellInfo cellInfo, final String s, final String s2, final int n) {
        if (cellInfo instanceof CellInfoGsm) {
            this.c = n;
            final CellInfoGsm cellInfoGsm = (CellInfoGsm)cellInfo;
            this.b = cellInfoGsm.getCellSignalStrength().getDbm();
            final CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
            this.a = a(s, s2, cellIdentity.getLac(), cellIdentity.getCid(), -1, Integer.MAX_VALUE);
            return;
        }
        if (cellInfo instanceof CellInfoCdma) {
            this.c = n;
            final CellInfoCdma cellInfoCdma = (CellInfoCdma)cellInfo;
            this.b = cellInfoCdma.getCellSignalStrength().getDbm();
            final CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
            this.a = a(s, cellIdentity2.getSystemId(), cellIdentity2.getNetworkId(), cellIdentity2.getBasestationId());
            return;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            if (cellInfo instanceof CellInfoWcdma) {
                this.c = n;
                final CellInfoWcdma cellInfoWcdma = (CellInfoWcdma)cellInfo;
                this.b = cellInfoWcdma.getCellSignalStrength().getDbm();
                final CellIdentityWcdma cellIdentity3 = cellInfoWcdma.getCellIdentity();
                this.a = a(s, s2, cellIdentity3.getLac(), cellIdentity3.getCid(), cellIdentity3.getPsc(), Integer.MAX_VALUE);
            }
        }
        else if (cellInfo instanceof CellInfoLte) {
            this.c = n;
            final CellInfoLte cellInfoLte = (CellInfoLte)cellInfo;
            this.b = cellInfoLte.getCellSignalStrength().getDbm();
            final CellIdentityLte cellIdentity4 = cellInfoLte.getCellIdentity();
            this.a = a(s, s2, cellIdentity4.getTac(), cellIdentity4.getCi(), -1, cellIdentity4.getPci());
        }
    }
    
    public static String a(final String str, final int i, final int j, final int k) {
        return str + "#" + i + "#" + j + "#" + k;
    }
    
    public static String a(final String str, final String str2, final int i, final int j, final int k, final int l) {
        return str + "#" + str2 + "#" + i + "#" + j + "#" + ((k == -1) ? "" : Integer.valueOf(k)) + "#" + ((l == Integer.MAX_VALUE) ? "" : Integer.valueOf(l));
    }
    
    public final JSONObject a() {
        final JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id", (Object)this.a);
            if (this.b != Integer.MAX_VALUE) {
                jsonObject.put("ss", this.b);
            }
            jsonObject.put("nt", this.c);
        }
        catch (JSONException ex) {}
        return jsonObject;
    }
    
    static {
        d = ik.class.getSimpleName();
    }
}
