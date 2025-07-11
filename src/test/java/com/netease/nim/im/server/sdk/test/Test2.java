package com.netease.nim.im.server.sdk.test;

import com.netease.nim.server.sdk.core.BizName;
import com.netease.nim.server.sdk.core.endpoint.DefaultRetryPolicy;
import com.netease.nim.server.sdk.core.endpoint.RetryPolicy;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;

/**
 * Created by caojiajun on 2024/12/10
 */
public class Test2 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        //
        // RetryPolicy可以自定义
        int maxRetry = 1;
        boolean retryOn502 = true;
        RetryPolicy retryPolicy = new DefaultRetryPolicy(maxRetry, retryOn502);
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(BizName.IM, appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .retryPolicy(retryPolicy)
                .build();

        //
    }
}
