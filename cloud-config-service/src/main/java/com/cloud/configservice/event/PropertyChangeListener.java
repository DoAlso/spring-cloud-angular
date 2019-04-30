package com.cloud.configservice.event;

import com.cloud.configservice.service.UrlMakerService;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


/**
 * @ClassName PropertyChangeListener
 * @Description TODO
 * @Author Administrator
 * @DATE 2019/4/10 10:41
 */
@Component
public class PropertyChangeListener implements ApplicationListener<PropertyChangeEvent> {
    private static Logger LOGGER = LoggerFactory.getLogger(PropertyChangeListener.class);
    private static final String END_POINT = "/actuator/bus-refresh";
    private OkHttpClient okHttpClient = buildOkHttpClient();
    @Autowired
    protected UrlMakerService urlMakerService;

    @Override
    public void onApplicationEvent(PropertyChangeEvent event) {
        LOGGER.info("开始调用事件总线的刷新机制......");
        String url = urlMakerService.configServerBaseUrl(event.getProfile())+END_POINT;
        try {
            String response = callTextPlain(url, "");
            LOGGER.info("response:{}",response);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private OkHttpClient buildOkHttpClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.SECONDS)
                .writeTimeout(2, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .build();
        return client;
    }

    private String callTextPlain(String url, String value) throws Exception {
        LOGGER.info("call text plain : {}" , url);
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/json")
                .post(RequestBody.create(MediaType.parse("application/json"), value))
                .build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        ResponseBody responseBody = response.body();
        return responseBody.string();
    }
}
