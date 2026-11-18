package com.mattiadoronzo.sonixlink;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mattiadoronzo.sonixlink.databinding.FragmentBrowseBinding;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: BrowseFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000±\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\n\u0018\u0000 Z2\u00020\u00012\u00020\u0002:\u0001ZB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\u0006H\u0002J\b\u0010'\u001a\u00020\u0006H\u0002J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*H\u0002J\u0012\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u001aH\u0002J\u001c\u0010.\u001a\u00020\u00062\b\b\u0002\u0010/\u001a\u00020 2\b\b\u0002\u00100\u001a\u00020 H\u0002J&\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\r2\u0014\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0002J$\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010<\u001a\u00020\u0006H\u0016J\b\u0010=\u001a\u00020\u0006H\u0016J\u0010\u0010>\u001a\u00020\u00062\u0006\u0010?\u001a\u00020@H\u0016J\b\u0010A\u001a\u00020\u0006H\u0016J\b\u0010B\u001a\u00020\u0006H\u0016J\b\u0010C\u001a\u00020\u0006H\u0016J\b\u0010D\u001a\u00020\u0006H\u0016J\u0018\u0010E\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u00122\u0006\u0010G\u001a\u00020\u001aH\u0002J\u0018\u0010H\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u00122\u0006\u0010G\u001a\u00020\u001aH\u0002J\b\u0010I\u001a\u00020\u0006H\u0016J\b\u0010J\u001a\u00020\u0006H\u0016J\u001a\u0010K\u001a\u00020\u00062\u0006\u0010L\u001a\u0002052\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u0016\u0010M\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u0011H\u0002J\b\u0010N\u001a\u00020\u0006H\u0002J\b\u0010O\u001a\u00020\u0006H\u0002J \u0010P\u001a\b\u0012\u0004\u0012\u00020\u001a0Q2\u0006\u0010R\u001a\u00020S2\b\u0010-\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010T\u001a\u00020 2\u0006\u0010G\u001a\u00020\u001aH\u0002J\u0010\u0010U\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010V\u001a\u00020\u0006H\u0002J\b\u0010W\u001a\u00020\u0006H\u0002J\b\u0010X\u001a\u00020\u0006H\u0002J\b\u0010Y\u001a\u00020\u0006H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R6\u0010\u000f\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00110\u0010j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006["}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/BrowseFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/mattiadoronzo/sonixlink/MainActivity$LibraryListener;", "()V", "accentWatch", "Lkotlin/Function0;", "", "adapter", "Lcom/mattiadoronzo/sonixlink/RowAdapter;", "back", "com/mattiadoronzo/sonixlink/BrowseFragment$back$1", "Lcom/mattiadoronzo/sonixlink/BrowseFragment$back$1;", "folderParent", "", "folderPath", "folderScroll", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "", "Lkotlin/collections/ArrayList;", "hideHint", "Ljava/lang/Runnable;", "hint", "Landroid/os/Handler;", "hintAccent", "opened", "Lcom/mattiadoronzo/sonixlink/Row;", "savedOffset", "savedRow", BrowseFragment.ARG_SECTION, "Lcom/mattiadoronzo/sonixlink/Section;", "staleWhileSelecting", "", "views", "Lcom/mattiadoronzo/sonixlink/databinding/FragmentBrowseBinding;", "actOnSelection", "action", "Lcom/mattiadoronzo/sonixlink/Selection$Action;", "buildLetterStrip", "hideHintSoon", "jumpTo", "letter", "", "leadingFor", "Lcom/mattiadoronzo/sonixlink/RowAdapter$Leading;", "category", "load", "restore", "keepScroll", "loadFolder", "path", "scroll", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onFavouritesChanged", "onNowPlaying", "state", "Lcom/mattiadoronzo/sonixlink/PlayerState;", "onOrderChanged", "onPause", "onPlaylistsChanged", "onResume", "onRowClicked", "at", "row", "onRowLongPressed", "onStart", "onStop", "onViewCreated", "view", "playTarget", "reload", "rememberPosition", "rowsFor", "", "library", "Lcom/mattiadoronzo/sonixlink/Library;", "selectable", "showHint", "showPlayMenu", "stopSelection", "updateBack", "updateHeader", "Companion", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class BrowseFragment extends Fragment implements MainActivity.LibraryListener {
    private static final String ARG_SECTION = "section";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long HINT_MS = 450;
    private RowAdapter adapter;
    private int hintAccent;
    private Row opened;
    private int savedOffset;
    private int savedRow;
    private Section section;
    private boolean staleWhileSelecting;
    private FragmentBrowseBinding views;
    private String folderPath = "";
    private String folderParent = "";
    private final ArrayList<Pair<Integer, Integer>> folderScroll = new ArrayList<>();
    private final Handler hint = new Handler(Looper.getMainLooper());
    private final Runnable hideHint = new Runnable() { // from class: com.mattiadoronzo.sonixlink.BrowseFragment$$ExternalSyntheticLambda3
        @Override // java.lang.Runnable
        public final void run() {
            BrowseFragment.hideHint$lambda$0(this.f$0);
        }
    };
    private final Function0<Unit> accentWatch = new Function0<Unit>() { // from class: com.mattiadoronzo.sonixlink.BrowseFragment$accentWatch$1
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
            this.this$0.hintAccent = 0;
            if (this.this$0.adapter != null) {
                RowAdapter rowAdapter = this.this$0.adapter;
                if (rowAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    rowAdapter = null;
                }
                rowAdapter.repaint();
                this.this$0.updateHeader();
            }
        }
    };
    private final BrowseFragment$back$1 back = new BrowseFragment$back$1(this);

    /* JADX INFO: compiled from: BrowseFragment.kt */
    @Metadata(m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Section.values().length];
            try {
                iArr[Section.TRACKS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Section.ALBUMS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Section.ARTISTS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[Section.ALBUM_ARTISTS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[Section.FAVOURITES.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[Section.PLAYLISTS.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[Section.FOLDERS.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: compiled from: BrowseFragment.kt */
    @Metadata(m147d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/BrowseFragment$Companion;", "", "()V", "ARG_SECTION", "", "HINT_MS", "", "of", "Lcom/mattiadoronzo/sonixlink/BrowseFragment;", BrowseFragment.ARG_SECTION, "Lcom/mattiadoronzo/sonixlink/Section;", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: of */
        public final BrowseFragment m143of(Section section) {
            Intrinsics.checkNotNullParameter(section, "section");
            BrowseFragment $this$of_u24lambda_u241 = new BrowseFragment();
            Bundle $this$of_u24lambda_u241_u24lambda_u240 = new Bundle();
            $this$of_u24lambda_u241_u24lambda_u240.putString(BrowseFragment.ARG_SECTION, section.name());
            $this$of_u24lambda_u241.setArguments($this$of_u24lambda_u241_u24lambda_u240);
            return $this$of_u24lambda_u241;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hideHint$lambda$0(BrowseFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentBrowseBinding fragmentBrowseBinding = this$0.views;
        FrameLayout frameLayout = fragmentBrowseBinding != null ? fragmentBrowseBinding.indexHint : null;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String string;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(ARG_SECTION)) == null) {
            string = "TRACKS";
        }
        this.section = Section.valueOf(string);
        FragmentBrowseBinding binding = FragmentBrowseBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(binding, "inflate(...)");
        this.views = binding;
        this.hintAccent = 0;
        Section section = this.section;
        RowAdapter rowAdapter = null;
        if (section == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ARG_SECTION);
            section = null;
        }
        this.adapter = new RowAdapter(section.getIcon(), leadingFor(this.opened), new Function2<Integer, Row, Unit>() { // from class: com.mattiadoronzo.sonixlink.BrowseFragment.onCreateView.1
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
                BrowseFragment.this.onRowClicked(at, row);
            }
        });
        RowAdapter rowAdapter2 = this.adapter;
        if (rowAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            rowAdapter2 = null;
        }
        rowAdapter2.setOnLongPress(new Function2<Integer, Row, Unit>() { // from class: com.mattiadoronzo.sonixlink.BrowseFragment.onCreateView.2
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
                BrowseFragment.this.onRowLongPressed(at, row);
            }
        });
        RowAdapter rowAdapter3 = this.adapter;
        if (rowAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            rowAdapter3 = null;
        }
        Playmark playmark = Playmark.INSTANCE;
        Section section2 = this.section;
        if (section2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ARG_SECTION);
            section2 = null;
        }
        rowAdapter3.setMarksCategory(playmark.forSection(section2));
        RowAdapter rowAdapter4 = this.adapter;
        if (rowAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            rowAdapter4 = null;
        }
        rowAdapter4.setPlaying(Session.INSTANCE.getState());
        binding.list.setLayoutManager(new LinearLayoutManager(requireContext()));
        RecyclerView recyclerView = binding.list;
        RowAdapter rowAdapter5 = this.adapter;
        if (rowAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            rowAdapter = rowAdapter5;
        }
        recyclerView.setAdapter(rowAdapter);
        binding.headerBack.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.BrowseFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BrowseFragment.onCreateView$lambda$1(this.f$0, view);
            }
        });
        binding.playMenu.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.BrowseFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BrowseFragment.onCreateView$lambda$2(this.f$0, view);
            }
        });
        binding.selClose.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.BrowseFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BrowseFragment.onCreateView$lambda$3(this.f$0, view);
            }
        });
        binding.selQueue.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.BrowseFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BrowseFragment.onCreateView$lambda$4(this.f$0, view);
            }
        });
        binding.selFavAdd.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.BrowseFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BrowseFragment.onCreateView$lambda$5(this.f$0, view);
            }
        });
        binding.selFavRemove.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.BrowseFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BrowseFragment.onCreateView$lambda$6(this.f$0, view);
            }
        });
        binding.selPlaylistAdd.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.BrowseFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BrowseFragment.onCreateView$lambda$7(this.f$0, view);
            }
        });
        binding.selPlaylistRemove.setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.BrowseFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BrowseFragment.onCreateView$lambda$8(this.f$0, view);
            }
        });
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        onBackPressedDispatcher.addCallback(viewLifecycleOwner, this.back);
        LinearLayout root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1(BrowseFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.back.handleOnBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$2(BrowseFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showPlayMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$3(BrowseFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.stopSelection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$4(BrowseFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.actOnSelection(Selection.Action.QUEUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$5(BrowseFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.actOnSelection(Selection.Action.FAVOURITES_ADD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6(BrowseFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.actOnSelection(Selection.Action.FAVOURITES_REMOVE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$7(BrowseFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.actOnSelection(Selection.Action.PLAYLIST_ADD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$8(BrowseFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.actOnSelection(Selection.Action.PLAYLIST_REMOVE);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Section section = this.section;
        if (section == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ARG_SECTION);
            section = null;
        }
        if (section == Section.FOLDERS) {
            loadFolder(this.folderPath, null);
        } else {
            load$default(this, false, false, 3, null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        FragmentActivity activity = getActivity();
        RowAdapter rowAdapter = null;
        MainActivity mainActivity = activity instanceof MainActivity ? (MainActivity) activity : null;
        if (mainActivity != null) {
            mainActivity.addLibraryListener(this);
        }
        Session.INSTANCE.watchAccent(this.accentWatch);
        RowAdapter rowAdapter2 = this.adapter;
        if (rowAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            rowAdapter = rowAdapter2;
        }
        rowAdapter.setPlaying(Session.INSTANCE.getState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        FragmentActivity activity = getActivity();
        MainActivity mainActivity = activity instanceof MainActivity ? (MainActivity) activity : null;
        if (mainActivity != null) {
            mainActivity.removeLibraryListener(this);
        }
        Session.INSTANCE.unwatchAccent(this.accentWatch);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        updateBack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:23:0x003e  */
    public final void updateBack() {
        BrowseFragment$back$1 browseFragment$back$1 = this.back;
        boolean z = false;
        if (isResumed()) {
            RowAdapter rowAdapter = this.adapter;
            Section section = null;
            if (rowAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                rowAdapter = null;
            }
            if (rowAdapter.getSelecting()) {
                z = true;
            } else {
                Section section2 = this.section;
                if (section2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ARG_SECTION);
                } else {
                    section = section2;
                }
                if (section != Section.FOLDERS ? this.opened != null : this.folderParent.length() > 0) {
                    z = true;
                }
            }
        }
        browseFragment$back$1.setEnabled(z);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.back.setEnabled(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.hint.removeCallbacks(this.hideHint);
        this.views = null;
    }

    @Override // com.mattiadoronzo.sonixlink.MainActivity.LibraryListener
    public void onOrderChanged() {
        Section section = this.section;
        if (section == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ARG_SECTION);
            section = null;
        }
        if (section != Section.FOLDERS) {
            Section section2 = this.section;
            if (section2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ARG_SECTION);
                section2 = null;
            }
            if (section2 != Section.PLAYLISTS) {
                load$default(this, false, false, 2, null);
            }
        }
    }

    @Override // com.mattiadoronzo.sonixlink.MainActivity.LibraryListener
    public void onFavouritesChanged() {
        Section section = this.section;
        if (section == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ARG_SECTION);
            section = null;
        }
        if (section == Section.FAVOURITES && this.opened == null) {
            reload();
        }
    }

    @Override // com.mattiadoronzo.sonixlink.MainActivity.LibraryListener
    public void onPlaylistsChanged() {
        Section section = this.section;
        if (section == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ARG_SECTION);
            section = null;
        }
        if (section == Section.PLAYLISTS) {
            reload();
        }
    }

    @Override // com.mattiadoronzo.sonixlink.MainActivity.LibraryListener
    public void onNowPlaying(PlayerState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (this.adapter != null) {
            RowAdapter rowAdapter = this.adapter;
            if (rowAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                rowAdapter = null;
            }
            rowAdapter.setPlaying(state);
        }
    }

    private final void reload() {
        if (this.views == null) {
            return;
        }
        RowAdapter rowAdapter = this.adapter;
        if (rowAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            rowAdapter = null;
        }
        if (rowAdapter.getSelecting()) {
            this.staleWhileSelecting = true;
        } else {
            load$default(this, false, true, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onRowClicked(int at, Row row) {
        Pair pairM155to;
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
        Section section = this.section;
        if (section == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ARG_SECTION);
            section = null;
        }
        if (section == Section.FOLDERS) {
            if (row.isTrack()) {
                FragmentActivity activity = getActivity();
                MainActivity mainActivity = activity instanceof MainActivity ? (MainActivity) activity : null;
                if (mainActivity != null) {
                    mainActivity.play(row.getPath(), "folder", "");
                    return;
                }
                return;
            }
            rememberPosition();
            this.folderScroll.add(TuplesKt.m155to(Integer.valueOf(this.savedRow), Integer.valueOf(this.savedOffset)));
            loadFolder(row.getFilter(), null);
            return;
        }
        if (row.isTrack()) {
            Row row2 = this.opened;
            Section section2 = this.section;
            if (section2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ARG_SECTION);
                section2 = null;
            }
            if (section2 == Section.FAVOURITES) {
                pairM155to = TuplesKt.m155to("favourites", "");
            } else if (row2 == null) {
                pairM155to = TuplesKt.m155to("all", "");
            } else {
                Section section3 = this.section;
                if (section3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ARG_SECTION);
                    section3 = null;
                }
                if (section3 == Section.ALBUMS) {
                    pairM155to = TuplesKt.m155to("album", row2.getFilter());
                } else {
                    Section section4 = this.section;
                    if (section4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(ARG_SECTION);
                        section4 = null;
                    }
                    if (section4 == Section.ARTISTS) {
                        pairM155to = TuplesKt.m155to("artist", row2.getFilter());
                    } else {
                        Section section5 = this.section;
                        if (section5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(ARG_SECTION);
                            section5 = null;
                        }
                        if (section5 == Section.ALBUM_ARTISTS) {
                            pairM155to = TuplesKt.m155to("album_artist", row2.getFilter());
                        } else {
                            Section section6 = this.section;
                            if (section6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(ARG_SECTION);
                                section6 = null;
                            }
                            pairM155to = section6 == Section.PLAYLISTS ? TuplesKt.m155to("playlist", StringsKt.removePrefix(row2.getFilter(), (CharSequence) "M3U_")) : TuplesKt.m155to("all", "");
                        }
                    }
                }
            }
            String str = (String) pairM155to.component1();
            String str2 = (String) pairM155to.component2();
            FragmentActivity activity2 = getActivity();
            MainActivity mainActivity2 = activity2 instanceof MainActivity ? (MainActivity) activity2 : null;
            if (mainActivity2 != null) {
                mainActivity2.play(row.getPath(), str, str2);
                return;
            }
            return;
        }
        rememberPosition();
        this.opened = row;
        updateBack();
        load$default(this, false, false, 3, null);
    }

    private final void rememberPosition() {
        RecyclerView recyclerView;
        FragmentBrowseBinding fragmentBrowseBinding = this.views;
        RecyclerView.LayoutManager layoutManager = (fragmentBrowseBinding == null || (recyclerView = fragmentBrowseBinding.list) == null) ? null : recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null) {
            return;
        }
        LinearLayoutManager manager = linearLayoutManager;
        this.savedRow = RangesKt.coerceAtLeast(manager.findFirstVisibleItemPosition(), 0);
        View viewFindViewByPosition = manager.findViewByPosition(this.savedRow);
        this.savedOffset = viewFindViewByPosition != null ? viewFindViewByPosition.getTop() : 0;
    }

    static /* synthetic */ void load$default(BrowseFragment browseFragment, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        browseFragment.load(z, z2);
    }

    private final void load(boolean restore, boolean keepScroll) {
        View viewFindViewByPosition;
        FragmentBrowseBinding binding = this.views;
        if (binding == null) {
            return;
        }
        Library library = Session.INSTANCE.getLibrary();
        Row category = this.opened;
        RecyclerView.LayoutManager layoutManager = binding.list.getLayoutManager();
        LinearLayoutManager shown = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        int keptRow = shown != null ? RangesKt.coerceAtLeast(shown.findFirstVisibleItemPosition(), 0) : 0;
        int keptOffset = (shown == null || (viewFindViewByPosition = shown.findViewByPosition(keptRow)) == null) ? 0 : viewFindViewByPosition.getTop();
        updateHeader();
        binding.progress.setVisibility(0);
        binding.emptyText.setVisibility(8);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09561(category, restore, keepScroll, keptRow, keptOffset, library, null), 3, null);
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.BrowseFragment$load$1 */
    /* JADX INFO: compiled from: BrowseFragment.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.BrowseFragment$load$1", m164f = "BrowseFragment.kt", m165i = {}, m166l = {275}, m167m = "invokeSuspend", m168n = {}, m169s = {})
    static final class C09561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Row $category;
        final /* synthetic */ boolean $keepScroll;
        final /* synthetic */ int $keptOffset;
        final /* synthetic */ int $keptRow;
        final /* synthetic */ Library $library;
        final /* synthetic */ boolean $restore;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09561(Row row, boolean z, boolean z2, int i, int i2, Library library, Continuation<? super C09561> continuation) {
            super(2, continuation);
            this.$category = row;
            this.$restore = z;
            this.$keepScroll = z2;
            this.$keptRow = i;
            this.$keptOffset = i2;
            this.$library = library;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BrowseFragment.this.new C09561(this.$category, this.$restore, this.$keepScroll, this.$keptRow, this.$keptOffset, this.$library, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            C09561 c09561;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c09561 = this;
                    c09561.label = 1;
                    Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new BrowseFragment$load$1$rows$1(c09561.$library, BrowseFragment.this, c09561.$category, null), c09561);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objWithContext;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    c09561 = this;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            List<Row> list = (List) $result;
            FragmentBrowseBinding current = BrowseFragment.this.views;
            if (current == null) {
                return Unit.INSTANCE;
            }
            RowAdapter rowAdapter = BrowseFragment.this.adapter;
            if (rowAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                rowAdapter = null;
            }
            rowAdapter.setLeading(BrowseFragment.this.leadingFor(c09561.$category));
            current.progress.setVisibility(8);
            RowAdapter rowAdapter2 = BrowseFragment.this.adapter;
            if (rowAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                rowAdapter2 = null;
            }
            rowAdapter2.submit(list);
            current.emptyText.setVisibility(list.isEmpty() ? 0 : 8);
            RecyclerView.LayoutManager layoutManager = current.list.getLayoutManager();
            LinearLayoutManager manager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
            if (c09561.$restore) {
                if (manager != null) {
                    manager.scrollToPositionWithOffset(BrowseFragment.this.savedRow, BrowseFragment.this.savedOffset);
                }
            } else if (c09561.$keepScroll) {
                if (manager != null) {
                    manager.scrollToPositionWithOffset(c09561.$keptRow, c09561.$keptOffset);
                }
            } else {
                current.list.scrollToPosition(0);
            }
            BrowseFragment.this.buildLetterStrip();
            BrowseFragment.this.updateHeader();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void buildLetterStrip() {
        int kind;
        final List<Character> listEmptyList;
        FragmentBrowseBinding binding = this.views;
        if (binding == null) {
            return;
        }
        LinearLayout letterStrip = binding.letterStrip;
        Intrinsics.checkNotNullExpressionValue(letterStrip, "letterStrip");
        letterStrip.removeAllViews();
        Section section = this.section;
        RowAdapter rowAdapter = null;
        if (section == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ARG_SECTION);
            section = null;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[section.ordinal()]) {
            case 1:
                kind = 0;
                break;
            case 2:
                kind = 1;
                break;
            case 3:
                kind = 2;
                break;
            case 4:
                kind = 3;
                break;
            default:
                kind = -1;
                break;
        }
        boolean wanted = this.opened == null && kind >= 0 && !Session.INSTANCE.getSort().byDate(kind);
        if (wanted) {
            RowAdapter rowAdapter2 = this.adapter;
            if (rowAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                rowAdapter = rowAdapter2;
            }
            listEmptyList = rowAdapter.letters();
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        if (listEmptyList.size() < 4) {
            letterStrip.setVisibility(8);
            binding.indexHint.setVisibility(8);
            this.hint.removeCallbacks(this.hideHint);
            binding.list.setPadding(0, 0, 0, 0);
            return;
        }
        binding.list.setPadding(0, 0, (int) (26 * getResources().getDisplayMetrics().density), 0);
        int secondary = ContextCompat.getColor(requireContext(), C1020R.color.text_secondary);
        Iterator<Character> it = listEmptyList.iterator();
        while (it.hasNext()) {
            char letter = it.next().charValue();
            TextView $this$buildLetterStrip_u24lambda_u249 = new TextView(requireContext());
            $this$buildLetterStrip_u24lambda_u249.setText(String.valueOf(letter));
            $this$buildLetterStrip_u24lambda_u249.setTextSize(10.0f);
            $this$buildLetterStrip_u24lambda_u249.setTextColor(secondary);
            $this$buildLetterStrip_u24lambda_u249.setGravity(17);
            $this$buildLetterStrip_u24lambda_u249.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
            letterStrip.addView($this$buildLetterStrip_u24lambda_u249);
        }
        letterStrip.setVisibility(0);
        letterStrip.setOnTouchListener(new View.OnTouchListener() { // from class: com.mattiadoronzo.sonixlink.BrowseFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return BrowseFragment.buildLetterStrip$lambda$10(listEmptyList, this, view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean buildLetterStrip$lambda$10(List letters, BrowseFragment this$0, View view, MotionEvent event) {
        Intrinsics.checkNotNullParameter(letters, "$letters");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        switch (event.getAction()) {
            case 0:
            case 2:
                int count = letters.size();
                if (count > 0 && view.getHeight() > 0) {
                    int at = RangesKt.coerceIn((int) ((event.getY() / view.getHeight()) * count), 0, count - 1);
                    this$0.showHint(((Character) letters.get(at)).charValue());
                    this$0.jumpTo(((Character) letters.get(at)).charValue());
                    break;
                }
                break;
            case 1:
            default:
                this$0.hideHintSoon();
                view.performClick();
                break;
        }
        return true;
    }

    private final void showHint(char letter) {
        FragmentBrowseBinding binding = this.views;
        if (binding == null) {
            return;
        }
        if (this.hintAccent != Session.INSTANCE.getAccent()) {
            this.hintAccent = Session.INSTANCE.getAccent();
            FrameLayout frameLayout = binding.indexHint;
            GradientDrawable $this$showHint_u24lambda_u2411 = new GradientDrawable();
            $this$showHint_u24lambda_u2411.setCornerRadius(26 * getResources().getDisplayMetrics().density);
            $this$showHint_u24lambda_u2411.setColor(this.hintAccent);
            $this$showHint_u24lambda_u2411.setAlpha(230);
            frameLayout.setBackground($this$showHint_u24lambda_u2411);
        }
        binding.indexHintLetter.setText(String.valueOf(letter));
        binding.indexHint.setVisibility(0);
        this.hint.removeCallbacks(this.hideHint);
    }

    private final void hideHintSoon() {
        this.hint.removeCallbacks(this.hideHint);
        this.hint.postDelayed(this.hideHint, HINT_MS);
    }

    private final void jumpTo(char letter) {
        FragmentBrowseBinding binding = this.views;
        if (binding == null) {
            return;
        }
        RowAdapter rowAdapter = this.adapter;
        if (rowAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            rowAdapter = null;
        }
        int at = rowAdapter.firstStartingWith(letter);
        if (at < 0) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = binding.list.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager != null) {
            linearLayoutManager.scrollToPositionWithOffset(at, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RowAdapter.Leading leadingFor(Row category) {
        if (category != null) {
            return RowAdapter.Leading.ICON;
        }
        Section section = this.section;
        Section section2 = null;
        if (section == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ARG_SECTION);
            section = null;
        }
        if (section != Section.ARTISTS) {
            Section section3 = this.section;
            if (section3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ARG_SECTION);
                section3 = null;
            }
            if (section3 != Section.ALBUM_ARTISTS) {
                Section section4 = this.section;
                if (section4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ARG_SECTION);
                } else {
                    section2 = section4;
                }
                if (section2 != Section.PLAYLISTS) {
                    return RowAdapter.Leading.ICON;
                }
            }
        }
        return RowAdapter.Leading.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:19:0x0037  */
    public final void updateHeader() {
        boolean inFolder;
        String string;
        FragmentBrowseBinding binding = this.views;
        if (binding == null) {
            return;
        }
        RowAdapter rowAdapter = this.adapter;
        Section section = null;
        if (rowAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            rowAdapter = null;
        }
        boolean selecting = rowAdapter.getSelecting();
        Row category = this.opened;
        Section section2 = this.section;
        if (section2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ARG_SECTION);
            section2 = null;
        }
        int i = 0;
        if (section2 != Section.FOLDERS) {
            inFolder = false;
        } else {
            if (this.folderParent.length() > 0) {
                inFolder = true;
            } else {
                inFolder = false;
            }
        }
        boolean canGoBack = !selecting && (category != null || inFolder);
        boolean play = (selecting || playTarget() == null) ? false : true;
        binding.headerBack.setVisibility(canGoBack ? 0 : 8);
        TextView textView = binding.headerTitle;
        if (selecting) {
            int i2 = C1020R.string.selected_count;
            RowAdapter rowAdapter2 = this.adapter;
            if (rowAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                rowAdapter2 = null;
            }
            string = getString(i2, Integer.valueOf(rowAdapter2.getSelected().size()));
        } else if (category != null) {
            string = category.getTitle();
        } else if (inFolder) {
            string = StringsKt.substringAfterLast$default(this.folderPath, '/', (String) null, 2, (Object) null);
        } else if (play) {
            Section section3 = this.section;
            if (section3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ARG_SECTION);
                section3 = null;
            }
            string = getString(section3.getTitleRes());
        }
        textView.setText(string);
        Section section4 = this.section;
        if (section4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ARG_SECTION);
            section4 = null;
        }
        boolean inFavourites = section4 == Section.FAVOURITES;
        Section section5 = this.section;
        if (section5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ARG_SECTION);
        } else {
            section = section5;
        }
        boolean inPlaylist = section == Section.PLAYLISTS && category != null;
        ImageButton selQueue = binding.selQueue;
        Intrinsics.checkNotNullExpressionValue(selQueue, "selQueue");
        updateHeader$show(selQueue, selecting);
        ImageButton selFavAdd = binding.selFavAdd;
        Intrinsics.checkNotNullExpressionValue(selFavAdd, "selFavAdd");
        updateHeader$show(selFavAdd, selecting && !inFavourites);
        ImageButton selPlaylistAdd = binding.selPlaylistAdd;
        Intrinsics.checkNotNullExpressionValue(selPlaylistAdd, "selPlaylistAdd");
        updateHeader$show(selPlaylistAdd, selecting && !inPlaylist);
        ImageButton selFavRemove = binding.selFavRemove;
        Intrinsics.checkNotNullExpressionValue(selFavRemove, "selFavRemove");
        updateHeader$show(selFavRemove, selecting && inFavourites);
        ImageButton selPlaylistRemove = binding.selPlaylistRemove;
        Intrinsics.checkNotNullExpressionValue(selPlaylistRemove, "selPlaylistRemove");
        updateHeader$show(selPlaylistRemove, selecting && inPlaylist);
        ImageButton selClose = binding.selClose;
        Intrinsics.checkNotNullExpressionValue(selClose, "selClose");
        updateHeader$show(selClose, selecting);
        ImageButton playMenu = binding.playMenu;
        Intrinsics.checkNotNullExpressionValue(playMenu, "playMenu");
        updateHeader$show(playMenu, play);
        if (play) {
            binding.playMenu.setImageTintList(ColorStateList.valueOf(Session.INSTANCE.getAccent()));
        }
        LinearLayout linearLayout = binding.header;
        if (!selecting && !canGoBack && !play) {
            i = 8;
        }
        linearLayout.setVisibility(i);
        updateBack();
    }

    private static final void updateHeader$show(View button, boolean wanted) {
        button.setVisibility(wanted ? 0 : 8);
    }

    private final Pair<String, String> playTarget() {
        Row category = this.opened;
        Section section = this.section;
        if (section == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ARG_SECTION);
            section = null;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[section.ordinal()]) {
            case 1:
                if (category == null) {
                    return TuplesKt.m155to("all", "");
                }
                return null;
            case 2:
                return category == null ? TuplesKt.m155to("albums", "") : TuplesKt.m155to("album", category.getFilter());
            case 3:
                if (category != null) {
                    return TuplesKt.m155to("artist", category.getFilter());
                }
                return null;
            case 4:
                if (category != null) {
                    return TuplesKt.m155to("album_artist", category.getFilter());
                }
                return null;
            case 5:
                return TuplesKt.m155to("favourites", "");
            case 6:
                if (category != null) {
                    return TuplesKt.m155to("playlist", StringsKt.removePrefix(category.getFilter(), (CharSequence) "M3U_"));
                }
                return null;
            case 7:
                return null;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final void showPlayMenu() {
        Pair<String, String> pairPlayTarget = playTarget();
        if (pairPlayTarget == null) {
            return;
        }
        final String list = pairPlayTarget.component1();
        final String value = pairPlayTarget.component2();
        FragmentActivity activity = getActivity();
        final MainActivity main = activity instanceof MainActivity ? (MainActivity) activity : null;
        if (main == null) {
            return;
        }
        String[] choices = {getString(C1020R.string.play_random), getString(C1020R.string.play_sequence), getString(C1020R.string.play_random_track)};
        new AlertDialog.Builder(requireContext()).setItems(choices, new DialogInterface.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.BrowseFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                BrowseFragment.showPlayMenu$lambda$15(main, this, list, value, dialogInterface, i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPlayMenu$lambda$15(MainActivity main, BrowseFragment this$0, final String list, final String value, DialogInterface dialogInterface, int which) {
        Intrinsics.checkNotNullParameter(main, "$main");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(list, "$list");
        Intrinsics.checkNotNullParameter(value, "$value");
        switch (which) {
            case 0:
                MainActivity.perform$default(main, null, null, new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.BrowseFragment$showPlayMenu$1$1
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
                        it.playAll(list, value, "shuffle");
                    }
                }, 3, null);
                break;
            case 1:
                MainActivity.perform$default(main, null, null, new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.BrowseFragment$showPlayMenu$1$2
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
                        it.playAll(list, value, "sequence");
                    }
                }, 3, null);
                break;
            default:
                MainActivity.perform$default(main, this$0.getString(C1020R.string.done_queue), null, new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.BrowseFragment$showPlayMenu$1$3
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
                        it.playAll(list, value, "random");
                    }
                }, 2, null);
                break;
        }
    }

    private final boolean selectable(Row row) {
        if (row.getKind() != Row.Kind.ROW) {
            return false;
        }
        if (row.isTrack()) {
            return true;
        }
        Section section = this.section;
        if (section == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ARG_SECTION);
            section = null;
        }
        return section != Section.FOLDERS && row.getFilter().length() > 0;
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
        if (this.staleWhileSelecting) {
            this.staleWhileSelecting = false;
            load$default(this, false, true, 1, null);
        }
    }

    private final void actOnSelection(Selection.Action action) {
        String filter;
        FragmentActivity activity = getActivity();
        MainActivity main = activity instanceof MainActivity ? (MainActivity) activity : null;
        if (main == null) {
            return;
        }
        RowAdapter rowAdapter = this.adapter;
        if (rowAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            rowAdapter = null;
        }
        List<Integer> selected = rowAdapter.getSelected();
        if (selected.isEmpty()) {
            return;
        }
        Row row = this.opened;
        String strRemovePrefix = (row == null || (filter = row.getFilter()) == null) ? null : StringsKt.removePrefix(filter, (CharSequence) "M3U_");
        if (strRemovePrefix == null) {
            strRemovePrefix = "";
        }
        String playlistName = strRemovePrefix;
        List<Integer> $this$mapNotNull$iv = selected;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            int it = ((Number) element$iv$iv$iv).intValue();
            Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
            RowAdapter rowAdapter2 = this.adapter;
            if (rowAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                rowAdapter2 = null;
            }
            Row rowRowAt = rowAdapter2.rowAt(it);
            if (rowRowAt != null) {
                destination$iv$iv.add(rowRowAt);
            }
            $this$mapNotNull$iv = $this$mapNotNull$iv2;
        }
        List rows = (List) destination$iv$iv;
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09541(action, this, main, playlistName, rows, selected, null), 3, null);
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.BrowseFragment$actOnSelection$1 */
    /* JADX INFO: compiled from: BrowseFragment.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.BrowseFragment$actOnSelection$1", m164f = "BrowseFragment.kt", m165i = {}, m166l = {541}, m167m = "invokeSuspend", m168n = {}, m169s = {})
    static final class C09541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Selection.Action $action;
        final /* synthetic */ MainActivity $main;
        final /* synthetic */ String $playlistName;
        final /* synthetic */ List<Integer> $positions;
        final /* synthetic */ List<Row> $rows;
        int label;
        final /* synthetic */ BrowseFragment this$0;

        /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.BrowseFragment$actOnSelection$1$WhenMappings */
        /* JADX INFO: compiled from: BrowseFragment.kt */
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
                    iArr[Selection.Action.PLAYLIST_REMOVE.ordinal()] = 4;
                } catch (NoSuchFieldError e4) {
                }
                try {
                    iArr[Selection.Action.PLAYLIST_ADD.ordinal()] = 5;
                } catch (NoSuchFieldError e5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09541(Selection.Action action, BrowseFragment browseFragment, MainActivity mainActivity, String str, List<Row> list, List<Integer> list2, Continuation<? super C09541> continuation) {
            super(2, continuation);
            this.$action = action;
            this.this$0 = browseFragment;
            this.$main = mainActivity;
            this.$playlistName = str;
            this.$rows = list;
            this.$positions = list2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09541(this.$action, this.this$0, this.$main, this.$playlistName, this.$rows, this.$positions, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09541) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            C09541 c09541;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c09541 = this;
                    c09541.label = 1;
                    Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new BrowseFragment$actOnSelection$1$paths$1(c09541.$rows, c09541.this$0, null), c09541);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objWithContext;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    c09541 = this;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            final List paths = (List) $result;
            if (paths.isEmpty()) {
                return Unit.INSTANCE;
            }
            switch (WhenMappings.$EnumSwitchMapping$0[c09541.$action.ordinal()]) {
                case 1:
                    c09541.this$0.stopSelection();
                    MainActivity.perform$default(c09541.$main, c09541.this$0.getString(C1020R.string.done_queue), null, new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.BrowseFragment.actOnSelection.1.1
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
                    }, 2, null);
                    break;
                case 2:
                    c09541.this$0.stopSelection();
                    MainActivity mainActivity = c09541.$main;
                    String string = c09541.this$0.getString(C1020R.string.done_fav);
                    final MainActivity mainActivity2 = c09541.$main;
                    mainActivity.perform(string, new Function0<Unit>() { // from class: com.mattiadoronzo.sonixlink.BrowseFragment.actOnSelection.1.2
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
                            mainActivity2.favouritesChanged(1500L);
                        }
                    }, new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.BrowseFragment.actOnSelection.1.3
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
                    c09541.this$0.stopSelection();
                    MainActivity mainActivity3 = c09541.$main;
                    String string2 = c09541.this$0.getString(C1020R.string.done_removed);
                    final MainActivity mainActivity4 = c09541.$main;
                    mainActivity3.perform(string2, new Function0<Unit>() { // from class: com.mattiadoronzo.sonixlink.BrowseFragment.actOnSelection.1.4
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
                            MainActivity.favouritesChanged$default(mainActivity4, 0L, 1, null);
                        }
                    }, new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.BrowseFragment.actOnSelection.1.5
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
                    if (c09541.$playlistName.length() == 0) {
                        return Unit.INSTANCE;
                    }
                    MainActivity mainActivity5 = c09541.$main;
                    String string3 = c09541.this$0.getString(C1020R.string.done_removed);
                    final BrowseFragment browseFragment = c09541.this$0;
                    final List<Integer> list = c09541.$positions;
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: com.mattiadoronzo.sonixlink.BrowseFragment.actOnSelection.1.6
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
                            RowAdapter rowAdapter = browseFragment.adapter;
                            if (rowAdapter == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                                rowAdapter = null;
                            }
                            rowAdapter.removeAt(list);
                            browseFragment.stopSelection();
                        }
                    };
                    final String str = c09541.$playlistName;
                    mainActivity5.perform(string3, function0, new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.BrowseFragment.actOnSelection.1.7
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
                            it.selection("playlist_remove", paths, str);
                        }
                    });
                    break;
                case 5:
                    Selection selection = Selection.INSTANCE;
                    Context contextRequireContext = c09541.this$0.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                    LifecycleOwner viewLifecycleOwner = c09541.this$0.getViewLifecycleOwner();
                    Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                    LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner);
                    final BrowseFragment browseFragment2 = c09541.this$0;
                    final MainActivity mainActivity6 = c09541.$main;
                    selection.pickPlaylist(contextRequireContext, lifecycleScope, new Function1<String, Unit>() { // from class: com.mattiadoronzo.sonixlink.BrowseFragment.actOnSelection.1.8
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                            invoke2(str2);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(final String name) {
                            Intrinsics.checkNotNullParameter(name, "name");
                            browseFragment2.stopSelection();
                            MainActivity mainActivity7 = mainActivity6;
                            String string4 = browseFragment2.getString(C1020R.string.done_playlist);
                            final List<String> list2 = paths;
                            MainActivity.perform$default(mainActivity7, string4, null, new Function1<PlayerClient, Unit>() { // from class: com.mattiadoronzo.sonixlink.BrowseFragment.actOnSelection.1.8.1
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
                                    it.selection("playlist_add", list2, name);
                                }
                            }, 2, null);
                        }
                    });
                    break;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadFolder(String path, Pair<Integer, Integer> scroll) {
        PlayerClient client;
        FragmentBrowseBinding binding = this.views;
        if (binding == null || (client = Session.INSTANCE.getClient()) == null) {
            return;
        }
        binding.progress.setVisibility(0);
        binding.emptyText.setVisibility(8);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09571(scroll, client, path, null), 3, null);
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.BrowseFragment$loadFolder$1 */
    /* JADX INFO: compiled from: BrowseFragment.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.BrowseFragment$loadFolder$1", m164f = "BrowseFragment.kt", m165i = {}, m166l = {606}, m167m = "invokeSuspend", m168n = {}, m169s = {})
    static final class C09571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PlayerClient $client;
        final /* synthetic */ String $path;
        final /* synthetic */ Pair<Integer, Integer> $scroll;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09571(Pair<Integer, Integer> pair, PlayerClient playerClient, String str, Continuation<? super C09571> continuation) {
            super(2, continuation);
            this.$scroll = pair;
            this.$client = playerClient;
            this.$path = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BrowseFragment.this.new C09571(this.$scroll, this.$client, this.$path, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09571) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            C09571 c09571;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c09571 = this;
                    c09571.label = 1;
                    Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new BrowseFragment$loadFolder$1$result$1(c09571.$client, c09571.$path, null), c09571);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objWithContext;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    c09571 = this;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Pair result = (Pair) $result;
            FragmentBrowseBinding current = BrowseFragment.this.views;
            if (current == null) {
                return Unit.INSTANCE;
            }
            current.progress.setVisibility(8);
            if (result == null) {
                current.emptyText.setVisibility(0);
                return Unit.INSTANCE;
            }
            Folder folder = (Folder) result.component1();
            List<Row> list = (List) result.component2();
            BrowseFragment.this.folderPath = folder.getPath();
            BrowseFragment.this.folderParent = folder.getParent();
            BrowseFragment.this.updateBack();
            RowAdapter rowAdapter = BrowseFragment.this.adapter;
            if (rowAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                rowAdapter = null;
            }
            rowAdapter.setLeading(RowAdapter.Leading.ICON);
            RowAdapter rowAdapter2 = BrowseFragment.this.adapter;
            if (rowAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                rowAdapter2 = null;
            }
            rowAdapter2.submit(list);
            current.emptyText.setVisibility(list.isEmpty() ? 0 : 8);
            RecyclerView.LayoutManager layoutManager = current.list.getLayoutManager();
            LinearLayoutManager manager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
            if (c09571.$scroll == null) {
                current.list.scrollToPosition(0);
            } else if (manager != null) {
                manager.scrollToPositionWithOffset(c09571.$scroll.getFirst().intValue(), c09571.$scroll.getSecond().intValue());
            }
            current.letterStrip.setVisibility(8);
            BrowseFragment.this.updateHeader();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Row> rowsFor(Library library, Row category) {
        Section section = this.section;
        if (section == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ARG_SECTION);
            section = null;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[section.ordinal()]) {
            case 1:
                return Library.tracks$default(library, null, 1, null);
            case 2:
                return category == null ? Library.albums$default(library, null, 1, null) : library.tracksOfAlbum(category.getFilter());
            case 3:
                return category == null ? Library.artists$default(library, null, 1, null) : Library.tracksOfArtist$default(library, category.getFilter(), null, 2, null);
            case 4:
                return category == null ? Library.albumArtists$default(library, null, 1, null) : Library.tracksOfAlbumArtist$default(library, category.getFilter(), null, 2, null);
            case 5:
                return LiveLists.INSTANCE.favourites(library);
            case 6:
                LiveLists liveLists = LiveLists.INSTANCE;
                return category == null ? liveLists.playlists(library) : liveLists.playlistTracks(library, category.getFilter());
            case 7:
                return CollectionsKt.emptyList();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
