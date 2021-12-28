package m2m.service;

import java.time.LocalDateTime;
import java.util.List;

import m2m.repo.entities.SensorStatistics;

public interface IBackOffice
{
	List<Integer> getIdBigValues(LocalDateTime from, LocalDateTime to, int sensorValue);
//	лист сенсор id, показатели которых за указанный промежуток времени был выше чем sensorValue
	
	List<Integer> getIdSmallValues(LocalDateTime from, LocalDateTime to, int sensorValue); 
	
	List<LocalDateTime> getDatesBigValues(int sensorId, LocalDateTime from, 
			LocalDateTime to, int sensorValue);
//	лист дат, когда поступали завышенные показатели сенсора с конкретным id
	
	List<LocalDateTime> getDatesSmallValues(int sensorId, LocalDateTime from, 
			LocalDateTime to, int sensorValue);
	
	SensorStatistics getSensorStatistics(int sensorId, LocalDateTime from, 
			LocalDateTime to);
}
