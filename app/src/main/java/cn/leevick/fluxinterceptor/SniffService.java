package cn.leevick.fluxinterceptor;

import android.content.Intent;
import android.net.Network;
import android.net.VpnService;
import android.os.IBinder;
import android.util.Log;

import java.net.DatagramSocket;
import java.net.Socket;

public class SniffService extends VpnService {

    public static final String ACTION_CONNECT = "cn.leevick.SniffService.ACTION_CONNECT";
    static final String TAG = SniffService.class.getSimpleName();

    public SniffService() {
        super();
    }

    @Override
    public boolean protect(int socket) {
        return super.protect(socket);
    }

    @Override
    public boolean protect(Socket socket) {
        return super.protect(socket);
    }

    @Override
    public boolean protect(DatagramSocket socket) {
        return super.protect(socket);
    }

    @Override
    public boolean setUnderlyingNetworks(Network[] networks) {
        return super.setUnderlyingNetworks(networks);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override
    public void onRevoke() {
        super.onRevoke();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"onStartCommand("+intent.getAction()+")");

        switch (intent.getAction()){
            case ACTION_CONNECT:
                VpnService.Builder builder = this.new Builder();
                builder.addAddress("10.95.55.248",0);
                builder.establish();
        }


        return super.onStartCommand(intent, flags, startId);
    }
}
