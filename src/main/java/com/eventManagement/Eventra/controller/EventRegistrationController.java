package com.eventManagement.Eventra.controller;


import com.eventManagement.Eventra.model.EventRegistration;
import com.eventManagement.Eventra.repository.EventRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registrations")
@CrossOrigin(origins = "http://localhost:5173") // Optional if using WebConfig
public class EventRegistrationController {

    @Autowired
    private EventRegistrationRepository registrationRepo;

    // 🎟 Register for an event
    @PostMapping
    public EventRegistration register(@RequestBody EventRegistration registration) {
        return registrationRepo.save(registration);
    }

    // 📜 View all registrations by a user
    @GetMapping("/user/{userId}")
    public List<EventRegistration> getByUser(@PathVariable String userId) {
        return registrationRepo.findByUserId(userId);
    }

    // 🗃 View all registrations for an event
    @GetMapping("/event/{eventId}")
    public List<EventRegistration> getByEvent(@PathVariable String eventId) {
        return registrationRepo.findByEventId(eventId);
    }
}
