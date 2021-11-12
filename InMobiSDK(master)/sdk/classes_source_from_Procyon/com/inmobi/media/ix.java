// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.WorkerThread;
import java.util.Map;
import java.util.Iterator;
import com.inmobi.unifiedId.InMobiUnifiedIdInterface;
import com.inmobi.unifiedId.InMobiUnifiedIdService;
import java.util.HashMap;
import androidx.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import androidx.annotation.NonNull;
import org.json.JSONObject;

public final class ix
{
    public static boolean a(@NonNull final JSONObject jsonObject) {
        boolean b = true;
        try {
            final JSONArray jsonArray;
            if (jsonObject.has("ufids") && (jsonArray = jsonObject.getJSONArray("ufids")) != null && jsonArray.length() != 0) {
                for (int i = 0; i < jsonArray.length(); ++i) {
                    b &= (System.currentTimeMillis() <= jsonArray.getJSONObject(i).getLong("expiry"));
                }
            }
        }
        catch (JSONException ex) {}
        return !b;
    }
    
    public static boolean b(@Nullable final JSONObject jsonObject) {
        if (jsonObject == null) {
            return true;
        }
        JSONArray jsonArray = null;
        try {
            if (jsonObject.has("ufids")) {
                jsonArray = jsonObject.getJSONArray("ufids");
            }
        }
        catch (JSONException ex) {
            return true;
        }
        return jsonObject == null || jsonArray == null || jsonArray.length() == 0;
    }
    
    @NonNull
    public static by a() {
        if (c()) {
            return new by();
        }
        if (b()) {
            return new by();
        }
        final HashMap<String, JSONObject> hashMap = new HashMap<String, JSONObject>();
        final JSONObject b;
        if ((b = iw.b()) != null) {
            final Iterator keys = b.keys();
            while (keys.hasNext()) {
                final String s = keys.next();
                try {
                    if (b.get(s) == null) {
                        continue;
                    }
                    final JSONObject jsonObject;
                    (jsonObject = new JSONObject()).put("src", (Object)s);
                    jsonObject.put("envelope", b.get(s));
                    hashMap.put(s, jsonObject);
                }
                catch (JSONException ex) {}
            }
        }
        boolean b2 = false;
        final JSONObject a;
        if ((a = iw.a()) != null) {
            try {
                if (a.has("ufids")) {
                    final JSONArray jsonArray = a.getJSONArray("ufids");
                    boolean b3 = false;
                    for (int i = 0; i < jsonArray.length(); ++i) {
                        final String string = jsonArray.getJSONObject(i).getString("src");
                        final String string2 = jsonArray.getJSONObject(i).getString("envelope");
                        if (System.currentTimeMillis() > jsonArray.getJSONObject(i).getLong("expiry")) {
                            b3 = true;
                        }
                        else if (string != null && string2 != null) {
                            final JSONObject jsonObject2;
                            (jsonObject2 = new JSONObject()).put("src", (Object)string);
                            jsonObject2.put("envelope", (Object)string2);
                            hashMap.put(string, jsonObject2);
                            b2 = true;
                        }
                    }
                    if (b3) {
                        InMobiUnifiedIdService.a((InMobiUnifiedIdInterface)null);
                    }
                }
            }
            catch (JSONException ex2) {}
        }
        if (hashMap.size() > 0) {
            final JSONArray jsonArray2 = new JSONArray();
            final Iterator<JSONObject> iterator = hashMap.values().iterator();
            while (iterator.hasNext()) {
                jsonArray2.put((Object)iterator.next());
            }
            return new by(jsonArray2.toString(), b2);
        }
        return new by();
    }
    
    public static boolean b() {
        final Boolean f;
        final boolean b;
        if (b = ((f = ic.a().f()) == null || f)) {
            InMobiUnifiedIdService.reset();
        }
        return b;
    }
    
    public static boolean c() {
        ii.a();
        final boolean b;
        if (b = !ii.f().enabled) {
            InMobiUnifiedIdService.reset();
        }
        return b;
    }
    
