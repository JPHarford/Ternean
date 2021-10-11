import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TerneanOpsTest extends TerneanOps {

    private final Ternean[] tArray = new Ternean[]
    {
            new Ternean((byte)  1),
            new Ternean((byte)  0),
            new Ternean((byte) -1)
    };

    /**
     * Tests that output from Ternary OR operation matches the truth table.
     * All predicate states are tested.
     *
     *                T | M | F
     *      T | ||| | 1 | 1 | 1
     *      M |     | 1 | 0 | 0
     *      F |     | 1 | 0 |-1
     */
    @Test
    void or3() {

        byte[] resultant = new byte[9];

        resultant[0] =  1;
        resultant[1] =  1;
        resultant[2] =  1;
        resultant[3] =  1;
        resultant[4] =  0;
        resultant[5] =  0;
        resultant[6] =  1;
        resultant[7] =  0;
        resultant[8] = -1;

        for(int i = 0; i < 3; i++) {

            for(int j = 0; j < 3; j++) {

                assertEquals
                        (
                                resultant[i * 3 + j],
                                or3(tArray[i].getByte(), tArray[j].getByte()),
                                "i: " + i + ", j: " + j
                        );
            }
        }
    }

    /**
     * Tests that output from Ternary AND operation matches the truth table.
     * All predicate states are tested.
     *
     *                T | M | F
     *      T | &&& | 1 | 0 |-1
     *      M |     | 0 | 0 |-1
     *      F |     |-1 |-1 |-1
     */
    @Test
    void and3() {

        byte[] resultant = new byte[9];

        resultant[0] =  1;
        resultant[1] =  0;
        resultant[2] = -1;
        resultant[3] =  0;
        resultant[4] =  0;
        resultant[5] = -1;
        resultant[6] = -1;
        resultant[7] = -1;
        resultant[8] = -1;

        for(int i = 0; i < 3; i++) {

            for(int j = 0; j < 3; j++) {

                assertEquals
                        (
                                resultant[i * 3 + j],
                                and3(tArray[i].getByte(), tArray[j].getByte()),
                                "i: " + i + ", j: " + j
                        );
            }
        }
    }

    /**
     * Tests that output from Ternary RIGHT IMPLICATION operation matches the truth table.
     * All predicate states are tested.
     *
     *                T | M | F
     *      T | ==> | 1 | 0 |-1
     *      M |     | 1 | 0 | 0
     *      F |     | 1 | 1 | 1
     */
    @Test
    void rImp3() {

        byte[] resultant = new byte[9];

        resultant[0] =  1;
        resultant[1] =  0;
        resultant[2] = -1;
        resultant[3] =  1;
        resultant[4] =  0;
        resultant[5] =  0;
        resultant[6] =  1;
        resultant[7] =  1;
        resultant[8] =  1;


        for(int i = 0; i < 3; i++) {

            for(int j = 0; j < 3; j++) {

                assertEquals
                        (
                                resultant[i * 3 + j],
                                rImp3(tArray[i].getByte(), tArray[j].getByte()),
                                "i: " + i + ", j: " + j
                        );
            }
        }
    }

    /**
     * Tests that output from Ternary LEFT IMPLICATION operation matches the truth table.
     * All predicate states are tested.
     *
     *                T | M | F
     *      T | <== | 1 | 1 | 1
     *      M |     | 0 | 0 | 1
     *      F |     |-1 | 0 | 1
     */
    @Test
    void lImp3() {

        byte[] resultant = new byte[9];

        resultant[0] =  1;
        resultant[1] =  1;
        resultant[2] =  1;
        resultant[3] =  0;
        resultant[4] =  0;
        resultant[5] =  1;
        resultant[6] = -1;
        resultant[7] =  0;
        resultant[8] =  1;

        for(int i = 0; i < 3; i++) {

            for(int j = 0; j < 3; j++) {

                assertEquals
                        (
                                resultant[i * 3 + j],
                                lImp3(tArray[i].getByte(), tArray[j].getByte()),
                                "i: " + i + ", j: " + j
                        );
            }
        }
    }

    /**
     * Tests that output from Ternary XOR operation matches the truth table.
     * All predicate states are tested.
     *
     *                T | M | F
     *      T | ^^^ |-1 | 0 | 1
     *      M |     | 0 | 0 | 0
     *      F |     | 1 | 0 |-1
     */
    @Test
    void xor3() {

        byte[] resultant = new byte[9];

        resultant[0] = -1;
        resultant[1] =  0;
        resultant[2] =  1;
        resultant[3] =  0;
        resultant[4] =  0;
        resultant[5] =  0;
        resultant[6] =  1;
        resultant[7] =  0;
        resultant[8] = -1;

        for(int i = 0; i < 3; i++) {

            for(int j = 0; j < 3; j++) {

                assertEquals
                        (
                                resultant[i * 3 + j],
                                Ternean.xor3(tArray[i].getByte(), tArray[j].getByte()),
                                "i: " + i + ", j: " + j
                        );
            }
        }
    }

    /**
     * Tests that output from Ternary EQUIVALENCE operation matches the truth table.
     * All predicate states are tested.
     *
     *                T | M | F
     *      T | === | 1 | 0 |-1
     *      M |     | 0 | 0 | 0
     *      F |     |-1 | 0 | 1
     */
    @Test
    void equ3() {

        byte[] resultant = new byte[9];

        resultant[0] =  1;
        resultant[1] =  0;
        resultant[2] = -1;
        resultant[3] =  0;
        resultant[4] =  0;
        resultant[5] =  0;
        resultant[6] = -1;
        resultant[7] =  0;
        resultant[8] =  1;

        for(int i = 0; i < 3; i++) {

            for(int j = 0; j < 3; j++) {

                assertEquals
                        (
                                resultant[i * 3 + j],
                                equ3(tArray[i].getByte(), tArray[j].getByte()),
                                "i: " + i + ", j: " + j
                        );
            }
        }
    }

    /**
     * Tests that output from Ternary NEGATION operation matches the truth table.
     * All predicate states are tested.
     *
     *      T | !!! |-1
     *      M |     | 0
     *      F |     | 1
     */
    @Test
    void neg3() {

        assertEquals(neg3((byte) -1), (byte)  1);
        assertEquals(neg3((byte)  0), (byte)  0);
        assertEquals(neg3((byte)  1), (byte) -1);
    }
}