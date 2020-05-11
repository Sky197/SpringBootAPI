package xyz.dev.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.dev.entity.ClientEntity;
import xyz.dev.entity.PetEntity;
import xyz.dev.repository.ClientRepository;
import xyz.dev.repository.PetRepository;
import xyz.dev.vo.ClientVO;
import xyz.dev.vo.PetVO;

@Service
public class ClientService {
    private final Logger logger = LoggerFactory.getLogger(ClientService.class);

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PetRepository petRepository;

    private ClientEntity clientEntity;
    private PetEntity petEntity;

    public void createClient(ClientVO clientVO) {

        clientEntity = new ClientEntity();
        clientEntity.setName(clientVO.getName());
        clientEntity.setMail(clientVO.getMail());
        clientEntity.setDocument(clientVO.getDocument());
        clientEntity.setCellphone(clientVO.getCellphone());
        clientRepository.save(clientEntity);
        logger.info("[createClient]: " + clientVO.getName() + " salvo com sucesso ");

        for (PetVO pet : clientVO.getPetList()) {
            petEntity = new PetEntity();
            petEntity.setAge(pet.getAge());
            petEntity.setLastVaccine(pet.getLastVaccine());
            petEntity.setName(pet.getName());
            petEntity.setSize(pet.getSize());
            petEntity.setClientEntity(clientEntity);
            petRepository.save(petEntity);
            logger.info("[savePet]: " + pet.getName() + " salvo com sucesso ");

        }


    }

}

