package xyz.dev.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.dev.controller.rootController;
import xyz.dev.entity.ClientEntity;
import xyz.dev.repository.ClientRepository;
import xyz.dev.vo.ClientVO;

@Service
public class ClientService {

    private final Logger logger = LoggerFactory.getLogger(ClientService.class);

    @Autowired
    private ClientRepository clientRepository;

    private ClientEntity clientEntity;

    public void createClient(ClientVO clientVO) {
        clientEntity = new ClientEntity();
        clientEntity.setName(clientVO.getName());
        clientEntity.setMail(clientVO.getMail());
        clientEntity.setDocument(clientVO.getDocument());
        clientEntity.setCellphone(clientVO.getCellphone());

        clientRepository.save(clientEntity);
        logger.info("[ClientService]  : createClient: " + clientVO.getName() + "salvo com sucesso ");
    }
}

