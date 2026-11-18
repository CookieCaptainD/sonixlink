package com.mattiadoronzo.sonixlink;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.location.LocationRequestCompat;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.mattiadoronzo.sonixlink.databinding.ActivityNowPlayingBinding;
import com.mattiadoronzo.sonixlink.databinding.VolumePillBinding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: NowPlayingActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 _2\u00020\u0001:\u0001_B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010$\u001a\u00020\u0005H\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0002J8\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\rH\u0002J(\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020)2\u0006\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u001aH\u0002J\u0010\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0014H\u0002J\u0012\u00103\u001a\u0004\u0018\u00010&2\u0006\u00104\u001a\u000205H\u0002J\u0010\u00106\u001a\u00020\r2\u0006\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u00020\r2\u0006\u00107\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020\u001aH\u0002J\b\u0010=\u001a\u00020\u0005H\u0002J\b\u0010>\u001a\u00020\u0005H\u0016J\b\u0010?\u001a\u00020\u0014H\u0002J\u0012\u0010@\u001a\u00020\u00052\b\u0010A\u001a\u0004\u0018\u00010BH\u0014J\b\u0010C\u001a\u00020\u0005H\u0014J\b\u0010D\u001a\u00020\u0005H\u0014J\b\u0010E\u001a\u00020\u0005H\u0014J\u0018\u0010F\u001a\u00020\r2\u0006\u0010G\u001a\u00020H2\u0006\u00107\u001a\u00020:H\u0002J\u000e\u0010I\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010JJ\u001c\u0010K\u001a\u00020\u00052\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020\u00050MH\u0002J\u0018\u0010O\u001a\u00020\u00052\u0006\u0010G\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u0007H\u0002J\u0010\u0010R\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\u0018H\u0002J\u0010\u0010T\u001a\u00020\u00052\u0006\u0010U\u001a\u00020\u0007H\u0002J\u0010\u0010V\u001a\u00020\u00052\u0006\u0010W\u001a\u00020\rH\u0002J\u0010\u0010X\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020ZH\u0002J\b\u0010[\u001a\u00020\u0005H\u0002J\u0010\u0010\\\u001a\u00020\u00052\u0006\u0010U\u001a\u00020\u0007H\u0002J\u0010\u0010]\u001a\u00020\r2\u0006\u0010S\u001a\u00020\u0018H\u0002J\b\u0010^\u001a\u00020\u0005H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\tj\b\u0012\u0004\u0012\u00020\u0007`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000¨\u0006`"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/NowPlayingActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "accentWatch", "Lkotlin/Function0;", "", "artAsked", "", "artMissing", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "artPath", "dismissing", "", "downX", "", "downY", "dragBlocked", "dragging", "seekHoldUntil", "", "seeking", "shownAt", "shownState", "Lcom/mattiadoronzo/sonixlink/PlayerState;", "slop", "", "getSlop", "()I", "slop$delegate", "Lkotlin/Lazy;", "standInPath", "views", "Lcom/mattiadoronzo/sonixlink/databinding/ActivityNowPlayingBinding;", "volume", "Lcom/mattiadoronzo/sonixlink/VolumePill;", "applyAccent", "blur", "Landroid/graphics/Bitmap;", "source", "blurAxis", "", "target", "width", "height", "radius", "horizontal", "boxBlur", "pixels", "clock", "seconds", "decode", "bytes", "", "dispatchKeyEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "dispatchTouchEvent", "Landroid/view/MotionEvent;", "dp", "value", "endDrag", "finish", "livePosition", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onStart", "onStop", "over", "view", "Landroid/view/View;", "refresh", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "send", "action", "Lkotlin/Function1;", "Lcom/mattiadoronzo/sonixlink/PlayerClient;", "setText", "Landroid/widget/TextView;", "text", "show", "state", "showArt", "path", "showFavourite", "starred", "showMode", "mode", "Lcom/mattiadoronzo/sonixlink/PlayMode;", "showProgress", "showStandIn", "shownFavourite", "wireControls", "Companion", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class NowPlayingActivity extends AppCompatActivity {
    private static final int BLUR_PASSES = 3;
    private static final int BLUR_RADIUS = 6;
    private static final int BLUR_SIDE = 128;
    private static final int MAX_SIDE_FALLBACK = 1080;
    private static final long POLL_MS = 1000;
    private static final long TICK_MS = 250;
    private boolean dismissing;
    private float downX;
    private float downY;
    private boolean dragBlocked;
    private boolean dragging;
    private long seekHoldUntil;
    private boolean seeking;
    private long shownAt;
    private ActivityNowPlayingBinding views;
    private VolumePill volume;
    private String artPath = "";
    private String artAsked = "";
    private final HashSet<String> artMissing = new HashSet<>();
    private final Function0<Unit> accentWatch = new Function0<Unit>() { // from class: com.mattiadoronzo.sonixlink.NowPlayingActivity$accentWatch$1
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
            this.this$0.applyAccent();
        }
    };

    /* JADX INFO: renamed from: slop$delegate, reason: from kotlin metadata */
    private final Lazy slop = LazyKt.lazy(new Function0<Integer>() { // from class: com.mattiadoronzo.sonixlink.NowPlayingActivity$slop$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Integer invoke() {
            return Integer.valueOf(ViewConfiguration.get(this.this$0).getScaledTouchSlop());
        }
    });
    private PlayerState shownState = PlayerState.INSTANCE.getEMPTY();
    private String standInPath = "";

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.NowPlayingActivity$refresh$1 */
    /* JADX INFO: compiled from: NowPlayingActivity.kt */
    @Metadata(m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.NowPlayingActivity", m164f = "NowPlayingActivity.kt", m165i = {0}, m166l = {303}, m167m = "refresh", m168n = {"this"}, m169s = {"L$0"})
    static final class C09791 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09791(Continuation<? super C09791> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NowPlayingActivity.this.refresh(this);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityNowPlayingBinding activityNowPlayingBindingInflate = ActivityNowPlayingBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityNowPlayingBindingInflate, "inflate(...)");
        this.views = activityNowPlayingBindingInflate;
        ActivityNowPlayingBinding activityNowPlayingBinding = this.views;
        if (activityNowPlayingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityNowPlayingBinding = null;
        }
        setContentView(activityNowPlayingBinding.getRoot());
        ActivityNowPlayingBinding activityNowPlayingBinding2 = this.views;
        if (activityNowPlayingBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityNowPlayingBinding2 = null;
        }
        VolumePillBinding volume = activityNowPlayingBinding2.volume;
        Intrinsics.checkNotNullExpressionValue(volume, "volume");
        this.volume = new VolumePill(volume, new Function1<Integer, Unit>() { // from class: com.mattiadoronzo.sonixlink.NowPlayingActivity.onCreate.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(final int level) {
                NowPlayingActivity.this.send(new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.NowPlayingActivity.onCreate.1.1
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
                        it.setVolume(level);
                    }
                });
            }
        });
        if (Session.INSTANCE.getClient() == null) {
            finish();
            return;
        }
        ActivityNowPlayingBinding activityNowPlayingBinding3 = this.views;
        if (activityNowPlayingBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityNowPlayingBinding3 = null;
        }
        activityNowPlayingBinding3.trackTitle.setSelected(true);
        ActivityNowPlayingBinding activityNowPlayingBinding4 = this.views;
        if (activityNowPlayingBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityNowPlayingBinding4 = null;
        }
        activityNowPlayingBinding4.trackArtist.setSelected(true);
        applyAccent();
        wireControls();
        if (Session.INSTANCE.getState().getHasTrack()) {
            show(Session.INSTANCE.getState());
            showArt(Session.INSTANCE.getState().getPath());
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C09772(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C09783(null), 3, null);
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.NowPlayingActivity$onCreate$2 */
    /* JADX INFO: compiled from: NowPlayingActivity.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.NowPlayingActivity$onCreate$2", m164f = "NowPlayingActivity.kt", m165i = {}, m166l = {94}, m167m = "invokeSuspend", m168n = {}, m169s = {})
    static final class C09772 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09772(Continuation<? super C09772> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NowPlayingActivity.this.new C09772(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09772) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.NowPlayingActivity$onCreate$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: NowPlayingActivity.kt */
        @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.NowPlayingActivity$onCreate$2$1", m164f = "NowPlayingActivity.kt", m165i = {0, 1}, m166l = {QueueActivity.ROOM_KEPT_DP, 97}, m167m = "invokeSuspend", m168n = {"$this$repeatOnLifecycle", "$this$repeatOnLifecycle"}, m169s = {"L$0", "L$0"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ NowPlayingActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(NowPlayingActivity nowPlayingActivity, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = nowPlayingActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:11:0x0031  */
            /* JADX WARN: Code duplicated, block: B:13:0x0041 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:16:0x0052 A[RETURN] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0050 -> B:9:0x002b). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                /*
                    r6 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r6.label
                    switch(r1) {
                        case 0: goto L23;
                        case 1: goto L1a;
                        case 2: goto L11;
                        default: goto L9;
                    }
                L9:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r0)
                    throw r7
                L11:
                    r1 = r6
                    java.lang.Object r2 = r1.L$0
                    kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
                    kotlin.ResultKt.throwOnFailure(r7)
                    goto L53
                L1a:
                    r1 = r6
                    java.lang.Object r2 = r1.L$0
                    kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
                    kotlin.ResultKt.throwOnFailure(r7)
                    goto L42
                L23:
                    kotlin.ResultKt.throwOnFailure(r7)
                    r1 = r6
                    java.lang.Object r2 = r1.L$0
                    kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
                L2b:
                    boolean r3 = kotlinx.coroutines.CoroutineScopeKt.isActive(r2)
                    if (r3 == 0) goto L54
                    com.mattiadoronzo.sonixlink.NowPlayingActivity r3 = r1.this$0
                    r4 = r1
                    kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                    r1.L$0 = r2
                    r5 = 1
                    r1.label = r5
                    java.lang.Object r3 = com.mattiadoronzo.sonixlink.NowPlayingActivity.access$refresh(r3, r4)
                    if (r3 != r0) goto L42
                    return r0
                L42:
                    r3 = r1
                    kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                    r1.L$0 = r2
                    r4 = 2
                    r1.label = r4
                    r4 = 1000(0x3e8, double:4.94E-321)
                    java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay(r4, r3)
                    if (r3 != r0) goto L53
                    return r0
                L53:
                    goto L2b
                L54:
                    kotlin.Unit r0 = kotlin.Unit.INSTANCE
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mattiadoronzo.sonixlink.NowPlayingActivity.C09772.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (RepeatOnLifecycleKt.repeatOnLifecycle(NowPlayingActivity.this, Lifecycle.State.STARTED, new AnonymousClass1(NowPlayingActivity.this, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.NowPlayingActivity$onCreate$3 */
    /* JADX INFO: compiled from: NowPlayingActivity.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.NowPlayingActivity$onCreate$3", m164f = "NowPlayingActivity.kt", m165i = {}, m166l = {LocationRequestCompat.QUALITY_LOW_POWER}, m167m = "invokeSuspend", m168n = {}, m169s = {})
    static final class C09783 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09783(Continuation<? super C09783> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NowPlayingActivity.this.new C09783(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09783) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.NowPlayingActivity$onCreate$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: NowPlayingActivity.kt */
        @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.NowPlayingActivity$onCreate$3$1", m164f = "NowPlayingActivity.kt", m165i = {0}, m166l = {107}, m167m = "invokeSuspend", m168n = {"$this$repeatOnLifecycle"}, m169s = {"L$0"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ NowPlayingActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(NowPlayingActivity nowPlayingActivity, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = nowPlayingActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                AnonymousClass1 anonymousClass1;
                CoroutineScope $this$repeatOnLifecycle;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        anonymousClass1 = this;
                        $this$repeatOnLifecycle = (CoroutineScope) anonymousClass1.L$0;
                        break;
                    case 1:
                        anonymousClass1 = this;
                        $this$repeatOnLifecycle = (CoroutineScope) anonymousClass1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                while (CoroutineScopeKt.isActive($this$repeatOnLifecycle)) {
                    anonymousClass1.this$0.showProgress();
                    anonymousClass1.L$0 = $this$repeatOnLifecycle;
                    anonymousClass1.label = 1;
                    if (DelayKt.delay(NowPlayingActivity.TICK_MS, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (RepeatOnLifecycleKt.repeatOnLifecycle(NowPlayingActivity.this, Lifecycle.State.STARTED, new AnonymousClass1(NowPlayingActivity.this, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (this.dismissing) {
            overridePendingTransition(0, 0);
        } else {
            overridePendingTransition(C1020R.anim.stay, C1020R.anim.slide_down);
        }
    }

    private final int getSlop() {
        return ((Number) this.slop.getValue()).intValue();
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00b3  */
    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent event) {
        boolean z;
        Intrinsics.checkNotNullParameter(event, "event");
        ActivityNowPlayingBinding activityNowPlayingBinding = null;
        switch (event.getActionMasked()) {
            case 0:
                this.downX = event.getRawX();
                this.downY = event.getRawY();
                this.dragging = false;
                if (!this.dismissing) {
                    VolumePill volumePill = this.volume;
                    if (volumePill == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("volume");
                        volumePill = null;
                    }
                    if (!volumePill.getShowing()) {
                        ActivityNowPlayingBinding activityNowPlayingBinding2 = this.views;
                        if (activityNowPlayingBinding2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("views");
                        } else {
                            activityNowPlayingBinding = activityNowPlayingBinding2;
                        }
                        SeekBar progressSeek = activityNowPlayingBinding.progressSeek;
                        Intrinsics.checkNotNullExpressionValue(progressSeek, "progressSeek");
                        z = over(progressSeek, event);
                    }
                }
                this.dragBlocked = z;
                break;
            case 1:
            case 3:
                if (this.dragging) {
                    this.dragging = false;
                    endDrag();
                    return true;
                }
                break;
            case 2:
                if (!this.dragging && !this.dragBlocked) {
                    float down = event.getRawY() - this.downY;
                    if (down > getSlop() && down > Math.abs(event.getRawX() - this.downX)) {
                        this.dragging = true;
                        MotionEvent cancel = MotionEvent.obtain(event);
                        cancel.setAction(3);
                        super.dispatchTouchEvent(cancel);
                        cancel.recycle();
                    }
                }
                if (this.dragging) {
                    ActivityNowPlayingBinding activityNowPlayingBinding3 = this.views;
                    if (activityNowPlayingBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("views");
                    } else {
                        activityNowPlayingBinding = activityNowPlayingBinding3;
                    }
                    activityNowPlayingBinding.sheet.setTranslationY(RangesKt.coerceAtLeast((event.getRawY() - this.downY) - getSlop(), 0.0f));
                    return true;
                }
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    private final boolean over(View view, MotionEvent event) {
        int[] at = new int[2];
        view.getLocationOnScreen(at);
        return event.getRawX() >= ((float) at[0]) && event.getRawX() <= ((float) (at[0] + view.getWidth())) && event.getRawY() >= ((float) at[1]) && event.getRawY() <= ((float) (at[1] + view.getHeight()));
    }

    private final void endDrag() {
        ActivityNowPlayingBinding activityNowPlayingBinding = this.views;
        if (activityNowPlayingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityNowPlayingBinding = null;
        }
        FrameLayout sheet = activityNowPlayingBinding.sheet;
        Intrinsics.checkNotNullExpressionValue(sheet, "sheet");
        if (sheet.getTranslationY() < sheet.getHeight() / 5.0f) {
            sheet.animate().translationY(0.0f).setDuration(160L).start();
        } else {
            this.dismissing = true;
            sheet.animate().translationY(sheet.getHeight()).setDuration(160L).withEndAction(new Runnable() { // from class: com.mattiadoronzo.sonixlink.NowPlayingActivity$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    NowPlayingActivity.endDrag$lambda$0(this.f$0);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void endDrag$lambda$0(NowPlayingActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        Session.INSTANCE.watchAccent(this.accentWatch);
        this.accentWatch.invoke();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        Session.INSTANCE.unwatchAccent(this.accentWatch);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        VolumePill volumePill = this.volume;
        if (volumePill == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volume");
            volumePill = null;
        }
        volumePill.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyAccent() {
        int accent = Session.INSTANCE.getAccent();
        Accent accent2 = Accent.INSTANCE;
        ActivityNowPlayingBinding activityNowPlayingBinding = this.views;
        ActivityNowPlayingBinding activityNowPlayingBinding2 = null;
        if (activityNowPlayingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityNowPlayingBinding = null;
        }
        ImageButton playButton = activityNowPlayingBinding.playButton;
        Intrinsics.checkNotNullExpressionValue(playButton, "playButton");
        accent2.circleButton(playButton, 64);
        ActivityNowPlayingBinding activityNowPlayingBinding3 = this.views;
        if (activityNowPlayingBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityNowPlayingBinding3 = null;
        }
        activityNowPlayingBinding3.progressSeek.setProgressTintList(ColorStateList.valueOf(accent));
        VolumePill volumePill = this.volume;
        if (volumePill == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volume");
            volumePill = null;
        }
        volumePill.accent();
        GradientDrawable $this$applyAccent_u24lambda_u241 = new GradientDrawable();
        $this$applyAccent_u24lambda_u241.setShape(1);
        $this$applyAccent_u24lambda_u241.setColor(accent);
        $this$applyAccent_u24lambda_u241.setStroke(m144dp(2), -1);
        $this$applyAccent_u24lambda_u241.setSize(m144dp(18), m144dp(18));
        ActivityNowPlayingBinding activityNowPlayingBinding4 = this.views;
        if (activityNowPlayingBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityNowPlayingBinding4 = null;
        }
        activityNowPlayingBinding4.progressSeek.setThumb($this$applyAccent_u24lambda_u241);
        ActivityNowPlayingBinding activityNowPlayingBinding5 = this.views;
        if (activityNowPlayingBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
        } else {
            activityNowPlayingBinding2 = activityNowPlayingBinding5;
        }
        activityNowPlayingBinding2.progressSeek.setThumbOffset(m144dp(9));
    }

    /* JADX INFO: renamed from: dp */
    private final int m144dp(int value) {
        return (int) (value * getResources().getDisplayMetrics().density);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        VolumePill volumePill = this.volume;
        if (volumePill == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volume");
            volumePill = null;
        }
        return volumePill.onKey(event) || super.dispatchKeyEvent(event);
    }

    private final void wireControls() {
        ActivityNowPlayingBinding activityNowPlayingBinding = this.views;
        ActivityNowPlayingBinding activityNowPlayingBinding2 = null;
        if (activityNowPlayingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityNowPlayingBinding = null;
        }
        activityNowPlayingBinding.playButton.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.NowPlayingActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NowPlayingActivity.wireControls$lambda$2(this.f$0, view);
            }
        });
        ActivityNowPlayingBinding activityNowPlayingBinding3 = this.views;
        if (activityNowPlayingBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityNowPlayingBinding3 = null;
        }
        activityNowPlayingBinding3.prevButton.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.NowPlayingActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NowPlayingActivity.wireControls$lambda$3(this.f$0, view);
            }
        });
        ActivityNowPlayingBinding activityNowPlayingBinding4 = this.views;
        if (activityNowPlayingBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityNowPlayingBinding4 = null;
        }
        activityNowPlayingBinding4.nextButton.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.NowPlayingActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NowPlayingActivity.wireControls$lambda$4(this.f$0, view);
            }
        });
        ActivityNowPlayingBinding activityNowPlayingBinding5 = this.views;
        if (activityNowPlayingBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityNowPlayingBinding5 = null;
        }
        activityNowPlayingBinding5.modeButton.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.NowPlayingActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NowPlayingActivity.wireControls$lambda$5(this.f$0, view);
            }
        });
        ActivityNowPlayingBinding activityNowPlayingBinding6 = this.views;
        if (activityNowPlayingBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityNowPlayingBinding6 = null;
        }
        activityNowPlayingBinding6.favouriteButton.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.NowPlayingActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NowPlayingActivity.wireControls$lambda$6(this.f$0, view);
            }
        });
        ActivityNowPlayingBinding activityNowPlayingBinding7 = this.views;
        if (activityNowPlayingBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityNowPlayingBinding7 = null;
        }
        activityNowPlayingBinding7.queueButton.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.NowPlayingActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NowPlayingActivity.wireControls$lambda$7(this.f$0, view);
            }
        });
        ActivityNowPlayingBinding activityNowPlayingBinding8 = this.views;
        if (activityNowPlayingBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
        } else {
            activityNowPlayingBinding2 = activityNowPlayingBinding8;
        }
        activityNowPlayingBinding2.progressSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.mattiadoronzo.sonixlink.NowPlayingActivity.wireControls.7
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar bar, int value, boolean fromUser) {
                int duration;
                Intrinsics.checkNotNullParameter(bar, "bar");
                if (fromUser && (duration = Session.INSTANCE.getState().getDuration()) > 0) {
                    ActivityNowPlayingBinding activityNowPlayingBinding9 = NowPlayingActivity.this.views;
                    if (activityNowPlayingBinding9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("views");
                        activityNowPlayingBinding9 = null;
                    }
                    activityNowPlayingBinding9.elapsed.setText(NowPlayingActivity.this.clock((((long) value) * ((long) duration)) / ((long) 1000)));
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar bar) {
                Intrinsics.checkNotNullParameter(bar, "bar");
                NowPlayingActivity.this.seeking = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar bar) {
                Intrinsics.checkNotNullParameter(bar, "bar");
                NowPlayingActivity.this.seeking = false;
                int duration = Session.INSTANCE.getState().getDuration();
                if (duration <= 0) {
                    return;
                }
                final int seconds = (int) ((((long) bar.getProgress()) * ((long) duration)) / ((long) 1000));
                NowPlayingActivity.this.seekHoldUntil = SystemClock.uptimeMillis() + ((long) 1200);
                NowPlayingActivity.this.send(new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.NowPlayingActivity$wireControls$7$onStopTrackingTouch$1
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
                        it.seek(seconds);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wireControls$lambda$2(NowPlayingActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.send(new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.NowPlayingActivity$wireControls$1$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PlayerClient playerClient) {
                invoke2(playerClient);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PlayerClient it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                it2.toggle();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wireControls$lambda$3(NowPlayingActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.send(new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.NowPlayingActivity$wireControls$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PlayerClient playerClient) {
                invoke2(playerClient);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PlayerClient it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                it2.previous();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wireControls$lambda$4(NowPlayingActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.send(new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.NowPlayingActivity$wireControls$3$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PlayerClient playerClient) {
                invoke2(playerClient);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PlayerClient it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                it2.next();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wireControls$lambda$5(NowPlayingActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final PlayMode next = Session.INSTANCE.getHeldMode().resolve(Session.INSTANCE.getState().getMode()).next();
        Session.INSTANCE.getHeldMode().set(next);
        this$0.showMode(next);
        this$0.send(new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.NowPlayingActivity$wireControls$4$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PlayerClient playerClient) {
                invoke2(playerClient);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PlayerClient it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                it2.setMode(next);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wireControls$lambda$6(NowPlayingActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final String path = Session.INSTANCE.getState().getPath();
        if (path.length() == 0) {
            return;
        }
        final boolean starred = !this$0.shownFavourite(Session.INSTANCE.getState());
        Session.INSTANCE.getHeldFavourite().set(TuplesKt.m155to(path, Boolean.valueOf(starred)));
        this$0.showFavourite(starred);
        this$0.send(new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.NowPlayingActivity$wireControls$5$1
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
            public final void invoke2(PlayerClient it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                it2.setFavourite(path, Boolean.valueOf(starred));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wireControls$lambda$7(NowPlayingActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) QueueActivity.class));
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.NowPlayingActivity$send$1 */
    /* JADX INFO: compiled from: NowPlayingActivity.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.NowPlayingActivity$send$1", m164f = "NowPlayingActivity.kt", m165i = {}, m166l = {290, 297}, m167m = "invokeSuspend", m168n = {}, m169s = {})
    static final class C09811 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<PlayerClient, Unit> $action;
        final /* synthetic */ PlayerClient $client;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09811(Function1<? super PlayerClient, Unit> function1, PlayerClient playerClient, Continuation<? super C09811> continuation) {
            super(2, continuation);
            this.$action = function1;
            this.$client = playerClient;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NowPlayingActivity.this.new C09811(this.$action, this.$client, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09811) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.NowPlayingActivity$send$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: NowPlayingActivity.kt */
        @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.NowPlayingActivity$send$1$1", m164f = "NowPlayingActivity.kt", m165i = {}, m166l = {}, m167m = "invokeSuspend", m168n = {}, m169s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<PlayerClient, Unit> $action;
            final /* synthetic */ PlayerClient $client;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(Function1<? super PlayerClient, Unit> function1, PlayerClient playerClient, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$action = function1;
                this.$client = playerClient;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$action, this.$client, continuation);
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
                            this.$action.invoke(this.$client);
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
            C09811 c09811;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c09811 = this;
                    c09811.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1(c09811.$action, c09811.$client, null), c09811) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c09811.label = 2;
                    if (NowPlayingActivity.this.refresh(c09811) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 1:
                    c09811 = this;
                    ResultKt.throwOnFailure($result);
                    c09811.label = 2;
                    if (NowPlayingActivity.this.refresh(c09811) == coroutine_suspended) {
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
        PlayerClient client = Session.INSTANCE.getClient();
        if (client == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C09811(action, client, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object refresh(Continuation<? super Unit> continuation) throws Throwable {
        C09791 c09791;
        Object objWithContext;
        NowPlayingActivity nowPlayingActivity;
        int color;
        if (continuation instanceof C09791) {
            c09791 = (C09791) continuation;
            if ((c09791.label & Integer.MIN_VALUE) != 0) {
                c09791.label -= Integer.MIN_VALUE;
            } else {
                c09791 = new C09791(continuation);
            }
        } else {
            c09791 = new C09791(continuation);
        }
        C09791 c09792 = c09791;
        Object $result = c09792.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c09792.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PlayerClient client = Session.INSTANCE.getClient();
                if (client == null) {
                    return Unit.INSTANCE;
                }
                CoroutineDispatcher io = Dispatchers.getIO();
                NowPlayingActivity$refresh$state$1 nowPlayingActivity$refresh$state$1 = new NowPlayingActivity$refresh$state$1(client, null);
                c09792.L$0 = this;
                c09792.label = 1;
                objWithContext = BuildersKt.withContext(io, nowPlayingActivity$refresh$state$1, c09792);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                nowPlayingActivity = this;
                break;
            case 1:
                nowPlayingActivity = (NowPlayingActivity) c09792.L$0;
                ResultKt.throwOnFailure($result);
                objWithContext = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        PlayerState state = (PlayerState) objWithContext;
        if (state != null) {
            Session.INSTANCE.setState(state);
            if ((state.getAccent().length() > 0) && (color = Session.INSTANCE.parseAccent(state.getAccent())) != Session.INSTANCE.getAccent()) {
                Session.INSTANCE.setAccent(color);
                String text = state.getAccent();
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(nowPlayingActivity), Dispatchers.getIO(), null, nowPlayingActivity.new C09802(text, null), 2, null);
            }
            nowPlayingActivity.show(state);
            nowPlayingActivity.showArt(state.getPath());
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.NowPlayingActivity$refresh$2 */
    /* JADX INFO: compiled from: NowPlayingActivity.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.NowPlayingActivity$refresh$2", m164f = "NowPlayingActivity.kt", m165i = {}, m166l = {}, m167m = "invokeSuspend", m168n = {}, m169s = {})
    static final class C09802 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $text;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09802(String str, Continuation<? super C09802> continuation) {
            super(2, continuation);
            this.$text = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NowPlayingActivity.this.new C09802(this.$text, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09802) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    Settings.INSTANCE.rememberAccent(NowPlayingActivity.this, this.$text);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final boolean shownFavourite(PlayerState state) {
        Pair<String, Boolean> pairResolve = Session.INSTANCE.getHeldFavourite().resolve(TuplesKt.m155to(state.getPath(), Boolean.valueOf(state.getFavourite())));
        String path = pairResolve.component1();
        boolean starred = pairResolve.component2().booleanValue();
        return Intrinsics.areEqual(path, state.getPath()) ? starred : state.getFavourite();
    }

    private final long livePosition() {
        PlayerState state = this.shownState;
        long seconds = state.getPosition();
        if (state.isPlaying() && this.shownAt > 0) {
            seconds += (SystemClock.uptimeMillis() - this.shownAt) / ((long) 1000);
        }
        return state.getDuration() > 0 ? RangesKt.coerceAtMost(seconds, state.getDuration()) : seconds;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showProgress() {
        if (this.seeking || SystemClock.uptimeMillis() < this.seekHoldUntil) {
            return;
        }
        PlayerState state = this.shownState;
        long position = livePosition();
        ActivityNowPlayingBinding activityNowPlayingBinding = this.views;
        ActivityNowPlayingBinding activityNowPlayingBinding2 = null;
        if (activityNowPlayingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityNowPlayingBinding = null;
        }
        activityNowPlayingBinding.progressSeek.setProgress(state.getDuration() > 0 ? RangesKt.coerceIn((int) ((((long) 1000) * position) / ((long) state.getDuration())), 0, 1000) : 0);
        ActivityNowPlayingBinding activityNowPlayingBinding3 = this.views;
        if (activityNowPlayingBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
        } else {
            activityNowPlayingBinding2 = activityNowPlayingBinding3;
        }
        activityNowPlayingBinding2.elapsed.setText(clock(position));
    }

    private final void show(PlayerState state) {
        String string;
        this.shownState = state;
        this.shownAt = SystemClock.uptimeMillis();
        ActivityNowPlayingBinding activityNowPlayingBinding = this.views;
        ActivityNowPlayingBinding activityNowPlayingBinding2 = null;
        if (activityNowPlayingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityNowPlayingBinding = null;
        }
        TextView trackTitle = activityNowPlayingBinding.trackTitle;
        Intrinsics.checkNotNullExpressionValue(trackTitle, "trackTitle");
        String title = state.getTitle();
        if (title.length() == 0) {
            title = StringsKt.substringAfterLast$default(state.getPath(), '/', (String) null, 2, (Object) null);
        }
        setText(trackTitle, title);
        ActivityNowPlayingBinding activityNowPlayingBinding3 = this.views;
        if (activityNowPlayingBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityNowPlayingBinding3 = null;
        }
        TextView trackArtist = activityNowPlayingBinding3.trackArtist;
        Intrinsics.checkNotNullExpressionValue(trackArtist, "trackArtist");
        Iterable $this$filter$iv = CollectionsKt.listOf((Object[]) new String[]{state.getArtist(), state.getAlbum()});
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            String it = (String) element$iv$iv;
            if (it.length() > 0) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        setText(trackArtist, CollectionsKt.joinToString$default((List) destination$iv$iv, " — ", null, null, 0, null, null, 62, null));
        ActivityNowPlayingBinding activityNowPlayingBinding4 = this.views;
        if (activityNowPlayingBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityNowPlayingBinding4 = null;
        }
        activityNowPlayingBinding4.playButton.setImageResource(state.isPlaying() ? C1020R.drawable.ic_pause : C1020R.drawable.ic_play);
        showMode(Session.INSTANCE.getHeldMode().resolve(state.getMode()));
        showFavourite(shownFavourite(state));
        showProgress();
        ActivityNowPlayingBinding activityNowPlayingBinding5 = this.views;
        if (activityNowPlayingBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityNowPlayingBinding5 = null;
        }
        activityNowPlayingBinding5.total.setText(clock(state.getDuration()));
        VolumePill volumePill = this.volume;
        if (volumePill == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volume");
            volumePill = null;
        }
        volumePill.follow(state.getVolume());
        ActivityNowPlayingBinding activityNowPlayingBinding6 = this.views;
        if (activityNowPlayingBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
        } else {
            activityNowPlayingBinding2 = activityNowPlayingBinding6;
        }
        TextView textView = activityNowPlayingBinding2.queuePosition;
        if (state.getDisplayCount() > 0 && state.getDisplayPosition() > 0) {
            string = getString(C1020R.string.queue_position, new Object[]{Integer.valueOf(state.getDisplayPosition()), Integer.valueOf(state.getDisplayCount())});
        } else {
            string = (state.getDisplayCount() != 0 && state.getQueuePosition() >= 0 && state.getQueueCount() > 0) ? getString(C1020R.string.queue_position, new Object[]{Integer.valueOf(state.getQueuePosition() + 1), Integer.valueOf(state.getQueueCount())}) : "";
        }
        textView.setText(string);
    }

    private final void setText(TextView view, String text) {
        CharSequence text2 = view.getText();
        if (!Intrinsics.areEqual(text2 != null ? text2.toString() : null, text)) {
            view.setText(text);
        }
    }

    private final void showMode(PlayMode mode) {
        ActivityNowPlayingBinding activityNowPlayingBinding = this.views;
        ActivityNowPlayingBinding activityNowPlayingBinding2 = null;
        if (activityNowPlayingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityNowPlayingBinding = null;
        }
        activityNowPlayingBinding.modeButton.setImageResource(mode.getIcon());
        ActivityNowPlayingBinding activityNowPlayingBinding3 = this.views;
        if (activityNowPlayingBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
        } else {
            activityNowPlayingBinding2 = activityNowPlayingBinding3;
        }
        activityNowPlayingBinding2.modeButton.setImageTintList(Accent.INSTANCE.onOff(this, mode != PlayMode.NORMAL));
    }

    private final void showFavourite(boolean starred) {
        ActivityNowPlayingBinding activityNowPlayingBinding = this.views;
        ActivityNowPlayingBinding activityNowPlayingBinding2 = null;
        if (activityNowPlayingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityNowPlayingBinding = null;
        }
        activityNowPlayingBinding.favouriteButton.setImageResource(starred ? C1020R.drawable.ic_favourite_filled : C1020R.drawable.ic_favourite);
        ActivityNowPlayingBinding activityNowPlayingBinding3 = this.views;
        if (activityNowPlayingBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
        } else {
            activityNowPlayingBinding2 = activityNowPlayingBinding3;
        }
        activityNowPlayingBinding2.favouriteButton.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(this, starred ? C1020R.color.favourite : C1020R.color.text_secondary)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String clock(long seconds) {
        if (seconds <= 0) {
            return "0:00";
        }
        long j = 60;
        long minutes = seconds / j;
        if (minutes >= 60) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(Locale.US, "%d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(minutes / j), Long.valueOf(minutes % j), Long.valueOf(seconds % j)}, 3));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String str2 = String.format(Locale.US, "%d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(minutes), Long.valueOf(seconds % j)}, 2));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }

    private final void showStandIn(String path) {
        if (Intrinsics.areEqual(path, this.standInPath)) {
            return;
        }
        this.standInPath = path;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C09831(path, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.NowPlayingActivity$showStandIn$1 */
    /* JADX INFO: compiled from: NowPlayingActivity.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.NowPlayingActivity$showStandIn$1", m164f = "NowPlayingActivity.kt", m165i = {}, m166l = {443}, m167m = "invokeSuspend", m168n = {}, m169s = {})
    static final class C09831 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $path;
        int label;
        final /* synthetic */ NowPlayingActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09831(String str, NowPlayingActivity nowPlayingActivity, Continuation<? super C09831> continuation) {
            super(2, continuation);
            this.$path = str;
            this.this$0 = nowPlayingActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09831(this.$path, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09831) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            C09831 c09831;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ActivityNowPlayingBinding activityNowPlayingBinding = null;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c09831 = this;
                    c09831.label = 1;
                    Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new NowPlayingActivity$showStandIn$1$pair$1(c09831.$path, c09831.this$0, null), c09831);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objWithContext;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    c09831 = this;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Pair pair = (Pair) $result;
            if (!Intrinsics.areEqual(Session.INSTANCE.getState().getPath(), c09831.$path) || Intrinsics.areEqual(c09831.this$0.artPath, c09831.$path) || !Intrinsics.areEqual(c09831.this$0.standInPath, c09831.$path)) {
                return Unit.INSTANCE;
            }
            if (pair != null) {
                ActivityNowPlayingBinding activityNowPlayingBinding2 = c09831.this$0.views;
                if (activityNowPlayingBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("views");
                    activityNowPlayingBinding2 = null;
                }
                activityNowPlayingBinding2.cover.setImageBitmap((Bitmap) pair.getFirst());
                ActivityNowPlayingBinding activityNowPlayingBinding3 = c09831.this$0.views;
                if (activityNowPlayingBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("views");
                    activityNowPlayingBinding3 = null;
                }
                activityNowPlayingBinding3.backdrop.setImageBitmap((Bitmap) pair.getSecond());
                ActivityNowPlayingBinding activityNowPlayingBinding4 = c09831.this$0.views;
                if (activityNowPlayingBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("views");
                } else {
                    activityNowPlayingBinding = activityNowPlayingBinding4;
                }
                activityNowPlayingBinding.coverPlaceholder.setVisibility(8);
            } else {
                ActivityNowPlayingBinding activityNowPlayingBinding5 = c09831.this$0.views;
                if (activityNowPlayingBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("views");
                    activityNowPlayingBinding5 = null;
                }
                activityNowPlayingBinding5.cover.setImageDrawable(null);
                ActivityNowPlayingBinding activityNowPlayingBinding6 = c09831.this$0.views;
                if (activityNowPlayingBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("views");
                    activityNowPlayingBinding6 = null;
                }
                activityNowPlayingBinding6.backdrop.setImageDrawable(null);
                ActivityNowPlayingBinding activityNowPlayingBinding7 = c09831.this$0.views;
                if (activityNowPlayingBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("views");
                } else {
                    activityNowPlayingBinding = activityNowPlayingBinding7;
                }
                activityNowPlayingBinding.coverPlaceholder.setVisibility(0);
            }
            return Unit.INSTANCE;
        }
    }

    private final void showArt(String path) {
        if (Intrinsics.areEqual(path, this.artPath) || Intrinsics.areEqual(path, this.artAsked) || this.artMissing.contains(path)) {
            return;
        }
        this.artAsked = path;
        ActivityNowPlayingBinding activityNowPlayingBinding = null;
        if (path.length() == 0) {
            this.artPath = path;
            ActivityNowPlayingBinding activityNowPlayingBinding2 = this.views;
            if (activityNowPlayingBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("views");
                activityNowPlayingBinding2 = null;
            }
            activityNowPlayingBinding2.cover.setImageDrawable(null);
            ActivityNowPlayingBinding activityNowPlayingBinding3 = this.views;
            if (activityNowPlayingBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("views");
                activityNowPlayingBinding3 = null;
            }
            activityNowPlayingBinding3.backdrop.setImageDrawable(null);
            ActivityNowPlayingBinding activityNowPlayingBinding4 = this.views;
            if (activityNowPlayingBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("views");
            } else {
                activityNowPlayingBinding = activityNowPlayingBinding4;
            }
            activityNowPlayingBinding.coverPlaceholder.setVisibility(0);
            return;
        }
        PlayerClient client = Session.INSTANCE.getClient();
        if (client == null) {
            return;
        }
        showStandIn(path);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C09821(path, client, null), 3, null);
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.NowPlayingActivity$showArt$1 */
    /* JADX INFO: compiled from: NowPlayingActivity.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.NowPlayingActivity$showArt$1", m164f = "NowPlayingActivity.kt", m165i = {0}, m166l = {487}, m167m = "invokeSuspend", m168n = {"failed"}, m169s = {"L$0"})
    static final class C09821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PlayerClient $client;
        final /* synthetic */ String $path;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09821(String str, PlayerClient playerClient, Continuation<? super C09821> continuation) {
            super(2, continuation);
            this.$path = str;
            this.$client = playerClient;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NowPlayingActivity.this.new C09821(this.$path, this.$client, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09821) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            C09821 c09821;
            Ref.BooleanRef failed;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c09821 = this;
                    failed = new Ref.BooleanRef();
                    c09821.L$0 = failed;
                    c09821.label = 1;
                    Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new NowPlayingActivity$showArt$1$pair$1(c09821.$client, c09821.$path, NowPlayingActivity.this, failed, null), c09821);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objWithContext;
                    break;
                case 1:
                    Ref.BooleanRef failed2 = (Ref.BooleanRef) this.L$0;
                    ResultKt.throwOnFailure($result);
                    failed = failed2;
                    c09821 = this;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Pair pair = (Pair) $result;
            NowPlayingActivity.this.artAsked = "";
            if (Intrinsics.areEqual(Session.INSTANCE.getState().getPath(), c09821.$path) && !failed.element) {
                ActivityNowPlayingBinding activityNowPlayingBinding = null;
                if (pair == null) {
                    NowPlayingActivity.this.artMissing.add(c09821.$path);
                    ActivityNowPlayingBinding activityNowPlayingBinding2 = NowPlayingActivity.this.views;
                    if (activityNowPlayingBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("views");
                        activityNowPlayingBinding2 = null;
                    }
                    activityNowPlayingBinding2.cover.setImageDrawable(null);
                    ActivityNowPlayingBinding activityNowPlayingBinding3 = NowPlayingActivity.this.views;
                    if (activityNowPlayingBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("views");
                        activityNowPlayingBinding3 = null;
                    }
                    activityNowPlayingBinding3.backdrop.setImageDrawable(null);
                    ActivityNowPlayingBinding activityNowPlayingBinding4 = NowPlayingActivity.this.views;
                    if (activityNowPlayingBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("views");
                    } else {
                        activityNowPlayingBinding = activityNowPlayingBinding4;
                    }
                    activityNowPlayingBinding.coverPlaceholder.setVisibility(0);
                    return Unit.INSTANCE;
                }
                NowPlayingActivity.this.artPath = c09821.$path;
                ActivityNowPlayingBinding activityNowPlayingBinding5 = NowPlayingActivity.this.views;
                if (activityNowPlayingBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("views");
                    activityNowPlayingBinding5 = null;
                }
                activityNowPlayingBinding5.cover.setImageBitmap((Bitmap) pair.getFirst());
                ActivityNowPlayingBinding activityNowPlayingBinding6 = NowPlayingActivity.this.views;
                if (activityNowPlayingBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("views");
                    activityNowPlayingBinding6 = null;
                }
                activityNowPlayingBinding6.backdrop.setImageBitmap((Bitmap) pair.getSecond());
                ActivityNowPlayingBinding activityNowPlayingBinding7 = NowPlayingActivity.this.views;
                if (activityNowPlayingBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("views");
                } else {
                    activityNowPlayingBinding = activityNowPlayingBinding7;
                }
                activityNowPlayingBinding.coverPlaceholder.setVisibility(8);
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap decode(byte[] bytes) {
        BitmapFactory.Options bounds = new BitmapFactory.Options();
        bounds.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bytes, 0, bytes.length, bounds);
        Integer numValueOf = Integer.valueOf(Math.max(getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels));
        int it = numValueOf.intValue();
        if (!(it > 0)) {
            numValueOf = null;
        }
        int limit = numValueOf != null ? numValueOf.intValue() : 1080;
        int sample = 1;
        int side = Math.max(bounds.outWidth, bounds.outHeight);
        while (side / sample > limit) {
            sample *= 2;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = sample;
        try {
            return BitmapFactory.decodeByteArray(bytes, 0, bytes.length, options);
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap blur(Bitmap source) {
        Bitmap small = Bitmap.createScaledBitmap(source, 128, 128, true).copy(Bitmap.Config.ARGB_8888, true);
        if (small == null) {
            return source;
        }
        int[] pixels = new int[16384];
        small.getPixels(pixels, 0, 128, 0, 0, 128, 128);
        for (int i = 0; i < 3; i++) {
            boxBlur(pixels, 128, 128, 6);
        }
        small.setPixels(pixels, 0, 128, 0, 0, 128, 128);
        return small;
    }

    private final void boxBlur(int[] pixels, int width, int height, int radius) {
        int[] temp = new int[pixels.length];
        blurAxis(pixels, temp, width, height, radius, true);
        blurAxis(temp, pixels, width, height, radius, false);
    }

    private final void blurAxis(int[] source, int[] target, int width, int height, int radius, boolean horizontal) {
        int outer = horizontal ? height : width;
        int inner = horizontal ? width : height;
        for (int o = 0; o < outer; o++) {
            for (int i = 0; i < inner; i++) {
                int r = 0;
                int g = 0;
                int b = 0;
                int n = 0;
                int k = -radius;
                if (k <= radius) {
                    while (true) {
                        int at = i + k;
                        if (at >= 0 && at < inner) {
                            int pixel = horizontal ? source[(o * width) + at] : source[(at * width) + o];
                            r += (pixel >> 16) & 255;
                            g += (pixel >> 8) & 255;
                            b += pixel & 255;
                            n++;
                        }
                        if (k == radius) {
                            break;
                        } else {
                            k++;
                        }
                    }
                }
                int value = ((r / n) << 16) | ViewCompat.MEASURED_STATE_MASK | ((g / n) << 8) | (b / n);
                if (horizontal) {
                    target[(o * width) + i] = value;
                } else {
                    target[(i * width) + o] = value;
                }
            }
        }
    }
}
