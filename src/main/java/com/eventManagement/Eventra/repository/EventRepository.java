package com.eventManagement.Eventra.repository;

import com.eventManagement.Eventra.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface EventRepository extends MongoRepository<Event, String> {
    List<Event> findByStatus(String status);
    List<Event> findByCreatedBy(String userId);
}

