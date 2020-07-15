package com.booknara.practice.rxjava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ObservableJust {
    public static void main(String[] args) {
        Observable.just("x", "y", "z")
                .subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe() ");
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext() " + s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
        System.out.println("last line");
    }
}
