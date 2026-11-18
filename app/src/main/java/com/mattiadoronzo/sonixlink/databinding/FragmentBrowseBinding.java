package com.mattiadoronzo.sonixlink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.mattiadoronzo.sonixlink.C1020R;

/* JADX INFO: loaded from: classes3.dex */
public final class FragmentBrowseBinding implements ViewBinding {
    public final TextView emptyText;
    public final LinearLayout header;
    public final ImageButton headerBack;
    public final TextView headerTitle;
    public final FrameLayout indexHint;
    public final TextView indexHintLetter;
    public final LinearLayout letterStrip;
    public final RecyclerView list;
    public final ImageButton playMenu;
    public final ProgressBar progress;
    private final LinearLayout rootView;
    public final ImageButton selClose;
    public final ImageButton selFavAdd;
    public final ImageButton selFavRemove;
    public final ImageButton selPlaylistAdd;
    public final ImageButton selPlaylistRemove;
    public final ImageButton selQueue;

    private FragmentBrowseBinding(LinearLayout rootView, TextView emptyText, LinearLayout header, ImageButton headerBack, TextView headerTitle, FrameLayout indexHint, TextView indexHintLetter, LinearLayout letterStrip, RecyclerView list, ImageButton playMenu, ProgressBar progress, ImageButton selClose, ImageButton selFavAdd, ImageButton selFavRemove, ImageButton selPlaylistAdd, ImageButton selPlaylistRemove, ImageButton selQueue) {
        this.rootView = rootView;
        this.emptyText = emptyText;
        this.header = header;
        this.headerBack = headerBack;
        this.headerTitle = headerTitle;
        this.indexHint = indexHint;
        this.indexHintLetter = indexHintLetter;
        this.letterStrip = letterStrip;
        this.list = list;
        this.playMenu = playMenu;
        this.progress = progress;
        this.selClose = selClose;
        this.selFavAdd = selFavAdd;
        this.selFavRemove = selFavRemove;
        this.selPlaylistAdd = selPlaylistAdd;
        this.selPlaylistRemove = selPlaylistRemove;
        this.selQueue = selQueue;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentBrowseBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentBrowseBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C1020R.layout.fragment_browse, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static FragmentBrowseBinding bind(View rootView) {
        int id = C1020R.id.emptyText;
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
                        id = C1020R.id.indexHint;
                        FrameLayout indexHint = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
                        if (indexHint != null) {
                            id = C1020R.id.indexHintLetter;
                            TextView indexHintLetter = (TextView) ViewBindings.findChildViewById(rootView, id);
                            if (indexHintLetter != null) {
                                id = C1020R.id.letterStrip;
                                LinearLayout letterStrip = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                                if (letterStrip != null) {
                                    id = C1020R.id.list;
                                    RecyclerView list = (RecyclerView) ViewBindings.findChildViewById(rootView, id);
                                    if (list != null) {
                                        id = C1020R.id.playMenu;
                                        ImageButton playMenu = (ImageButton) ViewBindings.findChildViewById(rootView, id);
                                        if (playMenu != null) {
                                            id = C1020R.id.progress;
                                            ProgressBar progress = (ProgressBar) ViewBindings.findChildViewById(rootView, id);
                                            if (progress != null) {
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
                                                                id = C1020R.id.selPlaylistRemove;
                                                                ImageButton selPlaylistRemove = (ImageButton) ViewBindings.findChildViewById(rootView, id);
                                                                if (selPlaylistRemove != null) {
                                                                    id = C1020R.id.selQueue;
                                                                    ImageButton selQueue = (ImageButton) ViewBindings.findChildViewById(rootView, id);
                                                                    if (selQueue != null) {
                                                                        return new FragmentBrowseBinding((LinearLayout) rootView, emptyText, header, headerBack, headerTitle, indexHint, indexHintLetter, letterStrip, list, playMenu, progress, selClose, selFavAdd, selFavRemove, selPlaylistAdd, selPlaylistRemove, selQueue);
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
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}
