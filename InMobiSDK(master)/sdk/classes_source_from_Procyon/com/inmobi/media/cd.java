// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import com.inmobi.ads.InMobiAdRequestStatus;

public final class cd
{
    public gn a;
    public InMobiAdRequestStatus b;
    private cc c;
    
    public cd(final cc c, final gn a) {
        this.c = c;
        this.a = a;
        if (this.a.a != null) {
            switch (this.a.a.a) {
                case 0: {
                    this.b = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.NETWORK_UNREACHABLE);
                }
                case -7: {
                    this.b = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REQUEST_INVALID);
                    if (this.a.a.b != null) {
                        this.b.setCustomMessage(this.a.a.b);
                        return;
                    }
                    break;
                }
                case 504: {
                    this.b = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REQUEST_TIMED_OUT);
                }
                case 500:
                case 501:
                case 502:
                case 503:
                case 505: {
                    this.b = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.SERVER_ERROR);
                }
                case -8: {
                    this.b = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.GDPR_COMPLIANCE_ENFORCED);
                }
                default: {
                    this.b = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR);
                    break;
                }
            }
        }
    }
}
