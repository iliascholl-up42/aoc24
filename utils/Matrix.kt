import kotlin.io.path.Path
import kotlin.io.path.readLines

typealias Matrix<T> = List<List<T>>

fun readStringMatrix(name: String): Matrix<String> = Path("$name.txt").readLines().map { it.split(Regex("\\s+")) }

fun <T> Matrix<T>.transpose(): Matrix<T> =
    first().indices.map { colIndex ->
        indices.map { rowIndex -> this[rowIndex][colIndex] }
    }
