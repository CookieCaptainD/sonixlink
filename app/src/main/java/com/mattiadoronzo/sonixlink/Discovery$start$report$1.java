package com.mattiadoronzo.sonixlink;

import android.os.Handler;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: Discovery.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m148d2 = {"<anonymous>", "", "found", "Lcom/mattiadoronzo/sonixlink/Discovery$Found;", "invoke"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class Discovery$start$report$1 extends Lambda implements Function1<Discovery.Found, Unit> {
    final /* synthetic */ Function1<Discovery.Found, Unit> $onFound;
    final /* synthetic */ HashSet<Discovery.Found> $seen;
    final /* synthetic */ Discovery this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    Discovery$start$report$1(HashSet<Discovery.Found> hashSet, Discovery discovery, Function1<? super Discovery.Found, Unit> function1) {
        super(1);
        this.$seen = hashSet;
        this.this$0 = discovery;
        this.$onFound = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Discovery.Found found) {
        invoke2(found);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final Discovery.Found found) {
        Intrinsics.checkNotNullParameter(found, "found");
        HashSet<Discovery.Found> hashSet = this.$seen;
        HashSet<Discovery.Found> hashSet2 = this.$seen;
        Discovery discovery = this.this$0;
        final Function1<Discovery.Found, Unit> function1 = this.$onFound;
        synchronized (hashSet) {
            if (hashSet2.add(found)) {
                new Handler(discovery.context.getMainLooper()).post(new Runnable() { // from class: com.mattiadoronzo.sonixlink.Discovery$start$report$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        Discovery$start$report$1.invoke$lambda$1$lambda$0(function1, found);
                    }
                });
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1$lambda$0(Function1 onFound, Discovery.Found found) {
        Intrinsics.checkNotNullParameter(onFound, "$onFound");
        Intrinsics.checkNotNullParameter(found, "$found");
        onFound.invoke(found);
    }
}
