/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.fieldvaluechanger.exceptions;

/**
 * Исключение для некорректного изменяющего значение поля.
 */
public class InvalidChangerFieldValueChangerException extends RuntimeException
{
    /**
     * Конструктор для {@code InvalidChangerFieldValueChangerException}.
     */
    public InvalidChangerFieldValueChangerException()
    {
        super();
    }

    /**
     * Конструктор для {@code InvalidChangerFieldValueChangerException}.
     *
     * @param message Сообщение.
     */
    public InvalidChangerFieldValueChangerException(String message)
    {
        super(message);
    }
}
