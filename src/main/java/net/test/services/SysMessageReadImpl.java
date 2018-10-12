package net.test.services;

import net.test.entities.SysMessage;
import org.springframework.stereotype.Service;

@Service("SysMessage")
public class SysMessageReadImpl implements IReadService {
    @Override
    public Object Read(Object oid) {
       return new SysMessage();

    }
}
