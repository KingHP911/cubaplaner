package ru.kinghp.cubaplaner.web.screens.speaker;

import com.haulmont.cuba.gui.screen.*;
import ru.kinghp.cubaplaner.entity.Speaker;

@UiController("cubaplaner_Speaker.browse")
@UiDescriptor("speaker-browse.xml")
@LookupComponent("speakersTable")
@LoadDataBeforeShow
public class SpeakerBrowse extends StandardLookup<Speaker> {
}