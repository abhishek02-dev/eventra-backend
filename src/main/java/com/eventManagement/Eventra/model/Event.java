package com.eventManagement.Eventra.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("events")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    private String id;
    private String title;
    private String description;
    private String date;
    private String venue;
    private String imageUrl;
    private String createdBy;
    private String status; // pending, approved, rejected

    // Ticket type info, optional
    private int totalTickets;
    private int bookedTickets;

    // Getters and Setters
}

