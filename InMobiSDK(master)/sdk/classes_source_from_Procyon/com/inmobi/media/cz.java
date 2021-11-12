// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.Iterator;
import java.util.HashMap;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.util.List;
import android.webkit.URLUtil;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.Reader;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParserFactory;
import android.text.TextUtils;
import java.util.Map;

public class cz
{
    private static final String a;
    private dc b;
    private fe.k c;
    private boolean d;
    private int e;
    private static final Map<String, String> f;
    
    public cz(final fe.k c) {
        this.c = c;
        this.b = new dc(this.c);
    }
    
    public final dc a(final String s) {
        try {
            if (TextUtils.isEmpty((CharSequence)s)) {
                this.a(303);
                return this.b;
            }
            final XmlPullParser pullParser;
            (pullParser = XmlPullParserFactory.newInstance().newPullParser()).setInput((Reader)new StringReader(s));
            final String[] array = { "Wrapper", "InLine" };
            a(pullParser, "VAST");
            if (a("VAST", pullParser)) {
                a(pullParser, "Ad");
                if (a("Ad", pullParser)) {
                    a(pullParser, array);
                    if (a("InLine", pullParser)) {
                        this.b(pullParser);
                    }
                    else if (a("Wrapper", pullParser)) {
                        this.a(pullParser);
                    }
                    else {
                        this.a(101);
                    }
                }
                else {
                    this.a(303);
                }
            }
            else {
                this.a(101);
            }
        }
        catch (XmlPullParserException ex) {
            this.a(100);
            fv.a().a(new gv((Throwable)ex));
        }
        catch (Exception ex2) {
            this.a(900);
            fv.a().a(new gv(ex2));
        }
        return this.b;
    }
    
    private void a(final XmlPullParser xmlPullParser) {
        ++this.e;
        if (this.e > this.c.maxWrapperLimit) {
            this.a(302);
            return;
        }
        boolean b = false;
        boolean b2 = false;
        for (int n = i(xmlPullParser); null == xmlPullParser.getName() || !xmlPullParser.getName().equals("Wrapper") || !b(n); n = i(xmlPullParser)) {
            if (null != xmlPullParser.getName() && !b(n)) {
                final String name = xmlPullParser.getName();
                switch (name) {
                    case "Impression": {
                        b2 = true;
                        if (i(xmlPullParser) != 4 || !this.a("Impression", xmlPullParser.getText())) {
                            this.a(101);
                            return;
                        }
                        break;
                    }
                    case "Error": {
                        if (i(xmlPullParser) == 4) {
                            this.a("error", xmlPullParser.getText());
                            break;
                        }
                        break;
                    }
                    case "VASTAdTagURI": {
                        b = true;
                        if (i(xmlPullParser) != 4) {
                            this.a(101);
                            return;
                        }
                        final String text;
                        final String s;
                        if ((s = (TextUtils.isEmpty((CharSequence)(text = xmlPullParser.getText())) ? null : text.trim())) == null) {
                            this.a(300);
                            return;
                        }
                        final String s2 = s;
                        if (URLUtil.isValidUrl(s2)) {
                            final gm gm;
                            (gm = new gm("GET", s2)).q = false;
                            gm.w = false;
                            gm.o = true;
                            final gn a;
                            if ((a = new gp(gm).a()).a()) {
                                this.a(301);
                            }
                            else {
                                this.a(a.b());
                            }
                        }
                        else {
                            this.a(300);
                        }
                        if (this.b.f != 0) {
                            return;
                        }
                        break;
                    }
                    case "TrackingEvents": {
                        this.d(xmlPullParser);
                        break;
                    }
                    case "VideoClicks": {
                        this.a(xmlPullParser, false);
                        break;
                    }
                    case "AdVerifications": {
                        this.g(xmlPullParser);
                        break;
                    }
                    case "Extensions": {
                        this.e(xmlPullParser);
                        break;
                    }
                }
            }
        }
        if (!b || !b2) {
            this.a(101);
        }
    }
    
