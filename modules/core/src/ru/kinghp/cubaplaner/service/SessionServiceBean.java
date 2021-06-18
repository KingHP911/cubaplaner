package ru.kinghp.cubaplaner.service;

import com.haulmont.cuba.core.global.DataManager;
import lombok.Data;
import org.springframework.stereotype.Service;
import ru.kinghp.cubaplaner.entity.Session;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service(SessionService.NAME)

//todo Пробую заменить inject. Тут работает
@Data
public class SessionServiceBean implements SessionService {

    //todo Пробую заменить inject. Тут работает
//    @Inject
//    private DataManager dataManager;
    private final DataManager dataManager;

    @Override
    public Session rescheduleSession(Session session, LocalDateTime newStartDate) {

        LocalDateTime dayStart = newStartDate.truncatedTo(ChronoUnit.DAYS).withHour(8);
        LocalDateTime dayEnd = newStartDate.truncatedTo(ChronoUnit.DAYS).withHour(20);

        Long sessionsSameTime = dataManager.loadValue("select count(s) from cubaplaner_Session s where " +
                "(s.startDate between :dayStart and :dayEnd) " +
                "and s.speaker = :speaker " +
                "and s.id <> :sessionId", Long.class)
                .parameter("dayStart", dayStart)
                .parameter("dayEnd", dayEnd)
                .parameter("speaker", session.getSpeaker())
                .parameter("sessionId", session.getId())
                .one();
        if (sessionsSameTime >= 2) {
            return session;
        }
        session.setStartDate(newStartDate);
        return dataManager.commit(session);
    }
}