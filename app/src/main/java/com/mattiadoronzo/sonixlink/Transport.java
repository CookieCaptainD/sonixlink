package com.mattiadoronzo.sonixlink;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: Transport.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H\u0016J6\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0012"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/Transport;", "", "label", "", "getLabel", "()Ljava/lang/String;", "close", "", "exchange", "Lcom/mattiadoronzo/sonixlink/Response;", "path", "method", "readTimeout", "", "bulk", "", "body", "", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface Transport {
    void close();

    Response exchange(String path, String method, int readTimeout, boolean bulk, byte[] body);

    String getLabel();

    /* JADX INFO: compiled from: Transport.kt */
    @Metadata(m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class DefaultImpls {
        public static /* synthetic */ Response exchange$default(Transport transport, String str, String str2, int i, boolean z, byte[] bArr, int i2, Object obj) {
            boolean z2;
            byte[] bArr2;
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exchange");
            }
            if ((i2 & 8) == 0) {
                z2 = z;
            } else {
                z2 = false;
            }
            if ((i2 & 16) == 0) {
                bArr2 = bArr;
            } else {
                bArr2 = null;
            }
            return transport.exchange(str, str2, i, z2, bArr2);
        }

        public static void close(Transport $this) {
        }
    }
}
