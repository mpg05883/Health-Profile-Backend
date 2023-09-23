/**
 * HealthProfile is a computerized health record that gathers user input, stores it, and displays health information.
 * It takes user input using inputPatientInformation(), and inputPatientInformation() invokes setters to assign input to
 * HealthProfile's instance variables. Then, it invokes printRecord() to display the input cleanly. printRecord() invokes
 * calculateAge() to calculate the patient's age and getTargetHeartRateInfo() to get the patient's maximum heart rate and
 * upper and lower bounds for their target heart rate range. Finally, displayBMIChart() is invoked to display the patient's BMI.
 * Within displayBMIChart(), calculateBMI is invoked to determine which category the patient's BMI falls in.
 *
 *  @author Michael Gee
 * ITP 265, Summer 2022, Section 31825
 * Assignment 1
 * Email: mpgee@usc.edu
 */

import java.util.Scanner; // import statement to use Scanner class from java.util package.
import java.time.*; // import statement to use classes and methods in java.time package.

/**
 * Returns a HealthProfile object that can then take input, calculate age, maximum heart rate, target heart rate range, and BMI, and neatly display everything.
 */
public class HealthProfile {
    // instance variables: declare instance variables as private so only methods within HealthProfile can modify them.
    private String firstName; // patient's first name.
    private String lastName; // patient's last name.
    private char gender; // patient's gender.
    private int birthMonth; // month when patient was born.
    private int birthDay; //  day of the month patient was born.
    private int birthYear; // year patient was born.
    private double height; // patient's height.
    private double weight; // patient's weight.
    private boolean covid; // patient's covid test result.
    private String allergies; // patient's allergies.

    /**
     * Initializes a HealthProfile object with default values.
     */
    public HealthProfile() {
        this.firstName = null;
        this.lastName = null;
        this.gender = 'o'; // initialize gender as 'o' to be gender neutral.
        this.birthMonth = 1; // initialize birthMonth as 1 bc that's the first month of any year.
        this.birthDay = 1; // initialize birthDay as 1 bc that's the first day of any month.
        this.birthYear = 1900; // initialize birthYear as 1900 bc that's the oldest allowable birth year.
        this.height = 0.0;
        this.weight = 0.0;
        this.covid = false;
        this.allergies = "none";
    }

    /**
     * Returns a String containing the patient's first name.
     *
     * @return the patient's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Assigns the patient's first name to a String firstNameParam.
     * Splits firstNameParam into two substrings. Invokes toUpperCase method to capitalize the first letter and invokes
     * to LowerCase method to lowercase the rest of the letters. The substrings are concatenated to get the first name
     * with only the first letter capitalized.
     *
     * @param firstNameParam the patient's first name.
     */
    public void setFirstName(String firstNameParam) {
        this.firstName = firstNameParam.substring(0,1).toUpperCase() + firstNameParam.substring(1).toLowerCase();
    }

    /**
     * Returns a string containing the patient's last name.
     *
     * @return the patient's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Assigns the patient's last name to a String lastNameParam.
     * Uses the same strategy as setFirstName to properly format the last name.
     *
     * @param lastNameParam the patient's last name.
     */
    public void setLastName(String lastNameParam) {
        this.lastName = lastNameParam.substring(0,1).toUpperCase() + lastNameParam.substring(1).toLowerCase();
    }

    /**
     * Returns a char containing the patient's gender.
     *
     * @return the patient's gender.
     */
    public char getGender() {
        return gender;
    }

    /**
     * Assigns the patient's gender to char genderParam.
     *
     * @param genderParam the patient's gender.
     */
    public void setGender(char genderParam) {
        this.gender = genderParam;
    }

    /**
     * Returns an int containing patient's month of birth.
     *
     * @return the patient's month of birth.
     */
    public int getBirthMonth() {
        return birthMonth;
    }

