package leetcode;

public class LC537_ComplexNumberMultiplication {
    class Complex {
        int a, b;
        Complex(int a, int b) {
            this.a = a;
            this.b = b;
        }
        
        public Complex multiply(Complex that) {
            int real = this.a * that.a - this.b * that.b;
            int im = this.b * that.a + this.a * that.b;
            return new Complex(real, im);
        }
        
        @Override
        public String toString() {
            return a + "+" + b + "i";
        }
    }
    
    private Complex parseComplex(String s) {
        String[] parts = s.split("\\+");
        String real = parts[0];
        String im = parts[1].substring(0, parts[1].length() - 1);
        return new Complex(Integer.parseInt(real), Integer.parseInt(im));
    }
    
    public String complexNumberMultiply(String a, String b) {
        Complex ca = parseComplex(a);
        Complex cb = parseComplex(b);
        return ca.multiply(cb).toString();
    }
}
