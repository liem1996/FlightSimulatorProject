<img src="https://upload.wikimedia.org/wikipedia/en/9/9b/FlightGear_Flight_Sim_Bo_105_over_Sint_Marteen.png"
width="350" height="200">

# Flight Gear Simulator Project ✈️
This is our final project in Advanced software development course as part of our B.Sc.
Computer Science studies that was taught by Dr. Eliahu-khalastchi. The project present visual analysis of flight control 
details and shows our abilities to work with different programming langueges and work with flight gear simulator.

# Main idea :bulb:
We would like to view a given CSV file that contains time series data and important details of a flight, and project them as a video on the screen to the user.
To do this we will first connect to the FlightGear simulator and show all of the given information translated to a real flight.
We will broadcast the flight data to him and he will present them. We want the ability to transmit the data at a real, fast, or slow pace or user-defined. We also want some kind of band
a scroll that can be used to run the flight back or forth and of course the simulator will respond immediately as if it were a video.

# Abilities & Programming languages :desktop_computer:	
- The application is written in Java and the GUI is written in JavaFX.
- The application's architecture is MVVM.
- Each element in the GUI is indepentent and can be removed or added by an XML tag, and also have generic definition and interface options using data binding.
- The application transmit (via TCP communication) the data of the current time point to the flight simulator
to project the current status.
- There are 3 main anomalies detection's algorithms: Z-Score, Simple Anomaly Detetor and Hybrid. They use as a plug-in of the application.

- The GUI is built of:
1. Virtual joystick that shows the position of the rudders (Elevators & Aileron), directional stabilizer (Rudder)
and Throttle.
2. Clock board - a panel that shows clocks, direction, speed, roll, pitch and yaw.
3. List of columns from the CSV file that shows the features we can choose.
4. Canvas that presents the graph for detecting the anomalies, according to the algorithm defined in the application's settings.

Our GUI:

<img src="https://i.postimg.cc/wvNZ5kT0/GUI.jpg"
width="580" height="350">

# Milestones & Progress :hammer_and_wrench:	
The course was seperated into 2 courses - ptm1 and ptm2 during almost a year into 2 semesters.
In the 1st course we had milestones, and on the 2nd course we had instructions to fullfill as a continuation of the 1st course and finally to submit the final result.

ptm 1:
- Milestone 1: Creating simple class of calculations which are the foundations 
- Milestone 2: Implementing a Simple Anomaly Detector for Time Series
- Milestone 3: Creating a problem-solving server, using files for caching solutions and socket streaming.

ptm 2:
- Creating the GUI and divide into 4 parts-Clocks, Joystick, Player and Charlist using JAVAFX and creating them controllers.
- Adding 2 more detecting algorithms- Z score and  hybrid.
- Adding functionality to each part of the GUI, using MVVM structure.

# Demo
Youtube video that demonstrate our work :smile:

https://www.youtube.com/watch?v=evbQTrwkFdE

Thank you :smile:


<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSciTyYW2rH3oKklbfuBKop39IkPf-904YfsA&usqp=CAU" width="100" height="100">

pictures credit: Wikipedia.


