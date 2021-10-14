
/**
 * Provides an historical count of ternary states.
 * @author - Jeremy P. Harford
 * @author - https://github.com/JPHarford
 */
@SuppressWarnings("unused")
public class MetaTernean extends Ternean {

    protected final int[] stateCounts;
    {
        stateCounts = new int[]{0, 0, 0};
    }

    /**
     * Default constructor creates a MetaTernean with maybe state.
     */
    public MetaTernean(){}

    /**
     * Down-Cast constructor creates a MetaTernean with the same state and history as the source.
     * @param source - the MetaTernean to be copied.
     */
    public MetaTernean(ProTernean source) {

        state = source.state;

        stateCounts[0] = source.stateCounts[0];
        stateCounts[1] = source.stateCounts[1];
        stateCounts[2] = source.stateCounts[2];
    }

    /**
     * Copy constructor creates a MetaTernean with the same state and history as the source.
     * @param source - the MetaTernean to be copied.
     */
    public MetaTernean(MetaTernean source) {

        state = source.state;

        stateCounts[0] = source.stateCounts[0];
        stateCounts[1] = source.stateCounts[1];
        stateCounts[2] = source.stateCounts[2];
    }

    /**
     * Construct a MetaTernean using a boolean value.
     * @param value - initial state.
     */
    public MetaTernean(boolean value) {

        this.state = (byte) (value ? 1 : -1);

        stateCounts[state + 1]++;
    }

    /**
     * Construct a MetaTernean using a char shorthand.
     *  t | T : true
     *  other : maybe
     *  f | F : false
     * @param value - character input.
     */
    public MetaTernean(char value) {

        state =
                value == 't' || value == 'T' ? (byte) 1 :
                        value == 'f' || value == 'F' ? (byte)-1 : 0;

        stateCounts[state + 1]++;
    }

    /**
     * Construct a MetaTernean using a string.
     *  true | True | TRUE    : true
     *  other : maybe
     *  false | False | FALSE : false
     * @param value - string input.
     */
    public MetaTernean(String value) {

        state = fromString(value);
        stateCounts[state + 1]++;
    }

    /**
     * Construct a MetaTernean using an 8-bit integer.
     *  value >  0 : true
     *  value == 0 : maybe
     *  value <  0 : false
     * @param value - initial state.
     */
    public MetaTernean(byte value) {

        state = value >=  0 ?
                value ==  0 ? (byte) 0 : -1 : 1;

        stateCounts[state + 1]++;
    }

    /**
     * Construct a MetaTernean using a 16-bit integer.
     *  value >  0 : true
     *  value == 0 : maybe
     *  value <  0 : false
     * @param value - initial state.
     */
    public MetaTernean(short value) {

        state = value >=  0 ?
                value ==  0 ? (byte) 0 : -1 : 1;

        stateCounts[state + 1]++;
    }

    /**
     * Construct a MetaTernean using a 32-bit integer.
     *  value >  0 : true
     *  value == 0 : maybe
     *  value <  0 : false
     * @param value - initial state.
     */
    public MetaTernean(int value) {

        state = value >=  0 ?
                value ==  0 ? (byte) 0 : -1 : 1;

        stateCounts[state + 1]++;
    }

    /**
     * Construct a MetaTernean using a 64-bit integer.
     *  value >  0 : true
     *  value == 0 : maybe
     *  value <  0 : false
     * @param value - initial state.
     */
    public MetaTernean(long value) {

        state = value >=  0 ?
                value ==  0 ? (byte) 0 : -1 : 1;

        stateCounts[state + 1]++;
    }

    /**
     * Construct a MetaTernean using a 32-bit floating point.
     *  value >  0 : true
     *  value == 0 : maybe
     *  value <  0 : false
     * @param value - initial state.
     */
    public MetaTernean(float value) {

        state = value >=  0 ?
                value ==  0 ? (byte) 0 : -1 : 1;

        stateCounts[state + 1]++;
    }

    /**
     * Construct a MetaTernean using a 64-bit floating point.
     *  value >  0 : true
     *  value == 0 : maybe
     *  value <  0 : false
     * @param value - initial state.
     */
    public MetaTernean(double value) {

        state = value >=  0 ?
                value ==  0 ? (byte) 0 : -1 : 1;

        stateCounts[state + 1]++;
    }

    /**
     * Copies Ternean state.
     * @param r - Ternean whose state to copy.
     */
    @Override
    public void setValue(Ternean r) {

        super.setValue(r.state);
        stateCounts[state + 1]++;
    }

