import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Driver {
  private static ArrayList<Dog> dogList = new ArrayList<Dog>();
  private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
  // Initialize array list with eligible monkey species
  private static ArrayList<String> monkeySpecies = new ArrayList<String>(
      Arrays.asList("capuchin", "guenon", "macaque", "Marmoset", "squirrel monkey", "tamarin"));
  // Instance variables (if needed)

  public static void main(String[] args) {

    initializeDogList();
    initializeMonkeyList();

    // For the project submission you must also include input validation
    // and appropriate feedback to the user.

    Scanner scnr = new Scanner(System.in);
    int option;
    String input;


    // Add a loop that displays the menu, accepts the users input
    // and takes the appropriate action.
    do {
      displayMenu();
      // check if user input wasn't an integer
      if (!scnr.hasNextInt()) {
        // if not an integer assign user input to new variable
        input = scnr.next();
        // if input is equal to q, break loop and alert user is exiting application
        if (input.equals("q")) {
          System.out.println("You Exited the application. Good Bye!!!");
          break;
        } else {
          // if input is anything else but an int or q, 
          // send user error message
          System.out.println("Your input does not match an available option. Try again.");
          // initialize option to random number outside designated values
          option = 8;
          // continue loop so user can try to input again
          continue;
        }
      }
      // set user input
      option = scnr.nextInt();
      // if option is 1
      if (option == 1) {
        // call intakeNewDog() method and send scanner as parameter
        intakeNewDog(scnr);
      }
      // if option is 2
      else if (option == 2) {
        // call intakeNewMonkey() method with scanner as parameter
        intakeNewMonkey(scnr);
      }
      // if option is 3
      else if (option == 3) {
        // call reserveAnimal() method with scanner as parameter
        reserveAnimal(scnr);
      }
      // if option is 4
      // Hint: Menu options 4, 5, and 6 should all connect to the printAnimals()
      // method.
      else if (option == 4 || option == 5 || option == 6) {
        // call the printAnimals() method
        printAnimals(option);
      }
      // if option is 7, then display the message and exit the loop
      else if (option == 7) {
        System.out.println("You Exited the application. Good Bye!!!");
        break;
      }
      // if option is invalid, display the error message and continue loop
      else {
        System.out.println("Your input does not match an available option. Try again.");
        continue;
      }
    } while (option != 7);

  }

  // This method prints the menu options
  public static void displayMenu() {
    System.out.println("\n\n");
    System.out.println("\t\t\t\tRescue Animal System Menu");
    System.out.println("[1] Intake a new dog");
    System.out.println("[2] Intake a new monkey");
    System.out.println("[3] Reserve an animal");
    System.out.println("[4] Print a list of all dogs");
    System.out.println("[5] Print a list of all monkeys");
    System.out.println("[6] Print a list of all animals that are not reserved");
    System.out.println("[7] Quit application");
    System.out.println();
    System.out.println("Enter a menu selection");
  }

  // Adds dogs to a list for testing
  public static void initializeDogList() {
    Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "in service",
        false, "United States");
    Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false,
        "United States");
    Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true,
        "Canada");

    dogList.add(dog1);
    dogList.add(dog2);
    dogList.add(dog3);
  }

  // Adds monkeys to a list for testing
  // Optional for testing
  public static void initializeMonkeyList() {
    Monkey monkey1 = new Monkey("Coco", "Capuchin", "female", "8", "1", "25.6", "3", "16", "06-18-2019",
        "United States", "Phase I", false, "United States");
    Monkey monkey2 = new Monkey("Mochi", "Capuchin", "male", "8", "1", "25.6",  "3", "16", "06-18-2019",
        "United States", "in service", false, "United States");

    monkeyList.add(monkey1);
    monkeyList.add(monkey2);
  }

  // Complete the intakeNewDog method
  // The input validation to check that the dog is not already in the list
  // is done for you
  public static void intakeNewDog(Scanner scanner) {
    scanner.nextLine();
    System.out.println("What is the dog's name?");
    String name = scanner.nextLine();
    for (Dog dog : dogList) {
      if (dog.getName().equalsIgnoreCase(name)) {
        System.out.println("\n\nThis dog is already in our system\n\n");
        return; // returns to menu
      }
    }
    ;

    // Add the code to instantiate a new dog and add it to the appropriate list
    // Prompt user for dog info
    System.out.println("Enter dog breed:");
    String dogBreed = scanner.nextLine();
    System.out.println("Enter dog gender:");
    String dogGender = scanner.nextLine();
    System.out.println("Enter dog age:");
    String dogAge = scanner.nextLine();
    System.out.println("Enter dog weight:");
    String dogWeight = scanner.nextLine();
    System.out.println("Enter acquisition date:");
    String acqDate = scanner.nextLine();
    System.out.println("Enter acquisition country:");
    String acqCountry = scanner.nextLine();
    System.out.println("Enter training status:");
    String trainStatus = scanner.nextLine();
    System.out.println("Is the dog reserved? (True/False)");
    Boolean isReserved = scanner.nextBoolean();
    scanner.nextLine();
    System.out.println("Enter dog's service country:");
    String servCountry = scanner.nextLine();
    // instantiate new dog with user input values
    Dog newDog = new Dog(name, dogBreed, dogGender, dogAge, dogWeight, acqDate, acqCountry, trainStatus, isReserved,
        servCountry);
    // add new Dog to array list
    dogList.add(newDog);
    System.out.println(name + " added to system!");
  }

  // Complete intakeNewMonkey
  // Instantiate and add the new monkey to the appropriate list
  // For the project submission you must also validate the input
  // to make sure the monkey doesn't already exist and the species type is allowed
  public static void intakeNewMonkey(Scanner scanner) {
    scanner.nextLine();
    System.out.println("What is the monkey's name?");
    String name = scanner.nextLine();
    for (Monkey monkey : monkeyList) {
      if (monkey.getName().equalsIgnoreCase(name)) {
        System.out.println("\n\nThis monkey is already in our system\n\n");
        return;
      }
    }

    // BUG: Prompts for monkey name and monkey species on same line, won't split to
    // separate lines and inputs for some reason

    System.out.println();
    System.out.println("What is the monkey's species? ");
    String species = scanner.nextLine();
    if (!monkeySpecies.contains(species.toLowerCase())) {
      System.out.println("\n\nThis monkey species is not allowed\n\n");
      return;
    }

    // Add the code to instantiate a new monkey and add it to the appropriate list
    // Prompt user for dog info
    System.out.println("Enter monkey's gender:");
    String monkeyGender = scanner.nextLine();
    System.out.println("Enter monkey's age ");
    String monkeyAge = scanner.nextLine();
    System.out.println("Enter monkey's weight ");
    String monkeyWeight = scanner.nextLine();
    System.out.println("Enter monkey's height ");
    String monkeyHeight = scanner.nextLine();
    System.out.println("Enter monkey's tail length ");
    String monkeyTailLength = scanner.nextLine();
    System.out.println("Enter monkey's body length ");
    String monkeyBodyLength = scanner.nextLine();
    System.out.println("Enter acquisition date:");
    String acqDate = scanner.nextLine();
    System.out.println("Enter acquisition country:");
    String acqCountry = scanner.nextLine();
    System.out.println("Enter training status:");
    String trainStatus = scanner.nextLine();
    System.out.println("Is the monkey reserved? (True/False)");
    Boolean isReserved = scanner.nextBoolean();
    scanner.nextLine();
    System.out.println("Enter monkey's service country:");
    String servCountry = scanner.nextLine();
    // instantiate new monkey with user input values
    Monkey newMonkey = new Monkey(name, species, monkeyGender, monkeyAge, monkeyWeight, monkeyHeight,
        monkeyTailLength, monkeyBodyLength, acqDate, acqCountry, trainStatus, isReserved, servCountry);
    // add new Monkey to array list
    monkeyList.add(newMonkey);
  }

  // Complete reserveAnimal
  // You will need to find the animal by animal type and in service country
  public static void reserveAnimal(Scanner scanner) {
    scanner.nextLine();
    System.out.println("Enter the animal type: ");
    String type = scanner.nextLine();
    System.out.println("Enter the country name: ");
    String country = scanner.nextLine();

    for (Dog dog : dogList) {
      // check if animal type is dog and service location is same for dog on file
      // also check if that dog's reserved status is currently false
      if (dog.getAnimalType().equalsIgnoreCase(type) && dog.getInServiceLocation().equalsIgnoreCase(country)
          && dog.getReserved() == false) {
        // if available change reserved state to true
        dog.setReserved(true);
        System.out.println("Animal reserved successfully in " + country);
        return;
      }
    }
    for (Monkey monkey : monkeyList) {
      // check if animal type is monkey and service location is same for monkey on
      // file
      // also check if that monkey's reserved status is currently false
      if (monkey.getAnimalType().equalsIgnoreCase(type) && monkey.getInServiceLocation().equalsIgnoreCase(country)
          && monkey.getReserved() == false) {
        // if available change reserved state to true
        monkey.setReserved(true);
        System.out.println("Animal reserved successfully in " + country);
        return;
      }
    }
    // if no checks pass return error to user
    System.out.println("No" + type + "is available in that location");

  }

  // Complete printAnimals
  // Include the animal name, status, acquisition country and if the animal is
  // reserved.
  // Remember that this method connects to three different menu items.
  // The printAnimals() method has three different outputs
  // based on the listType parameter
  // dog - prints the list of dogs
  // monkey - prints the list of monkeys
  // available - prints a combined list of all animals that are
  // fully trained ("in service") but not reserved
  // Remember that you only have to fully implement ONE of these lists.
  // The other lists can have a print statement saying "This option needs to be
  // implemented".
  // To score "exemplary" you must correctly implement the "available" list.
  public static void printAnimals(int option) {
    if (option == 6) {
      System.out.println("All available animals:");
      for (Dog dog : dogList) {
        // check if dog is in service and reserved status is false
        if (dog.getTrainingStatus() == "in service" && dog.getReserved() == false) {
          // if available print dog info
          System.out.println(dog.getName() + " - " + dog.getTrainingStatus() + " - "
              + dog.getAcquisitionLocation() + " - available");
        }
      }
      for (Monkey monkey : monkeyList) {
        // check if monkey is in service and reserved status is false
        if (monkey.getTrainingStatus() == "in service" && monkey.getReserved() == false) {
          // if available print monkey info
          System.out.println(monkey.getName() + " - " + monkey.getTrainingStatus() + " - "
              + monkey.getAcquisitionLocation() + " available");
        }
      }

    } else if (option == 5) {
      System.out.println("All Monkeys:");
      for (Monkey monkey : monkeyList) {
          // Print monkey's name, age, gender and training status
          System.out.println(monkey.getName() + " - " + monkey.getAge() + " - "
              + monkey.getGender() + " - " + monkey.getTrainingStatus());
      }
    } else if (option == 4) {
      System.out.println("All Dogs:");
      for (Dog dog : dogList) {
        // Print dog's name, age, gender and training status
        System.out.println(dog.getName() + " - " + dog.getAge() + " - "
            + dog.getGender() + " - " + dog.getTrainingStatus());
      }
    }
  }
}
