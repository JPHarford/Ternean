
/**
 * Provides on-demand pre-calculated ternary state probabilities.
 * @author - Jeremy P. Harford
 * @author - https://github.com/JPHarford
 */
@SuppressWarnings("unused")
public class ProTernean extends MetaTernean {

    protected double[] probabilities = new double[] {0,0,0};
    protected long samples = 0;

    public ProTernean(){}

    /**
     * Copy constructor creates a ProTernean with the same state, history, and probabilities as the source.
     * @param source - the MetaTernean to be copied.
     */
    public ProTernean(ProTernean source) {

        state = source.state;

        stateCounts[0] = source.stateCounts[0];
        stateCounts[1] = source.stateCounts[1];
        stateCounts[2] = source.stateCounts[2];

        probabilities[0] = source.probabilities[0];
        probabilities[1] = source.probabilities[1];
        probabilities[2] = source.probabilities[2];

        samples = source.samples;
    }

    /**
     * Copy constructor creates a ProTernean with the same state, history, and probabilities as the source.
     * @param source - the MetaTernean to be copied.
     */
    public ProTernean(MetaTernean source) {

        state = source.state;

        stateCounts[0] = source.stateCounts[0];
        stateCounts[1] = source.stateCounts[1];
        stateCounts[2] = source.stateCounts[2];

        samples = stateCounts[0] + stateCounts[1] + stateCounts[2];

        probabilities[0] = (double) stateCounts[0]/samples;
        probabilities[1] = (double) stateCounts[1]/samples;
        probabilities[2] = (double) stateCounts[2]/samples;

    }

    public ProTernean(Ternean source) {

        state = source.state;
        samples = 1;

        stateCounts[state + 1] = 1;

        probabilities[state + 1] = 1;
    }

    public ProTernean(boolean value) {

        this.state = value ? (byte) 1 : -1;

        initialize(this);
    }

    public ProTernean(char value) {

        state = value != 't' && value != 'T' ?
                value == 'f' || value == 'F' ? (byte) -1 : 0 : 1;

        initialize(this);
    }

    public ProTernean(String value) {

        state = fromString(value);
        initialize(this);
    }

    public ProTernean(byte value) {

        state = value >=  0 ?
                value ==  0 ? (byte) 0 : -1 : 1;

        initialize(this);
    }

    public ProTernean(short value) {

        state = value >=  0 ?
                value ==  0 ? (byte) 0 : -1 : 1;

        initialize(this);
    }

    public ProTernean(int value) {

        state = value >=  0 ?
                value ==  0 ? (byte) 0 : -1 : 1;

        initialize(this);
    }

    public ProTernean(long value) {

        state = value >=  0 ?
                value ==  0 ? (byte) 0 : -1 : 1;

        initialize(this);
    }

    public ProTernean(float value) {

        state = value >=  0 ?
                value ==  0 ? (byte) 0 : -1 : 1;

        initialize(this);
    }

    public ProTernean(double value) {

        state = value >=  0 ?
                value ==  0 ? (byte) 0 : -1 : 1;

        initialize(this);
    }

    @Override
    public void setValue(Ternean source) {

        super.setValue(source);
        samples++;
        refreshProbabilities(this);
    }

    @Override
    public void setValue(boolean value) {

        super.setValue(value);
        samples++;
        refreshProbabilities(this);
    }

    @Override
    public void setValue(char value) {

        super.setValue(value);
        samples++;
        refreshProbabilities(this);
    }

    @Override
    public void setValue(String value) {

        super.setValue(value);
        samples++;
        refreshProbabilities(this);
    }

    @Override
    public void setValue(byte value) {

        super.setValue(value);
        samples++;
        refreshProbabilities(this);
    }

    @Override
    public void setValue(short value) {

        super.setValue(value);
        samples++;
        refreshProbabilities(this);
    }

    @Override
    public void setValue(int value) {

        super.setValue(value);
        samples++;
        refreshProbabilities(this);
    }

