package com.mattiadoronzo.sonixlink;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import com.mattiadoronzo.sonixlink.databinding.ActivitySearchBinding;
import com.mattiadoronzo.sonixlink.databinding.VolumePillBinding;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: SearchActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u000b\u0018\u0000 =2\u00020\u0001:\u0001=B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0005H\u0002J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"H\u0002J\u0012\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u0010H\u0002J\b\u0010&\u001a\u00020\u0005H\u0016J\u0012\u0010'\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\b\u0010*\u001a\u00020\u0005H\u0014J\u0018\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u0010H\u0002J\u0018\u0010-\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u0010H\u0002J\b\u0010.\u001a\u00020\u0005H\u0014J\b\u0010/\u001a\u00020\u0005H\u0014J\u0010\u00100\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0010H\u0002J$\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\"2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u000503H\u0002J\u0010\u00105\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0010H\u0002J\b\u00106\u001a\u00020\u0005H\u0002J\b\u00107\u001a\u00020\u0005H\u0002J\u0010\u00108\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u0010H\u0002J\u0010\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u000eH\u0002J\b\u0010;\u001a\u00020\u0005H\u0002J\b\u0010<\u001a\u00020\u0005H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000¨\u0006>"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/SearchActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "accentWatch", "Lkotlin/Function0;", "", "adapter", "Lcom/mattiadoronzo/sonixlink/RowAdapter;", "clock", "Landroid/os/Handler;", "followPlaying", "com/mattiadoronzo/sonixlink/SearchActivity$followPlaying$1", "Lcom/mattiadoronzo/sonixlink/SearchActivity$followPlaying$1;", "generation", "", "opened", "Lcom/mattiadoronzo/sonixlink/Row;", "openedIsArtist", "", "runSearch", "Ljava/lang/Runnable;", "views", "Lcom/mattiadoronzo/sonixlink/databinding/ActivitySearchBinding;", "volume", "Lcom/mattiadoronzo/sonixlink/VolumePill;", "actOnSelection", "action", "Lcom/mattiadoronzo/sonixlink/Selection$Action;", "closeCategory", "dispatchKeyEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "header", "label", "", "kindOf", "Lcom/mattiadoronzo/sonixlink/Section;", "row", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onRowClicked", "at", "onRowLongPressed", "onStart", "onStop", "openCategory", "perform", "done", "Lkotlin/Function1;", "Lcom/mattiadoronzo/sonixlink/PlayerClient;", "play", "refreshVolume", "search", "selectable", "sendVolume", "level", "stopSelection", "updateHeader", "Companion", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SearchActivity extends AppCompatActivity {
    private static final long DEBOUNCE_MS = 350;
    private static final long MARK_MS = 1000;
    private static final int PER_CATEGORY = 12;
    private RowAdapter adapter;
    private int generation;
    private Row opened;
    private boolean openedIsArtist;
    private ActivitySearchBinding views;
    private VolumePill volume;
    private final Handler clock = new Handler(Looper.getMainLooper());
    private final Runnable runSearch = new Runnable() { // from class: com.mattiadoronzo.sonixlink.SearchActivity$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            SearchActivity.runSearch$lambda$0(this.f$0);
        }
    };
    private final SearchActivity$followPlaying$1 followPlaying = new SearchActivity$followPlaying$1(this);
    private final Function0<Unit> accentWatch = new Function0<Unit>() { // from class: com.mattiadoronzo.sonixlink.SearchActivity$accentWatch$1
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
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runSearch$lambda$0(SearchActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.search();
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
    protected void onStart() {
        super.onStart();
        Session.INSTANCE.watchAccent(this.accentWatch);
        this.accentWatch.invoke();
        refreshVolume();
        this.followPlaying.run();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        Session.INSTANCE.unwatchAccent(this.accentWatch);
        this.clock.removeCallbacks(this.followPlaying);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySearchBinding activitySearchBindingInflate = ActivitySearchBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activitySearchBindingInflate, "inflate(...)");
        this.views = activitySearchBindingInflate;
        ActivitySearchBinding activitySearchBinding = this.views;
        ActivitySearchBinding activitySearchBinding2 = null;
        if (activitySearchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySearchBinding = null;
        }
        setContentView(activitySearchBinding.getRoot());
        ActivitySearchBinding activitySearchBinding3 = this.views;
        if (activitySearchBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySearchBinding3 = null;
        }
        VolumePillBinding volume = activitySearchBinding3.volume;
        Intrinsics.checkNotNullExpressionValue(volume, "volume");
        this.volume = new VolumePill(volume, new Function1<Integer, Unit>() { // from class: com.mattiadoronzo.sonixlink.SearchActivity.onCreate.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int level) {
                SearchActivity.this.sendVolume(level);
            }
        });
        this.adapter = new RowAdapter(C1020R.drawable.ic_track, null, new Function2<Integer, Row, Unit>() { // from class: com.mattiadoronzo.sonixlink.SearchActivity.onCreate.2
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
                SearchActivity.this.onRowClicked(at, row);
            }
        }, 2, null);
        RowAdapter rowAdapter = this.adapter;
        if (rowAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            rowAdapter = null;
        }
        rowAdapter.setOnLongPress(new Function2<Integer, Row, Unit>() { // from class: com.mattiadoronzo.sonixlink.SearchActivity.onCreate.3
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
                SearchActivity.this.onRowLongPressed(at, row);
            }
        });
        RowAdapter rowAdapter2 = this.adapter;
        if (rowAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            rowAdapter2 = null;
        }
        rowAdapter2.setMarksCategory(new C10274(Playmark.INSTANCE));
        ActivitySearchBinding activitySearchBinding4 = this.views;
        if (activitySearchBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySearchBinding4 = null;
        }
        activitySearchBinding4.list.setLayoutManager(new LinearLayoutManager(this));
        ActivitySearchBinding activitySearchBinding5 = this.views;
        if (activitySearchBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySearchBinding5 = null;
        }
        RecyclerView recyclerView = activitySearchBinding5.list;
        RowAdapter rowAdapter3 = this.adapter;
        if (rowAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            rowAdapter3 = null;
        }
        recyclerView.setAdapter(rowAdapter3);
        ActivitySearchBinding activitySearchBinding6 = this.views;
        if (activitySearchBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySearchBinding6 = null;
        }
        activitySearchBinding6.backButton.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.SearchActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchActivity.onCreate$lambda$1(this.f$0, view);
            }
        });
        ActivitySearchBinding activitySearchBinding7 = this.views;
        if (activitySearchBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySearchBinding7 = null;
        }
        activitySearchBinding7.headerBack.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.SearchActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchActivity.onCreate$lambda$2(this.f$0, view);
            }
        });
        ActivitySearchBinding activitySearchBinding8 = this.views;
        if (activitySearchBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySearchBinding8 = null;
        }
        activitySearchBinding8.selClose.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.SearchActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchActivity.onCreate$lambda$3(this.f$0, view);
            }
        });
        ActivitySearchBinding activitySearchBinding9 = this.views;
        if (activitySearchBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySearchBinding9 = null;
        }
        activitySearchBinding9.selQueue.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.SearchActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchActivity.onCreate$lambda$4(this.f$0, view);
            }
        });
        ActivitySearchBinding activitySearchBinding10 = this.views;
        if (activitySearchBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySearchBinding10 = null;
        }
        activitySearchBinding10.selFavAdd.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.SearchActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchActivity.onCreate$lambda$5(this.f$0, view);
            }
        });
        ActivitySearchBinding activitySearchBinding11 = this.views;
        if (activitySearchBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySearchBinding11 = null;
        }
        activitySearchBinding11.selFavRemove.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.SearchActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchActivity.onCreate$lambda$6(this.f$0, view);
            }
        });
        ActivitySearchBinding activitySearchBinding12 = this.views;
        if (activitySearchBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySearchBinding12 = null;
        }
        activitySearchBinding12.selPlaylistAdd.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.SearchActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchActivity.onCreate$lambda$7(this.f$0, view);
            }
        });
        ActivitySearchBinding activitySearchBinding13 = this.views;
        if (activitySearchBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySearchBinding13 = null;
        }
        activitySearchBinding13.clearButton.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.SearchActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchActivity.onCreate$lambda$8(this.f$0, view);
            }
        });
        ActivitySearchBinding activitySearchBinding14 = this.views;
        if (activitySearchBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySearchBinding14 = null;
        }
        activitySearchBinding14.searchInput.addTextChangedListener(new TextWatcher() { // from class: com.mattiadoronzo.sonixlink.SearchActivity.onCreate.13
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int a, int b, int c) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int a, int b, int c) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                ActivitySearchBinding activitySearchBinding15 = SearchActivity.this.views;
                if (activitySearchBinding15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("views");
                    activitySearchBinding15 = null;
                }
                Editable editable = s;
                activitySearchBinding15.clearButton.setVisibility(editable == null || editable.length() == 0 ? 8 : 0);
                if (SearchActivity.this.opened != null) {
                    SearchActivity.this.opened = null;
                    SearchActivity.this.updateHeader();
                }
                SearchActivity.this.clock.removeCallbacks(SearchActivity.this.runSearch);
                SearchActivity.this.clock.postDelayed(SearchActivity.this.runSearch, SearchActivity.DEBOUNCE_MS);
            }
        });
        ActivitySearchBinding activitySearchBinding15 = this.views;
        if (activitySearchBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySearchBinding15 = null;
        }
        activitySearchBinding15.searchInput.requestFocus();
        ActivitySearchBinding activitySearchBinding16 = this.views;
        if (activitySearchBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
        } else {
            activitySearchBinding2 = activitySearchBinding16;
        }
        activitySearchBinding2.searchInput.post(new Runnable() { // from class: com.mattiadoronzo.sonixlink.SearchActivity$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                SearchActivity.onCreate$lambda$9(this.f$0);
            }
        });
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.SearchActivity$onCreate$4 */
    /* JADX INFO: compiled from: SearchActivity.kt */
    @Metadata(m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* synthetic */ class C10274 extends FunctionReferenceImpl implements Function2<Row, PlayerState, Boolean> {
        C10274(Object obj) {
            super(2, obj, Playmark.class, "byIcon", "byIcon(Lcom/mattiadoronzo/sonixlink/Row;Lcom/mattiadoronzo/sonixlink/PlayerState;)Z", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Boolean invoke(Row p0, PlayerState p1) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            return Boolean.valueOf(((Playmark) this.receiver).byIcon(p0, p1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(SearchActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(SearchActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.closeCategory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(SearchActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.stopSelection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$4(SearchActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.actOnSelection(Selection.Action.QUEUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$5(SearchActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.actOnSelection(Selection.Action.FAVOURITES_ADD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$6(SearchActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.actOnSelection(Selection.Action.FAVOURITES_REMOVE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$7(SearchActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.actOnSelection(Selection.Action.PLAYLIST_ADD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$8(SearchActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivitySearchBinding activitySearchBinding = this$0.views;
        ActivitySearchBinding activitySearchBinding2 = null;
        if (activitySearchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySearchBinding = null;
        }
        activitySearchBinding.searchInput.setText("");
        ActivitySearchBinding activitySearchBinding3 = this$0.views;
        if (activitySearchBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
        } else {
            activitySearchBinding2 = activitySearchBinding3;
        }
        activitySearchBinding2.searchInput.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$9(SearchActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object systemService = this$0.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager manager = (InputMethodManager) systemService;
        ActivitySearchBinding activitySearchBinding = this$0.views;
        if (activitySearchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySearchBinding = null;
        }
        manager.showSoftInput(activitySearchBinding.searchInput, 1);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.clock.removeCallbacks(this.runSearch);
        VolumePill volumePill = this.volume;
        if (volumePill == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volume");
            volumePill = null;
        }
        volumePill.release();
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.SearchActivity$refreshVolume$1 */
    /* JADX INFO: compiled from: SearchActivity.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.SearchActivity$refreshVolume$1", m164f = "SearchActivity.kt", m165i = {}, m166l = {152}, m167m = "invokeSuspend", m168n = {}, m169s = {})
    static final class C10311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PlayerClient $client;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10311(PlayerClient playerClient, Continuation<? super C10311> continuation) {
            super(2, continuation);
            this.$client = playerClient;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C10311(this.$client, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10311) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new SearchActivity$refreshVolume$1$state$1(this.$client, null), this);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objWithContext;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            PlayerState state = (PlayerState) $result;
            if (state == null) {
                return Unit.INSTANCE;
            }
            Session.INSTANCE.setState(state);
            return Unit.INSTANCE;
        }
    }

    private final void refreshVolume() {
        PlayerClient client = Session.INSTANCE.getClient();
        if (client == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C10311(client, null), 3, null);
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.SearchActivity$sendVolume$1 */
    /* JADX INFO: compiled from: SearchActivity.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.SearchActivity$sendVolume$1", m164f = "SearchActivity.kt", m165i = {}, m166l = {167}, m167m = "invokeSuspend", m168n = {}, m169s = {})
    static final class C10331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PlayerClient $client;
        final /* synthetic */ int $level;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10331(PlayerClient playerClient, int i, Continuation<? super C10331> continuation) {
            super(2, continuation);
            this.$client = playerClient;
            this.$level = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C10331(this.$client, this.$level, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10331) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.SearchActivity$sendVolume$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: SearchActivity.kt */
        @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.SearchActivity$sendVolume$1$1", m164f = "SearchActivity.kt", m165i = {}, m166l = {}, m167m = "invokeSuspend", m168n = {}, m169s = {})
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
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C10331(client, level, null), 3, null);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        RowAdapter rowAdapter = this.adapter;
        if (rowAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            rowAdapter = null;
        }
        if (rowAdapter.getSelecting()) {
            stopSelection();
        } else if (this.opened != null) {
            closeCategory();
        } else {
            super.onBackPressed();
        }
    }

    private final void search() {
        ActivitySearchBinding activitySearchBinding = this.views;
        ActivitySearchBinding activitySearchBinding2 = null;
        if (activitySearchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySearchBinding = null;
        }
        Editable text = activitySearchBinding.searchInput.getText();
        String string = text != null ? text.toString() : null;
        if (string == null) {
            string = "";
        }
        String text2 = StringsKt.trim((CharSequence) string).toString();
        Library library = Session.INSTANCE.getLibrary();
        if ((text2.length() == 0) || library == null) {
            RowAdapter rowAdapter = this.adapter;
            if (rowAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                rowAdapter = null;
            }
            rowAdapter.submit(CollectionsKt.emptyList());
            ActivitySearchBinding activitySearchBinding3 = this.views;
            if (activitySearchBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("views");
            } else {
                activitySearchBinding2 = activitySearchBinding3;
            }
            activitySearchBinding2.emptyText.setVisibility(8);
            return;
        }
        this.generation++;
        int mine = this.generation;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C10321(mine, this, library, text2, null), 3, null);
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.SearchActivity$search$1 */
    /* JADX INFO: compiled from: SearchActivity.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.SearchActivity$search$1", m164f = "SearchActivity.kt", m165i = {}, m166l = {202}, m167m = "invokeSuspend", m168n = {}, m169s = {})
    static final class C10321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Library $library;
        final /* synthetic */ int $mine;
        final /* synthetic */ String $text;
        int label;
        final /* synthetic */ SearchActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10321(int i, SearchActivity searchActivity, Library library, String str, Continuation<? super C10321> continuation) {
            super(2, continuation);
            this.$mine = i;
            this.this$0 = searchActivity;
            this.$library = library;
            this.$text = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C10321(this.$mine, this.this$0, this.$library, this.$text, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10321) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            C10321 c10321;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ActivitySearchBinding activitySearchBinding = null;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c10321 = this;
                    c10321.label = 1;
                    Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new SearchActivity$search$1$rows$1(c10321.$library, c10321.$text, c10321.this$0, null), c10321);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objWithContext;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    c10321 = this;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ArrayList rows = (ArrayList) $result;
            if (c10321.$mine != c10321.this$0.generation) {
                return Unit.INSTANCE;
            }
            RowAdapter rowAdapter = c10321.this$0.adapter;
            if (rowAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                rowAdapter = null;
            }
            rowAdapter.submit(rows);
            c10321.this$0.updateHeader();
            ActivitySearchBinding activitySearchBinding2 = c10321.this$0.views;
            if (activitySearchBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("views");
                activitySearchBinding2 = null;
            }
            activitySearchBinding2.list.scrollToPosition(0);
            ActivitySearchBinding activitySearchBinding3 = c10321.this$0.views;
            if (activitySearchBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("views");
            } else {
                activitySearchBinding = activitySearchBinding3;
            }
            activitySearchBinding.emptyText.setVisibility(rows.isEmpty() ? 0 : 8);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Row header(String label) {
        return new Row(label, "", null, null, 0, null, null, 0L, 0L, Row.Kind.HEADER, null, 0, 3580, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onRowClicked(int at, Row row) {
        RowAdapter rowAdapter = this.adapter;
        RowAdapter rowAdapter2 = null;
        if (rowAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            rowAdapter = null;
        }
        if (rowAdapter.getSelecting()) {
            if (selectable(row)) {
                RowAdapter rowAdapter3 = this.adapter;
                if (rowAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    rowAdapter2 = rowAdapter3;
                }
                if (rowAdapter2.toggle(at) == 0) {
                    stopSelection();
                    return;
                } else {
                    updateHeader();
                    return;
                }
            }
            return;
        }
        if (row.getKind() != Row.Kind.HEADER) {
            if (!row.isTrack()) {
                openCategory(row);
            } else if (Session.INSTANCE.getClient() != null) {
                play(row);
            }
        }
    }

    private final void play(Row row) {
        String list;
        Row category = this.opened;
        if (category == null) {
            list = "all";
        } else {
            list = this.openedIsArtist ? "artist" : "album";
        }
        String value = category != null ? category.getFilter() : null;
        if (value == null) {
            value = "";
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C10301(row, list, value, null), 3, null);
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.SearchActivity$play$1 */
    /* JADX INFO: compiled from: SearchActivity.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.SearchActivity$play$1", m164f = "SearchActivity.kt", m165i = {}, m166l = {256}, m167m = "invokeSuspend", m168n = {}, m169s = {})
    static final class C10301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $list;
        final /* synthetic */ Row $row;
        final /* synthetic */ String $value;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10301(Row row, String str, String str2, Continuation<? super C10301> continuation) {
            super(2, continuation);
            this.$row = row;
            this.$list = str;
            this.$value = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C10301(this.$row, this.$list, this.$value, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10301) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.SearchActivity$play$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: SearchActivity.kt */
        @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.SearchActivity$play$1$1", m164f = "SearchActivity.kt", m165i = {}, m166l = {}, m167m = "invokeSuspend", m168n = {}, m169s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $list;
            final /* synthetic */ Row $row;
            final /* synthetic */ String $value;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Row row, String str, String str2, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$row = row;
                this.$list = str;
                this.$value = str2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$row, this.$list, this.$value, continuation);
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
                            PlayerClient client = Session.INSTANCE.getClient();
                            if (client != null) {
                                client.playPath(this.$row.getPath(), this.$list, this.$value);
                            }
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
                    if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1(this.$row, this.$list, this.$value, null), this) == coroutine_suspended) {
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

    private final void openCategory(Row row) {
        Library library = Session.INSTANCE.getLibrary();
        if (library == null) {
            return;
        }
        this.generation++;
        int mine = this.generation;
        this.openedIsArtist = row.getAlbum().length() == 0;
        this.opened = row;
        updateHeader();
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C10281(mine, this, library, row, null), 3, null);
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.SearchActivity$openCategory$1 */
    /* JADX INFO: compiled from: SearchActivity.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.SearchActivity$openCategory$1", m164f = "SearchActivity.kt", m165i = {}, m166l = {275}, m167m = "invokeSuspend", m168n = {}, m169s = {})
    static final class C10281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Library $library;
        final /* synthetic */ int $mine;
        final /* synthetic */ Row $row;
        int label;
        final /* synthetic */ SearchActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10281(int i, SearchActivity searchActivity, Library library, Row row, Continuation<? super C10281> continuation) {
            super(2, continuation);
            this.$mine = i;
            this.this$0 = searchActivity;
            this.$library = library;
            this.$row = row;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C10281(this.$mine, this.this$0, this.$library, this.$row, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10281) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            C10281 c10281;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ActivitySearchBinding activitySearchBinding = null;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c10281 = this;
                    c10281.label = 1;
                    Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new SearchActivity$openCategory$1$rows$1(c10281.this$0, c10281.$library, c10281.$row, null), c10281);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objWithContext;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    c10281 = this;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            List<Row> list = (List) $result;
            if (c10281.$mine != c10281.this$0.generation) {
                return Unit.INSTANCE;
            }
            RowAdapter rowAdapter = c10281.this$0.adapter;
            if (rowAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                rowAdapter = null;
            }
            rowAdapter.submit(list);
            c10281.this$0.updateHeader();
            ActivitySearchBinding activitySearchBinding2 = c10281.this$0.views;
            if (activitySearchBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("views");
                activitySearchBinding2 = null;
            }
            activitySearchBinding2.list.scrollToPosition(0);
            ActivitySearchBinding activitySearchBinding3 = c10281.this$0.views;
            if (activitySearchBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("views");
            } else {
                activitySearchBinding = activitySearchBinding3;
            }
            activitySearchBinding.emptyText.setVisibility(list.isEmpty() ? 0 : 8);
            return Unit.INSTANCE;
        }
    }

    private final void closeCategory() {
        this.opened = null;
        updateHeader();
        search();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateHeader() {
        String title;
        RowAdapter rowAdapter = this.adapter;
        ActivitySearchBinding activitySearchBinding = null;
        if (rowAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            rowAdapter = null;
        }
        boolean selecting = rowAdapter.getSelecting();
        Row category = this.opened;
        ActivitySearchBinding activitySearchBinding2 = this.views;
        if (activitySearchBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySearchBinding2 = null;
        }
        activitySearchBinding2.headerBack.setVisibility((selecting || category == null) ? 8 : 0);
        ActivitySearchBinding activitySearchBinding3 = this.views;
        if (activitySearchBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySearchBinding3 = null;
        }
        TextView textView = activitySearchBinding3.headerTitle;
        if (selecting) {
            int i = C1020R.string.selected_count;
            RowAdapter rowAdapter2 = this.adapter;
            if (rowAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                rowAdapter2 = null;
            }
            title = getString(i, new Object[]{Integer.valueOf(rowAdapter2.getSelected().size())});
        } else {
            title = category != null ? category.getTitle() : "";
        }
        textView.setText(title);
        ImageButton[] imageButtonArr = new ImageButton[5];
        ActivitySearchBinding activitySearchBinding4 = this.views;
        if (activitySearchBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySearchBinding4 = null;
        }
        imageButtonArr[0] = activitySearchBinding4.selQueue;
        ActivitySearchBinding activitySearchBinding5 = this.views;
        if (activitySearchBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySearchBinding5 = null;
        }
        imageButtonArr[1] = activitySearchBinding5.selFavAdd;
        ActivitySearchBinding activitySearchBinding6 = this.views;
        if (activitySearchBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySearchBinding6 = null;
        }
        imageButtonArr[2] = activitySearchBinding6.selFavRemove;
        ActivitySearchBinding activitySearchBinding7 = this.views;
        if (activitySearchBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySearchBinding7 = null;
        }
        imageButtonArr[3] = activitySearchBinding7.selPlaylistAdd;
        ActivitySearchBinding activitySearchBinding8 = this.views;
        if (activitySearchBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySearchBinding8 = null;
        }
        imageButtonArr[4] = activitySearchBinding8.selClose;
        Iterable $this$forEach$iv = CollectionsKt.listOf((Object[]) imageButtonArr);
        for (Object element$iv : $this$forEach$iv) {
            ImageButton it = (ImageButton) element$iv;
            it.setVisibility(selecting ? 0 : 8);
        }
        ActivitySearchBinding activitySearchBinding9 = this.views;
        if (activitySearchBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
        } else {
            activitySearchBinding = activitySearchBinding9;
        }
        activitySearchBinding.header.setVisibility((selecting || category != null) ? 0 : 8);
    }

    private final boolean selectable(Row row) {
        if (row.getKind() != Row.Kind.ROW) {
            return false;
        }
        if (!row.isTrack()) {
            if (!(row.getFilter().length() > 0)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onRowLongPressed(int at, Row row) {
        RowAdapter rowAdapter = this.adapter;
        RowAdapter rowAdapter2 = null;
        if (rowAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            rowAdapter = null;
        }
        if (rowAdapter.getSelecting()) {
            onRowClicked(at, row);
            return;
        }
        if (selectable(row)) {
            RowAdapter rowAdapter3 = this.adapter;
            if (rowAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                rowAdapter2 = rowAdapter3;
            }
            rowAdapter2.startSelection(at);
            updateHeader();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopSelection() {
        RowAdapter rowAdapter = this.adapter;
        if (rowAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            rowAdapter = null;
        }
        rowAdapter.stopSelection();
        updateHeader();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Section kindOf(Row row) {
        int iconRes = row.getIconRes();
        if (iconRes == C1020R.drawable.ic_album) {
            return Section.ALBUMS;
        }
        if (iconRes == C1020R.drawable.ic_artist) {
            return Section.ARTISTS;
        }
        return null;
    }

    private final void actOnSelection(Selection.Action action) {
        RowAdapter rowAdapter = this.adapter;
        if (rowAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            rowAdapter = null;
        }
        Iterable $this$mapNotNull$iv = rowAdapter.getSelected();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            int it = ((Number) element$iv$iv$iv).intValue();
            RowAdapter rowAdapter2 = this.adapter;
            if (rowAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                rowAdapter2 = null;
            }
            Row rowRowAt = rowAdapter2.rowAt(it);
            if (rowRowAt != null) {
                destination$iv$iv.add(rowRowAt);
            }
        }
        List rows = (List) destination$iv$iv;
        if (rows.isEmpty()) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C10211(action, this, rows, null), 3, null);
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.SearchActivity$actOnSelection$1 */
    /* JADX INFO: compiled from: SearchActivity.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.SearchActivity$actOnSelection$1", m164f = "SearchActivity.kt", m165i = {}, m166l = {344}, m167m = "invokeSuspend", m168n = {}, m169s = {})
    static final class C10211 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Selection.Action $action;
        final /* synthetic */ List<Row> $rows;
        int label;
        final /* synthetic */ SearchActivity this$0;

        /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.SearchActivity$actOnSelection$1$WhenMappings */
        /* JADX INFO: compiled from: SearchActivity.kt */
        @Metadata(m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Selection.Action.values().length];
                try {
                    iArr[Selection.Action.QUEUE.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[Selection.Action.FAVOURITES_ADD.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[Selection.Action.FAVOURITES_REMOVE.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[Selection.Action.PLAYLIST_ADD.ordinal()] = 4;
                } catch (NoSuchFieldError e4) {
                }
                try {
                    iArr[Selection.Action.PLAYLIST_REMOVE.ordinal()] = 5;
                } catch (NoSuchFieldError e5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10211(Selection.Action action, SearchActivity searchActivity, List<Row> list, Continuation<? super C10211> continuation) {
            super(2, continuation);
            this.$action = action;
            this.this$0 = searchActivity;
            this.$rows = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C10211(this.$action, this.this$0, this.$rows, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10211) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            C10211 c10211;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c10211 = this;
                    c10211.label = 1;
                    Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new SearchActivity$actOnSelection$1$paths$1(c10211.$rows, c10211.this$0, null), c10211);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objWithContext;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    c10211 = this;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            final List paths = (List) $result;
            if (paths.isEmpty()) {
                return Unit.INSTANCE;
            }
            switch (WhenMappings.$EnumSwitchMapping$0[c10211.$action.ordinal()]) {
                case 1:
                    c10211.this$0.stopSelection();
                    SearchActivity searchActivity = c10211.this$0;
                    String string = c10211.this$0.getString(C1020R.string.done_queue);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    searchActivity.perform(string, new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.SearchActivity.actOnSelection.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(PlayerClient playerClient) throws Exception {
                            invoke2(playerClient);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(PlayerClient it) throws Exception {
                            Intrinsics.checkNotNullParameter(it, "it");
                            PlayerClient.selection$default(it, "queue_next", paths, null, 4, null);
                        }
                    });
                    break;
                case 2:
                    c10211.this$0.stopSelection();
                    SearchActivity searchActivity2 = c10211.this$0;
                    String string2 = c10211.this$0.getString(C1020R.string.done_fav);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    searchActivity2.perform(string2, new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.SearchActivity.actOnSelection.1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(PlayerClient playerClient) throws Exception {
                            invoke2(playerClient);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(PlayerClient it) throws Exception {
                            Intrinsics.checkNotNullParameter(it, "it");
                            PlayerClient.selection$default(it, "favourites_add", paths, null, 4, null);
                        }
                    });
                    break;
                case 3:
                    c10211.this$0.stopSelection();
                    SearchActivity searchActivity3 = c10211.this$0;
                    String string3 = c10211.this$0.getString(C1020R.string.done_removed);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    searchActivity3.perform(string3, new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.SearchActivity.actOnSelection.1.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(PlayerClient playerClient) throws Exception {
                            invoke2(playerClient);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(PlayerClient it) throws Exception {
                            Intrinsics.checkNotNullParameter(it, "it");
                            PlayerClient.selection$default(it, "favourites_remove", paths, null, 4, null);
                        }
                    });
                    break;
                case 4:
                    Selection selection = Selection.INSTANCE;
                    SearchActivity searchActivity4 = c10211.this$0;
                    LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(c10211.this$0);
                    final SearchActivity searchActivity5 = c10211.this$0;
                    selection.pickPlaylist(searchActivity4, lifecycleScope, new Function1<String, Unit>() { // from class: com.mattiadoronzo.sonixlink.SearchActivity.actOnSelection.1.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(String str) {
                            invoke2(str);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(final String name) {
                            Intrinsics.checkNotNullParameter(name, "name");
                            searchActivity5.stopSelection();
                            SearchActivity searchActivity6 = searchActivity5;
                            String string4 = searchActivity5.getString(C1020R.string.done_playlist);
                            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                            final List<String> list = paths;
                            searchActivity6.perform(string4, new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.SearchActivity.actOnSelection.1.4.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(PlayerClient playerClient) throws Exception {
                                    invoke2(playerClient);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(PlayerClient it) throws Exception {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    it.selection("playlist_add", list, name);
                                }
                            });
                        }
                    });
                    break;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.SearchActivity$perform$1 */
    /* JADX INFO: compiled from: SearchActivity.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.SearchActivity$perform$1", m164f = "SearchActivity.kt", m165i = {}, m166l = {379}, m167m = "invokeSuspend", m168n = {}, m169s = {})
    static final class C10291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<PlayerClient, Unit> $action;
        final /* synthetic */ PlayerClient $client;
        final /* synthetic */ String $done;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C10291(String str, Function1<? super PlayerClient, Unit> function1, PlayerClient playerClient, Continuation<? super C10291> continuation) {
            super(2, continuation);
            this.$done = str;
            this.$action = function1;
            this.$client = playerClient;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SearchActivity.this.new C10291(this.$done, this.$action, this.$client, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10291) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            C10291 c10291;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ActivitySearchBinding activitySearchBinding = null;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c10291 = this;
                    c10291.label = 1;
                    Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new SearchActivity$perform$1$failed$1(c10291.$action, c10291.$client, null), c10291);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objWithContext;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    c10291 = this;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean failed = ((Boolean) $result).booleanValue();
            String string = failed ? SearchActivity.this.getString(C1020R.string.command_failed) : c10291.$done;
            Intrinsics.checkNotNull(string);
            String message = string;
            ActivitySearchBinding activitySearchBinding2 = SearchActivity.this.views;
            if (activitySearchBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("views");
            } else {
                activitySearchBinding = activitySearchBinding2;
            }
            Snackbar.make(activitySearchBinding.getRoot(), message, 0).show();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void perform(String done, Function1<? super PlayerClient, Unit> action) {
        PlayerClient client = Session.INSTANCE.getClient();
        if (client == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C10291(done, action, client, null), 3, null);
    }
}
