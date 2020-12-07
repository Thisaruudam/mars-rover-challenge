package com.example.rover.service.impl;

import com.example.rover.model.Position;
import com.example.rover.service.RoverService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class RoverServiceImplTest {

    private Position position;

    @Autowired
    private RoverService roverService;

    @Test
    void executeInstructionsRover1() {


        Position positionTest;

        roverService.setCoordinates(5,5);

        position = new Position(1,2,'N');
        roverService.setInitialPosition(position);
        positionTest = roverService.executeInstructions("LMLMLMLMM");
        assertEquals(1, positionTest.getX());
        assertEquals(3, positionTest.getY());
        assertEquals('N', positionTest.getOrientation());

        position = new Position(3,3,'E');
        roverService.setInitialPosition(position);
        positionTest = roverService.executeInstructions("MMRMMRMRRM");
        assertEquals(5,positionTest.getX());
        assertEquals(1,positionTest.getY());
        assertEquals('E',positionTest.getOrientation());

    }

    @Test
    void executeInstructionsRover2() {

        Position positionTest;

        roverService.setCoordinates(5,5);

        position = new Position(3,3,'E');
        roverService.setInitialPosition(position);
        positionTest = roverService.executeInstructions("MMRMMRMRRM");
        assertEquals(5,positionTest.getX());
        assertEquals(1,positionTest.getY());
        assertEquals('E',positionTest.getOrientation());

    }

}
