package com.orafaaraujo.rxrecyclerexample.presentation.main.repository;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

/**
 * Created by rafael on 27/12/16.
 */

public class UserLoader {

    public static Observable<Object> fetch() {
        return Observable
                .range(1, 8)
                .zipWith(Observable.interval(200, TimeUnit.MILLISECONDS),
                        (Func2<Integer, Long, Object>) (integer, aLong) -> UserFactory.makeUser())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

    }
}
