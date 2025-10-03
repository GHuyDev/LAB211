package management.student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentManagement {
    private List<Student> studentList = new ArrayList<>();
    
    //tối ưu, ghi thêm chỉ có duy nhất, thông tin không đc trùng nhau. Nếu trùng nhau phải nhập lại
    private boolean isDuplicate(Student s) {
        for (Student test : studentList) {
            if (test.getId().equalsIgnoreCase(s.getId())
                && test.getName().equalsIgnoreCase(s.getName())
                && test.getSemester().equalsIgnoreCase(s.getSemester())
                && test.getCourse().equalsIgnoreCase(s.getCourse())) {
                return true;
            }
        }
        return false;
    }
    
    public boolean addStudent(Student student){
        if(isDuplicate(student)) return false;
        return studentList.add(student);
    }
    
    public void displayStudent(){
        for(Student st : studentList) 
            System.out.println(st.toString());
    }
    
    public void deleteStudent(String id){
        for(Student st : studentList){
            if(st.getId().equalsIgnoreCase(id))
                studentList.remove(st);
        }
    }
    
    public void updateStudent(String id, String newName, String newSemester, String newCourse){
        for(Student st : studentList){
            if(st.getId().equalsIgnoreCase(id)){
                st.setName(newName);
                st.setSemester(newSemester);
                st.setCourse(newCourse);
            }
        }
    }
        
    public void sortStudent(){
        studentList.sort(Comparator.comparing(Student::getName));
        displayStudent();
    }
    
    public void reportStudent(){
        Map<String, Integer> report = new HashMap();
        for(Student st : studentList){
            String key = st.getId() + "|" + st.getName() + "|" +st.getCourse();
            report.put(key, report.getOrDefault(key, 0) +1);
        }
        
        for(Map.Entry<String, Integer> st : report.entrySet()){//entrySet trả vể tập
            System.out.println("");
        }
    }
        
    
}
