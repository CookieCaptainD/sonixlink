package com.mattiadoronzo.sonixlink;

import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Discovery.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0003\u0014\u0015\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\u000eJ\u001c\u0010\u0010\u001a\u00020\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\u000eH\u0002J\u001c\u0010\u0012\u001a\u00020\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\u000eH\u0002J\u0006\u0010\u0013\u001a\u00020\fR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/Discovery;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "beacon", "Lcom/mattiadoronzo/sonixlink/Discovery$BeaconListener;", "listener", "Landroid/net/nsd/NsdManager$DiscoveryListener;", "nsd", "Landroid/net/nsd/NsdManager;", "start", "", "onFound", "Lkotlin/Function1;", "Lcom/mattiadoronzo/sonixlink/Discovery$Found;", "startBeacon", "report", "startNsd", "stop", "BeaconListener", "Companion", "Found", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Discovery {
    public static final int BEACON_PORT = 7801;
    private static final String BEACON_PREFIX = "SONIXLINK1";
    public static final String SERVICE_TYPE = "_sonixlink._tcp.";
    private static final String TAG = "SonixLinkDiscovery";
    private BeaconListener beacon;
    private final Context context;
    private NsdManager.DiscoveryListener listener;
    private NsdManager nsd;

    public Discovery(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    /* JADX INFO: compiled from: Discovery.kt */
    @Metadata(m147d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/Discovery$Found;", "", "name", "", "host", "port", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getHost", "()Ljava/lang/String;", "getName", "getPort", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class Found {
        private final String host;
        private final String name;
        private final int port;

        public static /* synthetic */ Found copy$default(Found found, String str, String str2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = found.name;
            }
            if ((i2 & 2) != 0) {
                str2 = found.host;
            }
            if ((i2 & 4) != 0) {
                i = found.port;
            }
            return found.copy(str, str2, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getHost() {
            return this.host;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getPort() {
            return this.port;
        }

        public final Found copy(String name, String host, int port) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(host, "host");
            return new Found(name, host, port);
        }

        public String toString() {
            return "Found(name=" + this.name + ", host=" + this.host + ", port=" + this.port + ")";
        }

        public Found(String name, String host, int port) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(host, "host");
            this.name = name;
            this.host = host;
            this.port = port;
        }

        public final String getHost() {
            return this.host;
        }

        public final String getName() {
            return this.name;
        }

        public final int getPort() {
            return this.port;
        }

        public boolean equals(Object other) {
            return (other instanceof Found) && Intrinsics.areEqual(((Found) other).host, this.host) && ((Found) other).port == this.port;
        }

        public int hashCode() {
            return (this.host.hashCode() * 31) + this.port;
        }
    }

    public final void start(Function1<? super Found, Unit> onFound) {
        Intrinsics.checkNotNullParameter(onFound, "onFound");
        HashSet seen = new HashSet();
        Function1 report = new Discovery$start$report$1(seen, this, onFound);
        startNsd(report);
        startBeacon(report);
    }

    public final void stop() {
        NsdManager.DiscoveryListener active = this.listener;
        if (active != null) {
            try {
                NsdManager nsdManager = this.nsd;
                if (nsdManager != null) {
                    nsdManager.stopServiceDiscovery(active);
                    Unit unit = Unit.INSTANCE;
                }
            } catch (IllegalArgumentException e) {
                Unit unit2 = Unit.INSTANCE;
            }
        }
        this.listener = null;
        BeaconListener beaconListener = this.beacon;
        if (beaconListener != null) {
            beaconListener.shutdown();
        }
        this.beacon = null;
    }

    private final void startNsd(final Function1<? super Found, Unit> report) {
        Object systemService = this.context.getSystemService("servicediscovery");
        final NsdManager manager = systemService instanceof NsdManager ? (NsdManager) systemService : null;
        if (manager == null) {
            return;
        }
        this.nsd = manager;
        final ArrayDeque pending = new ArrayDeque();
        final Ref.BooleanRef resolving = new Ref.BooleanRef();
        NsdManager.DiscoveryListener discoveryListener = new NsdManager.DiscoveryListener() { // from class: com.mattiadoronzo.sonixlink.Discovery$startNsd$active$1
            @Override // android.net.nsd.NsdManager.DiscoveryListener
            public void onStartDiscoveryFailed(String type, int errorCode) {
                Intrinsics.checkNotNullParameter(type, "type");
                Log.w("SonixLinkDiscovery", "discovery failed to start (" + errorCode + ")");
            }

            @Override // android.net.nsd.NsdManager.DiscoveryListener
            public void onStopDiscoveryFailed(String type, int errorCode) {
                Intrinsics.checkNotNullParameter(type, "type");
            }

            @Override // android.net.nsd.NsdManager.DiscoveryListener
            public void onDiscoveryStarted(String type) {
                Intrinsics.checkNotNullParameter(type, "type");
            }

            @Override // android.net.nsd.NsdManager.DiscoveryListener
            public void onDiscoveryStopped(String type) {
                Intrinsics.checkNotNullParameter(type, "type");
            }

            @Override // android.net.nsd.NsdManager.DiscoveryListener
            public void onServiceFound(NsdServiceInfo info) {
                Intrinsics.checkNotNullParameter(info, "info");
                pending.addLast(info);
                Discovery.startNsd$resolveNext(resolving, pending, manager, report);
            }

            @Override // android.net.nsd.NsdManager.DiscoveryListener
            public void onServiceLost(NsdServiceInfo info) {
                Intrinsics.checkNotNullParameter(info, "info");
            }
        };
        this.listener = discoveryListener;
        try {
            manager.discoverServices(SERVICE_TYPE, 1, discoveryListener);
        } catch (Exception e) {
            Log.w(TAG, "mDNS unavailable: " + e.getMessage());
            this.listener = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startNsd$resolveNext(final Ref.BooleanRef resolving, final ArrayDeque<NsdServiceInfo> arrayDeque, final NsdManager manager, final Function1<? super Found, Unit> function1) {
        NsdServiceInfo service;
        if (resolving.element || (service = arrayDeque.removeFirstOrNull()) == null) {
            return;
        }
        resolving.element = true;
        manager.resolveService(service, new NsdManager.ResolveListener() { // from class: com.mattiadoronzo.sonixlink.Discovery$startNsd$resolveNext$1
            @Override // android.net.nsd.NsdManager.ResolveListener
            public void onResolveFailed(NsdServiceInfo info, int errorCode) {
                Intrinsics.checkNotNullParameter(info, "info");
                Log.w("SonixLinkDiscovery", "resolve failed: " + info.getServiceName() + " (" + errorCode + ")");
                resolving.element = false;
                Discovery.startNsd$resolveNext(resolving, arrayDeque, manager, function1);
            }

            @Override // android.net.nsd.NsdManager.ResolveListener
            public void onServiceResolved(NsdServiceInfo info) {
                Intrinsics.checkNotNullParameter(info, "info");
                InetAddress host = info.getHost();
                String host2 = host != null ? host.getHostAddress() : null;
                if (host2 != null) {
                    Function1<Discovery.Found, Unit> function2 = function1;
                    String serviceName = info.getServiceName();
                    if (serviceName == null) {
                        serviceName = host2;
                    }
                    function2.invoke(new Discovery.Found(serviceName, host2, info.getPort()));
                }
                resolving.element = false;
                Discovery.startNsd$resolveNext(resolving, arrayDeque, manager, function1);
            }
        });
    }

    private final void startBeacon(Function1<? super Found, Unit> report) {
        BeaconListener it = new BeaconListener(this.context, report);
        it.start();
        this.beacon = it;
    }

    /* JADX INFO: compiled from: Discovery.kt */
    @Metadata(m147d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u001a\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0006\u0010\u0013\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/Discovery$BeaconListener;", "Ljava/lang/Thread;", "context", "Landroid/content/Context;", "report", "Lkotlin/Function1;", "Lcom/mattiadoronzo/sonixlink/Discovery$Found;", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "running", "", "socket", "Ljava/net/DatagramSocket;", "parse", "message", "", "from", "Ljava/net/InetAddress;", "run", "shutdown", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private static final class BeaconListener extends Thread {
        private final Context context;
        private final Function1<Found, Unit> report;
        private volatile boolean running;
        private DatagramSocket socket;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public BeaconListener(Context context, Function1<? super Found, Unit> report) {
            super("sonixlink-beacon");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(report, "report");
            this.context = context;
            this.report = report;
            this.running = true;
        }

        public final void shutdown() {
            this.running = false;
            DatagramSocket datagramSocket = this.socket;
            if (datagramSocket != null) {
                datagramSocket.close();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            WifiManager.MulticastLock $this$run_u24lambda_u240;
            Object systemService = this.context.getApplicationContext().getSystemService("wifi");
            WifiManager wifi = systemService instanceof WifiManager ? (WifiManager) systemService : null;
            if (wifi == null || ($this$run_u24lambda_u240 = wifi.createMulticastLock("sonixlink")) == null) {
                $this$run_u24lambda_u240 = null;
            } else {
                $this$run_u24lambda_u240.setReferenceCounted(true);
                $this$run_u24lambda_u240.acquire();
            }
            try {
                try {
                    DatagramSocket $this$run_u24lambda_u241 = new DatagramSocket((SocketAddress) null);
                    $this$run_u24lambda_u241.setReuseAddress(true);
                    $this$run_u24lambda_u241.setBroadcast(true);
                    $this$run_u24lambda_u241.bind(new InetSocketAddress(Discovery.BEACON_PORT));
                    $this$run_u24lambda_u241.setSoTimeout(1000);
                    this.socket = $this$run_u24lambda_u241;
                    byte[] buffer = new byte[512];
                    while (this.running) {
                        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                        try {
                            $this$run_u24lambda_u241.receive(packet);
                            byte[] data = packet.getData();
                            Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
                            String str = new String(data, 0, packet.getLength(), Charsets.UTF_8);
                            InetAddress address = packet.getAddress();
                            Intrinsics.checkNotNullExpressionValue(address, "getAddress(...)");
                            Found found = parse(str, address);
                            if (found != null) {
                                this.report.invoke(found);
                            } else {
                                continue;
                            }
                        } catch (SocketTimeoutException e) {
                        } catch (Exception e2) {
                        }
                    }
                    DatagramSocket listening = this.socket;
                    if (listening != null) {
                        listening.close();
                    }
                    if ($this$run_u24lambda_u240 != null) {
                        WifiManager.MulticastLock it = $this$run_u24lambda_u240;
                        if (it.isHeld()) {
                            it.release();
                        }
                    }
                } catch (Exception e3) {
                    Log.w(Discovery.TAG, "cannot listen for the beacon: " + e3.getMessage());
                    DatagramSocket datagramSocket = this.socket;
                    if (datagramSocket != null) {
                        datagramSocket.close();
                    }
                    if ($this$run_u24lambda_u240 != null) {
                        WifiManager.MulticastLock it2 = $this$run_u24lambda_u240;
                        if (it2.isHeld()) {
                            it2.release();
                        }
                    }
                }
            } catch (Throwable th) {
                DatagramSocket datagramSocket2 = this.socket;
                if (datagramSocket2 != null) {
                    datagramSocket2.close();
                }
                if ($this$run_u24lambda_u240 != null) {
                    WifiManager.MulticastLock it3 = $this$run_u24lambda_u240;
                    if (it3.isHeld()) {
                        it3.release();
                    }
                }
                throw th;
            }
        }

        private final Found parse(String message, InetAddress from) {
            Integer intOrNull;
            List parts = StringsKt.split$default((CharSequence) StringsKt.trim((CharSequence) message).toString(), new String[]{" "}, false, 4, 2, (Object) null);
            if (parts.size() < 3 || !Intrinsics.areEqual(parts.get(0), Discovery.BEACON_PREFIX) || (intOrNull = StringsKt.toIntOrNull((String) parts.get(2))) == null) {
                return null;
            }
            int port = intOrNull.intValue();
            String host = from.getHostAddress();
            if (host == null) {
                host = (String) parts.get(1);
            }
            String name = (parts.size() <= 3 || !(true ^ StringsKt.isBlank((CharSequence) parts.get(3)))) ? host : (String) parts.get(3);
            return new Found(name, host, port);
        }
    }
}
