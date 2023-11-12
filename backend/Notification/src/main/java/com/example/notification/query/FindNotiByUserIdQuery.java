package com.example.notification.query;

public class FindNotiByUserIdQuery {
    private final String userid;

    public FindNotiByUserIdQuery(String userid) {

        this.userid = userid;
    }

    public String getUserid() {
        return userid;
    }
}
