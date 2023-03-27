package com.nextit.reactplus.model.type;

public enum ReviewType {

    PHOTO("포토리뷰"),
    TEXT("텍스트리뷰"),
    VIDEO("동영상리뷰");

    private final String name;

    ReviewType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
