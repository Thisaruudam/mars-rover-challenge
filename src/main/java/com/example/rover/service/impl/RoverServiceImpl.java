package com.example.rover.service.impl;

import com.example.rover.exception.InvalidInstructionException;
import com.example.rover.exception.PositionOutOfPlateauException;
import com.example.rover.model.Position;
import com.example.rover.service.RoverService;
import org.springframework.stereotype.Service;

@Service
public class RoverServiceImpl implements RoverService {

    private int x;
    private int y;
    private Position position;

    @Override
    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void setInitialPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position executeInstructions(String ins) {

        Position position = new Position();

        char[] instructions = ins.toCharArray();

        for (int i = 0; i < instructions.length; i++) {
            try {
                execute(instructions[i]);
            } catch (PositionOutOfPlateauException | InvalidInstructionException e) {
                position.setX(0);
                position.setY(0);
                position.setOrientation('N');
                e.printStackTrace();
            }
        }

        position.setX(this.position.getX());
        position.setY(this.position.getY());
        position.setOrientation(this.position.getOrientation());

        return position;
    }

    public void execute(char instruction) throws PositionOutOfPlateauException,InvalidInstructionException {

        char defaultOrientation = position.getOrientation();

        if(instruction == 'L') {
            switch (defaultOrientation) {
                case 'N' :
                    position.setOrientation('W');
                    break;
                case 'W' :
                    position.setOrientation('S');
                    break;
                case 'S' :
                    position.setOrientation('E');
                    break;
                case 'E' :
                    position.setOrientation('N');
                    break;
            }
        } else if(instruction == 'R'){
            switch (defaultOrientation) {
                case 'N' :
                    position.setOrientation('E');
                    break;
                case 'E' :
                    position.setOrientation('S');
                    break;
                case 'S' :
                    position.setOrientation('W');
                    break;
                case 'W' :
                    position.setOrientation('N');
                    break;
            }
        } else if(instruction == 'M') {
            switch (defaultOrientation) {
                case 'N' :
                    if (y >= position.getY() + 1) {
                        position.setY(position.getY() + 1);
                    } else {
                        throw new PositionOutOfPlateauException("Position is out of plateau");
                    }
                    break;
                case 'E' :
                    if (x >= position.getX() + 1) {
                        position.setX(position.getX() + 1);
                    } else {
                        throw new PositionOutOfPlateauException("Position is out of plateau");
                    }
                    break;
                case 'S' :
                    if (0 <= position.getY() - 1) {
                        position.setY(position.getY() - 1);
                    } else {
                        throw new PositionOutOfPlateauException("Position is out of plateau");
                    }
                    break;
                case 'W' :
                    if (0 <= position.getX() - 1) {
                        position.setX(position.getX() - 1);
                    } else {
                        throw new PositionOutOfPlateauException("Position is out of plateau");
                    }
                    break;
            }
        } else {
            throw new InvalidInstructionException("Invalid Instruction");
        }
    }

}
