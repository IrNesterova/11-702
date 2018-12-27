package ru.itis;

public class Main {

    public static void main(String[] args) {
        WaveAlg wa = new WaveAlg(12, 12);
        wa.findPath(1,1, 6,3);
        wa.trace();
    }
}
