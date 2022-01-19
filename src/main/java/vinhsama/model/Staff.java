package vinhsama.model;

import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String maNhanVien;
    @NotEmpty(message = "ten khong duoc de trong")
    @Size(min = 3, max = 8, message = "toi thieu 2 ky tu , toi da 8 ky tu")
    private String name;
   @Min(value = 18,message = "tuoi phai lon hon 18")
   @Max(value = 35,message = "tuoi phai  nho hon 35")
    private int age;
   @NumberFormat(pattern = "45,000")
    private double salary;

    @ManyToOne
    private Branch branch;

    public Staff() {
    }

    public Staff(String maNhanVien, String name, int age, double salary, Branch branch) {
        this.maNhanVien = maNhanVien;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.branch = branch;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
