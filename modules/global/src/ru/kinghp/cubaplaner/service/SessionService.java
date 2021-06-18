package ru.kinghp.cubaplaner.service;

import ru.kinghp.cubaplaner.entity.Session;

import java.time.LocalDateTime;

public interface SessionService {
    String NAME = "cubaplaner_SessionService";

    Session rescheduleSession(Session session, LocalDateTime newStartDate);

}