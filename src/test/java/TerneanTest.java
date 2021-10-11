import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TerneanTest {

    private final Ternean[] tArray = new Ternean[]
    {
        new Ternean((byte)  1),
        new Ternean((byte)  0),
        new Ternean((byte) -1)
    };

    @Test
    void testEquals() {

        Ternean tester = new Ternean();

        tester.setValue((byte)  1);
        assertTrue(tArray[0].equals(tester));

        tester.setValue((byte)  0);
        assertTrue(tArray[1].equals(tester));

        tester.setValue((byte) -1);
        assertTrue(tArray[2].equals(tester));
    }

    @Test
    void createNeg() {

        Ternean tester = new Ternean(1);
        Ternean tester2 = Ternean.createNeg(tester);

        assertNotSame(tester, tester2);
        assertFalse(tester.equals(tester2));
    }

    @Test
    void setNeg() {

        Ternean tester = new Ternean(1);

        assertSame(tester, tester.setNeg());
    }

    @Test
    void createOr() {

        Ternean tester = new Ternean(1);
        Ternean tester2 = new Ternean(-1);

        Ternean tester3 = Ternean.createOr(tester, tester2);

        assertNotSame(tester, tester3);
        assertNotSame(tester2, tester3);
    }

    @Test
    void createAnd() {

        Ternean tester = new Ternean(1);
        Ternean tester2 = new Ternean(1);

        Ternean tester3 = Ternean.createAnd(tester, tester2);

        assertNotSame(tester, tester3);
        assertNotSame(tester2, tester3);
    }

    @Test
    void createRImp() {

        Ternean tester = new Ternean(-1);
        Ternean tester2 = new Ternean(1);

        Ternean tester3 = Ternean.createRImp(tester, tester2);

        assertNotSame(tester, tester3);
        assertNotSame(tester2, tester3);
    }

    @Test
    void createLImp() {

        Ternean tester = new Ternean(1);
        Ternean tester2 = new Ternean(-1);

        Ternean tester3 = Ternean.createLImp(tester, tester2);

        assertNotSame(tester, tester3);
        assertNotSame(tester2, tester3);
    }

    @Test
    void createXor() {

        Ternean tester = new Ternean(1);
        Ternean tester2 = new Ternean(-1);

        Ternean tester3 = Ternean.createXor(tester, tester2);

        assertNotSame(tester, tester3);
        assertNotSame(tester2, tester3);
    }

    @Test
    void createEqu() {

        Ternean tester = new Ternean(-1);
        Ternean tester2 = new Ternean(-1);

        Ternean tester3 = Ternean.createEqu(tester, tester2);

        assertNotSame(tester, tester3);
        assertNotSame(tester2, tester3);
    }

    @Test
    void setOr() {

        Ternean tester = new Ternean(1);
        Ternean tester2 = new Ternean(0);

        assertSame(tester, tester.setOr(tester2));
    }

    @Test
    void setAnd() {

        Ternean tester = new Ternean(1);
        Ternean tester2 = new Ternean(1);

        assertSame(tester, tester.setAnd(tester2));
    }

    @Test
    void setRImp() {

        Ternean tester = new Ternean(-1);
        Ternean tester2 = new Ternean(1);

        assertSame(tester, tester.setRImp(tester2));
    }

    @Test
    void setLImp() {

        Ternean tester = new Ternean(1);
        Ternean tester2 = new Ternean(0);

        assertSame(tester, tester.setLImp(tester2));
    }

    @Test
    void setXor() {

        Ternean tester = new Ternean(1);
        Ternean tester2 = new Ternean(-1);

        assertSame(tester, tester.setXor(tester2));
    }

    @Test
    void setEqu() {

        Ternean tester = new Ternean(-1);
        Ternean tester2 = new Ternean(-1);

        assertSame(tester, tester.setEqu(tester2));
    }

    @Test
    void setValue() {
    }

    @Test
    void testSetValue() {

        Ternean test = new Ternean();

        test.setValue((byte) 1);
        assertEquals(1, test.getByte());

        test.setValue((byte) 0);
        assertEquals(0, test.getByte());

        test.setValue((byte) -1);
        assertEquals(-1, test.getByte());
    }

    @Test
    void testSetValue1() {

        Ternean test = new Ternean();

        test.setValue(1);
        assertEquals(1, test.getByte());

        test.setValue(0);
        assertEquals(0, test.getByte());

        test.setValue(-1);
        assertEquals(-1, test.getByte());
    }

    @Test
    void testSetValue2() {

        Ternean test = new Ternean();

        test.setValue((long) 1);
        assertEquals(1, test.getByte());

        test.setValue((long) 0);
        assertEquals(0, test.getByte());

        test.setValue((long) -1);
        assertEquals(-1, test.getByte());
    }

    @Test
    void testSetValue3() {

        Ternean test = new Ternean(-1);

        test.setValue(true);
        assertEquals(1, test.getByte());

        test.setValue(false);
        assertEquals(-1, test.getByte());
    }

    @Test
    void testSetValue4() {

        Ternean test = new Ternean(-1);

        test.setValue('t');
        assertEquals(1, test.getByte());

        test.setValue('m');
        assertEquals(0, test.getByte());

        test.setValue('f');
        assertEquals(-1, test.getByte());
    }

    @Test
    void testSetValue5() {

        Ternean test = new Ternean(-1);
        test.setValue("true");

        assertEquals(1, test.getByte());
    }

    @Test
    void testSetValue6() {

        Ternean test = new Ternean(-1);
        Ternean test2 = new Ternean(1);
        test.setValue(test2);

        assertEquals(1, test.getByte());
    }

    @Test
    void testSetValue7() {

        Ternean test = new Ternean(-1);
        Ternean test2 = new Ternean(1);
        test.setValue(test2);

        assertEquals(1, test.getByte());
    }
}