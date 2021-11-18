package com.demos.agora.model.join;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class JoinKey implements Serializable {
    @Column(name = "studyId")
    private long studyId;

    @Column(name = "userId")
    private long userId;

    // standard constructors, getter, and setters
    // hashcode and equals implementation
}
