package io.kontak.apps.anomaly.detector.algorithm;

import java.util.ArrayList;
import java.util.List;

public class AnomalyDetectionAlgorithmOne {

    private AnomalyDetectionAlgorithmOne () {}
    public static List<Double> detectAnomalies(List<Double> measurements) {
        List<Double> anomalies = new ArrayList<>();

        for (int i = 0; i <= measurements.size() - 10; i++) {
            double sum = 0.0;
            for (int j = i; j < i + 10; j++) {
                sum += measurements.get(j);
            }
            double average = (sum - measurements.get(i)) / 9.0;

            if (measurements.get(i + 9) > average + 5.0) {
                anomalies.add(measurements.get(i + 9));
            }
        }

        return anomalies;
    }
}