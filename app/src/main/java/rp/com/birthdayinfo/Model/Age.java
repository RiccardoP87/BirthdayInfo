package rp.com.birthdayinfo.Model;


public class Age {

    private String title;
    private String age;

    public Age(String title, String age) {
        this.title = title;
        this.age = age;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
