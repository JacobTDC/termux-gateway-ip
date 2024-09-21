package com.termux.gatewayip;

import android.net.IConnectivityManager;
import android.net.LinkProperties;
import android.net.RouteInfo;
import android.os.RemoteException;
import android.os.ServiceManager;
import androidx.annotation.Keep;

public class CommandLineEntry {
  @Keep public static final void main(String[] args) {
    try {
      IConnectivityManager connectivityManager = IConnectivityManager.Stub.asInterface(ServiceManager.getService("connectivity"));
      LinkProperties linkProperties = connectivityManager.getLinkProperties(connectivityManager.getActiveNetwork());
      for (RouteInfo routeInfo: linkProperties.getRoutes()) {
        if (routeInfo.isDefaultRoute() && routeInfo.hasGateway()) {
          System.out.println(routeInfo.getGateway().getHostAddress());
          continue;
        }
      }
    } catch (RemoteException exc) {
      throw new RuntimeException(exc);
    }

    System.exit(0);
  }
}
