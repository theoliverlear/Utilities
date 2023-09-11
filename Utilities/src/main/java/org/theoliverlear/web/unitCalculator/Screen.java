package org.theoliverlear.web.unitCalculator;

public class Screen {
    double widthPx;
    double heightPx;
    public Screen(int widthPx, int heightPx) {
        this.widthPx = widthPx;
        this.heightPx = heightPx;
    }
    public double getWidthPx() {
        return this.widthPx;
    }
    public double getHeightPx() {
        return this.heightPx;
    }
}