    /**
     * Set MetaTernean state using a boolean value.
     * @param value - boolean input.
     */
    @Override
    public void setValue(boolean value) {

        super.setValue(value);
        stateCounts[state + 1]++;
    }

    /**
     * Set MetaTernean state using a char shorthand.
     *  t | T : true
     *  other : maybe
     *  f | F : false
     * @param value - character input.
     */
    @Override
    public void setValue(char value) {

        super.setValue(value);
        stateCounts[state + 1]++;
    }

    /**
     * Set MetaTernean state using a string.
     *  true | True | TRUE    : true
     *  other : maybe
     *  false | False | FALSE : false
     * @param value - string input.
     */
    @Override
    public void setValue(String value) {

        super.setValue(value);
        stateCounts[state + 1]++;
    }

    /**
     * Set MetaTernean state using an 8-bit integer.
     *  value >  0 : true
     *  value == 0 : maybe
     *  value <  0 : false
     * @param value - numeric input.
     */
    @Override
    public void setValue(byte value) {

        super.setValue(value);
        stateCounts[state + 1]++;
    }

    /**
     * Set MetaTernean state using a 16-bit integer.
     *  value >  0 : true
     *  value == 0 : maybe
     *  value <  0 : false
     * @param value - numeric input.
     */
    @Override
    public void setValue(short value) {

        super.setValue(value);
        stateCounts[state + 1]++;
    }

    /**
     * Set MetaTernean state using a 32-bit integer.
     *  value >  0 : true
     *  value == 0 : maybe
     *  value <  0 : false
     * @param value - numeric input.
     */
    @Override
    public void setValue(int value) {

        super.setValue(value);
        stateCounts[state + 1]++;
    }

    /**
     * Set MetaTernean state using a 64-bit integer.
     *  value >  0 : true
     *  value == 0 : maybe
     *  value <  0 : false
     * @param value - numeric input.
     */
    @Override
    public void setValue(long value) {

        super.setValue(value);
        stateCounts[state + 1]++;
    }

    /**
     * Set MetaTernean state using a 32-bit floating point.
     *  value >  0 : true
     *  value == 0 : maybe
     *  value <  0 : false
     * @param value - numeric input.
     */
    @Override
    public void setValue(float value) {

        super.setValue(value);
        stateCounts[state + 1]++;
    }

    /**
     * Set MetaTernean state using a 64-bit floating point.
     *  value >  0 : true
     *  value == 0 : maybe
     *  value <  0 : false
     * @param value - numeric input.
     */
    @Override
    public void setValue(double value) {

        super.setValue(value);
        stateCounts[state + 1]++;
    }

    /**
     * Returns a string representing the state history of this MetaTernean.
     * @return - a string of the form "{T:int1, M: int2, F:int3}"
     */
    public String historyToString()
    {
        return  "{T:"           +
                stateCounts[2]  +
                ", M:"          +
                stateCounts[1]  +
                ", F:"          +
                stateCounts[0]  +
                "}";
    }

    /**
     * Returns a string representing the current state and state history.
     * @return - a string of the form "[false|maybe|true] {T:int1, M:int2, F:int3}"
     */
    @Override
    public String toString() {

        switch(state) {

            case -1: {

                return "false " + historyToString();
            }
            case 1: {

                return "true " + historyToString();
            }
            default: {

                return "maybe " + historyToString();
            }
        }
    }

    /**
     * Get the number of times this MetaTernean has had a true state.
     * @return - an int with the true state history.
     */
    public int getTrueHistory()
    {

        return stateCounts[2];
    }

    /**
     * Get the number of times this MetaTernean has had a maybe state.
     * @return - an int with the maybe state history.
     */
    public int getMaybeHistory()
    {

        return stateCounts[1];
    }

    /**
     * Get the number of times this MetaTernean has had a false state.
     * @return - an int with the false state history.
     */
    public int getFalseHistory()
    {

        return stateCounts[0];
    }

    /**
     * Returns true if this and MetaTernean r have equal values for all state history.
     * @param r - right-hand operand
     * @return - boolean test result
     */
    public boolean historyEquals(MetaTernean r) {

        return  stateCounts[0] == r.stateCounts[0] &&
                stateCounts[1] == r.stateCounts[1] &&
                stateCounts[2] == r.stateCounts[2];
    }

