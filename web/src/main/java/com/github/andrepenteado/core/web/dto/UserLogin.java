package com.github.andrepenteado.core.web.dto;

import java.util.Map;

public record UserLogin(
    String login,
    String nome,
    Map<String, String> perfis
) { }

