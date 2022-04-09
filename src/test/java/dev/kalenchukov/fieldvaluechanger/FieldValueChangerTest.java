/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.fieldvaluechanger;

import dev.kalenchukov.fieldvaluechanger.annotations.Changer;
import dev.kalenchukov.fieldvaluechanger.supports.CommentChanger;
import dev.kalenchukov.fieldvaluechanger.supports.CommentNullChanger;
import dev.kalenchukov.fieldvaluechanger.supports.PriceChanger;
import dev.kalenchukov.fieldvaluechanger.supports.QuoteChanger;
import org.junit.Test;

import static org.junit.Assert.*;

public final class FieldValueChangerTest
{
    /**
     * Проверка изменения значений нескольких полей класса.
     */
    @Test
    public void testChange1()
    {
        class Experimental
        {
			@Changer(changer = CommentChanger.class)
            private String comment = "Мой комментарий";

			@Changer(changer = PriceChanger.class)
			private Double price = 20.05;

			public String getComment()
			{
				return this.comment;
			}

			public Double getPrice()
			{
				return this.price;
			}
		}

        Experimental experimental = new Experimental();

        FieldValueChanging fieldValueChanger = new FieldValueChanger(experimental);
		fieldValueChanger.change();

        assertEquals("МОЙ КОММЕНТАРИЙ к классу 'Experimental'", experimental.getComment());
		assertEquals(Double.valueOf(33.95), experimental.getPrice());
    }

	/**
	 * Проверка изменения значения с помощью нескольких изменяющих.
	 */
	@Test
	public void testChange2()
	{
		class Experimental
		{
			@Changer.Many({
				@Changer(changer = CommentChanger.class),
				@Changer(changer = QuoteChanger.class)
			})
			private String comment = "Мой комментарий";

			public String getComment()
			{
				return this.comment;
			}
		}

		Experimental experimental = new Experimental();

		FieldValueChanging fieldValueChanger = new FieldValueChanger(experimental);
		fieldValueChanger.change();

		assertEquals("'МОЙ КОММЕНТАРИЙ к классу 'Experimental''", experimental.getComment());
	}

	/**
	 * Проверка изменения значения на значение {@code null}.
	 */
	@Test
	public void testChange3()
	{
		class Experimental
		{
			@Changer(changer = CommentNullChanger.class)
			private String comment = "Мой комментарий";

			public String getComment()
			{
				return this.comment;
			}
		}

		Experimental experimental = new Experimental();

		FieldValueChanging fieldValueChanger = new FieldValueChanger(experimental);
		fieldValueChanger.change();

		assertNull(experimental.getComment());
	}
}