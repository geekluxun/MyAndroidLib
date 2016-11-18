package utils;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;

/**
 * Created by geekluxun on 2016/9/13.
 */
public class DownloadManagerUtil {

    public DownloadManagerUtil(Context context){

        DownloadManager manager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        DownloadManager.Request request = null;
        //下载请求
        try {
            //request = new DownloadManager.Request(Uri.parse("http://172.16.1.247:8080/luxun/new.apatch"));
            request = new DownloadManager.Request(Uri.parse("http://www.gujinsuo.com.cn/ipa/gujinsuo.apk"));

        }catch (Exception e){
            e.printStackTrace();
        }

        //设置允许使用的网络类型

        //禁止发出通知，既后台下载
        //request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_HIDDEN);
        //下载完成文件存放的位置

        //将下载请求放入队列中,开始下载
        try {
            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE | DownloadManager.Request.NETWORK_WIFI);
            request.setDestinationInExternalPublicDir("/luxun", "gujinsuo.apk");
            manager.enqueue(request);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
