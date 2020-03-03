package red

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class BlueLibTest {
    @Test
    fun test() {
        assertTrue(BlueLib().foo().contains("blue"))
    }
}
