package xyz.dev.controller;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.dev.service.ClientService;
import xyz.dev.vo.ClientVO;

@RestController
public class rootController {

    private final Logger logger =  LoggerFactory.getLogger(rootController.class);

    @Autowired
    private ClientService clientService;

    @PostMapping("/client/")
    public ResponseEntity<String> cadastrarCliente(@RequestBody String payload) {
        try {
            Gson gson = new Gson();
            ClientVO vo = gson.fromJson(payload, ClientVO.class);
            clientService.createClient(vo);

        } catch (Exception e) {
            logger.error(">>>>>>>>>>>>>> : ", e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }


}