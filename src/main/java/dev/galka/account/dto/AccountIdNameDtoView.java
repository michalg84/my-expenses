package dev.galka.account.dto;

import lombok.Getter;

@Getter
public final class AccountIdNameDtoView {
    private final Integer id;
    private final String name;

    AccountIdNameDtoView(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
