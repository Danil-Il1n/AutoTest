import org.junit.Assert.assertEquals
import org.junit.Test

class MainKtTest {

    @Test
    fun calcTestVisa() {
        val cardType = "Visa"
        val monthlyTransactions = 0
        val amount = 100_000

        val result = calc(cardType, monthlyTransactions, amount)
        assertEquals(750, result)
    }

    @Test
    fun calcTestVisaMinComiss() {
        val cardType = "Visa"
        val monthlyTransactions = 0
        val amount = 1_000

        val result = calc(cardType, monthlyTransactions, amount)
        assertEquals(35, result)
    }

    @Test
    fun mastercardNotComm() {
        val cardType = "Mastercard"
        val monthlyTransactions = 10_000
        val amount = 65_000

        val result = calc(cardType, monthlyTransactions, amount)
        assertEquals(0, result)
    }

    @Test
    fun mastercardComm() {
        val cardType = "Mastercard"
        val monthlyTransactions = 0
        val amount = 100_000

        val result = calc(cardType, monthlyTransactions, amount)
        assertEquals(62, result)
    }

    @Test
    fun mirComiss() {
        val cardType = "Mir"
        val monthlyTransactions = 0
        val amount = 100_000

        val result = calc(cardType, monthlyTransactions, amount)
        assertEquals(0, result)
    }
}