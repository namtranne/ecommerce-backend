package com.ecommerce.server.constant;

public class HttpStatusCode {
    // Prevent instantiation
    private HttpStatusCode() {}

    // Informational responses (100–199)
    public static final int CONTINUE = 100;
    public static final int SWITCHING_PROTOCOLS = 101;

    // Successful responses (200–299)
    public static final int OK = 200;
    public static final int CREATED = 201;
    public static final int ACCEPTED = 202;
    public static final int NO_CONTENT = 204;

    // Redirection messages (300–399)
    public static final int MOVED_PERMANENTLY = 301;
    public static final int FOUND = 302;
    public static final int NOT_MODIFIED = 304;

    // Client error responses (400–499)
    public static final int BAD_REQUEST = 400;
    public static final int UNAUTHORIZED = 401;
    public static final int FORBIDDEN = 403;
    public static final int NOT_FOUND = 404;
    public static final int METHOD_NOT_ALLOWED = 405;

    // Server error responses (500–599)
    public static final int INTERNAL_SERVER_ERROR = 500;
    public static final int NOT_IMPLEMENTED = 501;
    public static final int BAD_GATEWAY = 502;
    public static final int SERVICE_UNAVAILABLE = 503;
}
