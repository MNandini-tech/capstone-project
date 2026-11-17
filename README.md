CP-041 RouteSeat: Intercity Bus Reservation and Seat Management System
Team
M Nandini
Raheela
Java Track

How to run
Open the RouteSeat project folder in VS Code.
Open the terminal.
Compile the Java program:
javac RouteSeat.java
Run the program:
java RouteSeat
Features that work
Bus and Route Management: Set up bus routes and bus details.
Seat Layout: Display the bus seat arrangement.
Seat Availability: View available and booked seats.
Seat Booking: Book seats by entering the passenger's name and age.
Fare Calculation: Calculate ticket fare based on travel distance.
Booking Cancellation: Cancel an existing seat booking.
Refund Calculation: Calculate refunds based on how early the booking is cancelled.
Passenger List: Display the list of passengers booked on a bus.
Sample run
===== ROUTESEAT SYSTEM =====

Add Route
Add Bus
View Routes
View Buses
Show Seat Map
Book Ticket
Cancel Booking
Passenger List
Exit Enter your choice: 1 Enter source: blg Enter destination: chi Enter distance in KM: 250 Route added successfully!
===== ROUTESEAT SYSTEM =====

Add Route
Add Bus
View Routes
View Buses
Show Seat Map
Book Ticket
Cancel Booking
Passenger List
Exit Enter your choice: 2
--- ROUTE LIST --- Route ID: 1 blg to chi Distance: 250 KM
Enter route ID: 1 Enter bus name: altra dlex Enter number of seats (maximum 50): 30 Bus added successfully!

===== ROUTESEAT SYSTEM =====

Add Route
Add Bus
View Routes
View Buses
Show Seat Map
Book Ticket
Cancel Booking
Passenger List
Exit Enter your choice: 3
--- ROUTE LIST --- Route ID: 1 blg to chi Distance: 250 KM
===== ROUTESEAT SYSTEM =====

Add Route
Add Bus
View Routes
View Buses
Show Seat Map
Book Ticket
Cancel Booking
Passenger List
Exit Enter your choice: 4
--- BUS LIST --- Bus ID: 1 Bus Name: altra dlex Route: blg to chi Total Seats: 30
===== ROUTESEAT SYSTEM =====

Add Route
Add Bus
View Routes
View Buses
Show Seat Map
Book Ticket
Cancel Booking
Passenger List
Exit Enter your choice: 5
--- BUS LIST --- Bus ID: 1 Bus Name: altra dlex Route: blg to chi Total Seats: 30
Enter bus ID: 1

--- SEAT MAP --- A = Available, B = Booked 1[A] 2[A] 3[A] 4[A]
5[A] 6[A] 7[A] 8[A]
9[A] 10[A] 11[A] 12[A]
13[A] 14[A] 15[A] 16[A]
17[A] 18[A] 19[A] 20[A]
21[A] 22[A] 23[A] 24[A]
25[A] 26[A] 27[A] 28[A]
29[A] 30[A]

===== ROUTESEAT SYSTEM =====

Add Route
Add Bus
View Routes
View Buses
Show Seat Map
Book Ticket
Cancel Booking
Passenger List
Exit Enter your choice: 6
--- BUS LIST --- Bus ID: 1 Bus Name: altra dlex Route: blg to chi Total Seats: 30
Enter bus ID: 1

Available seats: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 Enter seat number: 3 Enter passenger name: pink Enter passenger age: 12 Ticket fare: Rs. 500.0 Enter payment amount: 500

--- TICKET CONFIRMATION --- Booking ID: 1 Passenger: pink Age: 12 Seat Number: 3 Fare: Rs. 500.0 Payment: Rs. 500.0 Change: Rs. 0.0 Booking successful!

===== ROUTESEAT SYSTEM =====

Add Route
Add Bus
View Routes
View Buses
Show Seat Map
Book Ticket
Cancel Booking
Passenger List
Exit Enter your choice: 8
--- BUS LIST --- Bus ID: 1 Bus Name: altra dlex Route: blg to chi Total Seats: 30
Enter bus ID: 1

--- PASSENGER LIST --- Booking ID: 1 Name: pink Age: 12 Seat Number: 3
===== ROUTESEAT SYSTEM =====

Add Route
Add Bus
View Routes
View Buses
Show Seat Map
Book Ticket
Cancel Booking
Passenger List
Exit Enter your choice: 7 Enter booking ID: 1 Enter hours before departure: 17 Booking cancelled successfully! Refund amount: Rs. 250.0
===== ROUTESEAT SYSTEM =====

Add Route
Add Bus
View Routes
View Buses
Show Seat Map
Book Ticket
Cancel Booking
Passenger List
Exit Enter your choice: 0 Thank you for using RouteSeat!
