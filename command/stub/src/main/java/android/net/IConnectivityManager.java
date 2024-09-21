package android.net;

import android.net.LinkProperties;
import android.net.Network;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

public interface IConnectivityManager extends IInterface {
  public Network getActiveNetwork()
    throws RemoteException;

  public LinkProperties getLinkProperties(Network network)
    throws RemoteException;

  abstract class Stub extends Binder implements IConnectivityManager {
    public static IConnectivityManager asInterface(IBinder binder) {
      throw new RuntimeException("STUB");
    }

    @Override public IBinder asBinder() {
      return this;
    }
  }
}
