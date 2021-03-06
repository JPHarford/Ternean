

/**
 * Provides a type for third order logical operations.
 * @author - Jeremy P. Harford
 * @author - https://github.com/JPHarford
 */
@SuppressWarnings("unused")
public class Ternean extends TerneanOps {

    protected byte state = 0;

    /**
     * Default constructor creates a Ternean with maybe state.
     */
    public Ternean() {}

    /**
     * Copy constructor creates a Ternean with the same state as Ternean source.
     * @param source - Ternean to be copied
     */
    public Ternean(Ternean source) {

        state = source.state;
    }

    /**
     * Construct a Ternean using a boolean value.
     * @param value - initial state
     */
    public Ternean(boolean value) {

        state = value ? (byte) 1 : (byte) -1;
    }

    /**
     * Construct a Ternean using a char shorthand.
     *  t | T : true
     *  other : maybe
     *  f | F : false
     * @param value - initial state
     */
    public Ternean(char value) {

        state = ( value == 't' || value == 'T') ? ((byte) 1) :
                ((value == 'f' || value == 'F') ? ((byte)-1) : 0);
    }

    /**
     * Construct a Ternean using a string.
     *  true | True | TRUE    : true
     *  other : maybe
     *  false | False | FALSE : false
     * @param value - initial state
     */
    public Ternean(String value) {

        state = ( value.equals("true" ) || value.equals("True" ) || value.equals("TRUE" )) ? ((byte) 1) :
                ((value.equals("false") || value.equals("False") || value.equals("FALSE")) ? ((byte)-1) : 0);
    }

    /**
     * Construct a Ternean using an 8-bit integer.
     *  value >  0 : true
     *  value == 0 : maybe
     *  value <  0 : false
     * @param value - initial state
     */
    public Ternean(byte value) {

        state = value >=  0 ?
                value ==  0 ? (byte) 0 : -1 : 1;
    }

    /**
     * Construct a Ternean using a 16-bit integer.
     *  value >  0 : true
     *  value == 0 : maybe
     *  value <  0 : false
     * @param value - initial state
     */
    public Ternean(short value) {

        state = value >=  0 ?
                value ==  0 ? (byte) 0 : -1 : 1;
    }

    /**
     * Construct a Ternean using a 32-bit integer.
     *  value >  0 : true
     *  value == 0 : maybe
     *  value <  0 : false
     * @param value - initial state
     */
    public Ternean(int value) {

        state = value >=  0 ?
                value ==  0 ? (byte) 0 : -1 : 1;
    }

    /**
     * Construct a Ternean using a 64-bit integer.
     *  value >  0 : true
     *  value == 0 : maybe
     *  value <  0 : false
     * @param value - initial state
     */
    public Ternean(long value) {

        state = value >=  0 ?
                value ==  0 ? (byte) 0 : -1 : 1;
    }

    /**
     * Construct a Ternean using a 32-bit floating point.
     *  value >  0 : true
     *  value == 0 : maybe
     *  value <  0 : false
     * @param value - initial state
     */
    public Ternean(float value) {

        state = value >=  0 ?
                value ==  0 ? (byte) 0 : -1 : 1;
    }

    /**
     * Construct a Ternean using a 64-bit floating point.
     *  value >  0 : true
     *  value == 0 : maybe
     *  value <  0 : false
     * @param value - initial state
     */
    public Ternean(double value)
    {
        state = value >=  0 ?
                value ==  0 ? (byte) 0 : -1 : 1;
    }

    /**
     * Set Ternean state using a boolean value.
     * @param value - boolean input.
     */
    public void setValue(boolean value) {

        state = value ? (byte) 1 : (byte) -1;
    }

    /**
     * Set Ternean state using an 8-bit integer.
     *  value >  0 : true
     *  value == 0 : maybe
     *  value <  0 : false
     * @param value - numeric input.
     */
    public void setValue(byte value) {

        state = value >=  0 ?
                value ==  0 ? (byte) 0 : -1 : 1;
    }

