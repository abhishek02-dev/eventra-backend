package com.eventManagement.Eventra.controller;

import com.eventManagement.Eventra.model.Event;
import com.eventManagement.Eventra.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/events")
@CrossOrigin(origins = "http://localhost:5173")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/approved")
    public List<Event> getApprovedEvents() {
        return eventService.getApprovedEvents();
    }

    @GetMapping("/pending")
    public List<Event> getPendingEvents() {
        return eventService.getPendingEvents();
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateEventStatus(
            @PathVariable("id") String eventId,
            @RequestParam("approved") boolean approved) {

        String status = approved ? "approved" : "rejected";
        Event updated = eventService.updateEventStatus(eventId, status);

        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable String id) {
        eventService.deleteEvent(id);
    }

    @GetMapping("/report")
    public Map<String, Object> getReport() {
        List<Event> allEvents = eventService.getAllEvents();
        int total = allEvents.size();
        int pending = (int) allEvents.stream().filter(e -> "pending".equals(e.getStatus())).count();
        int approved = (int) allEvents.stream().filter(e -> "approved".equals(e.getStatus())).count();

        Map<String, Object> report = new HashMap<>();
        report.put("totalEvents", total);
        report.put("pendingEvents", pending);
        report.put("approvedEvents", approved);
        return report;
    }
}

