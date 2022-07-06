package userservice.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import userservice.userservice.entity.User;
import userservice.userservice.repository.UserServiceRepo;
import userservice.userservice.responseVO.Department;
import userservice.userservice.responseVO.ResponseVo;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserServiceContoller {

    @Autowired
private RestTemplate restTemplate;

    @Autowired
    private UserServiceRepo userServiceRepo;

    @PostMapping("/users")
    public User saveuser(@RequestBody User user)
    {

        return userServiceRepo.save(user);
    }
    @GetMapping("/users")
    public List<User> getAll()
    {
        return userServiceRepo.findAll();
    }

    @GetMapping("/userswd/{cid}")
    public ResponseVo getUsersWithdepartment(@PathVariable("cid") Long cid)
    {
        Optional<User> user=userServiceRepo.findById(cid);
        String id=user.get().getDepartmentId();
        Department dep=restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/departments/"+id, Department.class);
        ResponseVo res=new ResponseVo();
        res.setUser(user.get());
        res.setDepartment(dep);
        return res;
    }
}