    /**
     * Returns true if this and MetaTernean r have had true state the same number of times.
     * @param r - right-hand operand
     * @return - boolean test result
     */
    public boolean trueHistoryEquals(MetaTernean r) {

        return stateCounts[2] == r.stateCounts[2];
    }

    /**
     * Returns true if this and MetaTernean r have had maybe state the same number of times.
     * @param r - right-hand operand
     * @return - boolean test result
     */
    public boolean maybeHistoryEquals(MetaTernean r) {

        return stateCounts[1] == r.stateCounts[1];
    }

    /**
     * Returns true if this and MetaTernean r have has false state the same number of times.
     * @param r - right-hand operand
     * @return - boolean test result
     */
    public boolean falseHistoryEquals(MetaTernean r) {

        return stateCounts[0] == r.stateCounts[0];
    }

    /**
     * Returns a MetaTernean with true state when either predicate is true.
     * Returns a MetaTernean with false state when both predicates are false.
     * All other cases return a MetaTernean with maybe state.
     * State history is not redistributed because MetaTernean does not support probabilities.
     * State history for the new MetaTernean reflects only the state assigned as a result of this operation.
     * @param l - left-hand operand
     * @param r - right-hand operand
     * @return - resultant of an OR operation between l and r
     */
    public static MetaTernean createOr(Ternean l, Ternean r) {

        return new MetaTernean(or3(l.state, r.state));
    }

    /**
     * Returns a MetaTernean with true state when both predicates are true.
     * Returns a MetaTernean with false state when either predicate is false.
     * ALl other cases return a MetaTernean with maybe state.
     * State history is not redistributed because MetaTernean does not support probabilities.
     * State history for the new MetaTernean reflects only the state assigned as a result of this operation.
     * @param l - left-hand operand
     * @param r - right-hand operand
     * @return - resultant of an AND operation between l and r
     */
    public static MetaTernean createAnd(Ternean l, Ternean r) {

        return new MetaTernean(and3(l.state, r.state));
    }

    /**
     * Returns a MetaTernean with true state where l is true and r is not false.
     * Returns a MetaTernean with false state where l is true and r is false.
     * ALl other cases return a MetaTernean in l maybe state.
     * State history is not redistributed because MetaTernean does not support probabilities.
     * State history for the new MetaTernean reflects only the state assigned as a result of this operation.
     * @param l - left-hand operand
     * @param r - right-hand operand
     * @return - resultant of RMP operation between l and r
     */
    public static MetaTernean createRImp(Ternean l, Ternean r) {

        return new MetaTernean(rImp3(l.state, r.state));
    }

    /**
     * Returns a MetaTernean with true state where r is true and l is not false.
     * Returns a MetaTernean with false state where r is true and l is false.
     * ALl other cases return a MetaTernean in l maybe state.
     * State history is not redistributed because MetaTernean does not support probabilities.
     * State history for the new MetaTernean reflects only the state assigned as a result of this operation.
     * @param l - left-hand operand
     * @param r - right-hand operand
     * @return - resultant of LMP operation between l and r
     */
    public static MetaTernean createLImp(Ternean l, Ternean r) {

        return new MetaTernean(lImp3(l.state, r.state));
    }

    /**
     * Returns a MetaTernean with true state when neither predicate is maybe and one predicate is true.
     * Returns a MetaTernean with false state when neither predicate is maybe and the predicates are in the same state.
     * Returns a MetaTernean with maybe state when either predicate is maybe.
     * State history is not redistributed because MetaTernean does not support probabilities.
     * State history for the new MetaTernean reflects only the state assigned as a result of this operation.
     * @param l - left-hand operand
     * @param r - right-hand operand
     * @return - resultant of XOR operation between l and r
     */
    public static MetaTernean createXor(Ternean l, Ternean r) {

        return new MetaTernean(xor3(l.state, r.state));
    }

    /**
     * Returns a MetaTernean with true state if neither predicate is maybe and the predicates have the same state.
     * Returns a MetaTernean with false state if neither predicate is maybe and the predicates have different state.
     * Returns a MetaTernean with maybe state if either predicate is maybe.
     * State history is not redistributed because MetaTernean does not support probabilities.
     * State history for the new MetaTernean reflects only the state assigned as a result of this operation.
     * @param l - left-hand operand
     * @param r - right-hand operand
     * @return - resultant of EQU operation between l and r
     */
    public static MetaTernean createEqu(Ternean l, Ternean r) {

        return new MetaTernean(equ3(l.state, r.state));
    }

