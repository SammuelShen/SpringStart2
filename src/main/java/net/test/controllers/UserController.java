package net.test.controllers;

import net.test.containers.ServiceResourceProvider;
import net.test.entities.User;
import net.test.repositories.UserRepository;
import net.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping("/user")
    public List<User> getList(HttpServletRequest request){
        String idStr=request.getParameter("Id");
        if(idStr==null || idStr.isEmpty()){
            return service.list();
        }else {
            Long.valueOf(idStr);
            long id = Long.parseLong(idStr);
            List<User> result=new ArrayList<User>();
            User user=service.findById(id);
            if(user==null){
                return result;
            }else {
                result.add(user);
                return result;
            }
        }
    }

    @RequestMapping(value="/user/{id}",method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable long id){
      return service.findById(id);
    }
}
