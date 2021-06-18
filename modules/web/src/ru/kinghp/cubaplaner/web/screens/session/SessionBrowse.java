package ru.kinghp.cubaplaner.web.screens.session;

import com.haulmont.cuba.gui.components.Calendar;
import com.haulmont.cuba.gui.components.EditorScreenFacet;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;
import lombok.Data;
import ru.kinghp.cubaplaner.entity.Session;
import ru.kinghp.cubaplaner.service.SessionService;

import javax.inject.Inject;
import java.time.LocalDateTime;

@UiController("cubaplaner_Session.browse")
@UiDescriptor("session-browse.xml")
@LookupComponent("sessionsTable")
@LoadDataBeforeShow

//todo тут не работает
//@Data
public class SessionBrowse extends StandardLookup<Session> {
    @Inject
    private EditorScreenFacet<Session, SessionEdit> sessionEditDialog;

    @Inject
    private CollectionContainer<Session> sessionsDc;

    //todo тут не работает
//    private final SessionService sessionService;
    @Inject
    private SessionService sessionService;

    @Subscribe("sessionsCalendar")
    public void onCalendarTabCalendarEventClick(Calendar.CalendarEventClickEvent<LocalDateTime> event) {
        sessionEditDialog.setEntityProvider(() -> (Session) event.getEntity());
        sessionEditDialog.show();
    }

    @Subscribe("sessionsCalendar")
    public void onSessionsCalendarCalendarEventMove(Calendar.CalendarEventMoveEvent<LocalDateTime> event) {
        Session session = sessionService.rescheduleSession((Session) event.getEntity(), event.getNewStart());
        sessionsDc.replaceItem(session);

    }
}