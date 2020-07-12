package com.booknara.practice.rxjava;

import io.reactivex.Observable;

public class ObservableCreate {
    /**
     * Observable.just() <- Observable.create
     */
    public static <T>Observable<T> just(T x) {
        return Observable.create(subscriber -> {
            subscriber.onNext(x);
            subscriber.onComplete();
        });
    }

    /**
     * Observable.never() <- Observable.create
     */
    public static Observable never() {
        return Observable.create(subscriber -> {

        });
    }

    /**
     * Observable.empty() <- Observable.create
     */
    public static Observable empty() {
        return Observable.create(subscriber -> {
            subscriber.onComplete();
        });
    }

    /**
     * Observable.range() <- Observable.create
     */
    public static Observable range(int x, int n) {
        return Observable.create(subscriber -> {
            for (int i = 0; i < n; i++) {
                subscriber.onNext(x + i);
            }

            subscriber.onComplete();
        });
    }
}
