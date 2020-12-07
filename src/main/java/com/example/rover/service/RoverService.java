package com.example.rover.service;

import com.example.rover.model.Position;

public interface RoverService {

    public void setCoordinates(int x, int y);

    public void setInitialPosition(Position position);

    public Position executeInstructions(String instructions);

}
