package com.ranisaurus.newtorklayer.protocols;


import com.ranisaurus.newtorklayer.enums.NetworkRequestEnum;

/**
 * Created by MuzammilPeer on 3/13/2015.
 */
public interface IResponseProtocol {
    public void responseWithError(Exception error, NetworkRequestEnum requestType);
    public void successWithData(Object data, NetworkRequestEnum requestType);
}
