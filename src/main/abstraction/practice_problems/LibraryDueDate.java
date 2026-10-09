package practice_problems;

import java.time.LocalDate;
import java.util.Scanner;

abstract class LibraryItem {
    String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int getLoanPeriod();

    LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26)
                .plusDays(getLoanPeriod());
    }
}

class BookItem extends LibraryItem {
    BookItem(String title) {
        super(title);
    }

    int getLoanPeriod() {
        return 14;
    }
}

class DVDItem extends LibraryItem {
    DVDItem(String title) {
        super(title);
    }

    int getLoanPeriod() {
        return 7;
    }
}

class MagazineItem extends LibraryItem {
    MagazineItem(String title) {
        super(title);
    }

    int getLoanPeriod() {
        return 3;
    }
}

public class LibraryDueDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        LibraryItem[] items = new LibraryItem[n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String type = line.substring(0, line.indexOf(' '));
            String title = line.substring(line.indexOf(' ') + 1)
                    .replace("\"", "");

            switch (type.toUpperCase()) {
                case "BOOK":
                    items[i] = new BookItem(title);
                    break;
                case "DVD":
                    items[i] = new DVDItem(title);
                    break;
                case "MAGAZINE":
                    items[i] = new MagazineItem(title);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown item type");
            }
        }

        for (LibraryItem item : items) {
            System.out.println(item.title + ": " + item.getDueDate());
        }

        sc.close();
    }
}