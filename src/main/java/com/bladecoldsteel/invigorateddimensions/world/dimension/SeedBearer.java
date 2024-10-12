package com.bladecoldsteel.invigorateddimensions.world.dimension;

public class SeedBearer {

    private static long seed = 0;

    public static void putInSeed(long seedInput) {
        seed = seedInput;
        System.out.println("Seed stored: " + seed);
    }

    public static long giveMeSeed() {
        System.out.println("Seed retrieved: " + seed);
        return seed;
    }
}
