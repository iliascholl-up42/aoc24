package input

import kotlin.io.path.Path
import kotlin.io.path.readText
import kotlin.reflect.KProperty

class FileDelegate<T>(
    private val transformer: (String) -> T,
) {
    operator fun getValue(
        thisRef: Any?,
        property: KProperty<*>,
    ) = Path("${property.name}.txt").readText().trim().let(transformer)
}

val file = FileDelegate { it }

fun <T> file(transformer: (String) -> T) = FileDelegate(transformer)
