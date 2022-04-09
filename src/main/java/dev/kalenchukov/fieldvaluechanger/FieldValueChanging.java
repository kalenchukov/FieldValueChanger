/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.fieldvaluechanger;

import dev.kalenchukov.fieldvaluechanger.exceptions.BadChangerFieldValueChangerException;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

/**
 * Интерфейс для реализации изменяющего значение поля.
 */
public interface FieldValueChanging
{
	/**
	 * Устанавливает локализацию.
	 *
	 * @param locale Локаль.
	 */
	void setLocale(@NotNull Locale locale);

	/**
	 * Изменяет значение поля.
	 *
	 * @throws BadChangerFieldValueChangerException Если изменяющий некорректный.
	 */
	void change() throws BadChangerFieldValueChangerException;
}
