package kamianowski.maciej.anomaly.storage.repository;

import kamianowski.maciej.anomaly.storage.model.AnomalyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnomalyRepository extends JpaRepository<AnomalyModel, Long> {

    @Query(
            value = "SELECT * FROM _anomalies a\n" +
                     "WHERE ( a.thermometerId = :thermometerId )" +
                    "OR ( a.roomId = :roomId )",
            nativeQuery = true)
    List<AnomalyModel> getAnomaliesBasedOnProvidedIdentifier(String thermometerId, String roomId);

}
