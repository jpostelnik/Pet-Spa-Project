import java.util.Locale;

public class Pets {
    private boolean clean;
    private boolean trim;
    private String name;
    private int age;
    //    private String ownersName;
    private boolean in;


    public Pets(String name, int age) {
        clean = false;
        this.trim = false;
        this.name = name;
        this.age = age;
//        this.ownersName = ownersName;
        in = false;
    }

    public boolean isIn() {
        return in;
    }

    public void setIn(boolean in) {
        this.in = in;
    }

    public boolean isClean() {
        return clean;
    }

    public void setClean(boolean clean) {
        this.clean = clean;
    }

    public boolean isTrim() {
        return trim;
    }

    public void setTrim(boolean trim) {
        this.trim = trim;
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

//    public String getOwnersName() {
//        return ownersName;
//    }
//
//    public void setOwnersName(String ownersName) {
//        this.ownersName = ownersName;
//    }

    private String cleaned() {
        if (clean) {
            return "clean";
        }
        return "dirty";
    }

    private String trimmed() {
        if (trim) {
            return "trimmed";
        }
        return "shaggy";
    }

    public String toString() {
        return String.format("%8s%8s%8s", name,trimmed(),cleaned());
    }
}

