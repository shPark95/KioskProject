import Enums.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menuList;
    private Order order = new Order(1, "홍길동", Customer.getByRole("일반인"));

    public Kiosk(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        int itemcnt = 0;

        while (true) {
            try {
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

                boolean orderFlag = showSelectedMenu(input1 - 1, input2 - 1);
                if (!orderFlag) continue;

                int input3 = showOrderMenu(sc);
                if (input3 == 1) {
                    int cnt = showRequestCountOrder(sc);
                    if (cnt <= 0) continue;
                    order.addItem(itemcnt + 1, menuList.get(input1 - 1).getMenuItems().get(input2 - 1), cnt);
                    itemcnt++;
                }

                int input4 = showRequestFinal(sc);
                if (input4 == 1) {
                    int input5 = showDiscountInfo(sc);
                    order.complete(input5);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

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
        System.out.println();
        showORDERMainMenu();
        return inputnumber(sc.next());
    }

    private int showSubMenu(Scanner sc, int input1) {
        if (input1 < 4) {
            menuList.get(input1 - 1).showMenu();
        } else if (input1 == 4) {
            if (order.getCartItems().isEmpty()) {
                throw new IllegalArgumentException("장바구니가 비어있습니다.");
            }
            return handleOrders(sc);
        } else if (input1 == menuList.size()) {
            if (order.getCartItems().isEmpty()) {
                throw new IllegalArgumentException("장바구니가 비어있습니다.");
            }
            return handleCancelOrders(sc);
        }
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
            if (menu.getIndex() < 4) {
                System.out.printf("%d. %s\n", menu.getIndex(), menu.getCategory());
            }
        }
    }
    public void showORDERMainMenu() {
        if (!order.getCartItems().isEmpty()) {
            System.out.println("[ ORDER MENU ]");
            for (Menu menu : menuList) {
                if (menu.getIndex() >= 4) {
                    System.out.printf("%d. %s    | %s\n", menu.getIndex(), menu.getCategory(), menu.getDescription());
                }
            }
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
            return false;
        }
    }

    public int showOrderMenu(Scanner sc) {
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인    2. 취소");
        return inputnumber(sc.next());
    }

    public int showRequestCountOrder(Scanner sc) {
        System.out.println("원하시는 수량을 입력해주세요.");
        return inputnumber(sc.next());
    }

    public int showRequestFinal(Scanner sc) {
        System.out.println("1. 주문    2. 메뉴판");
        return inputnumber(sc.next());
    }

    public int showDiscountInfo(Scanner sc) {
        System.out.println("할인 정보를 입력해주세요.");
        Arrays.stream(Customer.values())
                .forEach(x -> System.out.printf("%d. %s : %.0f%% 할인\n", x.getIndex(), x.getRole(), x.getDiscountRate() * 100));
        return inputnumber(sc.next());
    }

    public int handleOrders(Scanner sc) {
        System.out.println("아래와 같이 주문 하시겠습니까?");
        order.showOrders();

        System.out.println("1. 주문     2. 메뉴판");
        int input = inputnumber(sc.next());
        if (input == 1) {
            order.drop();
        }
        return 0;
    }

    public int handleCancelOrders(Scanner sc) {
        System.out.println("취소할 항목 번호를 입력하세요.");
        order.showOrders();
        int input = inputnumber(sc.next());

        if (input == 0) {
            return 0;
        } else if (input > 0 && input < order.getCartItems().size()) {
            System.out.println("1. 전체 삭제     2. 일부 취소");
            int input2 = inputnumber(sc.next());

            if (input2 == 1) {
                order.removeItem(input);
            } else if (input2 == 2) {
                System.out.println("취소할 수량을 입력하세요");
                int count = inputnumber(sc.next());
                order.decreaseItemCount(input, count);
            }
            return 0;
        } else {
            System.out.println("잘못된 입력입니다.");
            return handleCancelOrders(sc);
        }
    }
}
