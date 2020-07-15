package com.booknara.practice.rxjava;

import com.booknara.practice.rxjava.vo.Person;
import io.reactivex.Observable;
import io.reactivex.Single;

import java.util.ArrayList;
import java.util.List;

public class PersonDao {
    public List<Person> getPeople(Observable<Person> people) {
        Single<List<Person>> peopleSingle = people.toList();
        return peopleSingle.blockingGet();
    }

    // lazy call, asynchronous / reactive style
    public Observable<Person> listPeople() {
        return Observable.defer(() ->
                Observable.fromIterable(query("SELECT * FROM PEOPLE")));
    }

    // eager call, asynchronous / reactive style
//    public Observable<Person> listPeople() {
//        List<Person> people = query("SELECT * FROM PEOPLE");
//        return Observable.fromIterable(people);
//    }

    // synchronous
//    public List<Person> listPeople() {
//        return query("SELECT * FROM PEOPLE");
//    }

    private List<Person> query(String sql) {
        // some db operation
        return new ArrayList<>();
    }
}
