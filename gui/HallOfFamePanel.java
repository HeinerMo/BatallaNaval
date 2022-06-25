package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import util.Util;

public class HallOfFamePanel extends JPanel{
   
    private JButton jbtnJugar;
    private JTable jtRanking;
    private JLabel jlSalonFama;

    public HallOfFamePanel(ActionListener a) {
		super();
		this.setPreferredSize(new Dimension(Util.WIDTH, Util.HEIGHT));
		this.setLayout(null);
		this.initComponents(a);
		this.setBackground(new Color(27,138,150));
        this.setName("salonFamaPanel");
	}// constructor

    void initComponents(ActionListener a) {
        this.jlSalonFama=new JLabel("Ranking");  
        this.jlSalonFama.setBounds(370,50, 200,30); 
        this.jlSalonFama.setFont(new java.awt.Font("Tahoma", 0, 20));
        this.add(this.jlSalonFama);


        String data[][]={ {"Nombre","Puntaje"},
                          {"P1","1000"},    
                          {"P2","900"}, 
                          {"P3","800"}, 
                          {"P4","700"}, 
                          {"P5","600"}, 
                          {"P6","500"}, 
                          {"P7","400"}, 
                          {"P8","300"}, 
                          {"P9","200"}, 
                          {"P10","100"}};    

        String columns[] ={
                       "Id", "Name"};         
        this.jtRanking=new JTable(data,columns);    
        this.jtRanking.setFont(new java.awt.Font("Tahoma", 0, 15));
        this.jtRanking.setBackground(new Color(138,157,159));
        this.jtRanking.setBounds(200,100,400,200);  
        this.add(this.jtRanking);
    }// initLabels

}
