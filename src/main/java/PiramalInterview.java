import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class PiramalInterview {


    /*

    Design an elevator system of apartment. Consider there are N lifts and F floors.

    Design the classes which will be used
    there should be provision to initialize each lift at certain level.
    Optimization should be made to make the user wait as less as possible.
    When up or down is pressed user should be displayed a lift number.
    Elaborate all assumptions being made and test your code for exhaustive set of use cases.

     1 building   n elevators, f floor
     0 ground ,1,2,3 no negatives

     One button for all lifts
     Each floor will be up and down button

     Lift compartment f numbers for the floors and open and close button



     */

    public static void main(String[] args) {

    }
}

class LiftManagementSystem{

    Map<Integer,Lift> lift=new HashMap<>();

    LiftManagementSystem(){

    }

//    int getEndFloor(){
//
//    }


    void pressButton(int floorNumber,int directions){

    }

    void assignLift(int floorNumber){
        /*
           getLiftBasedon direction

           filter lifts which are not full and current floor is less than equal givenFloorNumber(

           assignTheFloor to lift

         */

    }
//    List<Lift> getLiftByDirection(){
//
//    }







}

class Lift{
    //List<Button>
    int id;
    LiftStates liftStates;
    int startFloor;
    int endFloor;

    int maxCapacity;

    int currentCapacity;


    LiftManagementSystem liftManagementSystem;

    Queue<Integer> floorStops;
   // void buttonPressed(int)
    Map<Integer,Button> buttton;

    LiftStates getLiftStates(){
        return liftStates;
    }


    void startLift(int floor){

    }
    void addStopAtFloor(int floor){

    }






}
enum LiftStates{
    GOING_UP,
    GOING_DOWN,
    STATIONATIONARY,
    INSERVICE;
}
enum  ButtonDirections{
    Up,
    Down;
}
interface Button{

}

class FloorButtonUp{

    LiftManagementSystem liftManagementSystem;

}

