package net.test.repositories;

import net.test.entities.MessageStatus;
import net.test.entities.SysMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional(rollbackOn = Exception.class)
public interface SysMessageRepository extends JpaRepository<SysMessage,Long>, JpaSpecificationExecutor<SysMessageRepository> {
    List<SysMessage> findBySenderId(long senderId);

    @Modifying
    @Transactional(rollbackOn= Exception.class)
    @Query(value="update SysMessage m set m.status=:status where m.id=:id")
    int updateStatusByMessageId(@Param("id") long id,@Param("status")MessageStatus status);
}
