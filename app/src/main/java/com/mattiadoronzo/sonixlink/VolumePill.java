package com.mattiadoronzo.sonixlink;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.mattiadoronzo.sonixlink.databinding.VolumePillBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: VolumePill.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001&B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0006\u0010\u0017\u001a\u00020\u0007J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\u000e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0006J\u0006\u0010\u001b\u001a\u00020\u0007J\b\u0010\u001c\u001a\u00020\u0007H\u0002J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0006H\u0002J\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 J\u001a\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\u0013H\u0002J\u0006\u0010$\u001a\u00020\u0007J\u000e\u0010%\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/VolumePill;", "", "views", "Lcom/mattiadoronzo/sonixlink/databinding/VolumePillBinding;", "send", "Lkotlin/Function1;", "", "", "(Lcom/mattiadoronzo/sonixlink/databinding/VolumePillBinding;Lkotlin/jvm/functions/Function1;)V", "clock", "Landroid/os/Handler;", "flushLater", "Ljava/lang/Runnable;", "hideLater", "holdUntil", "", "pending", "sentAt", "showing", "", "getShowing", "()Z", "touching", "accent", "flush", "follow", "level", "hide", "keepUp", "number", "onKey", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "queue", "value", "immediate", "release", "show", "Companion", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class VolumePill {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final long HIDE_MS = 1600;

    @Deprecated
    public static final int HIGH = 55;

    @Deprecated
    public static final long HOLD_MS = 700;

    @Deprecated
    public static final long SEND_MS = 100;

    @Deprecated
    public static final int STEP = 1;
    private final Handler clock;
    private final Runnable flushLater;
    private final Runnable hideLater;
    private long holdUntil;
    private int pending;
    private final Function1<Integer, Unit> send;
    private long sentAt;
    private boolean touching;
    private final VolumePillBinding views;

    /* JADX WARN: Multi-variable type inference failed */
    public VolumePill(VolumePillBinding views, Function1<? super Integer, Unit> send) {
        Intrinsics.checkNotNullParameter(views, "views");
        Intrinsics.checkNotNullParameter(send, "send");
        this.views = views;
        this.send = send;
        this.clock = new Handler(Looper.getMainLooper());
        this.hideLater = new Runnable() { // from class: com.mattiadoronzo.sonixlink.VolumePill$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                VolumePill.hideLater$lambda$0(this.f$0);
            }
        };
        this.flushLater = new Runnable() { // from class: com.mattiadoronzo.sonixlink.VolumePill$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                VolumePill.flushLater$lambda$1(this.f$0);
            }
        };
        this.pending = -1;
        this.views.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.VolumePill$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VolumePill._init_$lambda$2(this.f$0, view);
            }
        });
        this.views.volumeSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.mattiadoronzo.sonixlink.VolumePill.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar bar, int value, boolean fromUser) {
                Intrinsics.checkNotNullParameter(bar, "bar");
                if (fromUser) {
                    VolumePill.this.number(value);
                    VolumePill.queue$default(VolumePill.this, value, false, 2, null);
                    VolumePill.this.keepUp();
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar bar) {
                Intrinsics.checkNotNullParameter(bar, "bar");
                VolumePill.this.touching = true;
                VolumePill.this.clock.removeCallbacks(VolumePill.this.hideLater);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar bar) {
                Intrinsics.checkNotNullParameter(bar, "bar");
                VolumePill.this.touching = false;
                VolumePill.this.queue(bar.getProgress(), true);
                VolumePill.this.keepUp();
            }
        });
        accent();
    }

    /* JADX INFO: compiled from: VolumePill.kt */
    @Metadata(m147d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/VolumePill$Companion;", "", "()V", "HIDE_MS", "", "HIGH", "", "HOLD_MS", "SEND_MS", "STEP", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hideLater$lambda$0(VolumePill this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void flushLater$lambda$1(VolumePill this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.flush();
    }

    public final boolean getShowing() {
        return this.views.getRoot().getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(VolumePill this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hide();
    }

    public final void accent() {
        this.views.volumeSeek.setProgressTintList(ColorStateList.valueOf(Session.INSTANCE.getAccent()));
    }

    public final void release() {
        this.clock.removeCallbacks(this.hideLater);
        this.clock.removeCallbacks(this.flushLater);
    }

    public final boolean onKey(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int code = event.getKeyCode();
        if (code != 24 && code != 25) {
            return false;
        }
        if (event.getAction() == 0) {
            int step = code == 24 ? 1 : -1;
            int from = getShowing() ? this.views.volumeSeek.getProgress() : Session.INSTANCE.getState().getVolume();
            int target = RangesKt.coerceIn(from + step, 0, 100);
            show(target);
            queue$default(this, target, false, 2, null);
        }
        return true;
    }

    public final void show(int level) {
        this.views.volumeSeek.setProgress(RangesKt.coerceIn(level, 0, 100));
        number(level);
        this.views.getRoot().setVisibility(0);
        keepUp();
    }

    public final void hide() {
        this.views.getRoot().setVisibility(8);
    }

    public final void follow(int level) {
        if (!getShowing() || this.touching || this.pending >= 0 || SystemClock.uptimeMillis() < this.holdUntil) {
            return;
        }
        this.views.volumeSeek.setProgress(RangesKt.coerceIn(level, 0, 100));
        number(level);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void keepUp() {
        this.clock.removeCallbacks(this.hideLater);
        if (!this.touching) {
            this.clock.postDelayed(this.hideLater, HIDE_MS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void number(int level) {
        int i;
        Context context = this.views.getRoot().getContext();
        this.views.volumeText.setText(String.valueOf(level));
        this.views.volumeText.setTextColor(ContextCompat.getColor(context, level > 55 ? C1020R.color.volume_warn : C1020R.color.text_primary));
        ImageView imageView = this.views.volumeIcon;
        if (level <= 0) {
            i = C1020R.drawable.ic_volume_mute;
        } else {
            i = level < 55 ? C1020R.drawable.ic_volume_low : C1020R.drawable.ic_volume_high;
        }
        imageView.setImageResource(i);
    }

    static /* synthetic */ void queue$default(VolumePill volumePill, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        volumePill.queue(i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void queue(int value, boolean immediate) {
        this.pending = RangesKt.coerceIn(value, 0, 100);
        Session.INSTANCE.setState(PlayerState.copy$default(Session.INSTANCE.getState(), 0, null, this.pending, 0, 0, null, null, null, null, 0, 0, 0, false, 0, false, false, null, 0, 0, 0L, false, 0, 0, null, 0, 0, null, 0L, 0L, 0L, 1073741819, null));
        long now = SystemClock.uptimeMillis();
        this.holdUntil = 700 + now;
        long since = now - this.sentAt;
        this.clock.removeCallbacks(this.flushLater);
        if (!immediate && since < 100) {
            this.clock.postDelayed(this.flushLater, 100 - since);
        } else {
            flush();
        }
    }

    private final void flush() {
        int value = this.pending;
        if (value < 0) {
            return;
        }
        this.pending = -1;
        this.sentAt = SystemClock.uptimeMillis();
        this.send.invoke(Integer.valueOf(value));
    }
}
