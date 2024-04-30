import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToyShop toyShop = new ToyShop();

        toyShop.addToy(new Toy("Кукла", 2));
        toyShop.addToy(new Toy("Машинка", 3));
        toyShop.addToy(new Toy("Мяч", 1));

        while (true) {
            toyShop.waitForEnter();
            toyShop.drawPrize();
            if (toyShop.getPrize() == null) {
                break;
            }
        }
    }
}
