package com.mattiadoronzo.sonixlink;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SearchActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, m148d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.SearchActivity$actOnSelection$1$paths$1", m164f = "SearchActivity.kt", m165i = {}, m166l = {}, m167m = "invokeSuspend", m168n = {}, m169s = {})
final class SearchActivity$actOnSelection$1$paths$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends String>>, Object> {
    final /* synthetic */ List<Row> $rows;
    int label;
    final /* synthetic */ SearchActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SearchActivity$actOnSelection$1$paths$1(List<Row> list, SearchActivity searchActivity, Continuation<? super SearchActivity$actOnSelection$1$paths$1> continuation) {
        super(2, continuation);
        this.$rows = list;
        this.this$0 = searchActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchActivity$actOnSelection$1$paths$1(this.$rows, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends String>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<String>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<String>> continuation) {
        return ((SearchActivity$actOnSelection$1$paths$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.SearchActivity$actOnSelection$1$paths$1$1 */
    /* JADX INFO: compiled from: SearchActivity.kt */
    @Metadata(m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* synthetic */ class C10221 extends FunctionReferenceImpl implements Function1<Row, Section> {
        C10221(Object obj) {
            super(1, obj, SearchActivity.class, "kindOf", "kindOf(Lcom/mattiadoronzo/sonixlink/Row;)Lcom/mattiadoronzo/sonixlink/Section;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Section invoke(Row p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ((SearchActivity) this.receiver).kindOf(p0);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                return Selection.INSTANCE.paths(this.$rows, new C10221(this.this$0));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
