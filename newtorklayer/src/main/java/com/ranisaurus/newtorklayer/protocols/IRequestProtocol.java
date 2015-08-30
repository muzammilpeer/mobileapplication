package com.ranisaurus.newtorklayer.protocols;

/**
 * Created by MuzammilPeer on 3/13/2015.
 */

import com.google.gson.JsonObject;

public interface IRequestProtocol {

    public String getURL() throws Exception;
    public Boolean haveGetData();
    public String getData() throws Exception;
    public Boolean havePostData();
    public JsonObject postData() throws Exception;
    public Boolean haveImageData();
    public Object getImageData() throws Exception;
}
