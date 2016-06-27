package com.weather.app.api;

import com.weather.app.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by abdulaziz on 27/06/2016.
 */
@RestController
@RequestMapping(value="/monitor")
public class MonitorController {

    @Autowired
    MonitorService monitorService;

    @RequestMapping(value="/data", method= RequestMethod.GET)
    public List home() {

        return monitorService.getData();
    }
}
