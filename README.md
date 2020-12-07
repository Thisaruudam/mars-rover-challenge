# Project Title

THE MARS ROVER CHALLENGE

A squad of robotic rovers are to be landed by NASA on a plateau on Mars.
This plateau, which is curiously rectangular, must be navigated by the rovers so that their onboard cameras can get a complete view of the surrounding terrain to send back to Earth.
A rover’s position and location are represented by a combination of x and y co-ordinates and a letter
representing one of the four cardinal compass points. The plateau is divided up into a grid to simplify
navigation. An example position might be 0, 0, N, which means the rover is in the bottom left corner
and facing North.
In order to control a rover, NASA sends a simple string of letters. The possible letters are ‘L’, ‘R’ and ‘M’.
‘L’ and ‘R’ makes the rover spin 90 degrees left or right respectively, without moving from its current
spot.
‘M’ means move forward one grid point, and maintains the same heading.
Assume that the square directly North from (x, y) is (x, y+1).

####INPUT :
The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are
assumed to be 0,0.
The rest of the input is information pertaining to the rovers that have been deployed. Each rover has
two lines of input. The first line gives the rover’s position, and the second line is a series of instructions
telling the rover how to explore the plateau.
The position is made up of two integers and a letter separated by spaces, corresponding to the x and
y co-ordinates and the rover’s orientation.
Each rover will be finished sequentially, which means that the second rover won’t start to move until
the first one has finished moving.

#####OUTPUT :
The output for each rover should be its final co-ordinates and heading.

####INPUT AND OUTPUT

###### Test Inputs:
5 5 <br>
1 2 N <br>
LMLMLMLMM <br>
3 3 E <br>
MMRMMRMRRM <br>

###### Expected Outputs:
1 3 N <br> 
5 1 E
## About The Project
https://ti.arc.nasa.gov/m/pub-archive/858h/0858%20(Mak).pdf

First I studied above pdf file to get an idea about how this Mars rover works. Then I decided to use spring boot as this is ideally same as web service.

## Getting Started

Clone this repository and get start using below commands.

```
./mvnw spring-boot:run
```

### API Calls

1. Set Coordinates
   ```
   POST http://localhost:8080/api/v1/rover/coordinates?coordinates=5 5
   ```
2. Set Initial Rover Position
   ```
   POST http://localhost:8080/api/v1/rover/initial-pos?initialPosition=1 2 N
   ```
3. Give the instructions
   ```
   POST http://localhost:8080/api/v1/rover/execute?instructions=LMLMLMLMM
   ```
