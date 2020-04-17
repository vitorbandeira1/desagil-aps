package br.pro.hashi.ensino.desagil.aps.model;

public class AndGate extends Gate {
<<<<<<< HEAD

    private final NandGate nand1, nand2;
=======
    private final NandGate nandLeft;
    private final NandGate nandRight;
>>>>>>> 99e9111408edd710ad810ac9abd8fee66cb72796

    public AndGate() {
        super("AND", 2);

<<<<<<< HEAD
        nand1 = new NandGate();
        nand2 = new NandGate();
    }

    public boolean read() {
        return nand2.read();
=======
        nandLeft = new NandGate();

        nandRight = new NandGate();
        nandRight.connect(0, nandLeft);
        nandRight.connect(1, nandLeft);
    }

    @Override
    public boolean read() {
        return nandRight.read();
>>>>>>> 99e9111408edd710ad810ac9abd8fee66cb72796
    }

    @Override
    public void connect(int inputIndex, Emitter emitter) {
        if (inputIndex < 0 || inputIndex > 1) {
            throw new IndexOutOfBoundsException(inputIndex);
        }
<<<<<<< HEAD

        if (inputIndex == 0) {
            nand1.connect(0, emitter);
        }
        if (inputIndex == 1) {
            nand1.connect(1, emitter);
        }

        nand2.connect(0, nand1);
        nand2.connect(1, nand1);

    }
}

=======
        nandLeft.connect(inputIndex, emitter);
    }
}
>>>>>>> 99e9111408edd710ad810ac9abd8fee66cb72796
