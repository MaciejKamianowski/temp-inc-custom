package kamianowski.maciej.anomaly.storage.service;

import io.kontak.apps.event.Anomaly;
import kamianowski.maciej.anomaly.storage.mapper.AnomalyMapper;
import kamianowski.maciej.anomaly.storage.model.AnomalyModel;
import kamianowski.maciej.anomaly.storage.model.type.AnomalyType;
import kamianowski.maciej.anomaly.storage.repository.AnomalyInfoRepository;
import kamianowski.maciej.anomaly.storage.repository.AnomalyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnomalyServiceImpl implements AnomalyService{

    private final AnomalyRepository anomalyRepository;
    private final AnomalyInfoRepository anomalyInfoRepository;

    public AnomalyServiceImpl(AnomalyRepository anomalyRepository, AnomalyInfoRepository anomalyInfoRepository) {
        this.anomalyRepository = anomalyRepository;
        this.anomalyInfoRepository = anomalyInfoRepository;
    }

    @Override
    public void addAnomaly(Anomaly anomaly) {
        anomalyRepository.save(
                AnomalyMapper.INSTANCE.payloadToEntity(anomaly));
    }

    @Override
    public void deleteAnomaly(Anomaly anomaly) {
        anomalyRepository.delete(
                AnomalyMapper.INSTANCE.payloadToEntity(anomaly));
    }

    @Override
    public List<Anomaly> getAllAnomalies(AnomalyType type, String id) {
        List<AnomalyModel> anomalies = new ArrayList<>();
        if (AnomalyType.ROOM.equals(type)) {
            anomalies = anomalyRepository
                    .getAnomaliesBasedOnProvidedIdentifier(null, id);
        }
        if (AnomalyType.THERMOMETER.equals(type)) {
            anomalies = anomalyRepository
                    .getAnomaliesBasedOnProvidedIdentifier(id, null);
        }
        return anomalies
                .stream()
                .map(AnomalyMapper.INSTANCE::entityToPayload)
                .collect(Collectors.toList());
    }

    @Override
    public List<Long[]> getInfoAboutAmountAnomalies(long threshold) {
        return anomalyInfoRepository.getInfoAboutAmountAnomalies(threshold);
    }
}
