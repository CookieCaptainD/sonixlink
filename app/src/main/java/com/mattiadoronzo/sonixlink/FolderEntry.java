package com.mattiadoronzo.sonixlink;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlayerClient.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0015"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/FolderEntry;", "", "name", "", "path", "isFolder", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "()Z", "getName", "()Ljava/lang/String;", "getPath", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class FolderEntry {
    private final boolean isFolder;
    private final String name;
    private final String path;

    public static /* synthetic */ FolderEntry copy$default(FolderEntry folderEntry, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = folderEntry.name;
        }
        if ((i & 2) != 0) {
            str2 = folderEntry.path;
        }
        if ((i & 4) != 0) {
            z = folderEntry.isFolder;
        }
        return folderEntry.copy(str, str2, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsFolder() {
        return this.isFolder;
    }

    public final FolderEntry copy(String name, String path, boolean isFolder) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(path, "path");
        return new FolderEntry(name, path, isFolder);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FolderEntry)) {
            return false;
        }
        FolderEntry folderEntry = (FolderEntry) other;
        return Intrinsics.areEqual(this.name, folderEntry.name) && Intrinsics.areEqual(this.path, folderEntry.path) && this.isFolder == folderEntry.isFolder;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.path.hashCode()) * 31) + Boolean.hashCode(this.isFolder);
    }

    public String toString() {
        return "FolderEntry(name=" + this.name + ", path=" + this.path + ", isFolder=" + this.isFolder + ")";
    }

    public FolderEntry(String name, String path, boolean isFolder) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(path, "path");
        this.name = name;
        this.path = path;
        this.isFolder = isFolder;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPath() {
        return this.path;
    }

    public final boolean isFolder() {
        return this.isFolder;
    }
}
