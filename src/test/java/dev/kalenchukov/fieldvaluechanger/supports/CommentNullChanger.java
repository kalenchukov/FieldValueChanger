/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.fieldvaluechanger.supports;

import dev.kalenchukov.fieldvaluechanger.Changing;
import org.jetbrains.annotations.Nullable;

public final class CommentNullChanger implements Changing<String>
{
	@Nullable
	@Override
	public String changeValue(@Nullable final String value)
	{
		return null;
	}
}
