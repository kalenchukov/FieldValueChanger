/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.fieldvaluechanger.exceptions;

/**
 * Исключение для некорректного изменяющего значение поля.
 */
public class InvalidChangerClassException extends RuntimeException
{
    /**
     * Конструктор для {@code InvalidChangerFieldValueChangerException}.
     */
    public InvalidChangerClassException()
    {
        super();
    }

    /**
     * Конструктор для {@code InvalidChangerFieldValueChangerException}.
     *
     * @param message Сообщение.
     */
    public InvalidChangerClassException(String message)
    {
        super(message);
    }
}
