package m2m.repo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;

import m2m.repo.entities.SensorStatistics;

public class SensorsStatisticsRepoImpl implements SensorsStatisticsRepo
{
	@Autowired
	MongoTemplate template;
	
	@Override
	public SensorStatistics getSensorStatistics(int sensorId, long from, long to)
	{
		MatchOperation matchOp = Aggregation.match(new Criteria("id")
				.is(sensorId).andOperator(new Criteria("timestamp").gt(from)).lt(to));
		GroupOperation groupOp = Aggregation.group("id").avg("avgValue").as("avgValues")
				.min("avgValue").as("minValue").max("avgValue").as("maxValue");
		Aggregation pipe = Aggregation.newAggregation(matchOp, groupOp);
		AggregationResults<SensorStatistics> result = template.aggregate(pipe, 
				"sensors", SensorStatistics.class);
		return result.getUniqueMappedResult();
	}

}
