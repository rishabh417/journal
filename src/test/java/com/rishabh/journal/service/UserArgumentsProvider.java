package com.rishabh.journal.service;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import com.rishabh.journal.entity.User;


import java.util.stream.Stream;

public class UserArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                Arguments.of(User.builder().username("rishabhsingh").password("1234").build()),
                Arguments.of(User.builder().username("shyam-shayamju").password("1234").build())
        );
    }
}
