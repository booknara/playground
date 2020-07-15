package com.booknara.practice.rxjava;

import com.booknara.practice.rxjava.vo.Flight;
import com.booknara.practice.rxjava.vo.Passenger;
import com.booknara.practice.rxjava.vo.SmtpResponse;
import com.booknara.practice.rxjava.vo.Ticket;
import com.sun.tools.javac.util.Pair;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TravelController {
    ExecutorService pool = Executors.newFixedThreadPool(10);

    public Flight lookupFight(String flightNo) {
        return new Flight();
    }

    public Passenger findPassenger(long id) {
        return new Passenger();
    }

    @NotNull
    public Ticket bookTicket(Flight flight, Passenger passenger) {
        return new Ticket();
    }

    public SmtpResponse sendEmail(Ticket ticket) {
        return new SmtpResponse();
    }

    public void startBooking() {
        Flight flight = lookupFight("LOT 783");
        Passenger passenger = findPassenger(42);
        Ticket ticket = bookTicket(flight, passenger);
        sendEmail(ticket);
    }

    public void startBookingWithFailureDetection() {
        List<Ticket> tickets = new ArrayList<>();

        // Method 1
//        List<Ticket> failures = new ArrayList<>();
//        for (Ticket ticket: tickets) {
//            try {
//                sendEmail(ticket);
//            } catch (Exception e) {
//                failures.add(ticket);
//            }
//        }
        // Method 2
        List<Pair<Ticket, Future<SmtpResponse>>> tasks = tickets
                .stream()
                .map(ticket -> Pair.of(ticket, sendEmailAsync(ticket)))
                .collect(Collectors.toList());

        List<Ticket> failures = tasks
                .stream()
                .flatMap(pair -> {
                    try {
                        Future<SmtpResponse> future = pair.snd;
                        future.get(1, TimeUnit.SECONDS);
                        return Stream.empty();
                    } catch (Exception e) {
                        Ticket ticket = pair.fst;
                        return Stream.of(ticket);
                    }
                })
                .collect(Collectors.toList());
    }

    public Future<SmtpResponse> sendEmailAsync(Ticket ticket) {
        return pool.submit(() -> sendEmail(ticket));
    }

    public Observable<Flight> rxLookupFlight(String flightNo) {
        return Observable.defer(() ->
                Observable.just(lookupFight(flightNo)));
    }

    public Observable<Passenger> rxFindPassenger(long id) {
        return Observable.defer(() ->
                Observable.just(findPassenger(id)));
    }

    public Observable<Ticket> rxBookTicket(Flight flight, Passenger passenger) {
        return Observable.defer(() ->
                Observable.just(bookTicket(flight, passenger)));
    }

    public void rxStartBooking() {
        Observable<Flight> flight = rxLookupFlight("LOT 783");
        Observable<Passenger> passenger = rxFindPassenger(42);
//        Observable<Ticket> ticket = flight.zipWith(passenger, this::bookTicket)
//                .subscribeOn(Schedulers.io())
//                .timeout(100, TimeUnit.MILLISECONDS);
        Observable<Ticket> ticket = flight.zipWith(passenger, this::rxBookTicket)
                .flatMap(obs -> obs)
                .subscribeOn(Schedulers.io())
                .timeout(100, TimeUnit.MILLISECONDS);

        ticket.subscribe(this::sendEmail);
    }
}
