package dev.kalenchukov.lemna.changing.supports;

import dev.kalenchukov.lemna.changing.Modificatory;
import org.jetbrains.annotations.Nullable;

public final class PriceModifier implements Modificatory<Double>
{
	@Nullable
	@Override
	public Double modifyValue(@Nullable final Double value)
	{
		Double newValue = value;

		if (value != null)
		{
			newValue = value + 13.90;
		}

		return newValue;
	}
}