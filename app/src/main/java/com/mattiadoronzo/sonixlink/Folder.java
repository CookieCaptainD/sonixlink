package com.mattiadoronzo.sonixlink;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlayerClient.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/Folder;", "", "path", "", "root", "parent", "entries", "", "Lcom/mattiadoronzo/sonixlink/FolderEntry;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getEntries", "()Ljava/util/List;", "getParent", "()Ljava/lang/String;", "getPath", "getRoot", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class Folder {
    private final List<FolderEntry> entries;
    private final String parent;
    private final String path;
    private final String root;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Folder copy$default(Folder folder, String str, String str2, String str3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = folder.path;
        }
        if ((i & 2) != 0) {
            str2 = folder.root;
        }
        if ((i & 4) != 0) {
            str3 = folder.parent;
        }
        if ((i & 8) != 0) {
            list = folder.entries;
        }
        return folder.copy(str, str2, str3, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRoot() {
        return this.root;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getParent() {
        return this.parent;
    }

    public final List<FolderEntry> component4() {
        return this.entries;
    }

    public final Folder copy(String path, String root, String parent, List<FolderEntry> entries) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(entries, "entries");
        return new Folder(path, root, parent, entries);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Folder)) {
            return false;
        }
        Folder folder = (Folder) other;
        return Intrinsics.areEqual(this.path, folder.path) && Intrinsics.areEqual(this.root, folder.root) && Intrinsics.areEqual(this.parent, folder.parent) && Intrinsics.areEqual(this.entries, folder.entries);
    }

    public int hashCode() {
        return (((((this.path.hashCode() * 31) + this.root.hashCode()) * 31) + this.parent.hashCode()) * 31) + this.entries.hashCode();
    }

    public String toString() {
        return "Folder(path=" + this.path + ", root=" + this.root + ", parent=" + this.parent + ", entries=" + this.entries + ")";
    }

    public Folder(String path, String root, String parent, List<FolderEntry> entries) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(entries, "entries");
        this.path = path;
        this.root = root;
        this.parent = parent;
        this.entries = entries;
    }

    public final List<FolderEntry> getEntries() {
        return this.entries;
    }

    public final String getParent() {
        return this.parent;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getRoot() {
        return this.root;
    }
}
