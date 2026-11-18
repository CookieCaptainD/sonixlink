package com.mattiadoronzo.sonixlink;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.widget.ImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: Accent.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\n¨\u0006\u0011"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/Accent;", "", "()V", "circleButton", "", "button", "Landroid/widget/ImageButton;", "diameterDp", "", "onOff", "Landroid/content/res/ColorStateList;", "context", "Landroid/content/Context;", DebugKt.DEBUG_PROPERTY_VALUE_ON, "", "tabColors", "tint", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Accent {
    public static final Accent INSTANCE = new Accent();

    private Accent() {
    }

    public final ColorStateList tint() {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(Session.INSTANCE.getAccent());
        Intrinsics.checkNotNullExpressionValue(colorStateListValueOf, "valueOf(...)");
        return colorStateListValueOf;
    }

    public final ColorStateList onOff(Context context, boolean on) {
        Intrinsics.checkNotNullParameter(context, "context");
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(on ? Session.INSTANCE.getAccent() : ContextCompat.getColor(context, C1020R.color.text_secondary));
        Intrinsics.checkNotNullExpressionValue(colorStateListValueOf, "valueOf(...)");
        return colorStateListValueOf;
    }

    public final ColorStateList tabColors(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int[][] states = {new int[]{android.R.attr.state_selected}, new int[0]};
        int[] colors = {Session.INSTANCE.getAccent(), ContextCompat.getColor(context, C1020R.color.text_secondary)};
        return new ColorStateList(states, colors);
    }

    public final void circleButton(ImageButton button, int diameterDp) {
        Intrinsics.checkNotNullParameter(button, "button");
        float density = button.getResources().getDisplayMetrics().density;
        int size = (int) (diameterDp * density);
        GradientDrawable $this$circleButton_u24lambda_u240 = new GradientDrawable();
        $this$circleButton_u24lambda_u240.setShape(1);
        $this$circleButton_u24lambda_u240.setColor(-1);
        $this$circleButton_u24lambda_u240.setSize(size, size);
        button.setBackground($this$circleButton_u24lambda_u240);
        button.setImageTintList(ColorStateList.valueOf(Session.INSTANCE.getAccent()));
    }
}
