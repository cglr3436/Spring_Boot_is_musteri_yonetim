package com.javainuse.model;

import java.util.List;

import com.javainuse.data.JopRepository;
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JopService {
    @Autowired
    JopRepository repo;

    public void save(Jop jop) {
        repo.save(jop);
    }

    public List<Jop> listAll() {
        return (List<Jop>) repo.findAll();
    }

    public Jop get(Long id) {
        return repo.findOne(id);
    }

    public void delete(Long id) {
        repo.delete(id);
    }

    public List<Jop> search(String keyword) {
        return repo.search(keyword);
    }
}
