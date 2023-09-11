package org.theoliverlear.web.unitCalculator;

public class UnitCalculator {
    public static void main(String[] args) {
        Screen screen = new Screen(1000, 1000);
        Vw vw = new Vw(screen, 2);
        System.out.println(screen.getWidthPx());
        System.out.println("Vw: " + vw.getPx());
    }
}