import kotlin.math.max

const val DAY_LIMIT = 150_000
const val MONTH_LIMIT = 600_000
const val MASTERCARD_LIMIT = 75_000


fun main() {
    val cardType: String = "Visa"
    val dayTransaction: Int = 0
    val monthlyTransactions: Int = 0
    val amount: Int = 100_000
    val cardCommis: Int = calc(cardType, monthlyTransactions, amount)

    when {
        amount > DAY_LIMIT - dayTransaction -> println(
            "Превышен дневной лимит операций\n" + "На сегодня остаток для переводов: " + (DAY_LIMIT - dayTransaction)
        )

        amount > MONTH_LIMIT - monthlyTransactions -> println(
            "Превышен лимит операций за месяц\n" + "На сегодня остаток для переводов: " + (MONTH_LIMIT - monthlyTransactions)
        )

        else -> println(
            "Операция прошла успешно \n" +
                    "Отправили " + amount + "\n" +
                    "Комиссия составила: " + cardCommis
        )
    }

    if (amount == DAY_LIMIT || monthlyTransactions + amount >= MONTH_LIMIT) {
        println("Комиссию спишем в следующем месяце")
    } else {
        println("Всего доброго!")
    }
}

fun calc(cardType: String, monthlyTransactions: Int, amount: Int): Int {

    return when (cardType) {
        "Mastercard" -> if (amount + monthlyTransactions <= MASTERCARD_LIMIT) 0 else (amount * 0.006 + 20).toInt()
        "Visa" -> max(35, (amount * 0.0075).toInt())
        else -> 0
    }
}
