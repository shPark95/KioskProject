import java.util.ArrayList;
import java.util.List;

public class Order {
    private int index;
    private String name;
    private List<CartItem> cartItems;

    public Order(int index, String name) {
        this.index = index;
        this.name = name;
        cartItems = new ArrayList<>();
    }

    public void addItem(int index, MenuItem item, int count) {
        System.out.printf("%s 이 장바구니에 추가되었습니다.\n", item.getName());
        CartItem tmp = new CartItem(index, item, count);
        cartItems.add(tmp);
    }

    public void drop() {
        cartItems.clear();
    }

    public void complete() {
        cartItems.clear();
    }

    public void showOrders() {
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println();
        System.out.printf("[ %s's Orders ]\n", this.name);
        try {
            for (CartItem cartItem : cartItems) {
                System.out.printf(
                        "%d. %s | W %.1f | count %d | %s\n",
                        cartItem.getIndex(),
                        cartItem.getItem().getName(),
                        cartItem.getItem().getPrice(),
                        cartItem.getCount(),
                        cartItem.getItem().getDescription());
            }
            System.out.println();
            System.out.println("[ Total ]");
            System.out.printf(
                    "W %.1f\n",
                    this.cartItems.stream().mapToDouble(CartItem::totalPrice).sum());
        } catch (Exception e) {
            System.out.println("메뉴가 없습니다.");
        } finally {
            System.out.println("0. 종료      | 종료");
        }
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
    public void setName(String name) {
        this.name = name;
    }
    public List<CartItem> getCartItems() {
        return cartItems;
    }
}
