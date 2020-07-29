import java.io.Serializable;

public class Whisker implements Serializable {
    String owner;
    int number;

    public Whisker(String owner, int number) {
        this.owner = owner;
        this.number = number;
    }

    @Override
    public String toString() {
        return owner +"'s " + number +"th whisker!";
    }
}
