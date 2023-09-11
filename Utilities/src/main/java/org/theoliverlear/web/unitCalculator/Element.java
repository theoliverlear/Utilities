package org.theoliverlear.web.unitCalculator;

public class Element{
    String name;
    double widthPx;
    double heightPx;
    public Element(double widthPx, double heightPx) {

    }
    public double getEm(double px) {
        return px / this.widthPx;
    }
}
