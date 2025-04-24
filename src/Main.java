import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static List<MenuItem> menuItems = new ArrayList<>();

    public static void main(String[] args) {
        initializeItems();

        Scanner sc = new Scanner(System.in);
        int input = 0;
        do {
            showHambergMenu();
            showSelectMenu(sc.next());
        } while (input == 0);
    }

    public static void initializeItems() {
        MenuItem shack = new MenuItem(1, "ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 시그니처버거");
        MenuItem smoke = new MenuItem(2, "SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 스모크버거");
        MenuItem cheese = new MenuItem(3, "Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem ham = new MenuItem(4, "Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");
        menuItems.add(shack);
        menuItems.add(smoke);
        menuItems.add(cheese);
        menuItems.add(ham);
    }

    public static void showSelectMenu(String input) {
        try {
            int index = Integer.parseInt(input);
            if (index >= 0 && index < menuItems.size()) {
                System.out.println("==============선택한 메뉴===============");
                System.out.printf("이름 : %s\n", menuItems.get(index).getName());
                System.out.printf("가격 : %.1f\n", menuItems.get(index).getPrice());
                System.out.printf("설명 : %s\n", menuItems.get(index).getDescription());
                System.out.println();
            } else {
                System.out.println("프로그램을 종료");
            }
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다.");
        }
    }

    public static void showHambergMenu() {
        System.out.println("[ SHAKESHACK MENU ]");
        for (MenuItem menuItem : menuItems) {
            System.out.printf("%d. %s | W %.1f | %s\n", menuItem.getIndex(), menuItem.getName(), menuItem.getPrice(), menuItem.getDescription());
        }
        System.out.println("0. 종료      | 종료");
    }
}