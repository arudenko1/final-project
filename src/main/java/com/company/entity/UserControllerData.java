package com.company.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserControllerData {

    private int id;
    private String username;
    private String name;
    private String lastname;

    @Override
    public String toString() {
        return "UserControllerData{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
