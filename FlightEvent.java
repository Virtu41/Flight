/**
 * The backend of the GUI Flight.java
 * 
 * modified     20220520
 * date         20220516
 * @filename    FlightEvent.java
 * @author      Oscar Lam
 * @version     1.0
 * @see         Unit 2 activity 7
 */

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class FlightEvent implements ActionListener {
	Flight gui;
	ArrayList<all>info = new ArrayList <all>();
	private String id, first, last, firstWeek, secondWeek, thirdWeek, fourthWeek;
	int MIN_POINT = 0, MAX_POINT = 1000000;
	int MAX_ID = 10000, MIN_ID = 1;
	int arraySize = 0;
	boolean addFunction = false, updateFunction = false;

	public FlightEvent(Flight in) {
		// TODO Auto-generated constructor stub
		gui = in;
	}

	public void actionPerformed (ActionEvent event) {
		String command = event.getActionCommand();
		if(command.equals("Add")) {
			add();
		} 
		if(command.equals("Remove")) {
			remove();
		} 
		if(command.equals("Update")) {
			update();
		}
		if(command.equals("Total Points")) {
			points();
		}
		if(command.equals("List")) { // although has auto list, if use total point, list will not appear until added or removed 
			list();
		}
	}
	
	void add() {
		try {
			all c;
			addFunction = true;
			
			first = gui.txtFirst.getText();
			last = gui.txtLast.getText();
			firstWeek = gui.txtOne.getText();
			secondWeek = gui.txtTwo.getText();
			thirdWeek = gui.txtThree.getText();
			fourthWeek = gui.txtFour.getText();
			id = gui.txtId.getText();

			if(!improperInput()) {
				c = new all(id,first,last,firstWeek,secondWeek,thirdWeek,fourthWeek);
				info.add(c);
				list();
				arraySize++;
				gui.txtSize.setText(arraySize+"");
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "There is a mistake in your input");
		}
	}
	
	void remove() {
		try {
			id = gui.txtId.getText();
			int idInt = Integer.parseInt(id);

			for(int i = 0; i<info.size();i++) {
				if(Integer.parseInt(info.get(i).id)==idInt) {
					info.remove(i);
					arraySize--;
					gui.txtSize.setText(arraySize+"");
					break;
				}
			}
			list();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Please input a proper ID#");
		}
	}
	
	void update() {
		try {
			all c;
			int idInt;
			updateFunction = true;
			
			first = gui.txtFirst.getText();
			last = gui.txtLast.getText();
			firstWeek = gui.txtOne.getText();
			secondWeek = gui.txtTwo.getText();
			thirdWeek = gui.txtThree.getText();
			fourthWeek = gui.txtFour.getText();
			id = gui.txtId.getText();

			idInt = Integer.parseInt(id);
			
			if(!improperInput()) {
				for(int i = 0; i<info.size();i++) {
					if(Integer.parseInt(info.get(i).id)==idInt) {
						c = new all(id,first,last,firstWeek,secondWeek,thirdWeek,fourthWeek);
						info.set(i,c);
						break;
					}
				}
				list();
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "There is a mistake in your input");
		}

	}
	
	void points() {
		int idInt,total,bonus = 0;
		id = gui.txtId.getText();
		
		idInt = Integer.parseInt(id);
		
		for(int i = 0; i<info.size();i++) {
			if(Integer.parseInt(info.get(i).id)==idInt) {
				total = Integer.parseInt(info.get(i).firstWeek)+Integer.parseInt(info.get(i).secondWeek)+Integer.parseInt(info.get(i).thirdWeek)+Integer.parseInt(info.get(i).fourthWeek);
				if(total> 5000) {
					bonus = 1000;
				}
				gui.taOutput.setText("");
				gui.taOutput.append(info.get(i).first+"'s Total Points are: "+total+" bonus: "+bonus+ "\n");
			}
		}
	}
	
	void list() {
		gui.taOutput.setText("");
		gui.taOutput.append("Format: ID#, first name, last name, first-fourth week \n");

		for(int i = 0; i<info.size();i++) {
			gui.taOutput.append("ID# "+info.get(i).id+", "+info.get(i).first+", "+info.get(i).last+", "+info.get(i).firstWeek+", "+info.get(i).secondWeek+", "+info.get(i).thirdWeek+", "+info.get(i).fourthWeek+"\n");
		}
	}
	
	boolean improperInput() {
		int idInt;
		boolean dataError = false;
		idInt = Integer.parseInt(id);

		String week[] = {firstWeek,secondWeek,thirdWeek,fourthWeek};

		if(addFunction) {
			for(int i = 0; i<info.size();i++) {
				if(Integer.parseInt(info.get(i).id)==idInt) {
					JOptionPane.showMessageDialog(null, "ID# exists");
					dataError = true;
				}
			}
		}
		
		if(idInt > MAX_ID || idInt < MIN_ID) {
			JOptionPane.showMessageDialog(null, "ID# size is 1-1000");
			dataError = true;
		}

		for(int i = 0; i<first.length();i++) {
			char ch;
			ch = first.charAt(i);
			if(ch < 65 || (ch > 90 && ch < 97)|| ch>122) {
				JOptionPane.showMessageDialog(null, "Please input a proper first name");
				dataError = true;
				break;
			}
		}

		for(int i = 0; i<last.length();i++) {
			char ch;
			ch = last.charAt(i);
			if(ch < 65 || (ch > 90 && ch < 97)|| ch>122) {
				JOptionPane.showMessageDialog(null, "Please input a proper last name");
				dataError = true;
				break;
			}
		}

		for(int i = 0; i<week.length;i++) {
			if(Integer.parseInt(week[i])<MIN_POINT || Integer.parseInt(week[i])>MAX_POINT) {
				JOptionPane.showMessageDialog(null, "Points must be 0 or positive number. Max points per week is 1000000");
				dataError = true;
			}
		}
		addFunction = false;
		updateFunction = false;
		return dataError;
	}
	
	class all{
		String id, first, last, firstWeek, secondWeek, thirdWeek, fourthWeek;
		all(String _id, String _first, String _last, String _firstWeek, String _secondWeek, String _thirdWeek, String _fourthWeek){
			id = _id;
			first = _first;
			last = _last;
			firstWeek = _firstWeek;
			secondWeek = _secondWeek;
			thirdWeek = _thirdWeek;
			fourthWeek = _fourthWeek;
		}
	}
}