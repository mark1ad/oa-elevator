# oa-elevator
Coding Project for Outside Analytics Interview

## Project

Provide code that simulates an elevator. You are free to use any language.
- Upload the completed project to GitHub for discussion during interview.
- Document all assumptions and any features that weren’t implemented.
- The result should be an executable, or script, that can be run with the following inputs and generate the following outputs.
  - Inputs: [list of floors to visit] (e.g. elevator start=12 floor=2,9,1,32)
  - Outputs: [total travel time, floors visited in order] (e.g. 560 12,2,9,1,32)
  - Program Constants: Single floor travel time: 10
 
## Assumptions

- Floor numbers can be negative with the first floor being 0

## To Run

```
cd src
java Elevator.java -start n -floors x,y,...
```
