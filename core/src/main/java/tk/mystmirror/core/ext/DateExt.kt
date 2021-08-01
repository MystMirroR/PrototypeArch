package tk.mystmirror.core.ext

import java.text.SimpleDateFormat
import java.util.*

const val FORMAT_dd_MMMM = "dd MMMM"
const val FORMAT_HH_mm = "HH:mm"
const val FORMAT_yyyy_MM_dd = "yyyy/MM/dd"
const val FORMAT_yyyy_MM_dd_HH_mm_ss_SS_Z = "yyyy-MM-ddHH:mm:ss"


fun String.toTime(pattern: String) =
    SimpleDateFormat(pattern, Locale.getDefault()).parse(this)?.time ?: 0L

fun String.toDate(pattern: String) =
    SimpleDateFormat(pattern, Locale.getDefault()).parse(this) ?: Date(0L)

fun Date.toString(pattern: String) =
    SimpleDateFormat(pattern, Locale.getDefault()).format(this) ?: Date(0L)

fun Long.format(pattern: String): String =
    SimpleDateFormat(pattern, Locale.getDefault()).format(this)