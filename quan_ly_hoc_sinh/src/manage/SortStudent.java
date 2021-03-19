package manage;

import models.Student;

import java.util.Comparator;

public class SortStudent implements Comparator<Student>{
    private final int typeSort;

    public SortStudent(int typeSort){
        this.typeSort = typeSort;
    }
    @Override
    public int compare(Student o1, Student o2) {
        switch (this.typeSort){
            case 1:
                return o1.getId().compareTo(o2.getId());
            case 2:
                return o1.getName().compareTo(o2.getName());
            case 3:
                return o1.getGender().compareTo(o2.getGender());
            case 4:
                int year = o1.getYearOfBirth().compareTo(o2.getYearOfBirth());
                if (year == 0){
                    int month = o1.getMonthOfBirth().compareTo(o2.getMonthOfBirth());
                    if (month == 0){
                        return o1.getDayOfBirth().compareTo(o2.getDayOfBirth());
                    }
                    return month;
                }
                return year;
            case 5:
                return o1.getNameClass().compareTo(o2.getNameClass());
            default:
                return 0;
        }
    }
}
