package example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookShelves {
    public static void main(String[] args) {
        ProgrammingBook java = new ProgrammingBook(1,"Java",100000,"James","java","Spring");
        ProgrammingBook php = new ProgrammingBook(2,"PHP",90000,"Harry","java","laravel");
        ProgrammingBook javascript = new ProgrammingBook(3,"Javascript",80000,"Brendan","javascript","Angular");
        ProgrammingBook python = new ProgrammingBook(4,"Python",70000,"David","python","Django");
        ProgrammingBook ruby = new ProgrammingBook(5,"Ruby",60000,"Yukihiro","ruby","Ruby on Rails");

        FictionBook blackMemory = new FictionBook(6,"Black Memory",120000,"Jennifer Egan","Fiction");
        FictionBook myBrilliantFriend = new FictionBook(7,"My Brilliant Friend",30000,"Elena Ferrante","Fiction");
        FictionBook goneGirl = new FictionBook(8,"Gone Girl",50000,"Gillian Flynn","Fiction");
        FictionBook theTestaments = new FictionBook(9,"The Testaments",80000,"Margret Atwood","Fiction");
        FictionBook theSilentPatient = new FictionBook(10,"The Silent Patient",60000,"Alex Michaelides","Fiction");

        List<Book> bookList = new ArrayList<>();
        List<ProgrammingBook> programmingBookList = new ArrayList<>();
        List<FictionBook> fictionBookList = new ArrayList<>();
        programmingBookList.add(java);
        programmingBookList.add(php);
        programmingBookList.add(javascript);
        programmingBookList.add(python);
        programmingBookList.add(ruby);
        fictionBookList.add(blackMemory);
        fictionBookList.add(myBrilliantFriend);
        fictionBookList.add(goneGirl);
        fictionBookList.add(theTestaments);
        fictionBookList.add(theSilentPatient);
        bookList.addAll(programmingBookList);
        bookList.addAll(fictionBookList);


        //Tổng tiền.
        long total = 0;
        for (Book book : bookList) {
            total += book.getPrice();
        }
        System.out.println("Tổng tiền là : " + total);

        //đếm số sách ProgrammingBook có language là "Java"
        int count = 0;

        for (ProgrammingBook programmingBook : programmingBookList) {
            if (programmingBook.getLanguage().equals("java")){
                count++;
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

        //Tìm kiếm giá của cuốn sách có tên được nhập vào từ bán phím theo tìm kiếm nhị phân.

        System.out.println("Nhập vào tên cuốn sách cần tìm");
        String nameBook1 = scanner.nextLine();
        int i = bookList.size();

        for (Book book : bookList) {
            System.out.println(book.getName());
        }

    }
}
