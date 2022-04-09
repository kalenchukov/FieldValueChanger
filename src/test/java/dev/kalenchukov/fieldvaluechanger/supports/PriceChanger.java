package dev.kalenchukov.fieldvaluechanger.supports;

import dev.kalenchukov.fieldvaluechanger.Changing;
import org.jetbrains.annotations.Nullable;

public final class PriceChanger implements Changing<Double>
{
	@Nullable
	@Override
	public Double changeValue(@Nullable final Double value)
	{
		Double newValue = value;

		if (value != null)
		{
			newValue = value + 13.90;
		}

		return newValue;
	}
}