    @Override
    public void setValue(long value) {

        super.setValue(value);
        samples++;
        refreshProbabilities(this);
    }

    @Override
    public void setValue(float value) {

        super.setValue(value);
        samples++;
        refreshProbabilities(this);
    }

    @Override
    public void setValue(double value) {

        super.setValue(value);
        samples++;
        refreshProbabilities(this);
    }

    private static void initialize(ProTernean l) {

        l.stateCounts  [l.state + 1] = 1;
        l.probabilities[l.state + 1] = 1;
        l.samples = 1;
    }

    private static void refreshProbabilities(ProTernean l) {

        l.probabilities[0] = (double) l.stateCounts[0] / l.samples;
        l.probabilities[1] = (double) l.stateCounts[1] / l.samples;
        l.probabilities[2] = (double) l.stateCounts[2] / l.samples;
    }

    public static int[] probOrStateCounts(ProTernean l, ProTernean r) {

        long roundOffError;
        int[] resultant = new int[3];

        resultant[0] =  (int) ((l.probabilities[0] * r.probabilities[0]) * (l.samples + r.samples));

        resultant[1] =  (int) ((l.probabilities[0] * r.probabilities[1]) * (l.samples + r.samples));
        resultant[1] += (int) ((l.probabilities[1] * r.probabilities[1]) * (l.samples + r.samples));
        resultant[1] += (int) ((l.probabilities[1] * r.probabilities[0]) * (l.samples + r.samples));

        resultant[2] =  (int) ((l.probabilities[0] * r.probabilities[2]) * (l.samples + r.samples));
        resultant[2] += (int) ((l.probabilities[1] * r.probabilities[2]) * (l.samples + r.samples));
        resultant[2] += (int) ((l.probabilities[2] * r.probabilities[0]) * (l.samples + r.samples));
        resultant[2] += (int) ((l.probabilities[2] * r.probabilities[1]) * (l.samples + r.samples));
        resultant[2] += (int) ((l.probabilities[2] * r.probabilities[2]) * (l.samples + r.samples));

        roundOffError = l.samples + r.samples - resultant[0] - resultant[1] - resultant[2];
        resultant[1] -= roundOffError;

        return resultant;
    }

    public static int[] probAndStateCounts(ProTernean l, ProTernean r) {

        long roundOffError;
        int[] resultant = new int[3];

        resultant[0] =  (int) ((l.probabilities[0] * r.probabilities[0]) * (l.samples + r.samples));
        resultant[0] += (int) ((l.probabilities[0] * r.probabilities[1]) * (l.samples + r.samples));
        resultant[0] += (int) ((l.probabilities[0] * r.probabilities[2]) * (l.samples + r.samples));
        resultant[0] += (int) ((l.probabilities[1] * r.probabilities[0]) * (l.samples + r.samples));
        resultant[0] += (int) ((l.probabilities[2] * r.probabilities[0]) * (l.samples + r.samples));

        resultant[1] =  (int) ((l.probabilities[1] * r.probabilities[1]) * (l.samples + r.samples));
        resultant[1] += (int) ((l.probabilities[1] * r.probabilities[2]) * (l.samples + r.samples));
        resultant[1] += (int) ((l.probabilities[2] * r.probabilities[1]) * (l.samples + r.samples));

        resultant[2] = (int) ((l.probabilities[2] * r.probabilities[2]) * (l.samples + r.samples));

        roundOffError = l.samples + r.samples - resultant[0] - resultant[1] - resultant[2];
        resultant[1] -= roundOffError;

        return resultant;
    }
    
