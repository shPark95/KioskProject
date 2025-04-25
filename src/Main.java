import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<Menu> menuList = new ArrayList<>();
        Menu menuBurgers = new Menu(1, "Burgers", "");
        Menu menuDrinks = new Menu(2, "Drinks", "");
        Menu menuDesserts = new Menu(3, "Desserts", "");
        Menu menuOrders = new Menu(4, "Orders", "장바구니를 확인 후 주문합니다.");
        Menu menuCancel = new Menu(5, "Cancel", "진행중인 주문을 취소합니다.");
        menuBurgers.initializeBurgerItems();
        menuList.add(menuBurgers);
        menuList.add(menuDrinks);
        menuList.add(menuDesserts);
        menuList.add(menuOrders);
        menuList.add(menuCancel);

        Kiosk kiosk = new Kiosk(menuList);
        kiosk.start();
    }

}