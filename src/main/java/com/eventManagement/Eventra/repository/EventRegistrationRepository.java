package com.eventManagement.Eventra.repository;

import com.eventManagement.Eventra.model.EventRegistration;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EventRegistrationRepository extends MongoRepository<EventRegistration, String> {
    List<EventRegistration> findByUserId(String userId);
    List<EventRegistration> findByEventId(String eventId);
}
