/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.fieldvaluechanger.exceptions;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Исключение для некорректного изменяющего значение поля.
 */
public class InvalidChangerClassException extends RuntimeException
{
    /**
     * Конструктор для {@code InvalidChangerException}.
     *
     * @param message Сообщение.
     */
    public InvalidChangerClassException(@NotNull final String message)
    {
        super(message);

		Objects.requireNonNull(message);
    }
}
