package ru.kinghp.cubaplaner.web.screens.speaker;

import com.haulmont.cuba.gui.screen.*;
import ru.kinghp.cubaplaner.entity.Speaker;

@UiController("cubaplaner_Speaker.edit")
@UiDescriptor("speaker-edit.xml")
@EditedEntityContainer("speakerDc")
@LoadDataBeforeShow
public class SpeakerEdit extends StandardEditor<Speaker> {
}