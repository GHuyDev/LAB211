
package shortp109;

import java.util.*;
import java.util.stream.Collectors;

public class CourseRepository {
    private final LinkedHashMap<String, Course> byId = new LinkedHashMap<>();

    public boolean existsId(String id) { return byId.containsKey(id); }
    public boolean existsName(String name) {
        for (Course c : byId.values()) {
            if (c.getCourseName().equalsIgnoreCase(name)) return true;
        }
        return false;
    }
    public void put(Course c) { byId.put(c.getCourseId(), c); }
    public Course get(String id) { return byId.get(id); }
    public void remove(String id) { byId.remove(id); }
    public boolean isEmpty() { return byId.isEmpty(); }
    public Collection<Course> all() { return byId.values(); }

    public List<OnlineCourse> allOnline() {
        return byId.values().stream()
                .filter(c -> c instanceof OnlineCourse)
                .map(c -> (OnlineCourse) c)
                .collect(Collectors.toList());
    }
    public List<OfflineCourse> allOffline() {
        return byId.values().stream()
                .filter(c -> c instanceof OfflineCourse)
                .map(c -> (OfflineCourse) c)
                .collect(Collectors.toList());
    }

    public List<Course> findByNameContains(String keyword) {
        String k = keyword.toLowerCase();
        return byId.values().stream()
                .filter(c -> c.getCourseName().toLowerCase().contains(k))
                .collect(Collectors.toList());
    }
}

