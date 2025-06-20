package com.eventManagement.Eventra.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "event_registrations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventRegistration {

    @Id
    private String id;
    private String userId;
    private String eventId;
    private String name;
    private String email;
    private int tickets;

}