    /**
     * Assigns the patient's birth month to an int birthMonthParam.
     *
     * @param birthMonthParam the patient's month of birth.
     */
    public void setBirthMonth(int birthMonthParam) {
        this.birthMonth = birthMonthParam;
    }

    /**
     * Returns an int containing the day of the month the patient was born.
     *
     * @return the day of the month the patient was born.
     */
    public int getBirthDay() {
        return birthDay;
    }

    /**
     * Assigns the patient's birth day to an int birthDayParam.
     *
     * @param birthDayParam the day of the month the patient was born.
     */
    public void setBirthDay(int birthDayParam) {
        this.birthDay = birthDayParam;
    }

    /**
     * Returns an int containing the year the patient was born.
     *
     * @return the year the patient was born.
     */
    public int getBirthYear() {
        return birthYear;
    }

    /**
     * Assigns the patient's year of birth to an int birthYearParam.
     *
     * @param birthYearParam the year the patient was born.
     */
    public void setBirthYear(int birthYearParam) {
        this.birthYear = birthYearParam;
    }

    /**
     * Returns a double containing the patient's height in inches.
     *
     * @return the patient's height in inches.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Assigns the patient's height in inches to a double heightParam.
     *
     * @param heightParam the patient's height in inches.
     */
    public void setHeight(double heightParam) {
        this.height = heightParam;
    }

    /**
     * Returns a double containing the patient's weight in pounds.
     *
     * @return the patient's weight in pounds.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Assigns the patient's weight to a double weightParam.
     *
     * @param weightParam the patient's weight in pounds.
     */
    public void setWeight(double weightParam) {
        this.weight = weightParam;
    }

    /**
     * Returns a string containing the patient's allergies.
     *
     * @return a string containing the patient's allergies.
     */
    public String getAllergies() {
        return allergies;
    }

    /**
     * Assigns the patient's allergies to a String allergiesParam.
     *
     * @param allergiesParam a string containing the patient's allergies.
     */
    public void setAllergies(String allergiesParam) {
        this.allergies = allergiesParam;
    }

    /**
     * Returns a boolean containing the patient's covid test results. true means tested positive and false means tested
     * negative.
     *
     * @return a boolean containing the patient's covid test results.
     */
    public boolean isCovid() {
        return covid;
    }

    /**
     * Assigns the patient's covid test result to a boolean covidParam.
     *
     * @param covidParam a boolean containing the patient's covid test results.
     */
    public void setCovid(boolean covidParam) {
        this.covid = covidParam;
    }

