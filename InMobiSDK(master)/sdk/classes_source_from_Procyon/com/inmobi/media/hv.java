// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.lang.reflect.Constructor;
import androidx.annotation.Nullable;
import java.util.List;
import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import java.lang.reflect.Field;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

public class hv<T>
{
    private static final String a;
    private static boolean b;
    private Map<ia, hz> c;
    
    public hv() {
        this.c = new HashMap<ia, hz>();
    }
    
    public static void a(final boolean b) {
        hv.b = b;
    }
    
    public static void a(@NonNull final Object obj, @NonNull Object cast) {
        final Class<?> class1;
        if ((class1 = obj.getClass()).isAssignableFrom(cast.getClass())) {
            cast = class1.cast(cast);
            Field[] declaredFields;
            for (int length = (declaredFields = class1.getDeclaredFields()).length, i = 0; i < length; ++i) {
                final Field field = declaredFields[i];
                try {
                    field.setAccessible(true);
                    field.set(cast, field.get(obj));
                }
                catch (IllegalAccessException ex) {}
            }
        }
    }
    
    private static boolean b(@NonNull final Object o, @NonNull final Object o2) {
        if (o.getClass() == o2.getClass()) {
            if (o.getClass() == Integer.TYPE) {
                return (int)o == (int)o2;
            }
            if (o.getClass() == Long.TYPE) {
                return (long)o == (long)o2;
            }
            if (o.getClass() == Boolean.TYPE) {
                return (boolean)o == (boolean)o2;
            }
            if (o.getClass() == Double.TYPE) {
                return (double)o == (double)o2;
            }
            if (o.getClass() == Byte.TYPE) {
                return (byte)o == (byte)o2;
            }
            if (o.getClass() == Short.TYPE) {
                return (short)o == (short)o2;
            }
            return o.equals(o2);
        }
        else {
            if (o.getClass() == Integer.class && o2.getClass() == Long.class) {
                return (int)o == ((Long)o2).intValue();
            }
            if (o.getClass() == Long.class && o2.getClass() == Integer.class) {
                return ((Long)o).intValue() == (int)o2;
            }
            return o.equals(o2);
        }
    }
    
