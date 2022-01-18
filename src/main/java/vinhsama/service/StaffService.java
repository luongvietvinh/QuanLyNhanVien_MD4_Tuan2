package vinhsama.service;

import org.springframework.beans.factory.annotation.Autowired;
import vinhsama.model.Staff;
import vinhsama.repository.StaffRepo;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;

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
        for (Staff s : staffRepo.findAll()) {
            if (s.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT))) {
                return s;
            }
        }
        return null;
    }

    @Override
    public List<Staff> sortsalary() {
            List<Staff> list = findAll();
            list.sort(Comparator.comparing(Staff::getSalary));
            return list;
    }
    @Override
    public List<Staff> sortage() {
            List<Staff> list = findAll();
            list.sort(Comparator.comparing(Staff::getAge));
            return list;
    }

}
