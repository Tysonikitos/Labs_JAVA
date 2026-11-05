class MyClass {
    private String s = "Hello World!";

    public String getS() {
        return s;
    }

    public void setS(String newValue) {
        s = newValue;
    }
}

public class Test {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        System.out.println(obj.getS());

        obj.setS("It's modified!");
        System.out.println(obj.getS());
    }
}