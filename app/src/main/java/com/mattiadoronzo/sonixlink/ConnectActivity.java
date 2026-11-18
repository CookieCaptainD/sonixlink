package com.mattiadoronzo.sonixlink;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mattiadoronzo.sonixlink.databinding.ActivityConnectBinding;
import com.mattiadoronzo.sonixlink.databinding.RowFoundBinding;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: ConnectActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001,B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00162\b\b\u0002\u0010\u001f\u001a\u00020\u0007H\u0002J\u0012\u0010 \u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\b\u0010#\u001a\u00020\u001aH\u0014J\b\u0010$\u001a\u00020\u001aH\u0014J\b\u0010%\u001a\u00020\u001aH\u0003J\b\u0010&\u001a\u00020\u001aH\u0002J\b\u0010'\u001a\u00020\u001aH\u0002J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u0007H\u0002J\b\u0010*\u001a\u00020\u001aH\u0002J\b\u0010+\u001a\u00020\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000¨\u0006-"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/ConnectActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/mattiadoronzo/sonixlink/ConnectActivity$FoundAdapter;", "bluetoothPermission", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "clock", "Landroid/os/Handler;", "discovery", "Lcom/mattiadoronzo/sonixlink/Discovery;", "found", "Ljava/util/ArrayList;", "Lcom/mattiadoronzo/sonixlink/Discovery$Found;", "Lkotlin/collections/ArrayList;", "giveUp", "Ljava/lang/Runnable;", "giveUpAfterMs", "", "listening", "", "views", "Lcom/mattiadoronzo/sonixlink/databinding/ActivityConnectBinding;", "connect", "", "host", "port", "", "silentFailure", "shownName", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onStop", "pickBluetooth", "reconnect", "restartDiscovery", "showCrash", "text", "showNothingFound", "showSearching", "FoundAdapter", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ConnectActivity extends AppCompatActivity {
    private FoundAdapter adapter;
    private final ActivityResultLauncher<String> bluetoothPermission;
    private Discovery discovery;
    private boolean listening;
    private ActivityConnectBinding views;
    private final ArrayList<Discovery.Found> found = new ArrayList<>();
    private final long giveUpAfterMs = 10000;
    private final Handler clock = new Handler(Looper.getMainLooper());
    private final Runnable giveUp = new Runnable() { // from class: com.mattiadoronzo.sonixlink.ConnectActivity$$ExternalSyntheticLambda5
        @Override // java.lang.Runnable
        public final void run() {
            ConnectActivity.giveUp$lambda$0(this.f$0);
        }
    };

    public ConnectActivity() {
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.mattiadoronzo.sonixlink.ConnectActivity$$ExternalSyntheticLambda6
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ConnectActivity.bluetoothPermission$lambda$4(this.f$0, (Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.bluetoothPermission = activityResultLauncherRegisterForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void giveUp$lambda$0(ConnectActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showNothingFound();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityConnectBinding activityConnectBindingInflate = ActivityConnectBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityConnectBindingInflate, "inflate(...)");
        this.views = activityConnectBindingInflate;
        ActivityConnectBinding activityConnectBinding = this.views;
        ActivityConnectBinding activityConnectBinding2 = null;
        if (activityConnectBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityConnectBinding = null;
        }
        setContentView(activityConnectBinding.getRoot());
        this.adapter = new FoundAdapter(new Function1<Discovery.Found, Unit>() { // from class: com.mattiadoronzo.sonixlink.ConnectActivity.onCreate.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Discovery.Found found) {
                invoke2(found);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Discovery.Found it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ConnectActivity.connect$default(ConnectActivity.this, it.getHost(), it.getPort(), false, null, 12, null);
            }
        });
        ActivityConnectBinding activityConnectBinding3 = this.views;
        if (activityConnectBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityConnectBinding3 = null;
        }
        activityConnectBinding3.foundList.setLayoutManager(new LinearLayoutManager(this));
        ActivityConnectBinding activityConnectBinding4 = this.views;
        if (activityConnectBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityConnectBinding4 = null;
        }
        RecyclerView recyclerView = activityConnectBinding4.foundList;
        FoundAdapter foundAdapter = this.adapter;
        if (foundAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            foundAdapter = null;
        }
        recyclerView.setAdapter(foundAdapter);
        ActivityConnectBinding activityConnectBinding5 = this.views;
        if (activityConnectBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityConnectBinding5 = null;
        }
        activityConnectBinding5.rescanButton.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.ConnectActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConnectActivity.onCreate$lambda$1(this.f$0, view);
            }
        });
        ActivityConnectBinding activityConnectBinding6 = this.views;
        if (activityConnectBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
        } else {
            activityConnectBinding2 = activityConnectBinding6;
        }
        activityConnectBinding2.bluetoothButton.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.ConnectActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConnectActivity.onCreate$lambda$2(this.f$0, view);
            }
        });
        this.discovery = new Discovery(this);
        String crash = CrashLog.INSTANCE.pending(this);
        if (crash != null) {
            showCrash(crash);
        } else {
            reconnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(ConnectActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.restartDiscovery();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(ConnectActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.pickBluetooth();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        restartDiscovery();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        this.listening = false;
        Discovery discovery = this.discovery;
        if (discovery == null) {
            Intrinsics.throwUninitializedPropertyAccessException("discovery");
            discovery = null;
        }
        discovery.stop();
        this.clock.removeCallbacks(this.giveUp);
    }

    private final void reconnect() {
        Pair<String, Integer> pairLastHost = Settings.INSTANCE.lastHost(this);
        if (pairLastHost != null) {
            String host = pairLastHost.component1();
            int port = pairLastHost.component2().intValue();
            connect$default(this, host, port, true, null, 8, null);
        }
    }

    private final void restartDiscovery() {
        this.listening = false;
        Discovery discovery = this.discovery;
        Discovery discovery2 = null;
        if (discovery == null) {
            Intrinsics.throwUninitializedPropertyAccessException("discovery");
            discovery = null;
        }
        discovery.stop();
        this.found.clear();
        FoundAdapter foundAdapter = this.adapter;
        if (foundAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            foundAdapter = null;
        }
        foundAdapter.submit(this.found);
        ActivityConnectBinding activityConnectBinding = this.views;
        if (activityConnectBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityConnectBinding = null;
        }
        activityConnectBinding.nothingFound.setVisibility(8);
        showSearching();
        this.clock.removeCallbacks(this.giveUp);
        this.clock.postDelayed(this.giveUp, this.giveUpAfterMs);
        this.listening = true;
        Discovery discovery3 = this.discovery;
        if (discovery3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("discovery");
        } else {
            discovery2 = discovery3;
        }
        discovery2.start(new Function1<Discovery.Found, Unit>() { // from class: com.mattiadoronzo.sonixlink.ConnectActivity.restartDiscovery.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Discovery.Found found) {
                invoke2(found);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Discovery.Found player) {
                Intrinsics.checkNotNullParameter(player, "player");
                if (ConnectActivity.this.listening) {
                    ConnectActivity.this.found.add(player);
                    FoundAdapter foundAdapter2 = ConnectActivity.this.adapter;
                    if (foundAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        foundAdapter2 = null;
                    }
                    foundAdapter2.submit(ConnectActivity.this.found);
                    ConnectActivity.this.showSearching();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showSearching() {
        String quantityString;
        ActivityConnectBinding activityConnectBinding = this.views;
        ActivityConnectBinding activityConnectBinding2 = null;
        if (activityConnectBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityConnectBinding = null;
        }
        activityConnectBinding.progress.setVisibility(this.found.isEmpty() ? 0 : 8);
        ActivityConnectBinding activityConnectBinding3 = this.views;
        if (activityConnectBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityConnectBinding3 = null;
        }
        TextView textView = activityConnectBinding3.statusText;
        if (this.found.isEmpty()) {
            quantityString = getString(C1020R.string.connect_searching);
        } else {
            quantityString = getResources().getQuantityString(C1020R.plurals.players_found, this.found.size(), Integer.valueOf(this.found.size()));
        }
        textView.setText(quantityString);
        ActivityConnectBinding activityConnectBinding4 = this.views;
        if (activityConnectBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
        } else {
            activityConnectBinding2 = activityConnectBinding4;
        }
        activityConnectBinding2.hintText.setVisibility(this.found.isEmpty() ? 0 : 8);
    }

    private final void showNothingFound() {
        ActivityConnectBinding activityConnectBinding = this.views;
        ActivityConnectBinding activityConnectBinding2 = null;
        if (activityConnectBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityConnectBinding = null;
        }
        activityConnectBinding.nothingFound.setVisibility(0);
        ActivityConnectBinding activityConnectBinding3 = this.views;
        if (activityConnectBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityConnectBinding3 = null;
        }
        activityConnectBinding3.hintText.setVisibility(this.found.isEmpty() ? 0 : 8);
        if (this.found.isEmpty()) {
            ActivityConnectBinding activityConnectBinding4 = this.views;
            if (activityConnectBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("views");
            } else {
                activityConnectBinding2 = activityConnectBinding4;
            }
            activityConnectBinding2.progress.setVisibility(8);
        }
    }

    static /* synthetic */ void connect$default(ConnectActivity connectActivity, String str, int i, boolean z, String str2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        if ((i2 & 8) != 0) {
            str2 = str;
        }
        connectActivity.connect(str, i, z, str2);
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.ConnectActivity$connect$1 */
    /* JADX INFO: compiled from: ConnectActivity.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.ConnectActivity$connect$1", m164f = "ConnectActivity.kt", m165i = {0}, m166l = {132}, m167m = "invokeSuspend", m168n = {"why"}, m169s = {"L$0"})
    static final class C09601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $host;
        final /* synthetic */ int $port;
        final /* synthetic */ String $shownName;
        final /* synthetic */ boolean $silentFailure;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09601(boolean z, String str, String str2, int i, Continuation<? super C09601> continuation) {
            super(2, continuation);
            this.$silentFailure = z;
            this.$host = str;
            this.$shownName = str2;
            this.$port = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConnectActivity.this.new C09601(this.$silentFailure, this.$host, this.$shownName, this.$port, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09601) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            C09601 c09601;
            Ref.ObjectRef why;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            String str = "";
            ActivityConnectBinding activityConnectBinding = null;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c09601 = this;
                    why = new Ref.ObjectRef();
                    why.element = "";
                    c09601.L$0 = why;
                    c09601.label = 1;
                    Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new ConnectActivity$connect$1$info$1(c09601.$host, c09601.$port, why, null), c09601);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objWithContext;
                    break;
                case 1:
                    Ref.ObjectRef why2 = (Ref.ObjectRef) this.L$0;
                    ResultKt.throwOnFailure($result);
                    why = why2;
                    c09601 = this;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            PlayerInfo info = (PlayerInfo) $result;
            ActivityConnectBinding activityConnectBinding2 = ConnectActivity.this.views;
            if (activityConnectBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("views");
                activityConnectBinding2 = null;
            }
            activityConnectBinding2.progress.setVisibility(8);
            if (info == null) {
                if (!c09601.$silentFailure) {
                    if (BluetoothTransport.INSTANCE.isBluetooth(c09601.$host)) {
                        if (((CharSequence) why.element).length() > 0) {
                            str = "\n" + why.element;
                        }
                    }
                    String detail = str;
                    ActivityConnectBinding activityConnectBinding3 = ConnectActivity.this.views;
                    if (activityConnectBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("views");
                    } else {
                        activityConnectBinding = activityConnectBinding3;
                    }
                    activityConnectBinding.statusText.setText(ConnectActivity.this.getString(C1020R.string.connect_failed, new Object[]{c09601.$shownName}) + detail);
                }
                return Unit.INSTANCE;
            }
            Settings.INSTANCE.rememberHost(ConnectActivity.this, c09601.$host, c09601.$port);
            ConnectActivity.this.startActivity(new Intent(ConnectActivity.this, (Class<?>) SyncActivity.class).putExtra("host", c09601.$host).putExtra("port", c09601.$port).putExtra("name", info.getName()));
            ConnectActivity.this.finish();
            return Unit.INSTANCE;
        }
    }

    private final void connect(String host, int port, boolean silentFailure, String shownName) {
        ActivityConnectBinding activityConnectBinding = this.views;
        if (activityConnectBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityConnectBinding = null;
        }
        activityConnectBinding.progress.setVisibility(0);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C09601(silentFailure, host, shownName, port, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bluetoothPermission$lambda$4(ConnectActivity this$0, Boolean granted) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(granted);
        if (granted.booleanValue()) {
            this$0.pickBluetooth();
            return;
        }
        ActivityConnectBinding activityConnectBinding = this$0.views;
        if (activityConnectBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityConnectBinding = null;
        }
        activityConnectBinding.statusText.setText(this$0.getString(C1020R.string.bluetooth_denied));
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00ae  */
    private final void pickBluetooth() {
        List listEmptyList;
        if (Build.VERSION.SDK_INT >= 31 && ContextCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_CONNECT") != 0) {
            this.bluetoothPermission.launch("android.permission.BLUETOOTH_CONNECT");
            return;
        }
        BluetoothAdapter bluetooth = BluetoothAdapter.getDefaultAdapter();
        ActivityConnectBinding activityConnectBinding = null;
        if (bluetooth == null || !bluetooth.isEnabled()) {
            ActivityConnectBinding activityConnectBinding2 = this.views;
            if (activityConnectBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("views");
            } else {
                activityConnectBinding = activityConnectBinding2;
            }
            activityConnectBinding.statusText.setText(getString(C1020R.string.bluetooth_off));
            return;
        }
        try {
            Iterable bondedDevices = bluetooth.getBondedDevices();
            if (bondedDevices == null) {
                bondedDevices = SetsKt.emptySet();
            }
            Iterable $this$sortedBy$iv = bondedDevices;
            listEmptyList = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: com.mattiadoronzo.sonixlink.ConnectActivity$pickBluetooth$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    BluetoothDevice it = (BluetoothDevice) t;
                    String name = it.getName();
                    if (name == null) {
                        name = "";
                    }
                    String lowerCase = name.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    String str = lowerCase;
                    BluetoothDevice it2 = (BluetoothDevice) t2;
                    String name2 = it2.getName();
                    String lowerCase2 = (name2 != null ? name2 : "").toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    return ComparisonsKt.compareValues(str, lowerCase2);
                }
            });
        } catch (SecurityException e) {
            listEmptyList = CollectionsKt.emptyList();
        }
        final List devices = listEmptyList;
        if (devices.isEmpty()) {
            new AlertDialog.Builder(this).setTitle(C1020R.string.bluetooth_pick).setMessage(C1020R.string.bluetooth_none).setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) null).show();
            return;
        }
        List $this$map$iv = devices;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            BluetoothDevice it = (BluetoothDevice) item$iv$iv;
            String name = it.getName();
            if (name != null) {
                Intrinsics.checkNotNull(name);
                if (!(!StringsKt.isBlank(name))) {
                    name = null;
                }
                if (name == null) {
                    name = it.getAddress();
                }
            } else {
                name = it.getAddress();
            }
            destination$iv$iv.add(name);
        }
        Collection thisCollection$iv = (List) destination$iv$iv;
        final String[] names = (String[]) thisCollection$iv.toArray(new String[0]);
        new AlertDialog.Builder(this).setTitle(C1020R.string.bluetooth_pick).setItems(names, new DialogInterface.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.ConnectActivity$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ConnectActivity.pickBluetooth$lambda$8(devices, this, names, dialogInterface, i);
            }
        }).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pickBluetooth$lambda$8(List devices, ConnectActivity this$0, String[] names, DialogInterface dialogInterface, int which) {
        Intrinsics.checkNotNullParameter(devices, "$devices");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(names, "$names");
        BluetoothDevice device = (BluetoothDevice) devices.get(which);
        String str = BluetoothTransport.PREFIX + device.getAddress();
        String str2 = names[which];
        Intrinsics.checkNotNullExpressionValue(str2, "get(...)");
        connect$default(this$0, str, 0, false, str2, 4, null);
    }

    private final void showCrash(final String text) {
        new AlertDialog.Builder(this).setTitle(C1020R.string.crash_title).setMessage(text).setCancelable(false).setPositiveButton(C1020R.string.crash_copy, new DialogInterface.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.ConnectActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ConnectActivity.showCrash$lambda$9(this.f$0, text, dialogInterface, i);
            }
        }).setNegativeButton(C1020R.string.crash_dismiss, new DialogInterface.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.ConnectActivity$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ConnectActivity.showCrash$lambda$10(this.f$0, dialogInterface, i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCrash$lambda$9(ConnectActivity this$0, String text, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(text, "$text");
        Object systemService = this$0.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardManager clipboard = (ClipboardManager) systemService;
        clipboard.setPrimaryClip(ClipData.newPlainText("SonixLink", text));
        CrashLog.INSTANCE.clear(this$0);
        this$0.reconnect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCrash$lambda$10(ConnectActivity this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CrashLog.INSTANCE.clear(this$0);
        this$0.reconnect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: ConnectActivity.kt */
    @Metadata(m147d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J\u0014\u0010\u0016\u001a\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\tj\b\u0012\u0004\u0012\u00020\u0005`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/ConnectActivity$FoundAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/mattiadoronzo/sonixlink/ConnectActivity$FoundAdapter$Holder;", "onClick", "Lkotlin/Function1;", "Lcom/mattiadoronzo/sonixlink/Discovery$Found;", "", "(Lkotlin/jvm/functions/Function1;)V", "items", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submit", "list", "", "Holder", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    static final class FoundAdapter extends RecyclerView.Adapter<Holder> {
        private final ArrayList<Discovery.Found> items;
        private final Function1<Discovery.Found, Unit> onClick;

        public final Function1<Discovery.Found, Unit> getOnClick() {
            return this.onClick;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public FoundAdapter(Function1<? super Discovery.Found, Unit> onClick) {
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            this.onClick = onClick;
            this.items = new ArrayList<>();
        }

        public final void submit(List<Discovery.Found> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.items.clear();
            this.items.addAll(list);
            notifyDataSetChanged();
        }

        /* JADX INFO: compiled from: ConnectActivity.kt */
        @Metadata(m147d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/ConnectActivity$FoundAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "views", "Lcom/mattiadoronzo/sonixlink/databinding/RowFoundBinding;", "(Lcom/mattiadoronzo/sonixlink/databinding/RowFoundBinding;)V", "getViews", "()Lcom/mattiadoronzo/sonixlink/databinding/RowFoundBinding;", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class Holder extends RecyclerView.ViewHolder {
            private final RowFoundBinding views;

            public final RowFoundBinding getViews() {
                return this.views;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Holder(RowFoundBinding views) {
                super(views.getRoot());
                Intrinsics.checkNotNullParameter(views, "views");
                this.views = views;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            RowFoundBinding rowFoundBindingInflate = RowFoundBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(rowFoundBindingInflate, "inflate(...)");
            return new Holder(rowFoundBindingInflate);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.items.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(Holder holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            Discovery.Found found = this.items.get(position);
            Intrinsics.checkNotNullExpressionValue(found, "get(...)");
            final Discovery.Found item = found;
            holder.getViews().name.setText(item.getName());
            holder.getViews().address.setText(item.getHost() + ":" + item.getPort());
            holder.getViews().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.ConnectActivity$FoundAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ConnectActivity.FoundAdapter.onBindViewHolder$lambda$0(this.f$0, item, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBindViewHolder$lambda$0(FoundAdapter this$0, Discovery.Found item, View it) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            this$0.onClick.invoke(item);
        }
    }
}
