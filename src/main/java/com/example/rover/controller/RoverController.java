package com.example.rover.controller;

import com.example.rover.model.Position;
import com.example.rover.service.RoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/rover")
public class RoverController {

    @Autowired
    private RoverService roverService;

    @PostMapping(value = "/coordinates")
    public void setCoordinates(@RequestParam String coordinates) {
        coordinates.trim();
        roverService.setCoordinates(Integer.parseInt(coordinates.split(" ")[0]),
                Integer.parseInt(coordinates.split(" ")[1]));
    }

    @PostMapping(value = "/initial-pos")
    public void setInitialPosition(@RequestParam String initialPosition) {
        Position position = new Position();
        initialPosition.trim();

        position.setX(Integer.parseInt(initialPosition.split(" ")[0]));
        position.setY(Integer.parseInt(initialPosition.split(" ")[1]));
        position.setOrientation(initialPosition.split(" ")[2].charAt(0));

        roverService.setInitialPosition(position);
    }

    @PostMapping(value = "/execute", produces = MediaType.APPLICATION_JSON_VALUE)
    public Position executeInstructions(@RequestParam String instructions) {
        return roverService.executeInstructions(instructions);
    }

}
