package kz.iitu.itse1907.akmaral.security;

public enum ApplicationUserPermission {
    BOOK_READ("book:read"),
    BOOK_WRITE("book:write"),
    GENRE_READ("genre:read"),
    GENRE_WRITE("genre:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
