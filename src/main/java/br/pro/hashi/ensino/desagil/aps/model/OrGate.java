package br.pro.hashi.ensino.desagil.aps.model;

public class OrGate extends Gate {
<<<<<<< HEAD

    private final NandGate nand1, nand2, nand3;
=======
    private final NandGate nandTop;
    private final NandGate nandBottom;
    private final NandGate nandRight;
>>>>>>> 99e9111408edd710ad810ac9abd8fee66cb72796

    public OrGate() {
        super("OR", 2);

<<<<<<< HEAD
        nand1 = new NandGate();
        nand2 = new NandGate();
        nand3 = new NandGate();
    }

    public boolean read() {
        return nand3.read();
=======
        nandTop = new NandGate();

        nandBottom = new NandGate();

        nandRight = new NandGate();
        nandRight.connect(0, nandTop);
        nandRight.connect(1, nandBottom);
    }

    @Override
    public boolean read() {
        return nandRight.read();
>>>>>>> 99e9111408edd710ad810ac9abd8fee66cb72796
    }

    @Override
    public void connect(int inputIndex, Emitter emitter) {
<<<<<<< HEAD
        if (inputIndex < 0 || inputIndex > 1) {
            throw new IndexOutOfBoundsException(inputIndex);
        }
        if (inputIndex == 0) {
            nand1.connect(0, emitter);
            nand1.connect(1, emitter);

        }
        if (inputIndex == 1) {
            nand2.connect(0, emitter);
            nand2.connect(1, emitter);

        }

        nand3.connect(0, nand1);
        nand3.connect(1, nand2);


=======
        switch (inputIndex) {
            case 0:
                nandTop.connect(0, emitter);
                nandTop.connect(1, emitter);
                break;
            case 1:
                nandBottom.connect(0, emitter);
                nandBottom.connect(1, emitter);
                break;
            default:
                throw new IndexOutOfBoundsException(inputIndex);
        }
>>>>>>> 99e9111408edd710ad810ac9abd8fee66cb72796
    }
}
