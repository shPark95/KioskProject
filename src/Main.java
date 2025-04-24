import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<>();
        initializeItems(menuItems);

        Kiosk kiosk = new Kiosk(menuItems);
        kiosk.start();
    }

    public static void initializeItems(List<MenuItem> menuItems) {
        MenuItem shack = new MenuItem(1, "ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 시그니처버거");
        MenuItem smoke = new MenuItem(2, "SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 스모크버거");
        MenuItem cheese = new MenuItem(3, "Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem ham = new MenuItem(4, "Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");
        menuItems.add(shack);
        menuItems.add(smoke);
        menuItems.add(cheese);
        menuItems.add(ham);
    }
}