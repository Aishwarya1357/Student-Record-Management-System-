public class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return id + "," + name + "," + age;
    }

    public static Student fromString(String data) {
        String[] parts = data.split(",");
        return new Student(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]));
    }
}