    public static int[] probRImpStateCounts(ProTernean l, ProTernean r) {

        long roundOffError;
        int[] resultant = new int[3];

        resultant[0] =  (int) ((l.probabilities[2] * r.probabilities[0]) * (l.samples + r.samples));

        resultant[1] =  (int) ((l.probabilities[1] * r.probabilities[1]) * (l.samples + r.samples));
        resultant[1] += (int) ((l.probabilities[1] * r.probabilities[0]) * (l.samples + r.samples));
        resultant[1] += (int) ((l.probabilities[2] * r.probabilities[1]) * (l.samples + r.samples));

        resultant[2] =  (int) ((l.probabilities[0] * r.probabilities[0]) * (l.samples + r.samples));
        resultant[2] += (int) ((l.probabilities[0] * r.probabilities[1]) * (l.samples + r.samples));
        resultant[2] += (int) ((l.probabilities[0] * r.probabilities[2]) * (l.samples + r.samples));
        resultant[2] += (int) ((l.probabilities[1] * r.probabilities[2]) * (l.samples + r.samples));
        resultant[2] += (int) ((l.probabilities[2] * r.probabilities[2]) * (l.samples + r.samples));
        
        roundOffError = l.samples + r.samples - resultant[0] - resultant[1] - resultant[2];
        resultant[1] -= roundOffError;

        return resultant;
    }

    public static int[] probLImpStateCounts(ProTernean l, ProTernean r) {

        long roundOffError;
        int[] resultant = new int[3];

        resultant[0] =  (int) ((l.probabilities[0] * r.probabilities[2]) * (l.samples + r.samples));

        resultant[1] =  (int) ((l.probabilities[1] * r.probabilities[1]) * (l.samples + r.samples));
        resultant[1] += (int) ((l.probabilities[0] * r.probabilities[1]) * (l.samples + r.samples));
        resultant[1] += (int) ((l.probabilities[1] * r.probabilities[2]) * (l.samples + r.samples));

        resultant[2] =  (int) ((l.probabilities[0] * r.probabilities[0]) * (l.samples + r.samples));
        resultant[2] += (int) ((l.probabilities[1] * r.probabilities[0]) * (l.samples + r.samples));
        resultant[2] += (int) ((l.probabilities[2] * r.probabilities[0]) * (l.samples + r.samples));
        resultant[2] += (int) ((l.probabilities[2] * r.probabilities[1]) * (l.samples + r.samples));
        resultant[2] += (int) ((l.probabilities[2] * r.probabilities[2]) * (l.samples + r.samples));

        roundOffError = l.samples + r.samples - resultant[0] - resultant[1] - resultant[2];
        resultant[1] -= roundOffError;

        return resultant;
    }

    public static int[] probXorStateCounts(ProTernean l, ProTernean r) {

        long roundOffError;
        int[] resultant = new int[3];

        resultant[0]  = (int) ((l.probabilities[0] + r.probabilities[0]) * (l.samples + r.samples));
        resultant[0] += (int) ((l.probabilities[2] + r.probabilities[2]) * (l.samples + r.samples));

        resultant[1]  = (int) ((l.probabilities[1] + r.probabilities[0]) * (l.samples + r.samples));
        resultant[1] += (int) ((l.probabilities[0] + r.probabilities[1]) * (l.samples + r.samples));
        resultant[1] += (int) ((l.probabilities[1] + r.probabilities[2]) * (l.samples + r.samples));
        resultant[1] += (int) ((l.probabilities[2] + r.probabilities[1]) * (l.samples + r.samples));
        resultant[1] += (int) ((l.probabilities[1] + r.probabilities[1]) * (l.samples + r.samples));

        resultant[2]  = (int) ((l.probabilities[2] + r.probabilities[0]) * (l.samples + r.samples));
        resultant[2] += (int) ((l.probabilities[0] + r.probabilities[2]) * (l.samples + r.samples));

        roundOffError = l.samples + r.samples - resultant[0] - resultant[1] - resultant[2];
        resultant[1] -= roundOffError;

        return resultant;
    }
    