    /**
     * Set Ternean state using a 16-bit integer.
     *  value >  0 : true
     *  value == 0 : maybe
     *  value <  0 : false
     * @param value - numeric input.
     */
    public void setValue(short value) {

        state = value >=  0 ?
                value ==  0 ? (byte) 0 : -1 : 1;
    }

    /**
     * Set Ternean state using a char shorthand.
     *  t | T : true
     *  other : maybe
     *  f | F : false
     * @param value - character input.
     */
    public void setValue(char value) {

        state = (value != 't' && value != 'T') ?
                (value == 'f' || value == 'F') ? (byte) -1 : 0 : 1;
    }

    /**
     * Set Ternean state using a 32-bit integer.
     *  value >  0 : true
     *  value == 0 : maybe
     *  value <  0 : false
     * @param value - numeric input.
     */
    public void setValue(int value) {

        state = value >=  0 ?
                value ==  0 ? (byte) 0 : -1 : 1;
    }

    /**
     * Set Ternean state using a 64-bit integer.
     *  value >  0 : true
     *  value == 0 : maybe
     *  value <  0 : false
     * @param value - numeric input.
     */
    public void setValue(long value) {

        state = value >=  0 ?
                value ==  0 ? (byte) 0 : -1 : 1;
    }

    /**
     * Set Ternean state using a 32-bit floating point.
     *  value >  0 : true
     *  value == 0 : maybe
     *  value <  0 : false
     * @param value - numeric input.
     */
    public void setValue(float value) {

        state = value >=  0 ?
                value ==  0 ? (byte) 0 : -1 : 1;
    }

    /**
     * Set Ternean state using a 64-bit floating point.
     *  value >  0 : true
     *  value == 0 : maybe
     *  value <  0 : false
     * @param value - numeric input.
     */
    public void setValue(double value) {

        state = value >=  0 ?
                value ==  0 ? (byte) 0 : -1 : 1;
    }

    /**
     * Set Ternean state using a string.
     *  true | True | TRUE    : true
     *  other : maybe
     *  false | False | FALSE : false
     * @param value - string input.
     */
    public void setValue(String value) {

        state =    ( value.equals("true" ) || value.equals("True" ) || value.equals("TRUE" )) ? ((byte) 1) :
                    ((value.equals("false") || value.equals("False") || value.equals("FALSE")) ? ((byte)-1) : 0);
    }

    public void setValue(Ternean r) {

        state = r.state;
    }

    protected byte fromString(String value) {

        return  value.equals("true" ) || value.equals("True" ) || value.equals("TRUE" ) ? (byte) 1 :
                value.equals("false") || value.equals("False") || value.equals("FALSE") ? (byte)-1 : 0;
    }

    /**
     * Get the underlying Ternean value.
     * @return - a byte representing Ternean state.
     */
    public byte getByte() {

        return state;
    }

    public short getShort() {

        return state;
    }

    public int getInt() {

        return state;
    }

    public char getChar() {

        switch(state) {

            case -1: {

                return 'f';
            }
            case 1: {

                return 't';
            }
            default:
            {

                return 'm';
            }
        }
    }

    public String toString() {


        switch(state) {

            case -1: {

                return "false";
            }
            case 1: {

                return "true";
            }
            default: {

                return "maybe";
            }
        }
    }

    /**
     * Convert to boolean with maybe interpreted as false.
     * @return - boolean representing a biased, collapsed Ternean state.
     */
    public boolean biasFalse() {

        return state > 0;
    }

    /**
     * Convert to boolean with maybe interpreted as true.
     * @return - boolean representing a biased, collapsed Ternean state.
     */
    public boolean biasTrue() {

        return !(state < 0);
    }

