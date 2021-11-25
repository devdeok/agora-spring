package com.demos.agora.model.mood;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MoodKey implements Serializable {
    @Column(name="userId")
    private long userId;

    @Column(name="studyId")
    private long studyId;

}
