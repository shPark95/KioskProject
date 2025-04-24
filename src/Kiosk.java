import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menuList;

    public Kiosk(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int input1 = showMainMenu(sc);
            if (input1 == 0) {
                break;
            } else {
                if (!checkValidMainMenu(input1)) {
                    continue;
                }
            }

            int input2 = showSubMenu(sc, input1);
            if (input2 == 0) continue;

            boolean continueFlag = showSelectedMenu(input1 - 1, input2 - 1);
            if (!continueFlag) break;
        }

    }

    private boolean checkValidMainMenu(int input) {
        if (input < 0 || input > menuList.size()) {
            return false;
        } else {
            return true;
        }
    }

    private int showMainMenu(Scanner sc) {
        showSHAKESHACKMainMenu();
        return inputnumber(sc.next());
    }

    private int showSubMenu(Scanner sc, int input1) {
        menuList.get(input1 - 1).showMenu();
        return inputnumber(sc.next());
    }

    public int inputnumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다.");
            return -1;
        }
    }

    public void showSHAKESHACKMainMenu() {
        System.out.println("[ MAIN MENU ]");
        for (Menu menu : menuList) {
            System.out.printf("%d. %s\n", menu.getIndex(), menu.getCategory());
        }
    }

    public boolean showSelectedMenu(int input1, int input2) {
        if (input2 < menuList.get(input1).getMenuItems().size()) {
            System.out.println("==============선택한 메뉴===============");
            System.out.printf("이름 : %s\n", menuList.get(input1).getMenuItems().get(input2).getName());
            System.out.printf("가격 : %.1f\n", menuList.get(input1).getMenuItems().get(input2).getPrice());
            System.out.printf("설명 : %s\n", menuList.get(input1).getMenuItems().get(input2).getDescription());
            System.out.println();
            return true;
        } else {
            System.out.println("잘못된 숫자범위입니다.");
            return true;
        }
    }

}
