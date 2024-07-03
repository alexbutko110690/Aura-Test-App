package com.abutsko.auratestapp.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Date.equalsWithoutTime(date: Date): Boolean =
    SimpleDateFormat("yyyyMMdd", Locale.getDefault()).let { format ->
        format.format(this) == format.format(date)
    }

fun Date.dateWithoutTime(): String =
    SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(this)

//fun <T> List<T>.update(index: Int, item: T): List<T> = toMutableList().apply { this[index] = item }
//fun <E> Iterable<E>.updated(index: Int, elem: E) = mapIndexed { i, existing ->  if (i == index) elem else existing }
//fun <E> Iterable<E>.patched(from: Int, that: Iterable<E>, replaced: Int): Iterable<E> {
//    return take(from) + that + drop(from + replaced)
//}
//
//
//fun <T> List<T>.replaceLast(newValue: T, block: (T) -> Boolean): List<T> {
//    return map {
//        if (block(it)) newValue else it
//    }
//}
