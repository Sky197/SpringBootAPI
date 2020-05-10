package xyz.dev.entity;

import javax.persistence.*;

@Entity(name = "CLIENT")
public class ClientEntity {

    @Id
    @Column(unique = true, name = "CLI_DOCUMENT", nullable = false)
    private String document;

    @Column(name = "CLI_PHONE", nullable = false)
    private String cellphone;

    @Column(name = "CLI_MAIL", nullable = false)
    private String mail;

    @Column(name = "CLI_NAME", nullable = false)
    private String name;

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}