package m2m.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import m2m.repo.entities.SensorStatistics;
import m2m.service.IBackOffice;

@RestController
public class BackOfficeController
{
	@Autowired
	IBackOffice backOffice;

	@GetMapping("/sensor/statistics")
	SensorStatistics getStatistics(int sensorId, String fromDateTime, String toDateTime)
	{
		return backOffice.getSensorStatistics(sensorId, 
				LocalDateTime.parse(fromDateTime), LocalDateTime.parse(toDateTime));
	}

	@GetMapping("/sensor/dates")
	List<LocalDateTime> getDatesBigValues(int sensorId, int sensorValue, String fromDateTime, String toDateTime)
	{
		return backOffice.getDatesBigValues(sensorId, LocalDateTime.parse(fromDateTime),
		        LocalDateTime.parse(toDateTime), sensorValue);
	}
}
