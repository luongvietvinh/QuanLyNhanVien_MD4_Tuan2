package vinhsama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vinhsama.model.Branch;
import vinhsama.model.Staff;
import vinhsama.service.IBranchService;
import vinhsama.service.IStaffService;

@Controller
public class StaffController {
    @Autowired
    IBranchService branchService;
    @Autowired
    IStaffService staffService;

    @GetMapping("/staff")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView("showStaff");
        modelAndView.addObject("staffs" ,staffService.findAll() );
        return modelAndView;
    }
    @GetMapping ("/create")
    public ModelAndView createform(){
        ModelAndView modelAndView = new ModelAndView("createStaff");
        modelAndView.addObject("staff" , new Staff());
        modelAndView.addObject("branch" , branchService.findAll());
        return modelAndView;
    }
    @PostMapping ("/create")
    public String createStaff(@ModelAttribute (value = "staff") Staff staff ,@RequestParam long idBranch){
        Branch branch = new Branch();
        branch.setId(idBranch);
        staff.setBranch(branch);
        staffService.save(staff);
        return "redirect:/staff";
    }
    @GetMapping ("/edit")
    public ModelAndView editform(@RequestParam long id){
        ModelAndView modelAndView = new ModelAndView("editStaff");
        modelAndView.addObject("staff" , staffService.findById(id));
        modelAndView.addObject("branch" , branchService.findAll());
        return modelAndView;
    }
    @PostMapping ("/edit")
    public String editStaff(@ModelAttribute (value = "staff") Staff staff ,@RequestParam long idBranch){
        Branch branch = new Branch();
        branch.setId(idBranch);
        staff.setBranch(branch);
        staffService.save(staff);

        return "redirect:/staff";
    }
    @GetMapping ("/delete")
    public ModelAndView deleteform(@RequestParam long id){
       ModelAndView modelAndView = new ModelAndView("deleteStaff");
        modelAndView.addObject("mess" , staffService.findById(id) );
        return modelAndView;
    }
    @PostMapping ("/delete")
    public String delete(@RequestParam long id){
        staffService.delete(id);
        return "redirect:/staff";
    }
    @PostMapping ("/search")
    public ModelAndView searchByName (@RequestParam String search){
        ModelAndView modelAndView = new ModelAndView("ShowStaff");
        return modelAndView;
    }
}