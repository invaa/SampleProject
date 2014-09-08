package com.diosoft.trsine.calendar.datastore;

import com.diosoft.trsine.calendar.common.Event;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface DataStore {
//    Map<UUID,Event>
//    Map<String, List<UUID>>
//    Map<Date, List<UUID>>

    void add(Event event);
    void remove(UUID id);
    List<Event> searchByDescription(String description);
    List<Event> searchByTitle(String title);
    List<Event> searchByDay(Date day);

}
