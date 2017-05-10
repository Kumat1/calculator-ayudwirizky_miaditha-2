import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Acer on 10/05/2017.
 */
public class calculator {
    private Double operasiSatu;
    private Double operasiDua;
    private Operation calcOperation;
    private JTextField outputTbl;
    private JButton deleteTbl;
    private JButton plusminusTbl;
    private JButton percentTbl;
    private JButton divideTbl;
    private JButton satuTbl;
    private JButton duaTbl;
    private JButton tigaTbl;
    private JButton multiplyTbl;
    private JButton empatTbl;
    private JButton limaTbl;
    private JButton enamTbl;
    private JButton minusTbl;
    private JButton tujuhTbl;
    private JButton delapanTbl;
    private JButton sembilanTbl;
    private JButton plusTbl;
    private JButton nolTbl;
    private JButton comaTbl;
    private JButton equalsTbl;
    private JPanel dispCalc;
    private JButton akarTbl;
    private JButton pangkatTbl;


    public calculator() {

        tujuhTbl.addActionListener(new NumberBtnClicked(tujuhTbl.getText()));
        delapanTbl.addActionListener(new NumberBtnClicked(delapanTbl.getText()));
        sembilanTbl.addActionListener(new NumberBtnClicked(sembilanTbl.getText()));
        empatTbl.addActionListener(new NumberBtnClicked(empatTbl.getText()));
        limaTbl.addActionListener(new NumberBtnClicked(limaTbl.getText()));
        enamTbl.addActionListener(new NumberBtnClicked(enamTbl.getText()));
        satuTbl.addActionListener(new NumberBtnClicked(satuTbl.getText()));
        duaTbl.addActionListener(new NumberBtnClicked(duaTbl.getText()));
        tigaTbl.addActionListener(new NumberBtnClicked(tigaTbl.getText()));
        nolTbl.addActionListener(new NumberBtnClicked(nolTbl.getText()));

        percentTbl.addActionListener(new OperationBtnClicked(Operation.PERCENTAGE));
        multiplyTbl.addActionListener(new OperationBtnClicked(Operation.MULTIPLICATION));
        divideTbl.addActionListener(new OperationBtnClicked(Operation.DIVISION));
        minusTbl.addActionListener(new OperationBtnClicked(Operation.SUBTRACTION));
        plusTbl.addActionListener(new OperationBtnClicked(Operation.ADDITION));
        equalsTbl.addActionListener(new EqualsBtnClicked());
        deleteTbl.addActionListener(new ClearBtnClicked());
        plusminusTbl.addActionListener(new SignBtnClicked());
        comaTbl.addActionListener(new DigitBtnClicked());
    }

    public static void main(String[] args) {

        JFrame frame = new
                JFrame("calculator");
        frame.setContentPane(new calculator().dispCalc);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    private class NumberBtnClicked implements ActionListener {

        private String value;

        public NumberBtnClicked(String value) {
            this.value = value;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(operasiSatu == null || operasiSatu == 0.0) {
                value = outputTbl.getText() + value;
            }else{
                operasiDua = Double.valueOf(value);
            }
            outputTbl.setText(value);

        }
    }

    private class OperationBtnClicked implements ActionListener {

        private Operation operation;

        public OperationBtnClicked(Operation operation) {
            this.operation = operation;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            calcOperation = operation;
            operasiSatu = Double.valueOf(outputTbl.getText());
        }
    }

    private class ClearBtnClicked implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            outputTbl.setText("");
            operasiSatu = 0.0;
            operasiDua = 0.0;
        }
    }

    private class DigitBtnClicked implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            outputTbl.setText(outputTbl.getText() + ".");

        }
    }

    private class EqualsBtnClicked implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Double output = calcOperation.getOperator().applyAsDouble(operasiSatu, operasiDua);
            outputTbl.setText(output%1==0?String.valueOf(output.intValue()):String.valueOf(output));
            operasiSatu = 0.0;
            operasiDua = 0.0;
        }
    }

    private class SignBtnClicked implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            outputTbl.setText("-"+ outputTbl.getText());
        }
    }

}

