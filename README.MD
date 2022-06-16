# FieldValueChanger
Изменение значений полей класса.

### Создание изменяющего класса
Для создания изменяющего класса, необходимо создать класс реализующий интерфейс "Changing".

```java
import Changing;

public final class CommentChanger implements Changing<String>
{
	@Nullable
	@Override
	public String changeValue(@Nullable String value)
	{
		if (value == null)
		{
			return null;
		}

		return value.toUpperCase();
	}
}
```

### Изменение значений полей класса
Чтобы задать изменяющего для поля, необходимо добавить аннотацию "@Changer".
Данная аннотация содержит параметр для указания изменяющего класса.

Класс, в котором необходимо изменить значение поля:

```java
import Changer;

public class Experimental
{
	@Changer(changer = CommentChanger.class)
	private String comment = "Мой комментарий";

	public String getComment()
	{
		return this.comment;
	}
}
```
Вызов изменяющего:
```java
Experimental experimental = new Experimental();

FieldValueChanging fieldValueChanger = new FieldValueChanger(experimental);
fieldValueChanger.change();

experimental.getComment();
/*
Результат выполнения: МОЙ КОММЕНТАРИЙ
*/