    private static boolean a(@NonNull final JSONArray jsonArray, @NonNull final JSONArray jsonArray2) {
        if (jsonArray.length() == jsonArray2.length()) {
            for (int i = 0; i < jsonArray.length(); ++i) {
                try {
                    final Object value = jsonArray.get(i);
                    final Object value2 = jsonArray2.get(i);
                    if (value instanceof JSONObject && value2 instanceof JSONObject) {
                        if (!a((JSONObject)value, (JSONObject)value2)) {
                            return false;
                        }
                    }
                    else if (value instanceof JSONArray && value2 instanceof JSONArray) {
                        if (!a((JSONArray)value, (JSONArray)value2)) {
                            return false;
                        }
                    }
                    else if (!b(value, value2)) {
                        return false;
                    }
                }
                catch (JSONException ex) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    public static boolean a(@NonNull final JSONObject jsonObject, @NonNull final JSONObject jsonObject2) {
        if (jsonObject.length() == jsonObject2.length()) {
            final Iterator keys = jsonObject.keys();
            while (keys.hasNext()) {
                final String s = keys.next();
                try {
                    final Object value = jsonObject.get(s);
                    final Object value2 = jsonObject2.get(s);
                    if (value instanceof JSONObject && value2 instanceof JSONObject) {
                        if (!a((JSONObject)value, (JSONObject)value2)) {
                            return false;
                        }
                        continue;
                    }
                    else if (value instanceof JSONArray && value2 instanceof JSONArray) {
                        if (!a((JSONArray)value, (JSONArray)value2)) {
                            return false;
                        }
                        continue;
                    }
                    else {
                        if (!b(value, value2)) {
                            return false;
                        }
                        continue;
                    }
                    continue;
                }
                catch (JSONException ex) {
                    return false;
                }
                break;
            }
            return true;
        }
        return false;
    }
    
    public hv<T> a(@NonNull final ia ia, @NonNull final hz hz) {
        this.c.put(ia, hz);
        return this;
    }
    
    private static boolean a(final Class<?> clazz) {
        return Integer.TYPE == clazz || Integer.class == clazz || Boolean.TYPE == clazz || Boolean.class == clazz || Double.TYPE == clazz || Double.class == clazz || Float.TYPE == clazz || Float.class == clazz || Long.TYPE == clazz || Long.class == clazz || String.class == clazz || Byte.TYPE == clazz || Byte.class == clazz;
    }
    
    @Nullable
    private JSONObject a(@NonNull final Object obj, final Class<?> clazz) {
        try {
            JSONObject a = null;
            clazz.getSimpleName();
            final Class<?> superclass;
            if ((superclass = clazz.getSuperclass()) != null && Object.class != superclass) {
                final Class<?> superclass2;
                (superclass2 = clazz.getSuperclass()).getSimpleName();
                a = this.a(obj, superclass2);
            }
            if (a == null) {
                a = new JSONObject();
            }
            Field[] declaredFields;
            for (int length = (declaredFields = clazz.getDeclaredFields()).length, i = 0; i < length; ++i) {
                final Field field;
                (field = declaredFields[i]).setAccessible(true);
                if (field.get(obj) == null) {
                    field.getName();
                }
                else {
                    final Class<?> type = field.getType();
                    if (!Modifier.isStatic(field.getModifiers()) && !field.isAnnotationPresent(hu.class)) {
                        final Class<?> clazz2 = type;
                        if (Modifier.isStatic(clazz.getModifiers()) || clazz.getEnclosingClass() != clazz2) {
                            final String name = field.getName();
                            if (Integer.TYPE == type || Integer.class == type) {
                                a.put(name, (int)field.get(obj));
                            }
                            else if (Boolean.TYPE == type || Boolean.class == type) {
                                a.put(name, (boolean)field.get(obj));
                            }
                            else if (Double.TYPE == type || Double.class == type) {
                                a.put(name, (double)field.get(obj));
                            }
                            else if (Float.TYPE == type || Float.class == type) {
                                a.put(name, (double)(float)field.get(obj));
                            }
                            else if (Long.TYPE == type || Long.class == type) {
                                a.put(name, (long)field.get(obj));
                            }
                            else if (Byte.TYPE == type || Byte.class == type) {
                                a.put(name, (int)(byte)field.get(obj));
                            }
                            else if (String.class == type || JSONObject.class == type || JSONArray.class == type) {
                                a.put(name, field.get(obj));
                            }
                            else if (Map.class.isAssignableFrom(type)) {
                                if (this.c.get(new ia(name, clazz)) instanceof hy) {
                                    final JSONObject jsonObject = new JSONObject();
                                    final Object value;
                                    if ((value = field.get(obj)) != null) {
                                        final Map<Object, Object> map;
                                        final Iterator<Object> iterator = (map = (Map<Object, Object>)value).keySet().iterator();
                                        while (iterator.hasNext()) {
                                            final Object next;
                                            final Object value2;
                                            if ((value2 = map.get(next = iterator.next())) != null) {
                                                Object a2;
                                                if (a(value2.getClass())) {
                                                    a2 = value2;
                                                }
                                                else {
                                                    final Object o = value2;
                                                    a2 = this.a(o, o.getClass());
                                                }
                                                jsonObject.put(next.toString(), a2);
                                            }
                                        }
                                    }
                                    a.put(name, (Object)jsonObject);
                                }
                                else {
                                    type.getSimpleName();
                                }
                            }
                            else if (List.class.isAssignableFrom(type)) {
                                if (this.c.get(new ia(name, clazz)) instanceof hx) {
                                    final JSONArray jsonArray = new JSONArray();
                                    final Object value3;
                                    if ((value3 = field.get(obj)) != null) {
                                        final Iterator<Object> iterator2 = ((List<Object>)value3).iterator();
                                        while (iterator2.hasNext()) {
                                            final Object next2;
                                            if ((next2 = iterator2.next()) != null) {
                                                Object a3;
                                                Object o2;
                                                if (a(next2.getClass())) {
                                                    o2 = (a3 = next2);
                                                }
                                                else {
                                                    final Object o3 = next2;
                                                    o2 = (a3 = this.a(o3, o3.getClass()));
                                                }
                                                final Object o4 = a3;
                                                if (o2 == null) {
                                                    next2.getClass();
                                                }
                                                else {
                                                    jsonArray.put(o4);
                                                }
                                            }
                                        }
                                    }
                                    a.put(name, (Object)jsonArray);
                                }
                                else {
                                    type.getSimpleName();
                                }
                            }
                            else {
                                final Object value4;
                                if ((value4 = field.get(obj)) != null) {
                                    final JSONObject jsonObject2 = a;
                                    final String s = name;
                                    final Object o5 = value4;
                                    jsonObject2.put(s, (Object)this.a(o5, o5.getClass()));
                                }
                                else {
                                    type.getSimpleName();
                                }
                            }
                        }
                    }
                }
            }
            return a;
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    @Nullable
    public JSONObject a(@NonNull final T t) {
        return this.a(t, t.getClass());
    }
    
    public T a(@NonNull final JSONObject jsonObject, @NonNull final Class<T> clazz) {
        return clazz.cast(this.a(jsonObject, clazz, null, null));
    }
    
    private Object a(@NonNull final JSONObject jsonObject, @NonNull final Class<?> clazz, @Nullable final Object o, @Nullable Object o2) {
        try {
            clazz.getSimpleName();
            if (o2 == null) {
                try {
                    final Constructor<?>[] declaredConstructors;
                    if ((declaredConstructors = clazz.getDeclaredConstructors()).length == 0) {
                        o2 = clazz.newInstance();
                    }
                    else {
                        final Constructor<?> constructor;
                        (constructor = declaredConstructors[0]).setAccessible(true);
                        final int length;
                        if ((length = constructor.getParameterTypes().length) == 0) {
                            o2 = constructor.newInstance(new Object[0]);
                        }
                        else {
                            int n = 0;
                            final Object[] initargs = new Object[length];
                            Class<?>[] parameterTypes;
                            for (int length2 = (parameterTypes = constructor.getParameterTypes()).length, i = 0; i < length2; ++i) {
                                final Class<?> clazz2 = parameterTypes[i];
                                final Object[] array = initargs;
                                final int n2 = n++;
                                final Class<Float> clazz3 = (Class<Float>)clazz2;
                                array[n2] = ((Integer.TYPE == clazz3 || Long.TYPE == clazz3) ? Integer.valueOf(0) : ((Boolean.TYPE == clazz3) ? Boolean.FALSE : ((Double.TYPE == clazz3 || Float.TYPE == clazz3) ? Double.valueOf(0.0) : null)));
                            }
                            o2 = constructor.newInstance(initargs);
                        }
                    }
                }
                catch (Exception ex) {
                    return null;
                }
            }
            if (clazz.getSuperclass() != null) {
                final Class<?> superclass;
                (superclass = clazz.getSuperclass()).getSimpleName();
                o2 = this.a(jsonObject, superclass, o, o2);
            }
            Field[] declaredFields;
            for (int length3 = (declaredFields = clazz.getDeclaredFields()).length, j = 0; j < length3; ++j) {
                final Field field;
                (field = declaredFields[j]).setAccessible(true);
                final String name = field.getName();
                if (jsonObject.has(name) && !field.isAnnotationPresent(hu.class)) {
                    final Class<?> type = field.getType();
                    if (!Modifier.isStatic(field.getModifiers())) {
                        if (Integer.TYPE == type) {
                            field.setInt(o2, jsonObject.getInt(name));
                        }
                        else if (Integer.class == type) {
                            field.set(o2, jsonObject.get(name));
                        }
                        else if (Boolean.TYPE == type) {
                            field.setBoolean(o2, jsonObject.getBoolean(name));
                        }
                        else if (Boolean.class == type) {
                            field.set(o2, jsonObject.getBoolean(name));
                        }
                        else if (Double.TYPE == type) {
                            field.setDouble(o2, jsonObject.getDouble(name));
                        }
                        else if (Double.class == type) {
                            field.set(o2, jsonObject.getDouble(name));
                        }
                        else if (Float.TYPE == type) {
                            field.setFloat(o2, (float)jsonObject.getDouble(name));
                        }
                        else if (Float.class == type) {
                            field.set(o2, (float)jsonObject.getDouble(name));
                        }
                        else if (Long.TYPE == type) {
                            field.setLong(o2, jsonObject.getLong(name));
                        }
                        else if (Long.class == type) {
                            field.set(o2, jsonObject.getLong(name));
                        }
                        else if (Byte.TYPE == type) {
                            field.setByte(o2, (byte)jsonObject.getInt(name));
                        }
                        else if (Byte.class == type) {
                            field.set(o2, (byte)jsonObject.getInt(name));
                        }
                        else if (String.class == type) {
                            field.set(o2, jsonObject.optString(name));
                        }
                        else if (JSONObject.class == type) {
                            field.set(o2, jsonObject.getJSONObject(name));
                        }
                        else if (JSONArray.class == type) {
                            field.set(o2, jsonObject.getJSONArray(name));
                        }
                        else if (Map.class.isAssignableFrom(type)) {
                            final hz hz;
                            if ((hz = this.c.get(new ia(name, clazz))) instanceof hy) {
                                final JSONObject optJSONObject;
                                if ((optJSONObject = jsonObject.optJSONObject(name)) != null) {
                                    final hy hy;
                                    final Map value = (Map)(hy = (hy)hz).b.construct();
                                    final Iterator keys = optJSONObject.keys();
                                    while (keys.hasNext()) {
                                        final String s = keys.next();
                                        V v;
                                        if (a(hy.a)) {
                                            final Class<V> a = hy.a;
                                            final JSONObject jsonObject2 = optJSONObject;
                                            final String s2 = s;
                                            final Class<V> a2 = hy.a;
                                            final String s3 = s2;
                                            final JSONObject jsonObject3 = jsonObject2;
                                            v = a.cast((Integer.class == a2) ? Integer.valueOf(jsonObject3.getInt(s3)) : ((Double.class == a2) ? Double.valueOf(jsonObject3.getDouble(s3)) : ((Float.class == a2) ? Float.valueOf((float)jsonObject3.getDouble(s3)) : ((Long.class == a2) ? Long.valueOf(jsonObject3.getLong(s3)) : ((Byte.class == a2) ? Byte.valueOf((byte)jsonObject3.getInt(s3)) : jsonObject3.get(s3))))));
                                        }
                                        else {
                                            v = this.a(optJSONObject.getJSONObject(s), hy.a);
                                        }
                                        value.put(s, v);
                                    }
                                    field.set(o2, value);
                                }
                            }
                            else {
                                type.getSimpleName();
                            }
                        }
                        else if (List.class.isAssignableFrom(type)) {
                            final hz hz2;
                            if ((hz2 = this.c.get(new ia(name, clazz))) instanceof hx) {
                                final JSONArray optJSONArray;
                                if ((optJSONArray = jsonObject.optJSONArray(name)) != null) {
                                    final hx<Integer> hx;
                                    final List<Integer> a3 = (hx = (hx<Integer>)hz2).a();
                                    for (int k = 0; k < optJSONArray.length(); ++k) {
                                        final JSONArray jsonArray = optJSONArray;
                                        final int n3 = k;
                                        final Class<Integer> b = hx.b();
                                        final int n4 = n3;
                                        final JSONArray jsonArray2 = jsonArray;
                                        Object o4;
                                        final Object o3 = (Integer.class == b) ? (o4 = jsonArray2.getInt(n4)) : ((Double.class == b) ? (o4 = jsonArray2.getDouble(n4)) : ((Float.class == b) ? (o4 = (float)jsonArray2.getDouble(n4)) : ((Long.class == b) ? (o4 = jsonArray2.getLong(n4)) : ((Byte.class == b) ? (o4 = (byte)jsonArray2.getInt(n4)) : (o4 = jsonArray2.get(n4))))));
                                        final Object obj = o4;
                                        final Integer n5;
                                        if ((n5 = (a(o3.getClass()) ? hx.b().cast(obj) : this.a(optJSONArray.getJSONObject(k), hx.b()))) != null) {
                                            a3.add(n5);
                                        }
                                    }
                                    field.set(o2, a3);
                                }
                            }
                            else {
                                clazz.getSimpleName();
                            }
                        }
                        else {
                            final JSONObject optJSONObject2;
                            if ((optJSONObject2 = jsonObject.optJSONObject(name)) != null) {
                                field.set(o2, this.a(optJSONObject2, type, o2, null));
                            }
                            else {
                                clazz.getSimpleName();
                            }
                        }
                    }
                }
            }
            return o2;
        }
        catch (Exception ex2) {
            return null;
        }
    }
    
    static {
        a = hv.class.getSimpleName();
    }
}
