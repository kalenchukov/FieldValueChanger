/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.fieldvaluechanger;

import org.jetbrains.annotations.Nullable;

/**
 * Интерфейс для реализации изменяющего значение поля.
 *
 * @param <T> Объект типа значения поля.
 */
public interface Changing<T>
{
	/**
	 * Изменяет значение поля.
	 *
	 * @param value Значение поля, которое необходимо изменить.
	 * @return Возвращает изменённое значение поля.
	 */
	@Nullable
	T changeValue(@Nullable T value);
}
