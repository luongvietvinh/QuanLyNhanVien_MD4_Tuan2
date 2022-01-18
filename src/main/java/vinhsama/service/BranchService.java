package vinhsama.service;

import org.springframework.beans.factory.annotation.Autowired;
import vinhsama.model.Branch;
import vinhsama.repository.BranchRepo;

import java.util.List;

public class BranchService implements IBranchService{
    @Autowired
    BranchRepo branchRepo;
    @Override
    public List<Branch> findAll() {
        return (List<Branch>) branchRepo.findAll();
    }

    @Override
    public Branch findById(long id) {
        return branchRepo.findById(id).get();
    }
}
