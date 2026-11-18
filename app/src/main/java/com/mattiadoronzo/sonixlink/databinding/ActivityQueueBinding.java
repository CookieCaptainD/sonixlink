package com.mattiadoronzo.sonixlink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.mattiadoronzo.sonixlink.C1020R;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityQueueBinding implements ViewBinding {
    public final TextView emptyText;
    public final RecyclerView list;
    public final ProgressBar progress;
    public final ImageButton queueClose;
    public final ImageButton queueRemove;
    public final ImageButton queueReorder;
    public final ImageButton queueSelect;
    private final FrameLayout rootView;
    public final Toolbar toolbar;
    public final VolumePillBinding volume;

    private ActivityQueueBinding(FrameLayout rootView, TextView emptyText, RecyclerView list, ProgressBar progress, ImageButton queueClose, ImageButton queueRemove, ImageButton queueReorder, ImageButton queueSelect, Toolbar toolbar, VolumePillBinding volume) {
        this.rootView = rootView;
        this.emptyText = emptyText;
        this.list = list;
        this.progress = progress;
        this.queueClose = queueClose;
        this.queueRemove = queueRemove;
        this.queueReorder = queueReorder;
        this.queueSelect = queueSelect;
        this.toolbar = toolbar;
        this.volume = volume;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ActivityQueueBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityQueueBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C1020R.layout.activity_queue, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityQueueBinding bind(View rootView) {
        View volume;
        int id = C1020R.id.emptyText;
        TextView emptyText = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (emptyText != null) {
            id = C1020R.id.list;
            RecyclerView list = (RecyclerView) ViewBindings.findChildViewById(rootView, id);
            if (list != null) {
                id = C1020R.id.progress;
                ProgressBar progress = (ProgressBar) ViewBindings.findChildViewById(rootView, id);
                if (progress != null) {
                    id = C1020R.id.queueClose;
                    ImageButton queueClose = (ImageButton) ViewBindings.findChildViewById(rootView, id);
                    if (queueClose != null) {
                        id = C1020R.id.queueRemove;
                        ImageButton queueRemove = (ImageButton) ViewBindings.findChildViewById(rootView, id);
                        if (queueRemove != null) {
                            id = C1020R.id.queueReorder;
                            ImageButton queueReorder = (ImageButton) ViewBindings.findChildViewById(rootView, id);
                            if (queueReorder != null) {
                                id = C1020R.id.queueSelect;
                                ImageButton queueSelect = (ImageButton) ViewBindings.findChildViewById(rootView, id);
                                if (queueSelect != null) {
                                    id = C1020R.id.toolbar;
                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, id);
                                    if (toolbar != null && (volume = ViewBindings.findChildViewById(rootView, (id = C1020R.id.volume))) != null) {
                                        VolumePillBinding binding_volume = VolumePillBinding.bind(volume);
                                        return new ActivityQueueBinding((FrameLayout) rootView, emptyText, list, progress, queueClose, queueRemove, queueReorder, queueSelect, toolbar, binding_volume);
                                    }
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
