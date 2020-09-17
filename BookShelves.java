package example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookShelves {
    public static void main(String[] args) {

        List<Book> bookList = new ArrayList<>();

        bookList.add(new ProgrammingBook(1,"Java",100000,"James","java","Spring"));
        bookList.add(new ProgrammingBook(2,"Php",90000,"Harry","php","laravel"));
        bookList.add(new ProgrammingBook(3,"Javascript",80000,"Brendan","javascript","Angular"));
        bookList.add(new ProgrammingBook(4,"Python",70000,"David","python","Django"));
        bookList.add(new ProgrammingBook(5,"Ruby",60000,"Yukihiro","ruby","Ruby on Rails"));
        bookList.add(new FictionBook(6,"Black Memory",120000,"Jennifer Egan","Fiction"));
        bookList.add(new FictionBook(7,"My Brilliant Friend",30000,"Elena Ferrante","Fiction"));
        bookList.add(new FictionBook(8,"Gone Girl",50000,"Gillian Flynn","Fiction"));
        bookList.add(new FictionBook(9,"The Testaments",80000,"Margret Atwood","Fiction"));
        bookList.add(new FictionBook(10,"The Silent Patient",60000,"Alex Michaelides","Fiction"));

        //Tổng tiền.
        long total = 0;
        for (Book book : bookList) {
            total += book.getPrice();
        }
        System.out.println("Tổng tiền là : " + total);

        //đếm số sách ProgrammingBook có language là "Java"
        int count = 0;

        for (Book book : bookList) {
            boolean check1 = book instanceof ProgrammingBook;
            if (check1) {
                if (((ProgrammingBook) book).getLanguage().equals("java")) {
                    count++;
                }
            }
        }
        System.out.println("Số sách ProgrammingBook có language là Java là : " + count);

        //Tìm kiếm giá của cuốn sách có tên được nhập vào từ bàn phím theo tìm kiếm tuần tự
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào tên cuốn sách ");
        String nameBook = scanner.nextLine();
        boolean check = false;
        for (Book book : bookList) {
            if (nameBook.equals(book.getName())) {
                System.out.println("Giá của cuốn sách " + book.getName() + " là : " + book.getPrice());
                check = true;
            }
        }
        if (!check){
            System.out.println("Không tìm thấy sách");
        }

        // Sắp xếp thư viện theo giá sách.
        //Nổi bọt.
        Book swap;
        for (int j = 0; j < bookList.size()-1; j++){
            for (int i = 0; i < bookList.size()-1-j; i++){
                if (bookList.get(i).getPrice() > bookList.get(i+1).getPrice()){
                    swap = bookList.get(i);
                    bookList.set(i,bookList.get(i+1));
                    bookList.set(i+1,swap);
                }
            }
        }

        for (Book book : bookList) {
            System.out.print(book.getPrice() + " , ");
        }

        // Sắp xếp chọn.
        for (int i = 0;i < bookList.size(); i++){
            int a = 0;
            long min = bookList.get(i).getPrice();
            for (int j = i; j < bookList.size(); j++) {
                if (min >= bookList.get(j).getPrice()) {
                    min = bookList.get(j).getPrice();
                    a = j;
                }
            }
            swap = bookList.get(i);
            bookList.set(i,bookList.get(a));
            bookList.set(a,swap);
        }
        System.out.println();
        for (Book book : bookList) {
            System.out.print(book.getPrice() + " , ");
        }

        //Sắp xếp chèn.
        for (int i = 0; i < bookList.size()-1;i++){
            if (bookList.get(i).getPrice() < bookList.get(i+1).getPrice()){
                for (int j = i; j >= 0; j--){
                    if (bookList.get(j).getPrice() < bookList.get(j+1).getPrice()){
                        swap = bookList.get(j);
                        bookList.set(j,bookList.get(j+1));
                        bookList.set(j+1,swap);
                    }
                }
            }
        }

        System.out.println();
        for (Book book : bookList) {
            System.out.print(book.getPrice() + " , ");
        }

        //Tìm kiếm tên của cuốn sách có giá được nhập vào từ bàn phím theo tìm kiếm nhị phân.

        System.out.println();
        System.out.println("Nhập vào giá cuốn sách cần tìm");
        double price = scanner.nextDouble();

        BookShelves bookShelves = new BookShelves();
        int index = bookShelves.findPriceBook(bookList,0,bookList.size()-1,price);
        if (index != -1){
            System.out.println("Sách có giá tiền : " + price + " là : " + bookList.get(index).getName());
        }else {
            System.out.println("Không tìm thấy sách.");
        }

    }

    public int findPriceBook(List<Book> bookList,int left, int right, double price) {
        if (right >= left){
            int mid = (right + left)/2;
            if (bookList.get(mid).getPrice() == price){
                return mid;
            }else if (bookList.get(mid).getPrice() < price){
                return findPriceBook(bookList,left,mid-1,price);
            }else{
                return findPriceBook(bookList,mid+1,right,price);
            }
        }else {
            return -1;
        }
    }
}
