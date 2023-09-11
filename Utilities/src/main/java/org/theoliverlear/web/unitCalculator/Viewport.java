package org.theoliverlear.web.unitCalculator;

public abstract class Viewport {
    Screen screen;
    double units;
    double px;
    public Viewport(Screen screen, double units) {
        this.screen = screen;
        this.units = units;
    }
    public abstract double calculatePx();
    public abstract void updatePx();
    //---------------------------Getters-and-Setters--------------------------
    public Screen getScreen() {
        return this.screen;
    }
    public double getUnits() {
        return this.units;
    }
    public double getPx() {
        return this.px;
    }
    public void setScreen(Screen screen) {
        this.screen = screen;
    }
    public void setUnits(double units) {
        this.units = units;
    }
    public void setPx(double px) {
        this.px = px;
    }
}
