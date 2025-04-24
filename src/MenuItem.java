public class MenuItem {
    private int index;
    private String name;
    private double price;
    private String description;

    public MenuItem(int index, String name, double price, String description) {
        this.index = index;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public String getName() {
        return name;
    }
    public void setName () {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice () {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription () {
        this.description = description;
    }
}
