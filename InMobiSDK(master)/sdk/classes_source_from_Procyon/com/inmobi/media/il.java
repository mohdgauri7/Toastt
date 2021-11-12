// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.NonNull;
import java.util.Iterator;
import org.json.JSONArray;
import java.util.ArrayList;
import android.annotation.SuppressLint;
import android.location.LocationManager;
import android.telephony.CellLocation;
import java.util.List;
import android.telephony.gsm.GsmCellLocation;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.CellInfo;
import android.os.Build;
import android.content.Context;
import java.util.Locale;
import android.telephony.TelephonyManager;
import java.util.HashMap;
import java.util.Map;
import android.annotation.TargetApi;

@TargetApi(17)
public class il
{
    private static final String a;
    
    public static Map<String, String> a(String anObject) {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        final Context c;
        if ((c = gz.c()) == null) {
            return hashMap;
        }
        ii.a();
        final String m = gz.m();
        final ip c2;
        final String s = ((c2 = ir.c()) != null) ? c2.e() : null;
        final boolean b = c2 != null && c2.d();
        final boolean b2 = m == null || ii.a(m).c.oe;
        final boolean b3 = s == null || c2.c();
        final boolean b4 = !b || ii.a(s).c.oe;
        if (!b2 || !b3 || !b4) {
            return hashMap;
        }
        anObject = ("InMobi".equals(anObject) ? gz.g() : gz.h());
        ii.a();
        final int cof;
        final boolean a = a(cof = ii.a(anObject).c.cof, 2);
        final boolean a2 = a(cof, 1);
        final ij ij = new ij();
        final TelephonyManager telephonyManager = (TelephonyManager)c.getSystemService("phone");
        if (!a) {
            final int[] b5 = b(telephonyManager.getNetworkOperator());
            ij.a = b5[0];
            ij.b = b5[1];
            final ij ij2 = ij;
            final String networkCountryIso = telephonyManager.getNetworkCountryIso();
            final ij ij3 = ij2;
            if (networkCountryIso != null) {
                ij3.e = networkCountryIso.toLowerCase(Locale.ENGLISH);
            }
        }
        if (!a2) {
            final int[] b6 = b(telephonyManager.getSimOperator());
            ij.c = b6[0];
            ij.d = b6[1];
        }
        final ij ij4;
        hashMap.put("s-ho", ((ij4 = ij).c == -1 && ij4.d == -1) ? null : (ij4.c + "_" + ij4.d));
        final ij ij5;
        hashMap.put("s-co", ((ij5 = ij).a == -1 && ij5.b == -1) ? null : (ij5.a + "_" + ij5.b));
        hashMap.put("s-iso", ij.e);
        hashMap.put("s-cn", hn.a(c));
        return hashMap;
    }
    
    private static boolean a(final int n, final int n2) {
        return (n & n2) == n2;
    }
    
    private static int[] b(final String anObject) {
        final int[] array;
        array[1] = ((array = new int[2])[0] = -1);
        if (anObject == null || "".equals(anObject)) {
            return array;
        }
        try {
            final int int1 = Integer.parseInt(anObject.substring(0, 3));
            final int int2 = Integer.parseInt(anObject.substring(3));
            array[0] = int1;
            array[1] = int2;
        }
        catch (IndexOutOfBoundsException ex) {}
        catch (NumberFormatException ex2) {}
        return array;
    }
    
