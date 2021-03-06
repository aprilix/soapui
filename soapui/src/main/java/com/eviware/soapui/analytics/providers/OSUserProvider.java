package com.eviware.soapui.analytics.providers;

import com.eviware.soapui.analytics.ActionDescription;
import com.eviware.soapui.analytics.OSUserDescription;
import com.eviware.soapui.analytics.UserInfoProvider;
import com.eviware.soapui.impl.support.HttpUtils;

/**
 * Created by avdeev on 02.02.2015.
 */
public class OSUserProvider extends BaseAnalyticsProvider implements UserInfoProvider{
    final private static String ANALYTICS_SERVER_URL = "https://analytics01.smartbear.com/open-source-analytics-server/analytics";

    @Override
    public void trackUserInfo(OSUserDescription osUserDescription) {
        String requestParams = prepareRequestParams(osUserDescription);
        sendRecord(ANALYTICS_SERVER_URL, requestParams);
    }

    @Override
    public void trackAction(ActionDescription actionDescription) {
    }

    private String prepareRequestParams (OSUserDescription osUserDescription){
        StringBuilder sb = new StringBuilder();
        sb.append("name=");
        sb.append(HttpUtils.urlEncodeWithUtf8(osUserDescription.getName()));
        sb.append("&email=");
        sb.append(HttpUtils.urlEncodeWithUtf8(osUserDescription.getEmail()));
        return sb.toString();
    }
}
