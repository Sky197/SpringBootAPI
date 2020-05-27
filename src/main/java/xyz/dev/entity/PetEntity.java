package xyz.dev.entity;

import javax.persistence.*;

@Entity
@IdClass(PetId.class)
@Table(name = "PET")
public class PetEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "CLI_DOCUMENT", referencedColumnName = "CLI_DOCUMENT")
    private ClientEntity clientEntity;

    @Column(name = "PET_LAST_VACCINE")
    private String lastVaccine;

    @Column(name = "PET_SIZE")
    private String size;

    @Column(name = "PET_AGE")
    private String age;

    @Id
    @Column(name = "PET_NAME", nullable = false)
    private String petName;


    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    public String getLastVaccine() {
        return lastVaccine;
    }

    public void setLastVaccine(String lastVaccine) {
        this.lastVaccine = lastVaccine;
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

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }
}
