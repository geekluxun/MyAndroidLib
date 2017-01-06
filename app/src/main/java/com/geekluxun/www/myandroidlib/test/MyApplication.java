package com.geekluxun.www.myandroidlib.test;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.geekluxun.www.myandroidlib.test.thirdPartLibrary.greendaoTest.DaoMaster;
import com.geekluxun.www.myandroidlib.test.thirdPartLibrary.greendaoTest.DaoSession;
import com.geekluxun.www.weex.WeexInit;

import org.greenrobot.greendao.database.Database;


/**
 * Created by geekluxun on 2016/8/29.
 */
public class MyApplication extends Application {
    /** A flag to show how easily you can switch from standard SQLite to the encrypted SQLCipher. */
    public static final boolean ENCRYPTED = true;
    //public final Context mAppContext = getApplicationContext();
    private DaoSession daoSession;

    public SQLiteDatabase db;
    public DaoMaster.DevOpenHelper helper;
    public DaoMaster daoMaster;

    public static Context mAppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext = getApplicationContext();
        //AutoLayoutConifg.getInstance().useDeviceSize();
        //BigDecimalTest bigDecimalTest = new BigDecimalTest();
        //bigDecimalTest.BigDecimalTest1();
        //Fresco.initialize(getApplicationContext());
        //setupDatabase();

        WeexInit.Init(this,false, "debug_server");
    }

    public static Context getContext(){
        return mAppContext;
    }


    private void setupDatabase() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, ENCRYPTED ? "notes-db-encrypted" : "notes-db");
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

}



