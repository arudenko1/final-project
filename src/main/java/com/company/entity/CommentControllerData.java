package com.company.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter

public class CommentControllerData {
    private int id;
    private String message;
    private String username;
    private String commentDate;

    @Override
    public String toString() {
        return "CommentControllerData{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", username='" + username + '\'' +
                ", commentDate='" + commentDate + '\'' +
                '}';
    }
}
