package input

import kotlin.io.path.Path
import kotlin.io.path.readText

fun readString(vararg names: String) = names.map { Path("$it.txt").readText() }
