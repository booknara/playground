package com.booknara.practice.oop.generic;

import java.util.List;

public class ReaderPrinterComposite<T extends ReaderPrinter> implements ReaderPrinter {

    private final List<T> readerPrinters;

    public ReaderPrinterComposite(List<T> readerPrinters) {
        this.readerPrinters = readerPrinters;
    }

    @Override
    public void print() {
        for (Printer p: readerPrinters) {
            p.print();
        }
    }

    @Override
    public void read() {
        for (Reader r: readerPrinters) {
            r.read();
        }
    }
}
