package com.example.demo.serives;

import com.example.demo.dal.model.Names;
import com.example.demo.repositories.NamesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Collection;
import java.util.Collections;

import static java.util.Collections.emptyList;

@Service
@AllArgsConstructor
//@Transactional
//@Transactional(propagation = Propagation.REQUIRES_NEW)
public class NamesService {
    private final NamesRepository repository;

    public void initThem() {
        repository.save(Names.builder().name("Alex").build());
        repository.save(Names.builder().name("Alex").build());
        repository.save(Names.builder().name("Alex").build());
        repository.save(Names.builder().name("Alex").build());
        repository.save(Names.builder().name("Alex").build());
        repository.save(Names.builder().name("Fedor").build());
    }

    public Collection<Names> findAllByName(String name) {
        return repository.findAllByName(name).orElse(emptyList());
    }
    public void deleteAllByName(String name) {
        repository.deleteAllByName(name);
    }

    @PreDestroy
    public void destroy() {
        repository.deleteAll();
    }

    public void save(Names names) {
        repository.save(names);
    }

}
