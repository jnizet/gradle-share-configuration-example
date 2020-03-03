package red

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RedLibTest {
    @Test
    fun test() {
        assertTrue(RedLib().foo().contains("red"))
    }
}
