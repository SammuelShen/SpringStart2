package net.test.services;

import jdk.nashorn.internal.runtime.options.Option;
import net.test.entities.User;
import net.test.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> list(){
      return  repository.findAll();
    }

    public void save(User user){
        repository.save(user);
    }

    public User findById(long id){
      Optional<User> result= repository.findById(id);
      if(result.isPresent()){
          return result.get();
      }else{
          return null;
      }
    }
}
