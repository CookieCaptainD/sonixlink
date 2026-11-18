package com.mattiadoronzo.sonixlink;

import androidx.activity.OnBackPressedCallback;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BrowseFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, m148d2 = {"com/mattiadoronzo/sonixlink/BrowseFragment$back$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class BrowseFragment$back$1 extends OnBackPressedCallback {
    final /* synthetic */ BrowseFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrowseFragment$back$1(BrowseFragment $receiver) {
        super(false);
        this.this$0 = $receiver;
    }

    @Override // androidx.activity.OnBackPressedCallback
    public void handleOnBackPressed() {
        RowAdapter rowAdapter = this.this$0.adapter;
        if (rowAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            rowAdapter = null;
        }
        if (rowAdapter.getSelecting()) {
            this.this$0.stopSelection();
            return;
        }
        Section section = this.this$0.section;
        if (section == null) {
            Intrinsics.throwUninitializedPropertyAccessException("section");
            section = null;
        }
        if (section == Section.FOLDERS) {
            if (this.this$0.folderParent.length() > 0) {
                Pair scroll = (Pair) CollectionsKt.removeLastOrNull(this.this$0.folderScroll);
                this.this$0.loadFolder(this.this$0.folderParent, scroll);
                return;
            }
            return;
        }
        this.this$0.opened = null;
        this.this$0.updateBack();
        BrowseFragment.load$default(this.this$0, true, false, 2, null);
    }
}
