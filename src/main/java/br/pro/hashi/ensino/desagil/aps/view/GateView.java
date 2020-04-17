package br.pro.hashi.ensino.desagil.aps.view;

import br.pro.hashi.ensino.desagil.aps.model.Gate;
import br.pro.hashi.ensino.desagil.aps.model.Switch;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

public class GateView extends FixedPanel implements ItemListener {
    private final Gate gate;
    private final JCheckBox entrada1;
    private final JCheckBox entrada2;
    private final JCheckBox saida;

    private final Switch entradaSwitch1;
    private final Switch entradaSwitch2;


    public GateView(Gate gate) {
        super(250, 250);
        this.gate = gate;

        entrada1 = new JCheckBox();
        entrada1.setMnemonic(KeyEvent.VK_G);
        entrada1.setSelected(false);

        entrada2 = new JCheckBox();
        entrada2.setMnemonic(KeyEvent.VK_G);
        entrada2.setSelected(false);

        saida = new JCheckBox();
        saida.setMnemonic(KeyEvent.VK_G);
        saida.setSelected(false);

        JLabel entradaLabel = new JLabel("Entrada");
        JLabel saidaLabel = new JLabel("Saida");

        entradaSwitch1 = new Switch();
        entradaSwitch2 = new Switch();

        add(entradaLabel, 10, 10, 75, 25);
        add(entrada1, 85, 10, 150, 25);
        add(entrada2, 85, 45, 150, 25);
        add(saidaLabel, 10, 80, 75, 25);
        add(saida, 85, 80, 120, 25);


//        String name = gate.toString() + ".png";
//        URL url = getClass().getClassLoader().getResource(name);
//        image = getToolkit().getImage(url);

        if (gate.toString().equals("NOT")) {
            gate.connect(0, entradaSwitch1);
            entrada2.setEnabled(false);
            remove(entrada2);
        } else {
            gate.connect(0, entradaSwitch1);
            gate.connect(1, entradaSwitch2);
        }

        entrada1.addItemListener(this);
        entrada2.addItemListener(this);

        saida.setEnabled(false);
        //addMouseListener(this);

        update();
    }

    private void update() {
        boolean resposta1;
        boolean resposta2;

        resposta1 = entrada1.isSelected();
        resposta2 = entrada2.isSelected();

        if (resposta1 && resposta2) {
            entradaSwitch1.turnOn();
            entradaSwitch2.turnOn();
        } else if (resposta2) {
            entradaSwitch1.turnOff();
            entradaSwitch2.turnOn();
        } else if (resposta1) {
            entradaSwitch1.turnOn();
            entradaSwitch2.turnOff();
        } else {
            entradaSwitch1.turnOff();
            entradaSwitch2.turnOff();
        }

        saida.setSelected(this.gate.read());
    }

    public void itemStateChanged(ItemEvent itemEvent) {
        update();
    }


}