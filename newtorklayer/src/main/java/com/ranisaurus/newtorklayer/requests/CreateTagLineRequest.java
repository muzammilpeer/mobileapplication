package com.ranisaurus.newtorklayer.requests;

import com.ranisaurus.newtorklayer.enums.NetworkRequestEnum;
import com.ranisaurus.utilitylayer.network.GsonUtil;

/**
 * Created by muzammilpeer on 8/30/15.
 */
public class CreateTagLineRequest extends BaseNetworkRequest {

    //copy constructor
    public CreateTagLineRequest(Object model) {
        super(model);
    }

    public String getURL() throws Exception {
        return NetworkRequestEnum.BASE_SERVER_URL.getRelativeUrl()
                + NetworkRequestEnum.CREATE_TAG_LINE.getRelativeUrl();
    }

    @Override
    public Boolean haveGetData() {
        return true;
    }

    @Override
    public String getData() throws Exception {
        return GsonUtil.getQueryStringURL(this.getDataModel());
    }


}
