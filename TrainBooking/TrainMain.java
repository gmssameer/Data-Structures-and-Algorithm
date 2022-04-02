import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;


public class TrainMain {

    //Global variables
    static final int MAX_AC_SEATS = 60;
    static final int MAX_NON_AC_SEATS = 60;
    static final int MAX_SLEEPER_SEATS = 120;

    //Types of Coaches
    static final int AC_COACH = 1;
    static final int NON_AC_COACH = 2;
    static final int SLEEPER_COACH = 3;



    //Buffer Reader to read input from the command line
    static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    /**
     * The Seat is a basic unit belonging to Coach
     */
    static class Seat {
        int  pk_id;
        // seat number in a coach
        int seatNumber;
        // 1. upper birth | 2. Middle Birth | 3. lower birth
        int seatType;
//      FK to Coach
        int coachId;

        public Seat(int seatNumber) {
            this.seatNumber = seatNumber;
            this.seatType = seatNumber % 3;
        }

        private String getSeatType(){
            switch (this.seatType){
                case 0: return "Upper birth";
                case 1: return "Middle Birth";
                case 2: return "Lower birth";
                default:return "";
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Seat seats = (Seat) o;
            return seatNumber == seats.seatNumber;
        }

        @Override
        public int hashCode() {
            return Objects.hash(seatNumber);
        }

        @Override
        public String toString() {
            return "Seat: " +
                    "seatNumber = " + seatNumber +
                    ", seatType = " + getSeatType() +
                    ' ';
        }
    }

    /**
     * User
     */
    static class User{
//        PK
        int userId;
//        Name of the User
        String userName;
//        1:N mapping to booking
        Set<Booking> bookedIDs;
    }

    static class Dates{
        int dateId;
//        TIme of booking in milliseconds
        Long currentMils;
    }

    static class Booking{
//        PK
        int bookingId;
//        1:1 mapping to Dates
        Dates date;
//        1:N mapping to seat
        Set<Seat> seat;

    }


    /**
     * Coach
     */
    static class Coach{

        // identifier of the coach PK
        int coachId;
        // Total number of seats in the coach
        int noOfSeats;
//        List of seats
//        1:N mapping to Seat
        Set<Seat> totalSeats;
        // 1.Ac / 2. non Ac / 3. sleeper
        int typeOfCoach;
        // Number of seats booked in the coach
        Set<Seat> setOfBookedSeats;

//        FK to train
        int TrainId;

        public Coach() {
            this.totalSeats = new HashSet<>();
            this.setOfBookedSeats = new HashSet<>();
        }
        public Coach(int id) {
            this.coachId = id;
            this.totalSeats = new HashSet<>();
            this.setOfBookedSeats = new HashSet<>();
        }

        public int getCoachId() {
            return coachId;
        }

        public void setCoachId(int coachId) {
            this.coachId = coachId;
        }

        public int getNoOfSeats() {
            return noOfSeats;
        }

        public void setNoOfSeats(int noOfSeats) {
            this.totalSeats = new HashSet<>();
            for(int i =1;i<= noOfSeats;i++){
                Seat newSeat = new Seat(i);
                this.totalSeats.add(newSeat);
            }
            this.noOfSeats = noOfSeats;
        }

        public int getTypeOfCoach(){
            return typeOfCoach;
        }

        public String getTypeOfCoachString() {
            switch (typeOfCoach){
                case AC_COACH: return "A/C Sleeper";
                case NON_AC_COACH: return "Non A/C Sleeper";
                case SLEEPER_COACH: return "Seater";
                default:return "";
            }
        }

        public void setTypeOfCoach(int typeOfCoach) {
            this.typeOfCoach = typeOfCoach;
        }

        public Set<Seat> getSetOfBookedSeats() {
            return setOfBookedSeats;
        }

        public void setSetOfBookedSeats(HashSet<Seat> setOfBookedSeats) {
            this.setOfBookedSeats = setOfBookedSeats;
        }

        private void bookSeat(Integer seatNumber){
            setOfBookedSeats.add(new Seat(seatNumber));
        }

        private void bookMultipleSeats(Set<Seat> seatSet){
            setOfBookedSeats.addAll(seatSet);
        }

        private void removeSeat(Integer seatNumber){
            setOfBookedSeats.remove(new Seat(seatNumber));
        }

        public Set<Seat> getTotalSeats() {
            return totalSeats;
        }

        public void setTotalSeats(Set<Seat> totalSeats) {
            this.totalSeats = totalSeats;
        }

