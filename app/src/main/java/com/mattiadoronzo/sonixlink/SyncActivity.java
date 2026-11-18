package com.mattiadoronzo.sonixlink;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.location.LocationRequestCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import com.mattiadoronzo.sonixlink.databinding.ActivitySyncBinding;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: SyncActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002J\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\nH\u0002J\u001e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010\u001bJ\u001e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/SyncActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "client", "Lcom/mattiadoronzo/sonixlink/PlayerClient;", "playerName", "", "views", "Lcom/mattiadoronzo/sonixlink/databinding/ActivitySyncBinding;", "backToConnect", "", "done", "failed", "message", "hideAmount", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showAmount", "", "total", "start", "syncCovers", "info", "Lcom/mattiadoronzo/sonixlink/PlayerInfo;", SyncActivity.EXTRA_FORCE, "", "(Lcom/mattiadoronzo/sonixlink/PlayerInfo;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncLibrary", "Companion", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SyncActivity extends AppCompatActivity {
    public static final String EXTRA_FORCE = "force";
    public static final String EXTRA_HOST = "host";
    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_PORT = "port";
    private PlayerClient client;
    private String playerName = "";
    private ActivitySyncBinding views;

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.SyncActivity$syncCovers$1 */
    /* JADX INFO: compiled from: SyncActivity.kt */
    @Metadata(m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.SyncActivity", m164f = "SyncActivity.kt", m165i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4}, m166l = {143, 148, 152, 156, 164, 181}, m167m = "syncCovers", m168n = {"this", "info", "covers", SyncActivity.EXTRA_FORCE, "this", "info", "covers", SyncActivity.EXTRA_FORCE, "this", "info", "covers", "owner", "this", "info", "covers", "owner", "covers"}, m169s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0"})
    static final class C10361 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C10361(Continuation<? super C10361> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SyncActivity.this.syncCovers(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.SyncActivity$syncLibrary$1 */
    /* JADX INFO: compiled from: SyncActivity.kt */
    @Metadata(m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.SyncActivity", m164f = "SyncActivity.kt", m165i = {0, 0, 0, 0, 1, 1, 1, 1, 2}, m166l = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, 116, 130, 133}, m167m = "syncLibrary", m168n = {"this", "info", "library", SyncActivity.EXTRA_FORCE, "this", "info", "library", "owner", "library"}, m169s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$0"})
    static final class C10421 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C10421(Continuation<? super C10421> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SyncActivity.this.syncLibrary(null, false, this);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySyncBinding activitySyncBindingInflate = ActivitySyncBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activitySyncBindingInflate, "inflate(...)");
        this.views = activitySyncBindingInflate;
        ActivitySyncBinding activitySyncBinding = this.views;
        ActivitySyncBinding activitySyncBinding2 = null;
        if (activitySyncBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySyncBinding = null;
        }
        setContentView(activitySyncBinding.getRoot());
        String host = getIntent().getStringExtra("host");
        if (host == null) {
            host = "";
        }
        int port = getIntent().getIntExtra("port", PlayerClient.DEFAULT_PORT);
        String stringExtra = getIntent().getStringExtra("name");
        String str = stringExtra != null ? stringExtra : "";
        if (str.length() == 0) {
            str = host;
        }
        this.playerName = str;
        if (host.length() == 0) {
            backToConnect();
            return;
        }
        this.client = new PlayerClient(host, port);
        Session session = Session.INSTANCE;
        PlayerClient playerClient = this.client;
        if (playerClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("client");
            playerClient = null;
        }
        session.setClient(playerClient);
        String it = Settings.INSTANCE.accent(this);
        if (!(it.length() > 0)) {
            it = null;
        }
        if (it != null) {
            Session.INSTANCE.setAccent(Session.INSTANCE.parseAccent(it));
        }
        Library library = Session.INSTANCE.getLibrary();
        if (library != null) {
            library.close();
        }
        Covers covers = Session.INSTANCE.getCovers();
        if (covers != null) {
            covers.close();
        }
        Session.INSTANCE.setLibrary(new Library(this));
        Session.INSTANCE.setCovers(new Covers(this));
        ActivitySyncBinding activitySyncBinding3 = this.views;
        if (activitySyncBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
        } else {
            activitySyncBinding2 = activitySyncBinding3;
        }
        activitySyncBinding2.retryButton.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.SyncActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SyncActivity.onCreate$lambda$3(this.f$0, view);
            }
        });
        start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(SyncActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.start();
    }

    private final void start() {
        boolean force = getIntent().getBooleanExtra(EXTRA_FORCE, false);
        ActivitySyncBinding activitySyncBinding = this.views;
        if (activitySyncBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySyncBinding = null;
        }
        activitySyncBinding.retryButton.setVisibility(8);
        ActivitySyncBinding activitySyncBinding2 = this.views;
        if (activitySyncBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySyncBinding2 = null;
        }
        activitySyncBinding2.syncProgress.setVisibility(0);
        ActivitySyncBinding activitySyncBinding3 = this.views;
        if (activitySyncBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySyncBinding3 = null;
        }
        activitySyncBinding3.syncText.setText(C1020R.string.syncing);
        ActivitySyncBinding activitySyncBinding4 = this.views;
        if (activitySyncBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySyncBinding4 = null;
        }
        activitySyncBinding4.syncDetail.setText("");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C10351(force, null), 3, null);
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.SyncActivity$start$1 */
    /* JADX INFO: compiled from: SyncActivity.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.SyncActivity$start$1", m164f = "SyncActivity.kt", m165i = {1, 2}, m166l = {Covers.BOX, 90, 94, LocationRequestCompat.QUALITY_HIGH_ACCURACY}, m167m = "invokeSuspend", m168n = {"info", "info"}, m169s = {"L$0", "L$0"})
    static final class C10351 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $force;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10351(boolean z, Continuation<? super C10351> continuation) {
            super(2, continuation);
            this.$force = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SyncActivity.this.new C10351(this.$force, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10351) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0060  */
        /* JADX WARN: Code duplicated, block: B:18:0x0073  */
        /* JADX WARN: Code duplicated, block: B:20:0x0079  */
        /* JADX WARN: Code duplicated, block: B:22:0x008c  */
        /* JADX WARN: Code duplicated, block: B:24:0x0092  */
        /* JADX WARN: Code duplicated, block: B:27:0x00aa A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:28:0x00ab  */
        /* JADX WARN: Code duplicated, block: B:31:0x00b6  */
        /* JADX WARN: Code duplicated, block: B:33:0x00c9  */
        /* JADX WARN: Code duplicated, block: B:35:0x00db A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:36:0x00dc  */
        /* JADX WARN: Code duplicated, block: B:40:0x00ec  */
        /* JADX WARN: Code duplicated, block: B:42:0x00ef  */
        /* JADX WARN: Code duplicated, block: B:44:0x011b A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:45:0x011c  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            C10351 c10351;
            PlayerInfo info;
            SortPrefs it;
            Object objSyncLibrary;
            PlayerInfo info2;
            C10351 c10352;
            PlayerInfo info3;
            C10351 c10353;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new SyncActivity$start$1$info$1(SyncActivity.this, null), this);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objWithContext;
                    c10351 = this;
                    info = (PlayerInfo) $result;
                    if (info == null) {
                        SyncActivity syncActivity = SyncActivity.this;
                        String string = SyncActivity.this.getString(C1020R.string.sync_unreachable);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        syncActivity.failed(string);
                        return Unit.INSTANCE;
                    }
                    if (info.getScanning()) {
                        SyncActivity syncActivity2 = SyncActivity.this;
                        String string2 = SyncActivity.this.getString(C1020R.string.scanning_wait);
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        syncActivity2.failed(string2);
                        return Unit.INSTANCE;
                    }
                    it = info.getSort();
                    if (it != null) {
                        Session.INSTANCE.setSort(it);
                    }
                    c10351.L$0 = info;
                    c10351.label = 2;
                    objSyncLibrary = SyncActivity.this.syncLibrary(info, c10351.$force, c10351);
                    if (objSyncLibrary == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    info2 = info;
                    $result = objSyncLibrary;
                    if (!((Boolean) $result).booleanValue()) {
                        SyncActivity syncActivity3 = SyncActivity.this;
                        String string3 = SyncActivity.this.getString(C1020R.string.sync_no_library);
                        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                        syncActivity3.failed(string3);
                        return Unit.INSTANCE;
                    }
                    c10351.L$0 = info2;
                    c10351.label = 3;
                    if (SyncActivity.this.syncCovers(info2, c10351.$force, c10351) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c10352 = c10351;
                    info3 = info2;
                    if (info3.getAccent().length() > 0) {
                        Session.INSTANCE.setAccent(Session.INSTANCE.parseAccent(info3.getAccent()));
                        c10352.L$0 = null;
                        c10352.label = 4;
                        if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(SyncActivity.this, info3, null), c10352) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c10353 = c10352;
                        c10352 = c10353;
                    }
                    SyncActivity.this.done();
                    return Unit.INSTANCE;
                case 1:
                    ResultKt.throwOnFailure($result);
                    c10351 = this;
                    info = (PlayerInfo) $result;
                    if (info == null) {
                        SyncActivity syncActivity4 = SyncActivity.this;
                        String string4 = SyncActivity.this.getString(C1020R.string.sync_unreachable);
                        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                        syncActivity4.failed(string4);
                        return Unit.INSTANCE;
                    }
                    if (info.getScanning()) {
                        SyncActivity syncActivity5 = SyncActivity.this;
                        String string5 = SyncActivity.this.getString(C1020R.string.scanning_wait);
                        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                        syncActivity5.failed(string5);
                        return Unit.INSTANCE;
                    }
                    it = info.getSort();
                    if (it != null) {
                        Session.INSTANCE.setSort(it);
                    }
                    c10351.L$0 = info;
                    c10351.label = 2;
                    objSyncLibrary = SyncActivity.this.syncLibrary(info, c10351.$force, c10351);
                    if (objSyncLibrary == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    info2 = info;
                    $result = objSyncLibrary;
                    if (!((Boolean) $result).booleanValue()) {
                        SyncActivity syncActivity6 = SyncActivity.this;
                        String string6 = SyncActivity.this.getString(C1020R.string.sync_no_library);
                        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                        syncActivity6.failed(string6);
                        return Unit.INSTANCE;
                    }
                    c10351.L$0 = info2;
                    c10351.label = 3;
                    if (SyncActivity.this.syncCovers(info2, c10351.$force, c10351) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c10352 = c10351;
                    info3 = info2;
                    if (info3.getAccent().length() > 0) {
                        Session.INSTANCE.setAccent(Session.INSTANCE.parseAccent(info3.getAccent()));
                        c10352.L$0 = null;
                        c10352.label = 4;
                        if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(SyncActivity.this, info3, null), c10352) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c10353 = c10352;
                        c10352 = c10353;
                    }
                    SyncActivity.this.done();
                    return Unit.INSTANCE;
                case 2:
                    PlayerInfo info4 = (PlayerInfo) this.L$0;
                    ResultKt.throwOnFailure($result);
                    info2 = info4;
                    c10351 = this;
                    $result = $result;
                    if (!((Boolean) $result).booleanValue()) {
                        SyncActivity syncActivity7 = SyncActivity.this;
                        String string7 = SyncActivity.this.getString(C1020R.string.sync_no_library);
                        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                        syncActivity7.failed(string7);
                        return Unit.INSTANCE;
                    }
                    c10351.L$0 = info2;
                    c10351.label = 3;
                    if (SyncActivity.this.syncCovers(info2, c10351.$force, c10351) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c10352 = c10351;
                    info3 = info2;
                    if (info3.getAccent().length() > 0) {
                        Session.INSTANCE.setAccent(Session.INSTANCE.parseAccent(info3.getAccent()));
                        c10352.L$0 = null;
                        c10352.label = 4;
                        if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(SyncActivity.this, info3, null), c10352) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c10353 = c10352;
                        c10352 = c10353;
                    }
                    SyncActivity.this.done();
                    return Unit.INSTANCE;
                case 3:
                    c10352 = this;
                    info3 = (PlayerInfo) c10352.L$0;
                    ResultKt.throwOnFailure($result);
                    if (info3.getAccent().length() > 0) {
                        Session.INSTANCE.setAccent(Session.INSTANCE.parseAccent(info3.getAccent()));
                        c10352.L$0 = null;
                        c10352.label = 4;
                        if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(SyncActivity.this, info3, null), c10352) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c10353 = c10352;
                        c10352 = c10353;
                    }
                    SyncActivity.this.done();
                    return Unit.INSTANCE;
                case 4:
                    c10353 = this;
                    ResultKt.throwOnFailure($result);
                    c10352 = c10353;
                    SyncActivity.this.done();
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.SyncActivity$start$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: SyncActivity.kt */
        @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.SyncActivity$start$1$2", m164f = "SyncActivity.kt", m165i = {}, m166l = {}, m167m = "invokeSuspend", m168n = {}, m169s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PlayerInfo $info;
            int label;
            final /* synthetic */ SyncActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(SyncActivity syncActivity, PlayerInfo playerInfo, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = syncActivity;
                this.$info = playerInfo;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$info, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        Settings.INSTANCE.rememberAccent(this.this$0, this.$info.getAccent());
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:26:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:35:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:44:0x0101  */
    /* JADX WARN: Code duplicated, block: B:47:0x0133 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:48:0x0134  */
    /* JADX WARN: Code duplicated, block: B:51:0x0141  */
    /* JADX WARN: Code duplicated, block: B:53:0x015f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:54:0x0160  */
    /* JADX WARN: Code duplicated, block: B:56:0x0163  */
    /* JADX WARN: Code duplicated, block: B:59:0x0182 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object syncLibrary(PlayerInfo playerInfo, boolean force, Continuation<? super Boolean> continuation) throws Throwable {
        C10421 c10421;
        PlayerInfo info;
        Library library;
        Object objWithContext;
        SyncActivity syncActivity;
        boolean force2;
        String stampOwner;
        PlayerClient playerClient;
        String owner;
        boolean z;
        ActivitySyncBinding activitySyncBinding;
        Object objWithContext2;
        PlayerInfo info2;
        Library library2;
        boolean ok;
        CoroutineDispatcher io;
        C10443 c10443;
        Library library3;
        Object objWithContext3;
        if (continuation instanceof C10421) {
            C10421 c10422 = (C10421) continuation;
            if ((c10422.label & Integer.MIN_VALUE) != 0) {
                c10422.label -= Integer.MIN_VALUE;
                c10421 = c10422;
            } else {
                c10421 = new C10421(continuation);
            }
        } else {
            c10421 = new C10421(continuation);
        }
        Object $result = c10421.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c10421.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                info = playerInfo;
                library = Session.INSTANCE.getLibrary();
                if (library == null) {
                    return Boxing.boxBoolean(false);
                }
                CoroutineDispatcher io2 = Dispatchers.getIO();
                C10432 c10432 = new C10432(null);
                c10421.L$0 = this;
                c10421.L$1 = info;
                c10421.L$2 = library;
                c10421.Z$0 = force;
                c10421.label = 1;
                objWithContext = BuildersKt.withContext(io2, c10432, c10421);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                syncActivity = this;
                force2 = force;
                Pair pair = (Pair) objWithContext;
                stampOwner = (String) pair.component1();
                String stampVersion = (String) pair.component2();
                playerClient = syncActivity.client;
                if (playerClient == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("client");
                    playerClient = null;
                }
                owner = info.identity(playerClient.getHost());
                if (Intrinsics.areEqual(stampOwner, owner) || !Intrinsics.areEqual(stampVersion, info.getDbVersion()) || info.getDbMtime() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                boolean stale = z;
                if (info.getDbAvailable() && (force2 || stale || !library.getExists())) {
                    activitySyncBinding = syncActivity.views;
                    if (activitySyncBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("views");
                        activitySyncBinding = null;
                    }
                    activitySyncBinding.syncDetail.setText(C1020R.string.sync_library);
                    syncActivity.showAmount(0L, info.getDbSize());
                    CoroutineDispatcher io3 = Dispatchers.getIO();
                    SyncActivity$syncLibrary$ok$1 syncActivity$syncLibrary$ok$1 = new SyncActivity$syncLibrary$ok$1(library, syncActivity, info, null);
                    c10421.L$0 = syncActivity;
                    c10421.L$1 = info;
                    c10421.L$2 = library;
                    c10421.L$3 = owner;
                    c10421.label = 2;
                    objWithContext2 = BuildersKt.withContext(io3, syncActivity$syncLibrary$ok$1, c10421);
                    if (objWithContext2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    info2 = info;
                    library2 = library;
                    ok = ((Boolean) objWithContext2).booleanValue();
                    syncActivity.hideAmount();
                    if (ok) {
                        io = Dispatchers.getIO();
                        c10443 = syncActivity.new C10443(owner, info2, null);
                        c10421.L$0 = library2;
                        c10421.L$1 = null;
                        c10421.L$2 = null;
                        c10421.L$3 = null;
                        c10421.label = 3;
                        if (BuildersKt.withContext(io, c10443, c10421) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        library3 = library2;
                        library = library3;
                    } else {
                        library = library2;
                    }
                }
                CoroutineDispatcher io4 = Dispatchers.getIO();
                C10454 c10454 = new C10454(library, null);
                c10421.L$0 = null;
                c10421.L$1 = null;
                c10421.L$2 = null;
                c10421.L$3 = null;
                c10421.label = 4;
                objWithContext3 = BuildersKt.withContext(io4, c10454, c10421);
                if (objWithContext3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objWithContext3;
            case 1:
                force2 = c10421.Z$0;
                Library library4 = (Library) c10421.L$2;
                info = (PlayerInfo) c10421.L$1;
                SyncActivity syncActivity2 = (SyncActivity) c10421.L$0;
                ResultKt.throwOnFailure($result);
                objWithContext = $result;
                library = library4;
                syncActivity = syncActivity2;
                Pair pair2 = (Pair) objWithContext;
                stampOwner = (String) pair2.component1();
                String stampVersion2 = (String) pair2.component2();
                playerClient = syncActivity.client;
                if (playerClient == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("client");
                    playerClient = null;
                }
                owner = info.identity(playerClient.getHost());
                if (Intrinsics.areEqual(stampOwner, owner)) {
                    z = true;
                } else {
                    z = true;
                }
                boolean stale2 = z;
                if (info.getDbAvailable()) {
                    activitySyncBinding = syncActivity.views;
                    if (activitySyncBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("views");
                        activitySyncBinding = null;
                    }
                    activitySyncBinding.syncDetail.setText(C1020R.string.sync_library);
                    syncActivity.showAmount(0L, info.getDbSize());
                    CoroutineDispatcher io5 = Dispatchers.getIO();
                    SyncActivity$syncLibrary$ok$1 syncActivity$syncLibrary$ok$2 = new SyncActivity$syncLibrary$ok$1(library, syncActivity, info, null);
                    c10421.L$0 = syncActivity;
                    c10421.L$1 = info;
                    c10421.L$2 = library;
                    c10421.L$3 = owner;
                    c10421.label = 2;
                    objWithContext2 = BuildersKt.withContext(io5, syncActivity$syncLibrary$ok$2, c10421);
                    if (objWithContext2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    info2 = info;
                    library2 = library;
                    ok = ((Boolean) objWithContext2).booleanValue();
                    syncActivity.hideAmount();
                    if (ok) {
                        io = Dispatchers.getIO();
                        c10443 = syncActivity.new C10443(owner, info2, null);
                        c10421.L$0 = library2;
                        c10421.L$1 = null;
                        c10421.L$2 = null;
                        c10421.L$3 = null;
                        c10421.label = 3;
                        if (BuildersKt.withContext(io, c10443, c10421) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        library3 = library2;
                        library = library3;
                    } else {
                        library = library2;
                    }
                }
                CoroutineDispatcher io6 = Dispatchers.getIO();
                C10454 c10455 = new C10454(library, null);
                c10421.L$0 = null;
                c10421.L$1 = null;
                c10421.L$2 = null;
                c10421.L$3 = null;
                c10421.label = 4;
                objWithContext3 = BuildersKt.withContext(io6, c10455, c10421);
                if (objWithContext3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objWithContext3;
            case 2:
                String owner2 = (String) c10421.L$3;
                library2 = (Library) c10421.L$2;
                info2 = (PlayerInfo) c10421.L$1;
                syncActivity = (SyncActivity) c10421.L$0;
                ResultKt.throwOnFailure($result);
                owner = owner2;
                objWithContext2 = $result;
                ok = ((Boolean) objWithContext2).booleanValue();
                syncActivity.hideAmount();
                if (ok) {
                    io = Dispatchers.getIO();
                    c10443 = syncActivity.new C10443(owner, info2, null);
                    c10421.L$0 = library2;
                    c10421.L$1 = null;
                    c10421.L$2 = null;
                    c10421.L$3 = null;
                    c10421.label = 3;
                    if (BuildersKt.withContext(io, c10443, c10421) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    library3 = library2;
                    library = library3;
                } else {
                    library = library2;
                }
                CoroutineDispatcher io7 = Dispatchers.getIO();
                C10454 c10456 = new C10454(library, null);
                c10421.L$0 = null;
                c10421.L$1 = null;
                c10421.L$2 = null;
                c10421.L$3 = null;
                c10421.label = 4;
                objWithContext3 = BuildersKt.withContext(io7, c10456, c10421);
                if (objWithContext3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objWithContext3;
            case 3:
                library3 = (Library) c10421.L$0;
                ResultKt.throwOnFailure($result);
                library = library3;
                CoroutineDispatcher io8 = Dispatchers.getIO();
                C10454 c10457 = new C10454(library, null);
                c10421.L$0 = null;
                c10421.L$1 = null;
                c10421.L$2 = null;
                c10421.L$3 = null;
                c10421.label = 4;
                objWithContext3 = BuildersKt.withContext(io8, c10457, c10421);
                if (objWithContext3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objWithContext3;
            case 4:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.SyncActivity$syncLibrary$2 */
    /* JADX INFO: compiled from: SyncActivity.kt */
    @Metadata(m147d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, m148d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.SyncActivity$syncLibrary$2", m164f = "SyncActivity.kt", m165i = {}, m166l = {}, m167m = "invokeSuspend", m168n = {}, m169s = {})
    static final class C10432 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends String, ? extends String>>, Object> {
        int label;

        C10432(Continuation<? super C10432> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SyncActivity.this.new C10432(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends String, ? extends String>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Pair<String, String>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Pair<String, String>> continuation) {
            return ((C10432) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    return Settings.INSTANCE.databaseStamp(SyncActivity.this);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.SyncActivity$syncLibrary$3 */
    /* JADX INFO: compiled from: SyncActivity.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.SyncActivity$syncLibrary$3", m164f = "SyncActivity.kt", m165i = {}, m166l = {}, m167m = "invokeSuspend", m168n = {}, m169s = {})
    static final class C10443 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PlayerInfo $info;
        final /* synthetic */ String $owner;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10443(String str, PlayerInfo playerInfo, Continuation<? super C10443> continuation) {
            super(2, continuation);
            this.$owner = str;
            this.$info = playerInfo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SyncActivity.this.new C10443(this.$owner, this.$info, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10443) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    Settings.INSTANCE.rememberDatabaseStamp(SyncActivity.this, this.$owner, this.$info.getDbVersion());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.SyncActivity$syncLibrary$4 */
    /* JADX INFO: compiled from: SyncActivity.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.SyncActivity$syncLibrary$4", m164f = "SyncActivity.kt", m165i = {}, m166l = {}, m167m = "invokeSuspend", m168n = {}, m169s = {})
    static final class C10454 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Library $library;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10454(Library library, Continuation<? super C10454> continuation) {
            super(2, continuation);
            this.$library = library;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C10454(this.$library, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C10454) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    return Boxing.boxBoolean(this.$library.open());
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:27:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:30:0x0108 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x011b  */
    /* JADX WARN: Code duplicated, block: B:36:0x012d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0144  */
    /* JADX WARN: Code duplicated, block: B:44:0x0147 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:50:0x0170  */
    /* JADX WARN: Code duplicated, block: B:51:0x0173 A[PHI: r6 r9 r10 r11
      0x0173: PHI (r6v3 'owner' java.lang.String) = (r6v2 'owner' java.lang.String), (r6v2 'owner' java.lang.String), (r6v6 'owner' java.lang.String) binds: [B:43:0x0145, B:44:0x0147, B:49:0x016e] A[DONT_GENERATE, DONT_INLINE]
      0x0173: PHI (r9v8 'covers' com.mattiadoronzo.sonixlink.Covers) = 
      (r9v5 'covers' com.mattiadoronzo.sonixlink.Covers)
      (r9v5 'covers' com.mattiadoronzo.sonixlink.Covers)
      (r9v11 'covers' com.mattiadoronzo.sonixlink.Covers)
     binds: [B:43:0x0145, B:44:0x0147, B:49:0x016e] A[DONT_GENERATE, DONT_INLINE]
      0x0173: PHI (r10v7 'info' com.mattiadoronzo.sonixlink.PlayerInfo) = 
      (r10v4 'info' com.mattiadoronzo.sonixlink.PlayerInfo)
      (r10v4 'info' com.mattiadoronzo.sonixlink.PlayerInfo)
      (r10v12 'info' com.mattiadoronzo.sonixlink.PlayerInfo)
     binds: [B:43:0x0145, B:44:0x0147, B:49:0x016e] A[DONT_GENERATE, DONT_INLINE]
      0x0173: PHI (r11v7 com.mattiadoronzo.sonixlink.SyncActivity) = 
      (r11v4 com.mattiadoronzo.sonixlink.SyncActivity)
      (r11v4 com.mattiadoronzo.sonixlink.SyncActivity)
      (r11v10 com.mattiadoronzo.sonixlink.SyncActivity)
     binds: [B:43:0x0145, B:44:0x0147, B:49:0x016e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:54:0x0178  */
    /* JADX WARN: Code duplicated, block: B:56:0x017e  */
    /* JADX WARN: Code duplicated, block: B:58:0x0182  */
    /* JADX WARN: Code duplicated, block: B:61:0x01ad A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:62:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:65:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:67:0x01e7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:68:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:70:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:71:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:74:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:76:0x021d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object syncCovers(PlayerInfo playerInfo, boolean z, Continuation<? super Unit> continuation) throws Throwable {
        C10361 c10361;
        SyncActivity syncActivity;
        boolean force;
        PlayerInfo info;
        Covers covers;
        final PlayerClient fetchWith;
        Object objWithContext;
        String stampOwner;
        PlayerClient playerClient;
        String owner;
        boolean stale;
        Object objWithContext2;
        String owner2;
        PlayerInfo info2;
        SyncActivity syncActivity2;
        boolean haveList;
        ActivitySyncBinding activitySyncBinding;
        Object objWithContext3;
        Object obj;
        Covers covers2;
        SyncActivity syncActivity3;
        PlayerInfo info3;
        Set keys;
        CoroutineDispatcher io;
        C10405 c10405;
        Covers covers3;
        Library library;
        CoroutineDispatcher io2;
        C10416 c10416;
        if (continuation instanceof C10361) {
            C10361 c10362 = (C10361) continuation;
            if ((c10362.label & Integer.MIN_VALUE) != 0) {
                c10362.label -= Integer.MIN_VALUE;
                c10361 = c10362;
            } else {
                c10361 = new C10361(continuation);
            }
        } else {
            c10361 = new C10361(continuation);
        }
        Object $result = c10361.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean haveList2 = false;
        switch (c10361.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                syncActivity = this;
                force = z;
                info = playerInfo;
                covers = Session.INSTANCE.getCovers();
                if (covers == null) {
                    return Unit.INSTANCE;
                }
                CoroutineDispatcher io3 = Dispatchers.getIO();
                C10372 c10372 = new C10372(covers, null);
                c10361.L$0 = syncActivity;
                c10361.L$1 = info;
                c10361.L$2 = covers;
                c10361.Z$0 = force;
                c10361.label = 1;
                if (BuildersKt.withContext(io3, c10372, c10361) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                fetchWith = syncActivity.client;
                if (fetchWith == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("client");
                    fetchWith = null;
                }
                covers.setSource(new Function1<Collection<? extends String>, List<? extends Thumb>>() { // from class: com.mattiadoronzo.sonixlink.SyncActivity.syncCovers.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ List<? extends Thumb> invoke(Collection<? extends String> collection) {
                        return invoke2((Collection<String>) collection);
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final List<Thumb> invoke2(Collection<String> keys2) {
                        Intrinsics.checkNotNullParameter(keys2, "keys");
                        return fetchWith.thumbs(keys2);
                    }
                });
                covers.setSlowLink(fetchWith.isBluetooth());
                CoroutineDispatcher io4 = Dispatchers.getIO();
                C10394 c10394 = syncActivity.new C10394(null);
                c10361.L$0 = syncActivity;
                c10361.L$1 = info;
                c10361.L$2 = covers;
                c10361.Z$0 = force;
                c10361.label = 2;
                objWithContext = BuildersKt.withContext(io4, c10394, c10361);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Pair pair = (Pair) objWithContext;
                stampOwner = (String) pair.component1();
                String stampVersion = (String) pair.component2();
                playerClient = syncActivity.client;
                if (playerClient == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("client");
                    playerClient = null;
                }
                owner = info.identity(playerClient.getHost());
                if (Intrinsics.areEqual(stampOwner, owner) || !Intrinsics.areEqual(stampVersion, info.getCoversVersion()) || info.getCoversMtime() == 0) {
                    stale = true;
                } else {
                    stale = false;
                }
                if (!force || stale) {
                    owner2 = owner;
                } else {
                    CoroutineDispatcher io5 = Dispatchers.getIO();
                    SyncActivity$syncCovers$haveList$1 syncActivity$syncCovers$haveList$1 = new SyncActivity$syncCovers$haveList$1(covers, null);
                    c10361.L$0 = syncActivity;
                    c10361.L$1 = info;
                    c10361.L$2 = covers;
                    c10361.L$3 = owner;
                    c10361.label = 3;
                    objWithContext2 = BuildersKt.withContext(io5, syncActivity$syncCovers$haveList$1, c10361);
                    if (objWithContext2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (((Boolean) objWithContext2).booleanValue()) {
                        owner2 = owner;
                        haveList2 = true;
                    } else {
                        owner2 = owner;
                    }
                }
                info2 = info;
                syncActivity2 = syncActivity;
                if (!haveList2) {
                    haveList = info2.getCoversAvailable();
                    if (haveList) {
                        activitySyncBinding = syncActivity2.views;
                        if (activitySyncBinding == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("views");
                            activitySyncBinding = null;
                        }
                        activitySyncBinding.syncDetail.setText(C1020R.string.sync_covers);
                        CoroutineDispatcher io6 = Dispatchers.getIO();
                        SyncActivity$syncCovers$keys$1 syncActivity$syncCovers$keys$1 = new SyncActivity$syncCovers$keys$1(syncActivity2, null);
                        c10361.L$0 = syncActivity2;
                        c10361.L$1 = info2;
                        c10361.L$2 = covers;
                        c10361.L$3 = owner2;
                        c10361.label = 4;
                        objWithContext3 = BuildersKt.withContext(io6, syncActivity$syncCovers$keys$1, c10361);
                        if (objWithContext3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = objWithContext3;
                        covers2 = covers;
                        syncActivity3 = syncActivity2;
                        info3 = info2;
                        keys = (Set) obj;
                        if (keys != null) {
                            io = Dispatchers.getIO();
                            c10405 = new C10405(covers2, keys, syncActivity3, owner2, info3, null);
                            c10361.L$0 = covers2;
                            c10361.L$1 = null;
                            c10361.L$2 = null;
                            c10361.L$3 = null;
                            c10361.label = 5;
                            if (BuildersKt.withContext(io, c10405, c10361) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            covers3 = covers2;
                            covers = covers3;
                        } else {
                            covers2.clearRemoteKeys();
                            covers = covers2;
                        }
                    } else {
                        covers.setRemoteKeys(SetsKt.emptySet());
                    }
                }
                library = Session.INSTANCE.getLibrary();
                if (library != null) {
                    io2 = Dispatchers.getIO();
                    c10416 = new C10416(covers, library, null);
                    c10361.L$0 = null;
                    c10361.L$1 = null;
                    c10361.L$2 = null;
                    c10361.L$3 = null;
                    c10361.label = 6;
                    if (BuildersKt.withContext(io2, c10416, c10361) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            case 1:
                force = c10361.Z$0;
                covers = (Covers) c10361.L$2;
                info = (PlayerInfo) c10361.L$1;
                syncActivity = (SyncActivity) c10361.L$0;
                ResultKt.throwOnFailure($result);
                fetchWith = syncActivity.client;
                if (fetchWith == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("client");
                    fetchWith = null;
                }
                covers.setSource(new Function1<Collection<? extends String>, List<? extends Thumb>>() { // from class: com.mattiadoronzo.sonixlink.SyncActivity.syncCovers.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ List<? extends Thumb> invoke(Collection<? extends String> collection) {
                        return invoke2((Collection<String>) collection);
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final List<Thumb> invoke2(Collection<String> keys2) {
                        Intrinsics.checkNotNullParameter(keys2, "keys");
                        return fetchWith.thumbs(keys2);
                    }
                });
                covers.setSlowLink(fetchWith.isBluetooth());
                CoroutineDispatcher io7 = Dispatchers.getIO();
                C10394 c10395 = syncActivity.new C10394(null);
                c10361.L$0 = syncActivity;
                c10361.L$1 = info;
                c10361.L$2 = covers;
                c10361.Z$0 = force;
                c10361.label = 2;
                objWithContext = BuildersKt.withContext(io7, c10395, c10361);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Pair pair2 = (Pair) objWithContext;
                stampOwner = (String) pair2.component1();
                String stampVersion2 = (String) pair2.component2();
                playerClient = syncActivity.client;
                if (playerClient == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("client");
                    playerClient = null;
                }
                owner = info.identity(playerClient.getHost());
                if (Intrinsics.areEqual(stampOwner, owner)) {
                    stale = true;
                } else {
                    stale = true;
                }
                if (force) {
                }
                owner2 = owner;
                info2 = info;
                syncActivity2 = syncActivity;
                if (!haveList2) {
                    haveList = info2.getCoversAvailable();
                    if (haveList) {
                        activitySyncBinding = syncActivity2.views;
                        if (activitySyncBinding == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("views");
                            activitySyncBinding = null;
                        }
                        activitySyncBinding.syncDetail.setText(C1020R.string.sync_covers);
                        CoroutineDispatcher io8 = Dispatchers.getIO();
                        SyncActivity$syncCovers$keys$1 syncActivity$syncCovers$keys$2 = new SyncActivity$syncCovers$keys$1(syncActivity2, null);
                        c10361.L$0 = syncActivity2;
                        c10361.L$1 = info2;
                        c10361.L$2 = covers;
                        c10361.L$3 = owner2;
                        c10361.label = 4;
                        objWithContext3 = BuildersKt.withContext(io8, syncActivity$syncCovers$keys$2, c10361);
                        if (objWithContext3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = objWithContext3;
                        covers2 = covers;
                        syncActivity3 = syncActivity2;
                        info3 = info2;
                        keys = (Set) obj;
                        if (keys != null) {
                            io = Dispatchers.getIO();
                            c10405 = new C10405(covers2, keys, syncActivity3, owner2, info3, null);
                            c10361.L$0 = covers2;
                            c10361.L$1 = null;
                            c10361.L$2 = null;
                            c10361.L$3 = null;
                            c10361.label = 5;
                            if (BuildersKt.withContext(io, c10405, c10361) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            covers3 = covers2;
                            covers = covers3;
                        } else {
                            covers2.clearRemoteKeys();
                            covers = covers2;
                        }
                    } else {
                        covers.setRemoteKeys(SetsKt.emptySet());
                    }
                }
                library = Session.INSTANCE.getLibrary();
                if (library != null) {
                    io2 = Dispatchers.getIO();
                    c10416 = new C10416(covers, library, null);
                    c10361.L$0 = null;
                    c10361.L$1 = null;
                    c10361.L$2 = null;
                    c10361.L$3 = null;
                    c10361.label = 6;
                    if (BuildersKt.withContext(io2, c10416, c10361) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            case 2:
                force = c10361.Z$0;
                covers = (Covers) c10361.L$2;
                info = (PlayerInfo) c10361.L$1;
                syncActivity = (SyncActivity) c10361.L$0;
                ResultKt.throwOnFailure($result);
                objWithContext = $result;
                Pair pair3 = (Pair) objWithContext;
                stampOwner = (String) pair3.component1();
                String stampVersion3 = (String) pair3.component2();
                playerClient = syncActivity.client;
                if (playerClient == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("client");
                    playerClient = null;
                }
                owner = info.identity(playerClient.getHost());
                if (Intrinsics.areEqual(stampOwner, owner)) {
                    stale = true;
                } else {
                    stale = true;
                }
                if (force) {
                }
                owner2 = owner;
                info2 = info;
                syncActivity2 = syncActivity;
                if (!haveList2) {
                    haveList = info2.getCoversAvailable();
                    if (haveList) {
                        activitySyncBinding = syncActivity2.views;
                        if (activitySyncBinding == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("views");
                            activitySyncBinding = null;
                        }
                        activitySyncBinding.syncDetail.setText(C1020R.string.sync_covers);
                        CoroutineDispatcher io9 = Dispatchers.getIO();
                        SyncActivity$syncCovers$keys$1 syncActivity$syncCovers$keys$3 = new SyncActivity$syncCovers$keys$1(syncActivity2, null);
                        c10361.L$0 = syncActivity2;
                        c10361.L$1 = info2;
                        c10361.L$2 = covers;
                        c10361.L$3 = owner2;
                        c10361.label = 4;
                        objWithContext3 = BuildersKt.withContext(io9, syncActivity$syncCovers$keys$3, c10361);
                        if (objWithContext3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = objWithContext3;
                        covers2 = covers;
                        syncActivity3 = syncActivity2;
                        info3 = info2;
                        keys = (Set) obj;
                        if (keys != null) {
                            io = Dispatchers.getIO();
                            c10405 = new C10405(covers2, keys, syncActivity3, owner2, info3, null);
                            c10361.L$0 = covers2;
                            c10361.L$1 = null;
                            c10361.L$2 = null;
                            c10361.L$3 = null;
                            c10361.label = 5;
                            if (BuildersKt.withContext(io, c10405, c10361) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            covers3 = covers2;
                            covers = covers3;
                        } else {
                            covers2.clearRemoteKeys();
                            covers = covers2;
                        }
                    } else {
                        covers.setRemoteKeys(SetsKt.emptySet());
                    }
                }
                library = Session.INSTANCE.getLibrary();
                if (library != null) {
                    io2 = Dispatchers.getIO();
                    c10416 = new C10416(covers, library, null);
                    c10361.L$0 = null;
                    c10361.L$1 = null;
                    c10361.L$2 = null;
                    c10361.L$3 = null;
                    c10361.label = 6;
                    if (BuildersKt.withContext(io2, c10416, c10361) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            case 3:
                String owner3 = (String) c10361.L$3;
                Covers covers4 = (Covers) c10361.L$2;
                PlayerInfo info4 = (PlayerInfo) c10361.L$1;
                SyncActivity syncActivity4 = (SyncActivity) c10361.L$0;
                ResultKt.throwOnFailure($result);
                syncActivity = syncActivity4;
                info = info4;
                covers = covers4;
                owner = owner3;
                objWithContext2 = $result;
                if (((Boolean) objWithContext2).booleanValue()) {
                    owner2 = owner;
                    haveList2 = true;
                } else {
                    owner2 = owner;
                }
                info2 = info;
                syncActivity2 = syncActivity;
                if (!haveList2) {
                    haveList = info2.getCoversAvailable();
                    if (haveList) {
                        activitySyncBinding = syncActivity2.views;
                        if (activitySyncBinding == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("views");
                            activitySyncBinding = null;
                        }
                        activitySyncBinding.syncDetail.setText(C1020R.string.sync_covers);
                        CoroutineDispatcher io10 = Dispatchers.getIO();
                        SyncActivity$syncCovers$keys$1 syncActivity$syncCovers$keys$4 = new SyncActivity$syncCovers$keys$1(syncActivity2, null);
                        c10361.L$0 = syncActivity2;
                        c10361.L$1 = info2;
                        c10361.L$2 = covers;
                        c10361.L$3 = owner2;
                        c10361.label = 4;
                        objWithContext3 = BuildersKt.withContext(io10, syncActivity$syncCovers$keys$4, c10361);
                        if (objWithContext3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = objWithContext3;
                        covers2 = covers;
                        syncActivity3 = syncActivity2;
                        info3 = info2;
                        keys = (Set) obj;
                        if (keys != null) {
                            io = Dispatchers.getIO();
                            c10405 = new C10405(covers2, keys, syncActivity3, owner2, info3, null);
                            c10361.L$0 = covers2;
                            c10361.L$1 = null;
                            c10361.L$2 = null;
                            c10361.L$3 = null;
                            c10361.label = 5;
                            if (BuildersKt.withContext(io, c10405, c10361) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            covers3 = covers2;
                            covers = covers3;
                        } else {
                            covers2.clearRemoteKeys();
                            covers = covers2;
                        }
                    } else {
                        covers.setRemoteKeys(SetsKt.emptySet());
                    }
                }
                library = Session.INSTANCE.getLibrary();
                if (library != null) {
                    io2 = Dispatchers.getIO();
                    c10416 = new C10416(covers, library, null);
                    c10361.L$0 = null;
                    c10361.L$1 = null;
                    c10361.L$2 = null;
                    c10361.L$3 = null;
                    c10361.label = 6;
                    if (BuildersKt.withContext(io2, c10416, c10361) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            case 4:
                owner2 = (String) c10361.L$3;
                covers2 = (Covers) c10361.L$2;
                PlayerInfo info5 = (PlayerInfo) c10361.L$1;
                SyncActivity syncActivity5 = (SyncActivity) c10361.L$0;
                ResultKt.throwOnFailure($result);
                syncActivity3 = syncActivity5;
                info3 = info5;
                obj = $result;
                keys = (Set) obj;
                if (keys != null) {
                    io = Dispatchers.getIO();
                    c10405 = new C10405(covers2, keys, syncActivity3, owner2, info3, null);
                    c10361.L$0 = covers2;
                    c10361.L$1 = null;
                    c10361.L$2 = null;
                    c10361.L$3 = null;
                    c10361.label = 5;
                    if (BuildersKt.withContext(io, c10405, c10361) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    covers3 = covers2;
                    covers = covers3;
                } else {
                    covers2.clearRemoteKeys();
                    covers = covers2;
                }
                library = Session.INSTANCE.getLibrary();
                if (library != null) {
                    io2 = Dispatchers.getIO();
                    c10416 = new C10416(covers, library, null);
                    c10361.L$0 = null;
                    c10361.L$1 = null;
                    c10361.L$2 = null;
                    c10361.L$3 = null;
                    c10361.label = 6;
                    if (BuildersKt.withContext(io2, c10416, c10361) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            case 5:
                covers3 = (Covers) c10361.L$0;
                ResultKt.throwOnFailure($result);
                covers = covers3;
                library = Session.INSTANCE.getLibrary();
                if (library != null) {
                    io2 = Dispatchers.getIO();
                    c10416 = new C10416(covers, library, null);
                    c10361.L$0 = null;
                    c10361.L$1 = null;
                    c10361.L$2 = null;
                    c10361.L$3 = null;
                    c10361.label = 6;
                    if (BuildersKt.withContext(io2, c10416, c10361) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            case 6:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.SyncActivity$syncCovers$2 */
    /* JADX INFO: compiled from: SyncActivity.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.SyncActivity$syncCovers$2", m164f = "SyncActivity.kt", m165i = {}, m166l = {}, m167m = "invokeSuspend", m168n = {}, m169s = {})
    static final class C10372 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Covers $covers;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10372(Covers covers, Continuation<? super C10372> continuation) {
            super(2, continuation);
            this.$covers = covers;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C10372(this.$covers, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C10372) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    return Boxing.boxBoolean(this.$covers.open());
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.SyncActivity$syncCovers$4 */
    /* JADX INFO: compiled from: SyncActivity.kt */
    @Metadata(m147d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, m148d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.SyncActivity$syncCovers$4", m164f = "SyncActivity.kt", m165i = {}, m166l = {}, m167m = "invokeSuspend", m168n = {}, m169s = {})
    static final class C10394 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends String, ? extends String>>, Object> {
        int label;

        C10394(Continuation<? super C10394> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SyncActivity.this.new C10394(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends String, ? extends String>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Pair<String, String>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Pair<String, String>> continuation) {
            return ((C10394) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    return Settings.INSTANCE.coversStamp(SyncActivity.this);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.SyncActivity$syncCovers$5 */
    /* JADX INFO: compiled from: SyncActivity.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.SyncActivity$syncCovers$5", m164f = "SyncActivity.kt", m165i = {}, m166l = {}, m167m = "invokeSuspend", m168n = {}, m169s = {})
    static final class C10405 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Covers $covers;
        final /* synthetic */ PlayerInfo $info;
        final /* synthetic */ Set<String> $keys;
        final /* synthetic */ String $owner;
        int label;
        final /* synthetic */ SyncActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10405(Covers covers, Set<String> set, SyncActivity syncActivity, String str, PlayerInfo playerInfo, Continuation<? super C10405> continuation) {
            super(2, continuation);
            this.$covers = covers;
            this.$keys = set;
            this.this$0 = syncActivity;
            this.$owner = str;
            this.$info = playerInfo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C10405(this.$covers, this.$keys, this.this$0, this.$owner, this.$info, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10405) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    this.$covers.setRemoteKeys(this.$keys);
                    Settings.INSTANCE.rememberCoversStamp(this.this$0, this.$owner, this.$info.getCoversVersion());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.SyncActivity$syncCovers$6 */
    /* JADX INFO: compiled from: SyncActivity.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.SyncActivity$syncCovers$6", m164f = "SyncActivity.kt", m165i = {}, m166l = {}, m167m = "invokeSuspend", m168n = {}, m169s = {})
    static final class C10416 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Covers $covers;
        final /* synthetic */ Library $library;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10416(Covers covers, Library library, Continuation<? super C10416> continuation) {
            super(2, continuation);
            this.$covers = covers;
            this.$library = library;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C10416(this.$covers, this.$library, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10416) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    this.$covers.indexAlbums(Library.tracks$default(this.$library, null, 1, null));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showAmount(long done, long total) {
        ActivitySyncBinding activitySyncBinding = this.views;
        ActivitySyncBinding activitySyncBinding2 = null;
        if (activitySyncBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySyncBinding = null;
        }
        activitySyncBinding.syncBar.setVisibility(0);
        ActivitySyncBinding activitySyncBinding3 = this.views;
        if (activitySyncBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySyncBinding3 = null;
        }
        activitySyncBinding3.syncAmount.setVisibility(0);
        ActivitySyncBinding activitySyncBinding4 = this.views;
        if (activitySyncBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySyncBinding4 = null;
        }
        activitySyncBinding4.syncProgress.setVisibility(8);
        if (total > 0) {
            ActivitySyncBinding activitySyncBinding5 = this.views;
            if (activitySyncBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("views");
                activitySyncBinding5 = null;
            }
            activitySyncBinding5.syncBar.setProgressCompat(RangesKt.coerceIn((int) ((((long) 1000) * done) / total), 0, 1000), true);
            ActivitySyncBinding activitySyncBinding6 = this.views;
            if (activitySyncBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("views");
                activitySyncBinding6 = null;
            }
            activitySyncBinding6.syncAmount.setText(getString(C1020R.string.sync_progress, new Object[]{Formatter.formatShortFileSize(this, done), Formatter.formatShortFileSize(this, total)}));
        } else {
            ActivitySyncBinding activitySyncBinding7 = this.views;
            if (activitySyncBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("views");
                activitySyncBinding7 = null;
            }
            activitySyncBinding7.syncAmount.setText(Formatter.formatShortFileSize(this, done));
        }
        ActivitySyncBinding activitySyncBinding8 = this.views;
        if (activitySyncBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
        } else {
            activitySyncBinding2 = activitySyncBinding8;
        }
        activitySyncBinding2.syncBar.setIndicatorColor(Session.INSTANCE.getAccent());
    }

    private final void hideAmount() {
        ActivitySyncBinding activitySyncBinding = this.views;
        ActivitySyncBinding activitySyncBinding2 = null;
        if (activitySyncBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySyncBinding = null;
        }
        activitySyncBinding.syncBar.setVisibility(8);
        ActivitySyncBinding activitySyncBinding3 = this.views;
        if (activitySyncBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySyncBinding3 = null;
        }
        activitySyncBinding3.syncAmount.setVisibility(8);
        ActivitySyncBinding activitySyncBinding4 = this.views;
        if (activitySyncBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
        } else {
            activitySyncBinding2 = activitySyncBinding4;
        }
        activitySyncBinding2.syncProgress.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void done() {
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        PlayerClient playerClient = this.client;
        PlayerClient playerClient2 = null;
        if (playerClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("client");
            playerClient = null;
        }
        Intent intentPutExtra = intent.putExtra("host", playerClient.getHost());
        PlayerClient playerClient3 = this.client;
        if (playerClient3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("client");
        } else {
            playerClient2 = playerClient3;
        }
        startActivity(intentPutExtra.putExtra("port", playerClient2.getPort()).putExtra("name", this.playerName));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void failed(String message) {
        hideAmount();
        ActivitySyncBinding activitySyncBinding = this.views;
        ActivitySyncBinding activitySyncBinding2 = null;
        if (activitySyncBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySyncBinding = null;
        }
        activitySyncBinding.syncProgress.setVisibility(8);
        ActivitySyncBinding activitySyncBinding3 = this.views;
        if (activitySyncBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySyncBinding3 = null;
        }
        activitySyncBinding3.syncText.setText(message);
        ActivitySyncBinding activitySyncBinding4 = this.views;
        if (activitySyncBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activitySyncBinding4 = null;
        }
        activitySyncBinding4.syncDetail.setText("");
        ActivitySyncBinding activitySyncBinding5 = this.views;
        if (activitySyncBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
        } else {
            activitySyncBinding2 = activitySyncBinding5;
        }
        activitySyncBinding2.retryButton.setVisibility(0);
    }

    private final void backToConnect() {
        startActivity(new Intent(this, (Class<?>) ConnectActivity.class).addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL));
        finish();
    }
}
