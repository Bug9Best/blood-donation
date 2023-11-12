package com.example.notification.query;

public class FindNotiByIdQuery {
    private final String notiId;

    public FindNotiByIdQuery(String notiId) {
        this.notiId = notiId;
    }

    public String getNotiId() {
        return notiId;
    }


}
