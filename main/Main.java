package main;

import gui.Window;
import util.Util;

import java.math.BigInteger;
import java.util.ArrayList;

import javax.swing.JFrame;

import data.DataManager;
import data.PersonData;
import engine.InputHandler;

public class Main {

	public static void main(String[] args) {
		//Util.loadImages();
		//Window window = new Window();
		DataManager.getInstance().addToRanking("Heiner", 400f);

		ArrayList<PersonData> temp = DataManager.getInstance().getRankings();

		for (PersonData p: temp) {
			System.out.println(p.getName() + " " + p.getTime());
		}
	}

	
}