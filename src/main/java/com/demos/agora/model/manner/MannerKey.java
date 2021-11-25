package com.demos.agora.model.manner;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MannerKey implements Serializable {
    @Column(name="evaluatorId")
    private long evaluatorId;

    @Column(name="evaluateeId")
    private long evaluateeId;

    @Column(name="studyId")
    private long studyId;
}
