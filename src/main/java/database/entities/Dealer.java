package main.java.database.entities;

import java.util.Arrays;

public class Dealer {
    private String surname;
    private String name;
    private String patronymic;
    private byte[] photo;
    private String address;
    private String phone;
    private String login;

    public Dealer(String surname, String name, String patronymic, byte[] photo, String address, String phone, String login) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.photo = photo;
        this.address = address;
        this.phone = phone;
        this.login = login;
    }

    public Dealer(String surname, String name, String patronymic, String address, String phone, String login) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.phone = phone;
        this.login = login;
    }

    public Dealer(String surname, String name, String patronymic, String address, String phone) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.phone = phone;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getLogin() {
        return login;
    }

    public String getInfo() {
        return "Dealer{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", photo=" + Arrays.toString(photo) +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
