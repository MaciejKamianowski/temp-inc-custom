package kamianowski.maciej.anomaly.storage.mapper;

import io.kontak.apps.event.Anomaly;
import kamianowski.maciej.anomaly.storage.model.AnomalyModel;
import org.mapstruct.Mapper;
        import org.mapstruct.Mapping;
        import org.mapstruct.factory.Mappers;

@Mapper
public interface AnomalyMapper {
    AnomalyMapper INSTANCE = Mappers.getMapper(AnomalyMapper.class);
    @Mapping(target = "id", ignore = true)
    AnomalyModel payloadToEntity(Anomaly payload);
    Anomaly entityToPayload(AnomalyModel entity);
}