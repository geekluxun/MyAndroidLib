package com.geekluxun.www.myandroidlib.test.thirdPartLibrary;

import android.content.Context;
import android.text.InputType;

import com.orhanobut.logger.Logger;

import org.json.JSONObject;

import java.io.IOException;
import java.security.PrivateKey;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import utils.Md5Util;

/**
 * Created by geekluxun on 2016/11/28.
 */
public class RetrofitTest{
    public static String MD5KEY = "GuJinSuoIL6pvSsve9P0l8JswjcP4w";
    private static final String  mBaseUrl = "http://www.gujinsuo.com.cn/p2p/";
    //private static final String  mBaseUrl2 = "http://172.16.1.34:3000/";
    private static final String  mBaseUrl2 = "http://localhost:8000/";
    private Context curContext;
    public RetrofitTest(Context context){
        curContext = context;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .build();

        TestService service = retrofit.create(TestService.class);

        Map paras = new HashMap();
        paras.put("terminalid", "A");
        paras.put("devicecode", "1235");
        paras.put("timestamp", System.currentTimeMillis() + "");
        paras.put("version", "v2.0");
        Md5Util md5 = new Md5Util();
        paras.put("sign", md5.sign(getSigin(paras), MD5KEY));

        //把请求参数转换成json字符串作为请求体
        JSONObject jsonObject = new JSONObject(paras);
        RequestBody requestBody =  RequestBody.create(
                MediaType.parse("application/json; charset=utf-8"),
                jsonObject.toString());


        Logger.i(jsonObject.toString());

        Call<ResponseBody> call = service.getData(requestBody);

        //调用接口
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Logger.i(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });

        //testGetData2();
        testGetData3();
        //testGetData4();
    }

    //定义接口
    public interface TestService {
        @POST("v2/project/getrecommendproject")
        Call<ResponseBody> getData(@Body RequestBody requestBody);
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

    public interface TestService2{
        @GET("posts/{id}")
        Call<ResponseBody> getData(@Path("id") int id);
    }


    public void testGetData2() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mBaseUrl2)
                .build();

        TestService2 service = retrofit.create(TestService2.class);
        Call<ResponseBody> call = service.getData(1);
        call.enqueue(new Callback<ResponseBody>() {
                         @Override
                         public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                             try {
                                 Logger.t("testetData2").i(response.body().string());
                             }catch (Exception e){
                                 Logger.e(e, "error");
                             }
                         }

                         @Override
                         public void onFailure(Call<ResponseBody> call, Throwable t) {
                             Logger.e(t, "error");
                         }
                     }

        );

    }

    public interface TestService3{
        @HTTP(method = "GET",path = "posts/{id}",hasBody = false)
        Call<ResponseBody> getData(@Path("id") int id);
    }


    public void testGetData3() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mBaseUrl2)
                .build();

        TestService3 service = retrofit.create(TestService3.class);
        Call<ResponseBody> call = service.getData(1);
        call.enqueue(new Callback<ResponseBody>() {
                         @Override
                         public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                             try {
                                 Logger.t("testetData3").i(response.body().string());
                             }catch (Exception e){
                                 Logger.e(e, "error");
                             }
                         }

                         @Override
                         public void onFailure(Call<ResponseBody> call, Throwable t) {
                             Logger.e(t, "error");
                         }
                     }

        );

    }


    public interface TestService4 {
        /**
         * {@link FormUrlEncoded} 表明是一个表单格式的请求（Content-Type:application/x-www-form-urlencoded）
         * <code>Field("username")</code> 表示将后面的 <code>String name</code> 中name的取值作为 username 的值
         */
        @POST("/posts")
        @FormUrlEncoded
        Call<ResponseBody> testFormUrlEncoded1(@Field("id") String name, @Field("author") String age);

        /**
         * Map的key作为表单的键
         */
        @POST("/posts")
        @FormUrlEncoded
        Call<ResponseBody> testFormUrlEncoded2(@FieldMap Map<String, Object> map);


        /**
         * {@link Part} 后面支持三种类型，{@link RequestBody}、{@link okhttp3.MultipartBody.Part} 、任意类型
         * 除 {@link okhttp3.MultipartBody.Part} 以外，其它类型都必须带上表单字段({@link okhttp3.MultipartBody.Part} 中已经包含了表单字段的信息)，
         */
        @POST("/posts")
        @Multipart
        Call<ResponseBody> testFileUpload1(@Part("name") RequestBody name, @Part("age") RequestBody age, @Part MultipartBody.Part file);

        /**
         * PartMap 注解支持一个Map作为参数，支持 {@link RequestBody } 类型，
         * 如果有其它的类型，会被{@link retrofit2.Converter}转换，如后面会介绍的 使用{@link com.google.gson.Gson} 的 {@link retrofit2.converter.gson.GsonRequestBodyConverter}
         * 所以{@link MultipartBody.Part} 就不适用了,所以文件只能用<b> @Part MultipartBody.Part </b>
         */
        @POST("/posts")
        @Multipart
        Call<ResponseBody> testFileUpload2(@PartMap Map<String, RequestBody> args, @Part MultipartBody.Part file);
    }

    public void testGetData4(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mBaseUrl2)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TestService4 service = retrofit.create(TestService4.class);

        // 演示 @FormUrlEncoded 和 @Field
        Call<ResponseBody> call1 = service.testFormUrlEncoded1("1", "typicode");
        call1.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Logger.t("testetData3").i(response.body().string());
                }catch (Exception e){
                    Logger.e(e, "error");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Logger.e(t, "error");
            }
        });
        //printResponseBody(call1);

//        //===================================================
//
//        // 演示 @FormUrlEncoded 和 @FieldMap
//        // 实现的效果与上面想同
//        Map<String, Object> map = new HashMap<>();
//        map.put("username", "怪盗kidou");
//        map.put("age", 24);
//        Call<ResponseBody> call2 = service.testFormUrlEncoded2(map);
//        printResponseBody(call2);
//
//
//        //===================================================
//
//
//        MediaType textType = MediaType.parse("text/plain");
//        RequestBody name = RequestBody.create(textType, "怪盗kidou");
//        RequestBody age = RequestBody.create(textType, "24");
//        RequestBody file = RequestBody.create(MediaType.parse("application/octet-stream"), "这里是模拟文件的内容");
//
//        // 演示 @Multipart 和 @Part
//        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", "test.txt", file);
//        Call<ResponseBody> call3 = service.testFileUpload1(name, age, filePart);
//        printResponseBody(call3);
//
//        //===================================================
//        // 演示 @Multipart 和 @PartMap
//        // 实现和上面同样的效果
//        Map<String, RequestBody> fileUpload2Args = new HashMap<>();
//        fileUpload2Args.put("name", name);
//        fileUpload2Args.put("age", age);
//        //这里并不会被当成文件，因为没有文件名(包含在Content-Disposition请求头中)，但上面的 filePart 有
//        //fileUpload2Args.put("file", file);
//        Call<ResponseBody> call4 = service.testFileUpload2(fileUpload2Args, filePart); //单独处理文件
//        printResponseBody(call4);
    }


    /**
     * 为了方保证执行的顺序，所以方法是同步的
     */
    public static void printResponseBody(Call<ResponseBody> call) {
        try {
            System.out.println(call.execute().body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
