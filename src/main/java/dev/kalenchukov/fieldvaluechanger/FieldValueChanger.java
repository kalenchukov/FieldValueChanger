/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.fieldvaluechanger;

import dev.kalenchukov.fieldvaluechanger.annotations.Changer;
import dev.kalenchukov.fieldvaluechanger.exceptions.BadChangerFieldValueChangerException;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Класс для изменения значений полей класса.
 */
public class FieldValueChanger implements FieldValueChanging
{
	/**
	 * Локаль.
	 * Для изменения локали необходимо использовать {@link #setLocale(Locale)}.
	 */
	@NotNull
	private Locale locale = new Locale("ru", "RU");

	/**
	 * Объект класса в котором необходимо изменить значения полей.
	 */
	@NotNull
	private final Object object;

	/**
	 * Устанавливает логгер для данного класса.
	 */
	@NotNull
	private static final Logger LOG = Logger.getLogger(FieldValueChanger.class);

	/**
	 * Устанавливает локализованные тексты логирования.
	 */
	@NotNull
	private ResourceBundle localeLogs = ResourceBundle.getBundle("localizations/logs", locale);

	/**
	 * Устанавливает локализованные тексты исключений.
	 */
	@NotNull
	private ResourceBundle localeExceptions = ResourceBundle.getBundle("localizations/exceptions", locale);

	/**
	 * Конструктор для {@code FieldValueChanger}.
	 *
	 * @param object Объект класса в котором необходимо изменить значения полей.
	 */
	public FieldValueChanger(@NotNull final Object object)
	{
		this.object = object;
	}

	/**
	 * @see FieldValueChanger#setLocale(Locale)
	 */
	public void setLocale(@NotNull Locale locale)
	{
		Objects.requireNonNull(locale);

		if (!this.locale.equals(locale))
		{
			this.locale = locale;

			localeLogs = ResourceBundle.getBundle("localizations/logs", this.locale);
			localeExceptions = ResourceBundle.getBundle("localizations/exceptions", this.locale);
		}
	}

	/**
	 * @see FieldValueChanger#change()
	 */
	public void change() throws BadChangerFieldValueChangerException
	{
		LOG.debug(String.format(
			localeLogs.getString("60001"),
			this.object.getClass().getName()
		));

		for (Field field : this.object.getClass().getDeclaredFields())
		{
			Changer[] annotationsChanger = field.getAnnotationsByType(Changer.class);

			if (annotationsChanger.length == 0) {
				continue;
			}

			field.setAccessible(true);

			this.changeValueField(field, annotationsChanger);

			field.setAccessible(false);
		}

		LOG.debug(String.format(
			localeLogs.getString("60002"),
			this.object.getClass().getName()
		));
	}

	/**
	 * Внедряет значение в поле класса.
	 *
	 * @param field Поле класса в котором необходимо изменить значение.
	 * @param annotationsChanger Аннотации {@code Changer} применяемые к полю класса.
	 *
	 * @throws BadChangerFieldValueChangerException Если изменяющий некорректный.
	 */
	private void changeValueField(@NotNull final Field field, @NotNull Changer @NotNull [] annotationsChanger)
		throws BadChangerFieldValueChangerException
	{
		Objects.requireNonNull(field);
		Objects.requireNonNull(annotationsChanger);

		for (Changer annotationChanger : annotationsChanger)
		{
			Class<? extends Changing<?>> changer = annotationChanger.changer();

			LOG.debug(String.format(
				localeLogs.getString("60003"),
				changer.getName(),
				field.getName()
			));

			try
			{
				Method method = changer.getDeclaredMethod("changeValue", field.getType());

				field.set(
					this.object,
					method.invoke(
						changer.getConstructor().newInstance(),
						field.get(this.object)
					)
				);
			}
			catch (Exception exception)
			{
				throw new BadChangerFieldValueChangerException(String.format(
					localeExceptions.getString("70001"),
					changer.getName(),
					this.object.getClass().getName()
				));
			}

			LOG.debug(String.format(
				localeLogs.getString("60004"),
				field.getName()
			));
		}
	}
}
