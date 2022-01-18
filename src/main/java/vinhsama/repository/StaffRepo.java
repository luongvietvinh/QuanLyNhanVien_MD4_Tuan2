package vinhsama.repository;

import org.springframework.data.repository.CrudRepository;
import vinhsama.model.Staff;

public interface StaffRepo extends CrudRepository<Staff , Long> {
}
