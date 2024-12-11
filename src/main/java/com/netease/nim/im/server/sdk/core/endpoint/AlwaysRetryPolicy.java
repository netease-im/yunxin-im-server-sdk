package com.netease.nim.im.server.sdk.core.endpoint;

/**
 * Created by caojiajun on 2024/12/9
 */
public class AlwaysRetryPolicy implements RetryPolicy {

    @Override
    public RetryAction onError(ExecuteContext retryContext, Throwable error) {
        return RetryAction.RETRY_NEXT;
    }
}