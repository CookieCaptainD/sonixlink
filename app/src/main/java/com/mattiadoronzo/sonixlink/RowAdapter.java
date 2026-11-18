package com.mattiadoronzo.sonixlink;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.mattiadoronzo.sonixlink.databinding.RowHeaderBinding;
import com.mattiadoronzo.sonixlink.databinding.RowItemBinding;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RowAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0010\u0018\u0000 l2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004lmnoB1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\u0010\u000bJ\u000e\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020-J\b\u0010L\u001a\u00020\u0004H\u0016J\u0010\u0010M\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u0004H\u0016J\u000e\u0010O\u001a\u00020\u00132\u0006\u0010N\u001a\u00020\u0004J\f\u0010P\u001a\b\u0012\u0004\u0012\u00020-0CJ\u0016\u0010Q\u001a\u00020\n2\u0006\u0010R\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\u0004J\u0010\u0010T\u001a\u00020\n2\u0006\u0010U\u001a\u00020VH\u0016J\u0018\u0010W\u001a\u00020\n2\u0006\u0010X\u001a\u00020\u00022\u0006\u0010N\u001a\u00020\u0004H\u0016J\u0018\u0010Y\u001a\u00020\u00022\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020\u0004H\u0016J\u0010\u0010]\u001a\u00020\n2\u0006\u0010U\u001a\u00020VH\u0016J\u0014\u0010^\u001a\u00020\n2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00040`J\u0006\u0010a\u001a\u00020\nJ\u001c\u0010b\u001a\u00020\n2\u0006\u0010c\u001a\u00020\u00042\f\u0010d\u001a\b\u0012\u0004\u0012\u00020\t0CJ\u0010\u0010e\u001a\u0004\u0018\u00010\t2\u0006\u0010N\u001a\u00020\u0004J\f\u0010d\u001a\b\u0012\u0004\u0012\u00020\t0CJ\u0006\u0010f\u001a\u00020\nJ\u000e\u0010g\u001a\u00020\n2\u0006\u0010h\u001a\u00020\u0004J\u0006\u0010i\u001a\u00020\nJ\u0014\u0010j\u001a\u00020\n2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020\t0CJ\u000e\u0010k\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\rj\b\u0012\u0004\u0012\u00020\u0004`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u001e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\t0%j\b\u0012\u0004\u0012\u00020\t`&X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R*\u0010+\u001a\u001e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00040,j\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u0004`.X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010/\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0013\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R(\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0016\"\u0004\b7\u0010\u0018R.\u00108\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00102\"\u0004\b:\u00104R$\u0010;\u001a\u0002002\u0006\u0010\u0011\u001a\u000200@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0011\u0010@\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bA\u0010\u001bR\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00040C8F¢\u0006\u0006\u001a\u0004\bD\u0010ER\u001e\u0010G\u001a\u00020\u00132\u0006\u0010F\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bH\u0010I¨\u0006p"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/RowAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "categoryIcon", "", "leading", "Lcom/mattiadoronzo/sonixlink/RowAdapter$Leading;", "onClick", "Lkotlin/Function2;", "Lcom/mattiadoronzo/sonixlink/Row;", "", "(ILcom/mattiadoronzo/sonixlink/RowAdapter$Leading;Lkotlin/jvm/functions/Function2;)V", "chosen", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "coversArrived", "Lkotlin/Function0;", "value", "Lkotlin/Function1;", "", "gripAt", "getGripAt", "()Lkotlin/jvm/functions/Function1;", "setGripAt", "(Lkotlin/jvm/functions/Function1;)V", "highlightIndex", "getHighlightIndex", "()I", "setHighlightIndex", "(I)V", "", "highlightPath", "getHighlightPath", "()Ljava/lang/String;", "setHighlightPath", "(Ljava/lang/String;)V", "items", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLeading", "()Lcom/mattiadoronzo/sonixlink/RowAdapter$Leading;", "setLeading", "(Lcom/mattiadoronzo/sonixlink/RowAdapter$Leading;)V", "letterAt", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "marksCategory", "Lcom/mattiadoronzo/sonixlink/PlayerState;", "getMarksCategory", "()Lkotlin/jvm/functions/Function2;", "setMarksCategory", "(Lkotlin/jvm/functions/Function2;)V", "onGripPressed", "getOnGripPressed", "setOnGripPressed", "onLongPress", "getOnLongPress", "setOnLongPress", "playing", "getPlaying", "()Lcom/mattiadoronzo/sonixlink/PlayerState;", "setPlaying", "(Lcom/mattiadoronzo/sonixlink/PlayerState;)V", "rowCount", "getRowCount", "selected", "", "getSelected", "()Ljava/util/List;", "<set-?>", "selecting", "getSelecting", "()Z", "firstStartingWith", "letter", "getItemCount", "getItemViewType", "position", "isChosen", "letters", "move", "from", "to", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onDetachedFromRecyclerView", "removeAt", "positions", "", "repaint", "replace", "at", "rows", "rowAt", "startEmptySelection", "startSelection", "first", "stopSelection", "submit", "toggle", "Companion", "HeaderHolder", "Holder", "Leading", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class RowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final int TYPE_HEADER = 1;

    @Deprecated
    public static final int TYPE_ROW = 0;
    private final int categoryIcon;
    private final LinkedHashSet<Integer> chosen;
    private final Function0<Unit> coversArrived;
    private Function1<? super Integer, Boolean> gripAt;
    private int highlightIndex;
    private String highlightPath;
    private final ArrayList<Row> items;
    private Leading leading;
    private final LinkedHashMap<Character, Integer> letterAt;
    private Function2<? super Row, ? super PlayerState, Boolean> marksCategory;
    private final Function2<Integer, Row, Unit> onClick;
    private Function1<? super RecyclerView.ViewHolder, Unit> onGripPressed;
    private Function2<? super Integer, ? super Row, Unit> onLongPress;
    private PlayerState playing;
    private boolean selecting;

    /* JADX INFO: compiled from: RowAdapter.kt */
    @Metadata(m147d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/RowAdapter$Leading;", "", "(Ljava/lang/String;I)V", "ICON", "NONE", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public enum Leading {
        ICON,
        NONE;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<Leading> getEntries() {
            return $ENTRIES;
        }
    }

    public /* synthetic */ RowAdapter(int i, Leading leading, Function2 function2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? Leading.ICON : leading, function2);
    }

    public final Leading getLeading() {
        return this.leading;
    }

    public final void setLeading(Leading leading) {
        Intrinsics.checkNotNullParameter(leading, "<set-?>");
        this.leading = leading;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RowAdapter(int categoryIcon, Leading leading, Function2<? super Integer, ? super Row, Unit> onClick) {
        Intrinsics.checkNotNullParameter(leading, "leading");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.categoryIcon = categoryIcon;
        this.leading = leading;
        this.onClick = onClick;
        this.items = new ArrayList<>();
        this.chosen = new LinkedHashSet<>();
        this.letterAt = new LinkedHashMap<>();
        this.highlightPath = "";
        this.playing = PlayerState.INSTANCE.getEMPTY();
        this.highlightIndex = -1;
        this.coversArrived = new Function0<Unit>() { // from class: com.mattiadoronzo.sonixlink.RowAdapter$coversArrived$1
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
                this.this$0.notifyItemRangeChanged(0, this.this$0.items.size());
            }
        };
    }

    /* JADX INFO: compiled from: RowAdapter.kt */
    @Metadata(m147d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/RowAdapter$Companion;", "", "()V", "TYPE_HEADER", "", "TYPE_ROW", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final Row rowAt(int position) {
        return (Row) CollectionsKt.getOrNull(this.items, position);
    }

    public final int getRowCount() {
        return this.items.size();
    }

    public final Function2<Integer, Row, Unit> getOnLongPress() {
        return this.onLongPress;
    }

    public final void setOnLongPress(Function2<? super Integer, ? super Row, Unit> function2) {
        this.onLongPress = function2;
    }

    public final boolean getSelecting() {
        return this.selecting;
    }

    public final List<Integer> getSelected() {
        return CollectionsKt.sorted(this.chosen);
    }

    public final void startEmptySelection() {
        this.selecting = true;
        this.chosen.clear();
        notifyDataSetChanged();
    }

    public final void startSelection(int first) {
        boolean z = true;
        this.selecting = true;
        this.chosen.clear();
        if (first < 0 || first >= this.items.size()) {
            z = false;
        }
        if (z) {
            this.chosen.add(Integer.valueOf(first));
        }
        notifyDataSetChanged();
    }

    public final void stopSelection() {
        this.selecting = false;
        this.chosen.clear();
        notifyDataSetChanged();
    }

    public final int toggle(int position) {
        if (!this.chosen.remove(Integer.valueOf(position))) {
            this.chosen.add(Integer.valueOf(position));
        }
        notifyItemChanged(position);
        return this.chosen.size();
    }

    public final Function1<Integer, Boolean> getGripAt() {
        return this.gripAt;
    }

    public final void setGripAt(Function1<? super Integer, Boolean> function1) {
        this.gripAt = function1;
        notifyDataSetChanged();
    }

    public final Function1<RecyclerView.ViewHolder, Unit> getOnGripPressed() {
        return this.onGripPressed;
    }

    public final void setOnGripPressed(Function1<? super RecyclerView.ViewHolder, Unit> function1) {
        this.onGripPressed = function1;
    }

    public final void move(int from, int to) {
        if (from >= 0 && from < this.items.size()) {
            if (!(to >= 0 && to < this.items.size()) || from == to) {
                return;
            }
            Row rowRemove = this.items.remove(from);
            Intrinsics.checkNotNullExpressionValue(rowRemove, "removeAt(...)");
            Row row = rowRemove;
            this.items.add(to, row);
            notifyItemMoved(from, to);
        }
    }

    public final List<Row> rows() {
        return new ArrayList(this.items);
    }

    public final boolean isChosen(int position) {
        return this.selecting && this.chosen.contains(Integer.valueOf(position));
    }

    public final void removeAt(Collection<Integer> positions) {
        Intrinsics.checkNotNullParameter(positions, "positions");
        Iterable $this$forEach$iv = CollectionsKt.sortedDescending(positions);
        for (Object element$iv : $this$forEach$iv) {
            int it = ((Number) element$iv).intValue();
            boolean z = false;
            if (it >= 0 && it < this.items.size()) {
                z = true;
            }
            if (z) {
                this.items.remove(it);
            }
        }
        this.chosen.clear();
        notifyDataSetChanged();
    }

    public final String getHighlightPath() {
        return this.highlightPath;
    }

    public final void setHighlightPath(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (!Intrinsics.areEqual(this.highlightPath, value)) {
            this.highlightPath = value;
            notifyDataSetChanged();
        }
    }

    public final PlayerState getPlaying() {
        return this.playing;
    }

    public final void setPlaying(PlayerState value) {
        Intrinsics.checkNotNullParameter(value, "value");
        PlayerState old = this.playing;
        this.playing = value;
        if (!Intrinsics.areEqual(old.getPath(), value.getPath()) || !Intrinsics.areEqual(old.getAlbum(), value.getAlbum()) || !Intrinsics.areEqual(old.getArtist(), value.getArtist()) || !Intrinsics.areEqual(old.getAlbumArtist(), value.getAlbumArtist())) {
            notifyItemRangeChanged(0, this.items.size());
        }
    }

    public final Function2<Row, PlayerState, Boolean> getMarksCategory() {
        return this.marksCategory;
    }

    public final void setMarksCategory(Function2<? super Row, ? super PlayerState, Boolean> function2) {
        this.marksCategory = function2;
    }

    public final void repaint() {
        notifyDataSetChanged();
    }

    public final int getHighlightIndex() {
        return this.highlightIndex;
    }

    public final void setHighlightIndex(int value) {
        if (this.highlightIndex != value) {
            int old = this.highlightIndex;
            this.highlightIndex = value;
            if (old >= 0 && old < this.items.size()) {
                notifyItemChanged(old);
            }
            if (value >= 0 && value < this.items.size()) {
                notifyItemChanged(value);
            }
        }
    }

    public final void replace(int at, List<Row> rows) {
        Intrinsics.checkNotNullParameter(rows, "rows");
        if (at < 0 || at >= this.items.size()) {
            return;
        }
        int end = Math.min(this.items.size(), rows.size() + at);
        for (int i = at; i < end; i++) {
            this.items.set(i, rows.get(i - at));
        }
        int i2 = end - at;
        notifyItemRangeChanged(at, i2);
    }

    public final void submit(List<Row> rows) {
        Intrinsics.checkNotNullParameter(rows, "rows");
        this.selecting = false;
        this.chosen.clear();
        this.items.clear();
        this.items.addAll(rows);
        this.letterAt.clear();
        int i = 0;
        for (Row row : this.items) {
            int at = i;
            i++;
            if (row.getKind() == Row.Kind.ROW) {
                if (!(row.getSortKey().length() == 0)) {
                    char letter = Letters.INSTANCE.ofSortKey(row.getSortKey());
                    if (!this.letterAt.containsKey(Character.valueOf(letter))) {
                        this.letterAt.put(Character.valueOf(letter), Integer.valueOf(at));
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        Covers.INSTANCE.watch(this.coversArrived);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        Covers.INSTANCE.unwatch(this.coversArrived);
    }

    /* JADX INFO: compiled from: RowAdapter.kt */
    @Metadata(m147d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/RowAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "views", "Lcom/mattiadoronzo/sonixlink/databinding/RowItemBinding;", "(Lcom/mattiadoronzo/sonixlink/databinding/RowItemBinding;)V", "getViews", "()Lcom/mattiadoronzo/sonixlink/databinding/RowItemBinding;", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Holder extends RecyclerView.ViewHolder {
        private final RowItemBinding views;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Holder(RowItemBinding views) {
            super(views.getRoot());
            Intrinsics.checkNotNullParameter(views, "views");
            this.views = views;
        }

        public final RowItemBinding getViews() {
            return this.views;
        }
    }

    /* JADX INFO: compiled from: RowAdapter.kt */
    @Metadata(m147d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/RowAdapter$HeaderHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "views", "Lcom/mattiadoronzo/sonixlink/databinding/RowHeaderBinding;", "(Lcom/mattiadoronzo/sonixlink/databinding/RowHeaderBinding;)V", "getViews", "()Lcom/mattiadoronzo/sonixlink/databinding/RowHeaderBinding;", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class HeaderHolder extends RecyclerView.ViewHolder {
        private final RowHeaderBinding views;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeaderHolder(RowHeaderBinding views) {
            super(views.getRoot());
            Intrinsics.checkNotNullParameter(views, "views");
            this.views = views;
        }

        public final RowHeaderBinding getViews() {
            return this.views;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.items.get(position).getKind() == Row.Kind.HEADER ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == 1) {
            RowHeaderBinding rowHeaderBindingInflate = RowHeaderBinding.inflate(inflater, parent, false);
            Intrinsics.checkNotNullExpressionValue(rowHeaderBindingInflate, "inflate(...)");
            return new HeaderHolder(rowHeaderBindingInflate);
        }
        RowItemBinding rowItemBindingInflate = RowItemBinding.inflate(inflater, parent, false);
        Intrinsics.checkNotNullExpressionValue(rowItemBindingInflate, "inflate(...)");
        return new Holder(rowItemBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    public final int firstStartingWith(char letter) {
        Integer num = this.letterAt.get(Character.valueOf(letter));
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public final List<Character> letters() {
        Set<Character> setKeySet = this.letterAt.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
        return CollectionsKt.toList(setKeySet);
    }

    /* JADX WARN: Code duplicated, block: B:143:0x02a8  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        Bitmap cover;
        int iconRes;
        String subtitle;
        boolean playing;
        int color;
        boolean z;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Row row = this.items.get(position);
        Intrinsics.checkNotNullExpressionValue(row, "get(...)");
        Row row2 = row;
        if (holder instanceof HeaderHolder) {
            ((HeaderHolder) holder).getViews().headerLabel.setText(row2.getTitle());
            return;
        }
        if (holder instanceof Holder) {
            RowItemBinding views = ((Holder) holder).getViews();
            Context context = views.getRoot().getContext();
            views.title.setText(row2.getTitle());
            boolean marked = true;
            boolean isChosen = this.selecting && this.chosen.contains(Integer.valueOf(position));
            views.chevron.setVisibility((this.selecting || row2.isTrack() || row2.getKind() == Row.Kind.PENDING) ? 8 : 0);
            views.check.setVisibility(isChosen ? 0 : 8);
            Function1<? super Integer, Boolean> function1 = this.gripAt;
            boolean grip = function1 != null && function1.invoke(Integer.valueOf(position)).booleanValue();
            views.chevron.setImageResource(grip ? C1020R.drawable.ic_grip : C1020R.drawable.ic_chevron);
            int side = (int) ((grip ? 28 : 18) * context.getResources().getDisplayMetrics().density);
            ImageView imageView = views.chevron;
            ViewGroup.LayoutParams $this$onBindViewHolder_u24lambda_u241 = views.chevron.getLayoutParams();
            $this$onBindViewHolder_u24lambda_u241.width = side;
            $this$onBindViewHolder_u24lambda_u241.height = side;
            imageView.setLayoutParams($this$onBindViewHolder_u24lambda_u241);
            if (!grip) {
                views.chevron.setOnTouchListener(null);
            } else {
                views.chevron.setVisibility(0);
                views.chevron.setOnTouchListener(new View.OnTouchListener() { // from class: com.mattiadoronzo.sonixlink.RowAdapter$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return RowAdapter.onBindViewHolder$lambda$2(this.f$0, holder, view, motionEvent);
                    }
                });
            }
            if (isChosen) {
                views.check.setImageTintList(ColorStateList.valueOf(Session.INSTANCE.getAccent()));
                views.getRoot().setBackgroundColor(ContextCompat.getColor(context, C1020R.color.surface));
            } else {
                TypedValue ripple = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.selectableItemBackground, ripple, true);
                views.getRoot().setBackgroundResource(ripple.resourceId);
            }
            Covers covers = Session.INSTANCE.getCovers();
            if (covers == null) {
                cover = null;
            } else if (row2.isTrack()) {
                cover = covers.forTrack(row2.getArtPath(), row2.getArtMtime(), row2.getArtSize());
                if (cover == null) {
                    cover = covers.forAlbum(row2.getAlbum());
                }
            } else {
                cover = row2.getAlbum().length() > 0 ? covers.forAlbum(row2.getAlbum()) : null;
            }
            if (cover == null) {
                views.cover.setImageDrawable(null);
                views.cover.setVisibility(8);
                views.icon.setVisibility(this.leading == Leading.ICON ? 0 : 8);
                ImageView imageView2 = views.icon;
                if (row2.getIconRes() != 0) {
                    iconRes = row2.getIconRes();
                } else {
                    iconRes = row2.isTrack() ? C1020R.drawable.ic_track : this.categoryIcon;
                }
                imageView2.setImageResource(iconRes);
                views.artwork.setVisibility(this.leading == Leading.ICON ? 0 : 8);
            } else {
                views.cover.setImageBitmap(cover);
                views.cover.setVisibility(0);
                views.icon.setVisibility(8);
                views.artwork.setVisibility(0);
            }
            if (row2.getSubtitle().length() > 0) {
                subtitle = row2.getSubtitle();
            } else if (row2.isTrack() || row2.getCount() <= 0) {
                subtitle = "";
            } else {
                subtitle = context.getString(C1020R.string.tracks_count, Integer.valueOf(row2.getCount()));
                Intrinsics.checkNotNullExpressionValue(subtitle, "getString(...)");
            }
            views.subtitle.setText(subtitle);
            views.subtitle.setVisibility(subtitle.length() == 0 ? 8 : 0);
            if (this.highlightIndex >= 0) {
                playing = position == this.highlightIndex;
            } else {
                playing = (this.highlightPath.length() > 0) && Intrinsics.areEqual(row2.getPath(), this.highlightPath);
            }
            if (!playing) {
                if (row2.getKind() != Row.Kind.ROW) {
                    z = false;
                } else if (row2.isTrack()) {
                    z = (this.playing.getPath().length() > 0) && Intrinsics.areEqual(row2.getPath(), this.playing.getPath());
                } else if (this.playing.getHasTrack()) {
                    Function2<? super Row, ? super PlayerState, Boolean> function2 = this.marksCategory;
                    if (function2 != null && function2.invoke(row2, this.playing).booleanValue()) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                if (!z) {
                    marked = false;
                }
            }
            if (marked) {
                View view = views.playmark;
                GradientDrawable $this$onBindViewHolder_u24lambda_u243 = new GradientDrawable();
                $this$onBindViewHolder_u24lambda_u243.setCornerRadius(2 * context.getResources().getDisplayMetrics().density);
                $this$onBindViewHolder_u24lambda_u243.setColor(Session.INSTANCE.getAccent());
                view.setBackground($this$onBindViewHolder_u24lambda_u243);
                views.playmark.setVisibility(0);
            } else {
                views.playmark.setVisibility(8);
            }
            TextView textView = views.title;
            if (playing) {
                color = Session.INSTANCE.getAccent();
            } else {
                color = ContextCompat.getColor(context, C1020R.color.text_primary);
            }
            textView.setTextColor(color);
            views.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.RowAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    RowAdapter.onBindViewHolder$lambda$4(holder, this, view2);
                }
            });
            final Function2<? super Integer, ? super Row, Unit> function3 = this.onLongPress;
            if (function3 == null) {
                views.getRoot().setOnLongClickListener(null);
                views.getRoot().setLongClickable(false);
            } else {
                views.getRoot().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.mattiadoronzo.sonixlink.RowAdapter$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view2) {
                        return RowAdapter.onBindViewHolder$lambda$5(holder, function3, this, view2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onBindViewHolder$lambda$2(RowAdapter this$0, RecyclerView.ViewHolder holder, View view, MotionEvent event) {
        Function1<? super RecyclerView.ViewHolder, Unit> function1;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        if (event.getActionMasked() != 0 || (function1 = this$0.onGripPressed) == null) {
            return false;
        }
        function1.invoke(holder);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$4(RecyclerView.ViewHolder holder, RowAdapter this$0, View it) {
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int at = ((Holder) holder).getBindingAdapterPosition();
        if (at != -1) {
            Function2<Integer, Row, Unit> function2 = this$0.onClick;
            Integer numValueOf = Integer.valueOf(at);
            Row row = this$0.items.get(at);
            Intrinsics.checkNotNullExpressionValue(row, "get(...)");
            function2.invoke(numValueOf, row);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onBindViewHolder$lambda$5(RecyclerView.ViewHolder holder, Function2 $longPress, RowAdapter this$0, View it) {
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int at = ((Holder) holder).getBindingAdapterPosition();
        if (at != -1) {
            Integer numValueOf = Integer.valueOf(at);
            Row row = this$0.items.get(at);
            Intrinsics.checkNotNullExpressionValue(row, "get(...)");
            $longPress.invoke(numValueOf, row);
            return true;
        }
        return true;
    }
}
