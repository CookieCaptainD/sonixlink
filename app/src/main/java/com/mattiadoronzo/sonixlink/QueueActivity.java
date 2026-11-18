package com.mattiadoronzo.sonixlink;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.google.android.material.snackbar.Snackbar;
import com.mattiadoronzo.sonixlink.databinding.ActivityQueueBinding;
import com.mattiadoronzo.sonixlink.databinding.VolumePillBinding;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
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
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: QueueActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 d2\u00020\u0001:\u0004defgB\u0005¢\u0006\u0002\u0010\u0002J2\u00101\u001a\u00020\u00052\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\b\b\u0002\u00104\u001a\u00020\u00102\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u000506H\u0002J\u0017\u00108\u001a\u0004\u0018\u00010\u001a2\u0006\u00109\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010:J\u0010\u0010;\u001a\u0002032\u0006\u00109\u001a\u00020\u001aH\u0002J\u0010\u0010<\u001a\u00020\u00102\u0006\u0010=\u001a\u00020>H\u0016J\u0010\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\tH\u0002J\b\u0010A\u001a\u00020\u0005H\u0002J\u0010\u0010B\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\tH\u0002J\b\u0010D\u001a\u00020\u0005H\u0002J\u0010\u0010E\u001a\u00020\u001c2\u0006\u0010F\u001a\u000203H\u0002J\u0010\u0010G\u001a\u00020\u00102\u0006\u00109\u001a\u00020\tH\u0002J\u0010\u0010H\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\tH\u0002J\b\u0010J\u001a\u00020\u0005H\u0002J\u0016\u0010K\u001a\u00020\u00102\u0006\u0010L\u001a\u000207H\u0082@¢\u0006\u0002\u0010MJ\u0012\u0010N\u001a\u00020\u00052\b\u0010O\u001a\u0004\u0018\u00010PH\u0014J\b\u0010Q\u001a\u00020\u0005H\u0014J\u0018\u0010R\u001a\u00020\u00052\u0006\u00109\u001a\u00020\t2\u0006\u0010S\u001a\u00020\u001cH\u0002J\u0018\u0010T\u001a\u00020\u00052\u0006\u00109\u001a\u00020\t2\u0006\u0010S\u001a\u00020\u001cH\u0002J\b\u0010U\u001a\u00020\u0005H\u0014J\b\u0010V\u001a\u00020\u0005H\u0014J\b\u0010W\u001a\u00020\u0005H\u0002J\b\u0010X\u001a\u00020\tH\u0002J\u0010\u0010Y\u001a\u00020\t2\u0006\u00109\u001a\u00020\tH\u0002J\u000e\u0010Z\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010[J\b\u0010\\\u001a\u00020\u0005H\u0002J\u0010\u0010]\u001a\u00020\u00052\u0006\u0010^\u001a\u00020\tH\u0002J\u0010\u0010_\u001a\u00020\u00052\u0006\u0010`\u001a\u00020#H\u0002J\u0010\u0010a\u001a\u00020\u00052\u0006\u0010b\u001a\u00020\u0010H\u0002J\b\u0010c\u001a\u00020\tH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00150\u0017j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0015`\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00060!R\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010'\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001c0\u0017j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001c`\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082.¢\u0006\u0002\n\u0000¨\u0006h"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/QueueActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "accentWatch", "Lkotlin/Function0;", "", "adapter", "Lcom/mattiadoronzo/sonixlink/RowAdapter;", "count", "", "currentAt", "getCurrentAt", "()I", "dragAt", "dragFrom", "dragFromHistory", "", "dragging", "fetching", "history", "", "Lcom/mattiadoronzo/sonixlink/HistoryEntry;", "historyAt", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "historyRevision", "", "historyRows", "Lcom/mattiadoronzo/sonixlink/Row;", "laidCount", "laidPosition", "laidRevision", "manager", "Lcom/mattiadoronzo/sonixlink/QueueActivity$QueueLayoutManager;", "mode", "Lcom/mattiadoronzo/sonixlink/QueueActivity$Mode;", "nowAt", "placed", "position", "queueRows", "queueRowsRevision", "relayoutAfterDrag", "revision", "touch", "Landroidx/recyclerview/widget/ItemTouchHelper;", "views", "Lcom/mattiadoronzo/sonixlink/databinding/ActivityQueueBinding;", "volume", "Lcom/mattiadoronzo/sonixlink/VolumePill;", "act", "done", "", "relayout", "action", "Lkotlin/Function1;", "Lcom/mattiadoronzo/sonixlink/PlayerClient;", "dayKey", "at", "(J)Ljava/lang/Long;", "dayText", "dispatchKeyEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "dp", "value", "dropped", "fetchPage", "from", "fetchVisible", "header", "text", "isUpcoming", "jumpTo", "index", "layOut", "loadHistory", "client", "(Lcom/mattiadoronzo/sonixlink/PlayerClient;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onRowClicked", "row", "onRowLongPressed", "onStart", "onStop", "paintBar", "pulled", "queueIndexAt", "refresh", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeChosen", "sendVolume", "level", "setMode", "next", "settleOnNowPlaying", "animate", "tensionPx", "Companion", "DragCallback", "Mode", "QueueLayoutManager", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class QueueActivity extends AppCompatActivity {

    @Deprecated
    public static final int AHEAD = 40;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final int HISTORY_LIMIT = 200;

    @Deprecated
    public static final long REFRESH_MS = 1000;

    @Deprecated
    public static final int ROOM_KEPT_DP = 96;

    @Deprecated
    public static final int TENSION_DEN = 5;

    @Deprecated
    public static final int TENSION_DP = 56;

    @Deprecated
    public static final int TENSION_NUM = 2;
    private RowAdapter adapter;
    private boolean dragFromHistory;
    private boolean dragging;
    private boolean fetching;
    private QueueLayoutManager manager;
    private boolean placed;
    private boolean relayoutAfterDrag;
    private ItemTouchHelper touch;
    private ActivityQueueBinding views;
    private VolumePill volume;
    private long revision = Long.MIN_VALUE;
    private int count = -1;
    private int position = -1;
    private long laidRevision = Long.MIN_VALUE;
    private int laidCount = -1;
    private int laidPosition = -1;
    private final HashMap<Integer, Row> queueRows = new HashMap<>();
    private long queueRowsRevision = Long.MIN_VALUE;
    private long historyRevision = Long.MIN_VALUE;
    private List<HistoryEntry> history = CollectionsKt.emptyList();
    private List<Row> historyRows = CollectionsKt.emptyList();
    private final HashMap<Integer, HistoryEntry> historyAt = new HashMap<>();
    private int nowAt = -1;
    private Mode mode = Mode.IDLE;
    private int dragFrom = -1;
    private int dragAt = -1;
    private final Function0<Unit> accentWatch = new Function0<Unit>() { // from class: com.mattiadoronzo.sonixlink.QueueActivity$accentWatch$1
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
            VolumePill volumePill = null;
            if (this.this$0.adapter != null) {
                RowAdapter rowAdapter = this.this$0.adapter;
                if (rowAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    rowAdapter = null;
                }
                rowAdapter.repaint();
            }
            if (this.this$0.volume != null) {
                VolumePill volumePill2 = this.this$0.volume;
                if (volumePill2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("volume");
                } else {
                    volumePill = volumePill2;
                }
                volumePill.accent();
            }
            this.this$0.paintBar();
        }
    };

    /* JADX INFO: compiled from: QueueActivity.kt */
    @Metadata(m147d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/QueueActivity$Mode;", "", "(Ljava/lang/String;I)V", "IDLE", "SELECT", "REORDER", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private enum Mode {
        IDLE,
        SELECT,
        REORDER;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<Mode> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: QueueActivity.kt */
    @Metadata(m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Mode.values().length];
            try {
                iArr[Mode.SELECT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Mode.REORDER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Mode.IDLE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.QueueActivity$loadHistory$1 */
    /* JADX INFO: compiled from: QueueActivity.kt */
    @Metadata(m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.QueueActivity", m164f = "QueueActivity.kt", m165i = {0, 1, 1}, m166l = {326, 336}, m167m = "loadHistory", m168n = {"this", "this", "entries"}, m169s = {"L$0", "L$0", "L$1"})
    static final class C10061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10061(Continuation<? super C10061> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QueueActivity.this.loadHistory(null, this);
        }
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.QueueActivity$refresh$1 */
    /* JADX INFO: compiled from: QueueActivity.kt */
    @Metadata(m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.QueueActivity", m164f = "QueueActivity.kt", m165i = {0, 0, 1, 1, 1}, m166l = {282, 299}, m167m = "refresh", m168n = {"this", "client", "this", "state", "relayout"}, m169s = {"L$0", "L$1", "L$0", "L$1", "I$0"})
    static final class C10161 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10161(Continuation<? super C10161> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QueueActivity.this.refresh(this);
        }
    }

    /* JADX INFO: compiled from: QueueActivity.kt */
    @Metadata(m147d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/QueueActivity$Companion;", "", "()V", "AHEAD", "", "HISTORY_LIMIT", "REFRESH_MS", "", "ROOM_KEPT_DP", "TENSION_DEN", "TENSION_DP", "TENSION_NUM", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getCurrentAt() {
        if (this.nowAt < 0) {
            return -1;
        }
        return this.nowAt + 1;
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
        setMode(Mode.IDLE);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityQueueBinding activityQueueBindingInflate = ActivityQueueBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityQueueBindingInflate, "inflate(...)");
        this.views = activityQueueBindingInflate;
        ActivityQueueBinding activityQueueBinding = this.views;
        if (activityQueueBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityQueueBinding = null;
        }
        setContentView(activityQueueBinding.getRoot());
        ActivityQueueBinding activityQueueBinding2 = this.views;
        if (activityQueueBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityQueueBinding2 = null;
        }
        VolumePillBinding volume = activityQueueBinding2.volume;
        Intrinsics.checkNotNullExpressionValue(volume, "volume");
        this.volume = new VolumePill(volume, new Function1<Integer, Unit>() { // from class: com.mattiadoronzo.sonixlink.QueueActivity.onCreate.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int level) {
                QueueActivity.this.sendVolume(level);
            }
        });
        ActivityQueueBinding activityQueueBinding3 = this.views;
        if (activityQueueBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityQueueBinding3 = null;
        }
        setSupportActionBar(activityQueueBinding3.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(getString(C1020R.string.queue_title));
        }
        ActivityQueueBinding activityQueueBinding4 = this.views;
        if (activityQueueBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityQueueBinding4 = null;
        }
        activityQueueBinding4.toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.QueueActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QueueActivity.onCreate$lambda$0(this.f$0, view);
            }
        });
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback() { // from class: com.mattiadoronzo.sonixlink.QueueActivity.onCreate.3
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                if (QueueActivity.this.mode != Mode.IDLE) {
                    QueueActivity.this.setMode(Mode.IDLE);
                } else {
                    QueueActivity.this.finish();
                }
            }
        });
        ActivityQueueBinding activityQueueBinding5 = this.views;
        if (activityQueueBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityQueueBinding5 = null;
        }
        activityQueueBinding5.queueSelect.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.QueueActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QueueActivity.onCreate$lambda$1(this.f$0, view);
            }
        });
        ActivityQueueBinding activityQueueBinding6 = this.views;
        if (activityQueueBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityQueueBinding6 = null;
        }
        activityQueueBinding6.queueReorder.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.QueueActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QueueActivity.onCreate$lambda$2(this.f$0, view);
            }
        });
        ActivityQueueBinding activityQueueBinding7 = this.views;
        if (activityQueueBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityQueueBinding7 = null;
        }
        activityQueueBinding7.queueRemove.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.QueueActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QueueActivity.onCreate$lambda$3(this.f$0, view);
            }
        });
        ActivityQueueBinding activityQueueBinding8 = this.views;
        if (activityQueueBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityQueueBinding8 = null;
        }
        activityQueueBinding8.queueClose.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.QueueActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QueueActivity.onCreate$lambda$4(this.f$0, view);
            }
        });
        this.adapter = new RowAdapter(C1020R.drawable.ic_track, null, new Function2<Integer, Row, Unit>() { // from class: com.mattiadoronzo.sonixlink.QueueActivity.onCreate.8
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Row row) {
                invoke(num.intValue(), row);
                return Unit.INSTANCE;
            }

            public final void invoke(int at, Row row) {
                Intrinsics.checkNotNullParameter(row, "row");
                QueueActivity.this.onRowClicked(at, row);
            }
        }, 2, null);
        RowAdapter rowAdapter = this.adapter;
        if (rowAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            rowAdapter = null;
        }
        rowAdapter.setOnLongPress(new Function2<Integer, Row, Unit>() { // from class: com.mattiadoronzo.sonixlink.QueueActivity.onCreate.9
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Row row) {
                invoke(num.intValue(), row);
                return Unit.INSTANCE;
            }

            public final void invoke(int at, Row row) {
                Intrinsics.checkNotNullParameter(row, "row");
                QueueActivity.this.onRowLongPressed(at, row);
            }
        });
        RowAdapter rowAdapter2 = this.adapter;
        if (rowAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            rowAdapter2 = null;
        }
        rowAdapter2.setOnGripPressed(new Function1<RecyclerView.ViewHolder, Unit>() { // from class: com.mattiadoronzo.sonixlink.QueueActivity.onCreate.10
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RecyclerView.ViewHolder viewHolder) {
                invoke2(viewHolder);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RecyclerView.ViewHolder holder) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                ItemTouchHelper itemTouchHelper = QueueActivity.this.touch;
                if (itemTouchHelper == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("touch");
                    itemTouchHelper = null;
                }
                itemTouchHelper.startDrag(holder);
            }
        });
        this.manager = new QueueLayoutManager();
        ActivityQueueBinding activityQueueBinding9 = this.views;
        if (activityQueueBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityQueueBinding9 = null;
        }
        RecyclerView recyclerView = activityQueueBinding9.list;
        QueueLayoutManager queueLayoutManager = this.manager;
        if (queueLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
            queueLayoutManager = null;
        }
        recyclerView.setLayoutManager(queueLayoutManager);
        ActivityQueueBinding activityQueueBinding10 = this.views;
        if (activityQueueBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityQueueBinding10 = null;
        }
        RecyclerView recyclerView2 = activityQueueBinding10.list;
        RowAdapter rowAdapter3 = this.adapter;
        if (rowAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            rowAdapter3 = null;
        }
        recyclerView2.setAdapter(rowAdapter3);
        ActivityQueueBinding activityQueueBinding11 = this.views;
        if (activityQueueBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityQueueBinding11 = null;
        }
        RecyclerView.ItemAnimator itemAnimator = activityQueueBinding11.list.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        this.touch = new ItemTouchHelper(new DragCallback());
        ItemTouchHelper itemTouchHelper = this.touch;
        if (itemTouchHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("touch");
            itemTouchHelper = null;
        }
        ActivityQueueBinding activityQueueBinding12 = this.views;
        if (activityQueueBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityQueueBinding12 = null;
        }
        itemTouchHelper.attachToRecyclerView(activityQueueBinding12.list);
        ActivityQueueBinding activityQueueBinding13 = this.views;
        if (activityQueueBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityQueueBinding13 = null;
        }
        activityQueueBinding13.list.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener() { // from class: com.mattiadoronzo.sonixlink.QueueActivity.onCreate.11
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // androidx.recyclerview.widget.RecyclerView.SimpleOnItemTouchListener, androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                Intrinsics.checkNotNullParameter(rv, "rv");
                Intrinsics.checkNotNullParameter(e, "e");
                QueueLayoutManager queueLayoutManager2 = null;
                switch (e.getActionMasked()) {
                    case 0:
                        QueueLayoutManager queueLayoutManager3 = QueueActivity.this.manager;
                        if (queueLayoutManager3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("manager");
                            queueLayoutManager3 = null;
                        }
                        queueLayoutManager3.setHeld(true);
                        QueueLayoutManager queueLayoutManager4 = QueueActivity.this.manager;
                        if (queueLayoutManager4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("manager");
                        } else {
                            queueLayoutManager2 = queueLayoutManager4;
                        }
                        queueLayoutManager2.setTense(QueueActivity.this.pulled() == 0);
                        return false;
                    case 1:
                    case 3:
                        QueueLayoutManager queueLayoutManager5 = QueueActivity.this.manager;
                        if (queueLayoutManager5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("manager");
                        } else {
                            queueLayoutManager2 = queueLayoutManager5;
                        }
                        queueLayoutManager2.setHeld(false);
                        return false;
                    case 2:
                    default:
                        return false;
                }
            }
        });
        ActivityQueueBinding activityQueueBinding14 = this.views;
        if (activityQueueBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityQueueBinding14 = null;
        }
        activityQueueBinding14.list.addOnScrollListener(new C101012());
        ActivityQueueBinding activityQueueBinding15 = this.views;
        if (activityQueueBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityQueueBinding15 = null;
        }
        activityQueueBinding15.list.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.mattiadoronzo.sonixlink.QueueActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                QueueActivity.onCreate$lambda$6(this.f$0, view, i, i2, i3, i4, i5, i6, i7, i8);
            }
        });
        paintBar();
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C101114(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(QueueActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mode != Mode.IDLE) {
            this$0.setMode(Mode.IDLE);
        } else {
            this$0.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(QueueActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setMode(Mode.SELECT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(QueueActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setMode(this$0.mode == Mode.REORDER ? Mode.IDLE : Mode.REORDER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(QueueActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.removeChosen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$4(QueueActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setMode(Mode.IDLE);
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.QueueActivity$onCreate$12 */
    /* JADX INFO: compiled from: QueueActivity.kt */
    @Metadata(m147d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, m148d2 = {"com/mattiadoronzo/sonixlink/QueueActivity$onCreate$12", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class C101012 extends RecyclerView.OnScrollListener {
        C101012() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (recyclerView.getScrollState() == 2 && dy < 0) {
                QueueLayoutManager queueLayoutManager = QueueActivity.this.manager;
                QueueLayoutManager queueLayoutManager2 = null;
                if (queueLayoutManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("manager");
                    queueLayoutManager = null;
                }
                if (!queueLayoutManager.getTense()) {
                    QueueLayoutManager queueLayoutManager3 = QueueActivity.this.manager;
                    if (queueLayoutManager3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("manager");
                        queueLayoutManager3 = null;
                    }
                    if (!queueLayoutManager3.getHeld() && QueueActivity.this.pulled() > 0 && (!QueueActivity.this.history.isEmpty())) {
                        QueueLayoutManager queueLayoutManager4 = QueueActivity.this.manager;
                        if (queueLayoutManager4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("manager");
                        } else {
                            queueLayoutManager2 = queueLayoutManager4;
                        }
                        if (queueLayoutManager2.getFlingFromBelow()) {
                            recyclerView.stopScroll();
                            QueueActivity.this.settleOnNowPlaying(false);
                        }
                    }
                }
            }
            QueueActivity.this.fetchVisible();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(final RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            QueueLayoutManager queueLayoutManager = null;
            switch (newState) {
                case 0:
                case 2:
                    int pull = QueueActivity.this.pulled();
                    QueueLayoutManager queueLayoutManager2 = QueueActivity.this.manager;
                    if (queueLayoutManager2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("manager");
                        queueLayoutManager2 = null;
                    }
                    if (queueLayoutManager2.getTense()) {
                        QueueLayoutManager queueLayoutManager3 = QueueActivity.this.manager;
                        if (queueLayoutManager3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("manager");
                            queueLayoutManager3 = null;
                        }
                        if (!queueLayoutManager3.getHeld()) {
                            if (1 <= pull && pull < QueueActivity.this.tensionPx()) {
                                QueueLayoutManager queueLayoutManager4 = QueueActivity.this.manager;
                                if (queueLayoutManager4 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("manager");
                                } else {
                                    queueLayoutManager = queueLayoutManager4;
                                }
                                queueLayoutManager.setTense(false);
                                final QueueActivity queueActivity = QueueActivity.this;
                                recyclerView.post(new Runnable() { // from class: com.mattiadoronzo.sonixlink.QueueActivity$onCreate$12$$ExternalSyntheticLambda0
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        QueueActivity.C101012.onScrollStateChanged$lambda$0(recyclerView, queueActivity);
                                    }
                                });
                            }
                        }
                    }
                    break;
                case 1:
                    QueueLayoutManager queueLayoutManager5 = QueueActivity.this.manager;
                    if (queueLayoutManager5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("manager");
                    } else {
                        queueLayoutManager = queueLayoutManager5;
                    }
                    queueLayoutManager.setFlingFromBelow(QueueActivity.this.pulled() < 0);
                    break;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onScrollStateChanged$lambda$0(RecyclerView recyclerView, QueueActivity this$0) {
            Intrinsics.checkNotNullParameter(recyclerView, "$recyclerView");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            recyclerView.stopScroll();
            this$0.settleOnNowPlaying(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$6(QueueActivity this$0, final View list, int i, int top, int i2, int bottom, int i3, int oldTop, int i4, int oldBottom) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bottom - top != oldBottom - oldTop) {
            final int room = (bottom - top) - this$0.m145dp(96);
            list.post(new Runnable() { // from class: com.mattiadoronzo.sonixlink.QueueActivity$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    QueueActivity.onCreate$lambda$6$lambda$5(list, room);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$6$lambda$5(View $list, int $room) {
        $list.setPadding(0, 0, 0, RangesKt.coerceAtLeast($room, 0));
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.QueueActivity$onCreate$14 */
    /* JADX INFO: compiled from: QueueActivity.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.QueueActivity$onCreate$14", m164f = "QueueActivity.kt", m165i = {}, m166l = {259}, m167m = "invokeSuspend", m168n = {}, m169s = {})
    static final class C101114 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C101114(Continuation<? super C101114> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return QueueActivity.this.new C101114(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C101114) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.QueueActivity$onCreate$14$1, reason: invalid class name */
        /* JADX INFO: compiled from: QueueActivity.kt */
        @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.QueueActivity$onCreate$14$1", m164f = "QueueActivity.kt", m165i = {0, 1}, m166l = {261, 262}, m167m = "invokeSuspend", m168n = {"$this$repeatOnLifecycle", "$this$repeatOnLifecycle"}, m169s = {"L$0", "L$0"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ QueueActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(QueueActivity queueActivity, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = queueActivity;
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
                    com.mattiadoronzo.sonixlink.QueueActivity r3 = r1.this$0
                    r4 = r1
                    kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                    r1.L$0 = r2
                    r5 = 1
                    r1.label = r5
                    java.lang.Object r3 = com.mattiadoronzo.sonixlink.QueueActivity.access$refresh(r3, r4)
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
                throw new UnsupportedOperationException("Method not decompiled: com.mattiadoronzo.sonixlink.QueueActivity.C101114.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (RepeatOnLifecycleKt.repeatOnLifecycle(QueueActivity.this, Lifecycle.State.STARTED, new AnonymousClass1(QueueActivity.this, null), this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:24:0x0081  */
    /* JADX WARN: Code duplicated, block: B:26:0x0085  */
    /* JADX WARN: Code duplicated, block: B:28:0x008b  */
    /* JADX WARN: Code duplicated, block: B:31:0x009a  */
    /* JADX WARN: Code duplicated, block: B:32:0x009e  */
    /* JADX WARN: Code duplicated, block: B:36:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:38:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:40:0x00c6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:44:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:45:0x00db  */
    /* JADX WARN: Code duplicated, block: B:48:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:52:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:54:0x0110  */
    /* JADX WARN: Code duplicated, block: B:56:0x0114  */
    /* JADX WARN: Code duplicated, block: B:57:0x0117  */
    /* JADX WARN: Code duplicated, block: B:61:0x0121  */
    /* JADX WARN: Code duplicated, block: B:63:0x0127 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:66:0x012c  */
    /* JADX WARN: Code duplicated, block: B:67:0x0146  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object refresh(Continuation<? super Unit> continuation) throws Throwable {
        C10161 c10161;
        Object objWithContext;
        QueueActivity queueActivity;
        PlayerClient client;
        PlayerState state;
        int i;
        Object objLoadHistory;
        int i2;
        QueueActivity queueActivity2;
        ActivityQueueBinding activityQueueBinding;
        ActivityQueueBinding activityQueueBinding2;
        ActionBar supportActionBar;
        int i3;
        String string;
        if (continuation instanceof C10161) {
            c10161 = (C10161) continuation;
            if ((c10161.label & Integer.MIN_VALUE) != 0) {
                c10161.label -= Integer.MIN_VALUE;
            } else {
                c10161 = new C10161(continuation);
            }
        } else {
            c10161 = new C10161(continuation);
        }
        C10161 c10162 = c10161;
        Object $result = c10162.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ActivityQueueBinding activityQueueBinding3 = null;
        boolean z = false;
        switch (c10162.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PlayerClient client2 = Session.INSTANCE.getClient();
                if (client2 == null) {
                    finish();
                    return Unit.INSTANCE;
                }
                CoroutineDispatcher io = Dispatchers.getIO();
                QueueActivity$refresh$state$1 queueActivity$refresh$state$1 = new QueueActivity$refresh$state$1(client2, null);
                c10162.L$0 = this;
                c10162.L$1 = client2;
                c10162.label = 1;
                objWithContext = BuildersKt.withContext(io, queueActivity$refresh$state$1, c10162);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                queueActivity = this;
                client = client2;
                state = (PlayerState) objWithContext;
                if (state == null) {
                    if (queueActivity.count < 0) {
                        activityQueueBinding = queueActivity.views;
                        if (activityQueueBinding == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("views");
                            activityQueueBinding = null;
                        }
                        activityQueueBinding.progress.setVisibility(8);
                        activityQueueBinding2 = queueActivity.views;
                        if (activityQueueBinding2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("views");
                        } else {
                            activityQueueBinding3 = activityQueueBinding2;
                        }
                        activityQueueBinding3.emptyText.setVisibility(0);
                    }
                    return Unit.INSTANCE;
                }
                Session.INSTANCE.setState(state);
                i = 0;
                if (state.getHistoryRevision() != queueActivity.historyRevision) {
                    c10162.L$0 = queueActivity;
                    c10162.L$1 = state;
                    c10162.I$0 = 0;
                    c10162.label = 2;
                    objLoadHistory = queueActivity.loadHistory(client, c10162);
                    if (objLoadHistory == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i2 = 0;
                    queueActivity2 = queueActivity;
                    if (((Boolean) objLoadHistory).booleanValue()) {
                        queueActivity2.historyRevision = state.getHistoryRevision();
                        queueActivity = queueActivity2;
                        i = 1;
                    } else {
                        queueActivity = queueActivity2;
                        i = i2;
                    }
                }
                if (state.getQueueRevision() == queueActivity.revision || state.getQueueCount() != queueActivity.count || state.getQueuePosition() != queueActivity.position) {
                    queueActivity.revision = state.getQueueRevision();
                    queueActivity.count = RangesKt.coerceAtLeast(state.getQueueCount(), 0);
                    queueActivity.position = state.getQueuePosition();
                    i = 1;
                }
                if (i != 0) {
                    if (queueActivity.dragging) {
                        queueActivity.relayoutAfterDrag = true;
                    } else {
                        queueActivity.layOut();
                    }
                }
                supportActionBar = queueActivity.getSupportActionBar();
                if (supportActionBar != null) {
                    int i4 = queueActivity.count;
                    i3 = queueActivity.position;
                    if (i3 >= 0 && i3 < i4) {
                        z = true;
                    }
                    if (z) {
                        string = queueActivity.getString(C1020R.string.queue_position, new Object[]{Boxing.boxInt(queueActivity.position + 1), Boxing.boxInt(queueActivity.count)});
                    } else {
                        string = queueActivity.getString(C1020R.string.tracks_count, new Object[]{Boxing.boxInt(queueActivity.count)});
                    }
                    supportActionBar.setSubtitle(string);
                }
                queueActivity.fetchVisible();
                return Unit.INSTANCE;
            case 1:
                client = (PlayerClient) c10162.L$1;
                queueActivity = (QueueActivity) c10162.L$0;
                ResultKt.throwOnFailure($result);
                objWithContext = $result;
                state = (PlayerState) objWithContext;
                if (state == null) {
                    if (queueActivity.count < 0) {
                        activityQueueBinding = queueActivity.views;
                        if (activityQueueBinding == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("views");
                            activityQueueBinding = null;
                        }
                        activityQueueBinding.progress.setVisibility(8);
                        activityQueueBinding2 = queueActivity.views;
                        if (activityQueueBinding2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("views");
                        } else {
                            activityQueueBinding3 = activityQueueBinding2;
                        }
                        activityQueueBinding3.emptyText.setVisibility(0);
                    }
                    return Unit.INSTANCE;
                }
                Session.INSTANCE.setState(state);
                i = 0;
                if (state.getHistoryRevision() != queueActivity.historyRevision) {
                    c10162.L$0 = queueActivity;
                    c10162.L$1 = state;
                    c10162.I$0 = 0;
                    c10162.label = 2;
                    objLoadHistory = queueActivity.loadHistory(client, c10162);
                    if (objLoadHistory == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i2 = 0;
                    queueActivity2 = queueActivity;
                    if (((Boolean) objLoadHistory).booleanValue()) {
                        queueActivity2.historyRevision = state.getHistoryRevision();
                        queueActivity = queueActivity2;
                        i = 1;
                    } else {
                        queueActivity = queueActivity2;
                        i = i2;
                    }
                }
                if (state.getQueueRevision() == queueActivity.revision) {
                    queueActivity.revision = state.getQueueRevision();
                    queueActivity.count = RangesKt.coerceAtLeast(state.getQueueCount(), 0);
                    queueActivity.position = state.getQueuePosition();
                    i = 1;
                } else {
                    queueActivity.revision = state.getQueueRevision();
                    queueActivity.count = RangesKt.coerceAtLeast(state.getQueueCount(), 0);
                    queueActivity.position = state.getQueuePosition();
                    i = 1;
                }
                if (i != 0) {
                    if (queueActivity.dragging) {
                        queueActivity.relayoutAfterDrag = true;
                    } else {
                        queueActivity.layOut();
                    }
                }
                supportActionBar = queueActivity.getSupportActionBar();
                if (supportActionBar != null) {
                    int i5 = queueActivity.count;
                    i3 = queueActivity.position;
                    if (i3 >= 0) {
                        z = true;
                    }
                    if (z) {
                        string = queueActivity.getString(C1020R.string.queue_position, new Object[]{Boxing.boxInt(queueActivity.position + 1), Boxing.boxInt(queueActivity.count)});
                    } else {
                        string = queueActivity.getString(C1020R.string.tracks_count, new Object[]{Boxing.boxInt(queueActivity.count)});
                    }
                    supportActionBar.setSubtitle(string);
                }
                queueActivity.fetchVisible();
                return Unit.INSTANCE;
            case 2:
                i2 = c10162.I$0;
                PlayerState state2 = (PlayerState) c10162.L$1;
                queueActivity2 = (QueueActivity) c10162.L$0;
                ResultKt.throwOnFailure($result);
                state = state2;
                objLoadHistory = $result;
                if (((Boolean) objLoadHistory).booleanValue()) {
                    queueActivity2.historyRevision = state.getHistoryRevision();
                    queueActivity = queueActivity2;
                    i = 1;
                } else {
                    queueActivity = queueActivity2;
                    i = i2;
                }
                if (state.getQueueRevision() == queueActivity.revision) {
                    queueActivity.revision = state.getQueueRevision();
                    queueActivity.count = RangesKt.coerceAtLeast(state.getQueueCount(), 0);
                    queueActivity.position = state.getQueuePosition();
                    i = 1;
                } else {
                    queueActivity.revision = state.getQueueRevision();
                    queueActivity.count = RangesKt.coerceAtLeast(state.getQueueCount(), 0);
                    queueActivity.position = state.getQueuePosition();
                    i = 1;
                }
                if (i != 0) {
                    if (queueActivity.dragging) {
                        queueActivity.relayoutAfterDrag = true;
                    } else {
                        queueActivity.layOut();
                    }
                }
                supportActionBar = queueActivity.getSupportActionBar();
                if (supportActionBar != null) {
                    int i6 = queueActivity.count;
                    i3 = queueActivity.position;
                    if (i3 >= 0) {
                        z = true;
                    }
                    if (z) {
                        string = queueActivity.getString(C1020R.string.queue_position, new Object[]{Boxing.boxInt(queueActivity.position + 1), Boxing.boxInt(queueActivity.count)});
                    } else {
                        string = queueActivity.getString(C1020R.string.tracks_count, new Object[]{Boxing.boxInt(queueActivity.count)});
                    }
                    supportActionBar.setSubtitle(string);
                }
                queueActivity.fetchVisible();
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:19:0x0066  */
    /* JADX WARN: Code duplicated, block: B:21:0x006c  */
    /* JADX WARN: Code duplicated, block: B:23:0x0086 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0087  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object loadHistory(PlayerClient client, Continuation<? super Boolean> continuation) throws Throwable {
        C10061 c10061;
        QueueActivity queueActivity;
        Object objWithContext;
        List<HistoryEntry> list;
        Object objWithContext2;
        QueueActivity queueActivity2;
        if (continuation instanceof C10061) {
            c10061 = (C10061) continuation;
            if ((c10061.label & Integer.MIN_VALUE) != 0) {
                c10061.label -= Integer.MIN_VALUE;
            } else {
                c10061 = new C10061(continuation);
            }
        } else {
            c10061 = new C10061(continuation);
        }
        C10061 c10062 = c10061;
        Object $result = c10062.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c10062.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                queueActivity = this;
                CoroutineDispatcher io = Dispatchers.getIO();
                QueueActivity$loadHistory$entries$1 queueActivity$loadHistory$entries$1 = new QueueActivity$loadHistory$entries$1(client, null);
                c10062.L$0 = queueActivity;
                c10062.label = 1;
                objWithContext = BuildersKt.withContext(io, queueActivity$loadHistory$entries$1, c10062);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list = (List) objWithContext;
                if (list == null) {
                    return Boxing.boxBoolean(false);
                }
                CoroutineDispatcher io2 = Dispatchers.getIO();
                QueueActivity$loadHistory$rows$1 queueActivity$loadHistory$rows$1 = new QueueActivity$loadHistory$rows$1(list, null);
                c10062.L$0 = queueActivity;
                c10062.L$1 = list;
                c10062.label = 2;
                objWithContext2 = BuildersKt.withContext(io2, queueActivity$loadHistory$rows$1, c10062);
                if (objWithContext2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                queueActivity2 = queueActivity;
                queueActivity2.history = list;
                queueActivity2.historyRows = (List) objWithContext2;
                return Boxing.boxBoolean(true);
            case 1:
                QueueActivity queueActivity3 = (QueueActivity) c10062.L$0;
                ResultKt.throwOnFailure($result);
                queueActivity = queueActivity3;
                objWithContext = $result;
                list = (List) objWithContext;
                if (list == null) {
                    return Boxing.boxBoolean(false);
                }
                CoroutineDispatcher io3 = Dispatchers.getIO();
                QueueActivity$loadHistory$rows$1 queueActivity$loadHistory$rows$2 = new QueueActivity$loadHistory$rows$1(list, null);
                c10062.L$0 = queueActivity;
                c10062.L$1 = list;
                c10062.label = 2;
                objWithContext2 = BuildersKt.withContext(io3, queueActivity$loadHistory$rows$2, c10062);
                if (objWithContext2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                queueActivity2 = queueActivity;
                queueActivity2.history = list;
                queueActivity2.historyRows = (List) objWithContext2;
                return Boxing.boxBoolean(true);
            case 2:
                list = (List) c10062.L$1;
                queueActivity2 = (QueueActivity) c10062.L$0;
                ResultKt.throwOnFailure($result);
                objWithContext2 = $result;
                queueActivity2.history = list;
                queueActivity2.historyRows = (List) objWithContext2;
                return Boxing.boxBoolean(true);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final Row header(String text) {
        return new Row(text, "", null, null, 0, null, null, 0L, 0L, Row.Kind.HEADER, null, 0, 3580, null);
    }

    private final Long dayKey(long at) {
        if (at <= 0) {
            return null;
        }
        Calendar day = Calendar.getInstance();
        day.setTimeInMillis(((long) 1000) * at);
        return Long.valueOf((((long) day.get(1)) * 1000) + ((long) day.get(6)));
    }

    private final String dayText(long at) {
        Calendar then = Calendar.getInstance();
        then.setTimeInMillis(((long) 1000) * at);
        Calendar now = Calendar.getInstance();
        Calendar before = Calendar.getInstance();
        before.add(6, -1);
        Intrinsics.checkNotNull(then);
        Intrinsics.checkNotNull(now);
        if (dayText$same(then, now)) {
            String string = getString(C1020R.string.history_today);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        Intrinsics.checkNotNull(before);
        if (dayText$same(then, before)) {
            String string2 = getString(C1020R.string.history_yesterday);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        String skeleton = then.get(1) == now.get(1) ? "dMMMM" : "dMMMMyyyy";
        Locale locale = Locale.getDefault();
        String pattern = DateFormat.getBestDateTimePattern(locale, skeleton);
        String skeleton2 = new SimpleDateFormat(pattern, locale).format(then.getTime());
        Intrinsics.checkNotNull(skeleton2);
        return skeleton2;
    }

    private static final boolean dayText$same(Calendar a, Calendar b) {
        return a.get(1) == b.get(1) && a.get(6) == b.get(6);
    }

    private final int queueIndexAt(int at) {
        if (getCurrentAt() >= 0 && at >= getCurrentAt() && at < getCurrentAt() + (this.laidCount - this.laidPosition)) {
            return this.laidPosition + (at - getCurrentAt());
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isUpcoming(int at) {
        return getCurrentAt() >= 0 && at > getCurrentAt() && queueIndexAt(at) >= 0;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0257  */
    /* JADX WARN: Code duplicated, block: B:103:0x0263  */
    /* JADX WARN: Code duplicated, block: B:130:0x0305  */
    /* JADX WARN: Code duplicated, block: B:132:0x030b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:133:0x030d  */
    /* JADX WARN: Code duplicated, block: B:135:0x0311  */
    /* JADX WARN: Code duplicated, block: B:137:0x0319  */
    /* JADX WARN: Code duplicated, block: B:138:0x031f  */
    /* JADX WARN: Code duplicated, block: B:140:0x0325  */
    /* JADX WARN: Code duplicated, block: B:142:0x0329  */
    /* JADX WARN: Code duplicated, block: B:177:0x03ac  */
    /* JADX WARN: Code duplicated, block: B:179:0x03b3  */
    /* JADX WARN: Code duplicated, block: B:194:0x0221 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:56:0x0124  */
    /* JADX WARN: Code duplicated, block: B:59:0x014a  */
    /* JADX WARN: Code duplicated, block: B:61:0x0152  */
    /* JADX WARN: Code duplicated, block: B:67:0x018b  */
    /* JADX WARN: Code duplicated, block: B:70:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:73:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:77:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:79:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:80:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:83:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:85:0x0212  */
    /* JADX WARN: Code duplicated, block: B:87:0x0220  */
    /* JADX WARN: Code duplicated, block: B:91:0x022b  */
    /* JADX WARN: Code duplicated, block: B:94:0x0239  */
    /* JADX WARN: Code duplicated, block: B:97:0x0248  */
    private final void layOut() {
        View firstView;
        List chosen;
        List chosen2;
        boolean sameLength;
        int firstIndex;
        ArrayList rows;
        int firstIndex2;
        int firstSeen;
        int size;
        RowAdapter rowAdapter;
        RowAdapter rowAdapter2;
        ActivityQueueBinding activityQueueBinding;
        ActivityQueueBinding activityQueueBinding2;
        RowAdapter rowAdapter3;
        RowAdapter rowAdapter4;
        QueueLayoutManager queueLayoutManager;
        int target;
        int firstSeen2;
        Row placeholder;
        int index;
        int i;
        Row row;
        int i2;
        boolean z;
        Iterable $this$forEachIndexed$iv;
        int index$iv;
        Long key;
        int oldNowAt = this.nowAt;
        boolean wasOnNowPlaying = this.placed && pulled() == 0;
        QueueLayoutManager queueLayoutManager2 = this.manager;
        if (queueLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
            queueLayoutManager2 = null;
        }
        int firstSeen3 = queueLayoutManager2.findFirstVisibleItemPosition();
        if (firstSeen3 >= 0) {
            QueueLayoutManager queueLayoutManager3 = this.manager;
            if (queueLayoutManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("manager");
                queueLayoutManager3 = null;
            }
            firstView = queueLayoutManager3.findViewByPosition(firstSeen3);
        } else {
            firstView = null;
        }
        int top = firstView != null ? firstView.getTop() : 0;
        ActivityQueueBinding activityQueueBinding3 = this.views;
        if (activityQueueBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityQueueBinding3 = null;
        }
        int firstOffset = top - activityQueueBinding3.list.getPaddingTop();
        if (this.mode == Mode.SELECT) {
            RowAdapter rowAdapter5 = this.adapter;
            if (rowAdapter5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                rowAdapter5 = null;
            }
            Iterable $this$map$iv = rowAdapter5.getSelected();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                int it = ((Number) item$iv$iv).intValue();
                destination$iv$iv.add(Integer.valueOf(queueIndexAt(it)));
            }
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv : (List) destination$iv$iv) {
                int it2 = ((Number) element$iv$iv).intValue();
                int it3 = it2 >= 0 ? 1 : 0;
                if (it3 != 0) {
                    destination$iv$iv2.add(element$iv$iv);
                }
            }
            chosen = (List) destination$iv$iv2;
        } else {
            chosen = CollectionsKt.emptyList();
        }
        if (this.count == this.laidCount) {
            chosen2 = chosen;
            sameLength = this.revision == this.laidRevision;
            firstIndex = queueIndexAt(firstSeen3);
            if (this.revision != this.queueRowsRevision) {
                this.queueRows.clear();
                this.queueRowsRevision = this.revision;
            }
            this.laidRevision = this.revision;
            this.laidCount = this.count;
            this.laidPosition = this.position;
            rows = new ArrayList();
            this.historyAt.clear();
            if (!this.history.isEmpty()) {
                String string = getString(C1020R.string.queue_history);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                rows.add(header(string));
                long day = Long.MIN_VALUE;
                $this$forEachIndexed$iv = this.history;
                index$iv = 0;
                for (Object item$iv : $this$forEachIndexed$iv) {
                    int index$iv2 = index$iv + 1;
                    if (index$iv < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                    HistoryEntry entry = (HistoryEntry) item$iv;
                    int i3 = index$iv;
                    int firstIndex3 = firstIndex;
                    int firstSeen4 = firstSeen3;
                    key = dayKey(entry.getPlayedAt());
                    if (key == null && key.longValue() != day) {
                        day = key.longValue();
                        rows.add(header(dayText(entry.getPlayedAt())));
                    }
                    this.historyAt.put(Integer.valueOf(rows.size()), entry);
                    rows.add(this.historyRows.get(i3));
                    index$iv = index$iv2;
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                    firstSeen3 = firstSeen4;
                    firstIndex = firstIndex3;
                }
                firstIndex2 = firstIndex;
                firstSeen = firstSeen3;
            } else {
                firstIndex2 = firstIndex;
                firstSeen = firstSeen3;
            }
            if (this.count > 0) {
                int i4 = this.count;
                i2 = this.position;
                if (i2 >= 0 || i2 >= i4) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    size = rows.size();
                } else {
                    size = -1;
                }
            } else {
                size = -1;
            }
            this.nowAt = size;
            if (this.nowAt >= 0) {
                String string2 = getString(C1020R.string.queue_now_playing);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                rows.add(header(string2));
                placeholder = new Row("…", "", null, null, 0, null, null, 0L, 0L, Row.Kind.PENDING, null, C1020R.drawable.ic_track, 1532, null);
                i = this.count;
                for (index = this.position; index < i; index++) {
                    row = this.queueRows.get(Integer.valueOf(index));
                    if (row == null) {
                        row = placeholder;
                    }
                    rows.add(row);
                }
            }
            rowAdapter = this.adapter;
            if (rowAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                rowAdapter = null;
            }
            rowAdapter.submit(rows);
            rowAdapter2 = this.adapter;
            if (rowAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                rowAdapter2 = null;
            }
            rowAdapter2.setHighlightIndex(getCurrentAt());
            activityQueueBinding = this.views;
            if (activityQueueBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("views");
                activityQueueBinding = null;
            }
            activityQueueBinding.progress.setVisibility(8);
            activityQueueBinding2 = this.views;
            if (activityQueueBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("views");
                activityQueueBinding2 = null;
            }
            activityQueueBinding2.emptyText.setVisibility(rows.isEmpty() ? 0 : 8);
            if (this.mode != Mode.SELECT && (!chosen2.isEmpty()) && sameLength) {
                RowAdapter rowAdapter6 = this.adapter;
                if (rowAdapter6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    rowAdapter6 = null;
                }
                rowAdapter6.startEmptySelection();
                List $this$filter$iv = chosen2;
                int $i$f$filter = 0;
                Collection destination$iv$iv3 = new ArrayList();
                for (Object element$iv$iv2 : $this$filter$iv) {
                    Iterable $this$filter$iv2 = $this$filter$iv;
                    int it4 = ((Number) element$iv$iv2).intValue();
                    int $i$f$filter2 = $i$f$filter;
                    int $i$f$filter3 = this.laidPosition;
                    int it5 = it4 > $i$f$filter3 ? 1 : 0;
                    if (it5 != 0) {
                        destination$iv$iv3.add(element$iv$iv2);
                    }
                    $this$filter$iv = $this$filter$iv2;
                    $i$f$filter = $i$f$filter2;
                }
                Iterable $this$forEach$iv = (List) destination$iv$iv3;
                int $i$f$forEach = 0;
                for (Object element$iv : $this$forEach$iv) {
                    int it6 = ((Number) element$iv).intValue();
                    Iterable $this$forEach$iv2 = $this$forEach$iv;
                    RowAdapter rowAdapter7 = this.adapter;
                    if (rowAdapter7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        rowAdapter7 = null;
                    }
                    int currentAt = getCurrentAt();
                    int $i$f$forEach2 = $i$f$forEach;
                    int $i$f$forEach3 = this.laidPosition;
                    rowAdapter7.toggle(currentAt + (it6 - $i$f$forEach3));
                    $this$forEach$iv = $this$forEach$iv2;
                    $i$f$forEach = $i$f$forEach2;
                }
            } else if (this.mode == Mode.SELECT) {
                if (sameLength) {
                    rowAdapter4 = this.adapter;
                    if (rowAdapter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        rowAdapter4 = null;
                    }
                    rowAdapter4.startEmptySelection();
                } else {
                    setMode(Mode.IDLE);
                }
            } else if (this.mode == Mode.REORDER) {
                rowAdapter3 = this.adapter;
                if (rowAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    rowAdapter3 = null;
                }
                rowAdapter3.setGripAt(new Function1<Integer, Boolean>() { // from class: com.mattiadoronzo.sonixlink.QueueActivity.layOut.4
                    {
                        super(1);
                    }

                    public final Boolean invoke(int at) {
                        return Boolean.valueOf(QueueActivity.this.mode == Mode.REORDER && QueueActivity.this.isUpcoming(at));
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                        return invoke(num.intValue());
                    }
                });
            }
            if (this.nowAt < 0 && this.mode != Mode.IDLE) {
                setMode(Mode.IDLE);
            }
            if (this.placed || wasOnNowPlaying) {
                if (this.nowAt >= 0) {
                    this.placed = true;
                    queueLayoutManager = this.manager;
                    if (queueLayoutManager == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("manager");
                        queueLayoutManager = null;
                    }
                    queueLayoutManager.scrollToPositionWithOffset(this.nowAt, 0);
                }
            } else if (firstSeen >= 0) {
                int firstIndex4 = firstIndex2;
                if (firstIndex4 <= this.position || this.nowAt < 0) {
                    if (firstIndex4 < 0) {
                        if (oldNowAt >= 0) {
                            firstSeen2 = firstSeen;
                            if (firstSeen2 >= oldNowAt) {
                            }
                        } else {
                            firstSeen2 = firstSeen;
                        }
                        target = firstSeen2;
                    }
                    target = RangesKt.coerceAtLeast(this.nowAt, 0);
                } else {
                    target = getCurrentAt() + (firstIndex4 - this.position);
                }
                QueueLayoutManager queueLayoutManager4 = this.manager;
                if (queueLayoutManager4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("manager");
                    queueLayoutManager4 = null;
                }
                queueLayoutManager4.scrollToPositionWithOffset(RangesKt.coerceIn(target, 0, RangesKt.coerceAtLeast(rows.size() - 1, 0)), firstOffset);
            }
            paintBar();
            fetchVisible();
        }
        chosen2 = chosen;
        firstIndex = queueIndexAt(firstSeen3);
        if (this.revision != this.queueRowsRevision) {
            this.queueRows.clear();
            this.queueRowsRevision = this.revision;
        }
        this.laidRevision = this.revision;
        this.laidCount = this.count;
        this.laidPosition = this.position;
        rows = new ArrayList();
        this.historyAt.clear();
        if (!this.history.isEmpty()) {
            String string3 = getString(C1020R.string.queue_history);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            rows.add(header(string3));
            long day2 = Long.MIN_VALUE;
            $this$forEachIndexed$iv = this.history;
            index$iv = 0;
            while (r21.hasNext()) {
                int index$iv3 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Iterable $this$forEachIndexed$iv3 = $this$forEachIndexed$iv;
                HistoryEntry entry2 = (HistoryEntry) item$iv;
                int i5 = index$iv;
                int firstIndex5 = firstIndex;
                int firstSeen5 = firstSeen3;
                key = dayKey(entry2.getPlayedAt());
                if (key == null) {
                }
                this.historyAt.put(Integer.valueOf(rows.size()), entry2);
                rows.add(this.historyRows.get(i5));
                index$iv = index$iv3;
                $this$forEachIndexed$iv = $this$forEachIndexed$iv3;
                firstSeen3 = firstSeen5;
                firstIndex = firstIndex5;
            }
            firstIndex2 = firstIndex;
            firstSeen = firstSeen3;
        } else {
            firstIndex2 = firstIndex;
            firstSeen = firstSeen3;
        }
        if (this.count > 0) {
            int i6 = this.count;
            i2 = this.position;
            if (i2 >= 0) {
                z = false;
            } else {
                z = false;
            }
            if (z) {
                size = rows.size();
            } else {
                size = -1;
            }
        } else {
            size = -1;
        }
        this.nowAt = size;
        if (this.nowAt >= 0) {
            String string4 = getString(C1020R.string.queue_now_playing);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            rows.add(header(string4));
            placeholder = new Row("…", "", null, null, 0, null, null, 0L, 0L, Row.Kind.PENDING, null, C1020R.drawable.ic_track, 1532, null);
            i = this.count;
            while (index < i) {
                row = this.queueRows.get(Integer.valueOf(index));
                if (row == null) {
                    row = placeholder;
                }
                rows.add(row);
            }
        }
        rowAdapter = this.adapter;
        if (rowAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            rowAdapter = null;
        }
        rowAdapter.submit(rows);
        rowAdapter2 = this.adapter;
        if (rowAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            rowAdapter2 = null;
        }
        rowAdapter2.setHighlightIndex(getCurrentAt());
        activityQueueBinding = this.views;
        if (activityQueueBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityQueueBinding = null;
        }
        activityQueueBinding.progress.setVisibility(8);
        activityQueueBinding2 = this.views;
        if (activityQueueBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityQueueBinding2 = null;
        }
        activityQueueBinding2.emptyText.setVisibility(rows.isEmpty() ? 0 : 8);
        if (this.mode != Mode.SELECT) {
            if (this.mode == Mode.SELECT) {
                if (sameLength) {
                    rowAdapter4 = this.adapter;
                    if (rowAdapter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        rowAdapter4 = null;
                    }
                    rowAdapter4.startEmptySelection();
                } else {
                    setMode(Mode.IDLE);
                }
            } else if (this.mode == Mode.REORDER) {
                rowAdapter3 = this.adapter;
                if (rowAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    rowAdapter3 = null;
                }
                rowAdapter3.setGripAt(new Function1<Integer, Boolean>() { // from class: com.mattiadoronzo.sonixlink.QueueActivity.layOut.4
                    {
                        super(1);
                    }

                    public final Boolean invoke(int at) {
                        return Boolean.valueOf(QueueActivity.this.mode == Mode.REORDER && QueueActivity.this.isUpcoming(at));
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                        return invoke(num.intValue());
                    }
                });
            }
        } else if (this.mode == Mode.SELECT) {
            if (sameLength) {
                rowAdapter4 = this.adapter;
                if (rowAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    rowAdapter4 = null;
                }
                rowAdapter4.startEmptySelection();
            } else {
                setMode(Mode.IDLE);
            }
        } else if (this.mode == Mode.REORDER) {
            rowAdapter3 = this.adapter;
            if (rowAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                rowAdapter3 = null;
            }
            rowAdapter3.setGripAt(new Function1<Integer, Boolean>() { // from class: com.mattiadoronzo.sonixlink.QueueActivity.layOut.4
                {
                    super(1);
                }

                public final Boolean invoke(int at) {
                    return Boolean.valueOf(QueueActivity.this.mode == Mode.REORDER && QueueActivity.this.isUpcoming(at));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }
            });
        }
        if (this.nowAt < 0) {
            setMode(Mode.IDLE);
        }
        if (this.placed) {
        }
        if (this.nowAt >= 0) {
            this.placed = true;
            queueLayoutManager = this.manager;
            if (queueLayoutManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("manager");
                queueLayoutManager = null;
            }
            queueLayoutManager.scrollToPositionWithOffset(this.nowAt, 0);
        }
        paintBar();
        fetchVisible();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchVisible() {
        if (this.fetching || this.dragging || this.nowAt < 0 || this.laidCount <= 0) {
            return;
        }
        QueueLayoutManager queueLayoutManager = this.manager;
        Object obj = null;
        if (queueLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
            queueLayoutManager = null;
        }
        int first = queueLayoutManager.findFirstVisibleItemPosition();
        QueueLayoutManager queueLayoutManager2 = this.manager;
        if (queueLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
            queueLayoutManager2 = null;
        }
        int last = queueLayoutManager2.findLastVisibleItemPosition();
        if (first < 0 || last < 0) {
            first = getCurrentAt();
            last = getCurrentAt();
        }
        int from = RangesKt.coerceAtLeast(queueIndexAt(RangesKt.coerceAtLeast(first - 40, getCurrentAt())), this.laidPosition);
        int to = queueIndexAt(RangesKt.coerceAtMost(last + 40, ((getCurrentAt() + this.laidCount) - this.laidPosition) - 1));
        if (to < 0) {
            return;
        }
        Iterable $this$firstOrNull$iv = new IntRange(from, to);
        for (Object element$iv : $this$firstOrNull$iv) {
            int it = ((Number) element$iv).intValue();
            if (!this.queueRows.containsKey(Integer.valueOf(it))) {
                obj = element$iv;
                break;
            }
        }
        Integer num = (Integer) obj;
        if (num != null) {
            int missing = num.intValue();
            fetchPage(missing);
        }
    }

    private final void fetchPage(int from) {
        PlayerClient client = Session.INSTANCE.getClient();
        if (client == null) {
            return;
        }
        long wantedRevision = this.laidRevision;
        this.fetching = true;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C10031(wantedRevision, client, from, null), 3, null);
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.QueueActivity$fetchPage$1 */
    /* JADX INFO: compiled from: QueueActivity.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.QueueActivity$fetchPage$1", m164f = "QueueActivity.kt", m165i = {1}, m166l = {505, 520}, m167m = "invokeSuspend", m168n = {"page"}, m169s = {"L$0"})
    static final class C10031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PlayerClient $client;
        final /* synthetic */ int $from;
        final /* synthetic */ long $wantedRevision;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10031(long j, PlayerClient playerClient, int i, Continuation<? super C10031> continuation) {
            super(2, continuation);
            this.$wantedRevision = j;
            this.$client = playerClient;
            this.$from = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return QueueActivity.this.new C10031(this.$wantedRevision, this.$client, this.$from, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10031) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x00b3  */
        /* JADX WARN: Code duplicated, block: B:30:0x00b6  */
        /* JADX WARN: Code duplicated, block: B:33:0x00c7  */
        /* JADX WARN: Code duplicated, block: B:35:0x00cf  */
        /* JADX WARN: Code duplicated, block: B:39:0x00f5  */
        /* JADX WARN: Code duplicated, block: B:41:0x00f8  */
        /* JADX WARN: Code duplicated, block: B:43:0x010d  */
        /* JADX WARN: Code duplicated, block: B:45:0x0115  */
        /* JADX WARN: Code duplicated, block: B:53:0x00d2 A[SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            C10031 c10031;
            Object objWithContext;
            QueueWindow page;
            C10031 c10032;
            Object $result2;
            List rows;
            QueueActivity queueActivity;
            int i;
            int skip;
            RowAdapter rowAdapter;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c10031 = this;
                    c10031.label = 1;
                    objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new QueueActivity$fetchPage$1$page$1(c10031.$client, c10031.$from, null), c10031);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    page = (QueueWindow) objWithContext;
                    QueueActivity.this.fetching = false;
                    if (page != null || page.getPaths().isEmpty() || QueueActivity.this.laidRevision != c10031.$wantedRevision || (page.getRevision() >= 0 && page.getRevision() != c10031.$wantedRevision)) {
                        return Unit.INSTANCE;
                    }
                    c10031.L$0 = page;
                    c10031.label = 2;
                    Object objWithContext2 = BuildersKt.withContext(Dispatchers.getIO(), new QueueActivity$fetchPage$1$rows$1(page, null), c10031);
                    if (objWithContext2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c10032 = c10031;
                    $result2 = objWithContext2;
                    rows = (List) $result2;
                    if (QueueActivity.this.laidRevision != c10032.$wantedRevision) {
                        return Unit.INSTANCE;
                    }
                    List $this$forEachIndexed$iv = rows;
                    queueActivity = QueueActivity.this;
                    i = 0;
                    for (Object item$iv : $this$forEachIndexed$iv) {
                        int index$iv = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        Row row = (Row) item$iv;
                        queueActivity.queueRows.put(Boxing.boxInt(page.getFirst() + i), row);
                        i = index$iv;
                    }
                    if (QueueActivity.this.dragging) {
                        return Unit.INSTANCE;
                    }
                    skip = RangesKt.coerceAtLeast(QueueActivity.this.laidPosition - page.getFirst(), 0);
                    if (skip < rows.size()) {
                        rowAdapter = QueueActivity.this.adapter;
                        if (rowAdapter == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adapter");
                            rowAdapter = null;
                        }
                        rowAdapter.replace(QueueActivity.this.getCurrentAt() + ((page.getFirst() + skip) - QueueActivity.this.laidPosition), CollectionsKt.drop(rows, skip));
                    }
                    QueueActivity.this.fetchVisible();
                    return Unit.INSTANCE;
                case 1:
                    c10031 = this;
                    ResultKt.throwOnFailure($result);
                    objWithContext = $result;
                    page = (QueueWindow) objWithContext;
                    QueueActivity.this.fetching = false;
                    if (page != null) {
                        break;
                    }
                    return Unit.INSTANCE;
                case 2:
                    c10032 = this;
                    $result2 = $result;
                    QueueWindow page2 = (QueueWindow) c10032.L$0;
                    ResultKt.throwOnFailure($result2);
                    page = page2;
                    rows = (List) $result2;
                    if (QueueActivity.this.laidRevision != c10032.$wantedRevision) {
                        return Unit.INSTANCE;
                    }
                    List $this$forEachIndexed$iv2 = rows;
                    queueActivity = QueueActivity.this;
                    i = 0;
                    while (r11.hasNext()) {
                        int index$iv2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        Row row2 = (Row) item$iv;
                        queueActivity.queueRows.put(Boxing.boxInt(page.getFirst() + i), row2);
                        i = index$iv2;
                    }
                    if (QueueActivity.this.dragging) {
                        return Unit.INSTANCE;
                    }
                    skip = RangesKt.coerceAtLeast(QueueActivity.this.laidPosition - page.getFirst(), 0);
                    if (skip < rows.size()) {
                        rowAdapter = QueueActivity.this.adapter;
                        if (rowAdapter == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adapter");
                            rowAdapter = null;
                        }
                        rowAdapter.replace(QueueActivity.this.getCurrentAt() + ((page.getFirst() + skip) - QueueActivity.this.laidPosition), CollectionsKt.drop(rows, skip));
                    }
                    QueueActivity.this.fetchVisible();
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: dp */
    private final int m145dp(int value) {
        return (int) (value * getResources().getDisplayMetrics().density);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int tensionPx() {
        return m145dp(56);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int pulled() {
        if (this.nowAt < 0) {
            return -1;
        }
        QueueLayoutManager queueLayoutManager = this.manager;
        ActivityQueueBinding activityQueueBinding = null;
        QueueLayoutManager queueLayoutManager2 = null;
        if (queueLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
            queueLayoutManager = null;
        }
        View viewFindViewByPosition = queueLayoutManager.findViewByPosition(this.nowAt);
        if (viewFindViewByPosition == null) {
            QueueLayoutManager queueLayoutManager3 = this.manager;
            if (queueLayoutManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("manager");
            } else {
                queueLayoutManager2 = queueLayoutManager3;
            }
            int iFindFirstVisibleItemPosition = queueLayoutManager2.findFirstVisibleItemPosition();
            return (iFindFirstVisibleItemPosition < 0 || iFindFirstVisibleItemPosition > this.nowAt) ? -1 : Integer.MAX_VALUE;
        }
        int top = viewFindViewByPosition.getTop();
        ActivityQueueBinding activityQueueBinding2 = this.views;
        if (activityQueueBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
        } else {
            activityQueueBinding = activityQueueBinding2;
        }
        return top - activityQueueBinding.list.getPaddingTop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void settleOnNowPlaying(boolean animate) {
        if (this.nowAt < 0) {
            return;
        }
        QueueLayoutManager queueLayoutManager = null;
        if (!animate) {
            QueueLayoutManager queueLayoutManager2 = this.manager;
            if (queueLayoutManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("manager");
            } else {
                queueLayoutManager = queueLayoutManager2;
            }
            queueLayoutManager.scrollToPositionWithOffset(this.nowAt, 0);
            return;
        }
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(this) { // from class: com.mattiadoronzo.sonixlink.QueueActivity$settleOnNowPlaying$scroller$1
            {
                super(this);
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            protected int getVerticalSnapPreference() {
                return -1;
            }
        };
        linearSmoothScroller.setTargetPosition(this.nowAt);
        QueueLayoutManager queueLayoutManager3 = this.manager;
        if (queueLayoutManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
        } else {
            queueLayoutManager = queueLayoutManager3;
        }
        queueLayoutManager.startSmoothScroll(linearSmoothScroller);
    }

    /* JADX INFO: compiled from: QueueActivity.kt */
    @Metadata(m147d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0018\u00010\u0013R\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0017"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/QueueActivity$QueueLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "(Lcom/mattiadoronzo/sonixlink/QueueActivity;)V", "flingFromBelow", "", "getFlingFromBelow", "()Z", "setFlingFromBelow", "(Z)V", "held", "getHeld", "setHeld", "tense", "getTense", "setTense", "scrollVerticallyBy", "", "dy", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private final class QueueLayoutManager extends LinearLayoutManager {
        private boolean flingFromBelow;
        private boolean held;
        private boolean tense;

        public QueueLayoutManager() {
            super(QueueActivity.this);
        }

        public final boolean getHeld() {
            return this.held;
        }

        public final void setHeld(boolean z) {
            this.held = z;
        }

        public final boolean getTense() {
            return this.tense;
        }

        public final void setTense(boolean z) {
            this.tense = z;
        }

        public final boolean getFlingFromBelow() {
            return this.flingFromBelow;
        }

        public final void setFlingFromBelow(boolean z) {
            this.flingFromBelow = z;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
            if (dy < 0 && this.held && this.tense) {
                if (!QueueActivity.this.history.isEmpty()) {
                    int pull = QueueActivity.this.pulled();
                    if (pull >= 0 && pull < QueueActivity.this.tensionPx()) {
                        int eased = (dy * 2) / 5;
                        if (eased == 0) {
                            eased = -1;
                        }
                        super.scrollVerticallyBy(eased, recycler, state);
                        return dy;
                    }
                }
            }
            return super.scrollVerticallyBy(dy, recycler, state);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setMode(Mode next) {
        if (next == this.mode) {
            paintBar();
            return;
        }
        RowAdapter rowAdapter = null;
        if (this.mode == Mode.SELECT) {
            RowAdapter rowAdapter2 = this.adapter;
            if (rowAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                rowAdapter2 = null;
            }
            rowAdapter2.stopSelection();
        }
        this.mode = next;
        switch (WhenMappings.$EnumSwitchMapping$0[next.ordinal()]) {
            case 1:
                RowAdapter rowAdapter3 = this.adapter;
                if (rowAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    rowAdapter3 = null;
                }
                rowAdapter3.setGripAt(null);
                RowAdapter rowAdapter4 = this.adapter;
                if (rowAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    rowAdapter = rowAdapter4;
                }
                rowAdapter.startEmptySelection();
                break;
            case 2:
                RowAdapter rowAdapter5 = this.adapter;
                if (rowAdapter5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    rowAdapter = rowAdapter5;
                }
                rowAdapter.setGripAt(new Function1<Integer, Boolean>() { // from class: com.mattiadoronzo.sonixlink.QueueActivity.setMode.1
                    {
                        super(1);
                    }

                    public final Boolean invoke(int at) {
                        return Boolean.valueOf(QueueActivity.this.mode == Mode.REORDER && QueueActivity.this.isUpcoming(at));
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                        return invoke(num.intValue());
                    }
                });
                break;
            case 3:
                RowAdapter rowAdapter6 = this.adapter;
                if (rowAdapter6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    rowAdapter6 = null;
                }
                rowAdapter6.setGripAt(null);
                break;
        }
        paintBar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void paintBar() {
        int chosen;
        int color;
        String string;
        if (this.views == null) {
            return;
        }
        boolean any = this.laidCount > 0 && this.nowAt >= 0;
        ActivityQueueBinding activityQueueBinding = this.views;
        ActivityQueueBinding activityQueueBinding2 = null;
        if (activityQueueBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityQueueBinding = null;
        }
        activityQueueBinding.queueSelect.setVisibility((this.mode == Mode.IDLE && any) ? 0 : 8);
        ActivityQueueBinding activityQueueBinding3 = this.views;
        if (activityQueueBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityQueueBinding3 = null;
        }
        activityQueueBinding3.queueReorder.setVisibility((this.mode == Mode.SELECT || !any) ? 8 : 0);
        ActivityQueueBinding activityQueueBinding4 = this.views;
        if (activityQueueBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityQueueBinding4 = null;
        }
        activityQueueBinding4.queueRemove.setVisibility(this.mode == Mode.SELECT ? 0 : 8);
        ActivityQueueBinding activityQueueBinding5 = this.views;
        if (activityQueueBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityQueueBinding5 = null;
        }
        activityQueueBinding5.queueClose.setVisibility(this.mode == Mode.SELECT ? 0 : 8);
        if (this.mode == Mode.SELECT) {
            RowAdapter rowAdapter = this.adapter;
            if (rowAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                rowAdapter = null;
            }
            chosen = rowAdapter.getSelected().size();
        } else {
            chosen = 0;
        }
        ActivityQueueBinding activityQueueBinding6 = this.views;
        if (activityQueueBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityQueueBinding6 = null;
        }
        activityQueueBinding6.queueRemove.setEnabled(chosen > 0);
        ActivityQueueBinding activityQueueBinding7 = this.views;
        if (activityQueueBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityQueueBinding7 = null;
        }
        activityQueueBinding7.queueRemove.setAlpha(chosen > 0 ? 1.0f : 0.4f);
        ActivityQueueBinding activityQueueBinding8 = this.views;
        if (activityQueueBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
        } else {
            activityQueueBinding2 = activityQueueBinding8;
        }
        ImageButton imageButton = activityQueueBinding2.queueReorder;
        if (this.mode == Mode.REORDER) {
            color = Session.INSTANCE.getAccent();
        } else {
            color = ContextCompat.getColor(this, C1020R.color.text_primary);
        }
        imageButton.setImageTintList(ColorStateList.valueOf(color));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            if (this.mode == Mode.SELECT) {
                string = getString(C1020R.string.selected_count, new Object[]{Integer.valueOf(chosen)});
            } else {
                string = getString(C1020R.string.queue_title);
            }
            supportActionBar.setTitle(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onRowClicked(int at, Row row) {
        if (row.getKind() == Row.Kind.HEADER || this.dragging) {
            return;
        }
        final HistoryEntry entry = this.historyAt.get(Integer.valueOf(at));
        switch (WhenMappings.$EnumSwitchMapping$0[this.mode.ordinal()]) {
            case 1:
                if (isUpcoming(at)) {
                    RowAdapter rowAdapter = this.adapter;
                    if (rowAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        rowAdapter = null;
                    }
                    rowAdapter.toggle(at);
                    paintBar();
                }
                break;
            case 3:
                if (entry != null) {
                    act$default(this, null, false, new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.QueueActivity.onRowClicked.1
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
                            it.historyPlay(entry.getId());
                        }
                    }, 3, null);
                } else {
                    int index = queueIndexAt(at);
                    if (index >= 0) {
                        jumpTo(index);
                    }
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onRowLongPressed(int at, Row row) {
        if (this.mode == Mode.IDLE) {
            if (this.historyAt.containsKey(Integer.valueOf(at)) && this.nowAt >= 0) {
                ActivityQueueBinding activityQueueBinding = this.views;
                ItemTouchHelper itemTouchHelper = null;
                if (activityQueueBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("views");
                    activityQueueBinding = null;
                }
                RecyclerView.ViewHolder it = activityQueueBinding.list.findViewHolderForAdapterPosition(at);
                if (it != null) {
                    ItemTouchHelper itemTouchHelper2 = this.touch;
                    if (itemTouchHelper2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("touch");
                    } else {
                        itemTouchHelper = itemTouchHelper2;
                    }
                    itemTouchHelper.startDrag(it);
                    return;
                }
                return;
            }
        }
        onRowClicked(at, row);
    }

    private final void removeChosen() {
        RowAdapter rowAdapter = this.adapter;
        if (rowAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            rowAdapter = null;
        }
        Iterable $this$map$iv = rowAdapter.getSelected();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            int it = ((Number) item$iv$iv).intValue();
            destination$iv$iv.add(Integer.valueOf(queueIndexAt(it)));
        }
        Iterable $this$filter$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            int it2 = ((Number) element$iv$iv).intValue();
            if (it2 > this.laidPosition) {
                destination$iv$iv2.add(element$iv$iv);
            }
        }
        final List indices = (List) destination$iv$iv2;
        if (indices.isEmpty()) {
            return;
        }
        final long seen = this.laidRevision;
        setMode(Mode.IDLE);
        act$default(this, getString(C1020R.string.done_queue_removed), false, new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.QueueActivity.removeChosen.1
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
            public final void invoke2(PlayerClient it3) {
                Intrinsics.checkNotNullParameter(it3, "it");
                it3.queueRemove(indices, seen);
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dropped() {
        int from = this.dragFrom;
        int at = this.dragAt;
        boolean wasHistory = this.dragFromHistory;
        boolean stale = this.relayoutAfterDrag;
        this.dragging = false;
        this.dragFrom = -1;
        this.dragAt = -1;
        this.relayoutAfterDrag = false;
        QueueLayoutManager queueLayoutManager = this.manager;
        RowAdapter rowAdapter = null;
        if (queueLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
            queueLayoutManager = null;
        }
        queueLayoutManager.setHeld(false);
        final long seen = this.laidRevision;
        if (wasHistory) {
            final HistoryEntry entry = this.historyAt.get(Integer.valueOf(from));
            int current = getCurrentAt() - 1;
            if (!stale && entry != null && from != at && at > current) {
                final int slot = this.laidPosition + (at - current);
                act$default(this, null, true, new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.QueueActivity.dropped.1
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
                        it.historyInsert(entry.getId(), slot, seen);
                    }
                }, 1, null);
            }
            if (!stale) {
                RowAdapter rowAdapter2 = this.adapter;
                if (rowAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    rowAdapter = rowAdapter2;
                }
                rowAdapter.move(at, from);
                return;
            }
            layOut();
            return;
        }
        if (stale) {
            layOut();
            return;
        }
        final int fromIndex = this.laidPosition + (from - getCurrentAt());
        final int toIndex = this.laidPosition + (at - getCurrentAt());
        if (from >= 0 && at >= 0 && fromIndex != toIndex) {
            act$default(this, null, true, new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.QueueActivity.dropped.2
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
                    it.queueMove(fromIndex, toIndex, seen);
                }
            }, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: QueueActivity.kt */
    @Metadata(m147d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J \u0010\u000e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u001a\u0010\u0010\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\nH\u0016¨\u0006\u0014"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/QueueActivity$DragCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "(Lcom/mattiadoronzo/sonixlink/QueueActivity;)V", "clearView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getMovementFlags", "", "isItemViewSwipeEnabled", "", "isLongPressDragEnabled", "onMove", "target", "onSelectedChanged", "actionState", "onSwiped", "direction", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    final class DragCallback extends ItemTouchHelper.Callback {
        public DragCallback() {
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean isLongPressDragEnabled() {
            return false;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean isItemViewSwipeEnabled() {
            return false;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0050  */
        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            boolean movable;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            int at = viewHolder.getBindingAdapterPosition();
            if (QueueActivity.this.dragging || (QueueActivity.this.mode == Mode.REORDER && QueueActivity.this.isUpcoming(at))) {
                movable = true;
            } else {
                if (QueueActivity.this.mode == Mode.IDLE) {
                    if (QueueActivity.this.historyAt.containsKey(Integer.valueOf(at)) && QueueActivity.this.nowAt >= 0) {
                        movable = true;
                    }
                }
                movable = false;
            }
            if (movable) {
                return ItemTouchHelper.Callback.makeMovementFlags(3, 0);
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            Intrinsics.checkNotNullParameter(target, "target");
            int from = viewHolder.getBindingAdapterPosition();
            int to = target.getBindingAdapterPosition();
            if (from != -1 && to != -1) {
                if (QueueActivity.this.dragFromHistory || to > QueueActivity.this.getCurrentAt()) {
                    RowAdapter rowAdapter = QueueActivity.this.adapter;
                    if (rowAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        rowAdapter = null;
                    }
                    rowAdapter.move(from, to);
                    QueueActivity.this.dragAt = to;
                    return true;
                }
                return false;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
            super.onSelectedChanged(viewHolder, actionState);
            if (actionState == 2 && viewHolder != null) {
                QueueActivity.this.dragging = true;
                QueueActivity.this.dragFrom = viewHolder.getBindingAdapterPosition();
                QueueActivity.this.dragAt = QueueActivity.this.dragFrom;
                QueueActivity.this.dragFromHistory = QueueActivity.this.historyAt.containsKey(Integer.valueOf(QueueActivity.this.dragFrom));
            }
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            super.clearView(recyclerView, viewHolder);
            final QueueActivity queueActivity = QueueActivity.this;
            recyclerView.post(new Runnable() { // from class: com.mattiadoronzo.sonixlink.QueueActivity$DragCallback$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    QueueActivity.DragCallback.clearView$lambda$0(queueActivity);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void clearView$lambda$0(QueueActivity this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.dragging) {
                this$0.dropped();
            }
        }
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.QueueActivity$jumpTo$1 */
    /* JADX INFO: compiled from: QueueActivity.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.QueueActivity$jumpTo$1", m164f = "QueueActivity.kt", m165i = {}, m166l = {792, 799}, m167m = "invokeSuspend", m168n = {}, m169s = {})
    static final class C10041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PlayerClient $client;
        final /* synthetic */ int $index;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10041(PlayerClient playerClient, int i, Continuation<? super C10041> continuation) {
            super(2, continuation);
            this.$client = playerClient;
            this.$index = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return QueueActivity.this.new C10041(this.$client, this.$index, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10041) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.QueueActivity$jumpTo$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: QueueActivity.kt */
        @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.QueueActivity$jumpTo$1$1", m164f = "QueueActivity.kt", m165i = {}, m166l = {}, m167m = "invokeSuspend", m168n = {}, m169s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PlayerClient $client;
            final /* synthetic */ int $index;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(PlayerClient playerClient, int i, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$client = playerClient;
                this.$index = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$client, this.$index, continuation);
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
                            this.$client.playQueueIndex(this.$index);
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
            C10041 c10041;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c10041 = this;
                    c10041.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1(c10041.$client, c10041.$index, null), c10041) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c10041.label = 2;
                    if (QueueActivity.this.refresh(c10041) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 1:
                    c10041 = this;
                    ResultKt.throwOnFailure($result);
                    c10041.label = 2;
                    if (QueueActivity.this.refresh(c10041) == coroutine_suspended) {
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

    private final void jumpTo(int index) {
        PlayerClient client = Session.INSTANCE.getClient();
        if (client == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C10041(client, index, null), 3, null);
    }

    static /* synthetic */ void act$default(QueueActivity queueActivity, String str, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        queueActivity.act(str, z, function1);
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.QueueActivity$act$1 */
    /* JADX INFO: compiled from: QueueActivity.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.QueueActivity$act$1", m164f = "QueueActivity.kt", m165i = {2, 3}, m166l = {812, 825, 832, 833, 836}, m167m = "invokeSuspend", m168n = {"before", "before"}, m169s = {"J$0", "J$0"})
    static final class C10001 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<PlayerClient, Unit> $action;
        final /* synthetic */ PlayerClient $client;
        final /* synthetic */ String $done;
        final /* synthetic */ boolean $relayout;
        long J$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C10001(String str, boolean z, Function1<? super PlayerClient, Unit> function1, PlayerClient playerClient, Continuation<? super C10001> continuation) {
            super(2, continuation);
            this.$done = str;
            this.$relayout = z;
            this.$action = function1;
            this.$client = playerClient;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return QueueActivity.this.new C10001(this.$done, this.$relayout, this.$action, this.$client, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10001) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:17:0x0063  */
        /* JADX WARN: Code duplicated, block: B:18:0x006c  */
        /* JADX WARN: Code duplicated, block: B:21:0x0071  */
        /* JADX WARN: Code duplicated, block: B:23:0x0079  */
        /* JADX WARN: Code duplicated, block: B:24:0x007f  */
        /* JADX WARN: Code duplicated, block: B:28:0x0095  */
        /* JADX WARN: Code duplicated, block: B:30:0x00a3 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:31:0x00a4  */
        /* JADX WARN: Code duplicated, block: B:34:0x00a9  */
        /* JADX WARN: Code duplicated, block: B:36:0x00bf A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:37:0x00c0  */
        /* JADX WARN: Code duplicated, block: B:40:0x00d3 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:43:0x00de  */
        /* JADX WARN: Code duplicated, block: B:45:0x00f3 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:46:0x00f4  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            C10001 c10001;
            boolean failed;
            String string;
            String message;
            long before;
            C10001 c10002;
            long before2;
            ActivityQueueBinding activityQueueBinding;
            C10001 c10003;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ActivityQueueBinding activityQueueBinding2 = null;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new QueueActivity$act$1$failed$1(this.$action, this.$client, null), this);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objWithContext;
                    c10001 = this;
                    failed = ((Boolean) $result).booleanValue();
                    if (failed) {
                        string = QueueActivity.this.getString(C1020R.string.command_failed);
                    } else {
                        string = c10001.$done;
                    }
                    message = string;
                    if (message != null) {
                        activityQueueBinding = QueueActivity.this.views;
                        if (activityQueueBinding == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("views");
                        } else {
                            activityQueueBinding2 = activityQueueBinding;
                        }
                        Snackbar.make(activityQueueBinding2.getRoot(), message, 0).show();
                    }
                    if (!c10001.$relayout) {
                        c10001.label = 2;
                        if (QueueActivity.this.refresh(c10001) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    before = QueueActivity.this.laidRevision;
                    c10001.J$0 = before;
                    c10001.label = 3;
                    if (DelayKt.delay(1000L, c10001) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c10002 = c10001;
                    before2 = before;
                    c10002.J$0 = before2;
                    c10002.label = 4;
                    if (QueueActivity.this.refresh(c10002) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (QueueActivity.this.revision == before2) {
                        QueueActivity.this.revision = Long.MIN_VALUE;
                        c10002.label = 5;
                        if (QueueActivity.this.refresh(c10002) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c10003 = c10002;
                    }
                    return Unit.INSTANCE;
                case 1:
                    ResultKt.throwOnFailure($result);
                    c10001 = this;
                    failed = ((Boolean) $result).booleanValue();
                    if (failed) {
                        string = QueueActivity.this.getString(C1020R.string.command_failed);
                    } else {
                        string = c10001.$done;
                    }
                    message = string;
                    if (message != null) {
                        activityQueueBinding = QueueActivity.this.views;
                        if (activityQueueBinding == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("views");
                        } else {
                            activityQueueBinding2 = activityQueueBinding;
                        }
                        Snackbar.make(activityQueueBinding2.getRoot(), message, 0).show();
                    }
                    if (!c10001.$relayout) {
                        c10001.label = 2;
                        if (QueueActivity.this.refresh(c10001) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    before = QueueActivity.this.laidRevision;
                    c10001.J$0 = before;
                    c10001.label = 3;
                    if (DelayKt.delay(1000L, c10001) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c10002 = c10001;
                    before2 = before;
                    c10002.J$0 = before2;
                    c10002.label = 4;
                    if (QueueActivity.this.refresh(c10002) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (QueueActivity.this.revision == before2) {
                        QueueActivity.this.revision = Long.MIN_VALUE;
                        c10002.label = 5;
                        if (QueueActivity.this.refresh(c10002) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c10003 = c10002;
                    }
                    return Unit.INSTANCE;
                case 2:
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                case 3:
                    c10002 = this;
                    before2 = c10002.J$0;
                    ResultKt.throwOnFailure($result);
                    c10002.J$0 = before2;
                    c10002.label = 4;
                    if (QueueActivity.this.refresh(c10002) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (QueueActivity.this.revision == before2) {
                        QueueActivity.this.revision = Long.MIN_VALUE;
                        c10002.label = 5;
                        if (QueueActivity.this.refresh(c10002) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c10003 = c10002;
                    }
                    return Unit.INSTANCE;
                case 4:
                    c10002 = this;
                    before2 = c10002.J$0;
                    ResultKt.throwOnFailure($result);
                    if (QueueActivity.this.revision == before2) {
                        QueueActivity.this.revision = Long.MIN_VALUE;
                        c10002.label = 5;
                        if (QueueActivity.this.refresh(c10002) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c10003 = c10002;
                    }
                    return Unit.INSTANCE;
                case 5:
                    c10003 = this;
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final void act(String done, boolean relayout, Function1<? super PlayerClient, Unit> action) {
        PlayerClient client = Session.INSTANCE.getClient();
        if (client == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C10001(done, relayout, action, client, null), 3, null);
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.QueueActivity$sendVolume$1 */
    /* JADX INFO: compiled from: QueueActivity.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.QueueActivity$sendVolume$1", m164f = "QueueActivity.kt", m165i = {}, m166l = {845}, m167m = "invokeSuspend", m168n = {}, m169s = {})
    static final class C10181 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PlayerClient $client;
        final /* synthetic */ int $level;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10181(PlayerClient playerClient, int i, Continuation<? super C10181> continuation) {
            super(2, continuation);
            this.$client = playerClient;
            this.$level = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C10181(this.$client, this.$level, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10181) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.QueueActivity$sendVolume$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: QueueActivity.kt */
        @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.QueueActivity$sendVolume$1$1", m164f = "QueueActivity.kt", m165i = {}, m166l = {}, m167m = "invokeSuspend", m168n = {}, m169s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PlayerClient $client;
            final /* synthetic */ int $level;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(PlayerClient playerClient, int i, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$client = playerClient;
                this.$level = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$client, this.$level, continuation);
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
                            this.$client.setVolume(this.$level);
                            break;
                        } catch (Exception e) {
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1(this.$client, this.$level, null), this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendVolume(int level) {
        PlayerClient client = Session.INSTANCE.getClient();
        if (client == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C10181(client, level, null), 3, null);
    }
}
