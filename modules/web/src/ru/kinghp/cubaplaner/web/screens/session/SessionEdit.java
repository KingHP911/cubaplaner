package ru.kinghp.cubaplaner.web.screens.session;

import com.haulmont.cuba.gui.screen.*;
import ru.kinghp.cubaplaner.entity.Session;

@UiController("cubaplaner_Session.edit")
@UiDescriptor("session-edit.xml")
@EditedEntityContainer("sessionDc")
@LoadDataBeforeShow
public class SessionEdit extends StandardEditor<Session> {
    @Subscribe
    public void onInitEntity(InitEntityEvent<Session> event) {
        event.getEntity().setDuration(1);
    }
}