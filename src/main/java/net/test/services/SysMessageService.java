//package net.test.services;
//
//import net.test.entities.SysMessage;
//import net.test.repositories.SysMessageRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class SysMessageService {
//    @Autowired
//    private SysMessageRepository sysMessageRepository;
//
//    public List<SysMessage> findBySenderId(long senderId){
//       return sysMessageRepository.findBySenderId(senderId);
//    }
//
//    public void save(SysMessage message){
//        sysMessageRepository.save(message);
//    }
//}
