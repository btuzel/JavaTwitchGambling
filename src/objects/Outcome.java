package objects;

public enum Outcome {
    YES,
    NO;
    public static Outcome getByName(String name) {
        try {
            return valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}