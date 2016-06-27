package com.weather.app.repository;

import com.weather.app.model.Monitor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by abdulaziz on 27/06/2016.
 */
@Repository
public interface MonitorRepository extends MongoRepository<Monitor, String> {


}

