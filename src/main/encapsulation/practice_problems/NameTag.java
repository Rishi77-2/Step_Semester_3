package practice_problems;

public class NameTag {
    private final String firstName;
    private final String lastInitial;

    public NameTag(String fullName) {
        String[] parts = fullName.split(" ");
        firstName = parts[0];
        lastInitial = parts[1].substring(0, 1);
    }

    public String getNickname() {
        return firstName + " " + lastInitial + ".";
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");

        System.out.println(tag.getNickname());
    }
}