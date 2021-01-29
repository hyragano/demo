package com.example.demo.serives;

import com.example.demo.dal.model.Names;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@AllArgsConstructor
@EnableScheduling
@Slf4j
public class Invoketor {
    private final NamesService service;

    @Scheduled(initialDelay = 500, fixedDelay = 10000)
    @Transactional
    public void init() {
        service.initThem();
        Collection<Names> fedors = service.findAllByName("Fedor");
        log.info("Fedors Before change names");
        fedors.forEach(name -> log.info(name.toString()));
        fedors.forEach(fedor -> fedor.setName("Alex"));
        service.save(Names.builder().name("Alex").build());
        service.deleteAllByName("Alex");
        Collection<Names> fedorsAfterDeleteAllAlexes = service.findAllByName("Fedor");
        if(fedorsAfterDeleteAllAlexes.isEmpty())
            log.info("No Fedors found");
        else {
            log.info("there all: ");
            fedors.forEach(name -> log.info(name.toString()));
        }
    }
}
