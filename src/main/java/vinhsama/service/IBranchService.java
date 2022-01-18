package vinhsama.service;

import vinhsama.model.Branch;

import java.util.List;

public interface IBranchService {

    public List<Branch> findAll();
    public Branch findById(long id);
}