        public void setSetOfBookedSeats(Set<Seat> setOfBookedSeats) {
            this.setOfBookedSeats = setOfBookedSeats;
        }




        @Override
        public String toString() {
            int bookedSeats = (this.setOfBookedSeats.isEmpty())? 0:this.setOfBookedSeats.size();
            int availableSeats =  noOfSeats - bookedSeats;
            return "Coach{" +
                    "id = " + coachId +
                    ", Number Of Seats Available = " + availableSeats+
                    ", type of coach = " + getTypeOfCoachString() +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coach coach = (Coach) o;
            return coachId == coach.coachId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(coachId);
        }
    }

    static class Train{
        int id;
//        1:N mapping to coaches
        HashSet<Coach> coaches;


        public Train(int id) {
            this.id = id;
            this.coaches = new HashSet<>();
        }

        private void viewAllCoaches() {
            if(this.coaches.isEmpty()){
                System.out.println("Coaches are Empty");
            }
            else{
                System.out.println("All coaches:");
                for (Coach c : this.coaches) {
                    System.out.println(c.toString());
                }
            }

        }

        private Coach getCoach(int id){
            Coach c = null;
            if(this.coaches.isEmpty()){
                System.out.println("Coaches are Empty");
            }
            else{
                if(this.coaches.contains(new Coach(id))){
                    for (Coach i : this.coaches) {
                        if(i.equals(new Coach(id))){
                            c = i;
                        }
                    }
                }

            }
            return c;
        }
        private boolean removeCoach(int id){
            return this.coaches.remove(new Coach(id));
        }
        private void addCoach(Coach coach){
            this.coaches.add(coach);
        }
        private void updateCoach(Coach coach){
            this.coaches.remove(new Coach(coach.coachId));
            this.coaches.add(coach);
        }
        private boolean checkCoachId(int id){
            return this.coaches.contains(new Coach(id));
        }

    }

    /**
     * Check the input against the available types of Coaches
     * @param coachType - input
     * @return - boolean - true if the value exists
     */
    public static boolean checkTypeOfCoach(int coachType){
        return coachType == AC_COACH || coachType == NON_AC_COACH || coachType == SLEEPER_COACH;
    }

    /**
     * Chck the MAX number of the seats available in a coach
     * @param number - number of seats
     * @param coachType - Type of coach
     * @return - boolean true if the check is passed
     */
    public static boolean checkMaxNoSeats(int number , int coachType){
        switch (coachType){
            case AC_COACH:
                if(number>0 && number <= MAX_AC_SEATS) return true;break;
            case NON_AC_COACH:
                if(number>0 && number <= MAX_NON_AC_SEATS) return true;break;
            case SLEEPER_COACH:
                if(number>0 && number <= MAX_SLEEPER_SEATS) return true;break;
        }
        return false;
    }

    /**
     * Add new coach to the existing train
     * @param train - Static variable passed
     */
    public static void addCoachToTrain(Train train) {
        String confirm = "N";
        Coach newCoach;
        do {
            newCoach = new Coach();
            System.out.println("Add Coach");
            System.out.print("Coach number: ");
            int coachId = in.nextInt();
            while (train.checkCoachId(coachId)) {
                System.out.println("Coach Id Already Present \nRe-Enter: ");
                coachId = in.nextInt();
            }
            newCoach.setCoachId(coachId);
            System.out.println("Type of Coach \n 1.A/C Sleeper \n 2.Non A/C Sleeper \n 3.Seater");
            System.out.print("Enter option: ");
            int coachType = in.nextInt();
            while (!checkTypeOfCoach(coachType)) {
                System.out.println("invalid Coach Type \nRe-Enter: ");
                coachType = in.nextInt();
            }
            newCoach.setTypeOfCoach(coachType);
            System.out.print("Number of seats: ");
            int no_seats = in.nextInt();
            while (!checkMaxNoSeats(no_seats, newCoach.getTypeOfCoach())) {
                System.out.println("Number of seats are higher than the MAX value \nRe-Enter: ");
                no_seats = in.nextInt();
            }
            newCoach.setNoOfSeats(no_seats);
            System.out.println(newCoach.toString());

            System.out.println("Confirm Add (y/n): ");
            confirm = in.next();
        } while (!confirm.equalsIgnoreCase("Y"));
        train.addCoach(newCoach);
    }

