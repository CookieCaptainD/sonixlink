package com.mattiadoronzo.sonixlink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.mattiadoronzo.sonixlink.C1020R;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivitySearchBinding implements ViewBinding {
    public final ImageButton backButton;
    public final ImageButton clearButton;
    public final TextView emptyText;
    public final LinearLayout header;
    public final ImageButton headerBack;
    public final TextView headerTitle;
    public final RecyclerView list;
    private final FrameLayout rootView;
    public final EditText searchInput;
    public final ImageButton selClose;
    public final ImageButton selFavAdd;
    public final ImageButton selFavRemove;
    public final ImageButton selPlaylistAdd;
    public final ImageButton selQueue;
    public final VolumePillBinding volume;

    private ActivitySearchBinding(FrameLayout rootView, ImageButton backButton, ImageButton clearButton, TextView emptyText, LinearLayout header, ImageButton headerBack, TextView headerTitle, RecyclerView list, EditText searchInput, ImageButton selClose, ImageButton selFavAdd, ImageButton selFavRemove, ImageButton selPlaylistAdd, ImageButton selQueue, VolumePillBinding volume) {
        this.rootView = rootView;
        this.backButton = backButton;
        this.clearButton = clearButton;
        this.emptyText = emptyText;
        this.header = header;
        this.headerBack = headerBack;
        this.headerTitle = headerTitle;
        this.list = list;
        this.searchInput = searchInput;
        this.selClose = selClose;
        this.selFavAdd = selFavAdd;
        this.selFavRemove = selFavRemove;
        this.selPlaylistAdd = selPlaylistAdd;
        this.selQueue = selQueue;
        this.volume = volume;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySearchBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivitySearchBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C1020R.layout.activity_search, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivitySearchBinding bind(View rootView) {
        View volume;
        int id = C1020R.id.backButton;
        ImageButton backButton = (ImageButton) ViewBindings.findChildViewById(rootView, id);
        if (backButton != null) {
            id = C1020R.id.clearButton;
            ImageButton clearButton = (ImageButton) ViewBindings.findChildViewById(rootView, id);
            if (clearButton != null) {
                id = C1020R.id.emptyText;
                TextView emptyText = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (emptyText != null) {
                    id = C1020R.id.header;
                    LinearLayout header = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                    if (header != null) {
                        id = C1020R.id.headerBack;
                        ImageButton headerBack = (ImageButton) ViewBindings.findChildViewById(rootView, id);
                        if (headerBack != null) {
                            id = C1020R.id.headerTitle;
                            TextView headerTitle = (TextView) ViewBindings.findChildViewById(rootView, id);
                            if (headerTitle != null) {
                                id = C1020R.id.list;
                                RecyclerView list = (RecyclerView) ViewBindings.findChildViewById(rootView, id);
                                if (list != null) {
                                    id = C1020R.id.searchInput;
                                    EditText searchInput = (EditText) ViewBindings.findChildViewById(rootView, id);
                                    if (searchInput != null) {
                                        id = C1020R.id.selClose;
                                        ImageButton selClose = (ImageButton) ViewBindings.findChildViewById(rootView, id);
                                        if (selClose != null) {
                                            id = C1020R.id.selFavAdd;
                                            ImageButton selFavAdd = (ImageButton) ViewBindings.findChildViewById(rootView, id);
                                            if (selFavAdd != null) {
                                                id = C1020R.id.selFavRemove;
                                                ImageButton selFavRemove = (ImageButton) ViewBindings.findChildViewById(rootView, id);
                                                if (selFavRemove != null) {
                                                    id = C1020R.id.selPlaylistAdd;
                                                    ImageButton selPlaylistAdd = (ImageButton) ViewBindings.findChildViewById(rootView, id);
                                                    if (selPlaylistAdd != null) {
                                                        id = C1020R.id.selQueue;
                                                        ImageButton selQueue = (ImageButton) ViewBindings.findChildViewById(rootView, id);
                                                        if (selQueue != null && (volume = ViewBindings.findChildViewById(rootView, (id = C1020R.id.volume))) != null) {
                                                            VolumePillBinding binding_volume = VolumePillBinding.bind(volume);
                                                            return new ActivitySearchBinding((FrameLayout) rootView, backButton, clearButton, emptyText, header, headerBack, headerTitle, list, searchInput, selClose, selFavAdd, selFavRemove, selPlaylistAdd, selQueue, binding_volume);
                                                        }
                                                    }
                                                }
                                            }
                                        }
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
