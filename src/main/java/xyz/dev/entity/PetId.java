package xyz.dev.entity;

import java.io.Serializable;
import java.util.Objects;

public class PetId implements Serializable {
    private String petName;
    private String clientEntity;

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(String clientEntity) {
        this.clientEntity = clientEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetId petId = (PetId) o;
        return Objects.equals(petName, petId.petName) &&
                Objects.equals(clientEntity, petId.clientEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(petName, clientEntity);
    }
}
