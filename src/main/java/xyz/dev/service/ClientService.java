package xyz.dev.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.dev.entity.ClientEntity;
import xyz.dev.entity.PetEntity;
import xyz.dev.repository.ClientRepository;
import xyz.dev.repository.PetRepository;
import xyz.dev.vo.ClientVO;
import xyz.dev.vo.PetVO;

import java.util.ArrayList;
import java.util.List;

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
        for (PetVO pet : clientVO.getPetList()) {
            petEntity = new PetEntity();
            petEntity.setAge(pet.getAge());
            petEntity.setLastVaccine(pet.getLastVaccine());
            petEntity.setSize(pet.getSize());
            petEntity.setPetName(pet.getName());
            petEntity.setClientEntity(clientEntity);
            petRepository.save(petEntity);

        }
    }

    public ArrayList<ClientVO> listaClientes() {
        ArrayList<ClientVO> returnList = new ArrayList<>();
        ArrayList<PetVO> petList = new ArrayList<>();

        List<ClientEntity> listEntity = clientRepository.findAll();
        for (ClientEntity s : listEntity) {
            ClientVO clientVO = new ClientVO();
            clientVO.setCellphone(s.getCellphone());
            clientVO.setDocument(s.getDocument());
            clientVO.setMail(s.getMail());
            clientVO.setName(s.getName());
            for (PetEntity petEntity : s.getPet()) {
                PetVO petVO = new PetVO();
                petVO.setSize(petEntity.getSize());
                petVO.setName(petEntity.getPetName());
                petVO.setLastVaccine(petEntity.getLastVaccine());
                petVO.setAge(petEntity.getAge());
                petList.add(petVO);
            }
            clientVO.setPetList(petList);
            returnList.add(clientVO);
        }
        return returnList;
    }
}

