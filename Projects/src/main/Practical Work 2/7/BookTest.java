public class BookTest {

    public static void main(String[] args) {
        Bookshelf bookshelf = new Bookshelf(5);
        bookshelf.add(new Book("Унесённые ветром", "Маргарет Митчелл", 1936, "329742"));
        bookshelf.add(new Book("Капитанская дочка", "А. С. Пушкин", 1836, "197166"));
        bookshelf.add(new Book("Мартин Иден", "Джек Лондон", 1909, "209362"));
        bookshelf.add(new Book("Война и мир", "Л. Н. Толстой", 1863, "193581"));
        bookshelf.add(new Book("Алхимик", "Пауло Коэльо", 1988, "960178"));

        bookshelf.print();

        System.out.println("\nСамая старая книга: " + bookshelf.getOldestBook());
        System.out.println("Самая новая книга: " + bookshelf.getNewestBook());

        System.out.println("\nСортируем...\n");
        bookshelf.sort();

        bookshelf.print();
    }
}