    /**
     * Remove the Coach form the Train by coach number
     * @param train - Static variable passed
     */
    public static void removeCoachFromTrain(Train train){
        if(train.coaches.isEmpty()){
            System.out.println("Coaches are Empty");
        }
        else {
            System.out.println("Enter Coach Id to remove: ");
            int id = in.nextInt();
            if (!train.removeCoach(id)) {
                System.out.println("Remove Unsuccessful Invalid ID");
            }
        }
    }

    /**
     * Update the existing coach properties using coach number
     * @param train - Static variable passed
     */
    public static void updateCoach(Train train){
        if(train.coaches.isEmpty()){
            System.out.println("Coaches are Empty");
        }else {
            System.out.println("Enter Coach Id to update: ");
            int id = in.nextInt();

            Coach coach = train.getCoach(id);
            if(coach != null){
                System.out.println(coach.toString());

                String confirm = null;
                Coach updatedCoach = new Coach(id);
                do {
                    if(confirm != null && confirm.equalsIgnoreCase("N")){
                        System.out.println("Re-enter the coach Details");
                    }
                    System.out.println("Update Coach");
                    System.out.println("Coach number: "+ updatedCoach.getCoachId());

                    System.out.println("Type of Coach \n 1.A/C Sleeper \n 2.Non A/C Sleeper \n 3.Seater");
                    System.out.print("Enter option: ");
                    int coachType = in.nextInt();
                    while (!checkTypeOfCoach(coachType)) {
                        System.out.println("invalid Coach Type \nRe-Enter: ");
                        coachType = in.nextInt();
                    }
                    updatedCoach.setTypeOfCoach(coachType);
                    System.out.print("Number of seats: ");
                    int no_seats = in.nextInt();
                    while (!checkMaxNoSeats(no_seats, updatedCoach.getTypeOfCoach())) {
                        System.out.println("Number of seats are higher than the MAX value \nRe-Enter: ");
                        no_seats = in.nextInt();
                    }
                    updatedCoach.setNoOfSeats(no_seats);
                    System.out.println(updatedCoach.toString());

                    System.out.println("Confirm Add (y/n): ");
                    confirm = in.next();
                } while (!confirm.equalsIgnoreCase("Y"));
                train.updateCoach(updatedCoach);

            }else{
                System.out.println("Coach not found");
            }
        }
    }

    /**
     * View all the available seats in  the given coach of the train
     * @param train - Static variable passed
     */
    public static void viewAvailableSeats(Train train){
        if(train.coaches.isEmpty()){
            System.out.println("Coaches are Empty");
        }else {
            System.out.println("Enter Coach Id: ");
            int id = in.nextInt();
            Coach coach = train.getCoach(id);
            if(coach != null){
                System.out.println("Coach ID: "+ coach.getCoachId());
                System.out.println("Coach Type: "+ coach.getTypeOfCoachString());
                System.out.println("Total number of Seats: "+ coach.getNoOfSeats());
                System.out.println("Available number of Seats: "+ (coach.getNoOfSeats() - coach.getSetOfBookedSeats().size()));
                System.out.println("Available Seats");
                Set<Seat> bookedSeats = coach.getSetOfBookedSeats();
                for(Seat s : coach.getTotalSeats()){
                    if(!bookedSeats.contains(s)){
                        System.out.print(s.toString()+" - ");
                    }
                }

            }else {
                System.out.println("Coach not found");
            }

        }
    }

    /**
     * Book seats in given coach number
     * @param train - Static variable passed
     */
    public static void bookSeatsInCoach(Train train){
        if(train.coaches.isEmpty()){
            System.out.println("Coaches are Empty");
        }else {
            System.out.println("Enter Coach Id: ");
            int id = in.nextInt();
            Coach coach = train.getCoach(id);
            if(coach != null){
                if(coach.getSetOfBookedSeats().size() == coach.noOfSeats){
                    System.out.println("No Available Seats");
                    return;
                }
                System.out.println("Coach ID: "+ coach.getCoachId());
                System.out.println("Coach Type: "+coach.getTypeOfCoachString());
                System.out.println("Enter the seat number to book: ");
                int seatNo = in.nextInt();
                while(coach.getSetOfBookedSeats().contains(new Seat(seatNo)) || !coach.getTotalSeats().contains(new Seat(seatNo))){
                    System.out.println("Seats already booked (or) Not available \nRe-Enter: ");
                    seatNo = in.nextInt();
                }
                coach.bookSeat(seatNo);
                train.updateCoach(coach);
                System.out.println("Seat Booked");
            }else {
                System.out.println("Coach not found");
            }

        }
    }


