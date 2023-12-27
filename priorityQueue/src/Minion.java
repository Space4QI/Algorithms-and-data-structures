public class Minion implements Comparable<Minion> {

    public String name;
    public int eyes;
    public int age;

    public Minion(String name, int eyes, int age) {
        this.name = name;
        this.eyes = eyes;
        this.age = age;
    }

    @Override
    public int compareTo(Minion o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return  "Миньон " + this.name + ". Кол-во глаз: " + this.eyes + ", a лет ему " + this.age;
    }
}
