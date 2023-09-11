package org.theoliverlear.web.unitCalculator;

public class Vw extends Viewport {
    Screen screen;
    double units;
    double px;
    public Vw(Screen screen, double units) {
        super(screen, units);
        this.screen = screen;
        this.units = units;
        this.px = this.calculatePx();
        super.setPx(this.px);
    }
    @Override
    public double calculatePx() {
        return screen.getWidthPx() * (this.units / 100);
    }
    @Override
    public void updatePx() {
        this.px = this.calculatePx();
    }
}