    /**
     * Obtain a reference table for Ternean states by operation.
     * @return - string formatted for console output
     */
    public static String help()
    {
        return  "   | Op  | T | M | F \r\n" +
                "---------------------\r\n" +
                " T | ||| | 1 | 1 | 1 \r\n" +
                " M |     | 1 | 0 | 0 \r\n" +
                " F |     | 1 | 0 |-1 \r\n" +
                "---------------------\r\n" +
                " T | &&& | 1 | 0 |-1 \r\n" +
                " M |     | 0 | 0 |-1 \r\n" +
                " F |     |-1 |-1 |-1 \r\n" +
                "---------------------\r\n" +
                " T | ==> | 1 | 0 |-1 \r\n" +
                " M |     | 1 | 0 | 0 \r\n" +
                " F |     | 1 | 1 | 1 \r\n" +
                "---------------------\r\n" +
                " T | <== | 1 | 1 | 1 \r\n" +
                " M |     | 0 | 0 | 1 \r\n" +
                " F |     |-1 | 0 | 1 \r\n" +
                "---------------------\r\n" +
                " T | ^^^ |-1 | 0 | 1 \r\n" +
                " M |     | 0 | 0 | 0 \r\n" +
                " F |     | 1 | 0 |-1 \r\n" +
                "---------------------\r\n" +
                " T | === | 1 | 0 |-1 \r\n" +
                " M |     | 0 | 0 | 0 \r\n" +
                " F |     |-1 | 0 | 1 \r\n" +
                "---------------------\r\n" +
                " T | ~~~ | 1 | 0 | 0 \n\r" +
                " M |     | 0 | 1 | 0 \n\r" +
                " F |     | 0 | 0 | 0 \r\n" +
                "---------------------\r\n" +
                " - | !!! |-1 | 0 | 1 \r\n" +
                "\r\n" +
                "||| : OR\r\n" +
                "&&& : AND\r\n" +
                "^^^ : EXCLUSIVE OR\r\n" +
                "=== : EQUIVALENCE\r\n" +
                "==> : RIGHT IMPLICATION\r\n" +
                "<== : LEFT IMPLICATION\r\n" +
                "!!! : NEGATION\r\n" +
                "~~~ : EQUALS/IDENTITY\r\n" +
                "\r\n" +
                " 1: TRUE\r\n" +
                " 0: MAYBE\r\n" +
                "-1: FALSE";
    }

    /**
     * Returns true if this and b are in the same state.
     * Returns false of this and b are in different states.
     * @param r - right-hand operand
     * @return - boolean resultant of an equivalence test
     */
    public boolean equals(Ternean r) {

        return state == r.state;
    }

    /**
     * Returns a Ternean with true state when either predicate is true.
     * Returns a Ternean with false state when both predicates are false.
     * All other cases return a Ternean with maybe state.
     * @param l - left-hand operand
     * @param r - right-hand operand
     * @return - resultant of an OR operation between l and r
     */
    public static Ternean createOr(Ternean l, Ternean r) {

        return new Ternean(or3(l.state, r.state));
    }

    /**
     * Returns a Ternean with true state when both predicates are true.
     * Returns a Ternean with false state when either predicate is false.
     * ALl other cases return a Ternean with maybe state.
     * @param l - left-hand operand
     * @param r - right-hand operand
     * @return - resultant of an AND operation between l and r
     */
    public static Ternean createAnd(Ternean l, Ternean r) {

        return new Ternean(and3(l.state, r.state));
    }

    /**
     * Returns a Ternean with true state where l is true and r is not false.
     * Returns a Ternean with false state where l is true and r is false.
     * ALl other cases return a Ternean in l maybe state.
     * @param l - left-hand operand
     * @param r - right-hand operand
     * @return - resultant of RMP operation between l and r
     */
    public static Ternean createRImp(Ternean l, Ternean r) {

        return new Ternean(rImp3(l.state, r.state));
    }

    /**
     * Returns a Ternean with true state where r is true and l is not false.
     * Returns a Ternean with false state where r is true and l is false.
     * ALl other cases return a Ternean in l maybe state.
     * @param l - left-hand operand
     * @param r - right-hand operand
     * @return - resultant of LMP operation between l and r
     */
    public static Ternean createLImp(Ternean l, Ternean r) {

        return new Ternean(lImp3(l.state, r.state));
    }

