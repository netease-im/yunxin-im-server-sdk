package com.netease.nim.im.server.sdk.v1.account;

import com.alibaba.fastjson2.JSONObject;
import com.netease.nim.im.server.sdk.core.exception.YunxinSdkException;
import com.netease.nim.im.server.sdk.v1.YunxinV1ApiHttpClient;
import com.netease.nim.im.server.sdk.v1.YunxinV1ApiResponse;
import com.netease.nim.im.server.sdk.v1.account.request.CreateAccountRequest;
import com.netease.nim.im.server.sdk.v1.account.response.CreateAccountResponse;
import com.netease.nim.im.server.sdk.v1.exception.YunxinSdkCodeException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by caojiajun on 2024/12/11
 */
public class AccountService implements IAccountService {

    private final YunxinV1ApiHttpClient httpClient;

    public AccountService(YunxinV1ApiHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public CreateAccountResponse createAccount(CreateAccountRequest request) throws YunxinSdkException {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("accid", request.getAccid());
        YunxinV1ApiResponse apiResponse = httpClient.execute("/user/create.action", paramMap);
        JSONObject object = JSONObject.parseObject(apiResponse.getData());
        int code = object.getIntValue("code");
        if (code != 200) {
            throw new YunxinSdkCodeException(apiResponse.getEndpoint(), code, apiResponse.getTraceId(), object.getString("desc"));
        }
        CreateAccountResponse response = new CreateAccountResponse();
        response.setTraceId(apiResponse.getTraceId());
        JSONObject info = object.getJSONObject("info");
        response.setAccid(info.getString("accid"));
        response.setName(info.getString("name"));
        response.setToken(info.getString("token"));
        return response;
    }

}