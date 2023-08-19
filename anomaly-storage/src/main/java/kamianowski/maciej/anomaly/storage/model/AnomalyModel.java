package kamianowski.maciej.anomaly.storage.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_anomalies")
public class AnomalyModel {
    @Id
    @SequenceGenerator(
            name = "anomalies_sequence",
            sequenceName = "anomalies_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "anomalies_sequence"
    )
    private Long id;

    String roomId;
    String thermometerId;
    Instant timestamp;
}
