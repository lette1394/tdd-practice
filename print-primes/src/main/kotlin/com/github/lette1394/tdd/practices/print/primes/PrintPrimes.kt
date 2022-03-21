package com.github.lette1394.tdd.practices.print.primes

class PrintPrimes(
    private val output: Output,
) {
    fun run() {
        val M = 1000
        val RR = 50
        val CC = 4
        val ORDMAX = 30
        val PRIME_NUMBERS = IntArray(M + 1)

        var pageNumber: Int
        var pageOffset: Int
        var rowOffset: Int
        var c: Int
        var isJPrime: Boolean
        var square: Int
        var n: Int
        val mult = IntArray(ORDMAX + 1)

        var j = 1
        var k = 1
        PRIME_NUMBERS[1] = 2
        var ord = 2
        square = 9
        while (k < M) {
            do {
                j += 2
                if (j == square) {
                    ord += 1
                    square = PRIME_NUMBERS[ord] * PRIME_NUMBERS[ord]
                    mult[ord - 1] = j
                }
                n = 2
                isJPrime = true
                while (n < ord && isJPrime) {
                    while (mult[n] < j) mult[n] = mult[n] + PRIME_NUMBERS[n] + PRIME_NUMBERS[n]
                    if (mult[n] == j) isJPrime = false
                    n += 1
                }
            } while (!isJPrime)
            k += 1
            PRIME_NUMBERS[k] = j
        }


        run {
            pageNumber = 1
            pageOffset = 1
            while (pageOffset <= M) {
                output.println("The First " + M +
                        " Prime Numbers --- Page " + pageNumber)
                output.printLineBreak()

                rowOffset = pageOffset
                while (rowOffset < pageOffset + RR) {
                    c = 0
                    while (c < CC) {
                        if (rowOffset + c * RR <= M) {
                            output.printFormatted(PRIME_NUMBERS[rowOffset + c * RR])
                        }
                        c++
                    }
                    output.printLineBreak()
                    rowOffset++
                }
                output.printPageBreak()
                pageNumber += 1
                pageOffset += RR * CC
            }
        }
    }
}
