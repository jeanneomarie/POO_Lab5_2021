package candies;

public class Candy {
    private String name;
    private double price;
    private Discount discount;

    public Candy(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public double getDiscountedPrice() {
        if (this.discount != null) {
            if (discount.equals(Discount.CHRISTMAS)) {
                return this.price * .75;
            } else if (discount.equals(Discount.EASTER)) {
                return this.price * .80;
            } else if (discount.equals(Discount.FIFTY_PERCENT)) {
                return this.price * .50;
            }
        }
        return this.price;
    }

    @Override
    public boolean equals(Object o) {
        Candy that = (Candy) o;
        return this.name.equals(that.name) && this.price == that.price;
    }

    @Override
    public String toString() {
        return "Candy {" +
                "name='" + name + '\'' +
                ", price=" + price + '}';
    }
}
