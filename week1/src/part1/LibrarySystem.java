package part1;

public class LibrarySystem {
    public static void main(String[] args) {
        Book b1 = new Book("B001", "Divergent", "Veronica Roth");
        Book b2 = new Book("B002", "Green Eggs and Ham", "Dr.Seuss");

        System.out.printf("The ID of the first book: %s. Its title is: %s\n", b1.getBookID(), b1.getTitle());
        System.out.printf("The ID of the second book: %s. Its title is: %s\n", b2.getBookID(), b2.getTitle());

        if (b1.borrow("m123")) {
            System.out.println("Book 1 is borrowed by m123");
        } else {
            System.out.println("Book 1 is taken");
        }

//        if (b1.returnBook()) {
//            System.out.println("Book returned");
//        } else {
//            System.out.println("Book not on loan");
//        }

        System.out.println();
        System.out.println(b1);
        System.out.println(b2);
    }
}
