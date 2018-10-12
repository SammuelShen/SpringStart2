package net.test.controllers;

import net.test.entities.MessageStatus;
import net.test.entities.SysMessage;
import net.test.exceptions.ResourceNotFoundException;
import net.test.repositories.SysMessageRepository;
import net.test.services.SysMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class SysMessageController {

    @Autowired
    private SysMessageRepository sysMessageRepository;

    @RequestMapping(value = "/sysmessage/{id}",method = RequestMethod.GET)
    public @ResponseBody SysMessage getMessage(@PathVariable long id){
        return sysMessageRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Not Found Resource %s","SysMessage"), "SysMessage"));
    }

    @RequestMapping(value ="/sysmessage",method = RequestMethod.GET)
    public void createMessage(HttpServletRequest request){
        String senderIdStr=request.getParameter("id");
        String content=request.getParameter("content");
        SysMessage message=new SysMessage();
        long senderId=Long.parseLong(senderIdStr);
        message.setSenderId(senderId);
        message.setContent(content);
        message.setCreateBy(senderId);
        message.setModifiedBy(senderId);
        sysMessageRepository.save(message);
    }

    @RequestMapping(value ="/sysmessage/setstatus",method = RequestMethod.GET)
    public void setMessageStatus(HttpServletRequest request){
        String senderIdStr=request.getParameter("id");
        String statusStr=request.getParameter("status");
        MessageStatus status=MessageStatus.valueOf(statusStr);
        long id=Long.parseLong(senderIdStr);
        sysMessageRepository.updateStatusByMessageId(id,status);
    }
}
