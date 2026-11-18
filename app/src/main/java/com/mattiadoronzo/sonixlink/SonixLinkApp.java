package com.mattiadoronzo.sonixlink;

import android.app.Application;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: SonixLinkApp.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/SonixLinkApp;", "Landroid/app/Application;", "()V", "onCreate", "", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SonixLinkApp extends Application {
    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        CrashLog.INSTANCE.install(this);
    }
}
