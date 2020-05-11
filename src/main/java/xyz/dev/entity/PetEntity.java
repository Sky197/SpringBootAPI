package xyz.dev.entity;

import javax.persistence.*;

@Entity
@Table(name = "PET")
public class PetEntity {

    @ManyToOne
    @JoinColumn(name = "CLI_DOCUMENT")
    private ClientEntity clientEntity;

    @Id
    @Column(name = "PET_NAME", nullable = false)
    private String name;

    @Column(name = "PET_SIZE")
    private String size;

    @Column(name = "PET_AGE")
    private String age;

    @Column(name = "PET_LAST_VACCINE")
    private String lastVaccine;

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLastVaccine() {
        return lastVaccine;
    }

    public void setLastVaccine(String lastVaccine) {
        this.lastVaccine = lastVaccine;
    }
}
