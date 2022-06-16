/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.lemna.changing.supports;

import dev.kalenchukov.lemna.changing.Modificatory;
import org.jetbrains.annotations.Nullable;

public final class QuoteModifier implements Modificatory<String>
{
	@Nullable
	@Override
	public String modifyValue(@Nullable final String value)
	{
		String newValue = value;

		if (value != null) {
			newValue = "'" + newValue + "'";
		}

		return newValue;
	}
}