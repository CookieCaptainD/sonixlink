package com.mattiadoronzo.sonixlink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.mattiadoronzo.sonixlink.C1020R;

/* JADX INFO: loaded from: classes3.dex */
public final class RowItemBinding implements ViewBinding {
    public final FrameLayout artwork;
    public final ImageView check;
    public final ImageView chevron;
    public final ImageView cover;
    public final ImageView icon;
    public final View playmark;
    private final FrameLayout rootView;
    public final TextView subtitle;
    public final TextView title;

    private RowItemBinding(FrameLayout rootView, FrameLayout artwork, ImageView check, ImageView chevron, ImageView cover, ImageView icon, View playmark, TextView subtitle, TextView title) {
        this.rootView = rootView;
        this.artwork = artwork;
        this.check = check;
        this.chevron = chevron;
        this.cover = cover;
        this.icon = icon;
        this.playmark = playmark;
        this.subtitle = subtitle;
        this.title = title;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static RowItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C1020R.layout.row_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static RowItemBinding bind(View rootView) {
        View playmark;
        int id = C1020R.id.artwork;
        FrameLayout artwork = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
        if (artwork != null) {
            id = C1020R.id.check;
            ImageView check = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (check != null) {
                id = C1020R.id.chevron;
                ImageView chevron = (ImageView) ViewBindings.findChildViewById(rootView, id);
                if (chevron != null) {
                    id = C1020R.id.cover;
                    ImageView cover = (ImageView) ViewBindings.findChildViewById(rootView, id);
                    if (cover != null) {
                        id = C1020R.id.icon;
                        ImageView icon = (ImageView) ViewBindings.findChildViewById(rootView, id);
                        if (icon != null && (playmark = ViewBindings.findChildViewById(rootView, (id = C1020R.id.playmark))) != null) {
                            id = C1020R.id.subtitle;
                            TextView subtitle = (TextView) ViewBindings.findChildViewById(rootView, id);
                            if (subtitle != null) {
                                id = C1020R.id.title;
                                TextView title = (TextView) ViewBindings.findChildViewById(rootView, id);
                                if (title != null) {
                                    return new RowItemBinding((FrameLayout) rootView, artwork, check, chevron, cover, icon, playmark, subtitle, title);
                                }
                            }
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}
