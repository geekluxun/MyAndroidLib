package com.geekluxun.www.myandroidlib.test.thirdPartLibrary;

import com.orhanobut.logger.Logger;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * Created by geekluxun on 2016/11/18.
 */
public class RxJavaTest {

    public RxJavaTest(){
        //test1();
        //test2();
        test4();
    }

    /**
     *
     */
    public void test1(){
        Observable.create(new Observable.OnSubscribe<String>() { //创建Obserable
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("hello");
                subscriber.onNext("geek");
                subscriber.onNext("luxun");
                subscriber.onCompleted();
            }
        }).subscribe(new Subscriber<String>() { //订阅
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Logger.i(s);
            }
        });
    }

    /**
     *
     */
    public void test2(){
        String[] name = {"luxun", "mark", "geek"};
        Observable.from(name).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Logger.i(s);
            }
        });
    }

    /**
     *
     */
    public void test3(){
        Observable.just("luxun","mark","geek").subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Logger.i(s);
            }
        });
    }

    /**
     *
     */
    public void test4(){
        String[] name = {"luxun", "mark", "geek"};
        Logger.init("test4");
        Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                Logger.i(s);
            }
        };

        Action1<Throwable> onErrorAction = new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                //异常处理逻辑
                Logger.e(throwable,"geekluxun");
            }
        };

        Action0 onCompletedAction = new Action0() {
            @Override
            public void call() {
                Logger.i("completed");
            }
        };

        Observable observable = Observable.from(name);

        observable.subscribe(onNextAction);
        observable.subscribe(onNextAction,onErrorAction);
        observable.subscribe(onNextAction,onErrorAction, onCompletedAction);
    }

}
