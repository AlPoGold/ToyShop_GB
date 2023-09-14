import java.util.PriorityQueue;
import java.util.Random;


public class ToyShop {
    private final PriorityQueue<Toy> allToys = new PriorityQueue<>();
    private int totalWeight = 0;
    private final Random r = new Random();

    public ToyShop(PriorityQueue toys) {
        setQueue(toys);
    }

    private void setQueue(PriorityQueue toys) {
        allToys.addAll(toys);
        for (Toy toy: allToys
        ) {
            totalWeight+=toy.getWeight();
        }
    }

    public Toy getNextToy() {
        if (allToys.isEmpty()) return null;

        int randInt = r.nextInt(1, totalWeight+1);
        Toy chosenToy = null;
        int currentWeight = 0;

        for (Toy toy : allToys) {
            currentWeight += toy.getWeight();
            if (currentWeight >= randInt) {
                chosenToy = toy;
                break;
            }
        }
        return chosenToy;
    }
}


