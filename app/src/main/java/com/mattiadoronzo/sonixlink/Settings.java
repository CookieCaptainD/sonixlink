package com.mattiadoronzo.sonixlink;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Settings.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fJ\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00132\u0006\u0010\u000e\u001a\u00020\u000fJ\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00132\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000fJ\u001c\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00132\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000fJ\u001e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004J\u001e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004J\u001e\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\""}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/Settings;", "", "()V", "FILE", "", "KEY_ACCENT", "KEY_ASKED_NOTIFICATIONS", "KEY_COVERS_OWNER", "KEY_COVERS_VERSION", "KEY_DB_OWNER", "KEY_DB_VERSION", "KEY_HOST", "KEY_PORT", Settings.KEY_ACCENT, "context", "Landroid/content/Context;", "askedNotifications", "", "coversStamp", "Lkotlin/Pair;", "databaseStamp", "forgetHost", "", "lastHost", "", "rememberAccent", "rememberAskedNotifications", "rememberCoversStamp", "owner", "version", "rememberDatabaseStamp", "rememberHost", "host", "port", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Settings {
    private static final String FILE = "sonixlink";
    public static final Settings INSTANCE = new Settings();
    private static final String KEY_ACCENT = "accent";
    private static final String KEY_ASKED_NOTIFICATIONS = "asked_notifications";
    private static final String KEY_COVERS_OWNER = "covers_owner";
    private static final String KEY_COVERS_VERSION = "covers_version";
    private static final String KEY_DB_OWNER = "db_owner";
    private static final String KEY_DB_VERSION = "db_version";
    private static final String KEY_HOST = "last_host";
    private static final String KEY_PORT = "last_port";

    private Settings() {
    }

    public final Pair<String, Integer> lastHost(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences preferences = context.getSharedPreferences(FILE, 0);
        String host = preferences.getString(KEY_HOST, null);
        if (host == null || StringsKt.isBlank(host)) {
            return null;
        }
        return TuplesKt.m155to(host, Integer.valueOf(preferences.getInt(KEY_PORT, PlayerClient.DEFAULT_PORT)));
    }

    public final void rememberHost(Context context, String host, int port) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(host, "host");
        context.getSharedPreferences(FILE, 0).edit().putString(KEY_HOST, host).putInt(KEY_PORT, port).apply();
    }

    public final Pair<String, String> databaseStamp(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences preferences = context.getSharedPreferences(FILE, 0);
        String string = preferences.getString(KEY_DB_OWNER, "");
        if (string == null) {
            string = "";
        }
        String string2 = preferences.getString(KEY_DB_VERSION, "");
        return TuplesKt.m155to(string, string2 != null ? string2 : "");
    }

    public final void rememberDatabaseStamp(Context context, String owner, String version) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(version, "version");
        context.getSharedPreferences(FILE, 0).edit().putString(KEY_DB_OWNER, owner).putString(KEY_DB_VERSION, version).apply();
    }

    public final Pair<String, String> coversStamp(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences preferences = context.getSharedPreferences(FILE, 0);
        String string = preferences.getString(KEY_COVERS_OWNER, "");
        if (string == null) {
            string = "";
        }
        String string2 = preferences.getString(KEY_COVERS_VERSION, "");
        return TuplesKt.m155to(string, string2 != null ? string2 : "");
    }

    public final void rememberCoversStamp(Context context, String owner, String version) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(version, "version");
        context.getSharedPreferences(FILE, 0).edit().putString(KEY_COVERS_OWNER, owner).putString(KEY_COVERS_VERSION, version).apply();
    }

    public final String accent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getSharedPreferences(FILE, 0).getString(KEY_ACCENT, "");
        return string == null ? "" : string;
    }

    public final void rememberAccent(Context context, String accent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(accent, "accent");
        context.getSharedPreferences(FILE, 0).edit().putString(KEY_ACCENT, accent).apply();
    }

    public final boolean askedNotifications(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getSharedPreferences(FILE, 0).getBoolean(KEY_ASKED_NOTIFICATIONS, false);
    }

    public final void rememberAskedNotifications(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        context.getSharedPreferences(FILE, 0).edit().putBoolean(KEY_ASKED_NOTIFICATIONS, true).apply();
    }

    public final void forgetHost(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        context.getSharedPreferences(FILE, 0).edit().remove(KEY_HOST).remove(KEY_PORT).apply();
    }
}
