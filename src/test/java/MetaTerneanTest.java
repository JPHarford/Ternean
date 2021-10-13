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

        MetaTernean l = new MetaTernean();

        l.setValue( 1);
        l.setValue( 0);
        l.setValue( 0);
        l.setValue(-1);
        l.setValue(-1);
        l.setValue(-1);

        assertEquals("{T:1, M:2, F:3}", l.historyToString());
    }

    @Test
    void testToString() {

        MetaTernean l = new MetaTernean();

        l.setValue( 1);
        l.setValue( 0);
        l.setValue( 0);
        l.setValue(-1);
        l.setValue(-1);
        l.setValue(-1);

        assertEquals("false {T:1, M:2, F:3}", l.toString());
    }

    @Test
    void historyEquals() {

        MetaTernean l = new MetaTernean();

        l.setValue( 1);
        l.setValue( 0);
        l.setValue( 0);
        l.setValue(-1);
        l.setValue(-1);
        l.setValue(-1);

        MetaTernean r = new MetaTernean();

        r.setValue( 1);
        r.setValue( 0);
        r.setValue( 0);
        r.setValue(-1);
        r.setValue(-1);
        r.setValue(-1);

        assertTrue(l.historyEquals(r));
    }

    @Test
    void trueHistoryEquals() {

        MetaTernean l = new MetaTernean();

        l.setValue(1);

        MetaTernean r = new MetaTernean();

        r.setValue(1);

        assertTrue(l.trueHistoryEquals(r));

        l.setValue(1);

        assertFalse(l.trueHistoryEquals(r));
    }

    @Test
    void maybeHistoryEquals() {

        MetaTernean l = new MetaTernean();

        l.setValue(0);
        l.setValue(0);

        MetaTernean r = new MetaTernean();

        r.setValue(0);
        r.setValue(0);

        assertTrue(l.maybeHistoryEquals(r));

        l.setValue(0);

        assertFalse(l.maybeHistoryEquals(r));
    }

    @Test
    void falseHistoryEquals() {

        MetaTernean l = new MetaTernean();

        l.setValue(-1);
        l.setValue(-1);
        l.setValue(-1);

        MetaTernean r = new MetaTernean();

        r.setValue(-1);
        r.setValue(-1);
        r.setValue(-1);

        assertTrue(l.falseHistoryEquals(r));

        l.setValue(-1);

        assertFalse(l.falseHistoryEquals(r));
    }

    @Test
    void createOr() {

        MetaTernean l = new MetaTernean( 1);
        MetaTernean r = new MetaTernean(-1);

        assertEquals(1, MetaTernean.createOr(l, r).getTrueHistory());

        l.setValue(0);
        r.setValue(0);

        assertEquals(1, MetaTernean.createOr(l, r).getMaybeHistory());

        l.setValue(-1);
        r.setValue(-1);

        assertEquals(1, MetaTernean.createOr(l, r).getFalseHistory());
    }

    @Test
    void createAnd() {

        MetaTernean l = new MetaTernean(1);
        MetaTernean r = new MetaTernean(1);

        assertEquals(1, MetaTernean.createAnd(l, r).getTrueHistory());

        l.setValue(0);
        r.setValue(0);

        assertEquals(1, MetaTernean.createAnd(l, r).getMaybeHistory());

        l.setValue(-1);
        r.setValue(-1);

        assertEquals(1, MetaTernean.createAnd(l, r).getFalseHistory());
    }

    @Test
    void createRImp() {

        MetaTernean l = new MetaTernean(1);
        MetaTernean r = new MetaTernean(1);

        assertEquals(1, MetaTernean.createRImp(l, r).getTrueHistory());

        l.setValue(0);
        r.setValue(0);

        assertEquals(1, MetaTernean.createRImp(l, r).getMaybeHistory());

        l.setValue( 1);
        r.setValue(-1);

        assertEquals(1, MetaTernean.createRImp(l, r).getFalseHistory());
    }

    @Test
    void createLImp() {

        MetaTernean l = new MetaTernean(1);
        MetaTernean r = new MetaTernean(1);

        assertEquals(1, MetaTernean.createLImp(l, r).getTrueHistory());

        l.setValue(0);
        r.setValue(0);

        assertEquals(1, MetaTernean.createLImp(l, r).getMaybeHistory());

        l.setValue(-1);
        r.setValue( 1);

        assertEquals(1, MetaTernean.createLImp(l, r).getFalseHistory());
    }

    @Test
    void createXor() {

        MetaTernean l = new MetaTernean( 1);
        MetaTernean r = new MetaTernean(-1);

        assertEquals(1, MetaTernean.createXor(l, r).getTrueHistory());

        l.setValue( 0);
        r.setValue(-1);

        assertEquals(1, MetaTernean.createXor(l, r).getMaybeHistory());

        l.setValue(-1);
        r.setValue(-1);

        assertEquals(1, MetaTernean.createXor(l, r).getFalseHistory());
    }

    @Test
    void createEqu() {

        MetaTernean l = new MetaTernean( 1);
        MetaTernean r = new MetaTernean( 1);

        assertEquals(1, MetaTernean.createEqu(l, r).getTrueHistory());

        l.setValue( 0);
        r.setValue(-1);

        assertEquals(1, MetaTernean.createEqu(l, r).getMaybeHistory());

        l.setValue( 1);
        r.setValue(-1);

        assertEquals(1, MetaTernean.createEqu(l, r).getFalseHistory());
    }

    @Test
    void createNeg() {

        MetaTernean l = new MetaTernean(-1);

        assertEquals(1, MetaTernean.createNeg(l).getTrueHistory());

        l.setValue(0);

        assertEquals(1, MetaTernean.createNeg(l).getMaybeHistory());

        l.setValue(1);

        assertEquals(1, MetaTernean.createNeg(l).getFalseHistory());
    }

    @Test
    void setOr() {

        MetaTernean l = new MetaTernean();
        MetaTernean r = new MetaTernean(-1);

        l.setValue(1);
        assertEquals(1, l.getTrueHistory());
        l.setOr(r);
        assertEquals(2, l.getTrueHistory());

        l.setValue(0);
        assertEquals(1, l.getMaybeHistory());
        l.setOr(r);
        assertEquals(2, l.getMaybeHistory());

        l.setValue(-1);
        assertEquals(1, l.getFalseHistory());
        l.setOr(r);
        assertEquals(2, l.getFalseHistory());
    }

    @Test
    void setAnd() {

        MetaTernean l = new MetaTernean();
        MetaTernean r = new MetaTernean(1);

        l.setValue(1);
        assertEquals(1, l.getTrueHistory());
        l.setAnd(r);
        assertEquals(2, l.getTrueHistory());

        l.setValue(0);
        assertEquals(1, l.getMaybeHistory());
        l.setAnd(r);
        assertEquals(2, l.getMaybeHistory());

        l.setValue(-1);
        assertEquals(1, l.getFalseHistory());
        l.setAnd(r);
        assertEquals(2, l.getFalseHistory());
    }

    @Test
    void setRImp() {

        MetaTernean l = new MetaTernean();
        MetaTernean r = new MetaTernean(1);

        l.setValue(1);
        assertEquals(1, l.getTrueHistory());
        l.setRImp(r);
        assertEquals(2, l.getTrueHistory());

        r.setValue(0);
        assertEquals(0, l.getMaybeHistory());
        l.setRImp(r);
        assertEquals(1, l.getMaybeHistory());

        r.setValue(-1);

        l.setValue(1);
        assertEquals(0, l.getFalseHistory());
        l.setRImp(r);
        assertEquals(1, l.getFalseHistory());
    }

    @Test
    void setLImp() {

        MetaTernean l = new MetaTernean();
        MetaTernean r = new MetaTernean(1);

        l.setValue(1);
        assertEquals(1, l.getTrueHistory());
        l.setLImp(r);
        assertEquals(2, l.getTrueHistory());

        l.setValue(0);
        assertEquals(1, l.getMaybeHistory());
        l.setLImp(r);
        assertEquals(2, l.getMaybeHistory());

        l.setValue(-1);
        assertEquals(1, l.getFalseHistory());
        l.setLImp(r);
        assertEquals(2, l.getFalseHistory());
    }

    @Test
    void setXor() {

        MetaTernean l = new MetaTernean();
        MetaTernean r = new MetaTernean(1);

        l.setValue(-1);
        assertEquals(0, l.getTrueHistory());
        l.setXor(r);
        assertEquals(1, l.getTrueHistory());

        l.setValue(0);
        assertEquals(1, l.getMaybeHistory());
        l.setXor(r);
        assertEquals(2, l.getMaybeHistory());

        l.setValue(1);
        assertEquals(1, l.getFalseHistory());
        l.setXor(r);
        assertEquals(2, l.getFalseHistory());
    }

    @Test
    void setEqu() {

        MetaTernean l = new MetaTernean();
        MetaTernean r = new MetaTernean(1);

        l.setValue(1);
        assertEquals(1, l.getTrueHistory());
        l.setEqu(r);
        assertEquals(2, l.getTrueHistory());

        l.setValue(0);
        assertEquals(1, l.getMaybeHistory());
        l.setEqu(r);
        assertEquals(2, l.getMaybeHistory());

        l.setValue(-1);
        assertEquals(1, l.getFalseHistory());
        l.setEqu(r);
        assertEquals(2, l.getFalseHistory());
    }

    @Test
    void setNeg() {

        MetaTernean l = new MetaTernean(-1);

        assertEquals(0, l.getTrueHistory());
        l.setNeg();
        assertEquals(1, l.getTrueHistory());

        l.setValue(0);
        assertEquals(1, l.getMaybeHistory());
        l.setNeg();
        assertEquals(2, l.getMaybeHistory());

        l.setValue(1);
        assertEquals(1, l.getFalseHistory());
        l.setNeg();
        assertEquals(2, l.getFalseHistory());
    }
}