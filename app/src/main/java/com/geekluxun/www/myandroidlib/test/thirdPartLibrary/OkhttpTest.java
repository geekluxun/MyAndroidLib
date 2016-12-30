package com.geekluxun.www.myandroidlib.test.thirdPartLibrary;

import android.content.Context;
import com.orhanobut.logger.Logger;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.PostStringBuilder;
import com.zhy.http.okhttp.callback.StringCallback;
import org.json.JSONObject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Call;
import utils.Md5Util;

/**
 * Created by mark on 2016/11/28.
 */
public class OkhttpTest {
    public static String MD5KEY = "GuJinSuoIL6pvSsve9P0l8JswjcP4w";
    private Context curContext;
    private static final String  mBaseUrl = "http://www.gujinsuo.com.cn/p2p/";
    public OkhttpTest(Context context){
        curContext = context;
        Map map = new HashMap();
        postData(mBaseUrl + "v2/project/getrecommendproject", map);
    }

    public static void main(String[] args){
        Map map = new HashMap();
        postData(mBaseUrl + "v2/project/getrecommendproject", map);
    }

    public static void postData(String url,
                         Map<String, String> map
                         ) {

        if (map != null) {
            map.put("terminalid", "A");
            map.put("devicecode", "12315");
            map.put("timestamp", System.currentTimeMillis() + "");
            map.put("version", "v2.0");
            Md5Util md5 = new Md5Util();
            map.put("sign", md5.sign(getSigin(map), MD5KEY));
        }

        JSONObject jsonObject = new JSONObject(map);
        PostStringBuilder builder = OkHttpUtils.postString();

        builder.url(url)
                .content(jsonObject.toString())
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Logger.t("okhttp").i(response);
                    }
                });

    }


    public static String getSigin(Map<String, String> map) {
        String mStr = "";
        String[] mSort = new String[map.size()];
        int i = 0;
        for (String string : map.keySet()) {
            mSort[i] = string;
            i++;
        }
        Arrays.sort(mSort, null);
        for (int j = 0; j < mSort.length; j++) {
            if (map.get(mSort[j]) != null) {
                mStr = mStr + mSort[j] +"="+ map.get(mSort[j]) + "&";
            }
        }
        if (mStr.length() > 0)
            return mStr.substring(0, mStr.length() - 1);
        return mStr;
    }
}
