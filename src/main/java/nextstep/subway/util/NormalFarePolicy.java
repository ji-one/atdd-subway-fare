package nextstep.subway.util;

public class NormalFarePolicy implements FarePolicy {

    private static final int BASE_FARE = 1_250;
    private static final int BASE_DISTANCE = 10;
    private static final int FURTHER_DISTANCE = 50;

    @Override
    public int calculateFare(int distance) {
        if (distance <= BASE_DISTANCE) {
            return BASE_FARE;
        }

        if (distance <= FURTHER_DISTANCE) {
            return BASE_FARE + calculate10KMOverFare(distance);
        }

        return BASE_FARE + calculate10KMOverFare(distance) + calculate50KMOverFare(distance);
    }

    private static int calculate10KMOverFare(int distance) {
        if (distance <= BASE_DISTANCE) {
            return 0;
        }

        if (distance >= FURTHER_DISTANCE) {
            return 800;
        }

        return (int) ((Math.ceil((distance - BASE_DISTANCE) / 5) + 1) * 100);
    }

    private static int calculate50KMOverFare(int distance) {
        if (distance < FURTHER_DISTANCE) {
            return 0;
        }
        return (int) ((Math.ceil((distance - FURTHER_DISTANCE) / 8) + 1) * 100);
    }
}