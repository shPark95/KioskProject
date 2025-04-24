import java.util.ArrayList;
import java.util.List;

public class Menu {
    private int index;
    private String category;
    private List<MenuItem> menuItems;

    public Menu(int index, String category) {
        this.index = index;
        this.category = category;
    }

    public void initializeBurgerItems() {
        menuItems = new ArrayList<>();

        MenuItem shack = new MenuItem(1, "ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 시그니처버거");
        MenuItem smoke = new MenuItem(2, "SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 스모크버거");
        MenuItem cheese = new MenuItem(3, "Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem ham = new MenuItem(4, "Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");
        menuItems.add(shack);
        menuItems.add(smoke);
        menuItems.add(cheese);
        menuItems.add(ham);
    }

    public void showMenu() {
        System.out.printf("[ %s MENU ]\n", this.category);
        try {
            for (MenuItem menuItem : menuItems) {
                System.out.printf("%d. %s | W %.1f | %s\n", menuItem.getIndex(), menuItem.getName(), menuItem.getPrice(), menuItem.getDescription());
            }
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
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}
