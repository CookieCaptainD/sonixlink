package com.mattiadoronzo.sonixlink;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.SystemClock;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.media.VolumeProviderCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: PlayerService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 D2\u00020\u0001:\u0001DB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020!H\u0002J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00042\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020!H\u0002J\b\u0010&\u001a\u00020!H\u0002J\b\u0010'\u001a\u00020!H\u0002J\u0010\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\u0006H\u0002J\b\u0010*\u001a\u00020!H\u0002J\b\u0010+\u001a\u00020!H\u0003J\u0014\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020!H\u0016J\b\u00101\u001a\u00020!H\u0016J\"\u00102\u001a\u00020\n2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\nH\u0016J\b\u00105\u001a\u00020\u001dH\u0002J\u0010\u00106\u001a\u00020!2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u000208H\u0082@¢\u0006\u0002\u0010:J\b\u0010;\u001a\u00020!H\u0002J\u001c\u0010<\u001a\u00020!2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020!0=H\u0002J\u0010\u0010>\u001a\u00020!2\u0006\u0010?\u001a\u00020\nH\u0002J\u0010\u0010@\u001a\u00020!2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010A\u001a\u00020!H\u0002J\b\u0010B\u001a\u00020!H\u0002J\u0012\u0010C\u001a\u0004\u0018\u00010\u00042\u0006\u0010)\u001a\u00020\u0006H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0018\u00010\u0017R\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0018\u00010\u001aR\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/PlayerService;", "Landroid/app/Service;", "()V", "art", "Landroid/graphics/Bitmap;", "artPath", "", "client", "Lcom/mattiadoronzo/sonixlink/PlayerClient;", "failures", "", "name", "poller", "Lkotlinx/coroutines/Job;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "session", "Landroid/support/v4/media/session/MediaSessionCompat;", "state", "Lcom/mattiadoronzo/sonixlink/PlayerState;", "volume", "Landroidx/media/VolumeProviderCompat;", "wakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "wifiLock", "Landroid/net/wifi/WifiManager$WifiLock;", "Landroid/net/wifi/WifiManager;", "action", "Landroid/app/PendingIntent;", "buildNotification", "Landroid/app/Notification;", "createChannel", "", "decode", "bytes", "", "disconnect", "goForeground", "holdLocks", "loadArt", "path", "lostPlayer", "notifyNow", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "onStartCommand", "flags", "startId", "openApp", "publishMetadata", "refresh", "", SyncActivity.EXTRA_FORCE, "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "releaseLocks", "send", "Lkotlin/Function1;", "setVolume", "level", "show", "startPolling", "stopEverything", "thumbnail", "Companion", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PlayerService extends Service {
    private static final String ACTION_NEXT = "com.mattiadoronzo.sonixlink.NEXT";
    private static final String ACTION_PREVIOUS = "com.mattiadoronzo.sonixlink.PREVIOUS";
    private static final String ACTION_STOP = "com.mattiadoronzo.sonixlink.STOP";
    private static final String ACTION_TOGGLE = "com.mattiadoronzo.sonixlink.TOGGLE";
    private static final int ART_SIDE = 512;
    private static final String CHANNEL = "playback";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_HOST = "host";
    private static final String EXTRA_NAME = "name";
    private static final String EXTRA_PORT = "port";
    private static final long FRESH_MS = 1500;
    private static final int GIVE_UP_AFTER = 3;
    private static final int NOTIFICATION_ID = 1;
    private static final long PAUSED_MS = 5000;
    private static final long PLAYING_MS = 2000;
    private static final long RETRY_MS = 2000;
    private static final int VOLUME_STEP = 1;
    private static volatile boolean running;
    private Bitmap art;
    private volatile String artPath;
    private PlayerClient client;
    private int failures;
    private Job poller;
    private MediaSessionCompat session;
    private VolumeProviderCompat volume;
    private PowerManager.WakeLock wakeLock;
    private WifiManager.WifiLock wifiLock;
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));
    private String name = "";
    private PlayerState state = PlayerState.INSTANCE.getEMPTY();

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.PlayerService$refresh$1 */
    /* JADX INFO: compiled from: PlayerService.kt */
    @Metadata(m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.PlayerService", m164f = "PlayerService.kt", m165i = {0, 0}, m166l = {251}, m167m = "refresh", m168n = {"this", "current"}, m169s = {"L$0", "L$1"})
    static final class C09931 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C09931(Continuation<? super C09931> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlayerService.this.refresh(false, this);
        }
    }

    /* JADX INFO: compiled from: PlayerService.kt */
    @Metadata(m147d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\u0004J\u000e\u0010\"\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006#"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/PlayerService$Companion;", "", "()V", "ACTION_NEXT", "", "ACTION_PREVIOUS", "ACTION_STOP", "ACTION_TOGGLE", "ART_SIDE", "", "CHANNEL", "EXTRA_HOST", "EXTRA_NAME", "EXTRA_PORT", "FRESH_MS", "", "GIVE_UP_AFTER", "NOTIFICATION_ID", "PAUSED_MS", "PLAYING_MS", "RETRY_MS", "VOLUME_STEP", "<set-?>", "", "running", "getRunning", "()Z", "start", "", "context", "Landroid/content/Context;", "host", "port", "name", "stop", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getRunning() {
            return PlayerService.running;
        }

        public final void start(Context context, String host, int port, String name) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(name, "name");
            Intent intent = new Intent(context, (Class<?>) PlayerService.class).putExtra("host", host).putExtra("port", port).putExtra("name", name);
            Intrinsics.checkNotNullExpressionValue(intent, "putExtra(...)");
            ContextCompat.startForegroundService(context, intent);
        }

        public final void stop(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startService(new Intent(context, (Class<?>) PlayerService.class).setAction(PlayerService.ACTION_STOP));
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        running = true;
        createChannel();
        this.volume = new VolumeProviderCompat() { // from class: com.mattiadoronzo.sonixlink.PlayerService.onCreate.1
            {
                super(2, 100, 0);
            }

            @Override // androidx.media.VolumeProviderCompat
            public void onSetVolumeTo(int volume) {
                PlayerService.this.setVolume(volume);
            }

            @Override // androidx.media.VolumeProviderCompat
            public void onAdjustVolume(int direction) {
                if (direction != 0) {
                    PlayerService.this.setVolume(getCurrentVolume() + (direction * 1));
                }
            }
        };
        MediaSessionCompat $this$onCreate_u24lambda_u240 = new MediaSessionCompat(this, "SonixLink");
        $this$onCreate_u24lambda_u240.setCallback(new MediaSessionCompat.Callback() { // from class: com.mattiadoronzo.sonixlink.PlayerService$onCreate$2$1
            @Override // android.support.v4.media.session.MediaSessionCompat.Callback
            public void onPlay() {
                this.this$0.send(new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.PlayerService$onCreate$2$1$onPlay$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PlayerClient playerClient) {
                        invoke2(playerClient);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(PlayerClient it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.play();
                    }
                });
            }

            @Override // android.support.v4.media.session.MediaSessionCompat.Callback
            public void onPause() {
                this.this$0.send(new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.PlayerService$onCreate$2$1$onPause$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PlayerClient playerClient) {
                        invoke2(playerClient);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(PlayerClient it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.pause();
                    }
                });
            }

            @Override // android.support.v4.media.session.MediaSessionCompat.Callback
            public void onSkipToNext() {
                this.this$0.send(new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.PlayerService$onCreate$2$1$onSkipToNext$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PlayerClient playerClient) {
                        invoke2(playerClient);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(PlayerClient it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.next();
                    }
                });
            }

            @Override // android.support.v4.media.session.MediaSessionCompat.Callback
            public void onSkipToPrevious() {
                this.this$0.send(new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.PlayerService$onCreate$2$1$onSkipToPrevious$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PlayerClient playerClient) {
                        invoke2(playerClient);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(PlayerClient it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.previous();
                    }
                });
            }

            @Override // android.support.v4.media.session.MediaSessionCompat.Callback
            public void onSeekTo(final long pos) {
                this.this$0.send(new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.PlayerService$onCreate$2$1$onSeekTo$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PlayerClient playerClient) {
                        invoke2(playerClient);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(PlayerClient it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.seek((int) (pos / ((long) 1000)));
                    }
                });
            }

            @Override // android.support.v4.media.session.MediaSessionCompat.Callback
            public void onStop() {
                this.this$0.disconnect();
            }
        });
        VolumeProviderCompat volumeProviderCompat = this.volume;
        if (volumeProviderCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volume");
            volumeProviderCompat = null;
        }
        $this$onCreate_u24lambda_u240.setPlaybackToRemote(volumeProviderCompat);
        $this$onCreate_u24lambda_u240.setSessionActivity(openApp());
        $this$onCreate_u24lambda_u240.setActive(true);
        this.session = $this$onCreate_u24lambda_u240;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:28:0x0057  */
    /* JADX WARN: Code duplicated, block: B:30:0x005c  */
    /* JADX WARN: Code duplicated, block: B:31:0x0063  */
    /* JADX WARN: Code duplicated, block: B:34:0x0068  */
    /* JADX WARN: Code duplicated, block: B:37:0x0072  */
    /* JADX WARN: Code duplicated, block: B:38:0x0074  */
    /* JADX WARN: Code duplicated, block: B:40:0x0077  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:44:0x0083  */
    /* JADX WARN: Code duplicated, block: B:45:0x008a  */
    /* JADX WARN: Code duplicated, block: B:48:0x008e  */
    /* JADX WARN: Code duplicated, block: B:51:0x0095  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:56:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:58:0x00c0  */
    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        String host;
        boolean z;
        int port;
        String stringExtra;
        PlayerClient current;
        String action = intent != null ? intent.getAction() : null;
        if (action != null) {
            switch (action) {
                case "com.mattiadoronzo.sonixlink.PREVIOUS":
                    send(new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.PlayerService.onStartCommand.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(PlayerClient playerClient) {
                            invoke2(playerClient);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(PlayerClient it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            it.previous();
                        }
                    });
                    break;
                case "com.mattiadoronzo.sonixlink.TOGGLE":
                    send(new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.PlayerService.onStartCommand.2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(PlayerClient playerClient) {
                            invoke2(playerClient);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(PlayerClient it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            it.toggle();
                        }
                    });
                    break;
                case "com.mattiadoronzo.sonixlink.NEXT":
                    send(new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.PlayerService.onStartCommand.3
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(PlayerClient playerClient) {
                            invoke2(playerClient);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(PlayerClient it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            it.next();
                        }
                    });
                    break;
                case "com.mattiadoronzo.sonixlink.STOP":
                    disconnect();
                    break;
                default:
                    goForeground();
                    if (intent != null) {
                        host = intent.getStringExtra("host");
                    } else {
                        host = null;
                    }
                    if (host == null) {
                        host = "";
                    }
                    if (host.length() > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        port = PlayerClient.DEFAULT_PORT;
                        if (intent != null) {
                            port = intent.getIntExtra("port", PlayerClient.DEFAULT_PORT);
                        }
                        if (intent != null) {
                            stringExtra = intent.getStringExtra("name");
                        } else {
                            stringExtra = null;
                        }
                        this.name = stringExtra != null ? stringExtra : "";
                        current = this.client;
                        if (current != null || !Intrinsics.areEqual(current.getHost(), host) || current.getPort() != port) {
                            this.client = new PlayerClient(host, port);
                            this.state = PlayerState.INSTANCE.getEMPTY();
                            this.artPath = null;
                            this.art = null;
                            startPolling();
                        }
                    } else if (this.client == null) {
                        stopEverything();
                    }
                    break;
            }
            return 2;
        }
        goForeground();
        if (intent != null) {
            host = intent.getStringExtra("host");
        } else {
            host = null;
        }
        if (host == null) {
            host = "";
        }
        if (host.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            port = PlayerClient.DEFAULT_PORT;
            if (intent != null) {
                port = intent.getIntExtra("port", PlayerClient.DEFAULT_PORT);
            }
            if (intent != null) {
                stringExtra = intent.getStringExtra("name");
            } else {
                stringExtra = null;
            }
            this.name = stringExtra != null ? stringExtra : "";
            current = this.client;
            if (current != null) {
                this.client = new PlayerClient(host, port);
                this.state = PlayerState.INSTANCE.getEMPTY();
                this.artPath = null;
                this.art = null;
                startPolling();
            } else {
                this.client = new PlayerClient(host, port);
                this.state = PlayerState.INSTANCE.getEMPTY();
                this.artPath = null;
                this.art = null;
                startPolling();
            }
        } else if (this.client == null) {
            stopEverything();
            return 2;
        }
        return 2;
    }

    @Override // android.app.Service
    public void onDestroy() {
        running = false;
        Job job = this.poller;
        MediaSessionCompat mediaSessionCompat = null;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
        releaseLocks();
        MediaSessionCompat mediaSessionCompat2 = this.session;
        if (mediaSessionCompat2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("session");
            mediaSessionCompat2 = null;
        }
        mediaSessionCompat2.setActive(false);
        MediaSessionCompat mediaSessionCompat3 = this.session;
        if (mediaSessionCompat3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("session");
        } else {
            mediaSessionCompat = mediaSessionCompat3;
        }
        mediaSessionCompat.release();
        super.onDestroy();
    }

    private final void startPolling() {
        Job job = this.poller;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.failures = 0;
        this.poller = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C09961(null), 3, null);
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.PlayerService$startPolling$1 */
    /* JADX INFO: compiled from: PlayerService.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.PlayerService$startPolling$1", m164f = "PlayerService.kt", m165i = {0, 1}, m166l = {221, 226}, m167m = "invokeSuspend", m168n = {"$this$launch", "$this$launch"}, m169s = {"L$0", "L$0"})
    static final class C09961 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C09961(Continuation<? super C09961> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C09961 c09961 = PlayerService.this.new C09961(continuation);
            c09961.L$0 = obj;
            return c09961;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09961) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0036  */
        /* JADX WARN: Code duplicated, block: B:13:0x0048 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:14:0x0049  */
        /* JADX WARN: Code duplicated, block: B:17:0x005e  */
        /* JADX WARN: Code duplicated, block: B:19:0x0066  */
        /* JADX WARN: Code duplicated, block: B:22:0x0072 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:27:0x0085 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:28:0x0086  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0086 -> B:9:0x0030). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r9.label
                switch(r1) {
                    case 0: goto L28;
                    case 1: goto L1b;
                    case 2: goto L11;
                    default: goto L9;
                }
            L9:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L11:
                r1 = r9
                java.lang.Object r2 = r1.L$0
                kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
                kotlin.ResultKt.throwOnFailure(r10)
                goto L8a
            L1b:
                r1 = r9
                java.lang.Object r2 = r1.L$0
                kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
                kotlin.ResultKt.throwOnFailure(r10)
                r3 = r2
                r2 = r1
                r1 = r0
                r0 = r10
                goto L4f
            L28:
                kotlin.ResultKt.throwOnFailure(r10)
                r1 = r9
                java.lang.Object r2 = r1.L$0
                kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            L30:
                boolean r3 = kotlinx.coroutines.CoroutineScopeKt.isActive(r2)
                if (r3 == 0) goto L8b
                com.mattiadoronzo.sonixlink.PlayerService r3 = com.mattiadoronzo.sonixlink.PlayerService.this
                r4 = r1
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r1.L$0 = r2
                r5 = 1
                r1.label = r5
                r6 = 0
                r7 = 0
                java.lang.Object r3 = com.mattiadoronzo.sonixlink.PlayerService.refresh$default(r3, r6, r4, r5, r7)
                if (r3 != r0) goto L49
                return r0
            L49:
                r8 = r0
                r0 = r10
                r10 = r3
                r3 = r2
                r2 = r1
                r1 = r8
            L4f:
                java.lang.Boolean r10 = (java.lang.Boolean) r10
                boolean r10 = r10.booleanValue()
                com.mattiadoronzo.sonixlink.PlayerService r4 = com.mattiadoronzo.sonixlink.PlayerService.this
                int r4 = com.mattiadoronzo.sonixlink.PlayerService.access$getFailures$p(r4)
                r5 = 3
                if (r4 < r5) goto L66
                com.mattiadoronzo.sonixlink.PlayerService r10 = com.mattiadoronzo.sonixlink.PlayerService.this
                com.mattiadoronzo.sonixlink.PlayerService.access$lostPlayer(r10)
                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                return r10
            L66:
                com.mattiadoronzo.sonixlink.PlayerService r4 = com.mattiadoronzo.sonixlink.PlayerService.this
                int r4 = com.mattiadoronzo.sonixlink.PlayerService.access$getFailures$p(r4)
                r5 = 2000(0x7d0, double:9.88E-321)
                if (r4 <= 0) goto L72
                goto L77
            L72:
                if (r10 == 0) goto L75
                goto L77
            L75:
                r5 = 5000(0x1388, double:2.4703E-320)
            L77:
                r10 = r2
                kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
                r2.L$0 = r3
                r4 = 2
                r2.label = r4
                java.lang.Object r10 = kotlinx.coroutines.DelayKt.delay(r5, r10)
                if (r10 != r1) goto L86
                return r1
            L86:
                r10 = r0
                r0 = r1
                r1 = r2
                r2 = r3
            L8a:
                goto L30
            L8b:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mattiadoronzo.sonixlink.PlayerService.C09961.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object refresh(boolean force, Continuation<? super Boolean> continuation) throws Throwable {
        C09931 c09931;
        PlayerClient current;
        Object objWithContext;
        PlayerService playerService;
        if (continuation instanceof C09931) {
            c09931 = (C09931) continuation;
            if ((c09931.label & Integer.MIN_VALUE) != 0) {
                c09931.label -= Integer.MIN_VALUE;
            } else {
                c09931 = new C09931(continuation);
            }
        } else {
            c09931 = new C09931(continuation);
        }
        C09931 c09932 = c09931;
        Object $result = c09932.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c09932.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                current = this.client;
                if (current == null) {
                    return Boxing.boxBoolean(false);
                }
                long age = SystemClock.elapsedRealtime() - Session.INSTANCE.getStateAt();
                if (!force) {
                    boolean force2 = 0 <= age && age < FRESH_MS;
                    if (force2 && Session.INSTANCE.getState() != this.state) {
                        this.failures = 0;
                        this.state = Session.INSTANCE.getState();
                        show(this.state);
                        return Boxing.boxBoolean(this.state.isPlaying());
                    }
                }
                CoroutineDispatcher io = Dispatchers.getIO();
                PlayerService$refresh$read$1 playerService$refresh$read$1 = new PlayerService$refresh$read$1(current, null);
                c09932.L$0 = this;
                c09932.L$1 = current;
                c09932.label = 1;
                objWithContext = BuildersKt.withContext(io, playerService$refresh$read$1, c09932);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                playerService = this;
                break;
            case 1:
                PlayerClient current2 = (PlayerClient) c09932.L$1;
                playerService = (PlayerService) c09932.L$0;
                ResultKt.throwOnFailure($result);
                current = current2;
                objWithContext = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        PlayerState read = (PlayerState) objWithContext;
        if (read == null) {
            playerService.failures++;
            return Boxing.boxBoolean(playerService.state.isPlaying());
        }
        playerService.failures = 0;
        if (current != playerService.client) {
            return Boxing.boxBoolean(false);
        }
        playerService.state = read;
        Session.INSTANCE.setState(read);
        playerService.show(read);
        return Boxing.boxBoolean(read.isPlaying());
    }

    static /* synthetic */ Object refresh$default(PlayerService playerService, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return playerService.refresh(z, continuation);
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.PlayerService$send$1 */
    /* JADX INFO: compiled from: PlayerService.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.PlayerService$send$1", m164f = "PlayerService.kt", m165i = {}, m166l = {273, 280}, m167m = "invokeSuspend", m168n = {}, m169s = {})
    static final class C09941 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<PlayerClient, Unit> $action;
        final /* synthetic */ PlayerClient $current;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09941(Function1<? super PlayerClient, Unit> function1, PlayerClient playerClient, Continuation<? super C09941> continuation) {
            super(2, continuation);
            this.$action = function1;
            this.$current = playerClient;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PlayerService.this.new C09941(this.$action, this.$current, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09941) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.PlayerService$send$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: PlayerService.kt */
        @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.PlayerService$send$1$1", m164f = "PlayerService.kt", m165i = {}, m166l = {}, m167m = "invokeSuspend", m168n = {}, m169s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<PlayerClient, Unit> $action;
            final /* synthetic */ PlayerClient $current;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(Function1<? super PlayerClient, Unit> function1, PlayerClient playerClient, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$action = function1;
                this.$current = playerClient;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$action, this.$current, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        try {
                            this.$action.invoke(this.$current);
                            break;
                        } catch (Exception e) {
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:13:0x004c A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:14:0x004d  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            C09941 c09941;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c09941 = this;
                    c09941.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1(c09941.$action, c09941.$current, null), c09941) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c09941.label = 2;
                    if (PlayerService.this.refresh(true, c09941) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 1:
                    c09941 = this;
                    ResultKt.throwOnFailure($result);
                    c09941.label = 2;
                    if (PlayerService.this.refresh(true, c09941) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 2:
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void send(Function1<? super PlayerClient, Unit> action) {
        PlayerClient current = this.client;
        if (current == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C09941(action, current, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVolume(int level) {
        final int target = RangesKt.coerceIn(level, 0, 100);
        VolumeProviderCompat volumeProviderCompat = this.volume;
        if (volumeProviderCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volume");
            volumeProviderCompat = null;
        }
        volumeProviderCompat.setCurrentVolume(target);
        send(new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.PlayerService.setVolume.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PlayerClient playerClient) {
                invoke2(playerClient);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PlayerClient it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.setVolume(target);
            }
        });
    }

    private final void show(PlayerState state) {
        int playback;
        VolumeProviderCompat volumeProviderCompat = null;
        if (!Intrinsics.areEqual(state.getPath(), this.artPath)) {
            this.artPath = state.getPath();
            this.art = null;
            loadArt(state.getPath());
        }
        publishMetadata(state);
        switch (state.getPlayState()) {
            case 1:
                playback = 3;
                break;
            case 2:
                playback = 2;
                break;
            default:
                playback = 1;
                break;
        }
        MediaSessionCompat mediaSessionCompat = this.session;
        if (mediaSessionCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("session");
            mediaSessionCompat = null;
        }
        mediaSessionCompat.setPlaybackState(new PlaybackStateCompat.Builder().setActions(823L).setState(playback, ((long) state.getPosition()) * 1000, state.isPlaying() ? 1.0f : 0.0f).build());
        VolumeProviderCompat volumeProviderCompat2 = this.volume;
        if (volumeProviderCompat2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volume");
            volumeProviderCompat2 = null;
        }
        if (volumeProviderCompat2.getCurrentVolume() != state.getVolume()) {
            VolumeProviderCompat volumeProviderCompat3 = this.volume;
            if (volumeProviderCompat3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("volume");
            } else {
                volumeProviderCompat = volumeProviderCompat3;
            }
            volumeProviderCompat.setCurrentVolume(RangesKt.coerceIn(state.getVolume(), 0, 100));
        }
        if (state.isPlaying()) {
            holdLocks();
        } else {
            releaseLocks();
        }
        notifyNow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void publishMetadata(PlayerState state) {
        String title;
        MediaSessionCompat mediaSessionCompat = null;
        if (state.getHasTrack()) {
            String title2 = state.getTitle();
            if (title2.length() == 0) {
                title2 = StringsKt.substringAfterLast$default(state.getPath(), '/', (String) null, 2, (Object) null);
            }
            title = title2;
        } else {
            title = getString(C1020R.string.nothing_playing);
            Intrinsics.checkNotNull(title);
        }
        MediaMetadataCompat.Builder builder = new MediaMetadataCompat.Builder().putString(MediaMetadataCompat.METADATA_KEY_TITLE, title).putString(MediaMetadataCompat.METADATA_KEY_ARTIST, state.getArtist()).putString(MediaMetadataCompat.METADATA_KEY_ALBUM, state.getAlbum()).putLong(MediaMetadataCompat.METADATA_KEY_DURATION, ((long) state.getDuration()) * 1000);
        Bitmap it = this.art;
        if (it != null) {
            builder.putBitmap(MediaMetadataCompat.METADATA_KEY_ALBUM_ART, it);
        }
        MediaSessionCompat mediaSessionCompat2 = this.session;
        if (mediaSessionCompat2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("session");
        } else {
            mediaSessionCompat = mediaSessionCompat2;
        }
        mediaSessionCompat.setMetadata(builder.build());
    }

    private final void loadArt(String path) {
        PlayerClient current = this.client;
        if (current == null) {
            return;
        }
        if (path.length() == 0) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C09871(path, current, null), 3, null);
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.PlayerService$loadArt$1 */
    /* JADX INFO: compiled from: PlayerService.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.PlayerService$loadArt$1", m164f = "PlayerService.kt", m165i = {}, m166l = {352}, m167m = "invokeSuspend", m168n = {}, m169s = {})
    static final class C09871 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PlayerClient $current;
        final /* synthetic */ String $path;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09871(String str, PlayerClient playerClient, Continuation<? super C09871> continuation) {
            super(2, continuation);
            this.$path = str;
            this.$current = playerClient;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PlayerService.this.new C09871(this.$path, this.$current, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09871) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            C09871 c09871;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c09871 = this;
                    c09871.label = 1;
                    Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new PlayerService$loadArt$1$bitmap$1(c09871.$current, c09871.$path, PlayerService.this, null), c09871);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objWithContext;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    c09871 = this;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Bitmap bitmap = (Bitmap) $result;
            if (Intrinsics.areEqual(PlayerService.this.artPath, c09871.$path) && bitmap != null) {
                PlayerService.this.art = bitmap;
                PlayerService.this.publishMetadata(PlayerService.this.state);
                PlayerService.this.notifyNow();
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap thumbnail(String path) {
        Map<String, Row> mapTracksByPaths;
        Row row;
        Bitmap bitmapForTrack;
        Library library = Session.INSTANCE.getLibrary();
        if (library == null || (mapTracksByPaths = library.tracksByPaths(CollectionsKt.listOf(path))) == null || (row = mapTracksByPaths.get(path)) == null) {
            return null;
        }
        Covers covers = Session.INSTANCE.getCovers();
        if (covers != null && (bitmapForTrack = covers.forTrack(row.getArtPath(), row.getArtMtime(), row.getArtSize())) != null) {
            return bitmapForTrack;
        }
        Covers covers2 = Session.INSTANCE.getCovers();
        if (covers2 != null) {
            return covers2.forAlbum(row.getAlbum());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap decode(byte[] bytes) {
        BitmapFactory.Options bounds = new BitmapFactory.Options();
        bounds.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bytes, 0, bytes.length, bounds);
        int sample = 1;
        int side = Math.max(bounds.outWidth, bounds.outHeight);
        while (side / (sample * 2) >= 512) {
            sample *= 2;
        }
        try {
            int length = bytes.length;
            BitmapFactory.Options $this$decode_u24lambda_u244 = new BitmapFactory.Options();
            $this$decode_u24lambda_u244.inSampleSize = sample;
            Unit unit = Unit.INSTANCE;
            return BitmapFactory.decodeByteArray(bytes, 0, length, $this$decode_u24lambda_u244);
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    private final void createChannel() {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        NotificationChannel channel = new NotificationChannel(CHANNEL, getString(C1020R.string.notification_channel), 2);
        channel.setDescription(getString(C1020R.string.notification_channel_description));
        channel.setShowBadge(false);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(channel);
        }
    }

    private final Notification buildNotification() {
        String title;
        MediaSessionCompat mediaSessionCompat = null;
        if (this.state.getHasTrack()) {
            String title2 = this.state.getTitle();
            if (title2.length() == 0) {
                title2 = StringsKt.substringAfterLast$default(this.state.getPath(), '/', (String) null, 2, (Object) null);
            }
            title = title2;
        } else {
            int i = C1020R.string.notification_connected;
            String str = this.name;
            if (str.length() == 0) {
                PlayerClient playerClient = this.client;
                String label = playerClient != null ? playerClient.getLabel() : null;
                if (label == null) {
                    label = "";
                }
                str = label;
            }
            title = getString(i, new Object[]{str});
            Intrinsics.checkNotNull(title);
        }
        Iterable $this$filter$iv = CollectionsKt.listOf((Object[]) new String[]{this.state.getArtist(), this.state.getAlbum()});
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            String it = (String) element$iv$iv;
            if (it.length() > 0) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        String text = CollectionsKt.joinToString$default((List) destination$iv$iv, " — ", null, null, 0, null, null, 62, null);
        NotificationCompat.Builder contentText = new NotificationCompat.Builder(this, CHANNEL).setSmallIcon(C1020R.drawable.ic_notification).setContentTitle(title).setContentText(text);
        String str2 = this.name;
        if (str2.length() == 0) {
            str2 = null;
        }
        NotificationCompat.Builder builderAddAction = contentText.setSubText(str2).setLargeIcon(this.art).setContentIntent(openApp()).setDeleteIntent(action(ACTION_STOP)).setOnlyAlertOnce(true).setShowWhen(false).setOngoing(true).setVisibility(1).setCategory(NotificationCompat.CATEGORY_TRANSPORT).setColor(Session.INSTANCE.getAccent()).addAction(C1020R.drawable.ic_prev, getString(C1020R.string.cd_prev), action(ACTION_PREVIOUS)).addAction(this.state.isPlaying() ? C1020R.drawable.ic_pause : C1020R.drawable.ic_play, getString(this.state.isPlaying() ? C1020R.string.cd_pause : C1020R.string.cd_play), action(ACTION_TOGGLE)).addAction(C1020R.drawable.ic_next, getString(C1020R.string.cd_next), action(ACTION_NEXT)).addAction(C1020R.drawable.ic_close, getString(C1020R.string.notification_disconnect), action(ACTION_STOP));
        androidx.media.app.NotificationCompat.MediaStyle mediaStyle = new androidx.media.app.NotificationCompat.MediaStyle();
        MediaSessionCompat mediaSessionCompat2 = this.session;
        if (mediaSessionCompat2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("session");
        } else {
            mediaSessionCompat = mediaSessionCompat2;
        }
        Notification notificationBuild = builderAddAction.setStyle(mediaStyle.setMediaSession(mediaSessionCompat.getSessionToken()).setShowActionsInCompactView(0, 1, 2)).build();
        Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
        return notificationBuild;
    }

    private final void goForeground() {
        Notification notification = buildNotification();
        if (Build.VERSION.SDK_INT >= 29) {
            startForeground(1, notification, 2);
        } else {
            startForeground(1, notification);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyNow() {
        if (this.client == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 33 && ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") != 0) {
            return;
        }
        try {
            NotificationManagerCompat.from(this).notify(1, buildNotification());
        } catch (SecurityException e) {
        }
    }

    private final PendingIntent action(String name) {
        PendingIntent service = PendingIntent.getService(this, name.hashCode(), new Intent(this, (Class<?>) PlayerService.class).setAction(name), 201326592);
        Intrinsics.checkNotNullExpressionValue(service, "getService(...)");
        return service;
    }

    private final PendingIntent openApp() {
        Intent launch = getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (launch == null) {
            launch = new Intent(this, (Class<?>) ConnectActivity.class);
        }
        launch.addFlags(270532608);
        PendingIntent activity = PendingIntent.getActivity(this, 0, launch, 201326592);
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
        return activity;
    }

    private final void holdLocks() {
        WifiManager.WifiLock $this$holdLocks_u24lambda_u2411;
        if (this.wakeLock == null) {
            Object systemService = getSystemService("power");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
            PowerManager power = (PowerManager) systemService;
            PowerManager.WakeLock $this$holdLocks_u24lambda_u2410 = power.newWakeLock(1, "SonixLink:playback");
            $this$holdLocks_u24lambda_u2410.setReferenceCounted(false);
            $this$holdLocks_u24lambda_u2410.acquire();
            this.wakeLock = $this$holdLocks_u24lambda_u2410;
        }
        if (this.wifiLock == null) {
            PlayerClient playerClient = this.client;
            if ((playerClient == null || playerClient.isBluetooth()) ? false : true) {
                Object systemService2 = getApplicationContext().getSystemService("wifi");
                WifiManager.WifiLock wifiLock = null;
                WifiManager wifi = systemService2 instanceof WifiManager ? (WifiManager) systemService2 : null;
                if (wifi != null && ($this$holdLocks_u24lambda_u2411 = wifi.createWifiLock(3, "SonixLink:playback")) != null) {
                    $this$holdLocks_u24lambda_u2411.setReferenceCounted(false);
                    $this$holdLocks_u24lambda_u2411.acquire();
                    wifiLock = $this$holdLocks_u24lambda_u2411;
                }
                this.wifiLock = wifiLock;
            }
        }
    }

    private final void releaseLocks() {
        PowerManager.WakeLock it = this.wakeLock;
        if (it != null && it.isHeld()) {
            it.release();
        }
        this.wakeLock = null;
        WifiManager.WifiLock it2 = this.wifiLock;
        if (it2 != null && it2.isHeld()) {
            it2.release();
        }
        this.wifiLock = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void lostPlayer() {
        MediaSessionCompat mediaSessionCompat = null;
        this.client = null;
        Job job = this.poller;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        MediaSessionCompat mediaSessionCompat2 = this.session;
        if (mediaSessionCompat2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("session");
        } else {
            mediaSessionCompat = mediaSessionCompat2;
        }
        mediaSessionCompat.setActive(false);
        stopEverything();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disconnect() {
        final PlayerClient current = this.client;
        this.client = null;
        Job job = this.poller;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        if (current != null) {
            new Thread(new Runnable() { // from class: com.mattiadoronzo.sonixlink.PlayerService$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PlayerService.disconnect$lambda$14(current);
                }
            }).start();
        }
        stopEverything();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void disconnect$lambda$14(PlayerClient $current) {
        try {
            $current.bye();
        } catch (Exception e) {
        }
        PlayerClient.INSTANCE.release($current.getHost(), $current.getPort());
    }

    private final void stopEverything() {
        releaseLocks();
        stopForeground(1);
        stopSelf();
    }
}
