/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import model.backing.Student;

/**
 *
 * @author woodpecker
 */
@Named(value = "tableBean")
@RequestScoped
public class TableBean {
    
    private List<Student> students;

    /**
     * Creates a new instance of TableBean
     */
    public TableBean() {
        students = new ArrayList<>();
        students.add(new Student("Adam", "Kowalski", 4.6));
        students.add(new Student("Beata", "Wiśniewska", 3.5));
        students.add(new Student("Cezary", "Wójcik", 4.86));
        students.add(new Student("Danuta", "Kowalczyk", 3.98));
        students.add(new Student("Edward", "Kamiński", 4.7));
        students.add(new Student("Franciszka", "Lewandowska", 3.74));
        students.add(new Student("Grzegorz", "Zieliński", 4.71));
        students.add(new Student("Helena", "Szymańska", 4.02));
        students.add(new Student("Ireneusz", "Dąbrowski", 3.57));
        students.add(new Student("Jolanta", "Woźniak", 3.44));
        students.add(new Student("Krzysztof", "Kozłowski", 4.21));
        students.add(new Student("Lucyna", "Jankowska", 3.41));
        students.add(new Student("Michał", "Kwatkowski", 4.56));
        students.add(new Student("Natalia", "Wojciechowska", 4.12));
        students.add(new Student("Oktawian", "Mazur", 3.64));
        students.add(new Student("Paulina", "Krawczyk", 3.51));
        students.add(new Student("Robert", "Kaczmarek", 4.18));
        students.add(new Student("Sandra", "Piotrowska", 3.91));
        students.add(new Student("Tomasz", "Grabowski", 3.9));
        students.add(new Student("Urszula", "Pawłowska", 4.4));
    }

    /**
     * @return the students
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
}
