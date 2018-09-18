package cn.summerwaves.model;

import cn.summerwaves.util.StudentSexConvert;
import com.github.crab2died.annotation.ExcelField;

public class StudentExcel {
    @ExcelField(title = "学号", order = 1)
    private String number;

    @ExcelField(title = "姓名", order = 2)
    private String name;

    @ExcelField(title = "性别", order = 3,readConverter = StudentSexConvert.class)
    private Integer sex;

    @ExcelField(title = "班级", order = 4)
    private Integer grade;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "StudentExcel{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", grade=" + grade +
                '}';
    }
}