    /**
     * Returns a Ternean with true state when neither predicate is maybe and one predicate is true.
     * Returns a Ternean with false state when neither predicate is maybe and the predicates are in the same state.
     * Returns a Ternean with maybe state when either predicate is maybe.
     * @param l - left-hand operand
     * @param r - right-hand operand
     * @return - resultant of XOR operation between l and r
     */
    public static Ternean createXor(Ternean l, Ternean r) {

        return new Ternean(xor3(l.state, r.state));
    }

    /**
     * Returns a Ternean with true state if neither predicate is maybe and the predicates have the same state.
     * Returns a Ternean with false state if neither predicate is maybe and the predicates do not have the same state.
     * Returns a Ternean with maybe state if either predicate is maybe.
     * @param l - left-hand operand
     * @param r - right-hand operand
     * @return - resultant of EQU operation between l and r
     */
    public static Ternean createEqu(Ternean l, Ternean r) {

        return new Ternean(equ3(l.state, r.state));
    }

    /**
     * Returns a Ternean in true state where l is in false state.
     * Returns a Ternean in false state where l is in true state.
     * Returns a Ternean in maybe state where l is in maybe state.
     * @param l - operand
     * @return - resultant of a NOT operation on Ternean l
     */
    public static Ternean createNeg(Ternean l) {

        return new Ternean(neg3(l.state));
    }

    /**
     * Sets this Ternean to a true state when either predicate is true.
     * Sets this Ternean to a false state when both predicates are false.
     * All other cases set this Ternean to a maybe state.
     * @param r - right-hand operand
     * @return - this Ternean as the resultant of an OR operation with r
     */
    public Ternean setOr(Ternean r) {

        state = or3(state, r.state);
        return this;
    }

    /**
     * Sets this Ternean to a true state when both predicates are true.
     * Sets this Ternean to a false state when either predicate is false.
     * ALl other cases set this Ternean to a maybe state.
     * @param r - right-hand operand
     * @return - this Ternean as the resultant of an AND operation with r
     */
    public Ternean setAnd(Ternean r) {

        state = and3(state, r.state);
        return this;
    }

    /**
     * Sets this Ternean to a true state where a is true and r is not false.
     * Sets this Ternean to a false state where a is true and r is false.
     * ALl other cases sets this Ternean to a maybe state.
     * @param r - right-hand operand
     * @return - this Ternean as the resultant of RMP operation with r
     */
    public Ternean setRImp(Ternean r) {

        state = rImp3(state, r.state);
        return this;
    }

    /**
     * Sets this Ternean to a true state where r is true and a is not false.
     * Sets this Ternean to a false state where r is true and a is false.
     * ALl other cases sets this Ternean to a maybe state.
     * @param r - right-hand operand
     * @return - this Ternean the as resultant of LMP operation with r
     */
    public Ternean setLImp(Ternean r) {

        state = lImp3(state, r.state);
        return this;
    }

    /**
     * Sets this Ternean to a true state when neither predicate is maybe and one predicate is true.
     * Sets this Ternean to a false state when neither predicate is maybe and the predicates are in the same state.
     * Sets this Ternean to a maybe state when either predicate is maybe.
     * @param r - right-hand operand
     * @return - this Ternean as the resultant of XOR operation with r
     */
    public Ternean setXor(Ternean r) {

        state = xor3(state, r.state);
        return this;
    }

    /**
     * Sets this Ternean to a true state if neither predicate is maybe and the predicates have the same state.
     * Sets this Ternean to a false state if neither predicate is maybe and the predicates do not have the same state.
     * Sets this Ternean to a maybe state if either predicate is maybe.
     * @param r - right-hand operand
     * @return - this Ternean as the resultant of EQU operation with r
     */
    public Ternean setEqu(Ternean r) {

        state = equ3(state, r.state);
        return this;
    }

    /**
     * Sets this Ternean to true state where it is in false state.
     * Sets this Ternean to false state where it is in true state.
     * Sets this Ternean this maybe state where it is in maybe state.
     * @return - this as the resultant of a NOT operation on this
     */
    public Ternean setNeg() {

        state = neg3(state);
        return this;
    }
}
