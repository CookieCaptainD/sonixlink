package com.mattiadoronzo.sonixlink;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Transport.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 *2\u00020\u0001:\u0002)*B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0003J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0003J\b\u0010\u0017\u001a\u00020\u0014H\u0002J2\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$H\u0003J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\tH\u0002J\u0012\u0010'\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\tH\u0002J*\u0010(\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/BluetoothTransport;", "Lcom/mattiadoronzo/sonixlink/Transport;", "address", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "busy", "Lcom/mattiadoronzo/sonixlink/PriorityGate;", "input", "Ljava/io/InputStream;", "label", "getLabel", "()Ljava/lang/String;", "lock", "Ljava/lang/Object;", "output", "Ljava/io/OutputStream;", "socket", "Landroid/bluetooth/BluetoothSocket;", "close", "", "connect", "deviceName", "drop", "exchange", "Lcom/mattiadoronzo/sonixlink/Response;", "path", "method", "readTimeout", "", "bulk", "", "body", "", "open", "device", "Landroid/bluetooth/BluetoothDevice;", "readHead", "inp", "readLine", "send", "Bounded", "Companion", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class BluetoothTransport implements Transport {
    private static final int CHANNEL = 22;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String PREFIX = "bt:";
    private static final UUID SERVICE;
    private static final ScheduledExecutorService timer;
    private final String address;
    private final PriorityGate busy;
    private InputStream input;
    private final Object lock;
    private final String name;
    private OutputStream output;
    private BluetoothSocket socket;

    public BluetoothTransport(String address, String name) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(name, "name");
        this.address = address;
        this.name = name;
        this.lock = new Object();
        this.busy = new PriorityGate();
    }

    public /* synthetic */ BluetoothTransport(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "" : str2);
    }

    /* JADX INFO: compiled from: Transport.kt */
    @Metadata(m147d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/BluetoothTransport$Companion;", "", "()V", "CHANNEL", "", "PREFIX", "", "SERVICE", "Ljava/util/UUID;", "getSERVICE", "()Ljava/util/UUID;", "timer", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "addressOf", "host", "isBluetooth", "", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UUID getSERVICE() {
            return BluetoothTransport.SERVICE;
        }

        public final boolean isBluetooth(String host) {
            Intrinsics.checkNotNullParameter(host, "host");
            return StringsKt.startsWith$default(host, BluetoothTransport.PREFIX, false, 2, (Object) null);
        }

        public final String addressOf(String host) {
            Intrinsics.checkNotNullParameter(host, "host");
            return StringsKt.removePrefix(host, (CharSequence) BluetoothTransport.PREFIX);
        }
    }

    static {
        UUID uuidFromString = UUID.fromString("8d6e3a52-4c1f-4b7e-9a2d-5f0c7e1b3a90");
        Intrinsics.checkNotNullExpressionValue(uuidFromString, "fromString(...)");
        SERVICE = uuidFromString;
        timer = Executors.newSingleThreadScheduledExecutor();
    }

    @Override // com.mattiadoronzo.sonixlink.Transport
    public String getLabel() {
        String str = this.name;
        if (str.length() == 0) {
            String strDeviceName = deviceName();
            if (strDeviceName == null) {
                strDeviceName = this.address;
            }
            str = strDeviceName;
        }
        return str;
    }

    private final String deviceName() {
        BluetoothDevice remoteDevice;
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter == null || (remoteDevice = defaultAdapter.getRemoteDevice(this.address)) == null) {
                return null;
            }
            return remoteDevice.getName();
        } catch (Exception e) {
            return null;
        }
    }

    private final void connect() throws IOException {
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        if (adapter == null) {
            throw new IOException("no Bluetooth");
        }
        BluetoothDevice device = adapter.getRemoteDevice(this.address);
        try {
            adapter.cancelDiscovery();
        } catch (SecurityException e) {
        }
        Intrinsics.checkNotNull(device);
        BluetoothSocket fresh = open(device);
        this.socket = fresh;
        this.input = new BufferedInputStream(fresh.getInputStream(), 16384);
        this.output = fresh.getOutputStream();
    }

    private final BluetoothSocket open(BluetoothDevice device) throws IOException {
        BluetoothSocket first = device.createRfcommSocketToServiceRecord(SERVICE);
        try {
            first.connect();
            Intrinsics.checkNotNull(first);
            return first;
        } catch (IOException e) {
            try {
                first.close();
            } catch (IOException e2) {
            }
            try {
                Object objInvoke = device.getClass().getMethod("createRfcommSocket", Integer.TYPE).invoke(device, 22);
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type android.bluetooth.BluetoothSocket");
                BluetoothSocket byChannel = (BluetoothSocket) objInvoke;
                try {
                    byChannel.connect();
                    try {
                        device.fetchUuidsWithSdp();
                    } catch (Exception e3) {
                    }
                    return byChannel;
                } catch (IOException second) {
                    try {
                        byChannel.close();
                    } catch (IOException e4) {
                    }
                    throw new IOException(e.getMessage() + " / " + second.getMessage(), e);
                }
            } catch (Exception e5) {
                throw e;
            }
        }
    }

    private final void drop() {
        try {
            BluetoothSocket bluetoothSocket = this.socket;
            if (bluetoothSocket != null) {
                bluetoothSocket.close();
            }
        } catch (IOException e) {
        }
        this.socket = null;
        this.input = null;
        this.output = null;
    }

    @Override // com.mattiadoronzo.sonixlink.Transport
    public void close() {
        synchronized (this.lock) {
            drop();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.mattiadoronzo.sonixlink.Transport
    public Response exchange(String path, String method, int readTimeout, boolean bulk, byte[] body) throws Exception {
        Response responseSend;
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(method, "method");
        this.busy.acquire(bulk);
        try {
            synchronized (this.lock) {
                boolean hadLink = this.socket != null;
                try {
                    responseSend = send(path, method, readTimeout, body);
                } catch (IOException e) {
                    drop();
                    if (!hadLink) {
                        throw e;
                    }
                    responseSend = send(path, method, readTimeout, body);
                }
            }
            Response response = responseSend;
            return response;
        } catch (Exception e2) {
            this.busy.release();
            throw e2;
        }
    }

    private final Response send(String path, String method, int readTimeout, byte[] body) throws IOException {
        String length;
        if (this.socket == null) {
            connect();
        }
        OutputStream out = this.output;
        if (out == null) {
            throw new IOException("not connected");
        }
        InputStream inp = this.input;
        if (inp == null) {
            throw new IOException("not connected");
        }
        if (body != null) {
            length = "Content-Length: " + body.length + "\r\n";
        } else {
            length = "";
        }
        byte[] bytes = (method + " " + path + " HTTP/1.1\r\nHost: sonixlink\r\nConnection: keep-alive\r\n" + length + "\r\n").getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        out.write(bytes);
        if (body != null) {
            out.write(body);
        }
        out.flush();
        final BluetoothSocket stuck = this.socket;
        ScheduledFuture<?> scheduledFutureSchedule = timer.schedule(new Runnable() { // from class: com.mattiadoronzo.sonixlink.BluetoothTransport$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BluetoothTransport.send$lambda$3(stuck);
            }
        }, readTimeout, TimeUnit.MILLISECONDS);
        try {
            return readHead(inp);
        } finally {
            scheduledFutureSchedule.cancel(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void send$lambda$3(BluetoothSocket $stuck) {
        if ($stuck != null) {
            try {
                $stuck.close();
            } catch (IOException e) {
            }
        }
    }

    private final Response readHead(InputStream inp) throws IOException {
        Integer intOrNull;
        String status = readLine(inp);
        if (status == null) {
            throw new IOException("the player closed the link");
        }
        String str = (String) CollectionsKt.getOrNull(StringsKt.split$default((CharSequence) status, new char[]{' '}, false, 0, 6, (Object) null), 1);
        if (str == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) {
            throw new IOException("bad answer: " + status);
        }
        int code = intOrNull.intValue();
        long length = -1;
        while (true) {
            String line = readLine(inp);
            if (line == null) {
                throw new IOException("the player closed the link");
            }
            if (line.length() == 0) {
                if (length >= 0) {
                    return new Response(code, length, new Bounded(inp, length), new Function0<Unit>() { // from class: com.mattiadoronzo.sonixlink.BluetoothTransport.readHead.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            BluetoothTransport.this.busy.release();
                        }
                    });
                }
                throw new IOException("an answer with no length");
            }
            int colon = StringsKt.indexOf$default((CharSequence) line, ':', 0, false, 6, (Object) null);
            if (colon > 0) {
                String strSubstring = line.substring(0, colon);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                if (StringsKt.equals(StringsKt.trim((CharSequence) strSubstring).toString(), "Content-Length", true)) {
                    String strSubstring2 = line.substring(colon + 1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                    Long longOrNull = StringsKt.toLongOrNull(StringsKt.trim((CharSequence) strSubstring2).toString());
                    length = longOrNull != null ? longOrNull.longValue() : -1L;
                }
            }
        }
    }

    private final String readLine(InputStream input) throws IOException {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        while (true) {
            int b = input.read();
            if (b < 0) {
                if (bytes.size() == 0) {
                    return null;
                }
                return bytes.toString("UTF-8");
            }
            if (b != 10) {
                if (b != 13) {
                    bytes.write(b);
                }
            } else {
                return bytes.toString("UTF-8");
            }
        }
    }

    /* JADX INFO: compiled from: Transport.kt */
    @Metadata(m147d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J \u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/BluetoothTransport$Bounded;", "Ljava/io/InputStream;", "source", "left", "", "(Ljava/io/InputStream;J)V", "available", "", "close", "", "read", "buffer", "", "offset", "length", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private static final class Bounded extends InputStream {
        private long left;
        private final InputStream source;

        public Bounded(InputStream source, long left) {
            Intrinsics.checkNotNullParameter(source, "source");
            this.source = source;
            this.left = left;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.left <= 0) {
                return -1;
            }
            int b = this.source.read();
            if (b >= 0) {
                this.left--;
            }
            return b;
        }

        @Override // java.io.InputStream
        public int read(byte[] buffer, int offset, int length) throws IOException {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            if (this.left <= 0) {
                return -1;
            }
            int want = (int) Math.min(length, this.left);
            int n = this.source.read(buffer, offset, want);
            if (n > 0) {
                this.left -= (long) n;
            }
            return n;
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(this.source.available(), this.left);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            int n;
            byte[] skip = new byte[8192];
            while (this.left > 0 && (n = this.source.read(skip, 0, (int) Math.min(skip.length, this.left))) > 0) {
                this.left -= (long) n;
            }
        }
    }
}
