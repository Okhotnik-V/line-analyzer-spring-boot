package com.example.spring.services;

import com.example.spring.models.dtos.MongoDBDTO;
import com.example.spring.repository.MongoDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Service
public class MongoDBService {

    @Autowired
    private MongoDBRepository mongoDBRepository;

    private static final Logger logger = (Logger) LoggerFactory.getLogger(MongoDBService.class);

    @Cacheable("ehCacheMongoDB")
    public String getTextMongo() {
        logger.info("Getting from MongoDB");
        Optional<MongoDBDTO> mongoOptional = mongoDBRepository.findById("618525f61f0b795a8cd78de8");
        return mongoOptional.get().textMongoDB;
    }
}
