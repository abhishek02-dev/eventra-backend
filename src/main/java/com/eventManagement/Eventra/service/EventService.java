package com.eventManagement.Eventra.service;

import com.eventManagement.Eventra.model.Event;
import com.eventManagement.Eventra.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public Event createEvent(Event event) {
        event.setStatus("pending");
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public List<Event> getApprovedEvents() {
        return eventRepository.findByStatus("approved");
    }

    public List<Event> getPendingEvents() {
        return eventRepository.findByStatus("pending");
    }

    public Optional<Event> getEventById(String id) {
        return eventRepository.findById(id);
    }

    public void deleteEvent(String id) {
        eventRepository.deleteById(id);
    }

    public Event updateEventStatus(String eventId, String status) {
        Optional<Event> optionalEvent = eventRepository.findById(eventId);
        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();
            event.setStatus(status);
            return eventRepository.save(event);
        }
        return null;
    }
}

