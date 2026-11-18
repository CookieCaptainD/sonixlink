package com.mattiadoronzo.sonixlink;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.mattiadoronzo.sonixlink.databinding.ActivityMainBinding;
import com.mattiadoronzo.sonixlink.databinding.VolumePillBinding;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 Y2\u00020\u0001:\u0003YZ[B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u000fJ\b\u0010\u001d\u001a\u00020\u0005H\u0002J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u0005H\u0002J\b\u0010\"\u001a\u00020\u0005H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020\tJ\u0012\u0010)\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010+H\u0014J\u0010\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\u0005H\u0014J\u0010\u00100\u001a\u00020$2\u0006\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u00020\u0005H\u0014J\b\u00104\u001a\u00020\u0005H\u0014J6\u00105\u001a\u00020\u00052\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u000b2\u000e\b\u0002\u00107\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000509J\"\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u000b2\b\b\u0002\u0010<\u001a\u00020\u000b2\b\b\u0002\u0010=\u001a\u00020\u000bJ\u000e\u0010>\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010?J\u000e\u0010@\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u000fJ\b\u0010A\u001a\u00020\u0005H\u0002J\u0010\u0010B\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u000bH\u0002J,\u0010D\u001a\u00020\u00052\u000e\b\u0002\u00107\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000509H\u0002J\u0018\u0010E\u001a\u00020\u00052\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u000bH\u0002J\u0010\u0010I\u001a\u00020\u00052\u0006\u0010J\u001a\u00020$H\u0002J\b\u0010K\u001a\u00020\u0005H\u0002J\u0010\u0010L\u001a\u00020\u00052\u0006\u0010M\u001a\u00020NH\u0002J\u0010\u0010O\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u000bH\u0002J\u0010\u0010P\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020RH\u0002J\u0010\u0010S\u001a\u00020$2\u0006\u0010Q\u001a\u00020RH\u0002J\u001a\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010V\u001a\u00020 H\u0002J\b\u0010W\u001a\u00020\u0005H\u0002J\b\u0010X\u001a\u00020\u0005H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u000b0\u000b0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000¨\u0006\\"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "accentWatch", "Lkotlin/Function0;", "", "client", "Lcom/mattiadoronzo/sonixlink/PlayerClient;", "coverMissedAt", "", "coverPath", "", "coversWatch", "listeners", "Ljava/util/LinkedHashSet;", "Lcom/mattiadoronzo/sonixlink/MainActivity$LibraryListener;", "Lkotlin/collections/LinkedHashSet;", "notificationPermission", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "playerName", "seenFavourites", "seenPlaylists", "views", "Lcom/mattiadoronzo/sonixlink/databinding/ActivityMainBinding;", "volume", "Lcom/mattiadoronzo/sonixlink/VolumePill;", "addLibraryListener", "listener", "announceFavourites", "applyAccent", "color", "", "askForNotifications", "backToConnect", "dispatchKeyEvent", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "favouritesChanged", "afterMs", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onDestroy", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onStart", "onStop", "perform", "done", "then", "action", "Lkotlin/Function1;", "play", "path", "list", "value", "refreshState", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeLibraryListener", "retryNowCover", "say", "message", "send", "setText", "view", "Landroid/widget/TextView;", "text", "showFavourite", "starred", "showLibraryCount", "showMode", "mode", "Lcom/mattiadoronzo/sonixlink/PlayMode;", "showNowCover", "showState", "state", "Lcom/mattiadoronzo/sonixlink/PlayerState;", "shownFavourite", "smallArtwork", "Landroid/graphics/Bitmap;", "side", "startPolling", "wireControls", "Companion", "LibraryListener", "Sections", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class MainActivity extends AppCompatActivity {
    private static final long COVER_RETRY_MS = 5000;
    public static final String EXTRA_HOST = "host";
    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_PORT = "port";
    private static final long POLL_MS = 1000;
    private PlayerClient client;
    private long coverMissedAt;
    private final ActivityResultLauncher<String> notificationPermission;
    private ActivityMainBinding views;
    private VolumePill volume;
    private String playerName = "";
    private final LinkedHashSet<LibraryListener> listeners = new LinkedHashSet<>();
    private long seenFavourites = -1;
    private long seenPlaylists = -1;
    private final Function0<Unit> accentWatch = new Function0<Unit>() { // from class: com.mattiadoronzo.sonixlink.MainActivity$accentWatch$1
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
            this.this$0.applyAccent(Session.INSTANCE.getAccent());
        }
    };
    private final Function0<Unit> coversWatch = new Function0<Unit>() { // from class: com.mattiadoronzo.sonixlink.MainActivity$coversWatch$1
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
            ActivityMainBinding activityMainBinding = this.this$0.views;
            if (activityMainBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("views");
                activityMainBinding = null;
            }
            if (activityMainBinding.nowCover.getVisibility() != 0) {
                if (this.this$0.coverPath.length() > 0) {
                    String path = this.this$0.coverPath;
                    this.this$0.coverPath = "";
                    this.this$0.showNowCover(path);
                }
            }
        }
    };
    private String coverPath = "";

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.MainActivity$refreshState$1 */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.MainActivity", m164f = "MainActivity.kt", m165i = {0}, m166l = {327}, m167m = "refreshState", m168n = {"this"}, m169s = {"L$0"})
    static final class C09691 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09691(Continuation<? super C09691> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainActivity.this.refreshState(this);
        }
    }

    public MainActivity() {
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.mattiadoronzo.sonixlink.MainActivity$$ExternalSyntheticLambda0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                MainActivity.notificationPermission$lambda$18((Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.notificationPermission = activityResultLauncherRegisterForActivityResult;
    }

    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m147d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/MainActivity$LibraryListener;", "", "onFavouritesChanged", "", "onNowPlaying", "state", "Lcom/mattiadoronzo/sonixlink/PlayerState;", "onOrderChanged", "onPlaylistsChanged", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public interface LibraryListener {
        void onFavouritesChanged();

        void onNowPlaying(PlayerState state);

        void onOrderChanged();

        void onPlaylistsChanged();

        /* JADX INFO: compiled from: MainActivity.kt */
        @Metadata(m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class DefaultImpls {
            public static void onOrderChanged(LibraryListener $this) {
            }

            public static void onPlaylistsChanged(LibraryListener $this) {
            }

            public static void onNowPlaying(LibraryListener $this, PlayerState state) {
                Intrinsics.checkNotNullParameter(state, "state");
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBindingInflate = ActivityMainBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityMainBindingInflate, "inflate(...)");
        this.views = activityMainBindingInflate;
        ActivityMainBinding activityMainBinding = this.views;
        ActivityMainBinding activityMainBinding2 = null;
        if (activityMainBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityMainBinding = null;
        }
        setContentView(activityMainBinding.getRoot());
        ActivityMainBinding activityMainBinding3 = this.views;
        if (activityMainBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityMainBinding3 = null;
        }
        VolumePillBinding volume = activityMainBinding3.volume;
        Intrinsics.checkNotNullExpressionValue(volume, "volume");
        this.volume = new VolumePill(volume, new Function1<Integer, Unit>() { // from class: com.mattiadoronzo.sonixlink.MainActivity.onCreate.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(final int level) {
                MainActivity.send$default(MainActivity.this, null, new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.MainActivity.onCreate.1.1
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
                }, 1, null);
            }
        });
        String host = getIntent().getStringExtra("host");
        if (host == null) {
            host = "";
        }
        int port = getIntent().getIntExtra("port", PlayerClient.DEFAULT_PORT);
        if (host.length() == 0) {
            backToConnect();
            return;
        }
        if (Session.INSTANCE.getLibrary() == null) {
            Intent intentPutExtra = new Intent(this, (Class<?>) SyncActivity.class).putExtra("host", host).putExtra("port", port);
            String stringExtra = getIntent().getStringExtra("name");
            startActivity(intentPutExtra.putExtra("name", stringExtra != null ? stringExtra : ""));
            finish();
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
        String stringExtra2 = getIntent().getStringExtra("name");
        String name = stringExtra2 != null ? stringExtra2 : "";
        this.playerName = name;
        PlayerService.INSTANCE.start(this, host, port, name);
        askForNotifications();
        ActivityMainBinding activityMainBinding4 = this.views;
        if (activityMainBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityMainBinding4 = null;
        }
        setSupportActionBar(activityMainBinding4.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            String label = name;
            if (label.length() == 0) {
                PlayerClient playerClient2 = this.client;
                if (playerClient2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("client");
                    playerClient2 = null;
                }
                label = playerClient2.getLabel();
            }
            supportActionBar.setTitle(label);
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            PlayerClient playerClient3 = this.client;
            if (playerClient3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("client");
                playerClient3 = null;
            }
            supportActionBar2.setSubtitle(playerClient3.getLabel());
        }
        ActivityMainBinding activityMainBinding5 = this.views;
        if (activityMainBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityMainBinding5 = null;
        }
        activityMainBinding5.pager.setAdapter(new Sections(this));
        ActivityMainBinding activityMainBinding6 = this.views;
        if (activityMainBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityMainBinding6 = null;
        }
        activityMainBinding6.pager.setOffscreenPageLimit(1);
        ActivityMainBinding activityMainBinding7 = this.views;
        if (activityMainBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityMainBinding7 = null;
        }
        TabLayout tabLayout = activityMainBinding7.tabs;
        ActivityMainBinding activityMainBinding8 = this.views;
        if (activityMainBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityMainBinding8 = null;
        }
        new TabLayoutMediator(tabLayout, activityMainBinding8.pager, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.mattiadoronzo.sonixlink.MainActivity$$ExternalSyntheticLambda1
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                MainActivity.onCreate$lambda$1(tab, i);
            }
        }).attach();
        ActivityMainBinding activityMainBinding9 = this.views;
        if (activityMainBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityMainBinding9 = null;
        }
        activityMainBinding9.trackTitle.setSelected(true);
        ActivityMainBinding activityMainBinding10 = this.views;
        if (activityMainBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
        } else {
            activityMainBinding2 = activityMainBinding10;
        }
        activityMainBinding2.trackArtist.setSelected(true);
        wireControls();
        applyAccent(Session.INSTANCE.getAccent());
        showLibraryCount();
        startPolling();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(TabLayout.Tab tab, int position) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        Section section = Section.getEntries().get(position);
        tab.setText(section.getTitleRes());
        tab.setIcon(section.getIcon());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        Session.INSTANCE.watchAccent(this.accentWatch);
        Covers.INSTANCE.watch(this.coversWatch);
        this.accentWatch.invoke();
        this.coversWatch.invoke();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        Session.INSTANCE.unwatchAccent(this.accentWatch);
        Covers.INSTANCE.unwatch(this.coversWatch);
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

    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m147d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/MainActivity$Sections;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "", "getItemCount", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private static final class Sections extends FragmentStateAdapter {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Sections(AppCompatActivity activity) {
            super(activity);
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return Section.getEntries().size();
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int position) {
            return BrowseFragment.INSTANCE.m143of(Section.getEntries().get(position));
        }
    }

    public final void addLibraryListener(LibraryListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    public final void removeLibraryListener(LibraryListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.MainActivity$showLibraryCount$1 */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.MainActivity$showLibraryCount$1", m164f = "MainActivity.kt", m165i = {}, m166l = {199}, m167m = "invokeSuspend", m168n = {}, m169s = {})
    static final class C09721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09721(Continuation<? super C09721> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainActivity.this.new C09721(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09721) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            C09721 c09721;
            String label;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            PlayerClient playerClient = null;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c09721 = this;
                    c09721.label = 1;
                    Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new MainActivity$showLibraryCount$1$count$1(null), c09721);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objWithContext;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    c09721 = this;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int count = ((Number) $result).intValue();
            ActionBar supportActionBar = MainActivity.this.getSupportActionBar();
            if (supportActionBar != null) {
                if (count <= 0) {
                    PlayerClient playerClient2 = MainActivity.this.client;
                    if (playerClient2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("client");
                    } else {
                        playerClient = playerClient2;
                    }
                    label = playerClient.getLabel();
                } else {
                    label = MainActivity.this.getString(C1020R.string.library_ready, new Object[]{Boxing.boxInt(count)});
                }
                supportActionBar.setSubtitle(label);
            }
            return Unit.INSTANCE;
        }
    }

    private final void showLibraryCount() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C09721(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void announceFavourites() {
        Iterable $this$forEach$iv = CollectionsKt.toList(this.listeners);
        for (Object element$iv : $this$forEach$iv) {
            LibraryListener it = (LibraryListener) element$iv;
            it.onFavouritesChanged();
        }
    }

    private final void wireControls() {
        ActivityMainBinding activityMainBinding = this.views;
        ActivityMainBinding activityMainBinding2 = null;
        if (activityMainBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityMainBinding = null;
        }
        activityMainBinding.playButton.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.MainActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.wireControls$lambda$3(this.f$0, view);
            }
        });
        ActivityMainBinding activityMainBinding3 = this.views;
        if (activityMainBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityMainBinding3 = null;
        }
        activityMainBinding3.prevButton.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.MainActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.wireControls$lambda$4(this.f$0, view);
            }
        });
        ActivityMainBinding activityMainBinding4 = this.views;
        if (activityMainBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityMainBinding4 = null;
        }
        activityMainBinding4.nextButton.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.MainActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.wireControls$lambda$5(this.f$0, view);
            }
        });
        ActivityMainBinding activityMainBinding5 = this.views;
        if (activityMainBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityMainBinding5 = null;
        }
        activityMainBinding5.modeButton.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.MainActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.wireControls$lambda$6(this.f$0, view);
            }
        });
        ActivityMainBinding activityMainBinding6 = this.views;
        if (activityMainBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityMainBinding6 = null;
        }
        activityMainBinding6.favouriteButton.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.MainActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.wireControls$lambda$7(this.f$0, view);
            }
        });
        ActivityMainBinding activityMainBinding7 = this.views;
        if (activityMainBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityMainBinding7 = null;
        }
        activityMainBinding7.queueButton.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.MainActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.wireControls$lambda$8(this.f$0, view);
            }
        });
        ActivityMainBinding activityMainBinding8 = this.views;
        if (activityMainBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
        } else {
            activityMainBinding2 = activityMainBinding8;
        }
        activityMainBinding2.nowDetails.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.MainActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.wireControls$lambda$9(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wireControls$lambda$3(MainActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        send$default(this$0, null, new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.MainActivity$wireControls$1$1
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
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wireControls$lambda$4(MainActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        send$default(this$0, null, new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.MainActivity$wireControls$2$1
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
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wireControls$lambda$5(MainActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        send$default(this$0, null, new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.MainActivity$wireControls$3$1
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
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wireControls$lambda$6(MainActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final PlayMode next = Session.INSTANCE.getHeldMode().resolve(Session.INSTANCE.getState().getMode()).next();
        Session.INSTANCE.getHeldMode().set(next);
        this$0.showMode(next);
        ActivityMainBinding activityMainBinding = this$0.views;
        if (activityMainBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityMainBinding = null;
        }
        activityMainBinding.modeButton.setContentDescription(this$0.getString(next.getLabel()));
        send$default(this$0, null, new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.MainActivity$wireControls$4$1
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
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wireControls$lambda$7(final MainActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final String path = Session.INSTANCE.getState().getPath();
        if (path.length() == 0) {
            return;
        }
        final boolean starred = !this$0.shownFavourite(Session.INSTANCE.getState());
        Session.INSTANCE.getHeldFavourite().set(TuplesKt.m155to(path, Boolean.valueOf(starred)));
        this$0.showFavourite(starred);
        this$0.send(new Function0<Unit>() { // from class: com.mattiadoronzo.sonixlink.MainActivity$wireControls$5$1
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
                this.this$0.announceFavourites();
            }
        }, new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.MainActivity$wireControls$5$2
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
    public static final void wireControls$lambda$8(MainActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) QueueActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wireControls$lambda$9(MainActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Session.INSTANCE.getState().getHasTrack()) {
            this$0.startActivity(new Intent(this$0, (Class<?>) NowPlayingActivity.class));
            this$0.overridePendingTransition(C1020R.anim.slide_up, C1020R.anim.stay);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void send$default(MainActivity mainActivity, Function0 function0, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = new Function0<Unit>() { // from class: com.mattiadoronzo.sonixlink.MainActivity.send.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            };
        }
        mainActivity.send(function0, function1);
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.MainActivity$send$2 */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.MainActivity$send$2", m164f = "MainActivity.kt", m165i = {}, m166l = {264, 275}, m167m = "invokeSuspend", m168n = {}, m169s = {})
    static final class C09712 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<PlayerClient, Unit> $action;
        final /* synthetic */ Function0<Unit> $then;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09712(Function0<Unit> function0, Function1<? super PlayerClient, Unit> function1, Continuation<? super C09712> continuation) {
            super(2, continuation);
            this.$then = function0;
            this.$action = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainActivity.this.new C09712(this.$then, this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09712) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:14:0x004d  */
        /* JADX WARN: Code duplicated, block: B:15:0x0060  */
        /* JADX WARN: Code duplicated, block: B:17:0x006e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:18:0x006f  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            C09712 c09712;
            boolean failed;
            C09712 c09713;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new MainActivity$send$2$failed$1(this.$action, MainActivity.this, null), this);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objWithContext;
                    c09712 = this;
                    failed = ((Boolean) $result).booleanValue();
                    if (failed) {
                        c09712.label = 2;
                        if (MainActivity.this.refreshState(c09712) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = $result;
                        c09713 = c09712;
                        c09713.$then.invoke();
                    } else {
                        MainActivity mainActivity = MainActivity.this;
                        String string = MainActivity.this.getString(C1020R.string.command_failed);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        mainActivity.say(string);
                    }
                    return Unit.INSTANCE;
                case 1:
                    ResultKt.throwOnFailure($result);
                    c09712 = this;
                    failed = ((Boolean) $result).booleanValue();
                    if (failed) {
                        c09712.label = 2;
                        if (MainActivity.this.refreshState(c09712) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = $result;
                        c09713 = c09712;
                        c09713.$then.invoke();
                    } else {
                        MainActivity mainActivity2 = MainActivity.this;
                        String string2 = MainActivity.this.getString(C1020R.string.command_failed);
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        mainActivity2.say(string2);
                    }
                    return Unit.INSTANCE;
                case 2:
                    c09713 = this;
                    ResultKt.throwOnFailure($result);
                    c09713.$then.invoke();
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final void send(Function0<Unit> then, Function1<? super PlayerClient, Unit> action) {
        if (this.client == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C09712(then, action, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void perform$default(MainActivity mainActivity, String str, Function0 function0, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: com.mattiadoronzo.sonixlink.MainActivity.perform.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            };
        }
        mainActivity.perform(str, function0, function1);
    }

    public final void perform(final String done, final Function0<Unit> then, Function1<? super PlayerClient, Unit> action) {
        Intrinsics.checkNotNullParameter(then, "then");
        Intrinsics.checkNotNullParameter(action, "action");
        send(new Function0<Unit>() { // from class: com.mattiadoronzo.sonixlink.MainActivity.perform.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                if (done != null) {
                    this.say(done);
                }
                then.invoke();
            }
        }, action);
    }

    public static /* synthetic */ void favouritesChanged$default(MainActivity mainActivity, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        mainActivity.favouritesChanged(j);
    }

    public final void favouritesChanged(long afterMs) {
        if (afterMs <= 0) {
            announceFavourites();
            return;
        }
        ActivityMainBinding activityMainBinding = this.views;
        if (activityMainBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityMainBinding = null;
        }
        activityMainBinding.getRoot().postDelayed(new Runnable() { // from class: com.mattiadoronzo.sonixlink.MainActivity$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.favouritesChanged$lambda$10(this.f$0);
            }
        }, afterMs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void favouritesChanged$lambda$10(MainActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.announceFavourites();
    }

    public static /* synthetic */ void play$default(MainActivity mainActivity, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "all";
        }
        if ((i & 4) != 0) {
            str3 = "";
        }
        mainActivity.play(str, str2, str3);
    }

    public final void play(final String path, final String list, final String value) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(value, "value");
        if (path.length() == 0) {
            return;
        }
        send$default(this, null, new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.MainActivity.play.1
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
                it.playPath(path, list, value);
            }
        }, 1, null);
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.MainActivity$startPolling$1 */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.MainActivity$startPolling$1", m164f = "MainActivity.kt", m165i = {}, m166l = {317}, m167m = "invokeSuspend", m168n = {}, m169s = {})
    static final class C09751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09751(Continuation<? super C09751> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainActivity.this.new C09751(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09751) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.MainActivity$startPolling$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: MainActivity.kt */
        @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.MainActivity$startPolling$1$1", m164f = "MainActivity.kt", m165i = {0, 1}, m166l = {319, 320}, m167m = "invokeSuspend", m168n = {"$this$repeatOnLifecycle", "$this$repeatOnLifecycle"}, m169s = {"L$0", "L$0"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MainActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MainActivity mainActivity, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = mainActivity;
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
                    com.mattiadoronzo.sonixlink.MainActivity r3 = r1.this$0
                    r4 = r1
                    kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                    r1.L$0 = r2
                    r5 = 1
                    r1.label = r5
                    java.lang.Object r3 = com.mattiadoronzo.sonixlink.MainActivity.access$refreshState(r3, r4)
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
                throw new UnsupportedOperationException("Method not decompiled: com.mattiadoronzo.sonixlink.MainActivity.C09751.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (RepeatOnLifecycleKt.repeatOnLifecycle(MainActivity.this, Lifecycle.State.STARTED, new AnonymousClass1(MainActivity.this, null), this) == coroutine_suspended) {
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

    private final void startPolling() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C09751(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object refreshState(Continuation<? super Unit> continuation) throws Throwable {
        C09691 c09691;
        Object objWithContext;
        MainActivity mainActivity;
        if (continuation instanceof C09691) {
            c09691 = (C09691) continuation;
            if ((c09691.label & Integer.MIN_VALUE) != 0) {
                c09691.label -= Integer.MIN_VALUE;
            } else {
                c09691 = new C09691(continuation);
            }
        } else {
            c09691 = new C09691(continuation);
        }
        C09691 c09692 = c09691;
        Object $result = c09692.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        PlayerClient playerClient = null;
        switch (c09692.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                CoroutineDispatcher io = Dispatchers.getIO();
                MainActivity$refreshState$state$1 mainActivity$refreshState$state$1 = new MainActivity$refreshState$state$1(this, null);
                c09692.L$0 = this;
                c09692.label = 1;
                objWithContext = BuildersKt.withContext(io, mainActivity$refreshState$state$1, c09692);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mainActivity = this;
                break;
                break;
            case 1:
                mainActivity = (MainActivity) c09692.L$0;
                ResultKt.throwOnFailure($result);
                objWithContext = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        PlayerState state = (PlayerState) objWithContext;
        if (state != null) {
            Session.INSTANCE.setState(state);
            mainActivity.showState(state);
            if (!PlayerService.INSTANCE.getRunning()) {
                PlayerService.Companion companion = PlayerService.INSTANCE;
                MainActivity mainActivity2 = mainActivity;
                PlayerClient playerClient2 = mainActivity.client;
                if (playerClient2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("client");
                    playerClient2 = null;
                }
                String host = playerClient2.getHost();
                PlayerClient playerClient3 = mainActivity.client;
                if (playerClient3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("client");
                } else {
                    playerClient = playerClient3;
                }
                companion.start(mainActivity2, host, playerClient.getPort(), mainActivity.playerName);
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    private final void retryNowCover() {
        if (this.coverPath.length() == 0) {
            return;
        }
        ActivityMainBinding activityMainBinding = this.views;
        if (activityMainBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityMainBinding = null;
        }
        if (activityMainBinding.nowCover.getVisibility() != 0 && SystemClock.uptimeMillis() - this.coverMissedAt >= 5000) {
            String path = this.coverPath;
            this.coverPath = "";
            showNowCover(path);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showNowCover(String path) {
        if (Intrinsics.areEqual(path, this.coverPath)) {
            return;
        }
        this.coverPath = path;
        ActivityMainBinding activityMainBinding = null;
        if (path.length() == 0) {
            ActivityMainBinding activityMainBinding2 = this.views;
            if (activityMainBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("views");
            } else {
                activityMainBinding = activityMainBinding2;
            }
            activityMainBinding.nowCover.setVisibility(4);
            return;
        }
        int side = RangesKt.coerceAtLeast((int) (48 * getResources().getDisplayMetrics().density), 48);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C09731(path, side, null), 3, null);
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.MainActivity$showNowCover$1 */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.MainActivity$showNowCover$1", m164f = "MainActivity.kt", m165i = {}, m166l = {370}, m167m = "invokeSuspend", m168n = {}, m169s = {})
    static final class C09731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $path;
        final /* synthetic */ int $side;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09731(String str, int i, Continuation<? super C09731> continuation) {
            super(2, continuation);
            this.$path = str;
            this.$side = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainActivity.this.new C09731(this.$path, this.$side, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09731) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            C09731 c09731;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ActivityMainBinding activityMainBinding = null;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c09731 = this;
                    c09731.label = 1;
                    Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new MainActivity$showNowCover$1$bitmap$1(c09731.$path, MainActivity.this, c09731.$side, null), c09731);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objWithContext;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    c09731 = this;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Bitmap bitmap = (Bitmap) $result;
            if (!Intrinsics.areEqual(MainActivity.this.coverPath, c09731.$path)) {
                return Unit.INSTANCE;
            }
            if (bitmap != null) {
                ActivityMainBinding activityMainBinding2 = MainActivity.this.views;
                if (activityMainBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("views");
                    activityMainBinding2 = null;
                }
                activityMainBinding2.nowCover.setImageBitmap(bitmap);
                ActivityMainBinding activityMainBinding3 = MainActivity.this.views;
                if (activityMainBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("views");
                } else {
                    activityMainBinding = activityMainBinding3;
                }
                activityMainBinding.nowCover.setVisibility(0);
            } else {
                MainActivity.this.coverMissedAt = SystemClock.uptimeMillis();
                ActivityMainBinding activityMainBinding4 = MainActivity.this.views;
                if (activityMainBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("views");
                    activityMainBinding4 = null;
                }
                activityMainBinding4.nowCover.setImageDrawable(null);
                ActivityMainBinding activityMainBinding5 = MainActivity.this.views;
                if (activityMainBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("views");
                } else {
                    activityMainBinding = activityMainBinding5;
                }
                activityMainBinding.nowCover.setVisibility(4);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap smallArtwork(final String path, int side) {
        byte[] bytes;
        PlayerClient client = Session.INSTANCE.getClient();
        if (client == null) {
            return null;
        }
        try {
            bytes = Artwork.INSTANCE.get(client, path, new Function0<Boolean>() { // from class: com.mattiadoronzo.sonixlink.MainActivity$smallArtwork$bytes$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(Intrinsics.areEqual(this.this$0.coverPath, path));
                }
            });
        } catch (Exception e) {
            bytes = null;
        }
        if (bytes == null) {
            return null;
        }
        try {
            BitmapFactory.Options bounds = new BitmapFactory.Options();
            bounds.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bytes, 0, bytes.length, bounds);
            int sample = 1;
            while (Math.max(bounds.outWidth, bounds.outHeight) / (sample * 2) >= side) {
                sample *= 2;
            }
            int length = bytes.length;
            BitmapFactory.Options $this$smallArtwork_u24lambda_u2412 = new BitmapFactory.Options();
            $this$smallArtwork_u24lambda_u2412.inSampleSize = sample;
            Unit unit = Unit.INSTANCE;
            return BitmapFactory.decodeByteArray(bytes, 0, length, $this$smallArtwork_u24lambda_u2412);
        } catch (OutOfMemoryError e2) {
            return null;
        }
    }

    private final void showState(PlayerState state) {
        String string;
        int color;
        SortPrefs sort = state.getSort();
        if (sort != null && !Intrinsics.areEqual(sort, Session.INSTANCE.getSort())) {
            Session.INSTANCE.setSort(sort);
            Iterable $this$forEach$iv = CollectionsKt.toList(this.listeners);
            for (Object element$iv : $this$forEach$iv) {
                LibraryListener it = (LibraryListener) element$iv;
                it.onOrderChanged();
            }
        }
        if (state.getFavouritesRevision() >= 0 && state.getFavouritesRevision() != this.seenFavourites) {
            boolean first = this.seenFavourites < 0;
            this.seenFavourites = state.getFavouritesRevision();
            if (!first) {
                announceFavourites();
            }
        }
        if (state.getPlaylistsRevision() >= 0 && state.getPlaylistsRevision() != this.seenPlaylists) {
            boolean first2 = this.seenPlaylists < 0;
            this.seenPlaylists = state.getPlaylistsRevision();
            if (!first2) {
                Iterable $this$forEach$iv2 = CollectionsKt.toList(this.listeners);
                for (Object element$iv2 : $this$forEach$iv2) {
                    LibraryListener it2 = (LibraryListener) element$iv2;
                    it2.onPlaylistsChanged();
                }
            }
        }
        Iterable $this$forEach$iv3 = CollectionsKt.toList(this.listeners);
        for (Object element$iv3 : $this$forEach$iv3) {
            LibraryListener it3 = (LibraryListener) element$iv3;
            it3.onNowPlaying(state);
        }
        ActivityMainBinding activityMainBinding = null;
        if ((state.getAccent().length() > 0) && (color = Session.INSTANCE.parseAccent(state.getAccent())) != Session.INSTANCE.getAccent()) {
            Session.INSTANCE.setAccent(color);
            String text = state.getAccent();
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new C09744(text, null), 2, null);
        }
        showNowCover(state.getPath());
        retryNowCover();
        ActivityMainBinding activityMainBinding2 = this.views;
        if (activityMainBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityMainBinding2 = null;
        }
        TextView trackTitle = activityMainBinding2.trackTitle;
        Intrinsics.checkNotNullExpressionValue(trackTitle, "trackTitle");
        if (!state.getHasTrack()) {
            string = getString(C1020R.string.nothing_playing);
            Intrinsics.checkNotNull(string);
        } else {
            String title = state.getTitle();
            if (title.length() == 0) {
                title = StringsKt.substringAfterLast$default(state.getPath(), '/', (String) null, 2, (Object) null);
            }
            string = title;
        }
        setText(trackTitle, string);
        Iterable $this$filter$iv = CollectionsKt.listOf((Object[]) new String[]{state.getArtist(), state.getAlbum()});
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            String it4 = (String) element$iv$iv;
            if (it4.length() > 0) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        String by = CollectionsKt.joinToString$default((List) destination$iv$iv, " — ", null, null, 0, null, null, 62, null);
        ActivityMainBinding activityMainBinding3 = this.views;
        if (activityMainBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityMainBinding3 = null;
        }
        TextView trackArtist = activityMainBinding3.trackArtist;
        Intrinsics.checkNotNullExpressionValue(trackArtist, "trackArtist");
        setText(trackArtist, by);
        ActivityMainBinding activityMainBinding4 = this.views;
        if (activityMainBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityMainBinding4 = null;
        }
        activityMainBinding4.trackArtist.setVisibility(by.length() == 0 ? 8 : 0);
        ActivityMainBinding activityMainBinding5 = this.views;
        if (activityMainBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityMainBinding5 = null;
        }
        activityMainBinding5.playButton.setImageResource(state.isPlaying() ? C1020R.drawable.ic_pause : C1020R.drawable.ic_play);
        ActivityMainBinding activityMainBinding6 = this.views;
        if (activityMainBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityMainBinding6 = null;
        }
        activityMainBinding6.playButton.setContentDescription(getString(state.isPlaying() ? C1020R.string.cd_pause : C1020R.string.cd_play));
        showMode(Session.INSTANCE.getHeldMode().resolve(state.getMode()));
        ActivityMainBinding activityMainBinding7 = this.views;
        if (activityMainBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityMainBinding7 = null;
        }
        activityMainBinding7.progressTrack.setProgress(state.getDuration() > 0 ? RangesKt.coerceIn((int) ((((long) state.getPosition()) * ((long) 1000)) / ((long) state.getDuration())), 0, 1000) : 0);
        VolumePill volumePill = this.volume;
        if (volumePill == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volume");
            volumePill = null;
        }
        volumePill.follow(state.getVolume());
        showFavourite(shownFavourite(state));
        ActivityMainBinding activityMainBinding8 = this.views;
        if (activityMainBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
        } else {
            activityMainBinding = activityMainBinding8;
        }
        activityMainBinding.favouriteButton.setEnabled(state.getHasTrack());
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.MainActivity$showState$4 */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.MainActivity$showState$4", m164f = "MainActivity.kt", m165i = {}, m166l = {}, m167m = "invokeSuspend", m168n = {}, m169s = {})
    static final class C09744 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $text;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09744(String str, Continuation<? super C09744> continuation) {
            super(2, continuation);
            this.$text = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainActivity.this.new C09744(this.$text, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09744) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    Settings.INSTANCE.rememberAccent(MainActivity.this, this.$text);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final void setText(TextView view, String text) {
        CharSequence text2 = view.getText();
        if (!Intrinsics.areEqual(text2 != null ? text2.toString() : null, text)) {
            view.setText(text);
        }
    }

    private final boolean shownFavourite(PlayerState state) {
        Pair<String, Boolean> pairResolve = Session.INSTANCE.getHeldFavourite().resolve(TuplesKt.m155to(state.getPath(), Boolean.valueOf(state.getFavourite())));
        String path = pairResolve.component1();
        boolean starred = pairResolve.component2().booleanValue();
        return Intrinsics.areEqual(path, state.getPath()) ? starred : state.getFavourite();
    }

    private final void showFavourite(boolean starred) {
        ActivityMainBinding activityMainBinding = this.views;
        ActivityMainBinding activityMainBinding2 = null;
        if (activityMainBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityMainBinding = null;
        }
        activityMainBinding.favouriteButton.setImageResource(starred ? C1020R.drawable.ic_favourite_filled : C1020R.drawable.ic_favourite);
        ActivityMainBinding activityMainBinding3 = this.views;
        if (activityMainBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
        } else {
            activityMainBinding2 = activityMainBinding3;
        }
        activityMainBinding2.favouriteButton.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(this, starred ? C1020R.color.favourite : C1020R.color.text_secondary)));
    }

    private final void showMode(PlayMode mode) {
        ActivityMainBinding activityMainBinding = this.views;
        ActivityMainBinding activityMainBinding2 = null;
        if (activityMainBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityMainBinding = null;
        }
        activityMainBinding.modeButton.setImageResource(mode.getIcon());
        ActivityMainBinding activityMainBinding3 = this.views;
        if (activityMainBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
        } else {
            activityMainBinding2 = activityMainBinding3;
        }
        activityMainBinding2.modeButton.setImageTintList(Accent.INSTANCE.onOff(this, mode != PlayMode.NORMAL));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyAccent(int color) {
        ColorStateList tint = ColorStateList.valueOf(color);
        Intrinsics.checkNotNullExpressionValue(tint, "valueOf(...)");
        ActivityMainBinding activityMainBinding = this.views;
        ActivityMainBinding activityMainBinding2 = null;
        if (activityMainBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityMainBinding = null;
        }
        activityMainBinding.progressTrack.setProgressTintList(tint);
        VolumePill volumePill = this.volume;
        if (volumePill == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volume");
            volumePill = null;
        }
        volumePill.accent();
        ActivityMainBinding activityMainBinding3 = this.views;
        if (activityMainBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityMainBinding3 = null;
        }
        activityMainBinding3.tabs.setSelectedTabIndicatorColor(color);
        ActivityMainBinding activityMainBinding4 = this.views;
        if (activityMainBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityMainBinding4 = null;
        }
        activityMainBinding4.tabs.setTabIconTint(Accent.INSTANCE.tabColors(this));
        ActivityMainBinding activityMainBinding5 = this.views;
        if (activityMainBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityMainBinding5 = null;
        }
        activityMainBinding5.tabs.setTabTextColors(ContextCompat.getColor(this, C1020R.color.text_secondary), color);
        Accent accent = Accent.INSTANCE;
        ActivityMainBinding activityMainBinding6 = this.views;
        if (activityMainBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
        } else {
            activityMainBinding2 = activityMainBinding6;
        }
        ImageButton playButton = activityMainBinding2.playButton;
        Intrinsics.checkNotNullExpressionValue(playButton, "playButton");
        accent.circleButton(playButton, 56);
        showMode(Session.INSTANCE.getHeldMode().resolve(Session.INSTANCE.getState().getMode()));
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

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        getMenuInflater().inflate(C1020R.menu.main, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        CharSequence title;
        Intrinsics.checkNotNullParameter(item, "item");
        int itemId = item.getItemId();
        if (itemId == C1020R.id.action_search) {
            startActivity(new Intent(this, (Class<?>) SearchActivity.class));
            return true;
        }
        if (itemId != C1020R.id.action_refresh) {
            if (itemId == C1020R.id.action_disconnect) {
                Settings.INSTANCE.forgetHost(this);
                PlayerService.INSTANCE.stop(this);
                backToConnect();
                return true;
            }
            return super.onOptionsItemSelected(item);
        }
        if (this.client == null) {
            return true;
        }
        Intent intent = new Intent(this, (Class<?>) SyncActivity.class);
        PlayerClient playerClient = this.client;
        String string = null;
        if (playerClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("client");
            playerClient = null;
        }
        Intent intentPutExtra = intent.putExtra("host", playerClient.getHost());
        PlayerClient playerClient2 = this.client;
        if (playerClient2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("client");
            playerClient2 = null;
        }
        Intent intentPutExtra2 = intentPutExtra.putExtra("port", playerClient2.getPort());
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null && (title = supportActionBar.getTitle()) != null) {
            string = title.toString();
        }
        if (string == null) {
            string = "";
        }
        startActivity(intentPutExtra2.putExtra("name", string).putExtra(SyncActivity.EXTRA_FORCE, true));
        finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notificationPermission$lambda$18(Boolean it) {
    }

    private final void askForNotifications() {
        if (Build.VERSION.SDK_INT < 33 || ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") == 0 || Settings.INSTANCE.askedNotifications(this)) {
            return;
        }
        Settings.INSTANCE.rememberAskedNotifications(this);
        this.notificationPermission.launch("android.permission.POST_NOTIFICATIONS");
    }

    private final void backToConnect() {
        Session.INSTANCE.clear();
        startActivity(new Intent(this, (Class<?>) ConnectActivity.class).addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void say(String message) {
        ActivityMainBinding activityMainBinding = this.views;
        if (activityMainBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
            activityMainBinding = null;
        }
        Snackbar.make(activityMainBinding.getRoot(), message, 0).show();
    }
}
