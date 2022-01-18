package vinhsama.service;

import vinhsama.model.Staff;

import java.util.List;

public interface IStaffService {

    public List<Staff> findAll();
    public void save(Staff staff);
    public void delete(long id);
    public Staff findById(long id);
    public Staff findByName (String name);
    public List<Staff> sortsalary();
    public List<Staff> sortage();

}
