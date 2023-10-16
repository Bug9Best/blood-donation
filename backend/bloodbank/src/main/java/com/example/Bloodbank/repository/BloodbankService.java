package com.example.Bloodbank.repository;

import com.example.Bloodbank.pojo.Bloodbank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodbankService {
    private final BloodbankRepository repository;

    @Autowired
    public BloodbankService(BloodbankRepository repository) {
        this.repository = repository;
    }

    @Cacheable(value="bloodbankList")
    public List<Bloodbank> retrieveBloodbanks(){
        return repository.findAll();
    }

    @Cacheable(value="bloodbank", key="#id")
    public Bloodbank retrieveBloodbankByID(String id) {
        return repository.findByID(id);
    }

    @CachePut(value="bloodbank", key="#bloodbank.getName()")
    @CacheEvict(value="bloodbankList", allEntries=true)
    public Bloodbank createBloodbank(Bloodbank bloodbank) {
        return repository.save(bloodbank);
    }

    @CachePut(value="bloodbank", key="#bloodbank.getName()")
    @CacheEvict(value="bloodbankList", allEntries=true)
    public Bloodbank updateBloodbank(Bloodbank bloodbank) {
        return repository.save(bloodbank);
    }

    @CacheEvict(value="bloodbank", key="#bloodbank.getName()")
    @Caching(evict={ @CacheEvict(value="bloodbankList", allEntries=true) })
    public boolean deleteBloodbank(Bloodbank bloodbank) {
        try {
            repository.delete(bloodbank);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