    /**
     * Returns a MetaTernean in true state where l is in false state.
     * Returns a MetaTernean in false state where l is in true state.
     * Returns a MetaTernean in maybe state where l is in maybe state.
     * State history is not redistributed because MetaTernean does not support probabilities.
     * State history for the new MetaTernean reflects only the state assigned as a result of this operation.
     * @param l - operand
     * @return - resultant of a NOT operation on MetaTernean l
     */
    public static MetaTernean createNeg(Ternean l) {

        return new MetaTernean(neg3(l.state));
    }

    /**
     * Sets this MetaTernean to a true state when either predicate is true.
     * Sets this MetaTernean to a false state when both predicates are false.
     * All other cases set this MetaTernean to a maybe state.
     * State history is not redistributed because MetaTernean does not support probabilities.
     * State history is updated as though the resultant is a new sample.
     * @param r - right-hand operand
     * @return - this MetaTernean as the resultant of an OR operation with r
     */
    public MetaTernean setOr(Ternean r) {

        state = or3(state, r.state);
        stateCounts[state + 1]++;

        return this;
    }

    /**
     * Sets this MetaTernean to a true state when both predicates are true.
     * Sets this MetaTernean to a false state when either predicate is false.
     * ALl other cases set this MetaTernean to a maybe state.
     * State history is not redistributed because MetaTernean does not support probabilities.
     * State history is updated as though the resultant is a new sample.
     * @param r - right-hand operand
     * @return - this MetaTernean as the resultant of an AND operation with r
     */
    public MetaTernean setAnd(Ternean r) {

        state = and3(state, r.state);
        stateCounts[state + 1]++;

        return this;
    }

    /**
     * Sets this MetaTernean to a true state where a is true and r is not false.
     * Sets this MetaTernean to a false state where a is true and r is false.
     * ALl other cases sets this MetaTernean to a maybe state.
     * State history is not redistributed because MetaTernean does not support probabilities.
     * State history is updated as though the resultant is a new sample.
     * @param r - right-hand operand
     * @return - this MetaTernean as the resultant of RMP operation with r
     */
    public MetaTernean setRImp(Ternean r) {

        state = rImp3(state, r.state);
        stateCounts[state + 1]++;

        return this;
    }

    /**
     * Sets this MetaTernean to a true state where r is true and a is not false.
     * Sets this MetaTernean to a false state where r is true and a is false.
     * ALl other cases sets this MetaTernean to a maybe state.
     * State history is not redistributed because MetaTernean does not support probabilities.
     * State history is updated as though the resultant is a new sample.
     * @param r - right-hand operand
     * @return - this MetaTernean the as resultant of LMP operation with r
     */
    public MetaTernean setLImp(Ternean r) {

        state = lImp3(state, r.state);
        stateCounts[state + 1]++;

        return this;
    }

    /**
     * Sets this MetaTernean to a true state when neither predicate is maybe and one predicate is true.
     * Returns a MetaTernean with false state if neither predicate is maybe and the predicates have different state.
     * Sets this MetaTernean to a maybe state when either predicate is maybe.
     * State history is not redistributed because MetaTernean does not support probabilities.
     * State history is updated as though the resultant is a new sample.
     * @param r - right-hand operand
     * @return - this MetaTernean as the resultant of XOR operation with r
     */
    public MetaTernean setXor(Ternean r) {

        state = xor3(state, r.state);
        stateCounts[state + 1]++;

        return this;
    }

    /**
     * Sets this MetaTernean to a true state if neither predicate is maybe and the predicates have the same state.
     * Sets this MetaTernean to a false state if neither predicate is maybe and the predicates do not have the same state.
     * Sets this MetaTernean to a maybe state if either predicate is maybe.
     * State history is not redistributed because MetaTernean does not support probabilities.
     * State history is updated as though the resultant is a new sample.
     * @param r - right-hand operand
     * @return - this MetaTernean as the resultant of EQU operation with r
     */
    public MetaTernean setEqu(Ternean r) {

        state = equ3(state, r.state);
        stateCounts[state + 1]++;

        return this;
    }

    /**
     * Sets this MetaTernean to true state where it is in false state.
     * Sets this MetaTernean to false state where it is in true state.
     * Sets this MetaTernean this maybe state where it is in maybe state.
     * State history is not redistributed because MetaTernean does not support probabilities.
     * State history is updated as though the resultant is a new sample.
     * @return - this as the resultant of a NOT operation on this
     */
    public MetaTernean setNeg() {

        state = neg3(state);
        stateCounts[state + 1]++;

        return this;
    }
}