    public static void a(final InMobiUnifiedIdInterface inMobiUnifiedIdInterface, final JSONObject jsonObject, final Error error) {
        final byte a;
        if ((a = a(error)) >= 0) {
            final HashMap<String, Object> hashMap;
            (hashMap = new HashMap<String, Object>()).put("errorCode", a);
            gw.a().a("FetchCallbackFailure ", hashMap);
        }
        if (inMobiUnifiedIdInterface != null) {
            iu.a().a(new Runnable() {
                @Override
                public final void run() {
                    inMobiUnifiedIdInterface.onFetchCompleted(jsonObject, error);
                }
            });
        }
    }
    
    private static byte a(final Error error) {
        if (error != null) {
            final String message = error.getMessage();
            switch (message) {
                case "Fetching the unifiedIds from ID Service has failed and there are no unified ids present in cache": {
                    return 93;
                }
                case "No local data present": {
                    return 94;
                }
            }
        }
        return -1;
    }
    
    @WorkerThread
    @Nullable
    public static JSONArray d() {
        final JSONArray jsonArray = new JSONArray();
        final JSONObject a;
        if ((a = iw.a()) != null && a.has("ufids")) {
            try {
                final JSONArray jsonArray2;
                if ((jsonArray2 = a.getJSONArray("ufids")) != null) {
                    for (int i = 0; i < jsonArray2.length(); ++i) {
                        final String string = jsonArray2.getJSONObject(i).getString("src");
                        final String string2 = jsonArray2.getJSONObject(i).getString("signature");
                        final boolean b = System.currentTimeMillis() > jsonArray2.getJSONObject(i).getLong("expiry");
                        if (string != null && string2 != null) {
                            final JSONObject jsonObject;
                            (jsonObject = new JSONObject()).put("src", (Object)string);
                            jsonObject.put("signature", (Object)string2);
                            jsonObject.put("expired", b);
                            jsonArray.put((Object)jsonObject);
                        }
                    }
                }
            }
            catch (JSONException ex) {}
        }
        return jsonArray;
    }
    
    @Nullable
    public static JSONObject c(@Nullable final JSONObject jsonObject) {
        final JSONObject jsonObject2 = new JSONObject();
        final JSONArray jsonArray = new JSONArray();
        int n = 0;
        try {
            if (jsonObject != null && jsonObject.has("ufids")) {
                final JSONArray jsonArray2 = jsonObject.getJSONArray("ufids");
                for (int i = 0; i < jsonArray2.length(); ++i) {
                    final JSONObject jsonObject3 = jsonArray2.getJSONObject(i);
                    if (System.currentTimeMillis() < jsonObject3.getLong("expiry")) {
                        jsonArray.put(n++, (Object)jsonObject3);
                    }
                }
            }
            if (jsonArray.length() > 0) {
                jsonObject2.put("ufids", (Object)jsonArray);
                return jsonObject;
            }
        }
        catch (JSONException ex) {}
        return null;
    }
    
    @Nullable
    public static JSONObject a(@Nullable final JSONObject jsonObject, @Nullable final JSONObject jsonObject2) {
        final HashMap<String, JSONObject> hashMap = new HashMap<String, JSONObject>();
        final JSONObject jsonObject3 = new JSONObject();
        final JSONArray jsonArray = new JSONArray();
        try {
            final JSONArray jsonArray2;
            if (jsonObject2 != null && jsonObject2.has("ufids") && (jsonArray2 = jsonObject2.getJSONArray("ufids")) != null) {
                for (int i = 0; i < jsonArray2.length(); ++i) {
                    hashMap.put(jsonArray2.getJSONObject(i).getString("src"), jsonArray2.getJSONObject(i));
                }
            }
            final JSONArray jsonArray3;
            if (jsonObject != null && jsonObject.has("ufids") && (jsonArray3 = jsonObject.getJSONArray("ufids")) != null) {
                for (int j = 0; j < jsonArray3.length(); ++j) {
                    hashMap.put(jsonArray3.getJSONObject(j).getString("src"), jsonArray3.getJSONObject(j));
                }
            }
            final Iterator<JSONObject> iterator = hashMap.values().iterator();
            while (iterator.hasNext()) {
                jsonArray.put((Object)iterator.next());
            }
            jsonObject3.put("ufids", (Object)jsonArray);
        }
        catch (JSONException ex) {}
        return jsonObject3;
    }
}
