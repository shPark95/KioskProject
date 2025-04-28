package Enums;

import java.util.stream.Stream;

public enum Customer {
    HONOREE(1, "국가유공자", 0.10),
    SOLDIER(2, "군인", 0.05),
    STUDENT(3, "학생", 0.03),
    NORMAL(4, "일반인", 0.00);

    private final int index;
    private final String role;
    private final double discountRate;

    Customer(int index, String role, double discountRate) {
        this.index = index;
        this.role = role;
        this.discountRate = discountRate;
    }

    public static Customer getByIndex(int index) {
        for (Customer customer : values()) {
            if (customer.getIndex() == index) {
                return customer;
            }
        }
        // 유효하지 않은 index인 경우
        return NORMAL;
    }

    public static Customer getByRole(String role) {
        return Stream.of(Customer.values())
                .filter(x->x.role.equals(role))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Cannot Find Customer By Role: " + role));
    }

    public int getIndex() {
        return index;
    }
    public String getRole() {
        return role;
    }
    public double getDiscountRate() {
        return discountRate;
    }
}
