package candies;

public class Order {
    private int id;
    private Client client;
    private Candy[] candies;

    int indexForCandies;

    public Order(int id, Client client, int candiesNumber) {
        this.id = id;
        this.client = client;
        this.candies = new Candy[candiesNumber];
    }

    public void addCandy(Candy candy) {
        //if (indexForCandies < candiesNumber) {
        if (indexForCandies < this.candies.length) {
            if (getTotalPrice() + candy.getDiscountedPrice() <= client.getBudget()) {
                this.candies[indexForCandies++] = candy;
                System.out.println("Candy " + candy.getName() + " was added to the order!");
            } else {
                System.out.println("Candy " + candy.getName() + " is too expensive!");
            }
        } else {
            System.out.println("Too many candies!");
        }
    }

    public void removeCandy(Candy candy) {
        for (int i = 0; i < indexForCandies; i++) {
            if (this.candies[i].equals(candy)) {
                for (int j = i; j < indexForCandies - 1; j++){
                    this.candies[j] = this.candies[j + 1];
                }
                this.candies[indexForCandies - 1] = null;
                indexForCandies--;
                System.out.println(candy.getName() + " was removed from the order!");
            }
        }
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        /*for (int i = 0; i < this.candies.length; i++) {
            if(this.candies[i] != null) {
                totalPrice += this.candies[i].getDiscountedPrice();
            }
        }*/

        for (Candy candy : this.candies) {
            if (candy != null) {
                totalPrice += candy.getDiscountedPrice();
            }
        }
        
        return totalPrice;
    }

    public void printOrder() {
        if (indexForCandies == 0) {
            System.out.println("The order is in progress!");
        } else {
            System.out.println("The candies from order " + this.id + " for client " + client.getName() + " are:");
            for (Candy candy : this.candies) {
                if (candy != null) {
                    System.out.println(candy.toString());
                }
            }
        }
    }
}
