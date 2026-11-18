package com.mattiadoronzo.sonixlink;

import android.content.Context;
import android.os.Build;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p001io.CloseableKt;
import kotlin.p001io.FilesKt;

/* JADX INFO: compiled from: CrashLog.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/CrashLog;", "", "()V", "FILE", "", "clear", "", "context", "Landroid/content/Context;", "install", "pending", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CrashLog {
    private static final String FILE = "last-crash.txt";
    public static final CrashLog INSTANCE = new CrashLog();

    private CrashLog() {
    }

    public final void install(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        final File directory = context.getFilesDir();
        final Thread.UncaughtExceptionHandler previous = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.mattiadoronzo.sonixlink.CrashLog$$ExternalSyntheticLambda0
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread, Throwable th) {
                CrashLog.install$lambda$1(directory, previous, thread, th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void install$lambda$1(File $directory, Thread.UncaughtExceptionHandler $previous, Thread thread, Throwable error) {
        try {
            StringWriter text = new StringWriter();
            PrintWriter printWriter = new PrintWriter(text);
            try {
                PrintWriter writer = printWriter;
                String when_ = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date());
                writer.println("SonixLink 1.2 — " + when_);
                writer.println("thread: " + thread.getName());
                writer.println("Android " + Build.VERSION.RELEASE + " (API " + Build.VERSION.SDK_INT + ")");
                writer.println(Build.MANUFACTURER + " " + Build.MODEL);
                writer.println();
                error.printStackTrace(writer);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(printWriter, null);
                File file = new File($directory, FILE);
                String string = text.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                FilesKt.writeText$default(file, string, null, 2, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(printWriter, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
        }
        if ($previous != null) {
            $previous.uncaughtException(thread, error);
        }
    }

    public final String pending(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File file = new File(context.getFilesDir(), FILE);
        if (!file.exists()) {
            return null;
        }
        try {
            return FilesKt.readText$default(file, null, 1, null);
        } catch (Exception e) {
            return null;
        }
    }

    public final void clear(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        new File(context.getFilesDir(), FILE).delete();
    }
}