    /**
     * Book Multiple Seats in a given Coach
     * @param train - Static variable passed
     */
    public static void bookMultipleSeatsInCoach(Train train){
        if(train.coaches.isEmpty()){
            System.out.println("Coaches are Empty");
        }else {
            System.out.println("Enter Coach Id: ");
            int id = in.nextInt();
            Coach coach = train.getCoach(id);
            if(coach != null){
                if(coach.getSetOfBookedSeats().size() == coach.noOfSeats){
                    System.out.println("No Available Seats");
                    return;
                }
                System.out.println("Coach ID: "+ coach.getCoachId());
                System.out.println("Coach Type: "+ coach.getTypeOfCoachString());

                Set<Seat> bookingSeats = new HashSet<>();
                Set<Seat> alreadyBookedSeats = new HashSet<>();
                Set<Seat> invalidBookedSeats = new HashSet<>();
                Set<Seat> bookedSeats = coach.getSetOfBookedSeats();
                Set<Seat> totalSeats = coach.getTotalSeats();
                do{
                    if(!alreadyBookedSeats.isEmpty()){
                        System.out.println("Seats are not available " + alreadyBookedSeats.toString() +"\nRe-Enter: ");
                        alreadyBookedSeats.clear();
                    }
                    if(!invalidBookedSeats.isEmpty()){
                        System.out.println("Seats are invalid " + invalidBookedSeats.toString() +"\nRe-Enter: ");
                        invalidBookedSeats.clear();
                    }
                    System.out.println("Enter the seat number to book (comma separated): ");
                    String seatNos = in.next();
                    String []seats = seatNos.split(",");
                    for(String s:seats){
                        int seatNo = Integer.parseInt(s);
                        if(bookedSeats.contains(new Seat(seatNo))){
                            alreadyBookedSeats.add(new Seat(seatNo));
                        }else if(!totalSeats.contains(new Seat(seatNo))){
                            invalidBookedSeats.add(new Seat(seatNo));
                        }
                        else{
                            bookingSeats.add(new Seat(seatNo));
                        }
                    }
                } while(!alreadyBookedSeats.isEmpty() || !invalidBookedSeats.isEmpty());
                coach.bookMultipleSeats(bookingSeats);
                train.updateCoach(coach);
                System.out.println("Seats Booked");
            }else {
                System.out.println("Coach not found");
            }

        }
    }

    /**
     * Main Function to execute the program
     * Assumptions
     *  1. Only one user and admin available
     *  2. Only one Train is initiated
     * @param args
     */
    public static void main(String[] args) {
        boolean exitCode = true;
        Train train = new Train(1);

        do{
            //Print Menu
            System.out.println("Menu");
            System.out.println("1. Login ");
            System.out.println("2. Exit ");
            System.out.println("Enter Option: ");
            int option = in.nextInt();
            if(option == 1 ){
                //Select role of the user
                System.out.println("Select Roles to Login");
                System.out.println("1. Admin \n2. User");
                System.out.println("Enter Selection: ");
                int roleSelection = in.nextInt();
                boolean userLoggedIn = true;
                while (userLoggedIn){
                    //Printing Loggedin user operations
                    System.out.println("\nSelect Operations");
                    switch (roleSelection){
                        case 1:
                            System.out.println("1. Add Coaches");
                            System.out.println("2. Remove Coaches");
                            System.out.println("3. Update Coaches Details");
                            System.out.println("4. View all seats");
                            System.out.println("5. Logout");
                            System.out.println("Enter Option: ");
                            int adminSelection = in.nextInt();
                            switch (adminSelection){
                                case 1: addCoachToTrain(train);break;
                                case 2: removeCoachFromTrain(train);break;
                                case 3: updateCoach(train);break;
                                case 4: train.viewAllCoaches();break;
                                case 5: userLoggedIn = false;
                            }
                            break;
                        case 2:
                            System.out.println("1. View All Available Seats in Coach");
                            System.out.println("2. Book Seats in a Coach");
                            System.out.println("3. Book multiple Seats in a Coach");
                            System.out.println("4. Logout");
                            System.out.println("Enter Option: ");
                            int userSelection = in.nextInt();
                            switch (userSelection){
                            case 1: viewAvailableSeats(train);break;
                            case 2: bookSeatsInCoach(train);break;
                            case 3: bookMultipleSeatsInCoach(train);break;
                            case 4: userLoggedIn = false;
                        }
                            break;
                        default:
                            System.out.println("Wrong Input");
                    }

                }


            }
            else if (option == 2){
                exitCode = false;
            }
        }while (exitCode);

    }


}
