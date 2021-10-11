import static java.lang.Math.abs;

public class TerneanOps {
    
    public static byte or3(byte l, byte r) {

        return (byte) (
                
                l + r <= 0        ?
                l != 0 && r != 0  ?
                l + r != 0        ?  -1 : 1 : 0 : 1
        );
    }
    
    public static byte and3(byte l, byte r) {
        
        return (byte) (

                l + r != 2            ?
                l != -1 && r != -1    ? 0 : -1 : 1
        );
    }
    
    public static byte rImp3(byte l, byte r) {
        
        return (byte) (

            l != -1     ?
            l !=  1     ?
            r !=  1   ?  0 : 1 : r : 1
        );
    }
    
    public static byte lImp3(byte l, byte r) {
        
        return (byte) (

            r != -1   ?
            r !=  1   ?
            l !=  1     ?  0 : 1 : l : 1
        );
    }
    
    public static byte xor3(byte l, byte r) {
        
        return (byte) (

                abs(l + r) != 2   ?
                l * r != 0        ?  1 : 0 : -1
        );
    }
    
    public static byte equ3(byte l, byte r) {
        
        return (byte) (

            l * r != 0    ?
            l != r        ? -1 : 1 : 0
        );
    }
    
    public static byte neg3(byte l) {
        
        return (byte) (

            l != 0 ?
            l != 1 ? 1 : -1 : 0
        );
    }
}
