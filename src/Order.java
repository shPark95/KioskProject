import Enums.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Order {
    private int index;
    private String name;
    private List<CartItem> cartItems;
    private Customer role;

    public Order(int index, String name, Customer role) {
        this.index = index;
        this.name = name;
        this.role = role;
        cartItems = new ArrayList<>();
    }

    public void addItem(int index, MenuItem item, int count) {
        Optional<CartItem> existingItem = cartItems.stream()
                .filter(cartItem -> cartItem.getItem().getName().equals(item.getName()))
                .findFirst();

        if (existingItem.isPresent()) {
            CartItem tmpItem = existingItem.get();
            tmpItem.setCount(tmpItem.getCount() + count);
        } else {
            CartItem tmpItem = new CartItem(index, item, count);
            cartItems.add(tmpItem);
        }
        System.out.printf("%s 이 장바구니에 추가되었습니다.\n", item.getName());
    }

    public void removeItem(int index) {
        IntStream.range(0, cartItems.size())
                .filter(i -> i == index - 1)
                .findFirst()
                .ifPresent(i -> cartItems.remove(i));
    }

    public void decreaseItemCount(int index, int count) {
        IntStream.range(0, cartItems.size())
                .filter(i -> i == index - 1)
                .boxed()    // 기본형을 래퍼클래스로 변환 (int -> Integer) mapToObj()는 커스텀 객체로 변환 (int -> String, int -> MenuItem)
                .findFirst()
                .ifPresent(i -> {
                    CartItem tmpItem = cartItems.get(i);
                    if (tmpItem.getCount() <= count) {
                        cartItems.remove(i);
                    } else {
                        tmpItem.setCount(tmpItem.getCount() - count);
                    }
                });
    }

    public void drop() {
        cartItems.clear();
    }

    public void complete(int index) {
        double discountRate = Customer.getByIndex(index).getDiscountRate();
        double totalPrice = this.cartItems.stream().mapToDouble(CartItem::totalPrice).sum();
        System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.\n", totalPrice - totalPrice * discountRate);

        cartItems.clear();
    }

    public void showOrders() {
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
    public Customer getRole() {
        return role;
    }

}
