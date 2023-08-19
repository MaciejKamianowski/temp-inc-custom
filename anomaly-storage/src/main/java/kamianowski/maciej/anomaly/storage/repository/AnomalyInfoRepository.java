package kamianowski.maciej.anomaly.storage.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnomalyInfoRepository {
    private final EntityManager entityManager;

    public AnomalyInfoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Long[]> getInfoAboutAmountAnomalies(long threshold) {
        Query query = entityManager.createNativeQuery("SELECT a.thermometer_id, COUNT(*) AS anomaly_count\n" +
                "FROM _anomalies a\n" +
                "WHERE anomaly_count > :threshold\n" +
                "GROUP BY thermometer_id;");
        return query.getResultList();
    }
}
