package com.orafaaraujo.rxrecyclerexample.presentation.main.repository;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by rafael on 27/12/16.
 */

public class UserLoader {

    public static Observable<Object> fetch() {
        return Observable
                .range(1, 8)
                .zipWith(Observable.interval(200, TimeUnit.MILLISECONDS),
                        (BiFunction<Integer, Long, Object>) (integer, aLong) ->
                                UserFactory.makeUser())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

    }
}
