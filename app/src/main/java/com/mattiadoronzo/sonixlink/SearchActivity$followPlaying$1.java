package com.mattiadoronzo.sonixlink;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, m148d2 = {"com/mattiadoronzo/sonixlink/SearchActivity$followPlaying$1", "Ljava/lang/Runnable;", "run", "", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SearchActivity$followPlaying$1 implements Runnable {
    final /* synthetic */ SearchActivity this$0;

    SearchActivity$followPlaying$1(SearchActivity $receiver) {
        this.this$0 = $receiver;
    }

    @Override // java.lang.Runnable
    public void run() {
        RowAdapter rowAdapter = this.this$0.adapter;
        if (rowAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            rowAdapter = null;
        }
        rowAdapter.setPlaying(Session.INSTANCE.getState());
        this.this$0.clock.postDelayed(this, 1000L);
    }
}
