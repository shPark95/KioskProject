import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<Menu> menuList = new ArrayList<>();
        Menu menuBurgers = new Menu(1, "Burgers");
        Menu menuDrinks = new Menu(2, "Drinks");
        Menu menuDesserts = new Menu(3, "Desserts");
        menuBurgers.initializeBurgerItems();
        menuList.add(menuBurgers);
        menuList.add(menuDrinks);
        menuList.add(menuDesserts);

        Kiosk kiosk = new Kiosk(menuList);
        kiosk.start();
    }

}