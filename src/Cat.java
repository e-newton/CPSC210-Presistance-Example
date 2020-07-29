import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cat implements Serializable {
    String name;
    int age;
    List<Whisker> whiskers;
    public Cat(String name, int age){
        this.name = name;
        this.age = age;
        this.whiskers = new ArrayList<>();
        for (int i = 1; i <= 8; i++){
            this.whiskers.add(new Whisker(this.name, i));
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", whiskers=" + whiskers +
                '}';
    }
}