    public static Map<String, String> a() {
        ii.a();
        final String m = gz.m();
        final ip c;
        final String s = ((c = ir.c()) != null) ? c.e() : null;
        final boolean b = c != null && c.d();
        final boolean b2 = m == null || ii.a(m).c.cce;
        final boolean b3 = s == null || c.c();
        final boolean b4 = !b || ii.a(s).c.cce;
        ik ik = null;
        Label_0417: {
            if (!b2 || !b3 || !b4 || !d() || !c()) {
                ik = null;
            }
            else {
                final Context c2;
                if ((c2 = gz.c()) == null) {
                    ik = null;
                }
                else {
                    final TelephonyManager telephonyManager;
                    final int[] b5;
                    final String value = String.valueOf((b5 = b((telephonyManager = (TelephonyManager)c2.getSystemService("phone")).getNetworkOperator()))[0]);
                    final String value2 = String.valueOf(b5[1]);
                    final List allCellInfo;
                    if (Build.VERSION.SDK_INT >= 17 && (allCellInfo = telephonyManager.getAllCellInfo()) != null) {
                        CellInfo cellInfo = null;
                        for (int n = 0; n < allCellInfo.size() && !(cellInfo = allCellInfo.get(n)).isRegistered(); ++n) {}
                        if (cellInfo != null) {
                            ik = new ik(cellInfo, value, value2, a(telephonyManager));
                            break Label_0417;
                        }
                    }
                    final CellLocation cellLocation;
                    if ((cellLocation = telephonyManager.getCellLocation()) == null || b5[0] == -1) {
                        ik = null;
                    }
                    else {
                        final ik ik2 = new ik();
                        if (cellLocation instanceof CdmaCellLocation) {
                            final CdmaCellLocation cdmaCellLocation = (CdmaCellLocation)cellLocation;
                            ik2.b = Integer.MAX_VALUE;
                            ik2.c = a(telephonyManager);
                            ik2.a = com.inmobi.media.ik.a(value, cdmaCellLocation.getSystemId(), cdmaCellLocation.getNetworkId(), cdmaCellLocation.getBaseStationId());
                        }
                        else {
                            final GsmCellLocation gsmCellLocation = (GsmCellLocation)cellLocation;
                            ik2.b = Integer.MAX_VALUE;
                            ik2.c = a(telephonyManager);
                            ik2.a = com.inmobi.media.ik.a(value, value2, gsmCellLocation.getLac(), gsmCellLocation.getCid(), gsmCellLocation.getPsc(), Integer.MAX_VALUE);
                        }
                        ik = ik2;
                    }
                }
            }
        }
        final ik ik3 = ik;
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        if (ik3 != null) {
            hashMap.put("c-sc", ik3.a().toString());
        }
        return hashMap;
    }
    
    @SuppressLint({ "NewApi" })
    private static boolean c() {
        final LocationManager locationManager;
        return Build.VERSION.SDK_INT < 28 || ((locationManager = (LocationManager)gz.c().getSystemService("location")) != null && locationManager.isLocationEnabled());
    }
    
    public static Map<String, String> b() {
        ArrayList<ik> list = null;
        Label_0293: {
            if (gz.a() && d() && c()) {
                ii.a();
                final String m = gz.m();
                final ip c;
                final String s = ((c = ir.c()) != null) ? c.e() : null;
                final boolean b = c != null && c.d();
                final boolean b2 = m == null || ii.a(m).c.vce;
                final boolean b3 = s == null || c.c();
                final boolean b4 = !b || ii.a(s).c.vce;
                if (b2 && b3 && b4) {
                    final Context c2;
                    if ((c2 = gz.c()) == null) {
                        list = new ArrayList<ik>();
                        break Label_0293;
                    }
                    final TelephonyManager telephonyManager = (TelephonyManager)c2.getSystemService("phone");
                    final ArrayList<ik> list2 = (ArrayList<ik>)new ArrayList<Object>();
                    final int[] b5;
                    final String value = String.valueOf((b5 = b(telephonyManager.getNetworkOperator()))[0]);
                    final String value2 = String.valueOf(b5[1]);
                    final List allCellInfo;
                    if (Build.VERSION.SDK_INT >= 17 && (allCellInfo = telephonyManager.getAllCellInfo()) != null) {
                        final Iterator<CellInfo> iterator = allCellInfo.iterator();
                        while (iterator.hasNext()) {
                            final CellInfo cellInfo;
                            if (!(cellInfo = iterator.next()).isRegistered()) {
                                list2.add(new ik(cellInfo, value, value2, a(telephonyManager)));
                            }
                        }
                    }
                    list = list2;
                    break Label_0293;
                }
            }
            list = new ArrayList<ik>();
        }
        final ArrayList<ik> list3 = list;
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        if (!list3.isEmpty()) {
            final JSONArray jsonArray = new JSONArray();
            final ArrayList<ik> list4 = list3;
            jsonArray.put((Object)((ik)list4.get(list4.size() - 1)).a());
            hashMap.put("v-sc", jsonArray.toString());
        }
        return hashMap;
    }
    
    private static boolean d() {
        if (!gz.a()) {
            return false;
        }
        final boolean a = hh.a(gz.c(), "android.permission.READ_PHONE_STATE");
        final boolean a2 = hh.a(gz.c(), "android.permission.ACCESS_FINE_LOCATION");
        if (Build.VERSION.SDK_INT == 29) {
            return a2;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            return a2 && a;
        }
        return hh.a(gz.c(), "android.permission.ACCESS_COARSE_LOCATION") || a2;
    }
    
    @SuppressLint({ "MissingPermission" })
    private static int a(@NonNull final TelephonyManager telephonyManager) {
        if (Build.VERSION.SDK_INT >= 30) {
            return telephonyManager.getDataNetworkType();
        }
        return telephonyManager.getNetworkType();
    }
    
    static {
        a = il.class.getSimpleName();
    }
}
