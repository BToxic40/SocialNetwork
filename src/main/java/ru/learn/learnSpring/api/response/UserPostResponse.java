package ru.learn.learnSpring.api.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserPostResponse {
    private final int id;
    private final String name;
}
