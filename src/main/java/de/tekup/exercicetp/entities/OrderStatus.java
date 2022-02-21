package de.tekup.exercicetp.entities;

public enum OrderStatus {
    CREATE(0), SHIPPING(1), DELIVERED(2), PAID(3);

    private int value;

    private OrderStatus(int value) {
        this.value = value;
    }

    public int toInt() {
        return value;
    }

    public static OrderStatus fromInt(int value) {
        switch (value) {
            case 0:
                return CREATE;

            case 1:
                return SHIPPING;

            case 2:
                return DELIVERED;

            case 3:
                return PAID;

            default:
                return CREATE;
        }

    }

}
