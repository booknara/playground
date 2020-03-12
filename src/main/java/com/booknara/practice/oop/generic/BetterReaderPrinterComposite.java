package com.booknara.practice.oop.generic;

import java.util.List;

/**
 * Intersectional Generic Type
 * https://towardsdatascience.com/4-amazing-techniques-for-writing-better-java-6ad46b3c4a47
 * extends multiple interface or abstract class
 */
public class BetterReaderPrinterComposite<T extends Reader & Printer & Modifier>
        implements Reader, Printer, Modifier {

    private final List<T> readerPrinters;

    public BetterReaderPrinterComposite(List<T> readerPrinters) {
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

    @Override
    public void modify() {
        for (Modifier m: readerPrinters) {
            m.modify();
        }
    }
}
