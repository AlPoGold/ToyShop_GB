import java.io.FileWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ComparatorWeight c = new ComparatorWeight();
        PriorityQueue<Toy> test1 = new PriorityQueue<>(c);

        System.out.println("Please, enter information about toy: id, weight, name with space between. " +
                "When you finish, press button Enter 2 times: ");
        while(true){

            String toyString = scan.nextLine();
            if(toyString.equals("")) break;
            if (!checkValidData(toyString)){
                System.out.println("Please, reenter information about toy. Data invalid!");
                continue;
            }

            Toy toy = getToy(toyString);
            test1.add(toy);
        }


        ToyShop toyShop = new ToyShop(test1);
        try(FileWriter file = new FileWriter("answer.txt", true)){
            for (int i = 0; i < 10; i++) {
                Toy toy = toyShop.getNextToy();
                file.write(toy.getId()+" "+ toy.getName());
                file.write("\n");
            }

        }catch(Exception e){
            e.printStackTrace();

        }

    }

    private static boolean checkValidData(String toyString) {
        String[] data = toyString.split(" ");
        if(data.length<3) return false;
        try{
            int id = Integer.parseInt(data[0]);
            int weight = Integer.parseInt(data[1]);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    public static Toy getToy(String toyString) {
        String[] data = toyString.split(" ");
        Toy toy = new Toy();
        for (int i = 0; i < data.length; i++) {
            if(i==0) toy.setId(Integer.parseInt(data[i]));
            else if (i==1) {
                toy.setWeight(Integer.parseInt(data[i]));
            }else toy.setName(data[i]);

        }
        return toy;
    }

    public static Toy get(PriorityQueue<Toy> pq){
        return pq.poll();
    }


}