package m2m.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import m2m.repo.entities.SensorDoc;

public interface SensorRepo extends MongoRepository<SensorDoc, Object>, 
SensorsStatisticsRepo
{

	List<SensorDoc> findBySensorIdAndTimestampBetweenAndAvgValueGreaterThan(int sensorId, long l,
			long m, int sensorValue);

}
