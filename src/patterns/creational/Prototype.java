package patterns.creational;

/**
 * Created by dvetrov on 19.03.15.
 */
public class Prototype {
    public static void main(String[] args) {
        Person firstPerson = new Person("Philli");
        Person secondPerson = firstPerson.getClone();
        System.out.println(secondPerson.getName());
    }
}

class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Person getClone() {
        return new Person(name);
    }
}
