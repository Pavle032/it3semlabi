import java.util.Scanner;
abstract class Animal{
    private String name;
    private int age;
    private String color;
    private static int count = 0; //brojac

    public Animal(){
        count++;
    }

    public Animal(String name, int age, String color){
        this.name = name;
        this.age = age;
        this.color = color;
        count++;
    }

    abstract void makeSound();
    abstract void eat();

    //Getters and setters
    public String getName() {return name; }
    public void setName(String name) {this.name = name; }

    public int getAge() {return age; }
    public void setAge(int age) {this.age = age;}

    public String getColor() {return color; }
    public void setColor(String color) {this.color = color;}

    public static int getCount() {return count;}
    
    //display info
    public void displayInfo(){
        System.out.println("Name: " + name + "Age: " + age + "Color:" + color);
    }
}
//class Cat
class Cat extends Animal{
    private String breed;
    //constructor
    public Cat(String name, int age, String color, String breed){
        super(name, age, color);
        this.breed = breed;
    }
    @Override
    void makeSound(){
        System.out.println(getName() + " says: Meow!");
    }
    @Override
    void eat(){
        System.out.println(getName() + " eats fish");
    }
    //specific method
    void catchMouse(){
        System.out.println(getName() + " cathes a mouse");
    }
    //getters and setters
    public String getBreed() {return breed;}
    public void setBreed(String breed) {this.breed = breed;}
}
//class Parrot
class Parrot extends Animal{
    private boolean canTalk;

    //constructor
    public Parrot(String name, int age, String color, boolean canTalk){
        super(name, age, color);
        this.canTalk = canTalk;
    }

    @Override
    void makeSound(){
        if(canTalk){
            System.out.println(getName() + " says: Hello!");
        }else{
            System.out.println(getName() + " chirps");
        }
    }
    @Override
    void eat(){
        System.out.println(getName() + " eats seeds");
    }
    
    //specific method
    void fly(){
        System.out.println(getName() + " flies");
    }

    //getters and setters
    public boolean canTalk() {return canTalk;}
    public void canTalk(boolean canTalk){this.canTalk = canTalk;}
}

//class Fish
class Fish extends Animal{
    private String waterType;

    //Constructor
    public Fish(String name, int age, String color, String waterType){
        super(name, age, color);
        this.waterType = waterType;
    }
    @Override
    void makeSound(){
        System.out.println(getName() + " makes bubbles");
    }

    @Override
    void eat(){
        System.out.println(getName() + " eats fish food");
    }
    //specific method
    void swim(){
        System.out.println(getName() + " swims");
    }
    //getters and setters
    public String getWaterType(){return waterType;}
    public void getWaterType(String waterType){this.waterType = waterType;}
}
public class Main{
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        //data input
        System.out.print("---CREATING ANIMALS---");
        //creating a cat
        System.out.print("Enter cat name:");
        String catName = scanner.nextLine();
        System.out.print("Enter cat age:");
        int catAge = scanner.nextInt();
        scanner.nextLine(); //clear buffer
        System.out.print("Enter cat color:");
        String catColor = scanner.nextLine();
        System.out.print("Enter cat breed:");
        String catBreed = scanner.nextLine();

        Animal cat = new Cat(catName, catAge, catColor, catBreed);

        //creating a parrot
        System.out.print("\nEnter parrot name: ");
        String parrotName = scanner.nextLine();
        System.out.print("Enter parrot age: ");
        int parrotAge = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter parrot color: ");
        String parrotColor = scanner.nextLine();
        System.out.print("Can parrot talk (true/false): ");
        boolean canTalk = scanner.nextBoolean();
        scanner.nextLine();

        Animal parrot = new Parrot(parrotName, parrotAge, parrotColor, canTalk);

        //creating a fish
        System.out.print("\nEnter fish name: ");
        String fishName = scanner.nextLine();
        System.out.print("Enter fish age: ");
        int fishAge = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter fish color: ");
        String fishColor = scanner.nextLine();
        System.out.print("Enter water type for fish: ");
        String waterType = scanner.nextLine();
        
        Animal fish = new Fish(fishName, fishAge, fishColor, waterType);

        //output information
        System.out.println("\n=== Animal information ===");
        cat.displayInfo();
        cat.makeSound();
        cat.eat();
        ((Cat)cat).catchMouse();

        System.out.println();
        parrot.displayInfo();
        parrot.makeSound();
        parrot.eat();
        ((Parrot)parrot).fly();

        System.out.println();
        fish.displayInfo();
        fish.makeSound();
        fish.eat();
        ((Fish)fish).swim();

        //counter demonstration
        System.out.println("\n=== Statistics ===");
        System.out.println("Total animals created: " + Animal.getCount());

        System.out.println("\n=== OOP Principles Demonstration ===");

        //Inheritance - all classes inherit from Animal
        //polymorphism - same method makeSound() works differently
        Animal[] animals = {cat, parrot, fish};
        for( Animal animal : animals){
            animal.makeSound(); //each makes his own sound
        }
        //encapsulation - using getters 
        System.out.println("\nNames of all animals");
        for(Animal animal : animals){
            System.out.println(animal.getName());
        }
        scanner.close();
    }
}