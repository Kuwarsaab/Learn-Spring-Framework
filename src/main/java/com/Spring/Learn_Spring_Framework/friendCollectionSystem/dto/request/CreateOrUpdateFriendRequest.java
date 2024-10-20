package com.Spring.Learn_Spring_Framework.friendCollectionSystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class CreateOrUpdateFriendRequest {
    private String name;
    private int age;
    private String email;
    private String city;
    private String country;
}
