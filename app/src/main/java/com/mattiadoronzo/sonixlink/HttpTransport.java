package com.mattiadoronzo.sonixlink;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p001io.CloseableKt;

/* JADX INFO: compiled from: Transport.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J2\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/HttpTransport;", "Lcom/mattiadoronzo/sonixlink/Transport;", "host", "", "port", "", "(Ljava/lang/String;I)V", "label", "getLabel", "()Ljava/lang/String;", "exchange", "Lcom/mattiadoronzo/sonixlink/Response;", "path", "method", "readTimeout", "bulk", "", "body", "", "Companion", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class HttpTransport implements Transport {
    private static final int CONNECT_TIMEOUT = 3000;
    private final String host;
    private final int port;

    public HttpTransport(String host, int port) {
        Intrinsics.checkNotNullParameter(host, "host");
        this.host = host;
        this.port = port;
    }

    @Override // com.mattiadoronzo.sonixlink.Transport
    public void close() {
        Transport.DefaultImpls.close(this);
    }

    @Override // com.mattiadoronzo.sonixlink.Transport
    public String getLabel() {
        return this.host + ":" + this.port;
    }

    @Override // com.mattiadoronzo.sonixlink.Transport
    public Response exchange(String path, String method, int readTimeout, boolean bulk, byte[] body) throws IOException {
        InputStream stream;
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(method, "method");
        URLConnection uRLConnectionOpenConnection = new URL("http://" + this.host + ":" + this.port + path).openConnection();
        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        final HttpURLConnection $this$exchange_u24lambda_u240 = (HttpURLConnection) uRLConnectionOpenConnection;
        $this$exchange_u24lambda_u240.setRequestMethod(method);
        $this$exchange_u24lambda_u240.setConnectTimeout(3000);
        $this$exchange_u24lambda_u240.setReadTimeout(readTimeout);
        $this$exchange_u24lambda_u240.setUseCaches(false);
        boolean z = true;
        if (body != null) {
            $this$exchange_u24lambda_u240.setDoOutput(true);
            $this$exchange_u24lambda_u240.setFixedLengthStreamingMode(body.length);
            $this$exchange_u24lambda_u240.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
        }
        if (body != null) {
            try {
                OutputStream outputStream = $this$exchange_u24lambda_u240.getOutputStream();
                try {
                    OutputStream it = outputStream;
                    it.write(body);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(outputStream, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(outputStream, th);
                        throw th2;
                    }
                }
            } catch (IOException e) {
                $this$exchange_u24lambda_u240.disconnect();
                throw e;
            }
        }
        int code = $this$exchange_u24lambda_u240.getResponseCode();
        if (200 > code || code >= 300) {
            z = false;
        }
        InputStream inputStream = z ? $this$exchange_u24lambda_u240.getInputStream() : $this$exchange_u24lambda_u240.getErrorStream();
        if (inputStream != null) {
            stream = inputStream;
        } else {
            stream = new ByteArrayInputStream(new byte[0]);
        }
        return new Response(code, $this$exchange_u24lambda_u240.getContentLengthLong(), stream, new Function0<Unit>() { // from class: com.mattiadoronzo.sonixlink.HttpTransport.exchange.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                $this$exchange_u24lambda_u240.disconnect();
            }
        });
    }
}
