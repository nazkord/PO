package com.nazkord;

public class Main {

    public static void main(String[] args) {
	// write your code here
        RoundHole roundHole = new RoundHole(10);
        RoundPeg roundPeg = new RoundPeg(10);
        System.out.println(roundHole.fits(roundPeg));

        SquarePegAdapter squarePegAdapter = new SquarePegAdapter(new SquarePeg(10));
        System.out.println(roundHole.fits(squarePegAdapter));

        squarePegAdapter.setSquarePeg(new SquarePeg(20));
        System.out.println(roundHole.fits(squarePegAdapter));
    }
}
