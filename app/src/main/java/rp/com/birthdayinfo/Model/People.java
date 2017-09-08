package rp.com.birthdayinfo.Model;



public class People {

    private String name,surname,eta;
    private int image;

    public People(String name, String surname, String eta, int image) {
        this.name = name;
        this.surname = surname;
        this.eta = eta;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
