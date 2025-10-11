
package com.mycompany.shortp107;

import java.util.LinkedHashMap;
import java.util.Map;

public class ReservationRepository {

    private final LinkedHashMap<String, Reservation> db = new LinkedHashMap<>();

    public boolean existsId(String id) { return db.containsKey(id); }
    public Reservation get(String id) { return db.get(id); }
    public void put(Reservation r) { db.put(r.getBookingID(), r); }
    public void remove(String id) { db.remove(id); }
    public boolean isEmpty() { return db.isEmpty(); }
    public Iterable<Reservation> values() { return db.values(); }
    public Map<String, Reservation> asMap() { return db; }
}

