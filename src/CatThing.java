import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatThing {
    public static final String fileName = "catFile";
    ArrayList<Cat> cats;
    Scanner scanner = new Scanner(System.in);

    public CatThing(){
        cats = new ArrayList<>();
        System.out.println("Welcome to Cat Thing!");
        menu();
    }

    public void printCurrentCats(){
        System.out.println("Your current Cats Are: ");
        for(Cat c: cats){
            System.out.println(c);
        }

    }



    public void menu(){
        while(true) {


            System.out.println("Press A to add a new cat");
            System.out.println("Press V to view all cats");
            System.out.println("Press S to save all cats");
            System.out.println("Press L to load save file");
            System.out.println("Press E to exit");
            String choice = scanner.nextLine();
            if (choice.equals("A")) {
                addCat();
                printCurrentCats();
            } else if (choice.equals("V")) {
                printCurrentCats();
            } else if (choice.equals("S")) {
                saveCats();
            } else if (choice.equals("L")) {
                loadCats();
            } else if(choice.equals("E")){
                saveCats();
                break;
            } else {
                printCurrentCats();
            }
        }
    }

    private void addCat() {
        System.out.print("Enter cat's name: ");
        String name = scanner.nextLine();
        System.out.println();
        System.out.print("Enter cat's age: ");
        int age = scanner.nextInt();
        System.out.println();
        cats.add(new Cat(name,age));
    }

    private void saveCats() {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(cats);
            oos.close();
        } catch (Exception e){
            System.out.println("Something went wrong! :(");
        }
    }

    private void loadCats() {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            cats = (ArrayList<Cat>) ois.readObject();
            ois.close();
        } catch (Exception e){
            System.out.println("Something went wrong! :(");
        }
    }


}
