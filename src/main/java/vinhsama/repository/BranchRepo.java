package vinhsama.repository;

import org.springframework.data.repository.CrudRepository;
import vinhsama.model.Branch;

public interface BranchRepo extends CrudRepository<Branch , Long> {
}
