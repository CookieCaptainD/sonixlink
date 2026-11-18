package com.mattiadoronzo.sonixlink;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;

/* JADX INFO: compiled from: Transport.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u000f\u001a\u00020\rR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/PriorityGate;", "", "()V", "freed", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "held", "", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "urgentWaiting", "", "acquire", "", "bulk", "release", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PriorityGate {
    private boolean held;
    private int urgentWaiting;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition freed = this.lock.newCondition();

    public final void acquire(boolean bulk) {
        this.lock.lock();
        try {
            if (bulk) {
                while (true) {
                    if (!this.held && this.urgentWaiting <= 0) {
                        break;
                    } else {
                        this.freed.await();
                    }
                }
            } else {
                this.urgentWaiting++;
                while (this.held) {
                    try {
                        this.freed.await();
                    } catch (Throwable th) {
                        this.urgentWaiting--;
                        throw th;
                    }
                }
                this.urgentWaiting--;
            }
            this.held = true;
            this.lock.unlock();
        } catch (Throwable th2) {
            this.lock.unlock();
            throw th2;
        }
    }

    public final void release() {
        this.lock.lock();
        try {
            this.held = false;
            this.freed.signalAll();
        } finally {
            this.lock.unlock();
        }
    }
}
