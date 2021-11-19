package com.demos.agora.web.dto.study;

//userId, nickName, role, manner, association
public interface StudyDetailRespDto {
    Long getUserID();
    String getNickName();
    int getRole();
    int getManner();
    String getAssociation();
}
