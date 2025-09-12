package Measure;

public class Convertor {

    double m;

    public Convertor(double m) {
        this.m = m;
    }

    public double mmTocm(double m) {
        return m / 10;
    }

    public double cmTom(double m) {
        return m / 100;
    }

    public double mTokm(double m) {
        return m / 1000;
    }

}