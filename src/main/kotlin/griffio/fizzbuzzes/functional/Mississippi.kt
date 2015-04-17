package griffio.fizzbuzzes.functional

import java.util
import java.util.Collections

fun main(args: Array<String>) {

    fun one(input : String) {

        var result = linkedMapOf<Char, Int>()

        for(char in input) {
           val count  = result.getOrPut(char, {0})
           result.put(char, count.plus(1))
        }

        println("result = ${result}")

    }

    fun two(input: String) {

        val result = input.groupBy{it}.mapValues{it.getValue().size()}

        println("result = ${result}")

    }

    fun three(input: String) {

        val result = input.fold(linkedMapOf<Char, Int>(), {map, char ->
            val count = map.getOrPut(char, {0})
            map.put(char, count.plus(1))
            map
        })

        println("result = ${result}")

    }

    one("Mississippi")

    two("Mississippi")

    three("Mississippi")
}