package io.kontak.apps.anomaly.detector.algorithm;

import java.util.ArrayList;
import java.util.List;

public class AnomalyDetectionAlgorithmTwo {

    public static List<Double> detectAnomalies(List<Double> measurements, List<Long> timestamps) {
        List<Double> anomalies = new ArrayList<>();

        double sum = 0.0;
        for (Double measurement : measurements) {
            sum += measurement;
        }

        double average = sum / measurements.size();

        for (Double measurement : measurements) {
            if (Math.abs(measurement - average) > 5.0) {
                anomalies.add(measurement);
            }
        }

        return anomalies;
    }
}