    /**
     * Instantiates a Scanner to get input, displays prompts to provide input using print statements,
     * and invokes setters to assign input to instance variables.
     * It also uses while loops for gender, birth month, birth day, birth year, height, and weight to make sure inputs are
     * realistic (eg making sure birth month isn't 13 or weight is -1).
     */
    public void inputPatientInformation(){
        Scanner in = new Scanner(System.in); // instantiate new Scanner object using new keyword.
        System.out.println("Welcome to the HealthProfile system. Please enter patient information.");

        // first name:
        System.out.print("Please enter first name: "); // prompt to input first name.
        setFirstName(in.nextLine()); // assign input to firstName using firstName setter.

        // last name:
        System.out.print("Please enter last name: "); // prompt to input last name.
        setLastName(in.nextLine()); // assign input to lastName using lastName setter.

        // gender:
        int validGender = 0; // condition to run while loop.
        // use while loop to check if M, F, or O are inputted
        while (validGender == 0) {
            System.out.print("Please enter gender (M/F/O): "); // prompt to input gender.
            char genderInput = in.nextLine().toUpperCase().charAt(0); // assign input to char genderInput. toUpperCase method used for error checking. charAt(0) used to convert string input to char.
            if (genderInput == 'M' || genderInput == 'F' || genderInput == 'O') {
                // if gender equals M, F, or O then input is valid.
                setGender(genderInput); // assign input to gender using gender setter.
                validGender = 1; // validGender = 1 ends while loop.
            } else {
                // if gender != M, F, or O, then input is not correct
                System.out.println("Invalid gender. Please enter M, F, or O."); // print statement telling user their input was invalid
                // while loop repeatedly prompts user to input gender until they input M, F, or O
            }
        }

        // birth month:
        int validMonth = 0; // condition to run while loop.
        // use while loop to check that birthMonth => 1 and birthMonth <= 12.
        while (validMonth == 0){
            System.out.print("Please enter birth month (1-12): "); // prompt to input birth month.
            int birthMonthInput = in.nextInt(); // input assigned to birthMonthInput using nextInt method.
            if (birthMonthInput < 1 || birthMonthInput > 12){
                // if birthMonth < 1 or birthMonth > 12, then input does not correspond to a month on the Gregorian calendar.
                System.out.println("Invalid month. Please enter a month from 1 to 12."); // print statement telling user their input was invalid.
                // while loop repeatedly prompts user to input birth month until birthMonth => 1 and birthMonth <= 12.
            } else{
                // if birthMonth > 1 and birthMonth < 12, then input corresponds to a month on the Gregorian calendar.
                setBirthMonth(birthMonthInput); // assign input to birthMonth using birthMonth setter.
                validMonth = 1; // validMonth = 1 ends while loop.
            }
        }

        // birth day:
        int validDay = 0; // condition to run while loop.
        // use while loop to check that birthDay => 1 and birthDay <= 31.
        while (validDay == 0) {
            System.out.print("Please enter birth day (1-31): "); // prompt to input birth day.
            int birthDayInput = in.nextInt(); // input assigned to birthDayInput using nextInt method.
            if (birthDayInput < 1 || birthDayInput > 31) {
                // if birthDayInput < 1 or birthDayInput > 31, then input is not a real day of the month
                System.out.println("Invalid birth day. Please enter a day from 1 to 31."); // print statement telling user their input was invalid.
                // while loop repeatedly prompts user to input birth day until birthDay => 1 and birthDay <= 31.
            } else {
                // if birthDay => 1 and birthDay <= 31, then it is a real day of the month
                setBirthDay(birthDayInput); // assign input to birthDay using birthDay setter.
                validDay = 1; //validDay = 1 ends while loop.
            }
        }

        // birth year:
        int validYear = 0; // condition to run while loop.
        // while loop used to check if birthYear >= 1900 and birthYear <= 2022.
        while (validYear == 0){
            System.out.print("Please enter four digit birth year: "); // prompt to enter birth year.
            int birthYearInput = in.nextInt(); // input assigned to birthYearInput using nextInt method.
            if (birthYearInput < 1900 || birthYearInput > 2022){
                // birthYear < 1900 or birthYear > 2022, then the patient is either too old to be alive or hasn't been born yet.
                System.out.println("Invalid birth year. Please enter a year from 1900 to 2022."); // print statement telling user their input was invalid.
                // while loop repeatedly prompts user to input birth year until birthYear >= 1900 and birthYear <= 2022.
            } else{
                // if birthYear >= 1900 and birthYear <= 2022, then the patient is a realistic age.
                setBirthYear(birthYearInput); // input assigned to birthYear using birthYear setter.
                validYear = 1; // validYear = 1 ends while loop.
            }
        }

        // height:
        int validHeight = 0; // condition to run while loop.
        // while loop used to check if height is above 0 inches.
        while (validHeight == 0) {
            System.out.print("Please enter height in inches: "); // prompt to enter height.
            double heightInput = in.nextDouble(); // input assigned to heightInput using nextDouble method.
            if (heightInput <= 0){
                // if height <= 0, then it is an impossible value to have for height.
                System.out.println("Invalid height. Please enter a height above 0 inches."); // print statement telling user their input was invalid.
                // while loop repeatedly prompts user to input height until height > 0 (ie is realistic).
            }
            else{
                // if height > 0, then a realistic height has been inputted.
                setHeight(heightInput); // input assigned to height using height setter.
                validHeight = 1; // validHeight = 1 ends while loop.
            }
        }

        // weight:
        int validWeight = 0; // condition to run while loop.
        // while loop used to check if weight > 0.
        while (validWeight == 0) {
            System.out.print("Please enter weight in pounds: "); // prompt to input weight.
            double weightInput = in.nextDouble(); // input assigned to weightInput using nextDoule method.
            if (weightInput <= 0){
                // if weight <= 0, then it is an impossible value to have for weight.
                System.out.println("Invalid weight. Please enter a weight above 0 lbs."); // print statement telling user their input was invalid.
                // while loop repeatedly prompts user to input weight until weight > 0 (ie is realistic).
            } else{
                // if weight > 0, then a realistic weight has been inputted.
                setWeight(weightInput);  // input assigned to weight using weight setter.
                validWeight = 1; // validWeight = 1 ends while loop.
            }
        }

        // allergies:
        System.out.print("Please enter your allergies in a list (if no allergies, enter \"none\"): "); // prompt to input allergies.
        in.nextLine(); // nextLine method called on to work around Scanner class bug that occurs when reading strings preceded by numbers.
        setAllergies(in.nextLine()); // input assigned to allergies using allergies setter.

        // covid:
        System.out.print("Positive for Covid? (Enter \"true\" or \"false\"): "); // prompt to input covid test results.
        setCovid(in.nextBoolean()); // input assigned to covid using covid setter.
    }

