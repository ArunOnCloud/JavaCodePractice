package lld.elevator;

import lld.elevator.buttons.Button;

public class Building {

    private String id;
    int numberOfFloor;




    private ElevatorManagementSystem elevatorManagementSystem;

    private static  class Floor{
        int floorNumber;
        Button button;
        void pressButton(){
            button.pressButton();
        }


    }


}

