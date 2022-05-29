package dev.kalenchukov.fieldvaluechanger.annotations;

import dev.kalenchukov.fieldvaluechanger.Changing;
import org.jetbrains.annotations.NotNull;

import java.lang.annotation.*;

/**
 * Позволяет изменять значение поля класса.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Repeatable(Changer.ManyChanger.class)
public @interface Changer
{
	/**
	 * Задаёт класс изменяющего значение поля.
	 *
	 * @return Класс изменяющего значение поля.
	 */
	@NotNull
	Class<? extends Changing<?>> changer();

	/**
	 * Позволяет указывать множество {@code Changer} для одного поля.
	 *
	 * @see Changer
	 */
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.FIELD)
	@interface ManyChanger
	{
		/**
		 * @see Changer
		 */
		Changer[] value();
	}
}
