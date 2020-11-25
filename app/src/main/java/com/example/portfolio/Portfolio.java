package com.example.portfolio;

class Portfolio {

    private int id;
    private String name;
    private String pass;
    private String phone;
    private String address;
    private String email;
    private String link;
    private String url;

    //empty constructor
    Portfolio() {}

    // Constructor with variables
    Portfolio(String name, String pass, String phone, String address, String email, String link, String url) {
        this.name = name;
        this.pass = pass;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.link = link;
        this.url = url;
    }

    // Mutator
    void setID(int id) { this.id = id; }
    void setName(String name) {this.name = name;}
    void setPass(String pass) {this.pass = pass;}
    void setPhone(String phone) {this.phone = phone;}
    void setAddress(String address) {this.address = address;}
    void setEmail(String email) {this.email = email;}
    void setLink(String link) {this.link = link;}
    void setUrl(String url) {this.url = url;}

    // Accessors
    int getID() { return this.id; }
    String getName() {return this.name;}
    String getPass() {return this.pass;}
    String getPhone() {return this.phone;}
    String getAddress() {return this.address;}
    String getEmail() {return this.email;}
    String getLink() {return this.link;}
    String getUrl() {return this.url;}
}
