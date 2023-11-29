public class Minions {
    private String name;
    private int age;

    private String union;

    public Minions(String name, String union, int age) {
        this.name = name;
        this.age = age;
        this.union = union;
    }

    @Override
    public String toString() {
        return "Minion{name='" + name + "', union='" + union + "', age=" + age + "}";
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUnion() {
        return union;
    }

    public void setUnion(String union) {
        this.union = union;
    }
}