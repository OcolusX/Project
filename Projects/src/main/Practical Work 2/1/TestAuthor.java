public class TestAuthor {

    public static void main(String[] args) {
        Author author = new Author("Дмитрий", "melchakow.d@mail.ru", 'M');
        System.out.println(author.toString());

        author.setEmail("XXX@mail.ru");
        System.out.println("\nНовая почта: " + author.getEmail());
    }

}
