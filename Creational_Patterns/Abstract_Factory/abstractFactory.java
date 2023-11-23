import java.util.Scanner;

// Door Objects
interface Door {
    void open();
}

class GasCarDoor implements Door {
    GasCarDoor() {
        System.out.println("Making a door for a gas car.");
    }

    public void open() {
        System.out.println("click");
    }
}

class ElectricCarDoor implements Door {
    ElectricCarDoor() {
        System.out.println("Making a door for an electric car");
    }

    public void open() {
        System.out.println("shhhhh");
    }
}

// Engine objects
interface Engine {
    void run();
}

class GasEngine implements Engine {
    private final String sound;

    GasEngine() {
        sound = "vroom 🔥";
        System.out.println("Making a gas engine.");
    }

    public void run() {
        System.out.println(sound);
    }
}

class ElectricEngine implements Engine {
    private final String sound;

    ElectricEngine() {
        sound = "SHHHH 😎";
        System.out.println("Making an electric engine.");
    }

    public void run() {
        System.out.println(sound);
    }
}

// Factories
interface CarFactory {
    Door buildDoor();
    Engine buildEngine();
}

class GasCarFactory implements CarFactory {
    public Door buildDoor() {
        return new GasCarDoor();
    }

    public Engine buildEngine() {
        return new GasEngine();
    }
}

class ElectricCarFactory implements CarFactory {
    public Door buildDoor() {
        return new ElectricCarDoor();
    }

    public Engine buildEngine() {
        return new ElectricEngine();
    }
}

public class Main {
    public static void main(String[] args) {
        CarFactory carPlant;
        int choice;

        System.out.println("Select a car type: ");
        System.out.println("1: Gasoline");
        System.out.println("2: Electric");
        System.out.print("Selection: ");

        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();
        System.out.println();

        switch (choice) {
            case 1:
                carPlant = new GasCarFactory();
                break;
            case 2:
                carPlant = new ElectricCarFactory();
                break;
            default:
                System.out.println("Invalid Selection");
                carPlant = null;
                break;
        }

        if (carPlant != null) {
            Door myDoor = carPlant.buildDoor();
            Engine myEngine = carPlant.buildEngine();

            myDoor.open();
            myEngine.run();
        }
    }
}
