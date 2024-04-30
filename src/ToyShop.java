import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class ToyShop {
    private List<Toy> toys;
    private List<Toy> prizePool;
    private Random random;
    private Scanner scanner;

    public ToyShop() {
        toys = new ArrayList<>();
        prizePool = new ArrayList<>();
        random = new Random();
        scanner = new Scanner(System.in);
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void drawPrize() {
        if (toys.isEmpty()) {
            return;
        }

        Toy selectedToy = selectToyForPrize();
        if (selectedToy != null) {
            selectedToy.setQuantity(selectedToy.getQuantity() - 1);
            prizePool.add(selectedToy);
            savePrizeToFile(selectedToy.getName());
        } else {
            System.out.println("Все игрушки закончились.");
        }
    }

    private Toy selectToyForPrize() {
        List<Toy> availableToys = new ArrayList<>();
        for (Toy toy : toys) {
            if (toy.getQuantity() > 0) {
                availableToys.add(toy);
            }
        }

        if (!availableToys.isEmpty()) {
            return availableToys.get(random.nextInt(availableToys.size()));
        } else {
            return null;
        }
    }

    private void savePrizeToFile(String toyName) {
        try (FileWriter writer = new FileWriter("prize_list.txt", true)) {
            writer.write(toyName + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Toy getPrize() {
        if (!prizePool.isEmpty()) {
            Toy prize = prizePool.remove(0);
            System.out.println("Ваш приз: " + prize.getName());
            return prize;
        } else {
            return null;
        }
    }

    public void waitForEnter() {
        System.out.println("Нажмите Enter для розыгрыша игрушки...");
        scanner.nextLine();
    }
}
