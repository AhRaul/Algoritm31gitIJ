// Посредник, между View и Model. Логика связи.
public class Controller {
    public static final String SEQ = "/";
    public static final String MUL = "*";
    public static final String SUB = "-";
    public static final String ADD = "+";

    public static final String RESULT = "=";

    public static final String C = "C";

    private double x = 0.0;
    private double y = 0.0;
    private double result = 0.0;
    private boolean firstOperation = true;
    private String memLastOperation = "";

    private ModelImp model = new ModelImp();
    private View view;

    public Controller(View view) {
        this.view = view;
    }

    public void update(String push) {
        if (push.equals(C)) {
            x = 0.0;
            y = 0.0;
            result = 0.0;
            firstOperation = true;

        } else if (view.readTextField().equals("")) {

        } else if (push.equals(SEQ)) {      //пришла команда делить
            memLastOperation = SEQ;
            if (firstOperation) {
                x = readTextFieldToDub();
                firstOperation = false;
            } else {
                y = readTextFieldToDub();
                result = model.segmentation(x, y);
                writeTextFieldToString(result);
                x = result;
            }

        } else if (push.equals(MUL)) {      //пришла команда умножить
            memLastOperation = MUL;
            if (firstOperation) {
                x = readTextFieldToDub();
                firstOperation = false;
            } else {
                y = readTextFieldToDub();
                result = model.multiplication(x, y);
                writeTextFieldToString(result);
                x = result;
            }

        } else if (push.equals(SUB)) {      //пришла команда минус
            memLastOperation = SUB;
            if (firstOperation) {
                x = readTextFieldToDub();
                firstOperation = false;
            } else {
                y = readTextFieldToDub();
                result = model.subtraction(x, y);
                writeTextFieldToString(result);
                x = result;
            }

        } else if (push.equals(ADD)) {      //пришла команда плюс
            memLastOperation = ADD;
            if (firstOperation) {
                x = readTextFieldToDub();
                firstOperation = false;
            } else {
                y = readTextFieldToDub();
                result = model.addition(x, y);
                writeTextFieldToString(result);
                x = result;
            }

        }else if (push.equals(RESULT)) {            //пришла команда "="
            if(memLastOperation.equals(SEQ)) {
                y = readTextFieldToDub();
                result = model.segmentation(x, y);
                writeTextFieldToString(result);
                firstOperation = true;
            } else if(memLastOperation.equals(MUL)) {
                y = readTextFieldToDub();
                result = model.multiplication(x, y);
                writeTextFieldToString(result);
                firstOperation = true;
            } else if(memLastOperation.equals(SUB)) {
                y = readTextFieldToDub();
                result = model.subtraction(x, y);
                writeTextFieldToString(result);
                firstOperation = true;
            } else if(memLastOperation.equals(ADD)) {
                y = readTextFieldToDub();
                result = model.addition(x, y);
                writeTextFieldToString(result);
                firstOperation = true;
            } else { }

        }
    }

    private double readTextFieldToDub() {
        return Double.parseDouble(view.readTextField());
    }

    private void writeTextFieldToString(double value) {
        view.setAtTextField(String.valueOf(value));
    }
}
