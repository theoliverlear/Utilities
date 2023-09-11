package org.theoliverlear.web.unitCalculator;

public class Vh extends Viewport {
    Screen screen;
    double units;
    double px;
    public Vh(Screen screen, double units) {
        super(screen, units);
        this.px = this.calculatePx();
    }
    @Override
    public double calculatePx() {
        return this.screen.getHeightPx() * (this.units / 100);
    }
    @Override
    public void updatePx() {
        this.px = this.calculatePx();
    }
}
