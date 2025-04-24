import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<MenuItem> menuItems;

    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            showHambergMenu();
            flag = showSelectedMenu(sc.next());
        }
    }

    public boolean showSelectedMenu(String input) {
        try {
            int index = Integer.parseInt(input);
            if (index == 0) {
                System.out.println("프로그램을 종료");
                return false;
            } else if (index < menuItems.size()) {
                System.out.println("==============선택한 메뉴===============");
                System.out.printf("이름 : %s\n", menuItems.get(index).getName());
                System.out.printf("가격 : %.1f\n", menuItems.get(index).getPrice());
                System.out.printf("설명 : %s\n", menuItems.get(index).getDescription());
                System.out.println();
                return true;
            } else {
                System.out.println("잘못된 숫자범위입니다.");
                return true;
            }
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다.");
            return true;
        }
    }

    public void showHambergMenu() {
        System.out.println("[ SHAKESHACK MENU ]");
        for (MenuItem menuItem : menuItems) {
            System.out.printf("%d. %s | W %.1f | %s\n", menuItem.getIndex(), menuItem.getName(), menuItem.getPrice(), menuItem.getDescription());
        }
        System.out.println("0. 종료      | 종료");
    }
}
