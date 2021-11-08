package com.example.spring.services;

import ch.qos.logback.classic.Logger;
import com.example.spring.models.dtos.MySQLDTO;
import com.example.spring.repository.MySQLDTORepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MySQLService {

    @Autowired
    private MySQLDTORepository mySQLDTORepository;

    private static final Logger logger = (Logger) LoggerFactory.getLogger(MySQLService.class);

    @Cacheable("ehCacheMySQL")
    public String getTextSQL() {
        logger.info("Getting from MySQL");
        long id = 27;
        Optional<MySQLDTO> sql = mySQLDTORepository.findById(id);
        return sql.get().text;
    }

}
