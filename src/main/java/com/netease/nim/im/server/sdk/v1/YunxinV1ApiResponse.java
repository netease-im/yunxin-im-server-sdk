package com.netease.nim.im.server.sdk.v1;

/**
 * Created by caojiajun on 2024/12/10
 */
public class YunxinV1ApiResponse {
    private final String endpoint;
    private final String data;
    private final String traceId;

    public YunxinV1ApiResponse(String endpoint, String data, String traceId) {
        this.endpoint = endpoint;
        this.data = data;
        this.traceId = traceId;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public String getData() {
        return data;
    }

    public String getTraceId() {
        return traceId;
    }
}