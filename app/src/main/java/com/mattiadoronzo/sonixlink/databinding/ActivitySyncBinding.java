package com.mattiadoronzo.sonixlink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.mattiadoronzo.sonixlink.C1020R;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivitySyncBinding implements ViewBinding {
    public final Button retryButton;
    private final LinearLayout rootView;
    public final TextView syncAmount;
    public final LinearProgressIndicator syncBar;
    public final TextView syncDetail;
    public final ProgressBar syncProgress;
    public final TextView syncText;

    private ActivitySyncBinding(LinearLayout rootView, Button retryButton, TextView syncAmount, LinearProgressIndicator syncBar, TextView syncDetail, ProgressBar syncProgress, TextView syncText) {
        this.rootView = rootView;
        this.retryButton = retryButton;
        this.syncAmount = syncAmount;
        this.syncBar = syncBar;
        this.syncDetail = syncDetail;
        this.syncProgress = syncProgress;
        this.syncText = syncText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySyncBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivitySyncBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C1020R.layout.activity_sync, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivitySyncBinding bind(View rootView) {
        int id = C1020R.id.retryButton;
        Button retryButton = (Button) ViewBindings.findChildViewById(rootView, id);
        if (retryButton != null) {
            id = C1020R.id.syncAmount;
            TextView syncAmount = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (syncAmount != null) {
                id = C1020R.id.syncBar;
                LinearProgressIndicator syncBar = (LinearProgressIndicator) ViewBindings.findChildViewById(rootView, id);
                if (syncBar != null) {
                    id = C1020R.id.syncDetail;
                    TextView syncDetail = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (syncDetail != null) {
                        id = C1020R.id.syncProgress;
                        ProgressBar syncProgress = (ProgressBar) ViewBindings.findChildViewById(rootView, id);
                        if (syncProgress != null) {
                            id = C1020R.id.syncText;
                            TextView syncText = (TextView) ViewBindings.findChildViewById(rootView, id);
                            if (syncText != null) {
                                return new ActivitySyncBinding((LinearLayout) rootView, retryButton, syncAmount, syncBar, syncDetail, syncProgress, syncText);
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
