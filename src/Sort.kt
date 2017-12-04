var list = mutableListOf<Int>()

fun main(args: Array<String>) {
    // initial question, allowing user to exit program before entering list
    print("Enter 20 numbers ranging from -100 to 100? (Y/n) " )
    if (readLine()?.toUpperCase() != "Y") System.exit(0)
    while (list.size < 20) {
        print("Enter number ${list.size+1}: ")
        list.addOrAsk(readLine())
    }
    println("Entered all numbers")
    list = quickSort(list)
    list.forEach { println(it) }
}

fun MutableList<kotlin.Int>.addOrAsk(s: String?) {
    val num = s?.toInt() ?: 101
    if ((-100..100).contains(num)) this.add(num)
    else println("Does not validate the criteria needed for this list")
}

fun quickSort(list: MutableList<Int>): MutableList<Int> = helper(list, 0, list.size-1)

fun helper(list: MutableList<Int>, low: Int, high: Int): MutableList<Int> {
    val middle = partition(list, low, high)
    if (low < middle - 1)
        helper(list, low, middle - 1)
    if (middle < high)
        helper(list, middle, high)
    return list
}

fun partition(list: MutableList<Int>, low: Int, high: Int): Int {
    val pivot = list[(low + high) / 2]
    var left = low; var right = high
    while (left <= right) {
        while (list[left] < pivot) left++
        while (list[right] > pivot) right--

        if (left <= right) {
            val temp = list[left]
            list[left] = list[right]
            list[right] = temp

            left++; right--
        }
    }
    return left
}

