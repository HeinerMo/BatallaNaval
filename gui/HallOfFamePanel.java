package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.imageio.ImageIO;


import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.*;
import util.Util;

public class HallOfFamePanel extends JPanel{
   
    private JTable jtRanking;
    private JLabel jlSalonFama;
    private BufferedImage buffWinner;
    private Image imageWinner;
    private JLabel jlWinner;

    public HallOfFamePanel(ActionListener a) {
		super();
		this.setPreferredSize(new Dimension(Util.WIDTH, Util.HEIGHT));
		this.setLayout(null);
		this.initComponents(a);
        this.setBackground(new Color(0x007b00) );
        this.setName("salonFamaPanel");
	}// constructor

    void initComponents(ActionListener a) {
        this.jlSalonFama=new JLabel("Ranking");  
        this.jlSalonFama.setBounds(440,50, 200,30); 
        this.jlSalonFama.setFont(new java.awt.Font("Tahoma", 1, 30));
        this.jlSalonFama.setForeground(Color.WHITE);
        this.add(this.jlSalonFama);


        String[][] rec = {
            { "Ranking", "Jugador","Tiempo"},
            { "", "", ""},
            { "1", "Steve", ""},
            { "", "", ""},
            { "2", "Virat", ""},
            { "", "", ""},
            { "3", "Kane", ""},
            { "", "", ""},
            { "4", "David", ""},
            { "", "", ""},
            { "5", "Ben", ""},
            { "", "", ""},
            { "6", "Eion", ""},
            { "", "", ""},
            { "7", "Kane", ""},
            { "", "", ""},
            { "8", "David", ""},
            { "", "", ""},
            { "9", "Ben", ""},
            { "", "", ""},
            { "10", "Eion", ""},
         };
        String[] header = { "Ranking", "Jugador","Tiempo"};
        this.jtRanking = new JTable(rec, header);    
        this.jtRanking.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.jtRanking.setBounds(370,150,250,350);  
        this.jtRanking.setForeground(Color.WHITE);
        this.jtRanking.setBackground(new Color(0x007b00) );
        this.jtRanking.setGridColor(new Color(0x007b00) );
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        this.jtRanking.getColumnModel().getColumn(0).setCellRenderer(tcr);
        this.jtRanking.getColumnModel().getColumn(1).setCellRenderer(tcr);
        this.jtRanking.getColumnModel().getColumn(2).setCellRenderer(tcr);
        this.add(this.jtRanking);

        this.jlWinner = new JLabel();
		this.jlWinner.setBounds(340, 65, 200, 250);
		try {
            this.buffWinner=ImageIO.read(getClass().getResourceAsStream("/resources/imgs/winner.png"));
            this.imageWinner = this.buffWinner.getScaledInstance(30, 30, this.imageWinner.SCALE_DEFAULT);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		this.jlWinner.setIcon(new ImageIcon(this.imageWinner));
		this.add(this.jlWinner);
    }// initLabels

}
