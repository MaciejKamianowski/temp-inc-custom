package kamianowski.maciej.anomaly.storage.service;

import io.kontak.apps.event.Anomaly;
import kamianowski.maciej.anomaly.storage.model.type.AnomalyType;

import java.util.List;

public interface AnomalyService {

    void addAnomaly(Anomaly anomaly);

    void deleteAnomaly(Anomaly anomaly);

    List<Anomaly> getAllAnomalies(AnomalyType type, String id);

    List<Long[]> getInfoAboutAmountAnomalies(long threshold);
}