    /**
     * Calculates patient's age at the end of this calendar year by subtracting patient's birth year from current year.
     * Instantiates LocalDateTime object from java.time package and invokes getters to instantiate variables corresponding
     * to int values for today's date, month, and year. U
     * Uses if statement to determine if patient's birthday has passed yet and calculates age accordingly.
     *
     * @return an int containing the patient's age.
     */
    public int calculateAge(){
        LocalDateTime date = LocalDateTime.now(); // get today's date using now method.
        int todayMonth = date.getMonthValue(); // get int value for today's month using getMonthValue method.
        int todayDay = date.getDayOfMonth(); // get int value for today's date using getDayOfMonth method.
        int todayYear = date.getYear(); // get int value for today's year using getYear method.
        int age = todayYear - getBirthYear(); // get patient's age by the end of the calendar year.
        if (todayMonth < getBirthMonth() || (todayMonth == getBirthMonth() && todayDay < getBirthDay())){
            // case 1: if todayMonth < birthMonth, then the patient's birthday has not passed yet.
            // case 2: if todayMonth == birthMonth and todayDay < birthDay, then the patient's birthday has not passed yet.
            // because the patient's birthday has not passed yet, their true age is (todayYear - birthYear) - 1.
            age--; // patient's age is decreased by 1 using post increment.
        }
        return age; // return age.
    }

    /**
     * Calculates the patient's maximum heart rate and target heart rate range. Determines value for patient's age by
     * invoking calculateAge method. Initializes an array targetHR where the zeroth element is the upper target heart rate bound
     * and the first element is the lower target heart rate bound. Concatenates everything into a neatly formatted string.
     *
     * @return a String containing the patient's maximum heart rate and target heart rate range.
     */
    public String getTargetHeartRateInfo(){
        // NOTE: HR is abbreviation of heart rate.
        int maxHR = 220-calculateAge(); // get max HR by subtracting age from 220. get value for age by invoking calculateAge method.
        double[] targetHR = {maxHR*0.85, maxHR*0.5}; // calculate target heart rate bounds and assign to values in an array called targetHR.
        return ("Max heart rate: " + maxHR + " bpm. Target heart rate range: " + targetHR[0] + " - " + targetHR[1] + " bpm."); // return string containing max HR and target HR bounds.
    }

