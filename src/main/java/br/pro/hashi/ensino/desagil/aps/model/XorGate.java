package br.pro.hashi.ensino.desagil.aps.model;

public class XorGate extends Gate {
<<<<<<< HEAD

    private final NandGate nand1, nand2, nand3, nand4;
=======
    private final NandGate nandLeft;
    private final NandGate nandTop;
    private final NandGate nandBottom;
    private final NandGate nandRight;
>>>>>>> 99e9111408edd710ad810ac9abd8fee66cb72796

    public XorGate() {
        super("XOR", 2);

<<<<<<< HEAD
        nand1 = new NandGate();
        nand2 = new NandGate();
        nand3 = new NandGate();
        nand4 = new NandGate();
    }

    public boolean read() {
        return nand4.read();
    }


    @Override
    public void connect(int inputIndex, Emitter emitter) {
        if (inputIndex < 0 || inputIndex > 1) {
            throw new IndexOutOfBoundsException(inputIndex);
        }


        if (inputIndex == 0) {
            nand1.connect(0, emitter);
            nand2.connect(0, emitter);
        }
        if (inputIndex == 1) {
            nand1.connect(1, emitter);
            nand3.connect(1, emitter);
        }

        nand2.connect(1, nand1);

        nand3.connect(0, nand1);

        nand4.connect(0, nand2);
        nand4.connect(1, nand3);
    }

=======
        nandLeft = new NandGate();

        nandTop = new NandGate();
        nandTop.connect(1, nandLeft);

        nandBottom = new NandGate();
        nandBottom.connect(0, nandLeft);

        nandRight = new NandGate();
        nandRight.connect(0, nandTop);
        nandRight.connect(1, nandBottom);
    }

    @Override
    public boolean read() {
        return nandRight.read();
    }

    @Override
    public void connect(int inputIndex, Emitter emitter) {
        switch (inputIndex) {
            case 0:
                nandTop.connect(0, emitter);
                nandLeft.connect(0, emitter);
                break;
            case 1:
                nandLeft.connect(1, emitter);
                nandBottom.connect(1, emitter);
                break;
            default:
                throw new IndexOutOfBoundsException(inputIndex);
        }
    }
>>>>>>> 99e9111408edd710ad810ac9abd8fee66cb72796
}
