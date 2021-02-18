package ru.netology.web;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class User {
    private final String login;
    private final String password;
    private final String status;
}
