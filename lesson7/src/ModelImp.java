public class ModelImp implements Model {

    @Override
    public double addition(double term1, double term2) {
        return term1+term2;
    }

    @Override
    public double subtraction(double minuend, double subtrahend) {
        return minuend-subtrahend;
    }

    @Override
    public double multiplication(double multiplicand, double multiplier) {
        return multiplicand*multiplier;
    }

    @Override
    public double segmentation(double divident, double divider) {
        return divident/divider;
    }
}
