package PhoneBook;

public class Main {
    public static void main(String[] args) {
        PhoneBook book = new PhoneBook();
        book.add(new Person("Арбузиков", "53-12", "arbuzikov@people.ru"));
        book.add(new Person("Бананчиков", "46-18", "bananchikov@people.ru"));
        book.add(new Person("Арбузиков", "58-68", "arbuzikovv@people.ru"));
        String name = "Арбузиков";
        System.out.printf("Поиск по фамилии %s:\n", name);
        System.out.println("Телефоны: " + book.findPhone(name));
        System.out.println("Email: " + book.findEmail(name));
    }
}
