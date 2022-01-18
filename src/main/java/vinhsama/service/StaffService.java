package vinhsama.service;

import org.springframework.beans.factory.annotation.Autowired;
import vinhsama.model.Staff;
import vinhsama.repository.StaffRepo;

import java.util.List;

public class StaffService implements IStaffService{
    @Autowired
    StaffRepo staffRepo;
    @Override
    public List<Staff> findAll() {
        return (List<Staff>) staffRepo.findAll();
    }

    @Override
    public void save(Staff staff) {
    staffRepo.save(staff);
    }

    @Override
    public void delete(long id) {
    staffRepo.deleteById(id);
    }

    @Override
    public Staff findById(long id) {
        return staffRepo.findById(id).get();
    }

    @Override
    public Staff findByName(String name) {
        return null;
    }
}
