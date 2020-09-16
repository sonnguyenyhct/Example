package example;

public class FictionBook extends Book {
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public FictionBook(int bookCode, String name, long price, String author, String category) {
        super(bookCode, name, price, author);
        this.category = category;
    }
}
