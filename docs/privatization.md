

## 私有化

* 私有化场景下，可以手动指定endpoint，此时多域名切换机制将失效

```java
import com.netease.nim.im.server.sdk.core.core.YunxinApiHttpClient;

/**
 * Created by caojiajun on 2024/12/10
 */
public class Test5 {
    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;

        String endpoint = "https://xxxx.com";
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .endpoint(endpoint)
                .build();

        //
    }
}

```