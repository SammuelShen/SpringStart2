package net.test;


import net.test.containers.IServiceResourceProvider;
import net.test.containers.ServiceResourceProvider;
import net.test.entities.User;
import net.test.services.IReadService;
import net.test.services.ISaveService;
import net.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

//@EnableTransactionManagement
@SpringBootApplication
public class App implements CommandLineRunner
//public class App
{
   // @Qualifier("GlobalServiceResourceProvider")
    @Autowired
    private IServiceResourceProvider provider;

//    @Qualifier("User")
//    @Autowired
//    private IReadService readService;

//    @Qualifier("SysMessage")
//    @Autowired
//    private ISaveService saveService;

//    @Autowired
//    private ServiceResourceProvider provider;
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
      UserService srv= provider.getService(UserService.class);
      User user;
      user=new User();
      user.setLogonName("A");
      srv.save(user);
      List<User> list=srv.list();

      for (User item:list){
          System.out.printf("%d  %s %s ",item.getId(),item.getLogonName(),
                  item.getLastModifiedDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
          System.out.println();
      }
    }
}
