package com.weather.app.service;

import com.weather.app.model.Monitor;
import com.weather.app.repository.MonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by abdulaziz on 27/06/2016.
 */
@Service
public class MonitorServiceImpl  implements MonitorService{

    @Autowired
    MonitorRepository monitorRepository;


    @Override
    public List<Monitor> getData()
    {

        return monitorRepository.findAll();
    }
}
