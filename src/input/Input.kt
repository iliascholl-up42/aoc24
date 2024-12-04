package input

import matrix.Matrix
import kotlin.io.path.Path
import kotlin.io.path.readText
import kotlin.reflect.KProperty
import kotlin.streams.toList

fun readString(vararg names: String) = names.map { Path("$it.txt").readText() }

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

object Transformers {
    val charMatrix: (String) -> Matrix<Char> = { input ->
        input.lines().map { it.chars().toList().map(Int::toChar) }
    }
}
