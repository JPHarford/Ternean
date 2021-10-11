import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MetaTerneanTest {

    @Test
    void setValue() {}

    @Test
    void testSetValue() {

        MetaTernean test = new MetaTernean();

        assertEquals(0, test.getTrueHistory());
        test.setValue((byte) 1);
        assertEquals(1, test.getTrueHistory());

        assertEquals(0, test.getMaybeHistory());
        test.setValue((byte) 0);
        assertEquals(1, test.getMaybeHistory());

        assertEquals(0, test.getFalseHistory());
        test.setValue((byte) -1);
        assertEquals(1, test.getFalseHistory());
    }

    @Test
    void testSetValue1() {

        MetaTernean test = new MetaTernean();

        assertEquals(0, test.getTrueHistory());
        test.setValue((short) 1);
        assertEquals(1, test.getTrueHistory());

        assertEquals(0, test.getMaybeHistory());
        test.setValue((short) 0);
        assertEquals(1, test.getMaybeHistory());

        assertEquals(0, test.getFalseHistory());
        test.setValue((short) -1);
        assertEquals(1, test.getFalseHistory());
    }

    @Test
    void testSetValue2() {

        MetaTernean test = new MetaTernean();

        assertEquals(0, test.getTrueHistory());
        test.setValue(/*(int)*/  1);
        assertEquals(1, test.getTrueHistory());

        assertEquals(0, test.getMaybeHistory());
        test.setValue(/*(int)*/  0);
        assertEquals(1, test.getMaybeHistory());

        assertEquals(0, test.getFalseHistory());
        test.setValue(/*(int)*/ -1);
        assertEquals(1, test.getFalseHistory());
    }

    @Test
    void testSetValue3() {

        MetaTernean test = new MetaTernean();

        assertEquals(0, test.getTrueHistory());
        test.setValue((long) 1);
        assertEquals(1, test.getTrueHistory());

        assertEquals(0, test.getMaybeHistory());
        test.setValue((long) 0);
        assertEquals(1, test.getMaybeHistory());

        assertEquals(0, test.getFalseHistory());
        test.setValue((long) -1);
        assertEquals(1, test.getFalseHistory());
    }

    @Test
    void testSetValue4() {

        MetaTernean test = new MetaTernean();

        assertEquals(0, test.getTrueHistory());
        test.setValue(true);
        assertEquals(1, test.getTrueHistory());

        assertEquals(0, test.getFalseHistory());
        test.setValue(false);
        assertEquals(1, test.getFalseHistory());
    }

    @Test
    void testSetValue5() {

        MetaTernean test = new MetaTernean();

        assertEquals(0, test.getTrueHistory());
        test.setValue('t');
        assertEquals(1, test.getTrueHistory());

        assertEquals(0, test.getMaybeHistory());
        test.setValue('m');
        assertEquals(1, test.getMaybeHistory());

        assertEquals(0, test.getFalseHistory());
        test.setValue('f');
        assertEquals(1, test.getFalseHistory());
    }

    @Test
    void testSetValue6() {

        MetaTernean test = new MetaTernean();

        assertEquals(0, test.getTrueHistory());
        test.setValue("true");
        assertEquals(1, test.getTrueHistory());

        assertEquals(0, test.getMaybeHistory());
        test.setValue("maybe");
        assertEquals(1, test.getMaybeHistory());

        assertEquals(0, test.getFalseHistory());
        test.setValue("false");
        assertEquals(1, test.getFalseHistory());
    }

    @Test
    void testSetValue7() {

        MetaTernean trueState = new MetaTernean(1);
        MetaTernean maybeState = new MetaTernean(0);
        MetaTernean falseState = new MetaTernean(-1);

        MetaTernean test = new MetaTernean();

        assertEquals(0, test.getTrueHistory());
        test.setValue(trueState);
        assertEquals(1, test.getTrueHistory());

        assertEquals(0, test.getMaybeHistory());
        test.setValue(maybeState);
        assertEquals(1, test.getMaybeHistory());

        assertEquals(0, test.getFalseHistory());
        test.setValue(falseState);
        assertEquals(1, test.getFalseHistory());
    }

    @Test
    void historyToString() {
    }

    @Test
    void testToString() {
    }

    @Test
    void historyEquals() {
    }

    @Test
    void trueHistoryEquals() {
    }

    @Test
    void maybeHistoryEquals() {
    }

    @Test
    void falseHistoryEquals() {
    }

    @Test
    void createOr() {
    }

    @Test
    void createAnd() {
    }

    @Test
    void createRImp() {
    }

    @Test
    void createLImp() {
    }

    @Test
    void createXor() {
    }

    @Test
    void createEqu() {
    }

    @Test
    void createNeg() {
    }

    @Test
    void setOr() {
    }

    @Test
    void setAnd() {
    }

    @Test
    void setRImp() {
    }

    @Test
    void setLImp() {
    }

    @Test
    void setXor() {
    }

    @Test
    void setEqu() {
    }

    @Test
    void setNeg() {
    }
}