    public static int[] probEquStateCounts(ProTernean l, ProTernean r) {

        long roundOffError;
        int[] resultant = new int[3];

        resultant[0]  = (int) ((l.probabilities[0] + r.probabilities[2]) * (l.samples + r.samples));
        resultant[0] += (int) ((l.probabilities[2] + r.probabilities[0]) * (l.samples + r.samples));

        resultant[1]  = (int) ((l.probabilities[0] + r.probabilities[1]) * (l.samples + r.samples));
        resultant[1] += (int) ((l.probabilities[1] + r.probabilities[0]) * (l.samples + r.samples));
        resultant[1] += (int) ((l.probabilities[1] + r.probabilities[1]) * (l.samples + r.samples));
        resultant[1] += (int) ((l.probabilities[1] + r.probabilities[2]) * (l.samples + r.samples));
        resultant[1] += (int) ((l.probabilities[2] + r.probabilities[1]) * (l.samples + r.samples));

        resultant[2]  = (int) ((l.probabilities[0] + r.probabilities[0]) * (l.samples + r.samples));
        resultant[2] += (int) ((l.probabilities[2] + r.probabilities[2]) * (l.samples + r.samples));

        roundOffError = l.samples + r.samples - resultant[0] - resultant[1] - resultant[2];
        resultant[1] -= roundOffError;

        return resultant;
    }

    /**
     * Redistributes state history using state-explicit statistical conjunction for full predicate table coverage.
     * @param l - operand
     * @return - state history reflecting a statistical negation
     */
    public static int[] probNegStateCounts (ProTernean l) {

        int[] resultant = new int[3];

        resultant[0] = l.stateCounts[2];
        resultant[1] = l.stateCounts[1];
        resultant[2] = l.stateCounts[0];

        return resultant;
    }

    /**
     * Returns a ProTernean with true state when either predicate is true.
     * Returns a ProTernean with false state when both predicates are false.
     * All other cases return a ProTernean with maybe state.
     * State history is redistributed using state-explicit statistical conjunction for full predicate table coverage.
     * Resultant probabilities are recalculated using resultant state history.
     * Round off error is accounted for by offsetting maybe state history.
     * @param l - left-hand operand
     * @param r - right-hand operand
     * @return - resultant of an OR operation between l and r
     */
    public static ProTernean createOr(ProTernean l, ProTernean r) {

        ProTernean resultant = new ProTernean(or3(l.state, r.state));

        int[] stateCounts = probOrStateCounts(l, r);
        resultant.stateCounts[0] = stateCounts[0];
        resultant.stateCounts[1] = stateCounts[1];
        resultant.stateCounts[2] = stateCounts[2];

        resultant.samples = resultant.stateCounts[0] + resultant.stateCounts[1] + resultant.stateCounts[2];

        refreshProbabilities(resultant);

        return resultant;
    }

    /**
     * Up-Casts MetaTernean operands by calculating probabilities on the state histories.
     * Returns createAnd(ProTernean, ProTernean) using upcast operands.
     * @param l - left-hand operand
     * @param r - right-hand operand
     * @return - resultant of LMP operation between l and r
     */
    public static ProTernean createOr(MetaTernean l, MetaTernean r) {

        return createOr(new ProTernean(l), new ProTernean(r));
    }

    /**
     * Returns a MetaTernean with true state when both predicates are true.
     * Returns a MetaTernean with false state when either predicate is false.
     * ALl other cases return a MetaTernean with maybe state.
     * State history is redistributed using state-explicit statistical conjunction for full predicate table coverage.
     * Resultant probabilities are recalculated using resultant state history.
     * Round off error is accounted for by offsetting maybe state history.
     * @param l - left-hand operand
     * @param r - right-hand operand
     * @return - resultant of an AND operation between l and r
     */
    public static ProTernean createAnd(ProTernean l, ProTernean r) {

        ProTernean resultant = new ProTernean(and3(l.state, r.state));

        int[] stateCounts = probAndStateCounts(l, r);
        resultant.stateCounts[0] = stateCounts[0];
        resultant.stateCounts[1] = stateCounts[1];
        resultant.stateCounts[2] = stateCounts[2];

        resultant.samples = resultant.stateCounts[0] + resultant.stateCounts[1] + resultant.stateCounts[2];

        refreshProbabilities(resultant);

        return resultant;
    }