    /**
     * Neatly prints values assigned to instance variables by invoking getters within print statements. Uses two for
     * loops to print 75 asterisks at the top and bottom of the page. Prints heart rate info by invoking getTargetHeartRateInfo method
     * and prints age by invoking calculateAge method. Uses if and else statements to print covid test result.
     */
    public void printRecord(){
        // for loop prints 75 asterisks.
        for (int i = 0; i <=74; i++){
            System.out.print("*");
        }
        // print statements displaying inputted patient info.
        System.out.println("\n\t\tHealth Profile:");
        System.out.println("* Name: " + getFirstName() + " " + getLastName());
        System.out.println("* Gender: " + getGender());
        System.out.println("* DOB: " + getBirthMonth() + "/" + getBirthDay() + "/" + getBirthYear());
        System.out.println("* Height: " + getHeight() + " inches");
        System.out.println("* Weight: " + getWeight()+ " pounds");
        int age = calculateAge(); // invoke calculateAge() to initialize age.
        System.out.println("* Age: " + age);
        System.out.println("* ❤ Info: " + getTargetHeartRateInfo()); // invokes getTargetHeartRateInfo to get max HR, and target HR bounds.
        String testResult; // initialize string to display covid test result.
        if (isCovid() == true){
            // if covid == true, then the patient tested positive for covid.
            testResult = "POSITIVE"; // assign testResult to "POSITIVE".
        } else {
            // if covid != true, then the patient tested negative for covid.
            testResult = "NEGATIVE"; // assign testResult to "NEGATIVE".
        }
        System.out.println("* Allergies: " + getAllergies());
        System.out.println("* Covid test result: " + testResult);
        // for loop prints 75 asterisks
        for (int i = 0; i <=74; i++){
            System.out.print("*");
        }
    }

    /**
     * Calculates the patient's BMI. Invokes getters for weight in pounds and height in inches to get values
     * for weight and height.
     *
     * @return a double containing the patient's BMI.
     */
    public double calculateBMI(){
        return (getWeight() * 703)/(getHeight() * getHeight()); // calculate BMI using BMI formula.
    }

    /**
     * Neatly displays the patient's BMI by using print statements. Invokes calculateBMI method to get value for BMI.
     * Uses if, else if, and else statements to categorize the patient's BMI. Prints the patient's BMI and BMI category.
     */
    public void displayBMIChart(){
        System.out.println("\nBMI Values:\n\tUnderweight: less than 18.5\n\tNormal: between 18.5 and 24.9\n\tOverweight: between 25 and 29.9\n\tObese: 30 or greater"); // print statement displaying each BMI category.
        String categoryName; // declare String categoryName to be used later.
        // if, else if, and else statements used to declare category depending on calculated BMI
        if (calculateBMI() < 18.5){
            categoryName = "Underweight";
        } else if (calculateBMI() >= 18.5 && calculateBMI() <25) {
            categoryName = "Normal";
        } else if (calculateBMI() >= 25 & calculateBMI() < 30) {
            categoryName = "Overweight";
        } else {
            categoryName = "Obese";
        }
        System.out.println("\nYour BMI value is: " + calculateBMI() + ", which puts you in the " + categoryName + " category."); // print statement displaying patient's BMI and BMI category according to if, else if, and else statements.
    }

    /**
     * Instantiates HealthProfile object and invokes inputPatientInformation() method to input patient info,
     * printRecord() to display the patient's HealthProfile, and displayBMIChart() method to display the patient's
     * BMI information.
     *
     * @param args a String array.
     */
    public static void main(String[] args){
        HealthProfile record = new HealthProfile(); // instantiate HealthProfile class.
        record.inputPatientInformation(); // invoke inputPatientInformation method from HealthProfile class.
        record.printRecord(); // invoke printRecord method from HealthProfile class.
        record.displayBMIChart(); // invoke displayBMIChart method from HealthProfile class.
    }
}
