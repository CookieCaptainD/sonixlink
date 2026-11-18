package com.mattiadoronzo.sonixlink;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Transport.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u0012\u001a\u00020\nH\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/Response;", "Ljava/lang/AutoCloseable;", "code", "", "length", "", "body", "Ljava/io/InputStream;", "onClose", "Lkotlin/Function0;", "", "(IJLjava/io/InputStream;Lkotlin/jvm/functions/Function0;)V", "getBody", "()Ljava/io/InputStream;", "getCode", "()I", "getLength", "()J", "close", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Response implements AutoCloseable {
    private final InputStream body;
    private final int code;
    private final long length;
    private final Function0<Unit> onClose;

    public Response(int code, long length, InputStream body, Function0<Unit> onClose) {
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        this.code = code;
        this.length = length;
        this.body = body;
        this.onClose = onClose;
    }

    public final int getCode() {
        return this.code;
    }

    public final long getLength() {
        return this.length;
    }

    public final InputStream getBody() {
        return this.body;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        try {
            this.body.close();
        } catch (IOException e) {
        }
        this.onClose.invoke();
    }
}