    /**
     * Up-Casts MetaTernean operands by calculating probabilities on the state histories.
     * Returns createAnd(ProTernean, ProTernean) using upcast operands.
     * @param l - left-hand operand
     * @param r - right-hand operand
     * @return - resultant of LMP operation between l and r
     */
    public static ProTernean createAnd(MetaTernean l, MetaTernean r) {

        return createAnd(new ProTernean(l), new ProTernean(r));
    }

    /**
     * Returns a MetaTernean with true state where l is true and r is not false.
     * Returns a MetaTernean with false state where l is true and r is false.
     * ALl other cases return a MetaTernean in l maybe state.
     * State history is redistributed using state-explicit statistical conjunction for full predicate table coverage.
     * Resultant probabilities are recalculated using resultant state history.
     * Round off error is accounted for by offsetting maybe state history.
     * @param l - left-hand operand
     * @param r - right-hand operand
     * @return - resultant of RMP operation between l and r
     */
    public static ProTernean createRImp(ProTernean l, ProTernean r) {

        ProTernean resultant = new ProTernean(rImp3(l.state, r.state));

        int[] stateCounts = probRImpStateCounts(l, r);
        resultant.stateCounts[0] = stateCounts[0];
        resultant.stateCounts[1] = stateCounts[1];
        resultant.stateCounts[2] = stateCounts[2];

        resultant.samples = resultant.stateCounts[0] + resultant.stateCounts[1] + resultant.stateCounts[2];

        refreshProbabilities(resultant);

        return resultant;
    }

    /**
     * Up-Casts MetaTernean operands by calculating probabilities on the state histories.
     * Returns createRImp(ProTernean, ProTernean) using upcast operands.
     * @param l - left-hand operand
     * @param r - right-hand operand
     * @return - resultant of LMP operation between l and r
     */
    public static ProTernean createRImp(MetaTernean l, MetaTernean r) {

        return createRImp(new ProTernean(l), new ProTernean(r));
    }

    /**
     * Returns a MetaTernean with true state where r is true and l is not false.
     * Returns a MetaTernean with false state where r is true and l is false.
     * ALl other cases return a MetaTernean in l maybe state.
     * State history is redistributed using state-explicit statistical conjunction for full predicate table coverage.
     * Resultant probabilities are recalculated using resultant state history.
     * Round off error is accounted for by offsetting maybe state history.
     * @param l - left-hand operand
     * @param r - right-hand operand
     * @return - resultant of LMP operation between l and r
     */
    public static ProTernean createLImp(ProTernean l, ProTernean r) {

        ProTernean resultant = new ProTernean(lImp3(l.state, r.state));

        int[] stateCounts = probLImpStateCounts(l, r);
        resultant.stateCounts[0] = stateCounts[0];
        resultant.stateCounts[1] = stateCounts[1];
        resultant.stateCounts[2] = stateCounts[2];

        resultant.samples = resultant.stateCounts[0] + resultant.stateCounts[1] + resultant.stateCounts[2];

        refreshProbabilities(resultant);

        return resultant;
    }

    /**
     * Up-Casts MetaTernean operands by calculating probabilities on the state histories.
     * Returns createLImp(ProTernean, ProTernean) using upcast operands.
     * @param l - left-hand operand
     * @param r - right-hand operand
     * @return - resultant of LMP operation between l and r
     */
    public static ProTernean createLImp(MetaTernean l, MetaTernean r) {

        return createLImp(new ProTernean(l), new ProTernean(r));
    }

