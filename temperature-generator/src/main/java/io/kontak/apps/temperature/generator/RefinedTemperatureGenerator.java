package io.kontak.apps.temperature.generator;

import io.kontak.apps.event.TemperatureReading;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RefinedTemperatureGenerator implements TemperatureGenerator{

    private final Random random = new Random();
    private final String[] roomIds = {"idRoom1", "idRoom2", "idRoom3"};
    private final String[] thermometerIds = {"idThermometer1", "idThermometer2", "idThermometer3"};
    private final Instant startTimestamp = Instant.now();

    private static final int RANDOM_READINGS_LIST_SIZE = 100;
    @Override
    public List<TemperatureReading> generate() {
        List<TemperatureReading> readings = new ArrayList<>();
        for (int i = 0; i < RANDOM_READINGS_LIST_SIZE; i++) {
            readings.add(
                    new TemperatureReading(
                            getRandomTemperature(),
                            getRandomElement(roomIds),
                            getRandomElement(thermometerIds),
                            getTimestamp()));
        }
        return readings;
    }

    private double getRandomTemperature() {
        return 10 + random.nextDouble() * 30; // Generate temperature between 10 and 30 degrees Celsius
    }

    private Instant getTimestamp() {
        long timestampOffset = random.nextInt(3600); // Generate timestamp within the last hour
        return startTimestamp.minusSeconds(timestampOffset);
    }

    private <T> T getRandomElement(T[] array) {
        return array[random.nextInt(array.length)];
    }
}
