public class CartItem {
    private int index;
    private MenuItem item;
    private int count;

    public CartItem(int index, MenuItem item, int count) {
        this.index = index;
        this.item = item;
        this.count = count;
    }

    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public MenuItem getItem() {
        return item;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public double totalPrice() {
        return item.getPrice() * count;
    }

}
