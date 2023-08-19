package kamianowski.maciej.analytics.rest;

import io.kontak.apps.event.Anomaly;
import kamianowski.maciej.analytics.payload.AnomalyPayload;
import kamianowski.maciej.anomaly.storage.model.type.AnomalyType;
import kamianowski.maciej.anomaly.storage.service.AnomalyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/analytics")
public class TemperatureAnalyticsController {

    private final AnomalyService anomalyService;
    public TemperatureAnalyticsController(AnomalyService anomalyService) {
        this.anomalyService = anomalyService;
    }
    @PostMapping("/anomalies/info")
    public ResponseEntity<List<Long[]>> getAnomaliesInfo(@RequestBody long threshold) {
        return new ResponseEntity<>(
                anomalyService.getInfoAboutAmountAnomalies(threshold),
                HttpStatus.OK);
    }

    @PostMapping("/anomalies")
    public ResponseEntity<List<Anomaly>> getAnomalies(@RequestBody AnomalyPayload payload) {
        AnomalyType type = AnomalyType.valueOf(payload.anomalyType());
        return new ResponseEntity<>(
                anomalyService.getAllAnomalies(type, payload.id()),
                HttpStatus.OK);
    }
}