    /**
     * Returns a MetaTernean with true state when neither predicate is maybe and one predicate is true.
     * Returns a MetaTernean with false state if neither predicate is maybe and the predicates have different state.
     * Returns a MetaTernean with maybe state when either predicate is maybe.
     * State history is redistributed using state-explicit statistical conjunction for full predicate table coverage.
     * Resultant probabilities are recalculated using resultant state history.
     * Round off error is accounted for by offsetting maybe state history.
     * @param l - left-hand operand
     * @param r - right-hand operand
     * @return - resultant of XOR operation between l and r
     */
    public static ProTernean createXor(ProTernean l, ProTernean r) {

        ProTernean resultant = new ProTernean(xor3(l.state, r.state));

        int[] stateCounts = probXorStateCounts(l, r);
        resultant.stateCounts[0] = stateCounts[0];
        resultant.stateCounts[1] = stateCounts[1];
        resultant.stateCounts[2] = stateCounts[2];

        resultant.samples = resultant.stateCounts[0] + resultant.stateCounts[1] + resultant.stateCounts[2];

        refreshProbabilities(resultant);

        return resultant;
    }

    /**
     * Up-Casts MetaTernean operands by calculating probabilities on the state histories.
     * Returns createXor(ProTernean, ProTernean) using upcast operands.
     * @param l - left-hand operand
     * @param r - right-hand operand
     * @return - resultant of XOR operation between l and r
     */
    public static ProTernean createXor(MetaTernean l, MetaTernean r) {

        return createXor(new ProTernean(l), new ProTernean(r));
    }

    /**
     * Returns a MetaTernean with true state if neither predicate is maybe and the predicates have the same state.
     * Returns a MetaTernean with false state if neither predicate is maybe and the predicates have different state.
     * Returns a MetaTernean with maybe state if either predicate is maybe.
     * State history is redistributed using state-explicit statistical conjunction for full predicate table coverage.
     * Resultant probabilities are recalculated using resultant state history.
     * Round off error is accounted for by offsetting maybe state history.
     * @param l - left-hand operand
     * @param r - right-hand operand
     * @return - resultant of EQU operation between l and r
     */
    public static ProTernean createEqu(ProTernean l, ProTernean r) {

        ProTernean resultant = new ProTernean(equ3(l.state, r.state));

        int[] stateCounts = probEquStateCounts(l, r);
        resultant.stateCounts[0] = stateCounts[0];
        resultant.stateCounts[1] = stateCounts[1];
        resultant.stateCounts[2] = stateCounts[2];

        resultant.samples = resultant.stateCounts[0] + resultant.stateCounts[1] + resultant.stateCounts[2];

        refreshProbabilities(resultant);

        return resultant;
    }

    /**
     * Up-Casts MetaTernean operands by calculating probabilities on the state histories.
     * Returns createEqu(ProTernean, ProTernean) using upcast operands.
     * @param l - left-hand operand
     * @param r - right-hand operand
     * @return - resultant of EQU operation between l and r
     */
    public static ProTernean createEqu(MetaTernean l, MetaTernean r) {

        return createEqu(new ProTernean(l), new ProTernean(r));
    }

    /**
     * Returns a MetaTernean in true state where l is in false state.
     * Returns a MetaTernean in false state where l is in true state.
     * Returns a MetaTernean in maybe state where l is in maybe state.
     * State history is redistributed using state-explicit statistical conjunction for full predicate table coverage.
     * Resultant probabilities are recalculated using resultant state history.
     * Round off error is accounted for by offsetting maybe state history.
     * @param l - operand
     * @return - resultant of a NOT operation on MetaTernean l
     */
    public static ProTernean createNeg(ProTernean l) {

        ProTernean resultant = new ProTernean(neg3(l.state));

        resultant.stateCounts[0] = l.stateCounts[2];
        resultant.stateCounts[1] = l.stateCounts[1];
        resultant.stateCounts[2] = l.stateCounts[0];

        resultant.samples = l.samples;

        refreshProbabilities(resultant);

        return resultant;
    }

    /**
     * Up-Casts MetaTernean operands by calculating probabilities on the state histories.
     * Returns createNeg(ProTernean, ProTernean) using upcast operands.
     * @param l - operand
     * @return - resultant of a NOT operation on MetaTernean l
     */
    public static ProTernean createNeg(MetaTernean l) {

        return createNeg(new ProTernean(l));
    }
}
