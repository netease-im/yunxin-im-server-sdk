package com.netease.nim.im.server.sdk.test;

import com.netease.nim.server.sdk.core.BizName;
import com.netease.nim.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.server.sdk.core.Result;
import com.netease.nim.server.sdk.core.YunxinApiHttpClient;
import com.netease.nim.server.sdk.core.trace.TimeoutSetter;
import com.netease.nim.server.sdk.core.trace.YunxinTraceId;
import com.netease.nim.server.sdk.im.v1.YunxinV1ApiServices;
import com.netease.nim.server.sdk.im.v1.account.request.CreateAccountRequestV1;
import com.netease.nim.server.sdk.im.v1.account.response.CreateAccountResponseV1;

/**
 * Created by caojiajun on 2024/12/11
 */
public class Test6 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(BizName.IM, appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .build();

        // services
        YunxinV1ApiServices services = new YunxinV1ApiServices(client);

        // request
        CreateAccountRequestV1 request = new CreateAccountRequestV1();
        request.setAccid("zhangsan");
        try {
            TimeoutSetter.setTimeout(10000);//设置本次请求的超时时间
            YunxinTraceId.set("your_trace_id");//设置本次请求的traceId
            Result<CreateAccountResponseV1> result = services.getAccountService().createAccount(request);
            if (result.isSuccess()) {
                CreateAccountResponseV1 response = result.getResponse();
                // 注册成功
                System.out.println("register success, accid=" + response.getAccid() + ", token=" + response.getToken() + ", traceId=" + result.getTraceId());
            } else {
                // 注册失败，如参数错误、重复注册等
                System.err.println("register fail, code=" + result.getCode() + ", msg=" + result.getMsg() + ", traceId=" + result.getTraceId());
            }
        } catch (YunxinSdkException e) {//这是一个RuntimeException
            // 超时等异常
            System.err.println("register error, endpoint = " + e.getContext().getEndpoint() + ", traceId=" + e.getTraceId());
        }
    }
}
