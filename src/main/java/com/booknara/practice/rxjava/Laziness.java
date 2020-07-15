package com.booknara.practice.rxjava;

import com.booknara.practice.rxjava.vo.Book;
import com.booknara.practice.rxjava.vo.Person;
import io.reactivex.Observable;

public class Laziness {
    public void bestBookFor(Person person) {
//        Observable<Book> recommend = recommend(person);
//        Observable<Book> bestSeller = bestSeller();
//        Observable<Book> book = recommend.onErrorResumeNext(bestSeller);
//
//        Observable<String> title = book.map(Book::getTitle);
//        title.subscribe(this::display);
        recommend(person)
                .onErrorResumeNext(bestSeller())
                .map(Book::getTitle)
                .subscribe(this::display);
    }

    public Observable<Book> recommend(Person person) {
        return Observable.just(new Book());
    }

    public Observable<Book> bestSeller() {
        return Observable.defer(() -> Observable.just(new Book()));
    }

    public void bestBookFor1(Person person) {
        Book book;
        try {
            book = recommend1(person);
        } catch (Exception e) {
            book = bestSeller1();
        }

        display(book.getTitle());
    }

    public Book recommend1(Person person) {
        Book book = new Book();
        return book;
    }

    public Book bestSeller1() {
        Book book = new Book();
        return book;
    }

    public void display(String title) {
        System.out.println(title);
    }
}