    private void b(final XmlPullParser xmlPullParser) {
        boolean b = false;
        boolean b2 = false;
        for (int n = i(xmlPullParser); null == xmlPullParser.getName() || !xmlPullParser.getName().equals("InLine") || !b(n); n = i(xmlPullParser)) {
            if (null != xmlPullParser.getName() && !b(n)) {
                final String name = xmlPullParser.getName();
                switch (name) {
                    case "Impression": {
                        b2 = true;
                        if (i(xmlPullParser) != 4 || !this.a("Impression", xmlPullParser.getText())) {
                            this.a(101);
                            return;
                        }
                        break;
                    }
                    case "Error": {
                        i(xmlPullParser);
                        this.a("error", xmlPullParser.getText());
                        break;
                    }
                    case "Creatives": {
                        b = true;
                        boolean b3 = false;
                        boolean b4 = false;
                        int n3 = 0;
                    Label_2027:
                        for (int n4 = i(xmlPullParser); null == xmlPullParser.getName() || !xmlPullParser.getName().equals("Creatives") || !b(n4); n4 = i(xmlPullParser)) {
                            if (null != xmlPullParser.getName() && !b(n4)) {
                                final String name2 = xmlPullParser.getName();
                                switch (name2) {
                                    case "Creative": {
                                        b3 = true;
                                        break;
                                    }
                                    case "Linear": {
                                        b4 = true;
                                        int n6 = i(xmlPullParser);
                                        boolean b5 = false;
                                        boolean c = false;
                                        boolean b6 = false;
                                    Label_0869_Outer:
                                        while (true) {
                                            while (true) {
                                                while (null == xmlPullParser.getName() || !xmlPullParser.getName().equals("Linear") || !b(n6)) {
                                                    if (null != xmlPullParser.getName() && !b(n6)) {
                                                        final String name3 = xmlPullParser.getName();
                                                        switch (name3) {
                                                            case "Duration": {
                                                                if (i(xmlPullParser) != 4) {
                                                                    break;
                                                                }
                                                                final String text;
                                                                if (TextUtils.isEmpty((CharSequence)(text = xmlPullParser.getText())) || !text.matches("\\d*:[0-5][0-9]:[0-5][0-9](:[0-9][0-9][0-9])?")) {
                                                                    this.a(101);
                                                                    final int n8 = 0;
                                                                    n3 = n8;
                                                                    continue Label_2027;
                                                                }
                                                                this.b.b = text;
                                                                b5 = true;
                                                                break;
                                                            }
                                                            case "TrackingEvents": {
                                                                this.d(xmlPullParser);
                                                                break;
                                                            }
                                                            case "VideoClicks": {
                                                                this.a(xmlPullParser, true);
                                                                break;
                                                            }
                                                            case "MediaFiles": {
                                                                b6 = true;
                                                                c = this.c(xmlPullParser);
                                                                break;
                                                            }
                                                        }
                                                    }
                                                    n6 = i(xmlPullParser);
                                                }
                                                if (!b5 || !b6) {
                                                    this.a(101);
                                                }
                                                if (b5 && b6 && c) {
                                                    final int n8 = 1;
                                                    continue;
                                                }
                                                break;
                                            }
                                            continue Label_0869_Outer;
                                        }
                                    }
                                    case "CompanionAds": {
                                        int n9 = 0;
                                        int n10 = i(xmlPullParser);
                                        while (null == xmlPullParser.getName() || !xmlPullParser.getName().equals("CompanionAds") || !b(n10)) {
                                            if (null != xmlPullParser.getName() && "Companion".equals(xmlPullParser.getName()) && !b(n10)) {
                                                ++n9;
                                                int int1 = 0;
                                                int int2 = 0;
                                                try {
                                                    int1 = Integer.parseInt(xmlPullParser.getAttributeValue((String)null, "width"));
                                                    int2 = Integer.parseInt(xmlPullParser.getAttributeValue((String)null, "height"));
                                                }
                                                catch (Exception ex) {}
                                                if (int1 <= 0 || int2 <= 0) {
                                                    n10 = i(xmlPullParser);
                                                    continue;
                                                }
                                                final cw cw2;
                                                final cw cw = cw2 = new cw(int1, int2, xmlPullParser.getAttributeValue((String)null, "ID"));
                                                int n11 = i(xmlPullParser);
                                                String s = null;
                                                while (null == xmlPullParser.getName() || !xmlPullParser.getName().equals("Companion") || !b(n11)) {
                                                    Label_1910: {
                                                        if (null != xmlPullParser.getName() && !b(n11)) {
                                                            final String name4 = xmlPullParser.getName();
                                                            switch (name4) {
                                                                case "StaticResource": {
                                                                    final String attributeValue = xmlPullParser.getAttributeValue((String)null, "creativeType");
                                                                    if (i(xmlPullParser) == 4) {
                                                                        final String text2;
                                                                        s = (TextUtils.isEmpty((CharSequence)(text2 = xmlPullParser.getText())) ? null : text2.trim());
                                                                    }
                                                                    if (attributeValue != null && !attributeValue.trim().isEmpty()) {
                                                                        final String s2 = attributeValue;
                                                                        final int size = com.inmobi.media.cw.f.size();
                                                                        int i = 0;
                                                                        while (true) {
                                                                            while (i < size) {
                                                                                if (s2.equalsIgnoreCase(com.inmobi.media.cw.f.get(i))) {
                                                                                    final boolean b7 = true;
                                                                                    if (b7) {
                                                                                        cw2.a(new cw.a((byte)1, s));
                                                                                        break Label_1910;
                                                                                    }
                                                                                    this.d = true;
                                                                                    break Label_1910;
                                                                                }
                                                                                else {
                                                                                    ++i;
                                                                                }
                                                                            }
                                                                            final boolean b7 = false;
                                                                            continue;
                                                                        }
                                                                    }
                                                                    break;
                                                                }
                                                                case "HTMLResource": {
                                                                    final String text3;
                                                                    if (i(xmlPullParser) == 4 && !TextUtils.isEmpty((CharSequence)(text3 = xmlPullParser.getText()))) {
                                                                        cw2.a(new cw.a((byte)2, text3));
                                                                        break;
                                                                    }
                                                                    break;
                                                                }
                                                                case "IFrameResource": {
                                                                    final String text4;
                                                                    if (i(xmlPullParser) == 4 && !TextUtils.isEmpty((CharSequence)(text4 = xmlPullParser.getText()))) {
                                                                        cw2.a(new cw.a((byte)3, text4));
                                                                        break;
                                                                    }
                                                                    break;
                                                                }
                                                                case "CompanionClickTracking": {
                                                                    final String text5;
                                                                    if (i(xmlPullParser) == 4 && URLUtil.isValidUrl(s = (TextUtils.isEmpty((CharSequence)(text5 = xmlPullParser.getText())) ? null : text5.trim()))) {
                                                                        cw2.a(new bv(s, 0, "click", null));
                                                                        break;
                                                                    }
                                                                    break;
                                                                }
                                                                case "CompanionClickThrough": {
                                                                    final String text6;
                                                                    final String e;
                                                                    if (i(xmlPullParser) == 4 && URLUtil.isValidUrl(e = (TextUtils.isEmpty((CharSequence)(text6 = xmlPullParser.getText())) ? null : text6.trim()))) {
                                                                        cw2.e = e;
                                                                        break;
                                                                    }
                                                                    break;
                                                                }
                                                                case "TrackingEvents": {
                                                                    final cw cw3 = cw2;
                                                                    for (int n13 = i(xmlPullParser); null == xmlPullParser.getName() || !xmlPullParser.getName().equals("TrackingEvents") || !b(n13); n13 = i(xmlPullParser)) {
                                                                        if ("Tracking".equals(xmlPullParser.getName()) && !b(n13)) {
                                                                            final int attributeCount = xmlPullParser.getAttributeCount();
                                                                            int j = 0;
                                                                            while (j < attributeCount) {
                                                                                if (xmlPullParser.getAttributeName(j).equals("event")) {
                                                                                    final String attributeValue2 = xmlPullParser.getAttributeValue(j);
                                                                                    final String text7;
                                                                                    if (i(xmlPullParser) == 4 && URLUtil.isValidUrl(((text7 = xmlPullParser.getText()) == null) ? null : text7.trim())) {
                                                                                        cw3.a(new bv(xmlPullParser.getText(), 0, cz.f.get(attributeValue2), null));
                                                                                        break;
                                                                                    }
                                                                                    break;
                                                                                }
                                                                                else {
                                                                                    ++j;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    n11 = i(xmlPullParser);
                                                }
                                                final List<cw.a> c2;
                                                if ((c2 = cw.c) == null || c2.size() == 0) {
                                                    continue;
                                                }
                                                this.b.e.add(cw);
                                            }
                                            n10 = i(xmlPullParser);
                                        }
                                        final int size2;
                                        if ((size2 = this.b.e.size()) == 0 && this.d) {
                                            this.c(604);
                                            break;
                                        }
                                        if (n9 > 0 && size2 == 0) {
                                            this.c(600);
                                            break;
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                        if (!b3) {
                            this.a(101);
                        }
                        if (!b4) {
                            this.a(201);
                        }
                        if (!b3 || !b4 || n3 == 0) {
                            return;
                        }
                        break;
                    }
                    case "AdVerifications": {
                        this.g(xmlPullParser);
                        break;
                    }
                    case "Extensions": {
                        this.e(xmlPullParser);
                        break;
                    }
                }
            }
        }
        if (!b || !b2) {
            this.a(101);
        }
    }
    
    private static void a(final XmlPullParser xmlPullParser, final String anObject) {
        int next = 0;
        do {
            try {
                next = xmlPullParser.next();
            }
            catch (IOException ex) {}
            catch (XmlPullParserException ex2) {}
        } while (next != 1 && (xmlPullParser.getName() == null || !xmlPullParser.getName().equals(anObject)));
    }
    
    private static void a(final XmlPullParser xmlPullParser, final String[] array) {
        boolean b = false;
        int next = 0;
        do {
            try {
                next = xmlPullParser.next();
            }
            catch (IOException ex) {}
            catch (XmlPullParserException ex2) {}
            if (next == 1) {
                break;
            }
            if (xmlPullParser.getName() != null) {
                for (int i = 0; i < 2; ++i) {
                    if (xmlPullParser.getName().equals(array[i])) {
                        b = true;
                        break;
                    }
                }
            }
        } while (!b);
    }
    
    private boolean c(final XmlPullParser xmlPullParser) {
        boolean b = false;
        int n = i(xmlPullParser);
        while (null == xmlPullParser.getName() || !xmlPullParser.getName().equals("MediaFiles") || !b(n)) {
            if (null != xmlPullParser.getName() && "MediaFile".equals(xmlPullParser.getName()) && !b(n)) {
                String attributeValue = null;
                int intValue = 0;
                String attributeValue2 = null;
                b = true;
                final fe.c bitRate = this.c.bitRate;
                for (int attributeCount = xmlPullParser.getAttributeCount(), i = 0; i < attributeCount; ++i) {
                    final String attributeName = xmlPullParser.getAttributeName(i);
                    switch (attributeName) {
                        case "delivery": {
                            attributeValue = xmlPullParser.getAttributeValue(i);
                            break;
                        }
                        case "type": {
                            attributeValue2 = xmlPullParser.getAttributeValue(i);
                            break;
                        }
                        case "bitrate": {
                            try {
                                intValue = Integer.valueOf(xmlPullParser.getAttributeValue(i));
                            }
                            catch (Exception ex) {}
                            break;
                        }
                    }
                }
                if ((n = i(xmlPullParser)) == 4) {
                    final String text;
                    final String s;
                    if (!URLUtil.isValidUrl(s = (TextUtils.isEmpty((CharSequence)(text = xmlPullParser.getText())) ? null : text.trim()))) {
                        continue;
                    }
                    final String anotherString = "Progressive";
                    if ((bitRate.bitrate_mandatory && intValue <= 0) || attributeValue == null || !attributeValue.trim().equalsIgnoreCase(anotherString)) {
                        continue;
                    }
                    final List<String> allowedContentType = this.c.allowedContentType;
                    if (attributeValue2 != null) {
                        for (int j = 0; j < allowedContentType.size(); ++j) {
                            if (attributeValue2.equalsIgnoreCase(allowedContentType.get(j))) {
                                this.b.a.add(new cx(s, attributeValue, attributeValue2, intValue));
                            }
                        }
                    }
                }
            }
            n = i(xmlPullParser);
        }
        if (!b) {
            this.a(401);
            return false;
        }
        if (this.b.a.isEmpty()) {
            this.a(403);
            return false;
        }
        return true;
    }
    
    private void a(final XmlPullParser xmlPullParser, final boolean b) {
        for (int n = i(xmlPullParser); null == xmlPullParser.getName() || !xmlPullParser.getName().equals("VideoClicks") || !b(n); n = i(xmlPullParser)) {
            if (null != xmlPullParser.getName() && !b(n)) {
                final String name = xmlPullParser.getName();
                switch (name) {
                    case "ClickThrough": {
                        if (b && i(xmlPullParser) == 4) {
                            final String text;
                            this.b.c = (TextUtils.isEmpty((CharSequence)(text = xmlPullParser.getText())) ? null : text.trim());
                            break;
                        }
                        break;
                    }
                    case "ClickTracking": {
                        if (i(xmlPullParser) == 4) {
                            this.a("click", xmlPullParser.getText());
                            break;
                        }
                        break;
                    }
                }
            }
        }
    }
    
    private void d(final XmlPullParser xmlPullParser) {
        for (int n = i(xmlPullParser); null == xmlPullParser.getName() || !xmlPullParser.getName().equals("TrackingEvents") || !b(n); n = i(xmlPullParser)) {
            if (null != xmlPullParser.getName() && "Tracking".equals(xmlPullParser.getName()) && !b(n)) {
                final int attributeCount = xmlPullParser.getAttributeCount();
                int i = 0;
                while (i < attributeCount) {
                    if (xmlPullParser.getAttributeName(i).equals("event")) {
                        final String attributeValue = xmlPullParser.getAttributeValue(i);
                        if (i(xmlPullParser) == 4 && cz.f.containsKey(attributeValue)) {
                            this.a(cz.f.get(attributeValue), xmlPullParser.getText());
                            break;
                        }
                        break;
                    }
                    else {
                        ++i;
                    }
                }
            }
        }
    }
    
    private void e(final XmlPullParser xmlPullParser) {
        for (int n = i(xmlPullParser); null == xmlPullParser.getName() || !xmlPullParser.getName().equals("Extensions") || !b(n); n = i(xmlPullParser)) {
            if (null != xmlPullParser.getName() && !b(n)) {
                final String name = xmlPullParser.getName();
                switch (name) {
                    case "CompanionAdTracking": {
                        this.f(xmlPullParser);
                        break;
                    }
                    case "Extension": {
                        final String attributeValue;
                        if ((attributeValue = xmlPullParser.getAttributeValue((String)null, "type")) != null && attributeValue.equals("AdVerifications")) {
                            this.g(xmlPullParser);
                            break;
                        }
                        break;
                    }
                }
            }
        }
    }
    
    private void f(final XmlPullParser xmlPullParser) {
        for (int n = i(xmlPullParser); null == xmlPullParser.getName() || !xmlPullParser.getName().equals("CompanionAdTracking") || !b(n); n = i(xmlPullParser)) {
            if (null != xmlPullParser.getName() && !b(n) && "TrackingEvents".equals(xmlPullParser.getName())) {
                this.d(xmlPullParser);
            }
        }
    }
    
    private void g(final XmlPullParser xmlPullParser) {
        for (int n = i(xmlPullParser); null == xmlPullParser.getName() || !xmlPullParser.getName().equals("AdVerifications") || !b(n); n = i(xmlPullParser)) {
            if (null != xmlPullParser.getName() && !b(n)) {
                final String name = xmlPullParser.getName();
                switch (name) {
                    case "Verification": {
                        final String attributeValue;
                        if ((attributeValue = xmlPullParser.getAttributeValue((String)null, "vendor")) == null) {
                            break;
                        }
                        if (attributeValue.equals("Moat")) {
                            this.h(xmlPullParser);
                            break;
                        }
                        this.b(xmlPullParser, attributeValue);
                        break;
                    }
                }
            }
        }
    }
    
    private void h(final XmlPullParser xmlPullParser) {
        final StringBuilder sb = new StringBuilder();
        final StringBuilder s = new StringBuilder();
        final StringBuilder s2 = new StringBuilder();
        final String s3 = "<";
        final String s4 = ">";
        for (int n = i(xmlPullParser); null == xmlPullParser.getName() || !xmlPullParser.getName().equals("Verification") || !b(n); n = i(xmlPullParser)) {
            if (null != xmlPullParser.getName() && !b(n)) {
                final String name = xmlPullParser.getName();
                switch (name) {
                    case "ViewableImpression": {
                        final String name2 = xmlPullParser.getName();
                        final String name3 = xmlPullParser.getName();
                        for (int attributeCount = xmlPullParser.getAttributeCount(), i = 0; i < attributeCount; ++i) {
                            s.append(' ').append(xmlPullParser.getAttributeName(i)).append("=\"").append(xmlPullParser.getAttributeValue(i)).append("\"");
                        }
                        do {
                            try {
                                n = xmlPullParser.nextToken();
                            }
                            catch (IOException ex) {}
                            catch (XmlPullParserException ex2) {}
                            if (n == 4) {
                                s2.append(xmlPullParser.getText());
                            }
                            else if (n == 5) {
                                s2.append("<![CDATA[").append(xmlPullParser.getText()).append("]]>");
                            }
                        } while (!b(n));
                        sb.append(s3).append(name2).append((CharSequence)s).append(s4).append((CharSequence)s2).append(s3).append("/").append(name3).append(s4);
                        break;
                    }
                }
            }
        }
        if (sb.length() != 0) {
            this.b.a(new bv(sb.toString(), 0, "zMoatVASTIDs", null));
        }
    }
    
    @VisibleForTesting
    private void b(final XmlPullParser xmlPullParser, final String s) {
        String s2 = null;
        String s3 = null;
        for (int n = i(xmlPullParser); null == xmlPullParser.getName() || !xmlPullParser.getName().equals("Verification") || !b(n); n = i(xmlPullParser)) {
            if (null != xmlPullParser.getName() && !b(n)) {
                final String name = xmlPullParser.getName();
                switch (name) {
                    case "JavaScriptResource": {
                        final String attributeValue;
                        if ((attributeValue = xmlPullParser.getAttributeValue((String)null, "apiFramework")) != null && attributeValue.startsWith("omid") && i(xmlPullParser) == 4) {
                            final String text;
                            s2 = (TextUtils.isEmpty((CharSequence)(text = xmlPullParser.getText())) ? null : text.trim());
                            break;
                        }
                        break;
                    }
                    case "VerificationParameters": {
                        final int i;
                        if ((i = i(xmlPullParser)) == 5 || i == 4) {
                            s3 = (TextUtils.isEmpty((CharSequence)xmlPullParser.getText()) ? null : xmlPullParser.getText().trim());
                            break;
                        }
                        break;
                    }
                }
            }
        }
        if (URLUtil.isValidUrl(s2)) {
            this.b.a(new ea(s, s3, s2, "OMID_VIEWABILITY", null));
        }
    }
    
    private static int i(final XmlPullParser xmlPullParser) {
        try {
            return xmlPullParser.next();
        }
        catch (IOException ex) {}
        catch (XmlPullParserException ex2) {}
        return -1;
    }
    
    private static boolean a(@NonNull final String s, final XmlPullParser xmlPullParser) {
        return s.equals(xmlPullParser.getName());
    }
    
    private void a(final int f) {
        this.c(this.b.f = f);
    }
    
    private static boolean b(final int n) {
        return n == 3;
    }
    
    private void c(final int i) {
        final ba a = ba.a();
        final HashMap<String, String> hashMap;
        (hashMap = new HashMap<String, String>()).put("[ERRORCODE]", String.valueOf(i));
        for (final bv bv : this.b.d) {
            if ("error".equals(bv.d)) {
                a.a(hg.a(bv.b, hashMap), bv.e, true);
            }
        }
    }
    
    private boolean a(final String s, String s2) {
        if (!URLUtil.isValidUrl(s2 = (TextUtils.isEmpty((CharSequence)s2) ? null : s2.trim()))) {
            return !s.equals("Impression");
        }
        this.b.a(new bv(s2, 0, s, null));
        return true;
    }
    
    static {
        a = cz.class.getSimpleName();
        (f = new HashMap<String, String>()).put("Error", "error");
        cz.f.put("Impression", "Impression");
        cz.f.put("ClickTracking", "click");
        cz.f.put("creativeView", "creativeView");
        cz.f.put("start", "start");
        cz.f.put("firstQuartile", "firstQuartile");
        cz.f.put("midpoint", "midpoint");
        cz.f.put("thirdQuartile", "thirdQuartile");
        cz.f.put("complete", "complete");
        cz.f.put("mute", "mute");
        cz.f.put("unmute", "unmute");
        cz.f.put("pause", "pause");
        cz.f.put("resume", "resume");
        cz.f.put("fullscreen", "fullscreen");
        cz.f.put("exitFullscreen", "exitFullscreen");
        cz.f.put("closeEndCard", "closeEndCard");
    }
}
