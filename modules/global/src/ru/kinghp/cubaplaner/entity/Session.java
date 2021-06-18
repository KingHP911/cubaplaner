package ru.kinghp.cubaplaner.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Table(name = "CUBAPLANER_SESSION")
@Entity(name = "cubaplaner_Session")
@NamePattern("%s|description")
public class Session extends StandardEntity {
    private static final long serialVersionUID = 3014927229627219337L;

    @NotNull
    @Column(name = "TOPIC", nullable = false)
    private String topic;

    @NotNull
    @Column(name = "START_DATE", nullable = false)
    private LocalDateTime startDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SPEAKER_ID")
    @NotNull
    private Speaker speaker;

    @NotNull
    @Column(name = "DURATION", nullable = false)
    private Integer duration;

    @Column(name = "DESCRIPTION", length = 2000)
    private String description;

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @MetaProperty(related = {"startDate", "duration"})
    public LocalDateTime getEndDate() {
        return (startDate != null && duration != null) ? startDate.plusHours(duration):null;
    }

}