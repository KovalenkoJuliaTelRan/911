package m2m.repo.entities;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sensors")
public class SensorDoc
{
	@Indexed
	public long timestamp;
	@Indexed
	public int id;
	public int avgValue;
	
	public long getTimestamp()
	{
		return timestamp;
	}

	public int getId()
	{
		return id;
	}

	public int getAvgValue()
	{
		return avgValue;
	}
	
	
}
