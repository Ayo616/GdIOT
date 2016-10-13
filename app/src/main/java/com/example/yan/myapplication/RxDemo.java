package com.example.yan.myapplication;

import android.util.Log;

import com.orhanobut.logger.Logger;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.observers.Observers;

/**
 * Created by yan on 2016/10/8.
 */
public class RxDemo {

    Observer observers = new Observer<String>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(String o) {
            Log.d("i am watcher",o);
            Logger.d(o);
        }
    };

    Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
        @Override
        public void call(Subscriber<? super String> subscriber) {
            subscriber.onNext("hi,I am a observable,I am doing something here");
            Log.d("被观察","beiguancha");
            subscriber.onCompleted();
        }
    });


    public void test(){
        observable.subscribe(observers);


        new Func1<String, Integer>() {
            @Override
            public Integer call(String s) {
                return null;
            }
        };


    }


}
