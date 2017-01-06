package com.geekluxun.www.weex;

import android.app.Application;

import com.alibaba.weex.commons.adapter.ImageAdapter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.taobao.weex.InitConfig;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKEngine;

public class WeexInit {

    public static void Init(Application application, boolean enable, String host){
        /**
         * Set up for fresco usage.
         * Set<RequestListener> requestListeners = new HashSet<>();
         * requestListeners.add(new RequestLoggingListener());
         * ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
         *     .setRequestListeners(requestListeners)
         *     .build();
         * Fresco.initialize(this,config);
         **/
        initDebugEnvironment(enable, host);
        WXSDKEngine.addCustomOptions("appName", "WXSample");
        WXSDKEngine.addCustomOptions("appGroup", "WXApp");
        WXSDKEngine.initialize(application,
                new InitConfig.Builder()
                        //.setImgAdapter(new FrescoImageAdapter())// use fresco adapter
                        .setImgAdapter(new ImageAdapter())
                        //.setDebugAdapter(new PlayDebugAdapter())
                        .build()
        );

        Fresco.initialize(application.getApplicationContext());

//        try {
//            Fresco.initialize(context);
//
//            WXSDKEngine.registerComponent("richtext", RichText.class);
//            WXSDKEngine.registerModule("render", RenderModule.class);
//            WXSDKEngine.registerModule("event", WXEventModule.class);
//
//            WXSDKEngine.registerModule("myModule", MyModule.class);
//            WXSDKEngine.registerModule("geolocation", GeolocationModule.class);
//            /**
//             * override default image tag
//             * WXSDKEngine.registerComponent("image", FrescoImageComponent.class);
//             */
//
//
//        } catch (WXException e) {
//            e.printStackTrace();
//        }

    }


    /**
     *
     * @param enable enable remote debugger. valid only if host not to be "DEBUG_SERVER_HOST".
     *               true, you can launch a remote debugger and inspector both.
     *               false, you can  just launch a inspector.
     * @param host the debug server host, must not be "DEBUG_SERVER_HOST", a ip address or domain will be OK.
     *             for example "127.0.0.1".
     */
    private  static void initDebugEnvironment(boolean enable, String host) {
        if (!"DEBUG_SERVER_HOST".equals(host)) {
            WXEnvironment.sRemoteDebugMode = enable;
            WXEnvironment.sRemoteDebugProxyUrl = "ws://" + host + ":8088/debugProxy/native";
        }
    }
}
