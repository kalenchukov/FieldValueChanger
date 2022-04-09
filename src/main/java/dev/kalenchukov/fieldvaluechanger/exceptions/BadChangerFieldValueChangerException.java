/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.fieldvaluechanger.exceptions;

/**
 * Исключение для некорректного изменяющего значение поля.
 */
public class BadChangerFieldValueChangerException extends RuntimeException
{
    /**
     * Конструктор для {@code BadChangerFieldValueChangerException}.
     */
    public BadChangerFieldValueChangerException()
    {
        super();
    }

    /**
     * Конструктор для {@code BadChangerFieldValueChangerException}.
     *
     * @param message Сообщение.
     */
    public BadChangerFieldValueChangerException(String message)
    {
        super(message);
    }
}
