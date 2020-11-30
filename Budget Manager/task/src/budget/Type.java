package budget;

public enum Type {
    FOOD(1, "Food"),
    CLOTHES(2, "Clothes"),
    ENTERTAINMENT(3, "Entertainment"),
    OTHER(4, "Other");

    private final int typeId;
    private final String name;

    Type(int typeId, String name) {
        this.typeId = typeId;
        this.name = name;
    }

    public static Type getTypeById(int typeId) {
        for (Type type : values()) {
            if (type.typeId == typeId) {
                return type;
            }
        }
        return null;
    }

    public static Type getTypeByName(String name) {
        for (Type type : values()) {
            if (type.name.equals(name)) {
                return type;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
}
